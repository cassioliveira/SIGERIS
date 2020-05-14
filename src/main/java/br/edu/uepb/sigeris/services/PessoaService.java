package br.edu.uepb.sigeris.services;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import br.edu.uepb.sigeris.model.Pessoa;
import br.edu.uepb.sigeris.repository.Pessoas;
import br.edu.uepb.sigeris.util.jsf.FacesUtil;

/**
 * Possui metodos comuns a todas as entidades que herdam de <b>Pessoa</b>
 *
 * @see Pessoa
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class PessoaService implements Serializable {

	private static final long serialVersionUID = 1L;

	public static String CAMINHO_FOTO_SERVIDORES = System.getProperty("java.io.tmpdir"+"/");
//	public static String CAMINHO_FOTO_SERVIDORES = "/home/cassio/servers/uploads/";

	public Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();//Pega o Objeto que contém o usuário logado.
	
	public String nomeLocalFotoServidor = ((UserDetails) principal).getUsername();

	@Inject
	private Pessoas pessoas;

	/**
	 * Verifica se o ID da pessoa já existe, indicando se é um novo cadastro.
	 *
	 * @param entidade
	 * @return
	 */
	public boolean novoCadastro(Pessoa entidade) {
		return entidade.getId() == null;
	}

	public List<Pessoa> servidores() {
		return pessoas.consulta("Servidores.todos");
	}

	public List<Pessoa> tecnicos() {
		return pessoas.consulta("Tecnicos.todos");
	}

	public List<Pessoa> professores() {
		return pessoas.consulta("Professores.todos");
	}

	/**
	 * Responsável por retornar o caminho da tela de edição de acordo com o tipo de
	 * servidor selecionado, dentre PROFESSOR e TECNICO.
	 *
	 * @param pessoa
	 * @return
	 */
	public String direcionaParaEdicao(Pessoa pessoa) {
		String pagina;
		switch (pessoa.getCategoria()) {
		case "PROFESSOR":
			pagina = "/servidor/cadastro-professor";
			break;
		case "TECNICO":
			pagina = "/servidor/cadastro-tecnico";
			break;
		default:
			pagina = "";
			break;
		}
		return pagina;
	}

	public List<Pessoa> chamaConsulta(String tipoConsulta) {
		List<Pessoa> listaServidores = null;
		switch (tipoConsulta) {
		case "servidores":
			listaServidores = pessoas.consulta("Servidores.todos");
			break;
		case "tecnicos":
			listaServidores = pessoas.consulta("Tecnicos.todos");
			break;
		case "tcontratados":
			listaServidores = pessoas.consulta("TecnicosContratados.todos");
			break;
		case "tefetivos":
			listaServidores = pessoas.consulta("TecnicosEfetivos.todos");
			break;
		case "professores":
			listaServidores = pessoas.consulta("Professores.todos");
			break;
		case "pcontratados":
			listaServidores = pessoas.consulta("ProfessoresContratados.todos");
			break;
		case "pefetivos":
			listaServidores = pessoas.consulta("ProfessoresEfetivos.todos");
			break;
		case "terceirizados":
			listaServidores = pessoas.consulta("Terceirizados.todos");
			break;
		case "apoio":
			listaServidores = pessoas.consulta("TerceirizadosApoio.todos");
			break;
		case "vigilantes":
			listaServidores = pessoas.consulta("TerceirizadosVigilantes.todos");
			break;
		default:
			break;
		}
		return listaServidores;
	}

//	/**
//	 * @param tecnico
//	 * @param retorno
//	 */vice.C
//	public void salvaImagemPastaDestino(Tecnico tecnico, Tecnico retorno){
//		try {
//			Path origem = Paths.get(tecnico.getCaminhoTempFoto());
//			Path destino = Paths.get(CAMINHO_FOTO_SERVIDORES + retorno.getId() + ".jpg");
//			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	@Transactional
	public void excluir(Pessoa pessoa) {
		try {
			Pessoa pessoaSelecionada = findById(pessoa.getId());
			pessoas.excluir(pessoaSelecionada);
//			Path arquivo = Paths.get(PessoaService.CAMINHO_FOTO_SERVIDORES + pessoaSelecionada.getId() + ".jpg");
//			Files.deleteIfExists(arquivo);
		} catch (RuntimeException e) {
			FacesUtil.mensagemErro("Ocorreu um erro ao excluir o cadastro");
			e.printStackTrace();
		}
	}

	public Pessoa findById(Long id) {
		return pessoas.porId(id);
	}

	public List<Pessoa> todos() {
		return pessoas.todos();
	}

	public void apagarFotoLocal() {
		File file = new File(CAMINHO_FOTO_SERVIDORES + nomeLocalFotoServidor + ".jpg");
		file.delete();
	}

//	/**
//	 * Responsável por ler a imagem na pasta selecionada e a retornar com um
//	 * StreamedContent para exibir no GraphicImage.
//	 * 
//	 * @return
//	 * @throws Exception 
//	 */
//	public StreamedContent fotoSalva(String stringFotoBanco, String caminhoFotoDecodificada) throws Exception {
//		
//		decodeImage(stringFotoBanco, caminhoFotoDecodificada);
//		
//		File fotoSalvaNoDisco = new File(CAMINHO_FOTO_SERVIDORES + "foto.jpg");
//		DefaultStreamedContent conteudoImagem = null;
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
//	}

//	/**
//	 * Responsável por ler a imagem na pasta selecionada e a retornar com um
//	 * StreamedContent para exibir no GraphicImage.
//	 * 
//	 * @return
//	 * @throws Exception 
//	 */
//	public StreamedContent fotoSalva() throws Exception {
//		File fotoSalvaNoDisco = new File(CAMINHO_FOTO_SERVIDORES + "foto.jpg");
//		DefaultStreamedContent conteudoImagem = null;
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
//	}

//	 //decode image from base64 string stored in a file to an image
//    private static void decodeImage(String stringFotoBanco, String caminhoFotoDecodificada) throws Exception{
//
//        // read from text file
////        FileInputStream inputStream = new FileInputStream(txtPath);
//
//        byte[] data = Base64.getMimeDecoder().decode(stringFotoBanco);
//
//        // Base64.getDecoder().decode(inputStream.readAllBytes());
//        FileOutputStream fileOutputStream = new FileOutputStream(caminhoFotoDecodificada);
//
//        // write array of bytes to an image file
//        fileOutputStream.write(data);
//
//        // close streams
//        fileOutputStream.close();
//    }
}
