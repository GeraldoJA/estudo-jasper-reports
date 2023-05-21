package com.geraldo.report.relatorio;

import java.io.InputStream;
import java.util.List;

import com.geraldo.entidade.Aluno;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {
	
	public void gerarRelatorio( List<Aluno> lista) throws JRException {
		
		InputStream fonte = Relatorio.class.getResourceAsStream("/com/geraldo/report/arquivos/relatorio.jrxml");  //carregar o arquivo
		
		JasperReport report = JasperCompileManager.compileReport(fonte);  //compila o JasperReport e trata a exceção JRException
		
		JasperPrint print = JasperFillManager.fillReport
				(report, null, new JRBeanCollectionDataSource(lista) );   //2º parametro tipo como se fosse passar uma imagem, exemplo de uma logo, 
				                                                          //seria uma referencia HashMap (chave e valor), passa o nome e o caminho da imagem 
																	      //3º parametro transforma a lita em um datasource
		
		JasperViewer.viewReport(print, false);     //método para exibição. o false é para que a aplicação continuar ligada se fechar o reltório
	}

}
