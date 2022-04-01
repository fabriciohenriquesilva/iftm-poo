package principal;

public class Principal {

	public static void main(String[] args) {

		Tempo tempo = new Tempo();
		Tempo agora = new Tempo(15, 05, 27);
		
		System.out.println("Tempo sem argumentos no construtor: ");
		tempo.impressao();
		System.out.println("Tempo \"agora\" criado com parâmetros passados no construtor: ");
		agora.impressao();
		
		Tempo futuro = new Tempo(16, 52, 45);
		System.out.println("Tempo \"futuro\"");
		futuro.impressao();
			
		agora.soma(agora, futuro);
		System.out.println("Tempo \"agora\" somado com o tempo \"futuro\": ");
		agora.impressao();
		
		Tempo somado = new Tempo(9, 25, 30);
		System.out.println("Tempo \"somado\" criado com parâmetros passados no construtor : ");
		somado.impressao();
		tempo = somado.soma(agora);
		System.out.println("Tempo \"tempo\" resultante da adição de \"somado\" com \"agora\"");
		tempo.impressao();
		
		int diferencaEmSegundos = Tempo.diferencaEmSegundos(tempo, agora);
		System.out.println("Diferença em segundos entre \"tempo\" e \"agora\" : " + diferencaEmSegundos);
		
	}

}
