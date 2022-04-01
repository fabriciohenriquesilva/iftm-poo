package gerencia;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Consulta;
import model.Medico;
import model.Paciente;

public class GerenciaConsulta {
	
	Scanner sc;
	ArrayList<Consulta> consultas;
	int tam;
	ArrayList<Medico> medicos;
	ArrayList<Paciente> pacientes;
	
	public GerenciaConsulta(ArrayList<Consulta> consultas, int tam, ArrayList<Medico> vetMedicos, ArrayList<Paciente> vetPacientes) {
		this.consultas = consultas;
		this.tam = tam;
		sc = new Scanner(System.in);
		this.medicos = vetMedicos;
		this.pacientes =  vetPacientes;
	}
	
	public void incluirConsulta() {
		
		System.out.println("==============================");
		System.out.println("---- CADASTRO DE CONSULTA ----");
				
		if(medicos.isEmpty()) {
			System.out.println("AVISO: Não há médicos cadastrados. Favor cadastrar pelo menos 1 médico antes de prosseguir com o cadastro de consulta!");
			return;
		}
		
		if(pacientes.isEmpty()) {
			System.out.println("AVISO: Não há pacientes cadastrados. Favor cadastrar pelo menos 1 paciente antes de prosseguir com o cadastro de consulta!");
			return;
		}
			
		if(consultas.size() < tam) {
			Consulta consulta = new Consulta();
			int posMedico, posPaciente;
			
			lerDados(consulta);
			
			System.out.println("Escolha o médico da consulta pela sua posição: ");
			
			posMedico = Integer.parseInt(sc.nextLine());
			if(posMedico < medicos.size() && medicos.contains(medicos.get(posMedico))) {
				consulta.setMedico(medicos.get(posMedico));
			}
			else {
				System.out.println("AVISO: Não existe médico na posição informada! Cadastro cancelado!");
				return;
			}
			
			System.out.println("Escolha o paciente da consulta pela sua posição: ");
			
			posPaciente = Integer.parseInt(sc.nextLine());
			if(posMedico < medicos.size() && pacientes.contains(pacientes.get(posPaciente))) {
				consulta.setPaciente(pacientes.get(posPaciente));
			}
			else {
				System.out.println("AVISO: Não existe paciente na posição informada! Cadastro cancelado!");
				return;
			}
			
			consultas.add(consulta);
			
			System.out.println("Consulta cadastrada com sucesso");
		}
		else {
			System.out.println("AVISO: Memória cheia");
		}
		
	}
	
	public void excluirConsulta() {
		int pos, opcao;
		System.out.println("==============================");
		System.out.println("---- EXCLUSÃO DE CONSULTA ----");
		
		if(consultas.isEmpty()) {
			System.out.println("AVISO: Não existem consultas cadastrados");
			return;
		}
		
		System.out.println("Digite a posição da consulta a ser removida: ");
		
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 && pos < consultas.size()) {
			if(consultas.get(pos) != null) {
				System.out.println("A consulta que deseja remover é esta?");
				imprimir(consultas.get(pos));
				
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				opcao = Integer.parseInt(sc.nextLine());
				
				if(opcao == 1) {
					consultas.remove(pos);
					System.out.println("Consulta excluída");
				} else {
					System.out.println("Voltando ao menu principal");
				}
			} else {
				System.out.println("AVISO: Não existe consulta na posição informada para exclusão");
			}
		} else {
			System.out.println("ERRO: Posição deve ser um número entre 0 e N");
		}
	}
	
	public void alterarConsulta() {
		int pos, opcao;
		System.out.println("==============================");
		System.out.println("--- ALTERAÇÃO DE CONSULTAS ---");
		
		if(consultas.isEmpty()) {
			System.out.println("AVISO: Não existem consultas cadastrados");
			return;
		}
		
		System.out.println("Digite a posição da consulta a ser alterada: ");
		
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 && pos < consultas.size()) {
			if(consultas.get(pos) != null) {
				System.out.println("A consulta que deseja alterar é esta:");
				imprimir(consultas.get(pos));
				
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				opcao = Integer.parseInt(sc.nextLine());
				
				if(opcao == 1) {
					int posMedico, posPaciente;
					Consulta consulta = consultas.get(pos); 
					lerDados(consulta);
					
					System.out.println("Escolha o médico da consulta pela sua posição: ");
					
					posMedico = Integer.parseInt(sc.nextLine());
					while(medicos.contains(medicos.get(posMedico))) {
						consulta.setMedico(medicos.get(posMedico));
					}
					
					System.out.println("Escolha o paciente da consulta pela sua posição: ");
					
					posPaciente = Integer.parseInt(sc.nextLine());
					while(pacientes.contains(pacientes.get(posPaciente))) {
						consulta.setPaciente(pacientes.get(posPaciente));
					}
					
					System.out.println("Consulta alterada com sucesso");
				} else {
					System.out.println("Voltando ao menu principal");
				} 
			} else {
				System.out.println("AVISO: Não existe consulta na posição informada para alteração");
			}
		} else {
			System.out.println("ERRO: Posição deve ser um número entre 0 e N");
		}
	}
	
	public void verConsultas() {
		int pos;
		
		if(consultas.isEmpty()) {
			System.out.println("AVISO: Não existem consultas cadastrados");
			return;
		}
		
		System.out.println("Digite a posição da consulta a ser exibida: ");
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 && pos < consultas.size()) {
			imprimir(consultas.get(pos));
		}
		else {
			System.out.println("AVISO: Não existe consulta na posição informada");
		}
	}
	
	public void gerarRelatorio() {
		System.out.println("******************************");
		System.out.println("RELATÓRIO DE CONSULTAS");
		
		if(consultas.isEmpty()) {
			System.out.println("AVISO: Não há consultas cadastrados!");
		}
		
		for(Consulta consulta : consultas) {
			imprimir(consulta);
			System.out.println("******************************");
		}
	}
	
	private void lerDados(Consulta consulta) {
		
		System.out.println("1 - Digite a data da consulta");
		
		System.out.println("1.1 - Dia: ");
		int dia = Integer.parseInt(sc.nextLine());
		System.out.println("1.2 - Mês: ");
		int mes = Integer.parseInt(sc.nextLine());
		System.out.println("1.3 - Ano: ");
		int ano = Integer.parseInt(sc.nextLine());
		
		consulta.setData(LocalDate.of(ano, mes, dia));
		
		System.out.println("2 - Digite a hora da consulta");
		
		System.out.println("2.1 - Hora: ");
		int hora = Integer.parseInt(sc.nextLine());
		System.out.println("2.2 - Minutos: ");
		int minuto = Integer.parseInt(sc.nextLine());
		
		consulta.setHora(LocalTime.of(hora, minuto));
		
	}
	
	private void imprimir(Consulta consulta) {
		int pos = consultas.indexOf(consulta);
		Medico medico = medicos.get(pos);
		Paciente paciente = pacientes.get(pos);
		
		System.out.println("------------------------------");
		System.out.println("Posição #" + pos);
		
		
		System.out.println("..............................");
		System.out.println("Médico: "); 
		System.out.println("CRM: " + medico.getCrm());
		System.out.println("Nome: " + medico.getNome());
		System.out.println("..............................");
		
		System.out.println("..............................");
		System.out.println("Paciente: "); 
		System.out.println("CPF: " + paciente.getCpf());
		System.out.println("Nome: " + paciente.getNome());
		System.out.println("Endereço: " + paciente.getEndereco());
		System.out.println("Telefone: " + paciente.getTelefone());
		System.out.println("..............................");
		
		System.out.println("Data da consulta: ");
		String data = consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(data);
		
		System.out.println("Hora da consulta: ");
		String horario = consulta.getHora().format(DateTimeFormatter.ofPattern("HH:mm"));
		System.out.println(horario);
		
		System.out.println("------------------------------");
	}

}
