package br.edu.ifpb.pweb2.venus.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Processo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String numero;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataRecepcao;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataDistribuicao;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataParecer;

    private byte[] parecer;

    @Enumerated(EnumType.ORDINAL)
    private TipoDecisao decisaoRelator;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "assunto_id")
    private Assunto assunto;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor relator;

    // @ManyToOne
    // @JoinColumn(name = "id_curso")
    private String curso;

    @ElementCollection
    private List<byte[]> documentos;

    @ManyToOne
    @JoinColumn(name = "aluno_Id")
    private Aluno interessado;

    public void addDocumento(byte[] documento) {
        this.documentos.add(documento);
    }

    public void setTipoDecisao(TipoDecisao decisaoRelator) {
        this.decisaoRelator = decisaoRelator;
    }

    public TipoDecisao getTipoDecisao() {
        return this.decisaoRelator;
    }
}
