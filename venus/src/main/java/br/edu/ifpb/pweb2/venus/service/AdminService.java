package br.edu.ifpb.pweb2.venus.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.pweb2.venus.model.Aluno;
import br.edu.ifpb.pweb2.venus.repository.AlunoRepository;

@Service
public class AdminService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional
    public void removerAluno(Integer id) {
        alunoRepository.deleteById(id);
    }
    @Transactional
    public void saveAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> listAluno() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> getAluno(Integer id) {
        return alunoRepository.findById(id);
    }
    
}
