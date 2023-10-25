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

import br.edu.ifpb.pweb2.venus.model.Aluno;
import br.edu.ifpb.pweb2.venus.model.Professor;
import br.edu.ifpb.pweb2.venus.service.AdminService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @GetMapping("/alunos")
    public ModelAndView getAlunos(ModelAndView mav) {
        mav.setViewName("admin/listAluno");
        mav.addObject("alunos", adminService.listAluno());
        return mav;
    }

    @GetMapping("/alunos/cadastro")
    public ModelAndView getCadastroAluno(ModelAndView mav) {
        mav.setViewName("admin/formAluno");
        mav.addObject("aluno", new Aluno());
        return mav;
    }

    @PostMapping("/alunos")
    public ModelAndView saveAluno(@Valid Aluno aluno, BindingResult result, ModelAndView mav) {
        if (result.hasErrors()){
            mav.setViewName("admin/formAluno");
            mav.addObject("aluno", aluno);
            return mav;
        }
        adminService.saveAluno(aluno);
        mav.setViewName("redirect:/admin/alunos");
        mav.addObject("alunos", adminService.listAluno());
        return mav;
    }

    @GetMapping("/alunos/{id}")
    public ModelAndView editAluno(@PathVariable(value = "id") Integer id, ModelAndView mav) {
        mav.setViewName("admin/formAluno");
        mav.addObject("aluno", adminService.getAluno(id));
        return mav;
    }

    @DeleteMapping("/alunos/{id}")
    public ModelAndView deleteAluno(@PathVariable(value = "id") Integer id, ModelAndView mav) {
        adminService.removerAluno(id);
        mav.setViewName("redirect:/admin/alunos");
        mav.addObject("alunos", adminService.listAluno());
        return mav;
    }

    @GetMapping("/professores")
    public ModelAndView getProfessores(ModelAndView mav) {
        mav.setViewName("admin/listProfessor");
        mav.addObject("professores", adminService.listarProfessores());
        return mav;
    }

    @GetMapping("/professores/cadastro")
    public ModelAndView getCadastroProfessor(ModelAndView mav) {
        mav.setViewName("admin/formProfessor");
        mav.addObject("professor", new Professor());
        return mav;
    }

    @PostMapping("/professores")
    public ModelAndView saveProfessor(@Valid Professor professor, BindingResult result, ModelAndView mav) {
        if (result.hasErrors()){
            mav.setViewName("admin/formProfessor");
            mav.addObject("professor", professor);
            return mav;
        }
        adminService.salvarProfessor(professor);
        mav.setViewName("redirect:/admin/professores");
        mav.addObject("professores", adminService.listarProfessores());
        return mav;
    }

    @GetMapping("/professores/{id}")
    public ModelAndView editProfessor(@PathVariable(value = "id") Integer id, ModelAndView mav) {
        mav.setViewName("admin/formProfessor");
        mav.addObject("professor", adminService.getProfessor(id));
        return mav;
    }

    @DeleteMapping("/professores/{id}")
    public ModelAndView deleteProfessor(@PathVariable(value = "id") Integer id, ModelAndView mav) {
        adminService.removerProfessor(id);
        mav.setViewName("redirect:/admin/professores");
        mav.addObject("professores", adminService.listarProfessores());
        return mav;
    }

    }
