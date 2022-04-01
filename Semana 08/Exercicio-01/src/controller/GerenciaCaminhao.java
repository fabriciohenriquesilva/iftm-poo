package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Caminhao;

public class GerenciaCaminhao {

	Scanner sc;
	ArrayList<Caminhao> caminhoes;
	
	public GerenciaCaminhao(ArrayList<Caminhao> caminhoes) {
		this.sc = new Scanner(System.in);
		this.caminhoes = caminhoes;
	}
	
	public void incluir() {
		
		System.out.println("==============================");
		System.out.println("INCLUSÃO DE CAMINHÃO");
		
		Caminhao caminhao = new Caminhao();
		
		lerDados(caminhao);
		caminhoes.add(caminhao);
		
		System.out.println("Caminhão cadastrado com sucesso!");
		
	}
	
	public void alterar() {
		
		System.out.println("==============================");
		System.out.println("ALTERAÇÃO DE CAMINHÃO");
		
		System.out.println("Digite a posição do caminhão para alterar: ");
		int pos = Integer.parseInt(sc.nextLine());
				
		String mensagem = "O caminhão que deseja alterar é este?";
		
		if(!validarDados(pos, mensagem)){
			return;
		}
		
		System.out.println("Digite os novos dados: ");
		lerDados(caminhoes.get(pos));
		
		System.out.println("Caminhão alterado com sucesso!");
		
	}
	
	public void remover() {
		System.out.println("==============================");
		System.out.println("REMOÇÃO DE CAMINHÕES");
		
		System.out.println("Digite a posição do caminhão para remover: ");
		int pos = Integer.parseInt(sc.nextLine());
				
		String mensagem = "O caminhão que deseja remover é este?";
		
		if(!validarDados(pos, mensagem)){
			return;
		}
		
		caminhoes.remove(pos);
		
		System.out.println("Caminhão removido com sucesso!");
	}
	
	public void consultar() {
		System.out.println("==============================");
		System.out.println("CONSULTA DE CAMINHÃO");
		
		System.out.println("Digite a posição do caminhão para consultar: ");
		int pos = Integer.parseInt(sc.nextLine());
				
		String mensagem = "O caminhão que deseja consultar é este?";
		
		if(!validarDados(pos, mensagem)){
			consultar();
		}
	}
	
	public void relatorio() {
		System.out.println("==============================");
		System.out.println("RELATÓRIO DE CAMINHÕES");
		
		if(caminhoes.isEmpty()) {
			System.out.println("AVISO: Não há caminhões cadastrados!");
			return;
		}
		
		for(Caminhao caminhao : caminhoes) {
			System.out.println("-------------------------------");
			System.out.println("Posição #" + caminhoes.indexOf(caminhao));
			imprimir(caminhao);
		}
		System.out.println("-------------------------------");
	}
	
	private void lerDados(Caminhao caminhao) {
		
		System.out.println("1. Digite a marca do caminhão: ");
		caminhao.setMarca(sc.nextLine());
		
		System.out.println("2. Digite o modelo do caminhão: ");
		caminhao.setModelo(sc.nextLine());
		
		System.out.println("3. Digite o ano de fabricação do caminhão: ");
		caminhao.setAnoFabricacao(Integer.parseInt(sc.nextLine()));
		
		System.out.println("4. Digite o ano de modelo do caminhão: ");
		caminhao.setAnoModelo(Integer.parseInt(sc.nextLine()));
		
		System.out.println("5. Digite o preço do caminhão: ");
		caminhao.setPreco(Double.parseDouble(sc.nextLine()));
		
		System.out.println("6. Digite a capacidade de carga do caminhão: ");
		caminhao.setCapacidadeDeCarga(Float.parseFloat(sc.nextLine()));
		
	}
	
	private void imprimir(Caminhao caminhao) {
		System.out.println("Marca                = " + caminhao.getMarca());
		System.out.println("Modelo               = " + caminhao.getModelo());
		System.out.println("Ano de Fabricação    = " + caminhao.getAnoFabricacao());
		System.out.println("Ano de Modelo        = " + caminhao.getAnoModelo());
		System.out.println("Preço                = R$ " + caminhao.getPreco());
		System.out.println("Capacidade carga     = " + caminhao.getCapacidadeDeCarga());
	}
	
	private boolean validarDados(int pos, String messagem) {
		
		if(caminhoes.isEmpty()) {
			System.out.println("AVISO: Não há caminhões cadastrados!");
			return false;
		}
		if(pos < 0 || pos >= caminhoes.size()) {
			System.out.println("ALERTA: Posição inválida. Deve ser um número entre 0 e N-1");
			return false;
		}
		
		System.out.println(messagem);
		imprimir(caminhoes.get(pos));
		
		System.out.println("[1] Sim");
		System.out.println("[2] Não");
		
		int opcao = Integer.parseInt(sc.nextLine());
		
		if(opcao != 1) {
			System.out.println("Voltando ao menu inicial...");
			return false;
		}
		
		return true;
	}
	
}
