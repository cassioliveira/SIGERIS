package br.edu.uepb.sigeris.services;

import br.edu.uepb.sigeris.model.Terceirizado;
import br.edu.uepb.sigeris.repository.Terceirizados;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class TerceirizadoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Terceirizados terceirizados;

    @Inject
    private PessoaService pessoaService;

    @Inject
    private SetorService setorService;

    @Transactional
    public void salvar(Terceirizado terceirizado) {
        if (novoCadastro(terceirizado)) {
            terceirizado.setTipo("TERCEIRIZADO");
            terceirizado.setCadastro(new Date());
        }
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
