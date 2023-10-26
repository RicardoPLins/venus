package br.edu.ifpb.pweb2.venus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.pweb2.venus.model.Processo;
import br.edu.ifpb.pweb2.venus.repository.AlunoRepository;
import br.edu.ifpb.pweb2.venus.repository.ProcessoRepository;
import jakarta.transaction.Transactional;

@Service
public class AlunoService{
    
   @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProcessoRepository processoRepository;

    @Transactional
    public void removerProcesso(Integer id) {
        processoRepository.deleteById(id);
    }

    @Transactional
    public void saveProcesso(Processo processo) {
        processoRepository.save(processo);
    }

    public List<Processo> listProcesso() {
        return processoRepository.findAll();
    }
    
    public Optional<Processo> getProcesso(Integer id) {
        return processoRepository.findById(id);
    }
   
}
