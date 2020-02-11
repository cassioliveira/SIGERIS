package br.edu.uepb.sigeris.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.edu.uepb.sigeris.model.Usuario;
import br.edu.uepb.sigeris.repository.Usuarios;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;

	@Transactional
	public void salvar(Usuario usuario) {
		this.usuarios.salvar(usuario);
	}

	@Transactional
	public void excluir(Usuario usuario) {
		usuarios.excluir(porId(usuario.getId()));
	}

	public Usuario porId(Long id) {
		return usuarios.porId(id);
	}

	public List<Usuario> todos() {
		return usuarios.todos();
	}

	public Usuario porUsuario(String userName) {
		return usuarios.porUsuario(userName);
	}

	public List<String> usuariosPorGrupo(String nomeGrupo) {
		return usuarios.usuariosPorGrupo(nomeGrupo);
	}
	
//	public String grupoDoUsuario(Long usuario) {
//		return usuarios.grupoDoUsuario(usuario);
//	}

//	//Retorna o grupo da pessoa que fez um cadastro.
//	public String grupoDoUsuarioQueFezOCadastro() {
//		Pessoa pessoa = new Pessoa();
//		
//		
//	}
}
