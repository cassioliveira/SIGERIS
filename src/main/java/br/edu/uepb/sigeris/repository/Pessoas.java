package br.edu.uepb.sigeris.repository;

import java.io.Serializable;
import java.util.List;

import br.edu.uepb.sigeris.model.Pessoa;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class Pessoas extends Generic<Pessoa> implements Serializable {

	private static final long serialVersionUID = 1L;

	public Pessoas() {
		super(Pessoa.class);
	}

	/**
	 * Recebe do service o alias do tipo de consulta a ser feita para execução da
	 * query.
	 * 
	 * @param alias
	 * @return
	 */
	public List<Pessoa> consulta(String alias) {
		return getEntityManager().createNamedQuery(alias).getResultList();
	}
}
