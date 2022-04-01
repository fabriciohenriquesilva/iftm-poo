package principal;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Pessoa[] pessoa = new Pessoa[10];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < pessoa.length; i++) {
			pessoa[i] = new Pessoa();
			System.out.println("============================");
			System.out.println("PESSOA " + (i+1) );
			System.out.println("Digite o nome:");
			pessoa[i].setNome(sc.nextLine());
			
			System.out.println("Digite a idade:");
			pessoa[i].setIdade(sc.nextInt());
			sc.skip("\r\n");

		}
		
		for(int i = (pessoa.length - 1); i >= 0; i--) {
			System.out.println("============================");
			System.out.println("PESSOA " + (i+1) );
			System.out.println("Nome: " + pessoa[i].getNome());
			System.out.println("Idade: " + pessoa[i].getIdade());
		}
		
		sc.close();	
	}
}
