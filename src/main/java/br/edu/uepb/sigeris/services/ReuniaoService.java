package br.edu.uepb.sigeris.services;

import br.edu.uepb.sigeris.model.Reuniao;
import br.edu.uepb.sigeris.repository.Reunioes;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class ReuniaoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Reunioes reunioes;

    @Transactional
    public void salvar(Reuniao reuniao) {
        this.reunioes.salvar(reuniao);
    }

    @Transactional
    public void excluir(Reuniao reuniao) {
        reunioes.excluir(porId(reuniao.getId()));
    }

    public Reuniao porId(Long id) {
        return reunioes.porId(id);
    }

    public List<Reuniao> todos() {
        return reunioes.todos();
    }
}
