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
			System.out.println("AVISO: N�o h� m�dicos cadastrados. Favor cadastrar pelo menos 1 m�dico antes de prosseguir com o cadastro de consulta!");
			return;
		}
		
		if(pacientes.isEmpty()) {
			System.out.println("AVISO: N�o h� pacientes cadastrados. Favor cadastrar pelo menos 1 paciente antes de prosseguir com o cadastro de consulta!");
			return;
		}
			
		if(consultas.size() < tam) {
			Consulta consulta = new Consulta();
			int posMedico, posPaciente;
			
			lerDados(consulta);
			
			System.out.println("Escolha o m�dico da consulta pela sua posi��o: ");
			
			posMedico = Integer.parseInt(sc.nextLine());
			if(posMedico < medicos.size() && medicos.contains(medicos.get(posMedico))) {
				consulta.setMedico(medicos.get(posMedico));
			}
			else {
				System.out.println("AVISO: N�o existe m�dico na posi��o informada! Cadastro cancelado!");
				return;
			}
			
			System.out.println("Escolha o paciente da consulta pela sua posi��o: ");
			
			posPaciente = Integer.parseInt(sc.nextLine());
			if(posMedico < medicos.size() && pacientes.contains(pacientes.get(posPaciente))) {
				consulta.setPaciente(pacientes.get(posPaciente));
			}
			else {
				System.out.println("AVISO: N�o existe paciente na posi��o informada! Cadastro cancelado!");
				return;
			}
			
			consultas.add(consulta);
			
			System.out.println("Consulta cadastrada com sucesso");
		}
		else {
			System.out.println("AVISO: Mem�ria cheia");
		}
		
	}
	
	public void excluirConsulta() {
		int pos, opcao;
		System.out.println("==============================");
		System.out.println("---- EXCLUS�O DE CONSULTA ----");
		
		if(consultas.isEmpty()) {
			System.out.println("AVISO: N�o existem consultas cadastrados");
			return;
		}
		
		System.out.println("Digite a posi��o da consulta a ser removida: ");
		
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 && pos < consultas.size()) {
			if(consultas.get(pos) != null) {
				System.out.println("A consulta que deseja remover � esta?");
				imprimir(consultas.get(pos));
				
				System.out.println("[1] Sim");
				System.out.println("[2] N�o");
				opcao = Integer.parseInt(sc.nextLine());
				
				if(opcao == 1) {
					consultas.remove(pos);
					System.out.println("Consulta exclu�da");
				} else {
					System.out.println("Voltando ao menu principal");
				}
			} else {
				System.out.println("AVISO: N�o existe consulta na posi��o informada para exclus�o");
			}
		} else {
			System.out.println("ERRO: Posi��o deve ser um n�mero entre 0 e N");
		}
	}
	
	public void alterarConsulta() {
		int pos, opcao;
		System.out.println("==============================");
		System.out.println("--- ALTERA��O DE CONSULTAS ---");
		
		if(consultas.isEmpty()) {
			System.out.println("AVISO: N�o existem consultas cadastrados");
			return;
		}
		
		System.out.println("Digite a posi��o da consulta a ser alterada: ");
		
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 && pos < consultas.size()) {
			if(consultas.get(pos) != null) {
				System.out.println("A consulta que deseja alterar � esta:");
				imprimir(consultas.get(pos));
				
				System.out.println("[1] Sim");
				System.out.println("[2] N�o");
				opcao = Integer.parseInt(sc.nextLine());
				
				if(opcao == 1) {
					int posMedico, posPaciente;
					Consulta consulta = consultas.get(pos); 
					lerDados(consulta);
					
					System.out.println("Escolha o m�dico da consulta pela sua posi��o: ");
					
					posMedico = Integer.parseInt(sc.nextLine());
					while(medicos.contains(medicos.get(posMedico))) {
						consulta.setMedico(medicos.get(posMedico));
					}
					
					System.out.println("Escolha o paciente da consulta pela sua posi��o: ");
					
					posPaciente = Integer.parseInt(sc.nextLine());
					while(pacientes.contains(pacientes.get(posPaciente))) {
						consulta.setPaciente(pacientes.get(posPaciente));
					}
					
					System.out.println("Consulta alterada com sucesso");
				} else {
					System.out.println("Voltando ao menu principal");
				} 
			} else {
				System.out.println("AVISO: N�o existe consulta na posi��o informada para altera��o");
			}
		} else {
			System.out.println("ERRO: Posi��o deve ser um n�mero entre 0 e N");
		}
	}
	
	public void verConsultas() {
		int pos;
		
		if(consultas.isEmpty()) {
			System.out.println("AVISO: N�o existem consultas cadastrados");
			return;
		}
		
		System.out.println("Digite a posi��o da consulta a ser exibida: ");
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 && pos < consultas.size()) {
			imprimir(consultas.get(pos));
		}
		else {
			System.out.println("AVISO: N�o existe consulta na posi��o informada");
		}
	}
	
	public void gerarRelatorio() {
		System.out.println("******************************");
		System.out.println("RELAT�RIO DE CONSULTAS");
		
		if(consultas.isEmpty()) {
			System.out.println("AVISO: N�o h� consultas cadastrados!");
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
		System.out.println("1.2 - M�s: ");
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
		System.out.println("Posi��o #" + pos);
		
		
		System.out.println("..............................");
		System.out.println("M�dico: "); 
		System.out.println("CRM: " + medico.getCrm());
		System.out.println("Nome: " + medico.getNome());
		System.out.println("..............................");
		
		System.out.println("..............................");
		System.out.println("Paciente: "); 
		System.out.println("CPF: " + paciente.getCpf());
		System.out.println("Nome: " + paciente.getNome());
		System.out.println("Endere�o: " + paciente.getEndereco());
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
