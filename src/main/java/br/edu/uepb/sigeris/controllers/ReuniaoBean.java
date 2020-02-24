package br.edu.uepb.sigeris.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.uepb.sigeris.model.Pessoa;
import br.edu.uepb.sigeris.model.Reuniao;
import br.edu.uepb.sigeris.reports.ExecutaRelatorios;
import br.edu.uepb.sigeris.reports.GeraRelatorios;
import br.edu.uepb.sigeris.services.PessoaService;
import br.edu.uepb.sigeris.services.ReuniaoService;
import br.edu.uepb.sigeris.util.jsf.FacesUtil;
import lombok.Getter;
import lombok.Setter;
import net.sf.jasperreports.engine.JRException;

/**
 * Managed bean usado pela página de cadastro de consulta. É responsável por
 * ligar a classe de modelo Consulta à página de visualização processando as
 * solicitações do usuário e retornando os dados à visualização.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Named
@ViewScoped
public class ReuniaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private final GeraRelatorios geradorRelatorios = new GeraRelatorios();

	@Getter
	@Setter
	private String tipoConsulta;

	@Inject
	@Getter
	@Setter
	private ExecutaRelatorios executaRelatorios;

	@Inject
	@Getter
	@Setter
	private PessoaService pessoaService;

	@Getter
	@Setter
	private Reuniao reuniao;

	@Inject
	@Getter
	@Setter
	private ReuniaoService reuniaoService;

	@Getter
	@Setter
	private Reuniao reuniaoSelecionada;

	@Getter
	private List<Reuniao> reunioes;

	public ReuniaoBean() {
		this.reuniao = new Reuniao();
	}

	@PostConstruct
	public void init() {
		this.reunioes = reuniaoService.todos();
		getPessoasCadastradas();
	}

	public void salvar() {
		reuniaoService.salvar(reuniao);
		this.reuniao = new Reuniao();
		FacesUtil.mensagemSucesso("Salvo com sucesso!");
		reunioes = reuniaoService.todos();
	}

	public void excluir() {
		this.reuniaoService.excluir(reuniaoSelecionada);
		this.reunioes = reuniaoService.todos();
		FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
	}

	/**
	 * Retorna uma lista com o NOME de todos o servidores+terceirizados cadastrados,
	 * para seleção.
	 * 
	 * @return
	 */
	public List<String> getPessoasCadastradas() {
		List<String> pessoasCadastradas = new ArrayList<>();
		if (!pessoaService.todos().equals(null)) {
			for (Pessoa pessoa : pessoaService.todos()) {
				pessoasCadastradas.add(pessoa.getNome());
			}
		}
		return pessoasCadastradas;
	}

	/**
	 * Chama o método responsável pela geração dos relatórios, baseados no tipo de
	 * consulta selecionada.
	 * 
	 * @throws SQLException
	 * @throws JRException
	 * @throws IOException
	 */
	public void executaRelatorio() throws SQLException, JRException, IOException {
		executaRelatorios.servidores(tipoConsulta);
	}

	public List<Pessoa> getServidores() {
		return pessoaService.servidores();
	}

	public List<Pessoa> getTecnicos() {
		return pessoaService.tecnicos();
	}

	public List<Pessoa> getProfessores() {
		return pessoaService.professores();
	}

//	public List<Pessoa> getTecnicosContratados() {
//		return pessoaService.tecnicosContratados();
//	}
//
//	public List<Pessoa> getTecnicosEfetivos() {
//		return pessoaService.tecnicosEfetivos();
//	}
//
//	public List<Pessoa> getProfessoresContratados() {
//		return pessoaService.professoresContratados();
//	}
//
//	public List<Pessoa> getProfessoresEfetivos() {
//		return pessoaService.professoresEfetivos();
//	}
//
//	public List<Pessoa> getTerceirizados() {
//		return pessoaService.terceirizados();
//	}
//
//	public List<Pessoa> getTerceirizadosApoio() {
//		return pessoaService.terceirizadosApoio();
//	}
//
//	public List<Pessoa> getTerceirizadosVigilantes() {
//		return pessoaService.terceirizadosVigilantes();
//	}

	public void listaDePresenca() throws JRException, IOException {
		geradorRelatorios.gerarPdfListaReuniao("/reunioes.jasper", reuniao.getTituloDocumento() + ".pdf",
				pessoaService.servidores(), reuniao.getTituloDocumento(), reuniao.getDescricao(), reuniao.getData(),
				reuniao.getHora(), reuniao.getLocal(), reuniao.getPauta());
	}

//	public List<Object> dados() {
//		List<Object> dados = new ArrayList<>();
//
//		dados.add(reuniao.getTituloDocumento());
//		dados.add(reuniao.getSetor());
//		dados.add(reuniao.getDescricao());
//		dados.add(reuniao.getData());
//		dados.add(reuniao.getHora());
//		dados.add(reuniao.getLocal());
//		dados.add(reuniao.getPauta());
//		dados.add(servidores);
//
//		System.out.println("LISTA COM OS DADOS: " + dados);
//
//		return dados;
//	}
}
