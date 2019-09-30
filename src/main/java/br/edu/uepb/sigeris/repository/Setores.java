package br.edu.uepb.sigeris.repository;

import br.edu.uepb.sigeris.model.Setor;
import java.io.Serializable;
import java.util.List;

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
