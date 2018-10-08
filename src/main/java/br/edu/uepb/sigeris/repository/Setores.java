package br.edu.uepb.sigeris.repository;

import br.edu.uepb.sigeris.model.Setor;
import java.io.Serializable;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Setores extends Generic<Setor> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Setores() {
        super(Setor.class);
    }
}
