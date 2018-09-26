package br.edu.uepb.sigeris.repository;

import br.edu.uepb.sigeris.model.Tecnico;
import java.io.Serializable;

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
