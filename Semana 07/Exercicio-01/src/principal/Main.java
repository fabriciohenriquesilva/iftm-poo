package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int tam = 300;
		//Livro livros[] = new Livro[tam];
		ArrayList<Livro> livros = new ArrayList<Livro>();
		GerenciaLivros biblioteca = new GerenciaLivros(livros, tam);
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("=================================");
			System.out.println("GERENCIADOR DE LIVROS");
			System.out.println("1 - Incluir");
			System.out.println("2 - Excluir");
			System.out.println("3 - Alterar");
			System.out.println("4 - Consultar");
			System.out.println("5 - Relatório");
			System.out.println("0 - Sair");
			System.out.println("Opção: ");
			opcao = Integer.parseInt(sc.nextLine());
			//sc.skip("\r\n");
			
			switch(opcao) {
				case 1:
					biblioteca.incluir();
					break;
				case 2:
					biblioteca.excluir();
					break;
				case 3:
					biblioteca.alterar();
					break;
				case 4:
					biblioteca.consultar();
					break;
				case 5:
					biblioteca.gerarRelatorio();
					break;
				default:
					System.out.println("Encerrando aplicação...");
					break;
			}
		} while(opcao != 0);
		
		sc.close();
	}

}