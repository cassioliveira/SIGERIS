package br.edu.uepb.sigeris.controllers;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.uepb.sigeris.util.jsf.FacesUtil;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author cassio
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private transient FacesContext facesContext;

	@Inject
	private transient HttpServletRequest request;

	@Inject
	private transient HttpServletResponse response;

	@Getter
	@Setter
	private String userName;

	public LoginBean() {
	}

	/**
	 * Método que é chamado antes da pagína ser renderizada e verifica se há um
	 * parametro "invalid" na URL, indicando que o usuário digitou os dados
	 * inválidos para o login
	 */
	public void preRender() {
		if ("true".equals(request.getParameter("invalid"))) {
			FacesUtil.mensagemErro("Usuário e/ou senha inválidos!");
		}
	}

	public void login() throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.xhtml");
		dispatcher.forward(request, response);
		facesContext.responseComplete(); // Interrompe o ciclo de vida do JSF, pois o Spring Security que recebe as
											// requisições dessa sessão
	}

}
