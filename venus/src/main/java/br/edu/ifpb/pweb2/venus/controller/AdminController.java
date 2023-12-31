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
import br.edu.ifpb.pweb2.venus.model.Assunto;
import br.edu.ifpb.pweb2.venus.model.Colegiado;
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

    @GetMapping("/colegiados")
    public ModelAndView getColegiados(ModelAndView mav) {
        mav.setViewName("admin/listColegiado");
        mav.addObject("colegiados", adminService.listarColegiado());
        return mav;
    }

    @GetMapping("/colegiados/{id}")
    public ModelAndView editarColegiado(@PathVariable(value = "id") Integer id, ModelAndView mav) {
        mav.setViewName("admin/formColegiado");
        mav.addObject("colegiado", adminService.getColegiado(id));
        return mav;
    }

    @GetMapping("/colegiados/cadastro")
    public ModelAndView getCadastroColegiado(ModelAndView mav) {
        mav.setViewName("admin/formColegiado");
        mav.addObject("colegiado", new Colegiado());
        return mav;
    }

    @PostMapping("/colegiados")
    public ModelAndView saveColegiado(@Valid Colegiado colegiado,BindingResult result, ModelAndView mav) {
        if (result.hasErrors()){
            mav.setViewName("admin/formColegiado");
            mav.addObject("colegiado", colegiado);
            return mav;
        }
        adminService.salvarColegiado(colegiado);
        mav.setViewName("redirect:/admin/colegiados");
        mav.addObject("colegiados", adminService.listarColegiado());
        return mav;
    }

    @DeleteMapping("/colegiados/{id}")
    public ModelAndView deleteColegiado(@PathVariable(value = "id") Integer id, ModelAndView mav) {
        adminService.removerColegiado(id);
        mav.setViewName("redirect:/admin/colegiados");
        mav.addObject("colegiado", adminService.listarColegiado());
        return mav;
    }

    // @GetMapping("/cursos")
    // public ModelAndView getCursos(ModelAndView mav) {
    //     mav.setViewName("admin/listCurso");
    //     mav.addObject("cursos", adminService.listarCursos());
    //     return mav;
    // }

    // @GetMapping("/cursos/cadastro")
    // public ModelAndView getCadastro(ModelAndView mav) {
    //     mav.setViewName("admin/formCurso");
    //     mav.addObject("curso", new Curso());
    //     return mav;
    // }

    // @GetMapping("/cursos/{id}")
    // public ModelAndView editCurso(@PathVariable(value = "id") Long id, ModelAndView mav) {
    //     mav.setViewName("admin/formCurso");
    //     mav.addObject("curso", adminService.getCurso(id));
    //     return mav;
    // }
    
    // @PostMapping("/cursos")
    // public ModelAndView saveCurso(@Valid Curso curso, BindingResult result, ModelAndView mav) {
    //     if (result.hasErrors()){
    //         mav.addObject("curso", curso);
    //         mav.setViewName("/admin/formCurso");
    //         return mav;
    //     }
    //     adminService.salvarCurso(curso);
    //     mav.setViewName("redirect:/admin/cursos");
    //     mav.addObject("cursos", adminService.listarCursos());
    //     return mav;
    // }

    // @DeleteMapping("/cursos/{id}")
    // public ModelAndView deleteCurso(@PathVariable(value = "id") Long id, ModelAndView mav) {
    //     adminService.removerCurso(id);
    //     mav.setViewName("redirect:/admin/cursos");
    //     mav.addObject("cursos", adminService.listarCursos());
    //     return mav;
    // }

    @GetMapping("/assuntos")
    public ModelAndView getAssuntos(ModelAndView mav) {
        mav.setViewName("admin/listAssunto");
        mav.addObject("assuntos", adminService.listAssunto());
        return mav;
    }

    @GetMapping("/assuntos/cadastro")
    public ModelAndView getCadastroAssunto(ModelAndView mav) {
        mav.setViewName("admin/formAssunto");
        mav.addObject("assunto", new Assunto());
        return mav;
    }

    @PostMapping("/assuntos")
    public ModelAndView saveAssunto(@Valid Assunto assunto, BindingResult result, ModelAndView mav) {
        if (result.hasErrors()) {
            mav.setViewName("admin/formAssunto");
            mav.addObject("assunto", assunto);
            return mav;
        }
        adminService.saveAssunto(assunto);
        mav.setViewName("redirect:/admin/assuntos");
        mav.addObject("assuntos", adminService.listAssunto());
        return mav;
    }

    @GetMapping("/assuntos/{id}")
    public ModelAndView editAssunto(@PathVariable(value = "id") Integer id, ModelAndView mav) {
        mav.setViewName("admin/formAssunto");
        mav.addObject("assunto", adminService.getAssunto(id));
        return mav;
    }


    @DeleteMapping("/assuntos/{id}")
    public ModelAndView deleteAssunto(@PathVariable(value = "id") Integer id, ModelAndView mav) {
        adminService.removerAssunto(id);
        mav.setViewName("redirect:/admin/assuntos");
        mav.addObject("assuntos", adminService.listAssunto());
        return mav;
    }

}
