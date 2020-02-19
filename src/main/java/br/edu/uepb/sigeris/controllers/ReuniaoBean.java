package br.edu.uepb.sigeris.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.uepb.sigeris.model.Pessoa;
import br.edu.uepb.sigeris.model.Reuniao;
import br.edu.uepb.sigeris.services.PessoaService;
import br.edu.uepb.sigeris.services.ReuniaoService;
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
public class ReuniaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

//	private final GeraRelatorios geradorRelatorios = new GeraRelatorios();

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

//	@Getter
//	private List<Pessoa> pessoasCadastradas;

	@Getter
	private List<Reuniao> reunioes;

	public ReuniaoBean() {
		this.reuniao = new Reuniao();
	}

	@PostConstruct
	public void init() {
		this.reunioes = reuniaoService.todos();
		getPessoasCadastradas();
//		this.pessoasCadastradas = pessoaService.todos();
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

	public List<String> getPessoasCadastradas() {
		List<String> pessoasCadastradas = new ArrayList<>();
		if (!pessoaService.todos().equals(null)) {
			for (Pessoa pessoa : pessoaService.todos()) {
				pessoasCadastradas.add(pessoa.getNome());
			}
		}
		return pessoasCadastradas;
	}

//	public void listaDePresenca() throws JRException, IOException {
//		geradorRelatorios.gerarPdf("/reunioes.jasper", reuniao.getTituloDocumento() + ".pdf",
//				pessoaService.servidores(), reuniao.getTituloDocumento(), reuniao.getSetor().getNome(),
//				reuniao.getDescricao(), reuniao.getData(), reuniao.getHora(), reuniao.getLocal(), reuniao.getPauta());
//	}
//
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
