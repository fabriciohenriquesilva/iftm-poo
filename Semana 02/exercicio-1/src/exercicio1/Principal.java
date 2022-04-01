package exercicio1;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Aluno aluno1 = criarAluno(sc);
		Aluno aluno2 = criarAluno(sc);
		Aluno aluno3 = criarAluno(sc);
		
		int opcao;
		
		do {
			System.out.println("Como deseja imprimir os dados de alunos? ");
			System.out.println("[1] Imprimir de um único aluno informando a matricula");
			System.out.println("[2] Imprimir de todos os alunos");
			System.out.println("[0] Sair");
			
			opcao = sc.nextInt();
			sc.skip("\r\n");
			
			if(opcao == 1) {
				System.out.println("Digite o número da matricula: ");
				int matricula = sc.nextInt();
				if(aluno1.getMatricula() == matricula) {
					aluno1.impressao();
				}
				else if(aluno2.getMatricula() == matricula) {
					aluno2.impressao();
				}
				else if(aluno3.getMatricula() == matricula) {
					aluno3.impressao();
				}
				else {
					System.out.println("Aluno não encontrado.");
				}
			}
			else if(opcao == 2) {
				aluno1.impressao();
				aluno2.impressao();
				aluno3.impressao();
			}
			else if(opcao == 0) {
				System.out.println("Encerrando aplicação...");
			}
			else {
				System.out.println("Opção inválida");
			}
		} while(opcao != 0);
		sc.close();
	}
	
	
	public static Aluno criarAluno(Scanner sc) {
		int matricula, anoIngresso;
		String nome, telefone, curso;
		
		System.out.println("Digite a matricula do aluno: ");
		matricula = sc.nextInt();
		sc.skip("\r\n");
		
		System.out.println("Digite o nome do aluno: ");
		nome = sc.nextLine();
		
		System.out.println("Digite o telefone do aluno: ");
		telefone = sc.nextLine();
		
		System.out.println("Digite o ano de ingresso do aluno: ");
		anoIngresso = sc.nextInt();
		sc.skip("\r\n");
		
		System.out.println("Digite o curso do aluno: ");
		curso = sc.nextLine();
				
		System.out.println("==================================");
		
		Aluno aluno = new Aluno(matricula, nome, telefone, anoIngresso, curso);
		
		return aluno;
			
	}

}
