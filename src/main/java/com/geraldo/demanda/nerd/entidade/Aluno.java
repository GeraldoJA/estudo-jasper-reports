package com.geraldo.demanda.nerd.entidade;

import lombok.Data;

@Data
public class Aluno {
	
	private String nome;
	private String matricula;
	private Double nota;
	private Integer faltas;
	
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", matricula=" + matricula + ", nota=" + nota + ", faltas=" + faltas + "]\n";
	}

}
