package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Paciente;
import model.Pessoa;

public class GerenciaPaciente implements Gerencia {

	private Scanner sc;
	private ArrayList<Pessoa> pessoas;
	
	public GerenciaPaciente(ArrayList<Pessoa> pessoas) {
		sc = new Scanner(System.in);
		this.pessoas = pessoas;
	}
	
	public void adicionar() {

		System.out.println("...:::::[ CADASTRO DE PACIENTE ]:::::...");
		
		Paciente paciente = new Paciente();
		
		lerDados(paciente);
		
		pessoas.add(paciente);
		System.out.println("SUCESSO: Paciente cadastrado!");
	}
	
	public void alterar() {
		System.out.println("...:::::[ ALTERAÇÃO DE PACIENTE ]:::::...");
		
		if(!pessoas.isEmpty()) {
			System.out.println("Digite a posição do paciente a ser alterado: ");
			int posicao = sc.nextInt();
			sc.skip("\r\n");
			
			if(pessoas.get(posicao) instanceof Paciente) {
				
				System.out.println("O paciente a ser alterado é este?");
				Paciente paciente = (Paciente) pessoas.get(posicao);
				
				System.out.println(paciente);
				System.out.println("--------------------------------------");
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				System.out.println("Opção: ");
				int opcao = sc.nextInt();
				sc.skip("\r\n");
				
				if(opcao == 1) {
					lerDados(paciente);
					System.out.println("SUCESSO: Paciente alterado!");
				}
				else {
					System.out.println("AVISO: Operação cancelada! Voltando ao menu inicial...");
				}
			}
			else {
				System.out.println("AVISO: Não existe um paciente na posição informada!");
			}	
		}
		else {
			System.out.println("AVISO: Não há pessoas cadastradas! Voltando ao menu inicial!");
		}
	}
	
	public void consultar() {

		System.out.println("...:::::[ CONSULTA DE PACIENTE ]:::::...");
		
		if(!pessoas.isEmpty()) {
			
			System.out.println("Digite a posição do paciente a ser consultado: ");
			int posicao = sc.nextInt();
			sc.skip("\r\n");
			
			if(posicao < 0 || posicao >= pessoas.size()) {
				System.out.println("ERRO: Posição inválida!");
			}
			else {
				if(pessoas.get(posicao) instanceof Paciente) {
					
					Paciente paciente = (Paciente) pessoas.get(posicao);
					
					System.out.println("==============================");
					System.out.println(paciente);
					System.out.println("==============================");
				}
				else {
					System.out.println("ERRO: Não existe um paciente na posição informada!");
				}
			}
		}
		else {
			System.out.println("AVISO: Não há pessoas cadastradas! Voltando ao menu inicial!");
		}
	}
	
	public void remover() {
		System.out.println("...:::::[ REMOÇÃO DE PACIENTE ]:::::...");
		
		if(!pessoas.isEmpty()) {
			
			System.out.println("Digite a posição do paciente a ser removido: ");
			int posicao = sc.nextInt();
			sc.skip("\r\n");
			
			if(pessoas.get(posicao) instanceof Paciente) {
				System.out.println("O paciente a ser removido é este?");
				Paciente paciente = (Paciente) pessoas.get(posicao);
				
				System.out.println(paciente);
				System.out.println("--------------------------------------");
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				System.out.println("Opção: ");
				int opcao = sc.nextInt();
				sc.skip("\r\n");
				
				if(opcao == 1) {
					pessoas.remove(posicao);
					System.out.println("SUCESSO: Paciente removido!");
				}
				else {
					System.out.println("AVISO: Operação cancelada! Voltando ao menu inicial...");
				}
			}
			else {
				System.out.println("ERRO: Não existe um paciente na posição informada!");
			}
		}
		else {
			System.out.println("AVISO: Não há pessoas cadastrados! Voltando ao menu inicial!");
		}
	}
	
	public void gerarRelatorio() {
		System.out.println("...:::::[ RELATÓRIO DE PACIENTE ]:::::...");
		
		if(!pessoas.isEmpty()) {
			for(Pessoa p : pessoas) {
				if(p instanceof Paciente) {
					System.out.println("Posição " + pessoas.indexOf(p));
					System.out.println(p);
					System.out.println("--------------------------------------");
				}
			}
		}
		else {
			System.out.println("AVISO: Não há pessoas cadastradas! Voltando ao menu inicial!");
		}
	}	
	
	private void lerDados(Paciente paciente) {
		
		System.out.println("1. Digite o nome do paciente: ");
		paciente.setNome(sc.nextLine());
		
		System.out.println("2. Digite a identidade do paciente: ");
		paciente.setIdentidade(sc.nextLine());
		
		System.out.println("3. Digite o CPF do paciente: ");
		paciente.setCpf(sc.nextLine());
		
		System.out.println("4. Digite o endereço do paciente: ");
		paciente.setEndereco(sc.nextLine());
		
		System.out.println("5. Digite o telefone do paciente: ");
		paciente.setTelefone(sc.nextLine());
		
		System.out.println("6. Digite o nome do convênio do paciente: ");
		paciente.setNomeConvenio(sc.nextLine());
		
		System.out.println("7. Digite o número do convênio do paciente: ");
		paciente.setNumeroConvenio(sc.nextLine());
		
	}
}
