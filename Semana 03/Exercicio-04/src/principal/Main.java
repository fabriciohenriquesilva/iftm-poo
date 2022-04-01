package principal;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int tam = 5;
		Veiculo[][] veiculos = new Veiculo[tam][tam];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < veiculos.length; i++) {
			veiculos[i] = new Veiculo[tam];
			for(int j = 0; j < veiculos[i].length; j++) {
				veiculos[i][j] = new Veiculo();
				
				System.out.println("============================");
				System.out.println("VEICULO " + (tam*i+j+1) );
				
				System.out.println("Digite a marca: ");
				veiculos[i][j].setMarca(sc.nextLine());
				
				System.out.println("Digite o modelo: ");
				veiculos[i][j].setModelo(sc.nextLine());
				
				System.out.println("Digite o ano de fabricação: ");
				veiculos[i][j].setAnoFabricacao(sc.nextInt());
			
				sc.skip("\r\n");				
			}
		}
		
		for(int i = (veiculos.length - 1); i >= 0; i--) {
			for(int j = (veiculos[i].length - 1); j >= 0; j--) {
				System.out.println("============================");
				System.out.println("VEICULO " + (tam*i+j+1) );
				System.out.println("Marca: " + veiculos[i][j].getMarca());
				System.out.println("Modelo: " + veiculos[i][j].getModelo());
				System.out.println("Ano de Fabricação: " + veiculos[i][j].getAnoFabricacao());
			}
		}
		
		sc.close();
	}
}
