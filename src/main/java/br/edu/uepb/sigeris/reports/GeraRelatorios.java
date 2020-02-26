package br.edu.uepb.sigeris.reports;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import br.edu.uepb.sigeris.model.Setor;
import br.edu.uepb.sigeris.util.jsf.FacesUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class GeraRelatorios {

	/**
	 * Captura o caminho completo onde os arquivos de template compilados (.jasper)
	 * do relatório se encontram, contanto que este arquivo esteja na pasta
	 * resources.
	 *
	 * @return
	 */
	public String caminhoRelatorio() {
		return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/sigeris/relatorios/");
	}

	/**
	 * Responsável por gerar a lista com os servidores e funcionarios cadastrados.
	 * @param jasperFileName
	 * @param pdfFileName
	 * @param dados
	 * @param titulo
	 * @throws JRException
	 * @throws IOException
	 */
	public void gerarPdfPessoas(String jasperFileName, String pdfFileName, List<?> dados, String titulo)
			throws JRException, IOException {

		Map<String, Object> parametros = new HashMap<>();
		String uepb = FacesUtil.caminhoContexto("/resources/sigeris/imagens/relatorio-uepb.png");
		String cche = FacesUtil.caminhoContexto("/resources/sigeris/imagens/relatorio-cche.png");
		parametros.put("uepb", uepb);
		parametros.put("cche", cche);
		String caminhoArquivoJasper = caminhoRelatorio() + jasperFileName;
		parametros.put("titulo", titulo);

		processarRelatorio(dados, parametros, caminhoArquivoJasper, pdfFileName);
	}

	/**
	 * Responsável por gerar o PDF para a lista de reuniões
	 *
	 * @param jasperFileName
	 * @param pdfFileName
	 * @param dados
	 * @param titulo
	 * @param setor
	 * @param descricao
	 * @param data
	 * @param hora
	 * @param local
	 * @param pauta
	 * @throws JRException
	 * @throws IOException
	 */
	public void gerarPdfListaReuniao(String jasperFileName, String pdfFileName, List<?> dados, String titulo, Setor setor,
			String descricao, Date data, Date hora, String local, String pauta) throws JRException, IOException {

		Map<String, Object> parametros = new HashMap<>();
		String uepb = FacesUtil.caminhoContexto("/resources/sigeris/imagens/relatorio-uepb.png");
		String cche = FacesUtil.caminhoContexto("/resources/sigeris/imagens/relatorio-cche.png");
		parametros.put("uepb", uepb);
		parametros.put("cche", cche);
		String caminhoArquivoJasper = caminhoRelatorio() + jasperFileName;
		parametros.put("titulo", titulo);
		parametros.put("setor", setor);
		parametros.put("atividade", descricao);
		parametros.put("data", data);
		parametros.put("hora", hora);
		parametros.put("local", local);
		parametros.put("pauta", pauta);
		
		System.out.println("************* PRINT DO Gera Relatório *******************");
		System.out.println(titulo);
		System.out.println(setor);
		System.out.println(descricao);
		System.out.println(data);
		System.out.println(hora);
		System.out.println(local);
		System.out.println(pauta);
		System.out.println(dados);

		processarRelatorio(dados, parametros, caminhoArquivoJasper, pdfFileName);
	}

	/**
	 * Pega os dados informados e os processa para gerar o arquivo PDF
	 * @param dados
	 * @param parametros
	 * @param caminhoArquivoJasper
	 * @throws JRException
	 * @throws IOException
	 */
	private void processarRelatorio(List<?> dados, Map<String, Object> parametros, String caminhoArquivoJasper,String pdfFileName)
			throws JRException, IOException {
		JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoArquivoJasper, parametros,
				new JRBeanCollectionDataSource(dados));
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
