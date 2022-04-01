package principal;

public class Main {

	public static void main(String[] args) {
		
		Cliente cliA, cliB;
		
		cliA = new Cliente(1, "Luiza");
		cliA.atualizaSituacao(true);
		cliB = new Cliente(2, "Wesley");
		
		if(!cliA.atualizaLimite(500)) {
			System.out.println("-> Este não é um cliente especial");
		}
		
		cliB = cliA;
		cliB.atualizaSituacao(false);
		
		if(!cliA.atualizaLimite(700)) {
			System.out.println("--> Este não é um cliente especial");
		}

	}

}
