package br.edu.uepb.sigeris.repository;

import java.io.Serializable;

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
     * Método que faz uma consulta por um usuário no banco de dados e retorna o
     * mesmo baseado no parametro do método
     *
     * @param usuario
     * @return
     */
    public Usuario porUsuario(String usuario) {
        return (Usuario) getEntityManager().createNamedQuery("Usuario.porUsuario").setParameter("userName", usuario.toLowerCase()).getSingleResult();
    }
}
