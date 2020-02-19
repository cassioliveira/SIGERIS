package br.edu.uepb.sigeris.repository;

import java.io.Serializable;

import br.edu.uepb.sigeris.model.Reuniao;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Reunioes extends Generic<Reuniao> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Reunioes() {
        super(Reuniao.class);
    }
}
