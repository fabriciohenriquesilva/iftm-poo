package model;

public abstract class Pessoa {
	
	private String cpf;
	private String nome;
	private String identidade;
	
	public Pessoa() { }

	public Pessoa(String cpf, String nome, String identidade) {
		this.cpf = cpf;
		this.nome = nome;
		this.identidade = identidade;
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

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	
	@Override
	public String toString() {
		return    "Nome                     : " + nome +
				"\nCPF                      : " + cpf + 
				"\nIdentidade               : " + identidade;
	}
}
