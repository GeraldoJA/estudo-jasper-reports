package com.geraldo.exemplo.grafico.dto;

public class AbastecimentoDTO {

	private String data;
	
	private String infoCarro;
	
	private String placa;
	
	private String descricao;
	
	private Double valorGasto;
	

	public String getData() {
		return data;
	}

	public String getInfoCarro() {
		return infoCarro;
	}

	public String getPlaca() {
		return placa;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getValorGasto() {
		return valorGasto;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setInfoCarro(String infoCarro) {
		this.infoCarro = infoCarro;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValorGasto(Double valorGasto) {
		this.valorGasto = valorGasto;
	}
	
}
