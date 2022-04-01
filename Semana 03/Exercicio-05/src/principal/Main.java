package principal;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int n = 100;
		int[] vet1, vet2, vet3;
		vet1 = new int[n];
		vet2 = new int[n];
		vet3 = new int[n];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < n; i++) {
			System.out.println("Digite o valor " + (i+1) + " do vetor 1: ");
			vet1[i] = sc.nextInt();
			sc.skip("\r\n");
			
			System.out.println("Digite o valor " + (i+1) + " do vetor 2: ");
			vet2[i] = sc.nextInt();
			sc.skip("\r\n");
		}
		
		for(int i = 0, j = (n-1); i < n; i++, j--) {
			vet3[i] = vet1[i] * vet2[j];
		}
		
		for(int i = (n-1); i >= 0; i--) {
			System.out.printf("vet3[%d] = " + vet3[i] + "\n", i);
		}
	}
}
