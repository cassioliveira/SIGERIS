package br.edu.uepb.sigeris.services;

import br.edu.uepb.sigeris.model.Pessoa;
import java.io.Serializable;

/**
 * Possui metodos comuns a todas as entidades que herdam de <b>Pessoa</b>
 *
 * @see Pessoa
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class PessoaService implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Verifica se o ID da pessoa já existe, indicando se é um novo cadastro.
     *
     * @param entidade
     * @return
     */
    public boolean novoCadastro(Pessoa entidade) {
        return entidade.getId() == null;
    }
}
