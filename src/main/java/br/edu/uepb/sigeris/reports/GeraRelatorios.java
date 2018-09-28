package br.edu.uepb.sigeris.reports;

import br.edu.uepb.sigeris.util.jsf.FacesUtil;
import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class GeraRelatorios {

    /**
     * Captura o caminho completo onde os arquivos de template compilados
     * (.jasper) do relatório se encontram, contanto que este arquivo esteja na
     * pasta resources.
     *
     * @return
     */
    public String caminhoRelatorio() {
        return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/sigeris/relatorios/");
    }

    /**
     * Responsável por receber os parâmetros vindos do arquivo jasper, gerar o
     * relatório e procesar o retorno do mesmo de acordo com as requisições HTTP
     * vindas da camada de apresentação. Depois exporta o relatório para o
     * formato PDF antes de apresentar o mesmo no browser.
     *
     * @param jasperFileName
     * @param pdfFileName
     * @param dados
     * @param titulo
     * @param localizacao
     * @throws JRException
     * @throws IOException
     */
    public void gerarPdf(String jasperFileName, String pdfFileName, List<?> dados,
            String titulo, String localizacao) throws JRException, IOException {

        Map<String, Object> parametros = new HashMap<>();
        String uepb = FacesUtil.caminhoContexto("/resources/sigeris/imagens/relatorio-uepb.png");
        String cche = FacesUtil.caminhoContexto("/resources/sigeris/imagens/relatorio-cche.png");
        parametros.put("uepb", uepb);
        parametros.put("cche", cche);
        String caminhoArquivoJasper = caminhoRelatorio() + jasperFileName;
        parametros.put("titulo", titulo);
        parametros.put("localizacao", localizacao);

        JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoArquivoJasper, parametros, new JRBeanCollectionDataSource(dados));
        HttpServletResponse response = (HttpServletResponse) FacesUtil.responseHTTP();
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=".concat(pdfFileName));

        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }
}
