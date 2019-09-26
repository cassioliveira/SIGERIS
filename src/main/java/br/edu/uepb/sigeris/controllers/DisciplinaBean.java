package br.edu.uepb.sigeris.controllers;

import br.edu.uepb.sigeris.enumerations.VincluoServidor;
import br.edu.uepb.sigeris.enumerations.Estados;
import br.edu.uepb.sigeris.model.Disciplina;
import br.edu.uepb.sigeris.services.DisciplinaService;
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
public class DisciplinaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Disciplina disciplina;

    @Getter
    @Setter
    private Disciplina disciplinaSelecionada;

    @Getter
    @Setter
    @Inject
    private DisciplinaService disciplinaService;

    @Getter
    private List<Disciplina> disciplinas;

    @Getter
    private List<Estados> estados;

    public DisciplinaBean() {
        disciplina = new Disciplina();
        disciplinaSelecionada = new Disciplina();
    }

    @PostConstruct
    public void init() {
        this.disciplinas = disciplinaService.todos();
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Disciplina e salvar.
     *
     */
    public void salvar() {
        disciplinaService.salvar(disciplina);
        disciplina = new Disciplina();
        FacesUtil.mensagemSucesso("Salva com sucesso!");
        disciplinas = disciplinaService.todos();
    }

    /**
     * Método responsável por excluir um objeto do tipo Disciplina e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.disciplinaService.excluir(disciplinaSelecionada);
        this.disciplinas = disciplinaService.todos();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.disciplina.getId() != null;
    }

}
