package br.edu.ifpb.pweb2.venus.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Processo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String numero;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataRecepcao;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataDistribuicao;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataParecer;

    private byte[] parecer;

    private TipoDecisao decisaoRelator;
}
