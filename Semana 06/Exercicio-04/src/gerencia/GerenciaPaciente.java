package gerencia;

import java.util.Scanner;

import model.Paciente;

public class GerenciaPaciente {
	
	Paciente[] pacientes;
	Scanner sc;
	
	public GerenciaPaciente(Paciente[] pacientes) {
		this.pacientes = pacientes;
		sc = new Scanner(System.in);
	}
	
	public void incluirPaciente() {
		
		System.out.println("==============================");
		System.out.println("---- CADASTRO DE PACIENTE ----");
		
		int pos = 0;
		while(pos < pacientes.length && pacientes[pos] != null) {
			pos++;
		}
		
		if(pos < pacientes.length) {
			Paciente paciente = new Paciente();
			System.out.println("Digite os dados do novo paciente: ");
			
			pacientes[pos] = lerDados(paciente);
			
			System.out.println("Paciente cadastrado com sucesso");
		}
		else {
			System.out.println("Memória cheia");
		}
	}
	
	public void excluirPaciente() {
		int pos, opcao;
		System.out.println("==============================");
		System.out.println("---- EXCLUSÃO DE PACIENTE ----");
		
		System.out.println("Digite a posição do cliente a ser removido: ");
		
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 || pos < pacientes.length) {
			if(pacientes[pos] != null) {
				
				System.out.println("O paciente que deseja remover é este?");
				imprimir(pacientes[pos]);
				
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				opcao = Integer.parseInt(sc.nextLine());
				
				if(opcao == 1) {
					pacientes[pos] = null;
					System.out.println("Paciente excluído");
				} else {
					System.out.println("Voltando ao menu principal");
				}				
			}
			else {
				System.out.println("Não existe paciente na posição informada para exclusão");
			}
		}
		else {
			System.out.println("Posição deve ser um número entre 0 e N");
		}	
	}
	
	public void alterarPaciente() {
		int pos, opcao;
		System.out.println("==============================");
		System.out.println("--- ALTERAÇÃO DE PACIENTE  ---");
		
		System.out.println("Digite a posição do cliente a ser alterado: ");
		
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 || pos < pacientes.length) {
			if(pacientes[pos] != null) {
				System.out.println("O paciente que deseja alterar é este?");
				imprimir(pacientes[pos]);
				
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				opcao = Integer.parseInt(sc.nextLine());
				
				if(opcao == 1) {
					pacientes[pos] = lerDados(pacientes[pos]);
				} else {
					System.out.println("Voltando ao menu principal");
				}
				
			}
			else {
				System.out.println("Não existe paciente na posição informada para alteração");
			}
		}
		else {
			System.out.println("Posição deve ser um número entre 0 e N");
		}	
	}
	
	public void consultarPaciente() {
		int pos;
		System.out.println("Digite a posição do cliente a ser alterado: ");
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 || pos < pacientes.length) {
			if(pacientes[pos] != null) {
				imprimir(pacientes[pos]);
			}
			else {
				System.out.println("Não existe paciente na posição informada");
			}
		}
		else {
			System.out.println("Posição deve ser um número entre 0 e N");
		}			
	}
	
	public void gerarRelatorio() {
		System.out.println("******************************");
		System.out.println("RELATÓRIO DE PACIENTES");
		for(int i = 0; i < pacientes.length; i++) {
			if(pacientes[i] != null) {
				System.out.println("Posição #" + i);
				imprimir(pacientes[i]);
				System.out.println("******************************");
			}
		}
	}
	
	public void imprimir(Paciente paciente) {
		System.out.println("------------------------------");
		System.out.println("CPF: " + paciente.getCpf());
		System.out.println("Nome: " + paciente.getNome());
		System.out.println("Endereço: " + paciente.getEndereco());
		System.out.println("Telefone: " + paciente.getTelefone());
		System.out.println("------------------------------");
	}
	
	private Paciente lerDados(Paciente paciente) {
		System.out.println("1 - Digite o CPF do paciente: ");
		paciente.setCpf(sc.nextLine());
		
		System.out.println("2 - Digite o nome do paciente: ");
		paciente.setNome(sc.nextLine());
		
		System.out.println("3 - Digite o endereço do paciente: ");
		paciente.setEndereco(sc.nextLine());
		
		System.out.println("4 - Digite o telefone do paciente: ");
		paciente.setTelefone(sc.nextLine());
		
		return paciente;
	}
	
	public boolean estaVazio() {
		int pos = 0;
		while(pos < pacientes.length && pacientes[pos] == null) {
			pos++;
		}
		
		if(pos == pacientes.length) {
			return true;
		}
		
		return false;
	}
	
public Paciente alocarPaciente() {
		
		int pos;
		System.out.println("Digite a posição do paciente a ser alocado: ");
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 || pos < pacientes.length) {
			if(pacientes[pos] != null) {
				return pacientes[pos]; 
			}
			else {
				System.out.println("Não existe paciente na posição informada");
			}
		}
		else {
			System.out.println("Posição deve ser um número entre 0 e N");
		}
		return null;
	}
		
}
