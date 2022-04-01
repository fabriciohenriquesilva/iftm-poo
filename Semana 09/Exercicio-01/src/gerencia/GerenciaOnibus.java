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
		System.out.println("INCLUSÃO DE ÔNIBUS");
		
		Onibus onibus = new Onibus();
		
		lerDados(onibus);
		vetOnibus.add(onibus);
		
		System.out.println("Ônibus cadastrado com sucesso!");
		
	}
	
	public void alterar() {
		
		System.out.println("==============================");
		System.out.println("ALTERAÇÃO DE ÔNIBUS");
		
		if(vetOnibus.isEmpty()) {
			System.out.println("AVISO: Não há ônibus cadastrados!");
		}
		else {
			System.out.println("Digite a posição do ônibus para alterar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
					
			String mensagem = "O ônibus que deseja alterar é este?";
			
			if(validarDados(pos, mensagem)){
				System.out.println("Digite os novos dados: ");
				lerDados(vetOnibus.get(pos));
				System.out.println("Ônibus alterado com sucesso!");
			}
		}
	}
	
	public void remover() {
		System.out.println("==============================");
		System.out.println("REMOÇÃO DE ÔNIBUS");
		
		if(vetOnibus.isEmpty()) {
			System.out.println("AVISO: Não há ônibus cadastrados!");
		}
		else {
			System.out.println("Digite a posição do ônibus para remover: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
					
			String mensagem = "O ônibus que deseja remover é este?";
			
			if(validarDados(pos, mensagem)){
				vetOnibus.remove(pos);
				System.out.println("Ônibus removido com sucesso!");
			}
		}
	}
	
	public void consultar() {
		System.out.println("==============================");
		System.out.println("CONSULTA DE ÔNIBUS");
		
		if(vetOnibus.isEmpty()) {
			System.out.println("AVISO: Não há ônibus cadastrados!");
		}
		else {
			System.out.println("Digite a posição do ônibus para consultar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
					
			String mensagem = "O ônibus que deseja consultar é este?";
			
			if(!validarDados(pos, mensagem)){
				consultar();
			}
		}
	}
	
	public void relatorio() {
		System.out.println("==============================");
		System.out.println("RELATÓRIO DE ÔNIBUS");
		
		if(vetOnibus.isEmpty()) {
			System.out.println("AVISO: Não há ônibus cadastrados!");
		}
		else {
			for(Onibus onibus : vetOnibus) {
				System.out.println("-------------------------------");
				System.out.println("Posição #" + vetOnibus.indexOf(onibus));
				imprimir(onibus);
			}
			System.out.println("-------------------------------");
		}
	}
	
	private void lerDados(Onibus onibus) {
		
		System.out.println("1. Digite a marca do ônibus: ");
		onibus.setMarca(sc.nextLine());
		
		System.out.println("2. Digite o modelo do ônibus: ");
		onibus.setModelo(sc.nextLine());
		
		System.out.println("3. Digite o ano de fabricação do ônibus: ");
		onibus.setAnoFabricacao(sc.nextInt());
		sc.skip("\r\n");
		
		System.out.println("4. Digite o ano de modelo do ônibus: ");
		onibus.setAnoModelo(sc.nextInt());
		sc.skip("\r\n");
		
		System.out.println("5. Digite o preço do ônibus: ");
		onibus.setPreco(sc.nextDouble());
		sc.skip("\r\n");
		
		System.out.println("6. Digite a quantidade de passageiros do ônibus: ");
		onibus.setQuantidadePassageiros(sc.nextInt());
		sc.skip("\r\n");
		
		System.out.println("7. Digite a quantidade de eixos do ônibus: ");
		onibus.setQuantidadeEixos(sc.nextInt());
		sc.skip("\r\n");
		
	}
	
	private void imprimir(Onibus onibus) {
		System.out.println("Marca                       = " + onibus.getMarca());
		System.out.println("Modelo                      = " + onibus.getModelo());
		System.out.println("Ano de Fabricação           = " + onibus.getAnoFabricacao());
		System.out.println("Ano de Modelo               = " + onibus.getAnoModelo());
		System.out.println("Preço                       = R$ " + onibus.getPreco());
		System.out.println("Quantidade de eixos         = " + onibus.getQuantidadeEixos());
		System.out.println("Quantidade de passageiros   = " + onibus.getQuantidadePassageiros());
	}
	
	private boolean validarDados(int pos, String mensagem) {
		
		if(pos < 0 || pos >= vetOnibus.size()) {
			System.out.println("ALERTA: Posição inválida. Deve ser um número entre 0 e N-1");
			return false;
		}
		
		System.out.println(mensagem);
		imprimir(vetOnibus.get(pos));
		
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
