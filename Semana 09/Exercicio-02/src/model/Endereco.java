package model;

public class Endereco {
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private String municipio;
	private String cep;
	private int tipo; //Residencial ou comercial
	
	public Endereco() {}
		
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public int getTipo() {
		return tipo;
	}
	public boolean setTipo(int tipo) {
		if(tipo != 1 && tipo != 2) {
			return false;
		}
		this.tipo = tipo;
		return true;
	}

	@Override
	public String toString() {
		return    "Logradouro         = " + logradouro +
				"\nNumero             = " + numero +
				"\nComplemento        = " + complemento +
				"\nBairro             = " + bairro +
				"\nMunicípio          = " + municipio +
				"\nCEP                = " + cep +
				"\nTipo de Endereço   = " + tipo;
	}
}
