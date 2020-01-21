package br.edu.uepb.sigeris.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.edu.uepb.sigeris.model.Grupo;
import br.edu.uepb.sigeris.model.Usuario;
import br.edu.uepb.sigeris.services.UsuarioService;
import br.edu.uepb.sigeris.util.cdi.CDIServiceLocator;

/**
 *
 * @author cassio
 */
public class SystemUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UsuarioService usuarioService;
        usuarioService = CDIServiceLocator.getBean(UsuarioService.class);
        Usuario usuario = usuarioService.porUsuario(userName);

        SystemUser systemUser = null;

        if (usuario != null) {
            systemUser = new SystemUser(usuario, getGroups(usuario));
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado.");
        }

        return systemUser;
    }

    private Collection<? extends GrantedAuthority> getGroups(Usuario usuario) {
        List<SimpleGrantedAuthority> groups = new ArrayList<>();
        for (Grupo group : usuario.getGrupos()) {
            groups.add(new SimpleGrantedAuthority("ROLE_" + group.getNome().toUpperCase()));
        }
        return groups;
    }

}
