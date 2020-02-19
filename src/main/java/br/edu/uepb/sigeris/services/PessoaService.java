package br.edu.uepb.sigeris.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.edu.uepb.sigeris.model.Pessoa;
import br.edu.uepb.sigeris.repository.Pessoas;

/**
 * Possui metodos comuns a todas as entidades que herdam de <b>Pessoa</b>
 *
 * @see Pessoa
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class PessoaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pessoas pessoas;

	/**
	 * Verifica se o ID da pessoa já existe, indicando se é um novo cadastro.
	 *
	 * @param entidade
	 * @return
	 */
	public boolean novoCadastro(Pessoa entidade) {
		return entidade.getId() == null;
	}

	public List<Pessoa> servidores() {
		return pessoas.servidores();
	}

	public List<Pessoa> tecnicos() {
		return pessoas.tecnicos();
	}

	public List<Pessoa> professores() {
		return pessoas.professores();
	}

	/**
	 * Responsável por retornar o caminho da tela de edição de acordo com o tipo de
	 * servidor selecionado, dentre PROFESSOR e TECNICO.
	 *
	 * @param pessoa
	 * @return
	 */
	public String direcionaParaEdicao(Pessoa pessoa) {
		String pagina;
		switch (pessoa.getCategoria()) {
		case "PROFESSOR":
			pagina = "/servidor/cadastro-professor";
			break;
		case "TECNICO":
			pagina = "/servidor/cadastro-tecnico";
			break;
		default:
			pagina = "";
			break;
		}
		return pagina;
	}

	@Transactional
	public void excluir(Pessoa pessoa) {
		pessoas.excluir(findById(pessoa.getId()));
	}

	public Pessoa findById(Long id) {
		return pessoas.porId(id);
	}

	public List<Pessoa> todos() {
		return pessoas.todos();
	}
}
