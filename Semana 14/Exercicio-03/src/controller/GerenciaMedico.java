package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Medico;
import model.Pessoa;

public class GerenciaMedico implements Gerencia {

	private Scanner sc;
	private ArrayList<Pessoa> pessoas;
	
	public GerenciaMedico(ArrayList<Pessoa> pessoas) {
		sc = new Scanner(System.in);
		this.pessoas = pessoas;
	}
	
	public void adicionar() {

		System.out.println("...:::::[ CADASTRO DE MÉDICO ]:::::...");
		
		Medico medico = new Medico();
		
		lerDados(medico);
		
		pessoas.add(medico);
		System.out.println("SUCESSO: Médico cadastrado!");
	}
	
	public void alterar() {
		System.out.println("...:::::[ ALTERAÇÃO DE MÉDICO ]:::::...");
		
		if(!pessoas.isEmpty()) {
			System.out.println("Digite a posição do médico a ser alterado: ");
			int posicao = sc.nextInt();
			sc.skip("\r\n");
			
			if(pessoas.get(posicao) instanceof Medico) {
				
				System.out.println("O médico a ser alterado é este?");
				Medico medico = (Medico) pessoas.get(posicao);				
				
				System.out.println(medico);
				System.out.println("--------------------------------------");
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				System.out.println("Opção: ");
				int opcao = sc.nextInt();
				sc.skip("\r\n");
				
				if(opcao == 1) {
					lerDados(medico);
					System.out.println("SUCESSO: Médico alterado!");
				}
				else {
					System.out.println("AVISO: Operação cancelada! Voltando ao menu inicial...");
				}
			}
			else {
				System.out.println("AVISO: Não existe um médico na posição informada!");
			}	
		}
		else {
			System.out.println("AVISO: Não há pessoas cadastradas! Voltando ao menu inicial!");
		}
	}
	
	public void consultar() {

		System.out.println("...:::::[ CONSULTA DE MÉDICO ]:::::...");
		
		if(!pessoas.isEmpty()) {
			
			System.out.println("Digite a posição do médico a ser consultado: ");
			int posicao = sc.nextInt();
			sc.skip("\r\n");
			
			if(posicao < 0 || posicao >= pessoas.size()) {
				System.out.println("ERRO: Posição inválida!");
			}
			else {
				if(pessoas.get(posicao) instanceof Medico) {
					
					Medico medico = (Medico) pessoas.get(posicao);
					
					System.out.println("==============================");
					System.out.println(medico);
					System.out.println("==============================");
				}
				else {
					System.out.println("ERRO: Não existe um médico na posição informada!");
				}
			}
		}
		else {
			System.out.println("AVISO: Não há pessoas cadastradas! Voltando ao menu inicial!");
		}
	}
	
	public void remover() {
		System.out.println("...:::::[ REMOÇÃO DE MÉDICO ]:::::...");
		
		if(!pessoas.isEmpty()) {
			
			System.out.println("Digite a posição do médico a ser removido: ");
			int posicao = sc.nextInt();
			sc.skip("\r\n");
			
			if(pessoas.get(posicao) instanceof Medico) {
				System.out.println("O médico a ser removido é este?");
				Medico medico = (Medico) pessoas.get(posicao);
				
				System.out.println(medico);
				System.out.println("--------------------------------------");
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				System.out.println("Opção: ");
				int opcao = sc.nextInt();
				sc.skip("\r\n");
				
				if(opcao == 1) {
					pessoas.remove(posicao);
					System.out.println("SUCESSO: Médico removido!");
				}
				else {
					System.out.println("AVISO: Operação cancelada! Voltando ao menu inicial...");
				}
			}
			else {
				System.out.println("ERRO: Não existe um médico na posição informada!");
			}
		}
		else {
			System.out.println("AVISO: Não há pessoas cadastrados! Voltando ao menu inicial!");
		}
	}
	
	public void gerarRelatorio() {
		System.out.println("...:::::[ RELATÓRIO DE MÉDICO ]:::::...");
		
		if(!pessoas.isEmpty()) {
			for(Pessoa p : pessoas) {
				if(p instanceof Medico) {
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
	
	private void lerDados(Medico medico) {
		
		System.out.println("1. Digite o nome do médico: ");
		medico.setNome(sc.nextLine());
		
		System.out.println("2. Digite a identidade do médico: ");
		medico.setIdentidade(sc.nextLine());
		
		System.out.println("3. Digite o CPF do médico: ");
		medico.setCpf(sc.nextLine());
		
		System.out.println("4. Digite o endereço do médico: ");
		medico.setEndereco(sc.nextLine());
		
		System.out.println("5. Digite o telefone do médico: ");
		medico.setTelefone(sc.nextLine());
		
		System.out.println("6. Digite o CRM do médico: ");
		medico.setCrm(sc.nextLine());
		
		System.out.println("7. Digite a especialidade do médico: ");
		medico.setEspecialidade(sc.nextLine());
		
		System.out.println("7. Digite o número da Carteira de Trabalho da Previdência Social do médico: ");
		medico.setCtps(sc.nextLine());
	}
}
