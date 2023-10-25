package br.edu.ifpb.pweb2.venus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.venus.model.Professor;
import br.edu.ifpb.pweb2.venus.repository.ProfessorRepository;

@Component
public class ProfessorService implements Service<Professor, Integer>{
    
    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

    @Override
    public Professor findById(Integer id) {
        Professor professor = null;
        Optional<Professor> opProfessor = professorRepository.findById(id);
        if (opProfessor.isPresent()) {
            professor = opProfessor.get();
        }
        return professor;
        
    }

    @Override
    public Professor save(Professor t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    public void deleteById(Integer id) {
        professorRepository.deleteById(id);
    }
}
