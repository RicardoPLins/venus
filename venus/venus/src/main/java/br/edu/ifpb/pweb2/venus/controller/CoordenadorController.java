package br.edu.ifpb.pweb2.venus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.venus.model.Professor;
import br.edu.ifpb.pweb2.venus.service.CoordenadorService;

@Controller
@RequestMapping("/coordenadores")
public class CoordenadorController {

    @Autowired
    private CoordenadorService coordenadorService;

    @RequestMapping("/form")
    public ModelAndView getForm(ModelAndView modelAndView){
        modelAndView.setViewName("coordenadores/form");
        modelAndView.addObject("coordenador", new Professor());
        return modelAndView;
    }

    @GetMapping
    public ModelAndView listAll(ModelAndView modelAndView){
        modelAndView.setViewName("coordenadores/list");
        modelAndView.addObject("coordenadores", coordenadorService.findAll());
        return modelAndView;
    }
    @RequestMapping("/{id}/delete")
    public ModelAndView deleteById(@PathVariable(value = "id") Integer id, 
        ModelAndView mav, RedirectAttributes attr) {
        coordenadorService.deleteById(id);
        attr.addFlashAttribute("mensagem", "Coordenador removido com sucesso!");
        mav.setViewName("redirect:/coordenadores");
        return mav;
    }
}
