package com.geraldo.exemplo.grafico.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.geraldo.exemplo.grafico.dto.AbastecimentoDTO;
import com.geraldo.exemplo.grafico.report.control.Relatorio;

import net.sf.jasperreports.engine.JRException;


/**
 * 
 * Classe para acessos aos serviços referente à entidade Abastecimento.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
public class AbastecimentoService {
	
	public void gerarRelatorio() {
		
		List<AbastecimentoDTO> listaAbastecimentoDTO = criarAbastecimentoDTO();
		HashMap<String,Object> params = this.resumoAbastecimento();
		
		Relatorio relatorio =  new Relatorio();
		try {
			relatorio.gerarRelatorio(listaAbastecimentoDTO, params);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Armazena os valores totais de cada tipo em uma respectiva key 
	 * do HashMap. Usado no relatório do JasperReport.
	 * 
	 * @return HashMap<String,Object>
	 */
	private HashMap<String,Object> resumoAbastecimento() {
					
		HashMap<String,Object> params = new HashMap<String,Object>();						
	
		double totalVendidoGasolina = 0.0;
		List<AbastecimentoDTO> listA = criarAbastecimentoDTO();
		for (AbastecimentoDTO a : listA) {	
			totalVendidoGasolina += a.getValorGasto();
		}
		
		params.put( "totalLitrosGasolina", 
				"Litros de GASOLINA: " + 40.0 );
		params.put( "totalVendidoGasolina", 
				"Faturamento de GASOLINA: " + new DecimalFormat(".##").format(totalVendidoGasolina) );

		return params;
	}
	
	/**
	 * Cria uma lista de classes AbastecimentoDTO
	 * AbastecimentoDTO é modelada para facilitar a impressão dos dados no relatório.
	 * 
	 * @return listaAbastecimentoDTO - List<AbastecimentoDTO>
	 */
	private List<AbastecimentoDTO> criarAbastecimentoDTO() {

		List<AbastecimentoDTO> listaAbastecimentoDTO = new ArrayList<AbastecimentoDTO>();

		AbastecimentoDTO dto1 = new AbastecimentoDTO();
		dto1.setData("07/06/23");
		dto1.setPlaca("AAA1111");
		dto1.setInfoCarro("Fiat Uno, placa" + dto1.getPlaca());
		dto1.setValorGasto( 29.0 );
		dto1.setDescricao("Abasteceu 10.0 de litros de GASOLINA_COMUM");
		listaAbastecimentoDTO.add(dto1);
		
		AbastecimentoDTO dto2 = new AbastecimentoDTO();
		dto2.setData("07/06/23");
		dto2.setPlaca("BBB2222");
		dto2.setInfoCarro("Fiat Palio,, placa" + dto2.getPlaca());
		dto2.setValorGasto( 45.4 );
		dto2.setDescricao("Abasteceu 20.0 de litros de ALCOOL");
		listaAbastecimentoDTO.add(dto2);
		
		AbastecimentoDTO dto3 = new AbastecimentoDTO();
		dto3.setData("07/06/23");
		dto3.setPlaca("CCC3333");
		dto3.setInfoCarro("Honda Civic, placa" + dto3.getPlaca());
		dto3.setValorGasto( 87.0 );
		dto3.setDescricao("Abasteceu 30.0 de litros de GASOLINA_COMUM");
		listaAbastecimentoDTO.add(dto3);
		
		AbastecimentoDTO dto4 = new AbastecimentoDTO();
		dto4.setData("07/06/23");
		dto4.setPlaca("DDD4444");
		dto4.setInfoCarro("Peugeot 408, placa" + dto4.getPlaca());
		dto4.setValorGasto( 320.0 );
		dto4.setDescricao("Abasteceu 40.0 de litros de GASOLINA_PREMIUM");
		listaAbastecimentoDTO.add(dto4);
		
		AbastecimentoDTO dto5 = new AbastecimentoDTO();
		dto5.setData("07/06/23");
		dto5.setPlaca("EEE5555");
		dto5.setInfoCarro("Toyota Corola,, placa" + dto5.getPlaca());
		dto5.setValorGasto( 113.5 );
		dto5.setDescricao("Abasteceu 50.0 de litros de ALCOOL");
		listaAbastecimentoDTO.add(dto5);
		
		AbastecimentoDTO dto6 = new AbastecimentoDTO();
		dto6.setData("07/06/23");
		dto6.setPlaca("FFF6666");
		dto6.setInfoCarro("Toyota Hilux,, placa" + dto6.getPlaca());
		dto6.setValorGasto( 240.0 );
		dto6.setDescricao("Abasteceu 60.0 de litros de DIESEL");
		listaAbastecimentoDTO.add(dto6);
		
		return listaAbastecimentoDTO;
	}

}
