package br.edu.uepb.sigeris.repository;

import java.io.Serializable;

import br.edu.uepb.sigeris.model.Tecnico;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Tecnicos extends Generic<Tecnico> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Tecnicos() {
        super(Tecnico.class);
    }

}
