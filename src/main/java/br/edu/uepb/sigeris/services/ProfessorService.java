package br.edu.uepb.sigeris.services;

import br.edu.uepb.sigeris.enumerations.Estados;
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
            professor.setCadastro(new Date());
            professor.setMatricula("0.00000-0");
            professor.setEstado(Estados.PB);
            professor.setCidade("Monteiro");
            professor.setCep("58500-000");
        }
        this.professores.save(professor);
    }

    @Transactional
    public void deletar(Professor professor) {
        professores.delete(findById(professor.getId()));
    }

    public Professor findById(Long id) {
        return professores.findById(id);
    }

    public List<Professor> findAll() {
        return professores.findAll();
    }

    /**
     * Verifica se o ID do aluno já existe, indicando se é um novo cadastro.
     *
     * @param professor
     * @return
     */
    public boolean novoCadastro(Professor professor) {
        return pessoaService.novoCadastro(professor);
    }

}
