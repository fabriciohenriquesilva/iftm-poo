package principal;

public class Funcionario {
	private String cpf;
	private String nome;
	private float salario;
	private String identidade;
	private Filho[] filhos;
	
	public Funcionario(String cpf, String nome, float salario, String identidade) {
		this.cpf = cpf;
		this.nome = nome;
		this.salario = salario;
		this.identidade = identidade;
	}
	
	public Funcionario() {};
	
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

	public Filho[] getFilhos() {
		return filhos;
	}

	public void setFilhos(Filho[] filhos) {
		this.filhos = filhos;
	}
	
}