package br.com.luque.meurepresentante.servico;

import br.com.luque.meurepresentante.dominio.Politico;
import br.com.luque.meurepresentante.dominio.Projeto;
import java.io.IOException;
import java.util.List;

/**
 * Esta interface define o comportamento comum a carregadores de dados
 * municipais.
 *
 * @author Leandro Luque
 */
public interface CarregadorDadosMunicipais {

    /**
     * Carrega os dados do prefeito de algum municipio.
     *
     * @return O prefeito.
     * @throws IOException Caso ocorra algum erro no carregamento.
     */
    Politico carregarPrefeito() throws IOException;

    /**
     * Carrega os projetos propostos/votados na Camara dos Vereadores de algum
     * municipio.
     *
     * @param politicos Lista de politicos do municipio.
     * @return Lista de projetos propostos/votados.
     * @throws IOException Caso ocorra algum erro no carregamento.
     */
    List<Projeto> carregarProjetos(List<Politico> politicos) throws IOException;

    /**
     * Carrega os dados dos atuais vereadores de algum municipio.
     *
     * @return Uma lista de vereadores.
     * @throws IOException Caso ocorra algum erro no carregamento.
     */
    List<Politico> carregarVereadores() throws IOException;

}
