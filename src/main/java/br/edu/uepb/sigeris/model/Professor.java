package br.edu.uepb.sigeris.model;

import br.edu.uepb.sigeris.enumerations.Cursos;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Professor extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_controle")
    private Date data;

    @Column(name = "dedicacao_exclusiva")
    private boolean dedicacaoExclusiva;

    @Column(name = "classe", length = 50)
    private String classe;

    @Column(name = "nivel", length = 50)
    private String nivel;

    @CPF
    @Column(name = "cpf", unique = true)
    private String cpf;

    @ElementCollection(fetch = FetchType.EAGER, targetClass = Cursos.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "profesor_cursos")
    private List<Cursos> cursos;
}
