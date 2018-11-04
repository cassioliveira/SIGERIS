package br.edu.uepb.sigeris.controllers;

import br.edu.uepb.sigeris.enumerations.GruposUsuarios;
import br.edu.uepb.sigeris.model.Grupo;
import br.edu.uepb.sigeris.services.GrupoService;
import br.edu.uepb.sigeris.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
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
public class GrupoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Grupo grupo;

    @Getter
    @Setter
    private Grupo grupoSelecionado;

    @Getter
    @Setter
    @Inject
    private GrupoService grupoService;

    @Getter
    private List<Grupo> gruposCadastrados;
    
    @Getter
    private List<GruposUsuarios> grupos;

    public GrupoBean() {
        grupo = new Grupo();
        grupoSelecionado = new Grupo();
    }

    @PostConstruct
    public void init() {
        this.gruposCadastrados = grupoService.todos();
        this.grupos = Arrays.asList(GruposUsuarios.values());
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Grupo e salvar.
     *
     */
    public void salvar() {
        grupoService.salvar(grupo);
        this.grupo = new Grupo();
        FacesUtil.mensagemSucesso("Salvo com sucesso!");
        gruposCadastrados = grupoService.todos();
    }

    /**
     * Método responsável por excluir um objeto do tipo Grupo e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.grupoService.excluir(grupoSelecionado);
        this.gruposCadastrados = grupoService.todos();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.grupo.getId() != null;
    }
    
}
