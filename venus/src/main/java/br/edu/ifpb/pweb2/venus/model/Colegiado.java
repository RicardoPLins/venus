package br.edu.ifpb.pweb2.venus.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity 
public class Colegiado {
    //id: int, dataInicio: date, dataFim: date, descricao: str,
    //portaria: str, curso: str

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date dataInicio;

    private Date dataFim;

    private String descricao;

    private String portaria;

    private String curso;

}
