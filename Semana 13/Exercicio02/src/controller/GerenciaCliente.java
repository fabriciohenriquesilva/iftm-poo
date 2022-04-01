package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Cliente;

public class GerenciaCliente implements Gerencia {
	
	private ArrayList<Cliente> clientes;
	private Scanner sc;
	
	public GerenciaCliente(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
		sc = new Scanner(System.in);
	}
	
	public void inserir() {
		
		System.out.println("...:::::[ CADASTRO DE CLIENTE ]:::::...");
		
		Cliente cli = new Cliente();
		
		lerDados(cli);
		
		if(clientes.add(cli)) {
			System.out.println("SUCESSO: Cliente adicionado!");
		}
		else {
			System.out.println("FALHA: Não foi possível adicionar o cliente!");
		}
	}
	
	public void excluir() {
		
		System.out.println("...:::::[ EXCLUSÃO DE CLIENTE ]:::::...");
		
		System.out.println("Digite a posição do cliente a ser excluído: ");
		int posicao = sc.nextInt();
		sc.skip("\r\n");
		
		if(registroVazio() || posicaoInvalida(posicao)) {
			System.out.println("AVISO: Voltando ao menu inicial...");
		}
		else {
			Cliente cli = clientes.get(posicao);
			
			System.out.println("O cliente a ser removido é este?");
			System.out.println(cli);
			System.out.println("[1] Sim");
			System.out.println("[2] Não");
			System.out.println("Opção: ");
			int opcao = sc.nextInt();
			sc.skip("\r\n");
			
			if(opcao == 1) {
				clientes.remove(cli);
				System.out.println("SUCESSO: Cliente removido!");
			}
			else {
				System.out.println("AVISO: Voltando ao menu inicial...");
			}
		}
	}
	
	public void alterar() {
		
		System.out.println("...:::::[ ALTERAÇÃO DE CLIENTE ]:::::...");
		
		System.out.println("Digite a posição do cliente a ser alterado: ");
		int posicao = sc.nextInt();
		sc.skip("\r\n");
		
		if(registroVazio() || posicaoInvalida(posicao)) {
			System.out.println("AVISO: Voltando ao menu inicial...");
		}
		else {
			System.out.println("O cliente a ser alterado é este?");
			Cliente cli = clientes.get(posicao);
			
			System.out.println(cli);
			System.out.println("--------------------------------------");
			System.out.println("[1] Sim");
			System.out.println("[2] Não");
			System.out.println("Opção: ");
			int opcao = sc.nextInt();
			sc.skip("\r\n");
			
			if(opcao == 1) {
				lerDados(cli);
				System.out.println("SUCESSO: Cliente alterado!");
			}
			else {
				System.out.println("AVISO: Voltando ao menu inicial...");
			}
		}
	}
	
	public void consultar() {
		System.out.println("...:::::[ CONSULTA DE CLIENTE ]:::::...");
		
		System.out.println("Digite a posição do cliente a ser consultado: ");
		int posicao = sc.nextInt();
		sc.skip("\r\n");
		
		if(registroVazio() || posicaoInvalida(posicao)) {
			System.out.println("AVISO: Voltando ao menu inicial...");
		}
		else {
			Cliente cli = clientes.get(posicao);
			
			System.out.println("--------------------------------------");
			System.out.println("Posição " + clientes.indexOf(cli));
			System.out.println(cli);
			System.out.println("--------------------------------------");
		}
	}
	
	private void lerDados(Cliente cli) {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("1. Digite o CPF do cliente (apenas números): ");
		cli.setCpf(sc.nextLine());
		
		System.out.println("2. Digite o nome do cliente: ");
		cli.setNome(sc.nextLine());
		
		System.out.println("3. Digite a identidade do cliente (alfanúmerico): ");
		cli.setIdentidade(sc.nextLine());
		
		System.out.println("4. Digite o valor do limite de crédito do cliente: ");
		cli.setLimiteDeCredito(sc.nextFloat());
		sc.skip("\r\n");
		
		System.out.println("5. Digite o valor da compra: ");
		cli.setValorDaCompra(sc.nextFloat());
		sc.skip("\r\n");
		
		System.out.println("6. Digite a data da compra (dd/mm/yyyy): ");
		cli.setDataDaCompra(LocalDate.parse(sc.nextLine(), formato));
		
		System.out.println("7. Digite a data limite para pagamento (dd/mm/yyyy): ");
		cli.setDataLimiteParaPagamento(LocalDate.parse(sc.nextLine(), formato));
		
		System.out.println("8. Digite a data de pagamento (dd/mm/yyyy): ");
		cli.setDataDePagamento(LocalDate.parse(sc.nextLine(), formato));
	}
	
	public void gerarRelatorio() {
		System.out.println("...:::::[ RELATÓRIO DE CLIENTES ]:::::...");
		
		if(registroVazio()) {
			System.out.println("AVISO: Voltando ao menu inicial...");
		}
		else {
			for (Cliente cliente : clientes) {
				System.out.println("Posição " + clientes.indexOf(cliente));
				System.out.println(cliente);
				System.out.println("--------------------------------------");
			}
		}
	}
	
	private boolean registroVazio() {
		if(clientes.isEmpty()) {
			System.out.println("ERRO: Não há clientes cadastrados! Impossível realizar operação!");
			return true;
		}
		return false;
	}
	
	private boolean posicaoInvalida(int posicao) {
		if(posicao < 0 || posicao >= clientes.size()) {
			System.out.println("ERRO: Posição inválida! Digite um valor inteiro entre 0 e o total de registros");
			return true;
		}
		return false;
	}
	
}
