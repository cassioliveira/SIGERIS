package br.edu.uepb.sigeris.reports;

import java.util.List;

public class DadosParaPDFDePessoas {

	String titulo;
	String jasperFileName;
    String pdfFileName;
    List<?> dados;
    
	public DadosParaPDFDePessoas( String titulo, String jasperFileName, String pdfFileName, List<?> dados) {
		super();
		this.titulo = titulo;
		this.jasperFileName = jasperFileName;
		this.pdfFileName = pdfFileName;
		this.dados = dados;
	}
	
}
