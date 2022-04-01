package principal;

import java.util.Scanner;

import gerencia.GerenciaCliente;
import model.Cliente;

public class Principal {

	public static void main(String[] args) {
		int opcao, tam = 200;
		Cliente[] clientes = new Cliente[tam];
		GerenciaCliente gc = new GerenciaCliente(clientes);
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("============== MENU =============");
			System.out.println("Escolha uma opção:");
			System.out.println("1. Incluir");
			System.out.println("2. Consultar");
			System.out.println("3. Alterar");
			System.out.println("4. Excluir");
			System.out.println("5. Gerar relatório");
			System.out.println("0. Sair");
			System.out.println("Opção: ");
			
			opcao = Integer.parseInt(sc.nextLine());
			
			switch(opcao) {
				case 0:
					System.out.println("Encerrando aplicação...");
					break;			
				case 1:
					gc.cadastrarCliente();
					break;
				case 2:
					gc.consultarCliente();
					break;					
				case 3:
					gc.alterarCliente();
					break;					
				case 4:
					gc.removerCliente();
					break;					
				case 5:
					gc.relatorioDeClientes();
					break;					
				default:
					System.out.println("Opção inválida");
					break;					
			}
			
		} while(opcao != 0);
		sc.close();
	}

}
