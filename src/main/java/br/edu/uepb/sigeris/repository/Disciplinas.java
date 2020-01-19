package br.edu.uepb.sigeris.repository;

import java.io.Serializable;

import br.edu.uepb.sigeris.model.Disciplina;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Disciplinas extends Generic<Disciplina> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Disciplinas() {
        super(Disciplina.class);
    }
}
