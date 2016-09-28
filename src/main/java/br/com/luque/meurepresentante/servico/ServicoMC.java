package br.com.luque.meurepresentante.servico;

import br.com.luque.meurepresentante.dominio.Politico;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author leand
 */
public interface ServicoMC {

    void carregarVereadores() throws IOException;

    void inserir(List<Politico> politicos);
    
}
