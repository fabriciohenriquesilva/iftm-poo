package main;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Gerencia;
import controller.GerenciaCliente;
import controller.GerenciaFuncionario;
import model.Cliente;
import model.Funcionario;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int menu;
		
		ArrayList<Cliente> clientes = new ArrayList<>();
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		
		GerenciaCliente ficharioCliente = new GerenciaCliente(clientes);
		GerenciaFuncionario ficharioFuncionario = new GerenciaFuncionario(funcionarios);
		
		do {
			System.out.println("--------------------------------------");
			System.out.println("...:::::[ MENU ]:::::...");
			System.out.println("1. Funcionário");
			System.out.println("2. Cliente");
			System.out.println("0. Sair");
			
			menu = sc.nextInt();
			sc.skip("\r\n");
			
			if(menu == 0) {
				System.out.println("AVISO: Encerrando aplicação...");
				break;
			}
			else if(menu == 1) {
				operacao(ficharioFuncionario);
			}
			else if(menu == 2) {
				operacao(ficharioCliente);
			}
			else {
				System.out.println("ERRO: Opção inválida! Tente outra vez");
			}
		} while(menu != 0);
	}
	
	public static void operacao(Gerencia fichario) {
		Scanner ent = new Scanner(System.in);
		
		System.out.println("--------------------------------------");
		System.out.println("...:::::[ OPERAÇÃO ]:::::...");
		System.out.println("Escolha operação:");
		System.out.println("1. Incluir");
		System.out.println("2. Excluir");
		System.out.println("3. Alterar");
		System.out.println("4. Consultar");
		System.out.println("5. Gerar Relatório");
		System.out.println("0. Voltar ao menu inicial");
		
		int operacao = ent.nextInt();
		ent.skip("\r\n");
		
		switch(operacao) {
			case 1: fichario.inserir(); break;
			case 2: fichario.excluir(); break;
			case 3: fichario.alterar(); break;
			case 4: fichario.consultar(); break;
			case 5: fichario.gerarRelatorio(); break;
			case 0: System.out.println("AVISO: Voltando ao menu inicial..."); break;
			default: System.out.println("ERRO: Opção inválida! Voltando ao menu inicial..."); break;
		}
	}
}