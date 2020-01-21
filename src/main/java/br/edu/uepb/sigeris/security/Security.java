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
     * Captura o usuário já logado e retorna o nome do mesmo para ser exibido na
     * página
     *
     * @return
     */
    public String getNomeUsuario() {
        String nome = null;

        SystemUser systemUser = getLoggedUser();
        if (systemUser != null) {
            nome = systemUser.getSubject().getNome();
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

        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) 
                FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();

        if (authenticationToken != null && authenticationToken.getPrincipal() != null) {
            systemUser = (SystemUser) authenticationToken.getPrincipal();
        }

        return systemUser;
    }

}
