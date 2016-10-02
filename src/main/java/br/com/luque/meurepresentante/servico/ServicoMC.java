package br.com.luque.meurepresentante.servico;

import br.com.luque.meurepresentante.dominio.Politico;
import br.com.luque.meurepresentante.dominio.Projeto;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author leand
 */
public interface ServicoMC {

    void carregarVereadores() throws IOException;
    
    void carregarProjetos() throws IOException;
    
    List<Politico> listarVereadores();

    void inserirPoliticos(List<Politico> politicos);
    void inserirProjetos(List<Projeto> projetos);
    
    List<Projeto> procurarProjetos();
    
}
