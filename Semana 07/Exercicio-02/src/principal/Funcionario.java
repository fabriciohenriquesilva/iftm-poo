package principal;

import java.util.ArrayList;

public class Funcionario {
	private String cpf;
	private String nome;
	private float salario;
	private String identidade;
	private ArrayList<Filho> filhos;
	
	public Funcionario() {
		filhos = new ArrayList<Filho>();
	}
	
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
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public ArrayList<Filho> getFilhos() {
		return filhos;
	}
	
}