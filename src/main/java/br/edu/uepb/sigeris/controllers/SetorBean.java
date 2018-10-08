package br.edu.uepb.sigeris.controllers;

import br.edu.uepb.sigeris.enumerations.CategoriasServidor;
import br.edu.uepb.sigeris.enumerations.Estados;
import br.edu.uepb.sigeris.model.Setor;
import br.edu.uepb.sigeris.services.SetorService;
import br.edu.uepb.sigeris.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 * Managed bean usado pela página de cadastro de consulta. É responsável por
 * ligar a classe de modelo Consulta à página de visualização processando as
 * solicitações do usuário e retornando os dados à visualização.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Named
@ViewScoped
public class SetorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Setor setor;

    @Getter
    @Setter
    private Setor setorSelecionado;

    @Getter
    @Setter
    @Inject
    private SetorService setorService;

    @Getter
    private List<Setor> setores;

    public SetorBean() {
        setor = new Setor();
        setorSelecionado = new Setor();
    }

    @PostConstruct
    public void init() {
        this.setores = setorService.todas();
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Setor e salvar.
     *
     */
    public void salvar() {
        setorService.salvar(setor);
        this.setor = new Setor();
        FacesUtil.mensagemSucesso("Salvo com sucesso!");
        setores = setorService.todas();
    }

    /**
     * Método responsável por excluir um objeto do tipo Setor e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.setorService.excluir(setorSelecionado);
        this.setores = setorService.todas();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.setor.getId() != null;
    }

}
