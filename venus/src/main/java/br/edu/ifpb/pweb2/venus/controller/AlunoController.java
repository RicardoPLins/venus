package br.edu.ifpb.pweb2.venus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.pweb2.venus.model.Processo;
import br.edu.ifpb.pweb2.venus.service.AlunoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;

    @GetMapping("/processos")
    public ModelAndView getAlunos(ModelAndView mav) {
        mav.setViewName("alunos/listProcesso");
        mav.addObject("alunos", alunoService.listProcesso());
        return mav;
    }

    @GetMapping("/processos/cadastro")
    public ModelAndView getCadastroAluno(ModelAndView mav) {
        mav.setViewName("alunos/formProcesso");
        mav.addObject("processo", new Processo());
        return mav;
    }

    @PostMapping("/processos")
    public ModelAndView saveAluno(@Valid Processo processo, BindingResult result, ModelAndView mav) {
        if (result.hasErrors()) {
            mav.setViewName("alunos/formProcesso");
            mav.addObject("processo", processo);
            return mav;
        }
        alunoService.saveProceso(processo);
        mav.setViewName("redirect:/alunos/processos");
        mav.addObject("processos", alunoService.listProcesso());
        return mav;
    }

    @GetMapping("/processos/{id}")
    public ModelAndView editAluno(@PathVariable(value = "id") Integer id, ModelAndView mav) {
        mav.setViewName("alunos/formProcesso");
        mav.addObject("processo", alunoService.getProcesso(id));
        return mav;
    }

    @DeleteMapping("/processos/{id}")
    public ModelAndView deleteAluno(@PathVariable(value = "id") Integer id, ModelAndView mav) {
        alunoService.removerProcesso(id);
        mav.setViewName("redirect:/alunos/processos");
        mav.addObject("processos", alunoService.listProcesso());
        return mav;
    }

}
