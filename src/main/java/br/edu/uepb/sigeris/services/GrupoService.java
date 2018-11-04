package br.edu.uepb.sigeris.services;

import br.edu.uepb.sigeris.model.Grupo;
import br.edu.uepb.sigeris.repository.Grupos;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class GrupoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Grupos grupos;

    @Transactional
    public void salvar(Grupo grupo) {
        this.grupos.salvar(grupo);
    }

    @Transactional
    public void excluir(Grupo grupo) {
        grupos.excluir(porId(grupo.getId()));
    }

    public Grupo porId(Long id) {
        return grupos.porId(id);
    }

    public List<Grupo> todos() {
        return grupos.todos();
    }
    
//    public String grupoCadastrado(String nome){
//        return grupos.grupoCadastrado(nome);
//    }
}
