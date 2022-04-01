package gerencia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import model.Cliente;
import model.Endereco;

public class GerenciaCliente {
	private Scanner sc;
	private ArrayList<Cliente> clientes;
	private Endereco endCobranca;
	private Endereco endEntrega;
	private GerenciaEndereco geEntrega;
	private GerenciaEndereco geCobranca;
	private int tam;
	
	public GerenciaCliente(ArrayList<Cliente> cli, int tam) {
		this.clientes = cli;
		this.tam = tam;
		sc = new Scanner(System.in);
		geCobranca = new GerenciaEndereco(endCobranca);
		geEntrega = new GerenciaEndereco(endEntrega);
	}
	
	public void cadastrarCliente() {
		System.out.println("=================================");
		System.out.println("------ CADASTRO DE CLIENTE ------");
					
		if(clientes.size() < tam) {
			Cliente cliente = new Cliente();
			System.out.println("Digite os dados do novo cliente: ");
			
			lerDados(cliente);
			
			System.out.println("5. Digite o endereço de cobrança: ");
			cliente.setEndCobranca(geCobranca.cadastrarEndereco());
			
			System.out.println("6. Digite o endereço de entrega: ");
			cliente.setEndEntrega(geEntrega.cadastrarEndereco());
			
			clientes.add(cliente);
			System.out.println("Cliente cadastrado com sucesso");
		}
		else {
			System.out.println("Memória cheia");
		}
	}
	
	public void alterarCliente() {
		int opcao, pos;
		System.out.println("=================================");
		System.out.println("Digite a posição do cliente a ser alterado: ");
		
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 && pos < clientes.size()) {
			if(clientes.get(pos) != null) {
				
				System.out.println("O cliente que deseja alterar é este?");
				imprimir(clientes.get(pos));
				
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				opcao = Integer.parseInt(sc.nextLine());
				
				if(opcao == 1) {
					System.out.println("Deseja alterar os dados do cliente ou algum de seus endereços?");
					System.out.println("1 - Os dados do cliente");
					System.out.println("2 - O endereço de entrega");
					System.out.println("3 - O endereço de cobrança");
					opcao = Integer.parseInt(sc.nextLine());
					
					switch(opcao) {
					case 1:
						System.out.println("Alterando dados do cliente: ");
						lerDados(clientes.get(pos));
						System.out.println("Cliente alterado");
						break;
						
					case 2:
						System.out.println("Alterando dados do endereço de entrega do cliente: ");
						clientes.get(pos).setEndEntrega(geEntrega.alterarEndereco(clientes.get(pos).getEndEntrega()));
						System.out.println("Endereço de entrega alterado");
						break;
						
					case 3:
						System.out.println("Alterando dados do endereço de cobrança do cliente: ");
						clientes.get(pos).setEndCobranca(geCobranca.alterarEndereco(clientes.get(pos).getEndCobranca()));
						System.out.println("Endereço de cobrança alterado");
						break;
						
					default:
						System.out.println("Opção inválida");
						break;
					}
				} else {
					System.out.println("Voltando ao menu principal");
				}
			}
		}
		else if (pos >= clientes.size()) {
			System.out.println("Não existe cliente cadastrado nessa posição!");
		}
		else {
			System.out.println("Posição inválida");
		}
	}
	
	public void removerCliente() {
		int pos;
		System.out.println("=================================");
		System.out.println("Digite a posição do cliente a ser removido: ");
		
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 && pos < clientes.size()) {
			System.out.println("O cliente que deseja remover é este?");
			imprimir(clientes.get(pos));
			
			System.out.println("[1] Sim");
			System.out.println("[2] Não");
			int opcao = Integer.parseInt(sc.nextLine());
			
			if(opcao == 1) {
				clientes.remove(pos);
				System.out.println("Cliente excluído");
			} else {
				System.out.println("Voltando ao menu principal");
			}
		}
		else if (pos >= clientes.size()) {
			System.out.println("Não existe cliente cadastrado nessa posição!");
		}
		else {
			System.out.println("Posição inválida");
		}		
	}
	
	public void consultarCliente() {
		int pos;
		System.out.println("=================================");
		System.out.println("Digite a posição do cliente a ser consultado: ");
		
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 && pos < clientes.size()) {
			if(clientes.get(pos) != null) {
				imprimir(clientes.get(pos));
			}
			else {
				System.out.println("Não existe cliente na posição informada");
			}
		}
		else if (pos >= clientes.size()) {
			System.out.println("Não existe cliente cadastrado nessa posição!");
		}
		else {
			System.out.println("Posição inválida");
		}
	}
	
	public void relatorioDeClientes() {
		System.out.println("=================================");
		System.out.println("RELATÓRIO DE CLIENTES");
		
		if(clientes.isEmpty()) {
			System.out.println("Não há clientes cadastrados");
		}
		
		for(Cliente cliente : clientes) {
			System.out.println("Posição #" + clientes.indexOf(cliente));
			imprimir(cliente);
			System.out.println("=================================");
		}
	}
	
	
	private void lerDados(Cliente cli) {
		System.out.println("1. Digite o CPF: ");
		cli.setCpf(sc.nextLine());
		
		System.out.println("2. Digite o nome: ");
		cli.setNome(sc.nextLine());
		
		System.out.println("3. Digite o valor: ");
		cli.setValor(Float.parseFloat(sc.nextLine()));
		
		System.out.println("4. Informe os campos da data");
		Calendar data = Calendar.getInstance();
		System.out.println("4.1 - Digite o dia: ");
		data.set(Calendar.DAY_OF_MONTH, Integer.parseInt(sc.nextLine()));
		System.out.println("4.2 - Digite o mês: ");
		data.set(Calendar.MONTH, Integer.parseInt(sc.nextLine()));
		System.out.println("4.3 - Digite o ano: ");
		data.set(Calendar.YEAR, Integer.parseInt(sc.nextLine()));
		cli.setData(data);
		
	}
	
	private void imprimir(Cliente cliente) {
		System.out.println("---------------------------------");
		System.out.println("CPF: " + cliente.getCpf());
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("Valor: R$ " + + cliente.getValor());
		System.out.println("Data: "); 
		cliente.getData();
		
		System.out.println("*********************************");
		System.out.println("Endereço de Cobrança: ");
		geCobranca.consultarEndereco(cliente.getEndCobranca());
		System.out.println("Endereço de Entrega: ");
		geEntrega.consultarEndereco(cliente.getEndEntrega());		
		System.out.println("---------------------------------");
	}

}
