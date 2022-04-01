package main;

import java.util.ArrayList;
import java.util.Scanner;

import controller.GerenciaCaminhao;
import controller.GerenciaCarro;
import model.Caminhao;
import model.Carro;

public class Principal {

	public static void main(String[] args) {
		
		int opcao;
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Carro> carros = new ArrayList<Carro>();
		GerenciaCarro gc = new GerenciaCarro(carros);
		
		ArrayList<Caminhao> caminhoes = new ArrayList<Caminhao>();
		GerenciaCaminhao gk = new GerenciaCaminhao(caminhoes);
		
		do {
			System.out.println("============ MENU ============");
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
				case 1:
					
					System.out.println("Deseja incluir um: ");
					opcao = opcaoMenu();
					
					if(opcao == 1) {
						gc.incluir();
					}
					else if(opcao == 2) {
						gk.incluir();
					}
					else {
						System.out.println("Opção inválida");
					}
					
					break;
					
				case 2:
					
					System.out.println("Deseja consultar um: ");
					opcao = opcaoMenu();
					
					if(opcao == 1) {
						gc.consultar();
					}
					else if(opcao == 2) {
						gk.consultar();
					}
					else {
						System.out.println("Opção inválida");
					}
					
					break;
					
				case 3:
					
					System.out.println("Deseja alterar um: ");
					opcao = opcaoMenu();
					
					if(opcao == 1) {
						gc.alterar();
					}
					else if(opcao == 2) {
						gk.alterar();
					}
					else {
						System.out.println("Opção inválida");
					}
					
					break;
					
				case 4:
					
					System.out.println("Deseja remover um: ");
					opcao = opcaoMenu();
					
					if(opcao == 1) {
						gc.remover();
					}
					else if(opcao == 2) {
						gk.remover();
					}
					else {
						System.out.println("Opção inválida");
					}
					
					break;
					
				case 5:
					
					System.out.println("Deseja gerar um relatório de: ");
					opcao = opcaoMenu();
					
					if(opcao == 1) {
						gc.relatorio();
					}
					else if(opcao == 2) {
						gk.relatorio();
					}
					else {
						System.out.println("Opção inválida");
					}
					
					break;
					
				case 0:
					System.out.println("Encerrando aplicação...");
					break;
				default:
					System.out.println("ALERTA: Opção inválida!");
					break;
			}
			
		} while(opcao != 0);
	}
	
	private static int opcaoMenu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1 - Carro");
		System.out.println("2 - Caminhão");
		int opcao;
		opcao = Integer.parseInt(sc.nextLine());
		
		return opcao;
	}
}
