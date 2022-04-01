package gerencia;

import java.util.ArrayList;
import java.util.Scanner;

import model.Onibus;

public class GerenciaOnibus {
	
	private Scanner sc;
	private ArrayList<Onibus> vetOnibus;
	
	public GerenciaOnibus(ArrayList<Onibus> vetOnibus) {
		this.sc = new Scanner(System.in);
		this.vetOnibus = vetOnibus;
	}
	
	public void incluir() {
		
		System.out.println("==============================");
		System.out.println("INCLUS�O DE �NIBUS");
		
		Onibus onibus = new Onibus();
		
		lerDados(onibus);
		vetOnibus.add(onibus);
		
		System.out.println("�nibus cadastrado com sucesso!");
		
	}
	
	public void alterar() {
		
		System.out.println("==============================");
		System.out.println("ALTERA��O DE �NIBUS");
		
		if(vetOnibus.isEmpty()) {
			System.out.println("AVISO: N�o h� �nibus cadastrados!");
		}
		else {
			System.out.println("Digite a posi��o do �nibus para alterar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
					
			String mensagem = "O �nibus que deseja alterar � este?";
			
			if(validarDados(pos, mensagem)){
				System.out.println("Digite os novos dados: ");
				lerDados(vetOnibus.get(pos));
				System.out.println("�nibus alterado com sucesso!");
			}
		}
	}
	
	public void remover() {
		System.out.println("==============================");
		System.out.println("REMO��O DE �NIBUS");
		
		if(vetOnibus.isEmpty()) {
			System.out.println("AVISO: N�o h� �nibus cadastrados!");
		}
		else {
			System.out.println("Digite a posi��o do �nibus para remover: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
					
			String mensagem = "O �nibus que deseja remover � este?";
			
			if(validarDados(pos, mensagem)){
				vetOnibus.remove(pos);
				System.out.println("�nibus removido com sucesso!");
			}
		}
	}
	
	public void consultar() {
		System.out.println("==============================");
		System.out.println("CONSULTA DE �NIBUS");
		
		if(vetOnibus.isEmpty()) {
			System.out.println("AVISO: N�o h� �nibus cadastrados!");
		}
		else {
			System.out.println("Digite a posi��o do �nibus para consultar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
					
			String mensagem = "O �nibus que deseja consultar � este?";
			
			if(!validarDados(pos, mensagem)){
				consultar();
			}
		}
	}
	
	public void relatorio() {
		System.out.println("==============================");
		System.out.println("RELAT�RIO DE �NIBUS");
		
		if(vetOnibus.isEmpty()) {
			System.out.println("AVISO: N�o h� �nibus cadastrados!");
		}
		else {
			for(Onibus onibus : vetOnibus) {
				System.out.println("-------------------------------");
				System.out.println("Posi��o #" + vetOnibus.indexOf(onibus));
				imprimir(onibus);
			}
			System.out.println("-------------------------------");
		}
	}
	
	private void lerDados(Onibus onibus) {
		
		System.out.println("1. Digite a marca do �nibus: ");
		onibus.setMarca(sc.nextLine());
		
		System.out.println("2. Digite o modelo do �nibus: ");
		onibus.setModelo(sc.nextLine());
		
		System.out.println("3. Digite o ano de fabrica��o do �nibus: ");
		onibus.setAnoFabricacao(sc.nextInt());
		sc.skip("\r\n");
		
		System.out.println("4. Digite o ano de modelo do �nibus: ");
		onibus.setAnoModelo(sc.nextInt());
		sc.skip("\r\n");
		
		System.out.println("5. Digite o pre�o do �nibus: ");
		onibus.setPreco(sc.nextDouble());
		sc.skip("\r\n");
		
		System.out.println("6. Digite a quantidade de passageiros do �nibus: ");
		onibus.setQuantidadePassageiros(sc.nextInt());
		sc.skip("\r\n");
		
		System.out.println("7. Digite a quantidade de eixos do �nibus: ");
		onibus.setQuantidadeEixos(sc.nextInt());
		sc.skip("\r\n");
		
	}
	
	private void imprimir(Onibus onibus) {
		System.out.println("Marca                       = " + onibus.getMarca());
		System.out.println("Modelo                      = " + onibus.getModelo());
		System.out.println("Ano de Fabrica��o           = " + onibus.getAnoFabricacao());
		System.out.println("Ano de Modelo               = " + onibus.getAnoModelo());
		System.out.println("Pre�o                       = R$ " + onibus.getPreco());
		System.out.println("Quantidade de eixos         = " + onibus.getQuantidadeEixos());
		System.out.println("Quantidade de passageiros   = " + onibus.getQuantidadePassageiros());
	}
	
	private boolean validarDados(int pos, String mensagem) {
		
		if(pos < 0 || pos >= vetOnibus.size()) {
			System.out.println("ALERTA: Posi��o inv�lida. Deve ser um n�mero entre 0 e N-1");
			return false;
		}
		
		System.out.println(mensagem);
		imprimir(vetOnibus.get(pos));
		
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
