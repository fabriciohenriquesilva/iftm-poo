package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Carro;

public class GerenciaCarro {
	
	Scanner sc;
	ArrayList<Carro> carros;
	
	public GerenciaCarro(ArrayList<Carro> carros) {
		this.sc = new Scanner(System.in);
		this.carros = carros;
	}
	
	public void incluir() {
		
		// System.out.println("");
		System.out.println("==============================");
		System.out.println("INCLUS�O DE CARRO");
		
		Carro carro = new Carro();
		
		lerDados(carro);
		carros.add(carro);
		
		System.out.println("Carro cadastrado com sucesso!");
		
	}
	
	public void alterar() {
		
		System.out.println("==============================");
		System.out.println("ALTERA��O DE CARRO");
		
		System.out.println("Digite a posi��o do carro para alterar: ");
		int pos = Integer.parseInt(sc.nextLine());
				
		String mensagem = "O carro que deseja alterar � este?";
		
		if(!validarDados(pos, mensagem)){
			return;
		}
		
		System.out.println("Digite os novos dados: ");
		lerDados(carros.get(pos));
		
		System.out.println("Carro alterado com sucesso!");
		
	}
	
	public void remover() {
		System.out.println("==============================");
		System.out.println("REMO��O DE CARRO");
		
		System.out.println("Digite a posi��o do carro para remover: ");
		int pos = Integer.parseInt(sc.nextLine());
				
		String mensagem = "O carro que deseja remover � este?";
		
		if(!validarDados(pos, mensagem)){
			return;
		}
		
		carros.remove(pos);
		
		System.out.println("Carro removido com sucesso!");
	}
	
	public void consultar() {
		System.out.println("==============================");
		System.out.println("CONSULTA DE CARRO");
		
		System.out.println("Digite a posi��o do carro para consultar: ");
		int pos = Integer.parseInt(sc.nextLine());
				
		String mensagem = "O carro que deseja consultar � este?";
		
		if(!validarDados(pos, mensagem)){
			consultar();
		}
		
	}
	
	public void relatorio() {
		System.out.println("==============================");
		System.out.println("RELAT�RIO DE CARROS");
		
		if(carros.isEmpty()) {
			System.out.println("AVISO: N�o h� carros cadastrados!");
			return;
		}
		
		for(Carro carro : carros) {
			System.out.println("-------------------------------");
			System.out.println("Posi��o #" + carros.indexOf(carro));
			imprimir(carro);
		}
		System.out.println("-------------------------------");
	}
	
	private void lerDados(Carro carro) {
		
		System.out.println("1. Digite a marca do carro: ");
		carro.setMarca(sc.nextLine());
		
		System.out.println("2. Digite o modelo do carro: ");
		carro.setModelo(sc.nextLine());
		
		System.out.println("3. Digite o ano de fabrica��o do carro: ");
		carro.setAnoFabricacao(Integer.parseInt(sc.nextLine()));
		
		System.out.println("4. Digite o ano de modelo do carro: ");
		carro.setAnoModelo(Integer.parseInt(sc.nextLine()));
		
		System.out.println("5. Digite o pre�o do carro: ");
		carro.setPreco(Double.parseDouble(sc.nextLine()));
		
		System.out.println("6. Digite a quantidade de portas do carro: ");
		carro.setQuantidadePortas(Integer.parseInt(sc.nextLine()));
		
	}
	
	private void imprimir(Carro carro) {
		System.out.println("Marca                = " + carro.getMarca());
		System.out.println("Modelo               = " + carro.getModelo());
		System.out.println("Ano de Fabrica��o    = " + carro.getAnoFabricacao());
		System.out.println("Ano de Modelo        = " + carro.getAnoModelo());
		System.out.printf("Pre�o                = R$ %.2f\n", carro.getPreco());
		System.out.println("Quantidade de portas = " + carro.getQuantidadePortas());
	}
	
	private boolean validarDados(int pos, String messagem) {
		
		if(carros.isEmpty()) {
			System.out.println("AVISO: N�o h� carros cadastrados!");
			return false;
		}
		if(pos < 0 || pos >= carros.size()) {
			System.out.println("ALERTA: Posi��o inv�lida. Deve ser um n�mero entre 0 e N-1");
			return false;
		}
		
		System.out.println(messagem);
		imprimir(carros.get(pos));
		
		System.out.println("[1] Sim");
		System.out.println("[2] N�o");
		
		int opcao = Integer.parseInt(sc.nextLine());
		
		if(opcao != 1) {
			System.out.println("Voltando ao menu inicial...");
			return false;
		}
		
		return true;
	}
	
}
