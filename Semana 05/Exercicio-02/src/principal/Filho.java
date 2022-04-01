package principal;

import java.util.Date;

public class Filho {
	private String cpf;
	private String nome;
	private String numeroDaCertidaoDeNascimento;
	private Date dataDeNascimento;
	
	public Filho(String cpf, String nome, String numeroDaCertidaoDeNascimento, Date dataDeNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.numeroDaCertidaoDeNascimento = numeroDaCertidaoDeNascimento;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public Filho() {};
	
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
	public String getNumeroDaCertidaoDeNascimento() {
		return numeroDaCertidaoDeNascimento;
	}
	public void setNumeroDaCertidaoDeNascimento(String numeroDaCertidaoDeNascimento) {
		this.numeroDaCertidaoDeNascimento = numeroDaCertidaoDeNascimento;
	}
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}	
	
}
