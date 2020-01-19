package br.edu.uepb.sigeris.repository;

import java.io.Serializable;

import br.edu.uepb.sigeris.model.Terceirizado;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Terceirizados extends Generic<Terceirizado> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Terceirizados() {
        super(Terceirizado.class);
    }

}
