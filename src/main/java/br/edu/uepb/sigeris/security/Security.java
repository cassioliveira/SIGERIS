package br.edu.uepb.sigeris.security;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Bean CDI que disponibiliza o usuário logado no sistema e pode ser usado em
 * qualquer lugar da camada de apresentação.
 *
 * @author cassio
 */
@Model
public class Security {

	/**
	 * Captura o nome 'amigável' do usuário logado.
	 *
	 * @return
	 */
	public String getNomeDoUsuarioLogado() {
		String nome = null;

		SystemUser systemUser = getLoggedUser();
		if (systemUser != null) {
			nome = systemUser.getSubject().getNome();
		}

		return nome;
	}

	/**
	 * Captura o nome de usuário que faz o login (CPF)
	 *
	 * @return
	 */
	public String usuarioLogado() {
		String nome = null;

		SystemUser systemUser = getLoggedUser();
		if (systemUser != null) {
			nome = systemUser.getSubject().getUserName();
		}

		return nome;
	}

	/**
	 * Captura o ID do usuário logado
	 *
	 * @return
	 */
	public Long idDoUsuarioLogado() {
		Long nome = null;

		SystemUser systemUser = getLoggedUser();
		if (systemUser != null) {
			nome = systemUser.getSubject().getId();
//			nome = systemUser.getSubject().getId().intValue(); Versão com id convertido para int.
		}

		return nome;
	}

	/**
	 * Verifica o usuário que está logado no sistema
	 *
	 * @return
	 */
	private SystemUser getLoggedUser() {

		SystemUser systemUser = null;

		UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) FacesContext
				.getCurrentInstance().getExternalContext().getUserPrincipal();

		if (authenticationToken != null && authenticationToken.getPrincipal() != null) {
			systemUser = (SystemUser) authenticationToken.getPrincipal();
		}

		return systemUser;
	}

	// COMPARAR SE O USUÁRIO LOGADO ESTÁ CONTIDO NA LISTA DE USUÁRIOS RETORNADOS DE
	// UM GRUPO ESPECÍFICO.

//	public boolean getEstaNoGrupo() {
//
//		System.out.println("USUARIO LOGADO >>>>>>>>>>: " + usuarioLogado());
//		String grupoDoUsuarioLogado = usuarioService.grupoDoUsuario(idDoUsuarioLogado());
//		System.out.println("GRUPO >>>>>>>>>>: " + grupoDoUsuarioLogado);
//		System.out.println("USUARIOS DO GRUPO >>>>>>>>>>: " + usuarioService.usuariosPorGrupo(grupoDoUsuarioLogado));
//		Boolean usuarioEstaNoGrupo = false;
//		if (usuarioService.usuariosPorGrupo(grupoDoUsuarioLogado).contains(usuarioLogado())) {
//			usuarioEstaNoGrupo = true;
//		}
//		System.out.println("O USUARIO ESTÁ NO GRUPO??? >>>>>>>>>>: " + usuarioEstaNoGrupo);
//		return usuarioEstaNoGrupo;
//	}

//	public boolean estaNoGrupo(String grupo) {
//		System.out.println("GRUPO >>>>>>>>>>: " + grupo);
//		Boolean usuarioEstaNoGrupo = false;
//		for (String usuario : usuarioService.usuariosPorGrupo(grupo)) {
//			System.out.println("Usuario da vez >>>>>>: " + usuario);
//			System.out.println("Usuario Logado>>>>>>>: " + getLoggedUser().getUsername());
//			if (usuario.equals(getLoggedUser().getUsername())) {
//				usuarioEstaNoGrupo = true;
//			}
//		}
//		System.out.println("USUARIO DO GRUPO >>>>>>>>>: " + usuarioEstaNoGrupo);
//		return usuarioEstaNoGrupo;
//	}

}
