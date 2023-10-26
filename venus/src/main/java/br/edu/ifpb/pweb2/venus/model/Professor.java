package br.edu.ifpb.pweb2.venus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @NotBlank(message = "Campo obrigatório")
    private String fone;

    @NotBlank(message = "Campo obrigatório")
    private String matricula;

    @NotBlank(message = "Campo obrigatório")
    private String login;

    @NotBlank(message = "Campo obrigatório")
    private String senha;
    
    private Boolean coordenador;

    public void consultarListaSeusProcessos(){

    }
    public void RedigirParecerProcessos(){

    }
    
}
