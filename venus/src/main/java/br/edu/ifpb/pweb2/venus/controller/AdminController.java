package br.edu.ifpb.pweb2.venus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.pweb2.venus.model.Aluno;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @RequestMapping("/formAluno")
    public ModelAndView getForm(ModelAndView modelAndView){
        modelAndView.setViewName("admin/formAluno");
        modelAndView.addObject("aluno", new Aluno());
        return modelAndView;
        
    }
    

}
