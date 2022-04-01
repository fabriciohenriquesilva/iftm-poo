package principal;

import java.util.ArrayList;
import java.util.Scanner;

import gerencia.GerenciaConsulta;
import gerencia.GerenciaMedico;
import gerencia.GerenciaPaciente;
import model.Consulta;
import model.Medico;
import model.Paciente;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		ArrayList<Medico> medicos = new ArrayList<Medico>();
		ArrayList<Consulta> consultas = new ArrayList<Consulta>();
		
		GerenciaPaciente ficharioPaciente = new GerenciaPaciente(pacientes);
		GerenciaMedico ficharioMedico = new GerenciaMedico(medicos);
		GerenciaConsulta ficharioConsulta = new GerenciaConsulta(consultas, medicos, pacientes);
		
		Scanner sc = new Scanner(System.in);
		int categoria, operacao;
		
		do {
			System.out.println("========= CATEGORIAS =========");
			System.out.println("Escolha uma categoria de menu para acessar:");
			System.out.println("1. Paciente");
			System.out.println("2. Médico");
			System.out.println("3. Consulta");
			System.out.println("0. Encerrar programa");

			categoria = sc.nextInt();
			sc.skip("\r\n");
			
			switch(categoria) {
				case 1:
					operacao = escolherOperacaoMenu(sc);
					switch(operacao) {
						case 1: ficharioPaciente.incluir(); break;
						case 2: ficharioPaciente.consultar(); break;
						case 3:	ficharioPaciente.alterar(); break;
						case 4:	ficharioPaciente.remover(); break;
						case 5:	ficharioPaciente.relatorio(); break;
						default: System.out.println("ALERTA: Opção inválida!");	break;
					}
					break;
					
				case 2:
					operacao = escolherOperacaoMenu(sc);
					switch(operacao) {
						case 1: ficharioMedico.incluir(); break;
						case 2: ficharioMedico.consultar(); break;
						case 3:	ficharioMedico.alterar(); break;
						case 4:	ficharioMedico.remover(); break;
						case 5:	ficharioMedico.relatorio(); break;
						default: System.out.println("ALERTA: Opção inválida!");	break;
					}
					break;
				case 3:
					operacao = escolherOperacaoMenu(sc);
					switch(operacao) {
						case 1: ficharioConsulta.incluir(); break;
						case 2: ficharioConsulta.consultar(); break;
						case 3:	ficharioConsulta.alterar(); break;
						case 4:	ficharioConsulta.remover(); break;
						case 5:	ficharioConsulta.relatorio(); break;
						default: System.out.println("ALERTA: Opção inválida!");	break;
					}
					break;
				case 0:
					System.out.println("Encerrando aplicação...");
					break;
				default:
					System.out.println("ALERTA: Opção inválida!"); 
					break;
			}
			
		} while(categoria != 0);
		
	}
	
	private static int escolherOperacaoMenu(Scanner sc) {
		System.out.println("============ MENU ============");
		System.out.println("Escolha uma opção:");
		System.out.println("1. Incluir");
		System.out.println("2. Consultar");
		System.out.println("3. Alterar");
		System.out.println("4. Excluir");
		System.out.println("5. Gerar relatório");
		System.out.println("Opção: ");
		
		int opcao = sc.nextInt();
		sc.skip("\r\n");
		
		return opcao;
	}
}
