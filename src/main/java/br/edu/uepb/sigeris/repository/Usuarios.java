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
}
