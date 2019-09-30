package br.edu.uepb.sigeris.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * Classe que representa o modelo da entidade Setor a ser persistida no banco,
 * com todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Data
@Entity
@Table(name = "setor")
@NamedQueries({
    @NamedQuery(name = "Setor.servidores", query = "SELECT s.nome FROM Setor s WHERE s.categoria='SERVIDORES'"),
    @NamedQuery(name = "Setor.terceirizados", query = "SELECT s.nome FROM Setor s WHERE s.categoria='TERCEIRIZADOS'"),
})
public class Setor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "categoria", length = 20)
    private String categoria;

    @NotNull(message = "É necessário informar o nome do setor")
    @Column(name = "nome", length = 250)
    private String nome;

}
