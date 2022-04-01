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
		
		System.out.println("...:::::[ CADASTRO DE FUNCIONÁRIO ]:::::...");
		
		Funcionario func = new Funcionario();
		
		lerDados(func);
		
		if(funcionarios.add(func)) {
			System.out.println("SUCESSO: Funcionário adicionado!");
		}
		else {
			System.out.println("FALHA: Não foi possível adicionar o funcionário!");
		}
	}
	
	public void excluir() {
		
		System.out.println("...:::::[ EXCLUSÃO DE FUNCIONÁRIO ]:::::...");
		
		System.out.println("Digite a posição do funcionário a ser excluído: ");
		int posicao = sc.nextInt();
		sc.skip("\r\n");
		
		if(registroVazio() || posicaoInvalida(posicao)) {
			System.out.println("AVISO: Voltando ao menu inicial...");
		}
		else {
			Funcionario f = funcionarios.get(posicao);
			
			System.out.println("O funcionário a ser removido é este?");
			System.out.println(f);
			System.out.println("[1] Sim");
			System.out.println("[2] Não");
			System.out.println("Opção: ");
			int opcao = sc.nextInt();
			sc.skip("\r\n");
			
			if(opcao == 1) {
				funcionarios.remove(f);
				System.out.println("SUCESSO: Funcionário removido!");
			}
			else {
				System.out.println("AVISO: Voltando ao menu inicial...");
			}
		}
	}
	
	public void alterar() {
		
		System.out.println("...:::::[ ALTERAÇÃO DE FUNCIONÁRIO ]:::::...");
		
		System.out.println("Digite a posição do funcionário a ser alterado: ");
		int posicao = sc.nextInt();
		sc.skip("\r\n");
		
		if(registroVazio() || posicaoInvalida(posicao)) {
			System.out.println("AVISO: Voltando ao menu inicial...");
		}
		else {
			System.out.println("O funcionário a ser alterado é este?");
			Funcionario f = funcionarios.get(posicao);
			
			System.out.println(f);
			System.out.println("--------------------------------------");
			System.out.println("[1] Sim");
			System.out.println("[2] Não");
			System.out.println("Opção: ");
			int opcao = sc.nextInt();
			sc.skip("\r\n");
			
			if(opcao == 1) {
				lerDados(f);
				System.out.println("SUCESSO: Funcionário alterado!");
			}
			else {
				System.out.println("AVISO: Voltando ao menu inicial...");
			}
		}
	}
	
	public void consultar() {
		System.out.println("...:::::[ CONSULTA DE FUNCIONÁRIO ]:::::...");
		
		System.out.println("Digite a posição do funcionário a ser consultado: ");
		int posicao = sc.nextInt();
		sc.skip("\r\n");
		
		if(registroVazio() || posicaoInvalida(posicao)) {
			System.out.println("AVISO: Voltando ao menu inicial...");
		}
		else {
			Funcionario func = funcionarios.get(posicao);
			
			System.out.println("--------------------------------------");
			System.out.println("Posição " + funcionarios.indexOf(func));
			System.out.println(func);
			System.out.println("--------------------------------------");
		}
	}
	
	private void lerDados(Funcionario func) {
		
		System.out.println("1. Digite o CPF do funcionário (apenas números): ");
		func.setCpf(sc.nextLine());
		
		System.out.println("2. Digite o nome do funcionário: ");
		func.setNome(sc.nextLine());
		
		System.out.println("3. Digite a identidade do funcionário (alfanúmerico): ");
		func.setIdentidade(sc.nextLine());
		
		System.out.println("4. Digite o CTPS do funcionário (alfanúmerico) : ");
		func.setCtps(sc.nextLine());
		
		System.out.println("5. Digite o salário do funcionário: ");
		func.setSalario(sc.nextFloat());
		sc.skip("\r\n");
		
	}
	
	public void gerarRelatorio() {
		System.out.println("...:::::[ RELATÓRIO DE FUNCIONÁRIOS ]:::::...");
		
		if(registroVazio()) {
			System.out.println("AVISO: Voltando ao menu inicial...");
		}
		else {
			for (Funcionario funcionario : funcionarios) {
				System.out.println("Posição " + funcionarios.indexOf(funcionario));
				System.out.println(funcionario);
				System.out.println("--------------------------------------");
			}
		}
	}
	
	private boolean registroVazio() {
		if(funcionarios.isEmpty()) {
			System.out.println("ERRO: Não há funcionários cadastrados! Impossível realizar operação!");
			return true;
		}
		return false;
	}
	
	private boolean posicaoInvalida(int posicao) {
		if(posicao < 0 || posicao >= funcionarios.size()) {
			System.out.println("ERRO: Posição inválida! Digite um valor inteiro entre 0 e o total de registros");
			return true;
		}
		return false;
	}
}
