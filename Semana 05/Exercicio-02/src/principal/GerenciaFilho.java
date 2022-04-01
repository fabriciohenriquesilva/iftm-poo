package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GerenciaFilho {
	private Filho[] vetFilho;
	private Scanner sc;
	
	public GerenciaFilho(Filho vetor[]) {
		vetFilho = vetor;
		sc = new Scanner(System.in);
	}
	
	public void incluir() {
		int pos = 0;
		System.out.println("=================================");
		System.out.println("CADASTRO DE FILHO");
		
		while( (pos < vetFilho.length) && (vetFilho[pos] != null) ) {
			pos++;
		}
		
		if(pos < vetFilho.length) {
			Filho filho = new Filho();
			
			System.out.println("Digite os dados do novo Filho: ");
			
			filho = cadastrarDados(filho);
			
			vetFilho[pos] = filho;
			System.out.println("Filho cadastrado com sucesso");
		}
		else {
			System.out.println("Mem�ria cheia");
		}
	}
	
	public void excluir() {
		int pos;
		System.out.println("=================================");
		System.out.println("EXCLUS�O DE FILHO");

		System.out.println("Digite a posi��o em que se encontra o Filho para exclus�o: ");
		pos = Integer.parseInt(sc.nextLine());
		
		if(validarPosicao(pos, vetFilho)) {
			vetFilho[pos] = null;
		}
	
	}
	
	public void consultar() {
		int pos;
		System.out.println("=================================");
		System.out.println("CONSULTA DE FILHO");

		System.out.println("Digite a posi��o em que se encontra o Filho para consulta: ");
		pos = Integer.parseInt(sc.nextLine());
		
		if(validarPosicao(pos, vetFilho)) {
			imprimir(vetFilho[pos]);
		}

	}
	
	public void alterar() {
		System.out.println("=================================");
		System.out.println("ALTERAR FILHO");
		System.out.println("Digite a posi��o em que se encontra o Filho para altera��o: ");
		int pos = Integer.parseInt(sc.nextLine());
		
		if(validarPosicao(pos, vetFilho)) {
			vetFilho[pos] = cadastrarDados(vetFilho[pos]);
		}
	}
	
	public void gerarRelatorio() {
		System.out.println("---------------------------------");
		System.out.println("RELAT�RIO DE FILHO");
		for(int i = 0; i < vetFilho.length; i++) {
			if(vetFilho[i] != null) {
				System.out.println("Filho #" + i);
				imprimir(vetFilho[i]);
				System.out.println("---------------------------------");
			}
		}
	}
	
	public void imprimir(Filho filho) {
		System.out.println("CPF: " + filho.getCpf());
		System.out.println("Nome: " + filho.getNome());
		System.out.println("Numero da Certid�o de Nascimento: " + filho.getNumeroDaCertidaoDeNascimento());
		System.out.println("Data de Nascimento: " + filho.getDataDeNascimento());
	}
	
	private Filho cadastrarDados(Filho filho) {
		
		System.out.println("CPF do Filho: ");
		filho.setCpf(sc.nextLine());
		
		System.out.println("Nome do Filho: ");
		filho.setNome(sc.nextLine());
		
		System.out.println("Numero da Certid�o de Nascimento: ");
		filho.setNumeroDaCertidaoDeNascimento(sc.nextLine());
		
		System.out.println("Data de Nascimento do Filho (formato dd/mm/yyyy): ");
		String dataTexto = sc.nextLine();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date nasc;
		try {
			nasc = formato.parse(dataTexto);
			filho.setDataDeNascimento(nasc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filho;
	}
	
	private boolean validarPosicao(int pos, Filho vetFilho[]) {
		int err = 0;
		
		if(pos < 0 || pos >= vetFilho.length) {
			System.out.println("Posi��o inv�lida. Digite uma posi��o de 0 a n-1, onde n � o tamanho da mem�ria");
			err++;
		}
		
		if(vetFilho[pos] == null) {
			System.out.println("N�o existe um Filho na posi��o informada");
			err++;
		}
		
		if(err == 0)
			return true;
		else
			return false;
		
	}

}
