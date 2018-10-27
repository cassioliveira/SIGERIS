package br.edu.uepb.sigeris.controllers;

import br.edu.uepb.sigeris.model.Pessoa;
import br.edu.uepb.sigeris.model.Reuniao;
import br.edu.uepb.sigeris.reports.GeraRelatorios;
import br.edu.uepb.sigeris.services.PessoaService;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
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

    @Inject
    @Getter
    @Setter
    private PessoaService pessoaService;

    @Getter
    @Setter
    private Reuniao reuniao;

    @Getter
    private List<Pessoa> servidores;

    public ReuniaoBean() {
        this.reuniao = new Reuniao();
    }

    @PostConstruct
    public void init() {
        this.servidores = pessoaService.servidores();
    }

//    public void listaReunioes() throws JRException, IOException{
//        geradorRelatorios.gerarPdf("/frequencia-reuniao.jasper", 
//                tituloDocumento+".pdf", pessoaService.servidores(), tituloDocumento, setor);
//    }
    public void listaReunioes() throws JRException, IOException {
        geradorRelatorios.gerarPdf("/frequencia-reuniao.jasper",
                reuniao.getTituloDocumento() + ".pdf",
                pessoaService.servidores(),
                reuniao.getTituloDocumento(),
                reuniao.getSetor(),
                reuniao.getAtividade(),
                reuniao.getData(),
                reuniao.getHora(),
                reuniao.getLocal(),
                reuniao.getPauta());
    }

    public List<Object> dados() {
        List<Object> dados = new ArrayList<>();

        dados.add(reuniao.getTituloDocumento());
        dados.add(reuniao.getSetor());
        dados.add(reuniao.getAtividade());
        dados.add(reuniao.getData());
        dados.add(reuniao.getHora());
        dados.add(reuniao.getLocal());
        dados.add(reuniao.getPauta());
        dados.add(servidores);

        System.out.println("LISTA COM OS DADOS: " + dados);

        return dados;
    }
}
