package gerencia;

import java.util.ArrayList;
import java.util.Scanner;

import model.Medico;

public class GerenciaMedico {
	private Scanner sc;
	private ArrayList<Medico> medicos;
	
	public GerenciaMedico(ArrayList<Medico> medicos) {
		sc = new Scanner(System.in);
		this.medicos = medicos;
	}
	
	public void incluir() {
		
		System.out.println("==============================");
		System.out.println("CADASTRO DE MÉDICO");
		
		Medico medico = new Medico();
		
		lerDados(medico);
		
		medicos.add(medico);
		System.out.println("Médico cadastrado com sucesso!");
		
	}
	
	public void consultar() {
		System.out.println("==============================");
		System.out.println("CONSULTAR MÉDICO");
		
		if(medicos.isEmpty()) {
			System.out.println("AVISO: Não há médicos cadastrados! Voltando ao menu inicial!");
		}
		else {
			System.out.println("Digite a posição do médico a ser consultado: ");
			int posMedico = sc.nextInt();
			sc.skip("\r\n");
			
			if(posMedico < 0 || posMedico >= medicos.size()) {
				System.out.println("ALERTA: Posição inexistente. Digite um valor entre 0 e N-1!");
			}
			else {
				System.out.println("==============================");
				System.out.println(medicos.get(posMedico));
				System.out.println("==============================");
			}
		}
	}
	
	public void alterar() {
		System.out.println("==============================");
		System.out.println("ALTERAR MÉDICO");
		
		if(medicos.isEmpty()) {
			System.out.println("AVISO: Não há médicos cadastrados! Voltando ao menu inicial!");
		}
		else {
			System.out.println("Digite a posição do médico a ser alterado: ");
			int posMedico = sc.nextInt();
			sc.skip("\r\n");
			
			if(posMedico < 0 || posMedico >= medicos.size()) {
				System.out.println("ALERTA: Posição inexistente. Digite um valor entre 0 e N-1!");
			}
			else {
				System.out.println("O médico a ser alterado é este?");
				Medico medico = medicos.get(posMedico);
				System.out.println(medico);
				System.out.println("------------------------------");
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				System.out.println("Opção: ");
				int opcao = sc.nextInt();
				sc.skip("\r\n");
				
				if(opcao == 1) {
					lerDados(medico);
					System.out.println("Médico alterado com sucesso!");
				}
				else {
					System.out.println("Voltando ao menu inicial...");
				}
			}
		}
	}
	
	public void remover() {
		System.out.println("==============================");
		System.out.println("REMOVER MÉDICO");
		
		if(medicos.isEmpty()) {
			System.out.println("AVISO: Não há médicos cadastrados! Voltando ao menu inicial!");
		}
		else {
			System.out.println("Digite a posição do médico a ser removido: ");
			int posMedico = sc.nextInt();
			sc.skip("\r\n");
			
			if(posMedico < 0 || posMedico >= medicos.size()) {
				System.out.println("ALERTA: Posição inexistente. Digite um valor entre 0 e N-1!");
			}
			else {
				System.out.println("O médico a ser removido é este?");
				System.out.println(medicos.get(posMedico));
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				System.out.println("Opção: ");
				int opcao = sc.nextInt();
				sc.skip("\r\n");
				
				if(opcao == 1) {
					medicos.remove(posMedico);
					System.out.println("Médico removido com sucesso!");
				}
				else {
					System.out.println("Voltando ao menu inicial...");
				}
			}
		}
	}
	
	public void relatorio() {
		System.out.println("==============================");
		System.out.println("RELATÓRIO DE MÉDICOS");
		
		if(medicos.isEmpty()) {
			System.out.println("AVISO: Não há médicos cadastrados! Voltando ao menu inicial!");
		}
		else {
			for(Medico medico : medicos) {
				System.out.println("==============================");
				System.out.println("Posição            = " + medicos.indexOf(medico));
				System.out.println(medico);
				System.out.println("------------------------------");
			}
			System.out.println("==============================");
		}
	}
	
	private void lerDados(Medico medico) {
		
		System.out.println("1. Digite o nome do médico: ");
		medico.setNome(sc.nextLine());
		
		System.out.println("2. Digite a identidade do médico: ");
		medico.setIdentidade(sc.nextLine());
		
		System.out.println("3. Digite o CPF do médico: ");
		medico.setCpf(sc.nextLine());
		
		System.out.println("4. Digite o telefone do médico: ");
		medico.setTelefone(sc.nextLine());
		
		System.out.println("5. Digite a especialidade do médico: ");
		medico.setEspecialidade(sc.nextLine());
		
		System.out.println("6. Digite o CRM do médico: ");
		medico.setCrm(sc.nextLine());
		
		System.out.println("7. Digite o número da Carteira de Trabalho da Previdência Social do médico (apenas números): ");
		medico.setCtps(sc.nextInt());
		sc.skip("\r\n");
	}
}
