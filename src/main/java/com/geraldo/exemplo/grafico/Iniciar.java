package com.geraldo.exemplo.grafico;

import com.geraldo.exemplo.grafico.service.AbastecimentoService;

public class Iniciar {

	public static void main(String[] args) {
		
		AbastecimentoService exemploGrafico = new AbastecimentoService();
		exemploGrafico.gerarRelatorio();
	}

}
