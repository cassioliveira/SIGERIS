package br.edu.uepb.sigeris.controllers;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import br.edu.uepb.sigeris.enumerations.Estados;
import br.edu.uepb.sigeris.enumerations.VinculoServidor;
import br.edu.uepb.sigeris.model.Tecnico;
import br.edu.uepb.sigeris.services.PessoaService;
import br.edu.uepb.sigeris.services.TecnicoService;
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
@SessionScoped
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
	@Setter
	@Inject
	private PessoaService pessoaService;

	@Getter
	private List<Tecnico> tecnicos;

	@Getter
	private List<VinculoServidor> vinculos;

	@Getter
	private List<Estados> estados;

	@Getter
	@Setter
	private UploadedFile foto;

	@Getter
	@Setter
	private String fotoEmBase64;

	DefaultStreamedContent conteudoImagem = null;

//	private byte[] fotoDoBanco;

	@Getter
	@Setter
	@Inject
	private ImageBean imageBean;

	public TecnicoBean() {
		tecnico = new Tecnico();
		tecnicoSelecionado = new Tecnico();
	}

	@PostConstruct
	public void init() {
		this.tecnicos = tecnicoService.findAll();
		this.vinculos = Arrays.asList(VinculoServidor.values());
		this.estados = Arrays.asList(Estados.values());

	}

	/**
	 * Método responsável por iniciar uma transação, instanciar um objeto do tipo
	 * Tecnico e salvar.
	 * 
	 * @throws IOException
	 *
	 */
	public void salvar() {
//		if (tecnico.getCaminhoTempFoto() == null) {
//			FacesUtil.mensagemErro("O campo FOTO é obrigatório.");
//			return;
//		}
		tecnico.setFoto(fotoEmBase64);
		tecnicoService.salvar(tecnico);
		if (getEditando()) {
			FacesUtil.mensagemSucesso("Cadastro de '" + tecnico.getNome() + "' atualizado com sucesso!");
		} else {
			FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
		}
		FacesUtil.redirecionaPara("listar-servidores.xhtml");
		this.tecnico = new Tecnico();
	}

//	public void upload(FileUploadEvent evento) {
//		try {
//			UploadedFile arquivoUpload = evento.getFile();
//			Path arquivoTemp = Files.createTempFile(null, null);
//			Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
//			tecnico.setCaminhoTempFoto(arquivoTemp.toString());
//
//			FacesUtil.mensagemSucesso("Upload realizado com sucesso!");
//		} catch (IOException erro) {
//			FacesUtil.mensagemErro("Houve um erro ao tentar realizar o upload de arquivo");
//			erro.printStackTrace();
//		}

//		String nome = evento.getFile().getFileName();
//		String tipo = evento.getFile().getContentType();
//		Long tamanho = evento.getFile().getSize();
//		FacesUtil.mensagemSucesso("Nome: " + nome + "\nTipo: " + tipo + "\nTamanho: " + tamanho);
//		System.out.println("chamou o metodo");
//	}

	/**
	 * Método responsável por excluir um objeto do tipo Tecnico e exibir ao final do
	 * processo uma mensagem informativa.
	 *
	 */
//	public void excluir() {
//		this.tecnicoService.deletar(tecnicoSelecionado);
//		this.tecnicos = tecnicoService.findAll();
//		FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
//	}

	/**
	 * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
	 * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
	 *
	 * @return
	 */
	public boolean getEditando() {
		return this.tecnico.getId() != null;
	}

	public List<String> getSetores() {
		return tecnicoService.setores();
	}

	/**
	 * Faz upload da imagem e converte para String em base64.
	 * 
	 * @param event
	 * @throws Exception
	 */
	public void upload(FileUploadEvent event) throws Exception {
		String fileName = event.getFile().getFileName();

		// Get file extension.
		@SuppressWarnings("unused")
		String extension = "jpg";
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			extension = fileName.substring(i + 1).toLowerCase();
		}

		String encodedImage = java.util.Base64.getEncoder().encodeToString(event.getFile().getContents());
		this.fotoEmBase64 = String.format(encodedImage);
//		this.fotoEmBase64 = String.format("data:image/%s;base64, %s", extension, encodedImage);

		exibirImagemAposUpload();

		FacesUtil.mensagemSucesso("Imagem anexada com sucesso!");
	}

	/**
	 * Retorna imagem após upload e atualiza componente com imagem no formulário.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private void exibirImagemAposUpload() throws IOException, FileNotFoundException {
		imageBean.decodificarStringImagem(fotoEmBase64);

		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('uploadFoto').hide();"); // Fecha o dialog após o upload
		current.ajax().update("formLayout:tabContainer:dadosPessoaisComponent:panelGroupFoto");
//		current.ajax().update("formLayout:tabContainer:dadosPessoaisComponent:foto");
	}

	/**
	 * Chama os métodos para descodificar a imagem em base64 armazenada no banco e
	 * trazer a imagem salva para ser exibida no formulário.
	 * 
	 * @return
	 * @throws Exception
	 */
	public StreamedContent getFotoSalva() {

		try {
			imageBean.decodificarStringImagem(tecnico.getFoto());
		} catch (Exception e) {
			FacesUtil.mensagemErro("Houve um problema ao recuperar a imagem.");
			e.printStackTrace();
		}

		return retornaImagemPastaLocal();
	}

	/**
	 * Lê a pasta de armazenamento local da foto dos servidores e a retorna.
	 * 
	 * @return
	 */
	private StreamedContent retornaImagemPastaLocal() {
		try {
			BufferedInputStream imagemInputStream = new BufferedInputStream(
					new FileInputStream(PessoaService.CAMINHO_FOTO_SERVIDORES + "foto.jpg"));
			byte[] bytes = new byte[imagemInputStream.available()];
			imagemInputStream.read(bytes);
			imagemInputStream.close();
			conteudoImagem = new DefaultStreamedContent(new ByteArrayInputStream(bytes), "image/jpeg");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conteudoImagem;
	}
	
	public String redirecionaCadastroTecnico() {
		pessoaService.apagarFotoLocal();
		this.tecnico = new Tecnico();
		return "cadastro-tecnico?faces-redirect=true";
	}

}
