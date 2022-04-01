package principal;

import java.util.ArrayList;
import java.util.Scanner;

import gerencia.GerenciaCaminhao;
import gerencia.GerenciaCarro;
import gerencia.GerenciaCliente;
import gerencia.GerenciaOnibus;
import gerencia.GerenciaVenda;
import model.Caminhao;
import model.Carro;
import model.Cliente;
import model.Onibus;
import model.Venda;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Carro> carros = new ArrayList<Carro>(); 
		ArrayList<Onibus> vetOnibus = new ArrayList<Onibus>(); 
		ArrayList<Caminhao> caminhoes = new ArrayList<Caminhao>(); 
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		
		Scanner sc = new Scanner(System.in);
		GerenciaCarro ficharioCarro = new GerenciaCarro(carros);
		GerenciaOnibus ficharioOnibus = new GerenciaOnibus(vetOnibus);
		GerenciaCaminhao ficharioCaminhao = new GerenciaCaminhao(caminhoes);
		GerenciaCliente ficharioCliente = new GerenciaCliente(clientes);
		GerenciaVenda ficharioVenda = new GerenciaVenda(vendas, carros, vetOnibus, caminhoes, clientes);
		
		int categoria, operacao;
		
		do {
			System.out.println("========= CATEGORIAS =========");
			System.out.println("Escolha uma categoria de menu para acessar:");
			System.out.println("1. Carro");
			System.out.println("2. �nibus");
			System.out.println("3. Caminh�o");
			System.out.println("4. Cliente");
			System.out.println("5. Venda");
			System.out.println("0. Encerrar programa");

			categoria = sc.nextInt();
			sc.skip("\r\n");
			
			switch(categoria) {
				case 1:
					operacao = escolherOperacaoMenu(sc);
					switch(operacao) {
						case 1: ficharioCarro.incluir(); break;
						case 2: ficharioCarro.consultar(); break;
						case 3:	ficharioCarro.alterar(); break;
						case 4:	ficharioCarro.remover(); break;
						case 5:	ficharioCarro.relatorio(); break;
						default: System.out.println("ALERTA: Op��o inv�lida!");	break;
					}
					break;
					
				case 2:
					operacao = escolherOperacaoMenu(sc);
					switch(operacao) {
						case 1: ficharioOnibus.incluir(); break;
						case 2: ficharioOnibus.consultar(); break;
						case 3:	ficharioOnibus.alterar(); break;
						case 4:	ficharioOnibus.remover(); break;
						case 5:	ficharioOnibus.relatorio(); break;
						default: System.out.println("ALERTA: Op��o inv�lida!");	break;
					}
					break;
				case 3:
					operacao = escolherOperacaoMenu(sc);
					switch(operacao) {
						case 1: ficharioCaminhao.incluir(); break;
						case 2: ficharioCaminhao.consultar(); break;
						case 3:	ficharioCaminhao.alterar(); break;
						case 4:	ficharioCaminhao.remover(); break;
						case 5:	ficharioCaminhao.relatorio(); break;
						default: System.out.println("ALERTA: Op��o inv�lida!");	break;
					}
					break;
				case 4:
					operacao = escolherOperacaoMenu(sc);
					switch(operacao) {
						case 1: ficharioCliente.incluir(); break;
						case 2: ficharioCliente.consultar(); break;
						case 3:	ficharioCliente.alterar(); break;
						case 4:	ficharioCliente.remover(); break;
						case 5:	ficharioCliente.relatorio(); break;
						default: System.out.println("ALERTA: Op��o inv�lida!");	break;
					}
					break;
				case 5:
					operacao = escolherOperacaoMenu(sc);
					switch(operacao) {
						case 1: ficharioVenda.incluir(); break;
						case 2: ficharioVenda.consultar(); break;
						case 3:	ficharioVenda.alterar(); break;
						case 4:	ficharioVenda.remover(); break;
						case 5:	ficharioVenda.relatorio(); break;
						default: System.out.println("ALERTA: Op��o inv�lida!");	break;
					}
					break;
				case 0:
					System.out.println("Encerrando aplica��o...");
					break;
				default:
					System.out.println("ALERTA: Op��o inv�lida!"); 
					break;
			}
			
		} while(categoria != 0);
		
	}
	
	private static int escolherOperacaoMenu(Scanner sc) {
		System.out.println("============ MENU ============");
		System.out.println("Escolha uma op��o:");
		System.out.println("1. Incluir");
		System.out.println("2. Consultar");
		System.out.println("3. Alterar");
		System.out.println("4. Excluir");
		System.out.println("5. Gerar relat�rio");
		//System.out.println("0. Sair");
		System.out.println("Op��o: ");
		
		int opcao = sc.nextInt();
		sc.skip("\r\n");
		
		return opcao;
	}

}
