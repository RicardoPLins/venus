package br.edu.ifpb.pweb2.venus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.venus.model.Professor;
import br.edu.ifpb.pweb2.venus.service.ProfessorService;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
    
    @Autowired
    private ProfessorService professorService;

    @RequestMapping("/form")
    public ModelAndView getForm(ModelAndView modelAndView){
        modelAndView.setViewName("professores/form");
        modelAndView.addObject("professor", new Professor());
        return modelAndView;
    }

    @GetMapping
    public ModelAndView listAll(ModelAndView modelAndView){
        modelAndView.setViewName("professor/list");
        modelAndView.addObject("professor", professorService.findAll());
        return modelAndView;
    }
    @RequestMapping("/{id}/delete")
    public ModelAndView deleteById(@PathVariable(value = "id") Integer id, 
        ModelAndView mav, RedirectAttributes attr) {
        professorService.deleteById(id);
        attr.addFlashAttribute("mensagem", "Professor removido com sucesso!");
        mav.setViewName("redirect:/professores");
        return mav;
    }


}
