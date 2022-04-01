package gerencia;

import java.util.Scanner;

import model.Endereco;

public class GerenciaEndereco {
	private Scanner sc;
	
	public GerenciaEndereco(Endereco end) {
		sc = new Scanner(System.in);
	}
	
	public Endereco cadastrarEndereco() {
		Endereco end = new Endereco();
		
		System.out.println("=================================");
		System.out.println("----  CADASTRO DE ENDERE�O  -----");
		
		end = lerDados(end);
		
		System.out.println();
		return end;
	}
	
	public void consultarEndereco(Endereco end) {
		System.out.println("*********************************");
		System.out.println("Logradouro: " + end.getLogradouro());
		System.out.println("N�mero: " + end.getNumero());
		System.out.println("Complemento: " + end.getComplemento());
		System.out.println("Bairro: " + end.getBairro());
		System.out.println("Munic�pio: " + end.getMunicipio());
		System.out.println("Estado: " + end.getEstado());
		System.out.println("CEP: "+ end.getCep());
		System.out.println("*********************************");
	}
	
	public Endereco alterarEndereco(Endereco end) {
		
		end = lerDados(end);
		
		return end;
	}
	
	public void excluirEndereco(Endereco end) {
		end = null;
		System.out.println("Endere�o exclu�do");
		
	}
	
	private Endereco lerDados(Endereco end) {
		System.out.println("1. Digite o logradouro: ");
		end.setLogradouro(sc.nextLine());
		
		System.out.println("2. Digite o n�mero: ");
		end.setNumero(Integer.parseInt(sc.nextLine()));
		
		System.out.println("3. Digite o complemento: ");
		end.setComplemento(sc.nextLine());
		
		System.out.println("4. Digite o bairro: ");
		end.setBairro(sc.nextLine());
		
		System.out.println("5. Digite o munic�pio: ");
		end.setMunicipio(sc.nextLine());
		
		System.out.println("6. Digite o estado: ");
		end.setEstado(sc.nextLine());
		
		System.out.println("7. Digite o CEP: ");
		end.setCep(sc.nextLine());
		
		return end;
	}
}
