//package br.edu.uepb.sigeris.controllers;
//
//import br.edu.uepb.sigeris.enumerations.CategoriasServidor;
//import br.edu.uepb.sigeris.enumerations.Estados;
//import br.edu.uepb.sigeris.model.Curso;
//import br.edu.uepb.sigeris.services.CursoService;
//import br.edu.uepb.sigeris.util.jsf.FacesUtil;
//import java.io.Serializable;
//import java.util.Arrays;
//import java.util.List;
//import javax.annotation.PostConstruct;
//import javax.faces.view.ViewScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//import lombok.Getter;
//import lombok.Setter;
//
///**
// * Managed bean usado pela página de cadastro de consulta. É responsável por
// * ligar a classe de modelo Consulta à página de visualização processando as
// * solicitações do usuário e retornando os dados à visualização.
// *
// * @author Cássio Oliveira <cassio@cassioliveira.com.br>
// */
//@Named
//@ViewScoped
//public class CursoBean implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Getter
//    @Setter
//    private Curso curso;
//
//    @Getter
//    @Setter
//    private Curso cursoSelecionado;
//
//    @Getter
//    @Setter
//    @Inject
//    private CursoService cursoService;
//
//    @Getter
//    private List<Curso> cursos;
//
//    @Getter
//    private List<Estados> estados;
//
//    public CursoBean() {
//        curso = new Curso();
//        cursoSelecionado = new Curso();
//    }
//
//    @PostConstruct
//    public void init() {
//        this.cursos = cursoService.todos();
//    }
//
//    /**
//     * Método responsável por iniciar uma transação, instanciar um objeto do
//     * tipo Curso e salvar.
//     *
//     */
//    public void salvar() {
//        cursoService.salvar(curso);
//        this.curso = new Curso();
//        FacesUtil.mensagemSucesso("Salvo com sucesso!");
//        cursos = cursoService.todos();
//    }
//
//    /**
//     * Método responsável por excluir um objeto do tipo Curso e exibir ao
//     * final do processo uma mensagem informativa.
//     *
//     */
//    public void excluir() {
//        this.cursoService.excluir(cursoSelecionado);
//        this.cursos = cursoService.todos();
//        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
//    }
//
//    /**
//     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
//     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
//     *
//     * @return
//     */
//    public boolean getEditando() {
//        return this.curso.getId() != null;
//    }
//
//}
