package br.edu.uepb.sigeris.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "usuario")
@NamedQuery(name = "Usuario.porUsuario", query = "FROM Usuario AS u WHERE u.userName = :userName")
//@NamedQueries({
//    @NamedQuery(name = "Usuario.nome", query = "FROM Pessoa p, Usuario u WHERE p.tipo='TECNICO' OR p.tipo='PROFESSOR' ORDER BY p.nome ASC"),
//    @NamedQuery(name = "Professores.todos", query = "FROM Pessoa p WHERE p.tipo='PROFESSOR' ORDER BY p.nome ASC"),
//    @NamedQuery(name = "Tecnicos.todos", query = "FROM Pessoa p WHERE p.tipo='TECNICO' ORDER BY p.nome ASC")
//})
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O usuário deve ser informado")
	@Column(name = "username", length = 14)
	private String userName;

	@NotNull(message = "Informe uma senha")
	@Column(name = "password", length = 20)
	private String password;
	
	@NotNull(message = "Informe o primeiro nome do usuário")
	@Column(name = "nome", length = 20)
	private String nome;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_grupo", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "grupo_id"))
	private List<Grupo> grupos = new ArrayList<>();

}
