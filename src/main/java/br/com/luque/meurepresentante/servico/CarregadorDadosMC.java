package br.com.luque.meurepresentante.servico;

import br.com.luque.meurepresentante.dominio.Funcao;
import br.com.luque.meurepresentante.dominio.Imagem;
import br.com.luque.meurepresentante.dominio.Politico;
import br.com.luque.meurepresentante.dominio.Projeto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Esta classe carrega dados sobre os vereadores e os projetos da cidade de Mogi
 * das Cruzes.
 *
 * @author Leandro Luque
 */
public class CarregadorDadosMC implements CarregadorDadosMunicipais {

    public static final String ESTADO = "SP";
    public static final String MUNICIPIO = "Mogi das Cruzes";

    @Override
    public Politico carregarPrefeito() throws IOException {
        // ToDo: Recuperar dados do prefeito de algum lugar.
        throw new UnsupportedOperationException("Metodo nao implementado ainda.");
    }

    @Override
    public List<Politico> carregarVereadores() throws IOException {
        String url = "http://www.cmmc.sp.gov.br/vereadores";
        Document documento = Jsoup.connect(url).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
        ArrayList<Politico> vereadores = new ArrayList();
        Elements fotos = documento.getElementsByAttributeValueContaining("src", "fotos");
        for (int i = 0; i < fotos.size(); ++i) {
            Element foto = (Element) fotos.get(i);
            Element thSeguinte = foto.parent().nextElementSibling();
            Elements nomeETelefone = thSeguinte.getElementsByTag("p");
            String siglaPartido = thSeguinte.getElementsByTag("img").attr("src");
            siglaPartido = siglaPartido.substring(siglaPartido.lastIndexOf("/") + 1);
            siglaPartido = siglaPartido.replace(".jpg", "").toUpperCase();
            String email = String.valueOf(((Element) documento.getElementsByAttributeValueContaining("href", "mailto").get(i)).attr("href"));
            email = email.replace("mailto:", "");
            Politico vereador = new Politico();
            vereador.setNome(((Element) nomeETelefone.get(0)).text().trim());
            vereador.setTelefone(((Element) nomeETelefone.get(1)).getElementsByTag("span").text().trim());
            vereador.setEmail(email.trim());
            vereador.setPartidoAtual(siglaPartido.trim());
            vereador.setFuncaoAtual(Funcao.VEREADOR);
            vereador.setFoto(new Imagem(foto.attr("src").trim()));
            vereador.setMunicipio(MUNICIPIO);
            vereador.setEstado(ESTADO);
            vereadores.add(vereador);
        }
        return vereadores;
    }

    @Override
    public List<Projeto> carregarProjetos(List<Politico> vereadores) throws IOException {
        List<Projeto> projetos = new ArrayList();
        // Carrega os vereadores da cidade em um mapa (para otimizar o
        // processo e nao ter que requisitar o banco de dados varias vezes).
        Map<String, Politico> mapaVereadores = new HashMap();
        for (Politico vereador : vereadores) {
            mapaVereadores.put(vereador.getNome(), vereador);
        }

        for (String urlBase : new String[]{"http://www.cmmc.sp.gov.br/projetos/plo.php",
            "http://www.cmmc.sp.gov.br/projetos/plc.php",
            "http://www.cmmc.sp.gov.br/projetos/plo.php",
            "http://www.cmmc.sp.gov.br/projetos/pelo.php",
            "http://www.cmmc.sp.gov.br/projetos/pdl.php",
            "http://www.cmmc.sp.gov.br/projetos/pr.php"}) {

            Stack<String> paginas = new Stack();
            paginas.push(urlBase);
            while (!paginas.isEmpty()) {
                String urlPagina = paginas.pop();
                Document documento = Jsoup.connect(urlPagina).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
                projetos.addAll(carregarProjetos(documento, mapaVereadores));
                // Verifica se a pagina contem um link para proximas paginas.
                Elements links = documento.getElementsContainingText("próximo");
                for (Element link : links) {
                    if (link.tagName().equals("b")) {
                        String linkParaProximaPagina = urlBase + link.parent().attr("href");
                        System.out.println("---- Link para o proximo: " + linkParaProximaPagina);
                        paginas.push(linkParaProximaPagina);
                    }
                }
            }

        }
        return projetos;
    }

    /**
     * Carrega os projetos encontrados em uma pagina especifica.
     *
     * @param mapa Mapa de vereadores da cidade (nome -> vereador).
     * @param documento O documento que representa a pagina.
     * @return A lista de projetos da pagina.
     * @throws IOException Caso ocorra algum erro no carregamento.
     */
    private List<Projeto> carregarProjetos(Document documento, Map<String, Politico> mapaVereadores) throws IOException {
        List<Projeto> projetos = new ArrayList();
        // Procura pela tabela com os dados dos projetos.
        Elements tabelaProjetos = documento.select(".tabelaPadrao tr");
        // Descarta a primeira linha (cabecalho).
        for (int i = 1; i < tabelaProjetos.size(); i++) {
            Element linhaTabela = tabelaProjetos.get(i);
            // Recupera os dados do projeto.
            Elements links = linhaTabela.getElementsByTag("a");

            String numero = links.get(0).text();
            String textoAutores = links.get(1).text();
            String assunto = links.get(2).text();
            String situacao = links.get(3).text();

            // Preenche os dados do projeto.
            Projeto projeto = new Projeto();

            // Encontra os vereadores que propuseram o projeto.
            // ToDo: Carregar mesas diretivas por gestao (nao e possivel
            // definir quais vereadores propuseram o projeto sem saber quais
            // deles compuseram a mesa diretiva no momento para proposta
            // do projeto.
            // ToDo: Carregar projetos propostos pelo prefeito.
            if (!textoAutores.trim().isEmpty()
                    && !textoAutores.contains("MESA DIRETIVA")
                    && !textoAutores.contains("PREFEITO")) {
                String[] textosAutores = textoAutores.split(",");
                List<String> nomesAutores = new ArrayList();
                nomesAutores.addAll(Arrays.asList(textosAutores));
                if (nomesAutores.size() > 1) {
                    String ultimoNome = nomesAutores.get(nomesAutores.size() - 1);
                    // Remove o ultimo nome.
                    nomesAutores.remove(nomesAutores.size() - 1);
                    // Separa o ultimo nome pelo " E " e adiciona os dois nomes
                    // separados.
                    String[] ultimosNomes = ultimoNome.split(" E ");
                    nomesAutores.addAll(Arrays.asList(ultimosNomes));
                }

                List<Politico> autores = new ArrayList();
                for (String nomeAutor : nomesAutores) {
                    Politico autor = mapaVereadores.get(nomeAutor);
                    if (autor == null) {
                        // Cria um novo vereador com o nome especificado.
                        autor = new Politico();
                        autor.setNome(nomeAutor.trim());
                        autor.setMunicipio(MUNICIPIO);
                        autor.setEstado(ESTADO);
                        autor.setFuncaoAtual(Funcao.VEREADOR);
                        autor.addProjeto(projeto);
                        autor.setNovo(true);
                        mapaVereadores.put(autor.getNome(), autor);
                    }
                    autores.add(autor);
                }
                projeto.setAutores(autores);
            }

            projeto.setNumero(numero);
            projeto.setAssunto(assunto);
            // ToDo: recuperar ano e status.
            projetos.add(projeto);
        }
        return projetos;
    }

}
