package br.edu.uepb.sigeris.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * Classe que representa o modelo da entidade Disciplina a ser persistida no banco,
 * com todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Data
@Entity
@Table(name = "disciplina")
//@NamedQueries({
//    @NamedQuery(name = "Servidores.todos", query = "FROM Pessoa p WHERE p.tipo='TECNICO' OR p.tipo='PROFESSOR' ORDER BY p.nome ASC"),
//    @NamedQuery(name = "Professores.todos", query = "FROM Pessoa p WHERE p.tipo='PROFESSOR' ORDER BY p.nome ASC"),
//    @NamedQuery(name = "Tecnicos.todos", query = "FROM Pessoa p WHERE p.tipo='TECNICO' ORDER BY p.nome ASC")
//})
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "É necessário informar um nome para a disciplina")
    @Column(name = "nome", length = 200)
    private String nome;

    @Column(name = "codigo", length = 20)
    private String codigo;

    @Column(name = "chs")
    private int cargaHorariaSemanal;
}
