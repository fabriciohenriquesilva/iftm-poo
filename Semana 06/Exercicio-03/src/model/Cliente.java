package model;

import java.util.Calendar;

public class Cliente {
	private String cpf;
	private String nome;
	private float valor;
	private Calendar data;
	private Endereco endCobranca;
	private Endereco endEntrega;
	
	public Cliente() { };
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public void getData() {
		System.out.println(
			this.data.get(Calendar.DAY_OF_MONTH) + "/"
			+ this.data.get(Calendar.MONTH) + "/"
			+ this.data.get(Calendar.YEAR)
		);
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public Endereco getEndCobranca() {
		return endCobranca;
	}
	public void setEndCobranca(Endereco endCobranca) {
		this.endCobranca = endCobranca;
	}
	public Endereco getEndEntrega() {
		return endEntrega;
	}
	public void setEndEntrega(Endereco endEntrega) {
		this.endEntrega = endEntrega;
	}
	
}
