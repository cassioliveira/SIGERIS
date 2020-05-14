package br.edu.uepb.sigeris.controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.uepb.sigeris.services.PessoaService;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class ImageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@Inject
	private PessoaService pessoaService;

//	@Inject
//	@Getter
//	Security security;
//	
//	private String nomeLocalFotoServidor = security.usuarioLogado();

	/**
	 * Recebe uma String de imagem em base64 e cria um arquivo dessa imagem em pasta
	 * local.
	 * 
	 * @param fotoString
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void decodificarStringImagem(String fotoString) throws IOException, FileNotFoundException {
		byte[] data = Base64.getMimeDecoder().decode(fotoString);

		FileOutputStream fileOutputStream = new FileOutputStream(
				PessoaService.CAMINHO_FOTO_SERVIDORES + pessoaService.nomeLocalFotoServidor + ".jpg");
		fileOutputStream.write(data);// write array of bytes to an image file
		fileOutputStream.close();
	}

//	public void monitorarPaginasApagarImagem() {
//		String url = null;
//
//		if (url != "/SIGERIS/servidor/cadastro-professor.xhtml"
//				|| url != "/SIGERIS/servidor/cadastro-tecnico.xhtml"
//				|| url != "/SIGERIS/servidor/cadastro-terceirizado.xhtml") {
//		
//			FacesContext fc = FacesContext.getCurrentInstance();
//			HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
//			url = request.getRequestURI();
//			
//			System.out.println("***************************** "+url);
//			
//			pessoaService.apagarFotoLocal();
//		}
//
//	}

//	@Getter
//	@Setter
//	private UploadedFile foto;

//	@Getter
//	@Setter
//	private InputStream inputStreamFotoUpload;
//
//	@Getter
//	@Setter
//	private StreamedContent previewFotoUpload;

//	@Getter
//	@Setter
//	private String caminho;
//
//	public void upload(FileUploadEvent event) {
//
//		foto = event.getFile();
//		try {
////			inputStreamFotoUpload = event.getFile().getInputstream();
////			previewFotoUpload = new DefaultStreamedContent(inputStreamFotoUpload);
//
//			Path arquivoTemp = Files.createTempFile(null, null);
//			Files.copy(foto.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
//			setCaminho(arquivoTemp.toString());
//
//			Path origem = Paths.get(caminho);
//			Path destino = Paths.get(CAMINHO_FOTO_SERVIDORES + "foto" + ".jpg");
//
//			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
//
//			PrimeFaces current = PrimeFaces.current();
//			current.executeScript("PF('uploadFoto').hide();"); // Fecha o dialog após o upload
//			current.ajax().update("formLayout:tabContainer:dadosPessoaisComponent:foto");
//
//			FacesUtil.mensagemSucesso("Imagem anexada com sucesso!");
//
//		} catch (IOException e) {
//			FacesUtil.mensagemErro("Ocorreu um erro ao tentar carregar a imagem");
//			e.printStackTrace();
//		}
//	}
//	
//	
//	public StreamedContent teste(String foto) throws Exception {
//
//		DefaultStreamedContent conteudoImagem = null;
//
//		byte[] data = Base64.getMimeDecoder().decode(foto);
//		System.out.println("******* IMAGEM DO BANCO ***********: " + foto);
//		System.out.println("******* IMAGEM DECODIFICADA ***********: " + data);
//
//		// Base64.getDecoder().decode(inputStream.readAllBytes());
//		FileOutputStream fileOutputStream = new FileOutputStream(CAMINHO_FOTO_SERVIDORES + "foto.jpg");
//		System.out.println("******* FILEOUTPUTSTREAM ***********: " + fileOutputStream);
//
//		// write array of bytes to an image file
//		fileOutputStream.write(data);
//
//		// close streams
//		fileOutputStream.close();
//		
//		File fotoSalvaNoDisco = new File(CAMINHO_FOTO_SERVIDORES + "foto.jpg");
//		try {
//			BufferedInputStream imagemInputStream = new BufferedInputStream(new FileInputStream(fotoSalvaNoDisco));
//			byte[] bytes = new byte[imagemInputStream.available()];
//			imagemInputStream.read(bytes);
//			imagemInputStream.close();
//			conteudoImagem = new DefaultStreamedContent(new ByteArrayInputStream(bytes), "image/jpeg");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return conteudoImagem;
//		
////		conteudoImagem = new DefaultStreamedContent(new ByteArrayInputStream(data));
////
////		return conteudoImagem;
//
//	}

}
