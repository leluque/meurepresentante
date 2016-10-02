package br.com.luque.meurepresentante.servico.web;

import br.com.luque.meurepresentante.dominio.Projeto;
import br.com.luque.meurepresentante.servico.ServicoMC;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 */
@Controller
public class CidadaoController {

    @Autowired
    private ServicoMC servicoMC;

    @RequestMapping("/index2")
    public ModelAndView procurarProjetos() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Projeto> projetos = servicoMC.procurarProjetos();
        System.out.println(projetos.size());
        modelAndView.addObject("projetos", projetos);
        return modelAndView;
    }

}
