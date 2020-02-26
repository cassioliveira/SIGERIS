package br.edu.uepb.sigeris.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Classe que representa o modelo da entidade Curso a ser persistida no banco,
 * com todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Data
@Entity
@Table(name = "reuniao")
public class Reuniao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	private String tituloDocumento;
//
//	@NotNull(message = "Informe o setor responsável")
//	private Setor setor;
//
//	@NotNull(message = "Informe a descrição")
//	private String descricao;
//
//	@NotNull(message = "Informe o local")
//	private String local;
//
//	@NotNull(message = "Informe a data")
//	@Temporal(TemporalType.DATE)
//	private Date data;
//
//	@NotNull(message = "Informe a hora")
//	@Temporal(TemporalType.TIME)
//	private Date hora;
//
//	@Column(name = "pauta", length = 1000)
//	private String pauta;
//
//	@ElementCollection
//	private List<String> pessoas;

//	@OneToMany
//	@JoinTable(name = "reuniao_pessoa", joinColumns = @JoinColumn(name = "id_reuniao"), inverseJoinColumns = @JoinColumn(name = "id_pessoa"))

//	public Reuniao() {
//		setTituloDocumento("Lista de presença");
//	}

}
