package br.edu.uepb.sigeris.services;

import br.edu.uepb.sigeris.model.Professor;
import br.edu.uepb.sigeris.repository.Professores;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class ProfessorService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Professores professores;

    @Inject
    private PessoaService pessoaService;

    @Transactional
    public void salvar(Professor professor) {
        if (novoCadastro(professor)) {
            professor.setTipo("PROFESSOR");
            professor.setCadastro(new Date());
//            if (professor.getMatricula() == null) {
//                professor.setMatricula("0.00000-0");
//            }
        }
        this.professores.salvar(professor);
    }

    @Transactional
    public void deletar(Professor professor) {
        professores.excluir(findById(professor.getId()));
    }

    public Professor findById(Long id) {
        return professores.porId(id);
    }

    public List<Professor> findAll() {
        return professores.todos();
    }

    /**
     * Verifica se o ID do servidor já existe, indicando se é um novo cadastro.
     *
     * @param professor
     * @return
     */
    public boolean novoCadastro(Professor professor) {
        return pessoaService.novoCadastro(professor);
    }

}
