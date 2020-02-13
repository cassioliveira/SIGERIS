package br.edu.uepb.sigeris.services;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.uepb.sigeris.model.Terceirizado;
import br.edu.uepb.sigeris.repository.Terceirizados;
import br.edu.uepb.sigeris.security.Security;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class TerceirizadoService implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory.getLogger(TerceirizadoService.class);

	@Inject
	private Terceirizados terceirizados;

	@Inject
	private PessoaService pessoaService;

	@Inject
	private SetorService setorService;

	@Inject
	private Security security;

	@Transactional
	public void salvar(Terceirizado terceirizado) {
		if (novoCadastro(terceirizado)) {
			terceirizado.setCategoria("TERCEIRIZADO");
			terceirizado.setDataCadastro(new Date());
		}
		LOGGER.warn(">>> AVISO <<<");
		LOGGER.error(">>> ERRO <<<");
		LOGGER.info(">>> INFORMAÇÃO <<<");
		terceirizado.setUsuario(security.usuarioLogado());
		this.terceirizados.salvar(terceirizado);
	}

	@Transactional
	public void deletar(Terceirizado terceirizado) {
		terceirizados.excluir(findById(terceirizado.getId()));
	}

	public Terceirizado findById(Long id) {
		return terceirizados.porId(id);
	}

	public List<Terceirizado> findAll() {
		return terceirizados.todos();
	}

	/**
	 * Verifica se o ID do servidor já existe, indicando se é um novo cadastro.
	 *
	 * @param terceirizado
	 * @return
	 */
	public boolean novoCadastro(Terceirizado terceirizado) {
		return pessoaService.novoCadastro(terceirizado);
	}

	public List<String> setores() {
		return setorService.terceirizados();
	}

}
