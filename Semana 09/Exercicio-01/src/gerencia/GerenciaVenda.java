package gerencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

import model.Caminhao;
import model.Carro;
import model.Cliente;
import model.Onibus;
import model.Veiculo;
import model.Venda;

public class GerenciaVenda {
	
	private ArrayList<Venda> vendas;
	private Scanner sc;
	
	private ArrayList<Carro> carros;
	private ArrayList<Onibus> vetOnibus;
	private ArrayList<Caminhao> caminhoes;
	private ArrayList<Cliente> clientes;
	
	
	public GerenciaVenda(ArrayList<Venda> vendas, ArrayList<Carro> carros, ArrayList<Onibus> vetOnibus, 
			ArrayList<Caminhao> caminhoes, ArrayList<Cliente> clientes) {
		this.sc = new Scanner(System.in);
		this.vendas = vendas;
		this.carros = carros;
		this.vetOnibus = vetOnibus;
		this.caminhoes = caminhoes;
		this.clientes = clientes;
	}
	
	public void incluir() {
		
		System.out.println("==============================");
		System.out.println("INCLUS�O DE VENDAS");
		
		if(carros.isEmpty() && vetOnibus.isEmpty() && caminhoes.isEmpty()) {
			System.out.println("AVISO: N�o h� carros, �nibus ou caminh�es cadastrados! Cadastre ao menos um ve�culo para cadastrar uma venda!");
		}
		else if(clientes.isEmpty()) {
			System.out.println("AVISO: N�o h� clientes cadastrados! Imposs�vel cadastrar venda!");
		}
		else {
			Venda venda = new Venda();
			
			if(lerDados(venda)) {
				vendas.add(venda);
				System.out.println("Venda cadastrada com sucesso!");
			}
			else {
				System.out.println("AVISO: N�o foi poss�vel cadastrar a venda!");
			}
		}
	}
	
	public void alterar() {
		
		System.out.println("==============================");
		System.out.println("ALTERA��O DE VENDA");
		
		if(vendas.isEmpty()) {
			System.out.println("AVISO: N�o h� vendas cadastradas!");
		} 
		else {
			System.out.println("Digite a posi��o da venda para alterar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
					
			String mensagem = "A venda que deseja alterar � esta?";
			
			if(validarDados(pos, mensagem)){
				System.out.println("Digite os novos dados: ");
				lerDados(vendas.get(pos));
				System.out.println("Venda alterada com sucesso!");
			}
		}		
	}
	
	public void remover() {
		System.out.println("==============================");
		System.out.println("REMO��O DE VENDA");
		
		if(vendas.isEmpty()) {
			System.out.println("AVISO: N�o h� vendas cadastradas!");
		}
		else {
			System.out.println("Digite a posi��o da venda para remover: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
			
			String mensagem = "A venda que deseja remover � este?";
			
			if(validarDados(pos, mensagem)){
				vendas.remove(pos);
				System.out.println("Venda removida com sucesso!");
			}
		}
	}
	
	public void consultar() {
		System.out.println("==============================");
		System.out.println("CONSULTA DE VENDA");
		
		if(vendas.isEmpty()) {
			System.out.println("AVISO: N�o h� vendas cadastradas!");
		}
		else {
			System.out.println("Digite a posi��o da venda para consultar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");
					
			String mensagem = "A venda que deseja consultar � esta?";
			
			if(!validarDados(pos, mensagem)){
				consultar();
			}
		}
	}
	
	public void relatorio() {
		System.out.println("==============================");
		System.out.println("RELAT�RIO DE VENDAS");
		
		if(vendas.isEmpty()) {
			System.out.println("AVISO: N�o h� vendas cadastradas! Voltando ao menu inicial...");
		}
		else {
			for(Venda venda : vendas) {
				System.out.println("------------------------------");
				imprimir(venda);
			}
			System.out.println("------------------------------");
		}
	}
	
	private boolean lerDados(Venda venda) {
		
		System.out.println("Qual o tipo de ve�culo foi vendido? ");
		System.out.println("[1] Carro");
		System.out.println("[2] �nibus");
		System.out.println("[3] Caminh�o");
		
		int posVeiculo, tipoVeiculo = sc.nextInt();
		sc.skip("\r\n");
		
		switch(tipoVeiculo) {
			case 1:
				if(carros.isEmpty()) {
					System.out.println("AVISO: N�o h� carros cadastrados. Favor cadastrar um carro antes de cadastrar a venda!");
					return false;
				}
				else {
					System.out.println("1 - Digite a posi��o do carro para incluir na venda: ");
					posVeiculo = sc.nextInt();
					sc.skip("\r\n");
					
					if(posVeiculo < 0 || posVeiculo >= carros.size()) {
						System.out.println("ALERTA: Posi��o inv�lida. Deve ser um n�mero entre 0 e N-1");
						return false;
					} 
					else {				
						Carro carro = carros.get(posVeiculo);
						
						System.out.println("-------------------------------");
						System.out.println("Marca                = " + carro.getMarca());
						System.out.println("Modelo               = " + carro.getModelo());
						System.out.println("Ano de Fabrica��o    = " + carro.getAnoFabricacao());
						System.out.println("Ano de Modelo        = " + carro.getAnoModelo());
						System.out.printf ("Pre�o                = R$ %.2f\n", carro.getPreco());
						System.out.println("Quantidade de portas = " + carro.getQuantidadePortas());
						System.out.println("-------------------------------");
						
						System.out.println("O carro que deseja incluir na venda � este?");
						System.out.println("[1] Sim");
						System.out.println("[2] N�o");
						int opcao = sc.nextInt();
						sc.skip("\r\n");
						
						if(opcao == 1) {
							venda.setVeiculo(carro);
						}
						else {
							return false;
						}
					}
				}
				
				break;
			case 2:
				if(vetOnibus.isEmpty()) {
					System.out.println("AVISO: N�o h� �nibus cadastrados. Favor cadastrar um carro antes de cadastrar a venda!");
					return false;
				}
				else {
					System.out.println("1 - Digite a posi��o do �nibus para incluir na venda: ");
					posVeiculo = sc.nextInt();
					sc.skip("\r\n");
					
					if(posVeiculo < 0 || posVeiculo >= vetOnibus.size()) {
						System.out.println("ALERTA: Posi��o inv�lida. Deve ser um n�mero entre 0 e N-1");
						return false;
					} 
					else {				
						Onibus onibus = vetOnibus.get(posVeiculo);
						
						System.out.println("-------------------------------");
						System.out.println("Marca                      = " + onibus.getMarca());
						System.out.println("Modelo                     = " + onibus.getModelo());
						System.out.println("Ano de Fabrica��o          = " + onibus.getAnoFabricacao());
						System.out.println("Ano de Modelo              = " + onibus.getAnoModelo());
						System.out.printf ("Pre�o                      = R$ %.2f\n", onibus.getPreco());
						System.out.println("Quantidade de passageiros  = " + onibus.getQuantidadePassageiros());
						System.out.println("Quantidade de eixos        = " + onibus.getQuantidadeEixos());
						System.out.println("-------------------------------");
						
						System.out.println("O �nibus que deseja incluir na venda � este?");
						System.out.println("[1] Sim");
						System.out.println("[2] N�o");
						int opcao = sc.nextInt();
						sc.skip("\r\n");
						
						if(opcao == 1) {
							venda.setVeiculo(onibus);
						}
						else {
							return false;
						}
					}
				}
				break;
			case 3:
				if(caminhoes.isEmpty()) {
					System.out.println("AVISO: N�o h� caminh�es cadastrados. Favor cadastrar um carro antes de cadastrar a venda!");
					return false;
				}
				else {
					System.out.println("1 - Digite a posi��o do caminh�o para incluir na venda: ");
					posVeiculo = sc.nextInt();
					sc.skip("\r\n");
					
					if(posVeiculo < 0 || posVeiculo >= caminhoes.size()) {
						System.out.println("ALERTA: Posi��o inv�lida. Deve ser um n�mero entre 0 e N-1");
						return false;
					}
					else {				
						Caminhao caminhao = caminhoes.get(posVeiculo);
						
						System.out.println("-------------------------------");
						System.out.println("Marca                 = " + caminhao.getMarca());
						System.out.println("Modelo                = " + caminhao.getModelo());
						System.out.println("Ano de Fabrica��o     = " + caminhao.getAnoFabricacao());
						System.out.println("Ano de Modelo         = " + caminhao.getAnoModelo());
						System.out.printf ("Pre�o                 = R$ %.2f\n", caminhao.getPreco());
						System.out.println("Capacidade de carga   = " + caminhao.getCapacidadeDeCarga());
						System.out.println("-------------------------------");
						
						System.out.println("O caminhao que deseja incluir na venda � este?");
						System.out.println("[1] Sim");
						System.out.println("[2] N�o");
						int opcao = sc.nextInt();
						sc.skip("\r\n");
						
						if(opcao == 1) {
							venda.setVeiculo(caminhao);
						}
						else {
							return false;
						}
					}
				}
				break;
			default:
				System.out.println("ALERTA: Op��o inv�lida. Utilize uma op��o entre 1, 2 ou 3!");
				return false;
		}
		
		System.out.println("2 - Digite a posi��o do cliente da venda: ");
		int posCliente = sc.nextInt();
		sc.skip("\r\n");
		
		if(posCliente < 0 || posCliente >= clientes.size()) {
			System.out.println("ALERTA: Posi��o inv�lida. Deve ser um n�mero entre 0 e N-1");
			return false;
		}
		else {
			Cliente cliente = clientes.get(posCliente);
			
			System.out.println("-------------------------------");
			System.out.println("Nome      = " + cliente.getNome());
			System.out.println("Telefone  = " + cliente.getTelefone());
			System.out.println("CPF       = " + cliente.getCpf());
			System.out.println("-------------------------------");
			System.out.println("O cliente que deseja incluir na venda � este?");
			System.out.println("[1] Sim");
			System.out.println("[2] N�o");
			
			int opcao = sc.nextInt();
			sc.skip("\r\n");
			
			if(opcao == 1) {
				venda.setCliente(cliente);
			}
			else {
				return false;
			}
			
			System.out.println("3 - Digite a data da venda");
			
			System.out.println("3.1 - Dia: ");
			int dia = sc.nextInt();
			sc.skip("\r\n");
			
			System.out.println("3.2 - M�s: ");
			int mes = sc.nextInt();
			sc.skip("\r\n");
			
			System.out.println("3.3 - Ano: ");
			int ano = sc.nextInt();
			sc.skip("\r\n");
			
			venda.setData(LocalDate.of(ano, mes, dia));
			venda.setPreco();
			
			return true;
		}
	}
	
	private void imprimir(Venda venda) {
		
		int pos = vendas.indexOf(venda);
		Veiculo veiculo = venda.getVeiculo();
		
		Cliente cliente = clientes.get(pos);
		System.out.println("Posi��o #" + pos);
		
		System.out.println("..............................");
		System.out.println("Veiculo vendido: "); 
		System.out.println("Marca                = " + veiculo.getMarca());
		System.out.println("Modelo               = " + veiculo.getModelo());
		System.out.println("Ano de Fabrica��o    = " + veiculo.getAnoFabricacao());
		System.out.println("Ano de Modelo        = " + veiculo.getAnoModelo());
		System.out.printf ("Pre�o                = R$ %.2f\n", veiculo.getPreco());
		
		System.out.println("..............................");
		System.out.println("Cliente:"); 
		System.out.println("CPF                  = " + cliente.getCpf());
		System.out.println("Nome                 = " + cliente.getNome());
		System.out.println("Telefone             = " + cliente.getTelefone());
		System.out.println("..............................");

		String data = venda.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Data da venda: " + data);
		
	}
	
	private boolean validarDados(int pos, String mensagem) {
		
		if(pos < 0 || pos >= vendas.size()) {
			System.out.println("ALERTA: Posi��o inv�lida. Deve ser um n�mero entre 0 e N-1");
			return false;
		}
		
		System.out.println(mensagem);
		imprimir(vendas.get(pos));
		
		System.out.println("[1] Sim");
		System.out.println("[2] N�o");
		
		int opcao = sc.nextInt();
		sc.skip("\r\n");
		
		if(opcao != 1) {
			System.out.println("Voltando ao menu inicial...");
			return false;
		}
		
		return true;
	}
}
