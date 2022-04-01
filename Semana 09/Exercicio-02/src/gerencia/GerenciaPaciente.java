package gerencia;

import java.util.ArrayList;
import java.util.Scanner;

import model.Endereco;
import model.Paciente;

public class GerenciaPaciente {
	private Scanner sc;
	private ArrayList<Paciente> pacientes;
	
	public GerenciaPaciente(ArrayList<Paciente> pacientes) {
		sc = new Scanner(System.in);
		this.pacientes = pacientes;
	}
	
	public void incluir() {
		
		System.out.println("==============================");
		System.out.println("CADASTRO DE PACIENTE");
		
		System.out.println("Deseja cadastrar um paciente ou cadastrar um novo endere�o para o paciente?");
		System.out.println("[1] Cadastrar um paciente");
		System.out.println("[2] Cadastrar o endere�o do paciente");
		
		int opcao = sc.nextInt();
		sc.skip("\r\n");
		
		Endereco endereco = new Endereco();
		
		if(opcao == 1) {
			
			Paciente paciente = new Paciente();
			
			lerDados(paciente);
			pacientes.add(paciente);
			System.out.println("Hora de cadastrar seu endere�o: ");
			
			if(lerEndereco(endereco)) {
				if(paciente.setEndereco(endereco)) {
					System.out.println("Endere�o do paciente cadastrado com sucesso!");
				}
				else {
					System.out.println("ALERTA: Cliente j� possui o limite de 2 (dois) endere�os cadastrados! Voltando ao menu inicial");
				}
			}
			else {
				System.out.println("ALERTA: N�o foi poss�vel cadastrar o endere�o informado!");
			}
		}
		else if(opcao == 2) {
			
			if(pacientes.isEmpty()) {
				System.out.println("AVISO: N�o h� pacientes cadastrados! Voltando ao menu inicial!");
			}
			else {
				System.out.println("Digite a posi��o do paciente a ser cadastrado o endere�o: ");
				int posPaciente = sc.nextInt();
				sc.skip("\r\n");
				
				if(posPaciente < 0 || posPaciente >= pacientes.size()) {
					System.out.println("ALERTA: Posi��o inexistente. Digite um valor entre 0 e N-1!");
				}
				else {
					Paciente p = pacientes.get(posPaciente);
					System.out.println("==============================");
					System.out.println(p);
					System.out.println("==============================");
					
					System.out.println("Deseja cadastrar um endere�o para esse cliente? ");
					System.out.println("[1] Sim");
					System.out.println("[2] N�o");
					
					opcao = sc.nextInt();
					sc.skip("\r\n");
					
					if(opcao == 1) {
						if(lerEndereco(endereco)) {
							if(p.setEndereco(endereco)) {
								System.out.println("Endere�o do paciente cadastrado com sucesso!");
							}
							else {
								System.out.println("ALERTA: Cliente j� possui o limite de 2 (dois) endere�os cadastrados! Voltando ao menu inicial");
							}
						}
						else {
							System.out.println("ALERTA: N�o foi poss�vel cadastrar o endere�o informado!");
						}
					}
					else {
						System.out.println("Voltando ao menu inicial...");
					}
				}
			}
		}
		else {
			System.out.println("ALERTA: Op��o inv�lida. Voltando ao menu inicial...");
		}
	}
	
	public void consultar() {
		System.out.println("==============================");
		System.out.println("CONSULTAR PACIENTE");
		
		if(pacientes.isEmpty()) {
			System.out.println("AVISO: N�o h� pacientes cadastrados! Voltando ao menu inicial!");
		}
		else {
			System.out.println("Digite a posi��o do paciente a ser consultado: ");
			int posPaciente = sc.nextInt();
			sc.skip("\r\n");
			
			if(posPaciente < 0 || posPaciente >= pacientes.size()) {
				System.out.println("ALERTA: Posi��o inexistente. Digite um valor entre 0 e N-1!");
			}
			else {
				System.out.println("==============================");
				System.out.println(pacientes.get(posPaciente));
				System.out.println("==============================");
			}
		}
	}
	
	public void alterar() {
		System.out.println("==============================");
		System.out.println("ALTERAR PACIENTE");
		
		if(pacientes.isEmpty()) {
			System.out.println("AVISO: N�o h� pacientes cadastrados! Voltando ao menu inicial!");
		}
		else {
			System.out.println("Digite a posi��o do paciente a ser alterado: ");
			int posPaciente = sc.nextInt();
			sc.skip("\r\n");
			
			if(posPaciente < 0 || posPaciente >= pacientes.size()) {
				System.out.println("ALERTA: Posi��o inexistente. Digite um valor entre 0 e N-1!");
			}
			else {
				Paciente paciente = pacientes.get(posPaciente);
				
				System.out.println("O paciente a ser alterado � este?");
				System.out.println(paciente);
				System.out.println("------------------------------");
				System.out.println("[1] Sim");
				System.out.println("[2] N�o");
				System.out.println("Op��o: ");
				int opcao = sc.nextInt();
				sc.skip("\r\n");
				
				if(opcao == 1) {
					
					System.out.println("Deseja alterar os dados do paciente ou alterar o endere�o do paciente?");
					System.out.println("[1] Alterar dados do paciente");
					System.out.println("[2] Alterar endere�o do paciente");
					
					opcao = sc.nextInt();
					sc.skip("\r\n");
					
					if(opcao == 1) {
						lerDados(paciente);
						System.out.println("Paciente alterado com sucesso!");
					}
					else if(opcao == 2) {
						
						System.out.println("------------------------------");
						
						Endereco end[] = paciente.getEndereco();
						for(int i = 0; i < end.length; i++) {
							if(end[i] != null) {
								System.out.println("Endere�o " + i + ":\n" + end[i]);
								System.out.println("------------------------------");
							}
						}
						
						System.out.println("Digite a posi��o do endere�o a ser alterado");
						int pos = sc.nextInt();
						sc.skip("\r\n");
						
						if(pos < 0 || pos >= end.length) {
							System.out.println("ALERTA: Posi��o inv�lida. Voltando ao menu inicial...");
						}
						else if(end[pos] != null) {
							if(lerEndereco(end[pos])) {
								System.out.println("Endere�o do paciente alterado com sucesso!");
							}
						}
					}
					else {
						System.out.println("ALERTA: Op��o inv�lida. Voltando ao menu inicial...");
					}
				}
				else {
					System.out.println("Voltando ao menu inicial...");
				}
			}
		}
	}
	
	public void remover() {
		System.out.println("==============================");
		System.out.println("REMOVER PACIENTE");
		
		if(pacientes.isEmpty()) {
			System.out.println("AVISO: N�o h� pacientes cadastrados! Voltando ao menu inicial!");
		}
		else {
			System.out.println("Digite a posi��o do paciente a ser removido: ");
			int posPaciente = sc.nextInt();
			sc.skip("\r\n");
			
			if(posPaciente < 0 || posPaciente >= pacientes.size()) {
				System.out.println("ALERTA: Posi��o inexistente. Digite um valor entre 0 e N-1!");
			}
			else {
				System.out.println("O paciente a ser removido � este?");
				System.out.println(pacientes.get(posPaciente));
				System.out.println("[1] Sim");
				System.out.println("[2] N�o");
				System.out.println("Op��o: ");
				int opcao = sc.nextInt();
				sc.skip("\r\n");
				
				if(opcao == 1) {
					pacientes.remove(posPaciente);
					System.out.println("Paciente removido com sucesso!");
				}
				else {
					System.out.println("Voltando ao menu inicial...");
				}
			}
		}
	}
	
	public void relatorio() {
		System.out.println("==============================");
		System.out.println("RELAT�RIO DE PACIENTES");
		
		if(pacientes.isEmpty()) {
			System.out.println("AVISO: N�o h� pacientes cadastrados! Voltando ao menu inicial!");
		}
		else {
			for(Paciente paciente : pacientes) {
				System.out.println("==============================");
				System.out.println("Posi��o            = " + pacientes.indexOf(paciente));
				System.out.println(paciente);
				System.out.println("------------------------------");
			}
			System.out.println("==============================");
		}
	}
	
	private void lerDados(Paciente paciente) {
		
		System.out.println("1. Digite o nome do paciente: ");
		paciente.setNome(sc.nextLine());
		
		System.out.println("2. Digite a identidade do paciente: ");
		paciente.setIdentidade(sc.nextLine());
		
		System.out.println("3. Digite o CPF do paciente: ");
		paciente.setCpf(sc.nextLine());
		
		System.out.println("4. Digite o telefone do paciente: ");
		paciente.setTelefone(sc.nextLine());
		
		System.out.println("5. Digite o nome do conv�nio do paciente: ");
		paciente.setNomeConvenio(sc.nextLine());
		
		System.out.println("6. Digite o n�mero do conv�nio do paciente: ");
		paciente.setNumeroConvenio(sc.nextInt());
		sc.skip("\r\n");
	}
	
	private boolean lerEndereco(Endereco endereco) {
		
		System.out.println("ENDERE�O");
		System.out.println("7. Digite o logradouro do paciente: ");
		endereco.setLogradouro(sc.nextLine());
		
		System.out.println("8. Digite o n�mero do endere�o do paciente: ");
		endereco.setNumero(sc.nextInt());
		sc.skip("\r\n");
		
		System.out.println("9. Digite o complemento do endere�o do paciente: ");
		endereco.setComplemento(sc.nextLine());
		
		System.out.println("10. Digite o nome do bairro do paciente: ");
		endereco.setBairro(sc.nextLine());
		
		System.out.println("11. Digite o nome do munic�pio do paciente: ");
		endereco.setMunicipio(sc.nextLine());
		
		System.out.println("12. Digite o CEP do endere�o do paciente: ");
		endereco.setCep(sc.nextLine());
		
		System.out.println("12. Digite o tipo de endere�o do paciente: ");
		System.out.println("[1] Residencial");
		System.out.println("[2] Comercial");
		int tipoEndereco = sc.nextInt();
		sc.skip("\r\n");
		
		if(endereco.setTipo(tipoEndereco)) {
			return true;
		}
		else {
			System.out.println("ALERTA: Tipo de endere�o inv�lido! Voltando ao menu inicial");
			return false;
		}
	}
}
