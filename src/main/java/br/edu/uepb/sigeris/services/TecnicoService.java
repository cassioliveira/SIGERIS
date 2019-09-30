package br.edu.uepb.sigeris.services;

import br.edu.uepb.sigeris.model.Tecnico;
import br.edu.uepb.sigeris.repository.Tecnicos;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class TecnicoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Tecnicos tecnicos;

    @Inject
    private PessoaService pessoaService;

    @Inject
    private SetorService setorService;

    @Transactional
    public void salvar(Tecnico tecnico) {
        if (novoCadastro(tecnico)) {
            tecnico.setTipo("TECNICO");
            tecnico.setCadastro(new Date());
        }
        this.tecnicos.salvar(tecnico);
    }

    @Transactional
    public void deletar(Tecnico tecnico) {
        tecnicos.excluir(findById(tecnico.getId()));
    }

    public Tecnico findById(Long id) {
        return tecnicos.porId(id);
    }

    public List<Tecnico> findAll() {
        return tecnicos.todos();
    }

    /**
     * Verifica se o ID do servidor já existe, indicando se é um novo cadastro.
     *
     * @param tecnico
     * @return
     */
    public boolean novoCadastro(Tecnico tecnico) {
        return pessoaService.novoCadastro(tecnico);
    }

//    public List<String> setores() {
//        List<String> setoresString = new ArrayList<>();
//
//        for (Setor item : setorService.todos()) {
//            setoresString.add(item.getNome());
//        }
//
//        return setoresString;
//    }
    public List<String> setores() {
        return setorService.servidores();
    }

}
