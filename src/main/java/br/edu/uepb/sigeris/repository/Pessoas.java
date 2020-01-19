package br.edu.uepb.sigeris.repository;

import java.io.Serializable;
import java.util.List;

import br.edu.uepb.sigeris.model.Pessoa;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Pessoas extends Generic<Pessoa> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Pessoas() {
        super(Pessoa.class);
    }
    
    /**
     * Retorna todos os servidores cadastrados através do atributo 'tipo' de
     * Pessoa.
     *
     * @see Pessoa
     * @return
     */
    public List<Pessoa> servidores() {
        return getEntityManager().createNamedQuery("Servidores.todos").getResultList();
    }
    
    /**
     * Retorna todos os Técnicos cadastrados através do atributo 'tipo' de
     * Pessoa.
     *
     * @see Pessoa
     * @return
     */
    public List<Pessoa> tecnicos() {
        return getEntityManager().createNamedQuery("Tecnicos.todos").getResultList();
    }
    
    /**
     * Retorna todos os Professores cadastrados através do atributo 'tipo' de
     * Pessoa.
     *
     * @see Pessoa
     * @return
     */
    public List<Pessoa> professores() {
        return getEntityManager().createNamedQuery("Professores.todos").getResultList();
    }
}
