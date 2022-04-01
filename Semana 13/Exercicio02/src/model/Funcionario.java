package model;

public class Funcionario extends Pessoa {
	
	private float salario;
	private String ctps;
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(float salario, String ctps) {
		super();
		this.salario = salario;
		this.ctps = ctps;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"\nCTPS                     : " + ctps +
				"\nSalário                  : R$ " + salario;
	}
	
}
