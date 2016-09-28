package br.com.luque.meurepresentante.servico;

import br.com.luque.meurepresentante.dominio.Funcao;
import br.com.luque.meurepresentante.dominio.Imagem;
import br.com.luque.meurepresentante.dominio.Politico;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CarregadorDadosMC {
    public List<Politico> carregarPoliticos() throws IOException {
        String url = "http://www.cmmc.sp.gov.br/vereadores";
        Document document = Jsoup.connect((String)url).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
        ArrayList<Politico> vereadores = new ArrayList<Politico>();
        Elements fotos = document.getElementsByAttributeValueContaining("src", "fotos");
        for (int i = 0; i < fotos.size(); ++i) {
            Element foto = (Element)fotos.get(i);
            Element thSeguinte = foto.parent().nextElementSibling();
            Elements nomeETelefone = thSeguinte.getElementsByTag("p");
            String siglaPartido = thSeguinte.getElementsByTag("img").attr("src");
            siglaPartido = siglaPartido.substring(siglaPartido.lastIndexOf("/") + 1);
            siglaPartido = siglaPartido.replace(".jpg", "").toUpperCase();
            String email = String.valueOf(((Element)document.getElementsByAttributeValueContaining("href", "mailto").get(i)).attr("href"));
            email = email.replace("mailto:", "");
            Politico vereador = new Politico();
            vereador.setNome(((Element)nomeETelefone.get(0)).text().trim());
            vereador.setTelefone(((Element)nomeETelefone.get(1)).getElementsByTag("span").text().trim());
            vereador.setEmail(email.trim());
            vereador.setPartidoAtual(siglaPartido.trim());
            vereador.setFuncaoAtual(Funcao.VEREADOR);
            vereador.setFoto(new Imagem(foto.attr("src").trim()));
            vereadores.add(vereador);
        }
        return vereadores;
    }

    public void carregarTodosProjetos() throws IOException {
        String[] urlsProjetos;
        for (String url : urlsProjetos = new String[]{"http://www.cmmc.sp.gov.br/projetos/plo.php", "http://www.cmmc.sp.gov.br/projetos/plc.php", "http://www.cmmc.sp.gov.br/projetos/pelo.php", "http://www.cmmc.sp.gov.br/projetos/pdl.php", "http://www.cmmc.sp.gov.br/projetos/pr.php"}) {
            Document document = Jsoup.connect((String)url).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
            Elements projetos = document.select(".tabelaPadrao tr");
            StringBuilder retorno = new StringBuilder();
            for (Element projeto : projetos) {
                retorno.append("Projeto: " + projeto.text());
            }
        }
    }
}