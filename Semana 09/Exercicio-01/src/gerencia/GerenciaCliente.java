package gerencia;

import java.util.ArrayList;
import java.util.Scanner;

import model.Cliente;

public class GerenciaCliente {
	
	private Scanner sc;
	private ArrayList<Cliente> clientes;
	
	public GerenciaCliente(ArrayList<Cliente> clientes) {
		this.sc = new Scanner(System.in);
		this.clientes = clientes;
	}
	
	public void incluir() {
		
		System.out.println("==============================");
		System.out.println("INCLUS�O DE CLIENTES");
		
		Cliente cliente = new Cliente();
		
		lerDados(cliente);
		clientes.add(cliente);
		
		System.out.println("Cliente cadastrado com sucesso!");
		
	}
	
	public void alterar() {
		
		System.out.println("==============================");
		System.out.println("ALTERA��O DE CLIENTE");
		
		if(clientes.isEmpty()) {
			System.out.println("AVISO: N�o h� clientes cadastrados!");
		}
		else {
			System.out.println("Digite a posi��o do cliente para alterar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
					
			String mensagem = "O cliente que deseja alterar � este?";
			
			if(validarDados(pos, mensagem)){
				System.out.println("Digite os novos dados: ");
				lerDados(clientes.get(pos));
				System.out.println("Cliente alterado com sucesso!");
			}
		}
	}
	
	public void remover() {
		System.out.println("==============================");
		System.out.println("REMO��O DE CLIENTE");
		
		if(clientes.isEmpty()) {
			System.out.println("AVISO: N�o h� clientes cadastrados!");
		}
		else {
			System.out.println("Digite a posi��o do cliente para remover: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
			
			String mensagem = "O cliente que deseja remover � este?";
			
			if(validarDados(pos, mensagem)){
				clientes.remove(pos);
				System.out.println("Cliente removido com sucesso!");
			}
		}
	}
	
	public void consultar() {
		System.out.println("==============================");
		System.out.println("CONSULTA DE CLIENTE");
		
		if(clientes.isEmpty()) {
			System.out.println("AVISO: N�o h� clientes cadastrados!");
		}
		else {
			System.out.println("Digite a posi��o do cliente para consultar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
					
			String mensagem = "O cliente que deseja consultar � este?";
			
			if(!validarDados(pos, mensagem)){
				consultar();
			}
		}
	}
	
	public void relatorio() {
		System.out.println("==============================");
		System.out.println("RELAT�RIO DE CLIENTES");
		
		if(clientes.isEmpty()) {
			System.out.println("AVISO: N�o h� clientes cadastrados!");
		}
		else {
			for(Cliente cliente : clientes) {
				System.out.println("-------------------------------");
				System.out.println("Posi��o #" + clientes.indexOf(cliente));
				imprimir(cliente);
			}
			System.out.println("-------------------------------");
		}
	}
	
	private void lerDados(Cliente cliente) {
		
		System.out.println("1. Digite o nome do cliente: ");
		cliente.setNome(sc.nextLine());
		
		System.out.println("2. Digite o telefone do cliente: ");
		cliente.setTelefone(sc.nextLine());
		
		System.out.println("3. Digite o CPF do cliente: ");
		cliente.setCpf(sc.nextLine());
		
	}
	
	private void imprimir(Cliente cliente) {
		System.out.println("Nome      = " + cliente.getNome());
		System.out.println("Telefone  = " + cliente.getTelefone());
		System.out.println("CPF       = " + cliente.getCpf());
	}
	
	private boolean validarDados(int pos, String mensagem) {
		
		if(pos < 0 || pos >= clientes.size()) {
			System.out.println("ALERTA: Posi��o inv�lida. Deve ser um n�mero entre 0 e N-1");
			return false;
		}
		
		System.out.println(mensagem);
		imprimir(clientes.get(pos));
		
		System.out.println("[1] Sim");
		System.out.println("[2] N�o");
		
		int opcao = Integer.parseInt(sc.nextLine());
		
		if(opcao != 1) {
			System.out.println("Voltando ao menu inicial...");
			return false;
		}
		return true;
	}
}