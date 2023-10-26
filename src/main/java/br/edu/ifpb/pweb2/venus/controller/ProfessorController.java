// package br.edu.ifpb.pweb2.venus.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.servlet.ModelAndView;

// import br.edu.ifpb.pweb2.venus.model.Processo;
// import br.edu.ifpb.pweb2.venus.model.Professor;
// import br.edu.ifpb.pweb2.venus.service.ProfessorService;
// import jakarta.servlet.http.HttpSession;

// @Controller
// @RequestMapping("/professores")
// public class ProfessorController {

//     @Autowired
//     private ProfessorService professorService;   
    
    
//     @GetMapping("/processos")
//     public ModelAndView processos(ModelAndView mav, HttpSession session) {
//         Professor professor = (Professor) session.getAttribute("professor");
//         mav.setViewName("professor/formProcessos");
//         mav.addObject("processos", professorService.listProcesso());
//         return mav;
//     }

//     @GetMapping("/processos/{id}")
//     public ModelAndView processo(@PathVariable("id") Integer id, ModelAndView mav) {
//         Processo processo = professorService.buscarProcesso(id);
//         mav.setViewName("professor/votoRelator");
//         mav.addObject("processo", processo);
//         return mav;
//     }

// }
