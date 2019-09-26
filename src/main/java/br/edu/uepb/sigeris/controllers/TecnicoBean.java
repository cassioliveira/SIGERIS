package br.edu.uepb.sigeris.controllers;

import br.edu.uepb.sigeris.enumerations.VincluoServidor;
import br.edu.uepb.sigeris.enumerations.Estados;
import br.edu.uepb.sigeris.model.Tecnico;
import br.edu.uepb.sigeris.services.TecnicoService;
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
public class TecnicoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Tecnico tecnico;

    @Getter
    @Setter
    private Tecnico tecnicoSelecionado;

    @Getter
    @Setter
    @Inject
    private TecnicoService tecnicoService;

    @Getter
    private List<Tecnico> tecnicos;

    @Getter
    private List<VincluoServidor> categorias;

    @Getter
    private List<Estados> estados;

    public TecnicoBean() {
        tecnico = new Tecnico();
        tecnicoSelecionado = new Tecnico();
    }

    @PostConstruct
    public void init() {
        this.tecnicos = tecnicoService.findAll();
        this.categorias = Arrays.asList(VincluoServidor.values());
        this.estados = Arrays.asList(Estados.values());

    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Tecnico e salvar.
     *
     */
    public void salvar() {
        tecnicoService.salvar(tecnico);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de '" + tecnico.getNome() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("listar-servidores.xhtml");
        this.tecnico = new Tecnico();
    }

    /**
     * Método responsável por excluir um objeto do tipo Tecnico e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.tecnicoService.deletar(tecnicoSelecionado);
        this.tecnicos = tecnicoService.findAll();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.tecnico.getId() != null;
    }
    
    
    public List<String> getSetores(){
        return tecnicoService.setores();
    }

}
