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
		return pessoas.consulta("Servidores.todos");
	}

	public List<Pessoa> tecnicos() {
		return pessoas.consulta("Tecnicos.todos");
	}

	public List<Pessoa> professores() {
		return pessoas.consulta("Professores.todos");
	}

//	public List<Pessoa> tecnicosContratados() {
//		return pessoas.consulta("TecnicosContratados.todos");
//	}
//
//	public List<Pessoa> tecnicosEfetivos() {
//		return pessoas.consulta("TecnicosEfetivos.todos");
//	}
//
//	public List<Pessoa> professoresContratados() {
//		return pessoas.consulta("ProfessoresContratados.todos");
//	}
//
//	public List<Pessoa> professoresEfetivos() {
//		return pessoas.consulta("ProfessoresEfetivos.todos");
//	}
//
//	public List<Pessoa> terceirizados() {
//		return pessoas.consulta("Terceirizados.todos");
//	}
//
//	public List<Pessoa> terceirizadosApoio() {
//		return pessoas.consulta("TerceirizadosApoio.todos");
//	}
//
//	public List<Pessoa> terceirizadosVigilantes() {
//		return pessoas.consulta("TerceirizadosVigilantes.todos");
//	}

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

	public List<Pessoa> chamaConsulta(String tipoConsulta) {
		List<Pessoa> listaServidores = null;
		switch (tipoConsulta) {
		case "servidores":
			listaServidores = pessoas.consulta("Servidores.todos");
			break;
		case "tecnicos":
			listaServidores = pessoas.consulta("Tecnicos.todos");
			break;
		case "tcontratados":
			listaServidores = pessoas.consulta("TecnicosContratados.todos");
			break;
		case "tefetivos":
			listaServidores = pessoas.consulta("TecnicosEfetivos.todos");
			break;
		case "professores":
			listaServidores = pessoas.consulta("Professores.todos");
			break;
		case "pcontratados":
			listaServidores = pessoas.consulta("ProfessoresContratados.todos");
			break;
		case "pefetivos":
			listaServidores = pessoas.consulta("ProfessoresEfetivos.todos");
			break;
		case "terceirizados":
			listaServidores = pessoas.consulta("Terceirizados.todos");
			break;
		case "apoio":
			listaServidores = pessoas.consulta("TerceirizadosApoio.todos");
			break;
		case "vigilantes":
			listaServidores = pessoas.consulta("TerceirizadosVigilantes.todos");
			break;
		default:
			break;
		}
		return listaServidores;
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
