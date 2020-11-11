package br.edu.uepb.sigeris.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;
import lombok.EqualsAndHashCode;

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

	@Column(name = "curso", length = 150)
	private String curso;

//    @ElementCollection(fetch = FetchType.EAGER, targetClass = Cursos.class)
//    @Enumerated(EnumType.STRING)
//    @CollectionTable(name = "profesor_cursos")
//    private List<Cursos> cursos;
}
