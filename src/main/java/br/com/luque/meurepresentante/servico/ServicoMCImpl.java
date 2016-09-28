package br.com.luque.meurepresentante.servico;

import br.com.luque.meurepresentante.dominio.Politico;
import br.com.luque.meurepresentante.dominio.Projeto;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.luque.meurepresentante.persistencia.PoliticoRepository;
import br.com.luque.meurepresentante.persistencia.ProjetoRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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

    @Autowired
    private ProjetoRepository projetoDAO;

    @Override
    public void carregarVereadores() throws IOException {
        CarregadorDadosMC carregarDadosMogiDasCruzes = new CarregadorDadosMC();
        inserirPoliticos(carregarDadosMogiDasCruzes.carregarVereadores());
    }

    @Override
    public void carregarProjetos() throws IOException {
        CarregadorDadosMC carregarDadosMogiDasCruzes = new CarregadorDadosMC();
        List<Projeto> projetos = carregarDadosMogiDasCruzes.carregarProjetos(politicoDAO.findByMunicipioAndEstado(CarregadorDadosMC.MUNICIPIO, CarregadorDadosMC.ESTADO));
      inserirProjetos(projetos);
    }

    @Override
    public List<Politico> listarVereadores() {
        return politicoDAO.findByMunicipioAndEstado(CarregadorDadosMC.MUNICIPIO, CarregadorDadosMC.ESTADO);
    }

    @Override
    public void inserirPoliticos(List<Politico> politicos) {
        politicoDAO.save(politicos);
    }

    @Override
    public void inserirProjetos(List<Projeto> projetos) {
        projetoDAO.save(projetos);
    }

}
