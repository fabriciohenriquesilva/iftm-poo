package model;

public class Medico extends Pessoa {
	
	private String crm;
	private String especialidade;
	private String ctps;
	
	public Medico() {
		super();
	}

	public Medico(String nome, String identidade, String cpf, String endereco, String telefone, String crm, String especialidade, String ctps) {
		super(nome, identidade, cpf, endereco, telefone);
		this.crm = crm;
		this.especialidade = especialidade;
		this.ctps = ctps;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	
	public String toString() {
		return super.toString() +
				"\nCRM                = " + crm +
				"\nEspecialidade      = " + especialidade +
				"\nCTPS               = " + ctps;
	}
	
}
