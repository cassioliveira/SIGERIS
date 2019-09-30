package br.edu.uepb.sigeris.controllers;

import br.edu.uepb.sigeris.enumerations.VinculoServidor;
import br.edu.uepb.sigeris.enumerations.Cursos;
import br.edu.uepb.sigeris.enumerations.Estados;
import br.edu.uepb.sigeris.model.Professor;
import br.edu.uepb.sigeris.services.ProfessorService;
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
public class ProfessorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Professor professor;

    @Getter
    @Setter
    private Professor professorSelecionado;

    @Getter
    @Setter
    @Inject
    private ProfessorService professorService;

//    @Getter
//    @Setter
//    @Inject
//    private CursoService cursoService;
    @Getter
    private List<Professor> professores;

    @Getter
    private List<Cursos> todosCursos;
    
    @Getter
    private List<VinculoServidor> categorias;

    @Getter
    private List<Estados> estados;

    public ProfessorBean() {
        professor = new Professor();
        professorSelecionado = new Professor();
    }

    @PostConstruct
    public void init() {
        this.professores = professorService.findAll();
        this.todosCursos = Arrays.asList(Cursos.values());
        this.categorias = Arrays.asList(VinculoServidor.values());
        this.estados = Arrays.asList(Estados.values());
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Professor e salvar.
     *
     */
    public void salvar() {
        professorService.salvar(professor);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de '" + professor.getNome() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("listar-servidores.xhtml");
        this.professor = new Professor();
    }

    /**
     * Método responsável por excluir um objeto do tipo Professor e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.professorService.deletar(professorSelecionado);
        this.professores = professorService.findAll();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.professor.getId() != null;
    }

}
