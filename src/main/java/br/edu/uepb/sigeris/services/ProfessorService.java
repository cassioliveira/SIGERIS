package br.edu.uepb.sigeris.services;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.edu.uepb.sigeris.model.Professor;
import br.edu.uepb.sigeris.repository.Professores;
import br.edu.uepb.sigeris.security.Security;

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

	@Inject
	private Security security;

	@Transactional
	public void salvar(Professor professor) {
		if (novoCadastro(professor)) {
			professor.setCategoria("PROFESSOR");
			professor.setDataCadastro(new Date());
		}
		professor.setUsuario(security.usuarioLogado());
		professor.setDataUltimaAtualizacao(new Date());
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
