package gerencia;

import java.util.Scanner;

import model.Medico;

public class GerenciaMedico {
	
	Medico[] medicos;
	Scanner sc;
	
	public GerenciaMedico(Medico[] medicos) {
		this.medicos = medicos;
		sc = new Scanner(System.in);
	}
	
	public void incluirMedico() {
		
		System.out.println("==============================");
		System.out.println("----- CADASTRO DE MÉDICO -----");
		
		int pos = 0;
		while(pos < medicos.length && medicos[pos] != null) {
			pos++;
		}
		
		if(pos < medicos.length) {
			Medico medico = new Medico();
			System.out.println("Digite os dados do novo médico: ");
			
			System.out.println("1 - Digite o CRM do médico: ");
			medico.setCrm(Integer.parseInt(sc.nextLine()));
			
			System.out.println("2 - Digite o nome do médico: ");
			medico.setNome(sc.nextLine());
			
			medicos[pos] = medico;
			
			System.out.println("Médico cadastrado com sucesso");
		}
		else {
			System.out.println("Memória cheia");
		}
	}
	
	public void excluirMedico() {
		int pos, opcao;
		System.out.println("==============================");
		System.out.println("----- EXCLUSÃO DE MÉDICO -----");
		
		System.out.println("Digite a posição do médico a ser removido: ");
		
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 || pos < medicos.length) {
			if(medicos[pos] != null) {
				
				System.out.println("O paciente que deseja remover é este?");
				imprimir(medicos[pos]);
				
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				opcao = Integer.parseInt(sc.nextLine());
				
				if(opcao == 1) {
					medicos[pos] = null;
					System.out.println("Médico excluído");
				} else {
					System.out.println("Voltando ao menu principal");
				}
			}
			else {
				System.out.println("Não existe médico na posição informada para exclusão");
			}
		}
		else {
			System.out.println("Posição deve ser um número entre 0 e N");
		}	
	}
	
	public void alterarMedico() {
		int pos, opcao;
		System.out.println("==============================");
		System.out.println("---- ALTERAÇÃO DE MÉDICO  ----");
		
		System.out.println("Digite a posição do médico a ser alterado: ");
		
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 || pos < medicos.length) {
			if(medicos[pos] != null) {
				System.out.println("O médico que deseja alterar é este:");
				imprimir(medicos[pos]);
				
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				opcao = Integer.parseInt(sc.nextLine());
				
				if(opcao == 1) {
					System.out.println("1 - Digite o CRM do médico: ");
					medicos[pos].setCrm(Integer.parseInt(sc.nextLine()));
					
					System.out.println("2 - Digite o nome do médico: ");
					medicos[pos].setNome(sc.nextLine());
				} else {
					System.out.println("Voltando ao menu principal");
				}
				
			}
			else {
				System.out.println("Não existe médico na posição informada para alteração");
			}
		}
		else {
			System.out.println("Posição deve ser um número entre 0 e N");
		}	
	}
	
	public void consultarMedico() {
		int pos;
		System.out.println("Digite a posição do médico a ser consultado: ");
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 || pos < medicos.length) {
			if(medicos[pos] != null) {
				imprimir(medicos[pos]);
			}
			else {
				System.out.println("Não existe médico na posição informada");
			}
		}
		else {
			System.out.println("Posição deve ser um número entre 0 e N");
		}
	}
	
	public void gerarRelatorio() {
		System.out.println("******************************");
		System.out.println("RELATÓRIO DE MÉDICOS");
		for(int i = 0; i < medicos.length; i++) {
			if(medicos[i] != null) {
				System.out.println("Posição #" + i);
				imprimir(medicos[i]);
				System.out.println("******************************");
			}
		}
	}
	
	public void imprimir(Medico medico) {
		System.out.println("------------------------------");
		System.out.println("CRM: " + medico.getCrm());
		System.out.println("Nome: " + medico.getNome());
		System.out.println("------------------------------");
	}
	
	public boolean estaVazio() {
		
		int pos = 0;
		while(pos < medicos.length && medicos[pos] == null) {
			pos++;
		}
		
		if(pos == medicos.length) {
			return true;
		}
		
		return false;
	}
	
	public Medico alocarMedico() {
		
		int pos;
		System.out.println("Digite a posição do médico a ser alocado: ");
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 || pos < medicos.length) {
			if(medicos[pos] != null) {
				return medicos[pos]; 
			}
			else {
				System.out.println("Não existe médico na posição informada");
			}
		}
		else {
			System.out.println("Posição deve ser um número entre 0 e N");
		}
		return null;
	}
		
}
