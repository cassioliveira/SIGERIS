package br.edu.uepb.sigeris.services;

import br.edu.uepb.sigeris.model.Setor;
import br.edu.uepb.sigeris.repository.Setores;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class SetorService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Setores setores;

    @Transactional
    public void salvar(Setor setor) {
        this.setores.salvar(setor);
    }

    @Transactional
    public void excluir(Setor setor) {
        setores.excluir(porId(setor.getId()));
    }

    public Setor porId(Long id) {
        return setores.porId(id);
    }

    public List<Setor> todas() {
        return setores.todas();
    }
}
