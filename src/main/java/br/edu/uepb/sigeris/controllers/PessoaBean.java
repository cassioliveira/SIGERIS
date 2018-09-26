package br.edu.uepb.sigeris.controllers;

import br.edu.uepb.sigeris.model.Pessoa;
import br.edu.uepb.sigeris.services.PessoaService;
import br.edu.uepb.sigeris.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
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
public class PessoaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Getter
    @Setter
    private Pessoa pessoa;
    
    @Getter
    @Setter
    private Pessoa pessoaSelecionada;
    
    @Inject
    private PessoaService pessoaService;
    
    public PessoaBean(){
        this.pessoa = new Pessoa();
        this.pessoaSelecionada = new Pessoa();
    }
    
    public List<Pessoa> getServidores(){
        return pessoaService.servidores();
    }
    
     /**
     * Define qual tela de cadastro será aberta para edição ou visualização de
     * acordo com o tipo de servidor a ser editado.
     *
     * @param pessoa
     * @return
     */
    public String telaEdicaoServidor(Pessoa pessoa) {
        return pessoaService.direcionaParaEdicao(pessoa);
    }

    
    public void excluir(){
        pessoaService.excluir(pessoaSelecionada);
        getServidores();
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }
}
