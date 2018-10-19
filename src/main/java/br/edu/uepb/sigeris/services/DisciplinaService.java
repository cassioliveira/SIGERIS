package br.edu.uepb.sigeris.services;

import br.edu.uepb.sigeris.model.Disciplina;
import br.edu.uepb.sigeris.repository.Disciplinas;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class DisciplinaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Disciplinas disciplinas;

    @Transactional
    public void salvar(Disciplina disciplina) {
        this.disciplinas.salvar(disciplina);
    }

    @Transactional
    public void excluir(Disciplina disciplina) {
        disciplinas.excluir(porId(disciplina.getId()));
    }

    public Disciplina porId(Long id) {
        return disciplinas.porId(id);
    }

    public List<Disciplina> todos() {
        return disciplinas.todos();
    }
}
