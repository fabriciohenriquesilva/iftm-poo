package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaFuncionario {
	private ArrayList<Funcionario> vetFuncionario;
	private Scanner sc;
	private GerenciaFilho gf;
	private int tam;
	
	public GerenciaFuncionario(ArrayList<Funcionario> funcionarios) {
		vetFuncionario = funcionarios;
		sc = new Scanner(System.in);
		this.tam = 50;
	}	
	
	public void incluir() {
		int pos = 0, opcao;
		System.out.println("=================================");
		System.out.println("CADASTRO DE FUNCION�RIO");
		
		if(vetFuncionario.size() <= tam) {
		
			System.out.println("Deseja incluir um funcionario ou um filho de um funcionario?");
			System.out.println("1 - Funcion�rio");
			System.out.println("2 - Filho");
			
			opcao = Integer.parseInt(sc.nextLine());
			
			if(opcao == 1) {
				Funcionario func = new Funcionario();
				System.out.println("Digite os dados do novo Funcionario: ");
				
				cadastrarDados(func);
				vetFuncionario.add(func);
				
				System.out.println("Funcionario cadastrado com sucesso");
			}
			else if(opcao == 2) {
				System.out.println("Digite a posi��o em que se encontra o Funcionario para inclus�o do filho: ");
				pos = Integer.parseInt(sc.nextLine());
				
				if(validarPosicao(pos, vetFuncionario)) {
					gf = new GerenciaFilho(vetFuncionario.get(pos).getFilhos());
					gf.incluir();
				}
			}
			else {
				System.out.println("Op��o inv�lida");
			}
			
		}
		else {
			System.out.println("Mem�ria cheia");
		}
	}
	
	public void excluir() {
		int pos, opcao;
		System.out.println("=================================");
		System.out.println("EXCLUS�O");
		System.out.println("Deseja excluir um funcionario ou um filho de um funcionario?");
		System.out.println("1 - Funcion�rio");
		System.out.println("2 - Filho");
		
		opcao = Integer.parseInt(sc.nextLine());
		
		if(opcao == 1) {
			System.out.println("Digite a posi��o em que se encontra o Funcionario para exclus�o: ");
			pos = Integer.parseInt(sc.nextLine());
			
			if(validarPosicao(pos, vetFuncionario)) {
				
				System.out.println("O funcion�rio que deseja remover � este?");
				imprimir(vetFuncionario.get(pos));
				
				System.out.println("[1] Sim");
				System.out.println("[2] N�o");
				opcao = Integer.parseInt(sc.nextLine());
				
				if(opcao == 1) {
					vetFuncionario.remove(pos);
					System.out.println("Funcion�rio exclu�do");
				} else {
					System.out.println("Voltando ao menu principal");
				}
			}
		}
		else if(opcao == 2) {
			System.out.println("Digite a posi��o em que se encontra o Funcionario para exclus�o do filho: ");
			pos = Integer.parseInt(sc.nextLine());
	
			if(validarPosicao(pos, vetFuncionario)) {
				gf = new GerenciaFilho(vetFuncionario.get(pos).getFilhos());
				gf.excluir();
			}
		}
		else {
			System.out.println("Op��o inv�lida");
		}

	}
	
	public void consultar() {
		int pos, opcao;
		System.out.println("=================================");
		System.out.println("CONSULTA DE FUNCION�RIO");
		
		System.out.println("Deseja consultar um funcionario ou um filho de um funcionario?");
		System.out.println("1 - Funcion�rio");
		System.out.println("2 - Filho");
		
		opcao = Integer.parseInt(sc.nextLine()); 
		
		if(opcao == 1) {
			System.out.println("Digite a posi��o em que se encontra o Funcionario para consulta: ");
			pos = Integer.parseInt(sc.nextLine());
			
			if(validarPosicao(pos, vetFuncionario)) {
				imprimir(vetFuncionario.get(pos));
			}
		}
		else if(opcao == 2) {
			System.out.println("Digite a posi��o em que se encontra o Funcionario para consultar os filhos: ");
			pos = Integer.parseInt(sc.nextLine());
			
			if(validarPosicao(pos, vetFuncionario)) {
				gf = new GerenciaFilho(vetFuncionario.get(pos).getFilhos());
				gf.consultar();
			}
		}
		else {
			System.out.println("Op��o inv�lida");
		}
	}
	
	public void alterar() {
		int opcao, pos;
		System.out.println("=================================");
		System.out.println("ALTERAR FUNCION�RIOS");
		
		System.out.println("Deseja alterar um funcionario ou um filho de um funcionario?");
		System.out.println("1 - Funcion�rio");
		System.out.println("2 - Filho");
		
		opcao = Integer.parseInt(sc.nextLine()); 
		
		if(opcao == 1) {
			System.out.println("Digite a posi��o em que se encontra o Funcionario para alterar: ");
			pos = Integer.parseInt(sc.nextLine());
			
			if(validarPosicao(pos, vetFuncionario)) {
				
				System.out.println("O funcion�rio que deseja remover � este?");
				imprimir(vetFuncionario.get(pos));
				
				System.out.println("[1] Sim");
				System.out.println("[2] N�o");
				opcao = Integer.parseInt(sc.nextLine());
				
				if(opcao == 1) {
					cadastrarDados(vetFuncionario.get(pos));
					System.out.println("Funcion�rio alterado");
				} else {
					System.out.println("Voltando ao menu principal");
				}
			}
		}
		else if(opcao == 2) {
			System.out.println("Digite a posi��o em que se encontra o Funcionario para alterar os filhos: ");
			pos = Integer.parseInt(sc.nextLine());
			
			if(validarPosicao(pos, vetFuncionario)) {
				gf = new GerenciaFilho(vetFuncionario.get(pos).getFilhos());
				gf.alterar();
			}
		}
		else {
			System.out.println("Op��o inv�lida");
		}
	}
	
	public void gerarRelatorio() {
		System.out.println("---------------------------------");
		System.out.println("RELAT�RIO DE FUNCION�RIO");
		
		if(vetFuncionario.isEmpty()) {
			System.out.println("N�o h� funcion�rios cadastrados");
		}
		
		for(Funcionario func : vetFuncionario) {
			System.out.println("Funcion�rio #" + vetFuncionario.indexOf(func));
			imprimir(func);
			gf = new GerenciaFilho(func.getFilhos());
			gf.gerarRelatorio();
			System.out.println("---------------------------------");
		}
	}
	
	public void imprimir(Funcionario Funcionario) {
		System.out.println("CPF: " + Funcionario.getCpf());
		System.out.println("Nome: " + Funcionario.getNome());
		System.out.println("Identidade: " + Funcionario.getIdentidade());
		System.out.println("Sal�rio: " + Funcionario.getSalario());
	}
	
	private void cadastrarDados(Funcionario func) {
		
		System.out.println("CPF do Funcionario: ");
		func.setCpf(sc.nextLine());
		
		System.out.println("Nome do Funcionario: ");
		func.setNome(sc.nextLine());
		
		System.out.println("Identidade do Funcionario: ");
		func.setIdentidade(sc.nextLine());
		
		System.out.println("Sal�rio do Funcionario: ");
		func.setSalario(Float.parseFloat(sc.nextLine()));
		
	}
	
	private boolean validarPosicao(int pos, ArrayList<Funcionario> vetFuncionario) {
		
		if(pos < 0 || pos >= vetFuncionario.size()) {
			System.out.println("Posi��o inv�lida. Digite uma posi��o de 0 a n-1, onde n � o tamanho da mem�ria");
			return false;
		}
		
		if(vetFuncionario.isEmpty()) {
			System.out.println("N�o existe um Funcionario na posi��o informada");
			return false;
		}
		
		return true;
		
	}
}
