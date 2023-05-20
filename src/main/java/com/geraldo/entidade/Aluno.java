package com.geraldo.entidade;

import lombok.Data;

@Data
public class Aluno {
	
	private String nome;
	private String matricula;
	private double nota;
	private Integer faltas;
	
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", matricula=" + matricula + ", nota=" + nota + ", faltas=" + faltas + "]";
	}

}