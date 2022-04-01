package principal;

import java.util.Scanner;

import gerencia.GerenciaConsulta;
import gerencia.GerenciaMedico;
import gerencia.GerenciaPaciente;
import model.Consulta;
import model.Medico;
import model.Paciente;

public class Principal {

	public static void main(String[] args) {
		Medico[] medicos = new Medico[30];
		Paciente[] pacientes = new Paciente[100];
		Consulta[] consultas = new Consulta[1000];
		
		GerenciaConsulta gc = new GerenciaConsulta(consultas, medicos, pacientes);
		GerenciaMedico gm = new GerenciaMedico(medicos);
		GerenciaPaciente gp = new GerenciaPaciente(pacientes);
		
		int menu, opcao;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("============ MENU ============");
			System.out.println("Escolha uma op��o:");
			System.out.println("1. Incluir");
			System.out.println("2. Consultar");
			System.out.println("3. Alterar");
			System.out.println("4. Excluir");
			System.out.println("5. Gerar relat�rio");
			System.out.println("0. Sair");
			System.out.println("Op��o: ");
			
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
				case 0:
					System.out.println("Encerrando aplica��o...");
					break;			
				case 1:
					
					System.out.println("Deseja incluir um: ");
					opcao = opcaoMenu();
					
					if(opcao == 1) {
						gm.incluirMedico();
					}
					else if(opcao == 2) {
						gp.incluirPaciente();
					}
					else if(opcao == 3) {
						gc.incluirConsulta();
					}
					else {
						System.out.println("Op��o inv�lida");
					}
					
					break;
				case 2:
					
					System.out.println("Deseja consultar um: ");
					opcao = opcaoMenu();
					
					if(opcao == 1) {
						gm.consultarMedico();
					}
					else if(opcao == 2) {
						gp.consultarPaciente();
					}
					else if(opcao == 3) {
						gc.verConsultas();
					}
					else {
						System.out.println("Op��o inv�lida");
					}
					
					break;					
				case 3:
					
					System.out.println("Deseja alterar um: ");
					opcao = opcaoMenu();
					
					if(opcao == 1) {
						gm.alterarMedico();
					}
					else if(opcao == 2) {
						gp.alterarPaciente();
					}
					else if(opcao == 3) {
						gc.alterarConsulta();
					}
					else {
						System.out.println("Op��o inv�lida");
					}
					break;					
				case 4:
					
					System.out.println("Deseja excluir um: ");
					opcao = opcaoMenu();
					
					if(opcao == 1) {
						gm.excluirMedico();
					}
					else if(opcao == 2) {
						gp.excluirPaciente();
					}
					else if(opcao == 3) {
						gc.excluirConsulta();
					}
					else {
						System.out.println("Op��o inv�lida");
					}
					break;					
				case 5:
					
					System.out.println("Deseja gerar relat�rio de um: ");
					opcao = opcaoMenu();
					
					if(opcao == 1) {
						gm.gerarRelatorio();
					}
					else if(opcao == 2) {
						gp.gerarRelatorio();
					}
					else if(opcao == 3) {
						gc.gerarRelatorio(); //
					}
					else {
						System.out.println("Op��o inv�lida");
					}
					break;					
				default:
					System.out.println("Op��o inv�lida");
					break;					
			}
			
		} while(menu != 0);
		
	}
	
	private static int opcaoMenu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1 - M�dico");
		System.out.println("2 - Paciente");
		System.out.println("3 - Consulta");
		int opcao;
		opcao = Integer.parseInt(sc.nextLine());
		
		return opcao;
	}

}
