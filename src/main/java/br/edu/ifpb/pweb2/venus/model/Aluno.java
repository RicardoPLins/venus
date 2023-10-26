package br.edu.ifpb.pweb2.venus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @NotBlank(message = "Campo obrigatório")
    private String fone;

    @NotBlank(message = "Campo Obrigatório")
    private String matricula;

    @NotBlank(message = "Campo obrigatório")
    private String login;

    @NotBlank(message = "Campo obrigatório")
    private String senha;
    
    // @ManyToOne
    // @JoinColumn(name="id_curso")
    // private Curso curso;

    public Reuniao consultarReuniao(Reuniao reuniao) {
        return reuniao;
    }
}

