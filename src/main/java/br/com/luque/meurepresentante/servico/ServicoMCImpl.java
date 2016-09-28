package br.com.luque.meurepresentante.servico;

import br.com.luque.meurepresentante.dominio.Politico;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.luque.meurepresentante.persistencia.PoliticoRepository;
import org.springframework.stereotype.Component;

/**
 * Esta classe implementa servicos para a cidade de Mogi das Cruzes.
 *
 * @author Leandro Luque
 */
@Component
public class ServicoMCImpl implements ServicoMC {

    @Autowired
    private PoliticoRepository politicoDAO;

    @Override
    public void carregarVereadores() throws IOException {
        CarregadorDadosMC carregarDadosMogiDasCruzes = new CarregadorDadosMC();
        inserir(carregarDadosMogiDasCruzes.carregarPoliticos());
    }

    @Override
    public void inserir(List<Politico> politicos) {
        politicoDAO.save(politicos);
    }

}
