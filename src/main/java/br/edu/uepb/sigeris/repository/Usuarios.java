package br.edu.uepb.sigeris.repository;

import java.io.Serializable;
import java.util.List;

import br.edu.uepb.sigeris.model.Usuario;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Usuarios extends Generic<Usuario> implements Serializable {

	private static final long serialVersionUID = 1L;

	public Usuarios() {
		super(Usuario.class);
	}

	/**
	 * Consulta por um usuário no banco de dados e retorna o mesmo baseado no
	 * parametro do método
	 *
	 * @param usuario
	 * @return
	 */
	public Usuario porUsuario(String usuario) {
		return (Usuario) getEntityManager().createNamedQuery("Usuario.porUsuario")
				.setParameter("userName", usuario.toLowerCase()).getSingleResult();
	}

	/**
	 * Retorna uma lista de string de usuários de acordo com o nome do grupo
	 * informado no parâmetro do método.
	 * 
	 * @param nomeGrupo
	 * @return
	 */
	public List<String> usuariosPorGrupo(String nomeGrupo) {
		List<String> usuariosPorGrupo = getEntityManager().createNamedQuery("Usuarios.doGrupo")
				.setParameter("nomeGrupo", nomeGrupo).getResultList();
		return usuariosPorGrupo;

	}

	/**
	 * Retorna o grupo associado ao ID do usuario informado no parâmetro do método.
	 * 
	 * @param nomeGrupo
	 * @return
	 */
//	public String grupoDoUsuario(Long idDoUsuario) {
//		return getEntityManager().createNamedQuery("Usuarios.grupoDoUsuarioLogado")
//				.setParameter("idDoUsuario", idDoUsuario).getSingleResult().toString();
//	}
}
