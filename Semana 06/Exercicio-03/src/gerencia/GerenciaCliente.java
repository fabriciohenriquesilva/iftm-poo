package gerencia;

import java.util.Calendar;
import java.util.Scanner;

import model.Cliente;
import model.Endereco;

public class GerenciaCliente {
	private Scanner sc;
	private Cliente clientes[];
	private Endereco endCobranca;
	private Endereco endEntrega;
	private GerenciaEndereco geEntrega;
	private GerenciaEndereco geCobranca;
	
	public GerenciaCliente(Cliente[] cli) {
		this.clientes = cli;
		
		sc = new Scanner(System.in);
		geCobranca = new GerenciaEndereco(endCobranca);
		geEntrega = new GerenciaEndereco(endEntrega);
	}
	
	public void cadastrarCliente() {
		System.out.println("=================================");
		System.out.println("------ CADASTRO DE CLIENTE ------");
		
		int pos = 0;
		while(pos < clientes.length && clientes[pos] != null) {
			pos++;
		}
		
		if(pos < clientes.length) {
			Cliente cliente = new Cliente();
			System.out.println("Digite os dados do novo cliente: ");
			
			clientes[pos] = lerDados(cliente);
			
			System.out.println("5. Digite o endereço de cobrança: ");
			clientes[pos].setEndCobranca(geCobranca.cadastrarEndereco());
			
			System.out.println("6. Digite o endereço de entrega: ");
			clientes[pos].setEndEntrega(geEntrega.cadastrarEndereco());
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
		
		if(pos >= 0 || pos < clientes.length) {
			if(clientes[pos] != null) {
				System.out.println("Deseja alterar os dados do cliente ou algum de seus endereços?");
				System.out.println("1 - Os dados do cliente");
				System.out.println("2 - O endereço de entrega");
				System.out.println("3 - O endereço de cobrança");
				opcao = Integer.parseInt(sc.nextLine());
				
				switch(opcao) {
					case 1:
						System.out.println("Alterando dados do cliente: ");
						clientes[pos] = lerDados(clientes[pos]);
						break;
						
					case 2:
						System.out.println("Alterando dados do endereço de entrega do cliente: ");
						clientes[pos].setEndEntrega(geEntrega.alterarEndereco(clientes[pos].getEndEntrega()));
						break;
						
					case 3:
						System.out.println("Alterando dados do endereço de cobrança do cliente: ");
						clientes[pos].setEndCobranca(geCobranca.alterarEndereco(clientes[pos].getEndCobranca()));
						break;
						
					default:
						System.out.println("Opção inválida");
						break;
				}
			}
			else {
				System.out.println("Não existe cliente na posição informada");
			}
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
		
		if(pos >= 0 || pos < clientes.length) {
			if(clientes[pos] != null) {
				clientes[pos] = null;
			}
			else {
				System.out.println("Não existe cliente na posição informada");
			}
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
		
		if(pos >= 0 || pos < clientes.length) {
			if(clientes[pos] != null) {
				imprimir(clientes[pos]);
			}
			else {
				System.out.println("Não existe cliente na posição informada");
			}
		}
		else {
			System.out.println("Posição inválida");
		}
	}
	
	public void relatorioDeClientes() {
		System.out.println("=================================");
		System.out.println("RELATÓRIO DE CLIENTES");
		for(int i = 0; i < clientes.length; i++) {
			if(clientes[i] != null) {
				System.out.println("Posição #" + i);
				imprimir(clientes[i]);
				System.out.println("=================================");
			}
		}
	}
	
	
	private Cliente lerDados(Cliente cli) {
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
		
		//cli.setData(sc.nextLine());
		
		return cli;
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
