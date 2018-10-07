package br.edu.uepb.sigeris.services;

import br.edu.uepb.sigeris.model.Curso;
import br.edu.uepb.sigeris.repository.Cursos;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class CursoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Cursos cursos;

    @Transactional
    public void salvar(Curso curso) {
        this.cursos.salvar(curso);
    }

    @Transactional
    public void excluir(Curso curso) {
        cursos.excluir(porId(curso.getId()));
    }

    public Curso porId(Long id) {
        return cursos.porId(id);
    }

    public List<Curso> todas() {
        return cursos.todas();
    }
}
