package br.edu.ifpb.pweb2.venus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpb.pweb2.venus.model.Professor;


public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
    
    // Professor findByCoordenadorTrueAndCursoId(Integer id);

    // Professor findByMatricula(String matricula);

    // List<Professor> findAllByRelatorId(Integer id);

}
