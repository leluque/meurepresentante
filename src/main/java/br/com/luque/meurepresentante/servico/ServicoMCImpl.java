package br.com.luque.meurepresentante.servico;

import br.com.luque.meurepresentante.dominio.Politico;
import br.com.luque.meurepresentante.dominio.Projeto;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.luque.meurepresentante.persistencia.PoliticoRepository;
import br.com.luque.meurepresentante.persistencia.ProjetoRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

/**
 * Esta classe implementa servicos para a cidade de Mogi das Cruzes.
 *
 * @author Leandro Luque
 */
@Component
@Transactional
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
        List<Politico> vereadores = politicoDAO.findByMunicipioAndEstado(CarregadorDadosMC.MUNICIPIO, CarregadorDadosMC.ESTADO);
        List<Projeto> projetos = carregarDadosMogiDasCruzes.carregarProjetos(vereadores);
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
        // Procura pelos vereadores do projeto e os atualiza caso eles ja
        // existam.
        projetoDAO.save(projetos);
    }

    @Override
    public List<Projeto> procurarProjetos() {
        return projetoDAO.findByAssuntoContaining("Denominação");
    }

}
