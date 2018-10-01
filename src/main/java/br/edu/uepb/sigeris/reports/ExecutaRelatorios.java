package br.edu.uepb.sigeris.reports;

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

    private final GeraRelatorios geradorRelatorios = new GeraRelatorios();

    @Inject
    @Getter
    @Setter
    private PessoaService pessoaService;

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
        String jasperFileName = "/servidores.jasper";
        String pdfFileName = null;
        List<?> dados = null;
        String titulo = null;
        String setor = null;
        if (null != tipo) {
            switch (tipo) {
                case "SERVIDORES":
                    titulo = "Servidores cadastrados";
                    pdfFileName = titulo + ".pdf";
                    setor = "Direção";
                    dados = pessoaService.servidores();
                    break;
                case "PROFESSORES":
                    titulo = "Professores cadastrados";
                    pdfFileName = titulo + ".pdf";
                    setor = "Coordençaõ de matemática";
                    dados = pessoaService.professores();
                    break;
                case "TECNICOS":
                    titulo = "Técnicos cadastrados";
                    pdfFileName = titulo + ".pdf";
                    setor = "Coordençaõ de letras";
                    dados = pessoaService.tecnicos();
                    break;
                default:
                    break;
            }
        }
        geradorRelatorios.gerarPdf(jasperFileName, pdfFileName, dados, titulo, setor);
    }
    
    public void listaReunioes() throws JRException, IOException{
        geradorRelatorios.gerarPdf("/frequencia-reuniao.jasper", "Lista de presença.pdf", pessoaService.servidores(), "Lista de presença", "Coordenação de extensão");
    }
}
