package br.edu.uepb.sigeris.reports;

import br.edu.uepb.sigeris.controllers.ReuniaoBean;
import br.edu.uepb.sigeris.services.PessoaService;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import net.sf.jasperreports.engine.JRException;

/**
 * Emite o relatório baseado em métodos presentes na classe
 * <b>GeraRelatorios</b> e que fazem a conexão com o banco de dados e tratam os
 * dados para gerar os relatórios. Ao chamar essa classe utilitária de geração
 * de relatórios, dois parâmetros são passados, onde o primeiro refere-se ao
 * nome do arquivo de template de relatório compilado (.jasper) e o segundo ao
 * nome do relatório em PDF que o usuário visualizará. Cada método dessa classe
 * representa a chamada a um relatorio diferente
 *
 * @see GeraRelatorios
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Named
@ViewScoped
public class ExecutaRelatorios implements Serializable {

	private static final long serialVersionUID = 1L;

	private final GeraRelatorios geradorRelatorios = new GeraRelatorios();

    @Inject
    @Getter
    @Setter
    private PessoaService pessoaService;
    
    @Inject
    @Getter
    @Setter
    private ReuniaoBean reuniaoBean;

    /**
     * Retorna o relatório de PROFESSORES, TÉCNICOS ou ambos de acordo com tipo
     * selecionado
     *
     * @param tipo
     * @throws java.sql.SQLException
     * @throws net.sf.jasperreports.engine.JRException
     * @throws java.io.IOException
     */
    public void servidores(String tipo) throws SQLException, JRException, IOException {
    	String titulo = null;
    	String pdfFileName = null;
        String jasperFileName = "/servidores.jasper";
        List<?> dados = pessoaService.chamaConsulta(tipo);
            switch (tipo) {
                case "servidores":
                	titulo = "Todos os servidores";
                	pdfFileName = titulo+".pdf";
                	new DadosParaPDFDePessoas( titulo,"/servidores.jasper", pdfFileName, dados);
                    break;
                case "professores":
                	titulo = "Todos os professores";
                	pdfFileName = titulo+".pdf";
                	new DadosParaPDFDePessoas( titulo,"/servidores.jasper", pdfFileName, dados);
                    break;
                case "tecnicos":
                    titulo = "Todos os técnicos";
                    pdfFileName = titulo+".pdf";
                    new DadosParaPDFDePessoas( titulo,"/servidores.jasper", pdfFileName, dados);
                    break;
                case "tcontratados":
                	titulo = "Técnicos contratados";
                	pdfFileName = titulo+".pdf";
                	new DadosParaPDFDePessoas( titulo,"/servidores.jasper", pdfFileName, dados);
                    break;
                case "tefetivos":
                	titulo = "Técnicos efetivos";
                	pdfFileName = titulo+".pdf";
                	new DadosParaPDFDePessoas( titulo,"/servidores.jasper", pdfFileName, dados);
                    break;
                case "pcontratados":
                	titulo = "Professores contratados";
                	pdfFileName = titulo+".pdf";
                	new DadosParaPDFDePessoas( titulo,"/servidores.jasper", pdfFileName, dados);
                    break;
                case "pefetivos":
                	titulo = "Professores efetivos";
                	pdfFileName = titulo+".pdf";
                	new DadosParaPDFDePessoas( titulo,"/servidores.jasper", pdfFileName, dados);
                    break;
                case "terceirizados":
                	titulo = "Todos os terceirizados";
                	pdfFileName = titulo+".pdf";
                	new DadosParaPDFDePessoas( titulo,"/servidores.jasper", pdfFileName, dados);
                    break;
                case "apoio":
                	titulo = "Terceirizados APOIO";
                	pdfFileName = titulo+".pdf";
                	new DadosParaPDFDePessoas( titulo,"/servidores.jasper", pdfFileName, dados);
                    break;
                case "vigilantes":
                	titulo = "Terceirizados VIGILANTES";
                	pdfFileName = titulo+".pdf";
                	new DadosParaPDFDePessoas( titulo,"/servidores.jasper", pdfFileName, dados);
                    break;
                default:
                    break;
            }
        geradorRelatorios.gerarPdfPessoas(jasperFileName, pdfFileName, dados, titulo);
    }

//    public void listaReunioes() throws JRException, IOException{
//        geradorRelatorios.gerarPdf("/frequencia-reuniao.jasper", "Lista de presença.pdf", pessoaService.servidores(), "Lista de presença", "Coordenação de extensão");
//    }
}
