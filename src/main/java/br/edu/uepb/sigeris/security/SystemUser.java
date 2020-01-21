package br.edu.uepb.sigeris.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.edu.uepb.sigeris.model.Usuario;
import lombok.Getter;

/**
 * Provedor de autenticação customizado para o Spring Security
 *
 * @author cassio
 */
public class SystemUser extends User {

    private static final long serialVersionUID = 1L;
    
    @Getter
    private final Usuario subject;

    public SystemUser(Usuario subject, Collection<? extends GrantedAuthority> authorities) {
        super(subject.getUserName(), subject.getPassword(), authorities);
        this.subject = subject;
    }
}
