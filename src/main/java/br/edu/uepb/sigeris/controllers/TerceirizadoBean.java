package br.edu.uepb.sigeris.controllers;

import br.edu.uepb.sigeris.enumerations.Estados;
import br.edu.uepb.sigeris.enumerations.TurnosTerceirizados;
import br.edu.uepb.sigeris.model.Terceirizado;
import br.edu.uepb.sigeris.services.TerceirizadoService;
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
public class TerceirizadoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Terceirizado terceirizado;

    @Getter
    @Setter
    private Terceirizado terceirizadoSelecionado;

    @Getter
    @Setter
    @Inject
    private TerceirizadoService terceirizadoService;

    @Getter
    private List<Terceirizado> terceirizados;

    @Getter
    private List<Estados> estados;

//    @Getter
//    private List<SetoresTerceirizados> setores;
    
    @Getter
    private List<TurnosTerceirizados> turnos;

    public TerceirizadoBean() {
        terceirizado = new Terceirizado();
        terceirizadoSelecionado = new Terceirizado();
    }

    @PostConstruct
    public void init() {
        this.terceirizados = terceirizadoService.findAll();
        this.estados = Arrays.asList(Estados.values());
//        this.setores = Arrays.asList(SetoresTerceirizados.values());
        this.turnos = Arrays.asList(TurnosTerceirizados.values());
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Terceirizado e salvar.
     *
     */
    public void salvar() {
        terceirizadoService.salvar(terceirizado);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de '" + terceirizado.getNome() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("listar-terceirizados.xhtml");
        this.terceirizado = new Terceirizado();
    }

    /**
     * Método responsável por excluir um objeto do tipo Terceirizado e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.terceirizadoService.deletar(terceirizadoSelecionado);
        this.terceirizados = terceirizadoService.findAll();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.terceirizado.getId() != null;
    }
    
    public List<String> getSetores(){
        return terceirizadoService.setores();
    }
}
