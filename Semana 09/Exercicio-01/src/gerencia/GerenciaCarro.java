package gerencia;

import java.util.ArrayList;
import java.util.Scanner;

import model.Carro;

public class GerenciaCarro {
	private ArrayList<Carro> carros;
	private Scanner sc;
	
	public GerenciaCarro(ArrayList<Carro> carros) {
		this.sc = new Scanner(System.in);
		this.carros = carros;
	}
	
	public void incluir() {
		
		System.out.println("==============================");
		System.out.println("INCLUSÃO DE CARRO");
		
		Carro carro = new Carro();
		
		lerDados(carro);
		carros.add(carro);
		
		System.out.println("Carro cadastrado com sucesso!");
		
	}
	
	public void alterar() {
		
		System.out.println("==============================");
		System.out.println("ALTERAÇÃO DE CARRO");
		
		if(carros.isEmpty()) {
			System.out.println("AVISO: Não há carros cadastrados!");
		}
		else {
			System.out.println("Digite a posição do carro para alterar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
					
			String mensagem = "O carro que deseja alterar é este?";
			
			if(validarDados(pos, mensagem)){
				System.out.println("Digite os novos dados: ");
				lerDados(carros.get(pos));
				System.out.println("Carro alterado com sucesso!");
			}
		}
	}
	
	public void remover() {
		System.out.println("==============================");
		System.out.println("REMOÇÃO DE CARRO");
		
		if(carros.isEmpty()) {
			System.out.println("AVISO: Não há carros cadastrados!");
		}
		else {
			System.out.println("Digite a posição do carro para remover: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
			
			String mensagem = "O carro que deseja remover é este?";
			
			if(validarDados(pos, mensagem)){
				carros.remove(pos);
				System.out.println("Carro removido com sucesso!");
			}
		}
	}
	
	public void consultar() {
		System.out.println("==============================");
		System.out.println("CONSULTA DE CARRO");
		
		if(carros.isEmpty()) {
			System.out.println("AVISO: Não há carros cadastrados!");
		}
		else {
			System.out.println("Digite a posição do carro para consultar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
					
			String mensagem = "O carro que deseja consultar é este?";
			
			if(!validarDados(pos, mensagem)){
				consultar();
			}
		}
	}
	
	public void relatorio() {
		System.out.println("==============================");
		System.out.println("RELATÓRIO DE CARROS");
		
		if(carros.isEmpty()) {
			System.out.println("AVISO: Não há carros cadastrados!");
		}
		else {
			for(Carro carro : carros) {
				System.out.println("-------------------------------");
				System.out.println("Posição #" + carros.indexOf(carro));
				imprimir(carro);
			}
			System.out.println("-------------------------------");
		}
	}
	
	private void lerDados(Carro carro) {
		
		System.out.println("1. Digite a marca do carro: ");
		carro.setMarca(sc.nextLine());
		
		System.out.println("2. Digite o modelo do carro: ");
		carro.setModelo(sc.nextLine());
		
		System.out.println("3. Digite o ano de fabricação do carro: ");
		carro.setAnoFabricacao(sc.nextInt());
		sc.skip("\r\n");
		
		System.out.println("4. Digite o ano de modelo do carro: ");
		carro.setAnoModelo(sc.nextInt());
		sc.skip("\r\n");
		
		System.out.println("5. Digite o preço do carro: ");
		carro.setPreco(sc.nextDouble());
		sc.skip("\r\n");
		
		System.out.println("6. Digite a quantidade de portas do carro: ");
		carro.setQuantidadePortas(sc.nextInt());
		sc.skip("\r\n");
		
	}
	
	private void imprimir(Carro carro) {
		System.out.println("Marca                = " + carro.getMarca());
		System.out.println("Modelo               = " + carro.getModelo());
		System.out.println("Ano de Fabricação    = " + carro.getAnoFabricacao());
		System.out.println("Ano de Modelo        = " + carro.getAnoModelo());
		System.out.printf ("Preço                = R$ %.2f\n", carro.getPreco());
		System.out.println("Quantidade de portas = " + carro.getQuantidadePortas());
	}
	
	private boolean validarDados(int pos, String mensagem) {
		
		if(pos < 0 || pos >= carros.size()) {
			System.out.println("ALERTA: Posição inválida. Deve ser um número entre 0 e N-1");
			return false;
		}
		
		System.out.println(mensagem);
		imprimir(carros.get(pos));
		
		System.out.println("[1] Sim");
		System.out.println("[2] Não");
		
		int opcao = sc.nextInt();
		sc.skip("\r\n");
		
		if(opcao != 1) {
			System.out.println("Voltando ao menu inicial...");
			return false;
		}
		
		return true;
	}

}
