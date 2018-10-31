package br.edu.uepb.sigeris.controllers;

import br.edu.uepb.sigeris.enumerations.CategoriasServidor;
import br.edu.uepb.sigeris.enumerations.Estados;
import br.edu.uepb.sigeris.model.Usuario;
import br.edu.uepb.sigeris.services.UsuarioService;
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
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Usuario usuario;

    @Getter
    @Setter
    private Usuario usuarioSelecionado;

    @Getter
    @Setter
    @Inject
    private UsuarioService usuarioService;

    @Getter
    private List<Usuario> usuarios;

    public UsuarioBean() {
        usuario = new Usuario();
        usuarioSelecionado = new Usuario();
    }

    @PostConstruct
    public void init() {
        this.usuarios = usuarioService.todos();
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Usuario e salvar.
     *
     */
    public void salvar() {
        usuarioService.salvar(usuario);
        this.usuario = new Usuario();
        FacesUtil.mensagemSucesso("Salvo com sucesso!");
        usuarios = usuarioService.todos();
    }

    /**
     * Método responsável por excluir um objeto do tipo Usuario e exibir ao
     * final do processo uma mensagem informativa.
     *
     */
    public void excluir() {
        this.usuarioService.excluir(usuarioSelecionado);
        this.usuarios = usuarioService.todos();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.usuario.getId() != null;
    }
    
}
