package br.edu.uepb.sigeris.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import br.edu.uepb.sigeris.model.Pessoa;
import br.edu.uepb.sigeris.model.Reuniao;
import br.edu.uepb.sigeris.model.Setor;
import br.edu.uepb.sigeris.reports.ExecutaRelatorios;
import br.edu.uepb.sigeris.services.PessoaService;
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

	@Getter
	@Setter
	private Reuniao reuniao;

	// INICIO ATRIBUTOS LISTA DE PRESENÇA

	@Getter
	@Setter
	private String tituloDocumento;

	@Getter
	@Setter
	@NotNull(message = "Informe o setor responsável")
	private Setor setor;

	@Getter
	@Setter
	@NotNull(message = "Informe a descrição")
	private String descricao;

	@Getter
	@Setter
	@NotNull(message = "Informe o local")
	private String local;

	@Getter
	@Setter
	@NotNull(message = "Informe a data")
	private Date data;

	@Getter
	@Setter
	@NotNull(message = "Informe a hora")
	private Date hora;

	@Getter
	@Setter
	private String pauta;

	@Getter
	@Setter
	private List<Pessoa> pessoas;

	// FIM ATRIBUTOS LISTA DE PRESENÇA

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
	private List<Pessoa> pessoasCadastradas;

//
//	@Inject
//	@Getter
//	@Setter
//	private ReuniaoService reuniaoService;
//
//	@Getter
//	@Setter
//	private Reuniao reuniaoSelecionada;
//
//	@Getter
//	private List<Reuniao> reunioes;
//
	public ReuniaoBean() {
		this.reuniao = new Reuniao();
	}

//
	@PostConstruct
	public void init() {
		this.pessoasCadastradas = pessoaService.todos();
//		this.reunioes = reuniaoService.todos();
//		getPessoasCadastradas();
	}
//
//	public void salvar() {
//		reuniaoService.salvar(reuniao);
//		this.reuniao = new Reuniao();
//		FacesUtil.mensagemSucesso("Salvo com sucesso!");
//		reunioes = reuniaoService.todos();
//	}
//
//	public void excluir() {
//		this.reuniaoService.excluir(reuniaoSelecionada);
//		this.reunioes = reuniaoService.todos();
//		FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
//	}

	/**
	 * Retorna uma lista com o NOME de todos o servidores+terceirizados cadastrados,
	 * para seleção.
	 * 
	 * @return
	 */
//	public List<String> getPessoasCadastradas() {
//		List<String> pessoasCadastradas = new ArrayList<>();
//		if (!pessoaService.todos().equals(null)) {
//			for (Pessoa pessoa : pessoaService.todos()) {
//				pessoasCadastradas.add(pessoa.getNome());
//			}
//		}
//		return pessoasCadastradas;
//	}

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

	public void geraListaPresenca() throws JRException, IOException {
		System.out.println("************* PRINT DO Gera Relatório *******************");
		System.out.println(getSetor());
		System.out.println(getDescricao());
		System.out.println(getData());
		System.out.println(getHora());
		System.out.println(getLocal());
		System.out.println(getPauta());
		System.out.println(getPessoas());
		executaRelatorios.listaReunioes(getSetor(), getDescricao(), getData(), getHora(), getLocal(), getPauta(),
				getPessoas());
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

//	public void listaDePresenca() throws JRException, IOException {
//		geradorRelatorios.gerarPdfListaReuniao("/reunioes.jasper", getTituloDocumento() + ".pdf",
//				pessoaService.servidores(), getTituloDocumento(), getDescricao(), getData(), getHora(), getLocal(),
//				getPauta());
//	}

//	public void listaDePresenca() throws JRException, IOException {
//		geradorRelatorios.gerarPdfListaReuniao("/reunioes.jasper", reuniao.getTituloDocumento() + ".pdf",
//				pessoaService.servidores(), reuniao.getTituloDocumento(), reuniao.getDescricao(), reuniao.getData(),
//				reuniao.getHora(), reuniao.getLocal(), reuniao.getPauta());
//	}

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