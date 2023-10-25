package br.edu.ifpb.pweb2.venus.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.pweb2.venus.model.Aluno;
import br.edu.ifpb.pweb2.venus.model.Colegiado;
import br.edu.ifpb.pweb2.venus.model.Professor;
import br.edu.ifpb.pweb2.venus.repository.AlunoRepository;
import br.edu.ifpb.pweb2.venus.repository.ColegiadoRepository;
import br.edu.ifpb.pweb2.venus.repository.ProfessorRepository;

@Service
public class AdminService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ColegiadoRepository colegiadoRepository;    

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

    @Transactional
    public void removerProfessor(Integer id) {
        professorRepository.deleteById(id);
    }

    @Transactional
    public void salvarProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    public Optional<Professor> getProfessor(Integer id) {
        return professorRepository.findById(id);
    }
    
    @Transactional
    public void removerColegiado(Integer id) {
        colegiadoRepository.deleteById(id);
    }

    @Transactional
    public void salvarColegiado(Colegiado colegiado) {
        colegiadoRepository.save(colegiado);
    }

    public List<Colegiado> listarColegiado() {
        return colegiadoRepository.findAll();
    }

    public Colegiado getColegiado(Long id) {
        return colegiadoRepository.findById(id);
    }
}
