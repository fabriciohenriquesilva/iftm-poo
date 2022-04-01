package model;

public class Medico extends Pessoa {
	
	private String especialidade;
	private String crm;
	private int ctps;
	
	public Medico() {
		super();
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public int getCtps() {
		return ctps;
	}

	public void setCtps(int ctps) {
		this.ctps = ctps;
	}

	@Override
	public String toString() {
		return    "Nome               = " + this.getNome() +
				"\nIdentidade         = " + this.getIdentidade() +
				"\nCPF                = " + this.getCpf() +
				"\nTelefone           = " + this.getTelefone() +
				"\nEspecialidade      = " + especialidade+
				"\nCRM                = " + crm + 
				"\nCTPS               = " + ctps;
	}
}
