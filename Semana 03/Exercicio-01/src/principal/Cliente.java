package principal;

public class Cliente {
	private int codigo;
	private String nome;
	private boolean eClienteEspecial;
	private double limiteCredito;
	
	public Cliente(int c, String n) {
		this.codigo = c;
		this.nome = n;
		this.limiteCredito = 0;
		this.eClienteEspecial = false;
	}
	
	public String obterNome() {
		return(nome);
	}
	
	public boolean atualizaLimite(double valor) {
		if(this.eClienteEspecial) {
			this.limiteCredito = valor;
			return true;
		}
		
		return false;
	}
	
	public void atualizaSituacao(boolean clienteEspecial) {
		if(clienteEspecial) {
			this.eClienteEspecial = clienteEspecial;
		}
		
		this.eClienteEspecial = clienteEspecial;
		this.limiteCredito = 0;
	}
	
}
