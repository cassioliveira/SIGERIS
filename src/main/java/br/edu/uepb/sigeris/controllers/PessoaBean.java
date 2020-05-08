package br.edu.uepb.sigeris.controllers;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import br.edu.uepb.sigeris.model.Pessoa;
import br.edu.uepb.sigeris.model.Tecnico;
import br.edu.uepb.sigeris.services.PessoaService;
import br.edu.uepb.sigeris.util.jsf.FacesUtil;
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

//	@Inject
//	@Getter
//	@Setter
//	ImageBean imageBean;

	@Getter
	@Setter
	private UploadedFile foto;

	@Getter
	StreamedContent st;

	@Getter
	@Setter
	private InputStream inputStreamFotoUpload;

	@Getter
	@Setter
	private StreamedContent previewFotoUpload;

	@Getter
	@Setter
	private String caminho;

	public PessoaBean() {
		this.pessoa = new Pessoa();
		this.pessoaSelecionada = new Pessoa();
	}

	public List<Pessoa> getServidores() {
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

	public void excluir() {
		pessoaService.excluir(pessoaSelecionada);
		getServidores();
		FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
	}
	
	public void apagarFotoLocal() {
		pessoaService.apagarFotoLocal();
	}
	
	/**
	 * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
	 * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
	 *
	 * @return
	 */
	public boolean getEditando() {
		return this.pessoa.getId() != null;
	}

//	public void upload(FileUploadEvent event) {
//
//		foto = event.getFile();
//		try {
//			inputStreamFotoUpload = event.getFile().getInputstream();
//			previewFotoUpload = new DefaultStreamedContent(inputStreamFotoUpload);
//
//			Path arquivoTemp = Files.createTempFile(null, null);
//			Files.copy(foto.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
//			setCaminho(arquivoTemp.toString());
//
//			Path origem = Paths.get(caminho);
//			Path destino = Paths.get("/home/cassio/servers/uploads/" + "foto" + ".jpg");
//
//			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
//
//			PrimeFaces current = PrimeFaces.current();
//			current.executeScript("PF('uploadFoto').hide();"); // Fecha o dialog após o upload
//			current.ajax().update("formLayout:tabContainer:dadosPessoaisComponent:foto");
//			
//			this.pessoa.setFoto(IOUtils.toByteArray(event.getFile().getInputstream()));
//			imageBean.uploadImagem(this.pessoa.getFoto());
//			
//		} catch (IOException e) {
//			FacesUtil.mensagemErro("Ocorreu um erro ao tentar carregar a imagem");
//			e.printStackTrace();
//		}
//	}
}
