package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GerenciaFilho {
	private ArrayList<Filho> vetFilho;
	private Scanner sc;
	int tam;
	
	public GerenciaFilho(ArrayList<Filho> vetor) {
		vetFilho = vetor;
		sc = new Scanner(System.in);
		this.tam = 10;
	}
	
	public void incluir() {
		System.out.println("=================================");
		System.out.println("CADASTRO DE FILHO");
		
		if(vetFilho.size() <= tam) {
			Filho filho = new Filho();
			
			System.out.println("Digite os dados do novo Filho: ");
			
			cadastrarDados(filho);
			vetFilho.add(filho);
			
			System.out.println("Filho cadastrado com sucesso");
		}
		else {
			System.out.println("Memória cheia");
		}
	}
	
	public void excluir() {
		int pos;
		System.out.println("=================================");
		System.out.println("EXCLUSÃO DE FILHO");

		System.out.println("Digite a posição em que se encontra o Filho para exclusão: ");
		pos = Integer.parseInt(sc.nextLine());
		
		if(validarPosicao(pos, vetFilho)) {
			System.out.println("O filho que deseja remover é este?");
			imprimir(vetFilho.get(pos));
			
			System.out.println("[1] Sim");
			System.out.println("[2] Não");
			int opcao = Integer.parseInt(sc.nextLine());
			
			if(opcao == 1) {
				vetFilho.remove(pos);
				System.out.println("Filho excluído");
			} else {
				System.out.println("Voltando ao menu principal");
			}
		}
	}
	
	public void consultar() {
		int pos;
		System.out.println("=================================");
		System.out.println("CONSULTA DE FILHO");

		System.out.println("Digite a posição em que se encontra o Filho para consulta: ");
		pos = Integer.parseInt(sc.nextLine());
		
		if(validarPosicao(pos, vetFilho)) {
			imprimir(vetFilho.get(pos));
		}
	}
	
	public void alterar() {
		System.out.println("=================================");
		System.out.println("ALTERAR FILHO");
		System.out.println("Digite a posição em que se encontra o Filho para alteração: ");
		int pos = Integer.parseInt(sc.nextLine());
		
		if(validarPosicao(pos, vetFilho)) {
			
			System.out.println("O filho que deseja alterar é este?");
			imprimir(vetFilho.get(pos));
			
			System.out.println("[1] Sim");
			System.out.println("[2] Não");
			int opcao = Integer.parseInt(sc.nextLine());
			
			if(opcao == 1) {
				cadastrarDados(vetFilho.get(pos));
				System.out.println("Filho alterado");
			} else {
				System.out.println("Voltando ao menu principal");
			}	
		}
	}
	
	public void gerarRelatorio() {
		System.out.println("*********************************");
		System.out.println("RELATÓRIO DE FILHOS");
		
		if(vetFilho.isEmpty()) {
			System.out.println("Não há filhos cadastrados");
		}
		
		for(Filho filho : vetFilho) {
			System.out.println("Filho #" + vetFilho.indexOf(filho));
			imprimir(filho);
			System.out.println("*********************************");
		}
	}
	
	public void imprimir(Filho filho) {
		System.out.println("CPF: " + filho.getCpf());
		System.out.println("Nome: " + filho.getNome());
		System.out.println("Numero da Certidão de Nascimento: " + filho.getNumeroDaCertidaoDeNascimento());
		System.out.println("Data de Nascimento: " + filho.getDataDeNascimento());
	}
	
	private void cadastrarDados(Filho filho) {
		
		System.out.println("CPF do Filho: ");
		filho.setCpf(sc.nextLine());
		
		System.out.println("Nome do Filho: ");
		filho.setNome(sc.nextLine());
		
		System.out.println("Numero da Certidão de Nascimento: ");
		filho.setNumeroDaCertidaoDeNascimento(sc.nextLine());
		
		System.out.println("Data de Nascimento do Filho (formato dd/mm/yyyy): ");
		String dataTexto = sc.nextLine();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date nasc;
		
		try {
			nasc = formato.parse(dataTexto);
			filho.setDataDeNascimento(nasc);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private boolean validarPosicao(int pos, ArrayList<Filho> vetFilho) {
	
		if(pos < 0 || pos >= vetFilho.size()) {
			System.out.println("Posição inválida. Digite uma posição de 0 a n-1, onde n é o tamanho da memória");
			return false;
		}
		
		if(vetFilho.isEmpty()) {
			System.out.println("Não há filhos cadastrados");
			return false;
		}
		
		return true;
	}
}
