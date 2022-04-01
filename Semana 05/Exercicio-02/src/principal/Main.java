package principal;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int tam = 3;
		Funcionario funcionarios[] = new Funcionario[tam];
		GerenciaFuncionario departamento = new GerenciaFuncionario(funcionarios);
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("=================================");
			System.out.println("REGISTRO DE PESSOAS");
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
					departamento.incluir();
					break;
				case 2:
					departamento.excluir();
					break;
				case 3:
					departamento.alterar();
					break;
				case 4:
					departamento.consultar();
					break;
				case 5:
					departamento.gerarRelatorio();
					break;
				default:
					break;
			}
		} while(opcao != 0);
		
		sc.close();
	}

}