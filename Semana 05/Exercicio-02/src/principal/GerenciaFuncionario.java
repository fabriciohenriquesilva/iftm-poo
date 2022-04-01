package principal;

import java.util.Scanner;

public class GerenciaFuncionario {
	private Funcionario[] vetFuncionario;
	private Scanner sc;
	private GerenciaFilho gf;
	
	public GerenciaFuncionario(Funcionario vetor[]) {
		vetFuncionario = vetor;
		sc = new Scanner(System.in);
	}	
	
	public void incluir() {
		int pos = 0, opcao;
		System.out.println("=================================");
		System.out.println("CADASTRO DE FUNCIONÁRIO");
		
		while( (pos < vetFuncionario.length) && (vetFuncionario[pos] != null) ) {
			pos++;
		}
		
		if(pos < vetFuncionario.length) {
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Deseja incluir um funcionario ou um filho de um funcionario?");
			System.out.println("1 - Funcionário");
			System.out.println("2 - Filho");
			
			opcao = Integer.parseInt(sc.nextLine());
			
			if(opcao == 1) {
				Funcionario func = new Funcionario();
				System.out.println("Digite os dados do novo Funcionario: ");
				
				func = cadastrarDados(func);
				
				vetFuncionario[pos] = func;
				Filho[] filhos = new Filho[10];
				vetFuncionario[pos].setFilhos(filhos);
				System.out.println("Funcionario cadastrado com sucesso");
			}
			else if(opcao == 2) {
				System.out.println("Digite a posição em que se encontra o Funcionario para inclusão do filho: ");
				pos = Integer.parseInt(sc.nextLine());
				
				if(validarPosicao(pos, vetFuncionario)) {
					GerenciaFilho gf = new GerenciaFilho(vetFuncionario[pos].getFilhos());
					gf.incluir();
				}
			}
			else {
				System.out.println("Opção inválida");
			}
			
		}
		else {
			System.out.println("Memória cheia");
		}
	}
	
	public void excluir() {
		int pos, opcao;
		Scanner sc = new Scanner(System.in);
		System.out.println("=================================");
		System.out.println("EXCLUSÃO");
		System.out.println("Deseja excluir um funcionario ou um filho de um funcionario?");
		System.out.println("1 - Funcionário");
		System.out.println("2 - Filho");
		
		opcao = Integer.parseInt(sc.nextLine());
		
		if(opcao == 1) {
			System.out.println("Digite a posição em que se encontra o Funcionario para exclusão: ");
			pos = Integer.parseInt(sc.nextLine());
			
			if(validarPosicao(pos, vetFuncionario)) {
				vetFuncionario[pos] = null;
			}
		}
		else if(opcao == 2) {
			System.out.println("Digite a posição em que se encontra o Funcionario para exclusão do filho: ");
			pos = Integer.parseInt(sc.nextLine());
			
			if(validarPosicao(pos, vetFuncionario)) {
				GerenciaFilho gf = new GerenciaFilho(vetFuncionario[pos].getFilhos());
				gf.excluir();
			}
		}
		else {
			System.out.println("Opção inválida");
		}

	}
	
	public void consultar() {
		int pos, opcao;
		System.out.println("=================================");
		System.out.println("CONSULTA DE FUNCIONÁRIO");
		
		System.out.println("Deseja consultar um funcionario ou um filho de um funcionario?");
		System.out.println("1 - Funcionário");
		System.out.println("2 - Filho");
		
		opcao = Integer.parseInt(sc.nextLine()); 
		
		if(opcao == 1) {
			System.out.println("Digite a posição em que se encontra o Funcionario para consulta: ");
			pos = Integer.parseInt(sc.nextLine());
			
			if(validarPosicao(pos, vetFuncionario)) {
				imprimir(vetFuncionario[pos]);
			}
		}
		else if(opcao == 2) {
			System.out.println("Digite a posição em que se encontra o Funcionario para consultar os filhos: ");
			pos = Integer.parseInt(sc.nextLine());
			
			if(validarPosicao(pos, vetFuncionario)) {
				GerenciaFilho gf = new GerenciaFilho(vetFuncionario[pos].getFilhos());
				gf.consultar();
			}
		}
		else {
			System.out.println("Opção inválida");
		}
	}
	
	public void alterar() {
		int opcao, pos;
		System.out.println("=================================");
		System.out.println("ALTERAR FUNCIONÁRIO");
		
		System.out.println("Deseja alterar um funcionario ou um filho de um funcionario?");
		System.out.println("1 - Funcionário");
		System.out.println("2 - Filho");
		
		opcao = Integer.parseInt(sc.nextLine()); 
		
		if(opcao == 1) {
			System.out.println("Digite a posição em que se encontra o Funcionario para alterar: ");
			pos = Integer.parseInt(sc.nextLine());
			
			if(validarPosicao(pos, vetFuncionario)) {
				vetFuncionario[pos] = cadastrarDados(vetFuncionario[pos]);
			}
		}
		else if(opcao == 2) {
			System.out.println("Digite a posição em que se encontra o Funcionario para alterar os filhos: ");
			pos = Integer.parseInt(sc.nextLine());
			
			if(validarPosicao(pos, vetFuncionario)) {
				GerenciaFilho gf = new GerenciaFilho(vetFuncionario[pos].getFilhos());
				gf.alterar();
			}
		}
		else {
			System.out.println("Opção inválida");
		}
		
		
	}
	
	public void gerarRelatorio() {
		System.out.println("=================================");
		System.out.println("RELATÓRIO DE FUNCIONÁRIO");
		for(int i = 0; i < vetFuncionario.length; i++) {
			if(vetFuncionario[i] != null) {
				System.out.println("Funcionário #" + i);
				imprimir(vetFuncionario[i]);
				GerenciaFilho gf = new GerenciaFilho(vetFuncionario[i].getFilhos());
				gf.gerarRelatorio();
				System.out.println("=================================");
			}
		}
	}
	
	public void imprimir(Funcionario Funcionario) {
		System.out.println("CPF: " + Funcionario.getCpf());
		System.out.println("Nome: " + Funcionario.getNome());
		System.out.println("Identidade: " + Funcionario.getIdentidade());
		System.out.println("Salário: " + Funcionario.getSalario());
	}
	
	private Funcionario cadastrarDados(Funcionario func) {
		
		System.out.println("CPF do Funcionario: ");
		func.setCpf(sc.nextLine());
		
		System.out.println("Nome do Funcionario: ");
		func.setNome(sc.nextLine());
		
		System.out.println("Identidade do Funcionario: ");
		func.setIdentidade(sc.nextLine());
		
		System.out.println("Salário do Funcionario: ");
		func.setSalario(Float.parseFloat(sc.nextLine()));
		
		return func;
	}
	
	private boolean validarPosicao(int pos, Funcionario vetFuncionario[]) {
		int err = 0;
		
		if(pos < 0 || pos >= vetFuncionario.length) {
			System.out.println("Posição inválida. Digite uma posição de 0 a n-1, onde n é o tamanho da memória");
			err++;
		}
		
		if(vetFuncionario[pos] == null) {
			System.out.println("Não existe um Funcionario na posição informada");
			err++;
		}
		
		if(err == 0)
			return true;
		else
			return false;
		
	}
}
