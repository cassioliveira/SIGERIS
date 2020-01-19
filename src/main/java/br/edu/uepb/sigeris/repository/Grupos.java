package br.edu.uepb.sigeris.repository;

import java.io.Serializable;

import br.edu.uepb.sigeris.model.Grupo;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Grupos extends Generic<Grupo> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Grupos() {
        super(Grupo.class);
    }
    
//    public String grupoCadastrado(String nome){
//        return getEntityManager().createNamedQuery("Grupo.cadastrado").setParameter("nome", nome).getSingleResult().toString();
//    }
}
