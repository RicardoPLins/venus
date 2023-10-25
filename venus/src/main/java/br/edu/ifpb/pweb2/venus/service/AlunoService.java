package br.edu.ifpb.pweb2.venus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.pweb2.venus.model.Aluno;
import br.edu.ifpb.pweb2.venus.repository.AlunoRepository;

@Service
public class AlunoService{
    
   @Autowired
    private AlunoRepository alunoRepository;

   
}
