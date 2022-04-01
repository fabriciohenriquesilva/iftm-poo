package model;

public class Paciente extends Pessoa {
	
	private String nomeConvenio;
	private int numeroConvenio;
	private Endereco enderecos[];
	
	public Paciente(String nomeConvenio, int numeroConvenio) {
		super();
		this.nomeConvenio = nomeConvenio;
		this.numeroConvenio = numeroConvenio;
		enderecos = new Endereco[2];
	}

	public Paciente() {
		super();
		enderecos = new Endereco[2];
	}
	
	public String getNomeConvenio() {
		return nomeConvenio;
	}
	public void setNomeConvenio(String nomeConvenio) {
		this.nomeConvenio = nomeConvenio;
	}
	public int getNumeroConvenio() {
		return numeroConvenio;
	}
	public void setNumeroConvenio(int numeroConvenio) {
		this.numeroConvenio = numeroConvenio;
	}
	public Endereco[] getEndereco() {
		return enderecos;
	}
	public boolean setEndereco(Endereco endereco) {
		int pos = 0;
		while( (pos < enderecos.length) && (enderecos[pos] != null) ) {
			pos++;
		}
		
		if(pos < enderecos.length) {
			enderecos[pos] = endereco;
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String s =    "Nome               = " + this.getNome() +
					"\nIdentidade         = " + this.getIdentidade() +
					"\nCPF                = " + this.getCpf() +
					"\nTelefone           = " + this.getTelefone() +
					"\nNome do Convênio   = " + nomeConvenio +
					"\nNúmero do convênio = " + numeroConvenio;
		
		for(int i = 0; i < enderecos.length; i++) {
			if(enderecos[i] != null) {
				s += "\n------------------------------";
				s += "\nEndereço " + i + ":\n" + enderecos[i];
			}
		}
		
		return s;
	}
}
