package br.edu.uepb.sigeris.repository;

import java.io.Serializable;
import java.util.List;

import br.edu.uepb.sigeris.model.Pessoa;
import br.edu.uepb.sigeris.model.Setor;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Setores extends Generic<Setor> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Setores() {
        super(Setor.class);
    }
    
    /**
     * Retorna todos os Setores cadastrados e que sejam da categoria SERVIDORES
     *
     * @see Pessoa
     * @return
     */
    public List<String> servidores() {
        return getEntityManager().createNamedQuery("Setor.servidores").getResultList();
    }
    
    /**
     * Retorna todos os Setores cadastrados e que sejam da categoria SERVIDORES
     *
     * @see Pessoa
     * @return
     */
    public List<String> terceirizados() {
        return getEntityManager().createNamedQuery("Setor.terceirizados").getResultList();
    }
}
