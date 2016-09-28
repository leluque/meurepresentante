package br.com.luque.meurepresentante.servico.web;

import br.com.luque.meurepresentante.servico.ServicoMC;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 */
@Controller
public class AdministradorController {

    @Autowired
    private ServicoMC servicoMC;

    @RequestMapping("/carregarPoliticosMC")
    public String carregarVereadores() {
        try {
            servicoMC.carregarVereadores();
        } catch (IOException erro) {
            erro.printStackTrace();
        }
        return "index";
    }

    @RequestMapping("/carregarProjetosMC")
    public String carregarProjetos() {
        try {
            servicoMC.carregarProjetos();
        } catch (IOException erro) {
            erro.printStackTrace();
        }
        return "index";
    }

}
