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
		System.out.println("CADASTRO DE M�DICO");
		
		Medico medico = new Medico();
		
		lerDados(medico);
		
		medicos.add(medico);
		System.out.println("M�dico cadastrado com sucesso!");
		
	}
	
	public void consultar() {
		System.out.println("==============================");
		System.out.println("CONSULTAR M�DICO");
		
		if(medicos.isEmpty()) {
			System.out.println("AVISO: N�o h� m�dicos cadastrados! Voltando ao menu inicial!");
		}
		else {
			System.out.println("Digite a posi��o do m�dico a ser consultado: ");
			int posMedico = sc.nextInt();
			sc.skip("\r\n");
			
			if(posMedico < 0 || posMedico >= medicos.size()) {
				System.out.println("ALERTA: Posi��o inexistente. Digite um valor entre 0 e N-1!");
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
		System.out.println("ALTERAR M�DICO");
		
		if(medicos.isEmpty()) {
			System.out.println("AVISO: N�o h� m�dicos cadastrados! Voltando ao menu inicial!");
		}
		else {
			System.out.println("Digite a posi��o do m�dico a ser alterado: ");
			int posMedico = sc.nextInt();
			sc.skip("\r\n");
			
			if(posMedico < 0 || posMedico >= medicos.size()) {
				System.out.println("ALERTA: Posi��o inexistente. Digite um valor entre 0 e N-1!");
			}
			else {
				System.out.println("O m�dico a ser alterado � este?");
				Medico medico = medicos.get(posMedico);
				System.out.println(medico);
				System.out.println("------------------------------");
				System.out.println("[1] Sim");
				System.out.println("[2] N�o");
				System.out.println("Op��o: ");
				int opcao = sc.nextInt();
				sc.skip("\r\n");
				
				if(opcao == 1) {
					lerDados(medico);
					System.out.println("M�dico alterado com sucesso!");
				}
				else {
					System.out.println("Voltando ao menu inicial...");
				}
			}
		}
	}
	
	public void remover() {
		System.out.println("==============================");
		System.out.println("REMOVER M�DICO");
		
		if(medicos.isEmpty()) {
			System.out.println("AVISO: N�o h� m�dicos cadastrados! Voltando ao menu inicial!");
		}
		else {
			System.out.println("Digite a posi��o do m�dico a ser removido: ");
			int posMedico = sc.nextInt();
			sc.skip("\r\n");
			
			if(posMedico < 0 || posMedico >= medicos.size()) {
				System.out.println("ALERTA: Posi��o inexistente. Digite um valor entre 0 e N-1!");
			}
			else {
				System.out.println("O m�dico a ser removido � este?");
				System.out.println(medicos.get(posMedico));
				System.out.println("[1] Sim");
				System.out.println("[2] N�o");
				System.out.println("Op��o: ");
				int opcao = sc.nextInt();
				sc.skip("\r\n");
				
				if(opcao == 1) {
					medicos.remove(posMedico);
					System.out.println("M�dico removido com sucesso!");
				}
				else {
					System.out.println("Voltando ao menu inicial...");
				}
			}
		}
	}
	
	public void relatorio() {
		System.out.println("==============================");
		System.out.println("RELAT�RIO DE M�DICOS");
		
		if(medicos.isEmpty()) {
			System.out.println("AVISO: N�o h� m�dicos cadastrados! Voltando ao menu inicial!");
		}
		else {
			for(Medico medico : medicos) {
				System.out.println("==============================");
				System.out.println("Posi��o            = " + medicos.indexOf(medico));
				System.out.println(medico);
				System.out.println("------------------------------");
			}
			System.out.println("==============================");
		}
	}
	
	private void lerDados(Medico medico) {
		
		System.out.println("1. Digite o nome do m�dico: ");
		medico.setNome(sc.nextLine());
		
		System.out.println("2. Digite a identidade do m�dico: ");
		medico.setIdentidade(sc.nextLine());
		
		System.out.println("3. Digite o CPF do m�dico: ");
		medico.setCpf(sc.nextLine());
		
		System.out.println("4. Digite o telefone do m�dico: ");
		medico.setTelefone(sc.nextLine());
		
		System.out.println("5. Digite a especialidade do m�dico: ");
		medico.setEspecialidade(sc.nextLine());
		
		System.out.println("6. Digite o CRM do m�dico: ");
		medico.setCrm(sc.nextLine());
		
		System.out.println("7. Digite o n�mero da Carteira de Trabalho da Previd�ncia Social do m�dico (apenas n�meros): ");
		medico.setCtps(sc.nextInt());
		sc.skip("\r\n");
	}
}
