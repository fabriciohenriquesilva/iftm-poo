package gerencia;

import java.util.ArrayList;
import java.util.Scanner;

import model.Caminhao;

public class GerenciaCaminhao {

	private Scanner sc;
	private ArrayList<Caminhao> caminhoes;
	
	public GerenciaCaminhao(ArrayList<Caminhao> caminhoes) {
		this.sc = new Scanner(System.in);
		this.caminhoes = caminhoes;
	}
	
	public void incluir() {
		
		System.out.println("==============================");
		System.out.println("INCLUS�O DE CAMINH�O");
		
		Caminhao caminhao = new Caminhao();
		
		lerDados(caminhao);
		caminhoes.add(caminhao);
		
		System.out.println("Caminh�o cadastrado com sucesso!");
		
	}
	
	public void alterar() {
		
		System.out.println("==============================");
		System.out.println("ALTERA��O DE CAMINH�O");
		
		if(caminhoes.isEmpty()) {
			System.out.println("AVISO: N�o h� caminh�es cadastrados!");
		}
		else {
			System.out.println("Digite a posi��o do caminh�o para alterar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
					
			String mensagem = "O caminh�o que deseja alterar � este?";
			
			if(validarDados(pos, mensagem)){
				System.out.println("Digite os novos dados: ");
				lerDados(caminhoes.get(pos));
				System.out.println("Caminh�o alterado com sucesso!");			
			}
		}
	}
	
	public void remover() {
		System.out.println("==============================");
		System.out.println("REMO��O DE CAMINH�ES");
		
		if(caminhoes.isEmpty()) {
			System.out.println("AVISO: N�o h� caminh�es cadastrados!");
		}
		else {
			System.out.println("Digite a posi��o do caminh�o para remover: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
					
			String mensagem = "O caminh�o que deseja remover � este?";
			
			if(validarDados(pos, mensagem)){
				caminhoes.remove(pos);
				System.out.println("Caminh�o removido com sucesso!");
			}
		}
	}
	
	public void consultar() {
		System.out.println("==============================");
		System.out.println("CONSULTA DE CAMINH�O");
		
		if(caminhoes.isEmpty()) {
			System.out.println("AVISO: N�o h� caminh�es cadastrados!");
		}
		else {
			System.out.println("Digite a posi��o do caminh�o para consultar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
					
			String mensagem = "O caminh�o que deseja consultar � este?";
			
			if(!validarDados(pos, mensagem)){
				consultar();
			}
		}
	}
	
	public void relatorio() {
		System.out.println("==============================");
		System.out.println("RELAT�RIO DE CAMINH�ES");
		
		if(caminhoes.isEmpty()) {
			System.out.println("AVISO: N�o h� caminh�es cadastrados!");
		}
		else {
			for(Caminhao caminhao : caminhoes) {
				System.out.println("-------------------------------");
				System.out.println("Posi��o #" + caminhoes.indexOf(caminhao));
				imprimir(caminhao);
			}
			System.out.println("-------------------------------");
		}
	}
	
	private void lerDados(Caminhao caminhao) {
		
		System.out.println("1. Digite a marca do caminh�o: ");
		caminhao.setMarca(sc.nextLine());
		
		System.out.println("2. Digite o modelo do caminh�o: ");
		caminhao.setModelo(sc.nextLine());
		
		System.out.println("3. Digite o ano de fabrica��o do caminh�o: ");
		caminhao.setAnoFabricacao(sc.nextInt());
		sc.skip("\r\n");
		
		System.out.println("4. Digite o ano de modelo do caminh�o: ");
		caminhao.setAnoModelo(sc.nextInt());
		sc.skip("\r\n");
		
		System.out.println("5. Digite o pre�o do caminh�o: ");
		caminhao.setPreco(sc.nextDouble());
		sc.skip("\r\n");
		
		System.out.println("6. Digite a capacidade de carga do caminh�o: ");
		caminhao.setCapacidadeDeCarga(sc.nextFloat());
		sc.skip("\r\n");
		
	}
	
	private void imprimir(Caminhao caminhao) {
		System.out.println("Marca                = " + caminhao.getMarca());
		System.out.println("Modelo               = " + caminhao.getModelo());
		System.out.println("Ano de Fabrica��o    = " + caminhao.getAnoFabricacao());
		System.out.println("Ano de Modelo        = " + caminhao.getAnoModelo());
		System.out.printf ("Pre�o                = R$ %.2f\n", caminhao.getPreco());
		System.out.println("Capacidade carga     = " + caminhao.getCapacidadeDeCarga());
	}
	
	private boolean validarDados(int pos, String mensagem) {
		
		if(pos < 0 || pos >= caminhoes.size()) {
			System.out.println("ALERTA: Posi��o inv�lida. Deve ser um n�mero entre 0 e N-1");
			return false;
		}
		
		System.out.println(mensagem);
		imprimir(caminhoes.get(pos));
		
		System.out.println("[1] Sim");
		System.out.println("[2] N�o");
		
		int opcao = sc.nextInt();
		sc.skip("\r\n");
		
		if(opcao != 1) {
			System.out.println("Voltando ao menu inicial...");
			return false;
		}
		return true;
	}
}