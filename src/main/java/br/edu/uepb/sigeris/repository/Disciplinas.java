package br.edu.uepb.sigeris.repository;

import br.edu.uepb.sigeris.model.Disciplina;
import java.io.Serializable;

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
