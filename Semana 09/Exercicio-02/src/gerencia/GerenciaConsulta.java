package gerencia;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import model.Consulta;
import model.Medico;
import model.Paciente;

public class GerenciaConsulta {

	private Scanner sc;
	private ArrayList<Medico> medicos;
	private ArrayList<Paciente> pacientes;
	private ArrayList<Consulta> consultas;
	
	public GerenciaConsulta(ArrayList<Consulta> consultas, ArrayList<Medico> medicos, ArrayList<Paciente> pacientes) {
		sc = new Scanner(System.in);
		this.consultas = consultas;
		this.medicos = medicos;
		this.pacientes =  pacientes;
	}
	
	public void incluir() {
		
		System.out.println("==============================");
		System.out.println("---- CADASTRO DE CONSULTA ----");
				
		if(medicos.isEmpty()) {
			System.out.println("AVISO: Não há médicos cadastrados. Favor cadastrar pelo menos 1 médico antes de prosseguir com o cadastro de consulta!");
		}
		else if(pacientes.isEmpty()) {
			System.out.println("AVISO: Não há pacientes cadastrados. Favor cadastrar pelo menos 1 paciente antes de prosseguir com o cadastro de consulta!");
		}
		else {
			Consulta consulta = new Consulta();
			
			lerDados(consulta);
			
			if(cadastrarMedico(consulta)) {
				System.out.println("Médico cadastrado com sucesso!");
				
				if(cadastrarPaciente(consulta)) {
					System.out.println("Paciente cadastrado com sucesso!");
					
					consultas.add(consulta);
					System.out.println("Consulta cadastrada com sucesso");
				}
				else {
					System.out.println("ALERTA: Não foi possível cadastrar o paciente na consulta! Voltando ao menu inicial...");
				}
			}
			else {
				System.out.println("ALERTA: Não foi possível cadastrar o médico na consulta! Voltando ao menu inicial...");
			}
		}
	}
	
	public void remover() {
		int pos, opcao;
		System.out.println("==============================");
		System.out.println("---- EXCLUSÃO DE CONSULTA ----");
		
		if(consultas.isEmpty()) {
			System.out.println("AVISO: Não existem consultas cadastrados");
		}
		else {
			System.out.println("Digite a posição da consulta a ser removida: ");
			
			pos = sc.nextInt();
			sc.skip("\r\n");
			
			if(pos < 0 || pos >= consultas.size() ) {
				System.out.println("ALERTA: Posição inexistente. Digite um valor entre 0 e N-1!");
			}
			else {
				System.out.println("A consulta que deseja remover é esta?");
				System.out.println(consultas.get(pos));
				
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				opcao = sc.nextInt();
				sc.skip("\r\n");
				
				if(opcao == 1) {
					consultas.remove(pos);
					System.out.println("Consulta excluída");
				} else {
					System.out.println("Voltando ao menu inicial...");
				}
			}
		}
	}
	
	public void alterar() {
		int pos, opcao;
		System.out.println("==============================");
		System.out.println("--- ALTERAÇÃO DE CONSULTAS ---");
		
		if(consultas.isEmpty()) {
			System.out.println("AVISO: Não existem consultas cadastrados");
		}
		else {
			System.out.println("Digite a posição da consulta a ser alterada: ");
			
			pos = sc.nextInt();
			sc.skip("\r\n");
			
			if(pos < 0 || pos >= consultas.size() ) {
				System.out.println("ALERTA: Posição inexistente. Digite um valor entre 0 e N-1!");
			}
			else {
				System.out.println("A consulta que deseja alterar é esta:");
				Consulta consulta = consultas.get(pos);
				System.out.println(consulta);
				
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				opcao = sc.nextInt();
				sc.skip("\r\n");
				
				if(opcao == 1) {
					lerDados(consulta);
					
					if(cadastrarMedico(consulta)) {
						System.out.println("Médico alterado com sucesso!");
						
						if(cadastrarPaciente(consulta)) {
							System.out.println("Paciente alterado com sucesso!");
							System.out.println("Consulta alterada com sucesso");
						}
						else {
							System.out.println("ALERTA: Não foi possível alterar o paciente na consulta! Voltando ao menu inicial...");
						}
					}
					else {
						System.out.println("ALERTA: Não foi possível alterar o médico na consulta! Voltando ao menu inicial...");
					}
				} 
				else {
					System.out.println("Voltando ao menu inicial...");
				}
			}
		}
	}
	
	public void consultar() {
		int pos;
		
		if(consultas.isEmpty()) {
			System.out.println("AVISO: Não existem consultas cadastrados");
		}
		else {
			System.out.println("Digite a posição da consulta a ser exibida: ");
			pos = sc.nextInt();
			sc.skip("\r\n");
			
			if(pos < 0 || pos >= consultas.size()) {
				System.out.println("ALERTA: Posição inexistente. Digite um valor entre 0 e N-1!");
			}
			else {
				System.out.println(consultas.get(pos));
				System.out.println("==============================");
			}
		}
	}
	
	public void relatorio() {
		System.out.println("******************************");
		System.out.println("RELATÓRIO DE CONSULTAS");
		
		if(consultas.isEmpty()) {
			System.out.println("AVISO: Não há consultas cadastrados!");
		}
		
		for(Consulta consulta : consultas) {
			System.out.println(consulta);
			System.out.println("------------------------------");
			
		}
		System.out.println("******************************");
	}
	
	private void lerDados(Consulta consulta) {
		
		System.out.println("1 - Digite a data da consulta");
		
		System.out.println("1.1 - Dia: ");
		int dia = sc.nextInt();
		sc.skip("\r\n");
		System.out.println("1.2 - Mês: ");
		int mes = sc.nextInt();
		sc.skip("\r\n");
		System.out.println("1.3 - Ano: ");
		int ano = sc.nextInt();
		sc.skip("\r\n");
		
		consulta.setData(LocalDate.of(ano, mes, dia));
		
		System.out.println("2 - Digite a hora da consulta");
		
		System.out.println("2.1 - Hora: ");
		int hora = sc.nextInt();
		sc.skip("\r\n");
		System.out.println("2.2 - Minutos: ");
		int minuto = sc.nextInt();
		sc.skip("\r\n");
		
		consulta.setHora(LocalTime.of(hora, minuto));
		
	}
	
	private boolean cadastrarMedico(Consulta consulta) {

		System.out.println("Escolha o médico da consulta pela sua posição: ");
		
		int posMedico = sc.nextInt();
		sc.skip("\r\n");
		
		if(posMedico < 0 || posMedico >= medicos.size() ) {
			System.out.println("ALERTA: Posição inexistente. Digite um valor entre 0 e N-1!");
			return false;
		}
		else {
			System.out.println("O médico que deseja incluir é este? ");
			Medico medico = medicos.get(posMedico);
			System.out.println(medico);
			
			System.out.println("[1] Sim");
			System.out.println("[2] Não");
			System.out.println("------------------------------");
			
			int opcao = sc.nextInt();
			sc.skip("\r\n");
			
			if(opcao == 1) {
				consulta.setMedico(medico);
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	private boolean cadastrarPaciente(Consulta consulta) {

		System.out.println("Escolha o paciente da consulta pela sua posição: ");
		
		int posPaciente = sc.nextInt();
		sc.skip("\r\n");
		
		if(posPaciente < 0 || posPaciente >= pacientes.size() ) {
			System.out.println("ALERTA: Posição inexistente. Digite um valor entre 0 e N-1!");
			return false;
		}
		else {
			System.out.println("O paciente que deseja incluir é este? ");
			Paciente paciente = pacientes.get(posPaciente);
			System.out.println(paciente);
			
			System.out.println("[1] Sim");
			System.out.println("[2] Não");
			System.out.println("------------------------------");
			
			int opcao = sc.nextInt();
			sc.skip("\r\n");
			
			if(opcao == 1) {
				consulta.setPaciente(paciente);
				return true;
			}
			else {
				return false;
			}
		}
	}

}
