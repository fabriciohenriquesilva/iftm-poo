package model;

public class Paciente extends Pessoa {
	
	private String nomeConvenio;
	private String numeroConvenio;
	
	public Paciente() {
		super();
	}

	public Paciente(String nome, String identidade, String cpf, String endereco, String telefone, String crm, String nomeConvenio, String numeroConvenio) {
		super(nome, identidade, cpf, endereco, telefone);
		this.nomeConvenio = nomeConvenio;
		this.numeroConvenio = numeroConvenio;
	}

	public String getNomeConvenio() {
		return nomeConvenio;
	}

	public void setNomeConvenio(String nomeConvenio) {
		this.nomeConvenio = nomeConvenio;
	}

	public String getNumeroConvenio() {
		return numeroConvenio;
	}

	public void setNumeroConvenio(String numeroConvenio) {
		this.numeroConvenio = numeroConvenio;
	}
	
	public String toString() {
		return super.toString() + 
				"\nNome do Covênio    = " + nomeConvenio +
				"\nNúmero do Convênio = " + numeroConvenio;
	}
	
	
}