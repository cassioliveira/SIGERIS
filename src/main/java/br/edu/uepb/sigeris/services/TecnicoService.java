package br.edu.uepb.sigeris.services;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.edu.uepb.sigeris.model.Tecnico;
import br.edu.uepb.sigeris.repository.Tecnicos;
import br.edu.uepb.sigeris.security.Security;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class TecnicoService implements Serializable {

	private static final long serialVersionUID = 1L;

//	public static String CAMINHO_FOTO_SERVIDORES = "/home/cassio/servers/uploads/";

	Tecnico retorno;

	@Inject
	private Tecnicos tecnicos;

	@Inject
	private PessoaService pessoaService;

	@Inject
	private SetorService setorService;

	@Inject
	private Security security;

	@Transactional
	public Tecnico salvar(Tecnico tecnico) {
		try {
			if (novoCadastro(tecnico)) {
				tecnico.setCategoria("TECNICO");
				tecnico.setDataCadastro(new Date());
			}
			tecnico.setUsuario(security.usuarioLogado());
			tecnico.setDataUltimaAtualizacao(new Date());
			retorno = (Tecnico) this.tecnicos.salvar(tecnico);
			pessoaService.apagarFotoLocal();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		pessoaService.salvaImagemPastaDestino(tecnico, retorno);

		return retorno;
	}

//	/**
//	 * Read the file and returns the byte array
//	 * 
//	 * @param file
//	 * @return the bytes of the file
//	 */
//	private byte[] readFile(String file) {
//		ByteArrayOutputStream bos = null;
//		try {
//			File f = new File(file);
//			FileInputStream fis = new FileInputStream(f);
//			byte[] buffer = new byte[1024];
//			bos = new ByteArrayOutputStream();
//			for (int len; (len = fis.read(buffer)) != -1;) {
//				bos.write(buffer, 0, len);
//			}
//		} catch (FileNotFoundException e) {
//			System.err.println(e.getMessage());
//		} catch (IOException e2) {
//			System.err.println(e2.getMessage());
//		}
//		return bos != null ? bos.toByteArray() : null;
//	}

	public Tecnico findById(Long id) {
		return tecnicos.porId(id);
	}

	public List<Tecnico> findAll() {
		return tecnicos.todos();
	}

	/**
	 * Verifica se o ID do servidor já existe, indicando se é um novo cadastro.
	 *
	 * @param tecnico
	 * @return
	 */
	public boolean novoCadastro(Tecnico tecnico) {
		return pessoaService.novoCadastro(tecnico);
	}

	public List<String> setores() {
		return setorService.servidores();
	}

}
