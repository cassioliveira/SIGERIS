package br.edu.uepb.sigeris.repository;

import br.edu.uepb.sigeris.model.Usuario;
import java.io.Serializable;

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
