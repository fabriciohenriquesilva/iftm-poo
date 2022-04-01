package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Funcionario;

public class GerenciaFuncionario implements Gerencia {
	
	private ArrayList<Funcionario> funcionarios;
	private Scanner sc;
	
	public GerenciaFuncionario(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
		sc = new Scanner(System.in);
	}
	
	public void inserir() {
		
		System.out.println("...:::::[ CADASTRO DE FUNCION�RIO ]:::::...");
		
		Funcionario func = new Funcionario();
		
		lerDados(func);
		
		if(funcionarios.add(func)) {
			System.out.println("SUCESSO: Funcion�rio adicionado!");
		}
		else {
			System.out.println("FALHA: N�o foi poss�vel adicionar o funcion�rio!");
		}
	}
	
	public void excluir() {
		
		System.out.println("...:::::[ EXCLUS�O DE FUNCION�RIO ]:::::...");
		
		System.out.println("Digite a posi��o do funcion�rio a ser exclu�do: ");
		int posicao = sc.nextInt();
		sc.skip("\r\n");
		
		if(registroVazio() || posicaoInvalida(posicao)) {
			System.out.println("AVISO: Voltando ao menu inicial...");
		}
		else {
			Funcionario f = funcionarios.get(posicao);
			
			System.out.println("O funcion�rio a ser removido � este?");
			System.out.println(f);
			System.out.println("[1] Sim");
			System.out.println("[2] N�o");
			System.out.println("Op��o: ");
			int opcao = sc.nextInt();
			sc.skip("\r\n");
			
			if(opcao == 1) {
				funcionarios.remove(f);
				System.out.println("SUCESSO: Funcion�rio removido!");
			}
			else {
				System.out.println("AVISO: Voltando ao menu inicial...");
			}
		}
	}
	
	public void alterar() {
		
		System.out.println("...:::::[ ALTERA��O DE FUNCION�RIO ]:::::...");
		
		System.out.println("Digite a posi��o do funcion�rio a ser alterado: ");
		int posicao = sc.nextInt();
		sc.skip("\r\n");
		
		if(registroVazio() || posicaoInvalida(posicao)) {
			System.out.println("AVISO: Voltando ao menu inicial...");
		}
		else {
			System.out.println("O funcion�rio a ser alterado � este?");
			Funcionario f = funcionarios.get(posicao);
			
			System.out.println(f);
			System.out.println("--------------------------------------");
			System.out.println("[1] Sim");
			System.out.println("[2] N�o");
			System.out.println("Op��o: ");
			int opcao = sc.nextInt();
			sc.skip("\r\n");
			
			if(opcao == 1) {
				lerDados(f);
				System.out.println("SUCESSO: Funcion�rio alterado!");
			}
			else {
				System.out.println("AVISO: Voltando ao menu inicial...");
			}
		}
	}
	
	public void consultar() {
		System.out.println("...:::::[ CONSULTA DE FUNCION�RIO ]:::::...");
		
		System.out.println("Digite a posi��o do funcion�rio a ser consultado: ");
		int posicao = sc.nextInt();
		sc.skip("\r\n");
		
		if(registroVazio() || posicaoInvalida(posicao)) {
			System.out.println("AVISO: Voltando ao menu inicial...");
		}
		else {
			Funcionario func = funcionarios.get(posicao);
			
			System.out.println("--------------------------------------");
			System.out.println("Posi��o " + funcionarios.indexOf(func));
			System.out.println(func);
			System.out.println("--------------------------------------");
		}
	}
	
	private void lerDados(Funcionario func) {
		
		System.out.println("1. Digite o CPF do funcion�rio (apenas n�meros): ");
		func.setCpf(sc.nextLine());
		
		System.out.println("2. Digite o nome do funcion�rio: ");
		func.setNome(sc.nextLine());
		
		System.out.println("3. Digite a identidade do funcion�rio (alfan�merico): ");
		func.setIdentidade(sc.nextLine());
		
		System.out.println("4. Digite o CTPS do funcion�rio (alfan�merico) : ");
		func.setCtps(sc.nextLine());
		
		System.out.println("5. Digite o sal�rio do funcion�rio: ");
		func.setSalario(sc.nextFloat());
		sc.skip("\r\n");
		
	}
	
	public void gerarRelatorio() {
		System.out.println("...:::::[ RELAT�RIO DE FUNCION�RIOS ]:::::...");
		
		if(registroVazio()) {
			System.out.println("AVISO: Voltando ao menu inicial...");
		}
		else {
			for (Funcionario funcionario : funcionarios) {
				System.out.println("Posi��o " + funcionarios.indexOf(funcionario));
				System.out.println(funcionario);
				System.out.println("--------------------------------------");
			}
		}
	}
	
	private boolean registroVazio() {
		if(funcionarios.isEmpty()) {
			System.out.println("ERRO: N�o h� funcion�rios cadastrados! Imposs�vel realizar opera��o!");
			return true;
		}
		return false;
	}
	
	private boolean posicaoInvalida(int posicao) {
		if(posicao < 0 || posicao >= funcionarios.size()) {
			System.out.println("ERRO: Posi��o inv�lida! Digite um valor inteiro entre 0 e o total de registros");
			return true;
		}
		return false;
	}
}
