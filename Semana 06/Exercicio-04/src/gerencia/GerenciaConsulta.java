package gerencia;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.Consulta;
import model.Medico;
import model.Paciente;

public class GerenciaConsulta {
	
	Scanner sc;
	Consulta[] consultas;
	GerenciaMedico gm;
	GerenciaPaciente gp;
	
	public GerenciaConsulta(Consulta[] consultas, Medico[] medicos, Paciente[] pacientes) {
		this.consultas = consultas;
		
		sc = new Scanner(System.in);
		gm = new GerenciaMedico(medicos);
		gp = new GerenciaPaciente(pacientes);
	}
	
	public void incluirConsulta() {
		
		System.out.println("==============================");
		System.out.println("---- CADASTRO DE CONSULTA ----");
		int pos = 0;
		
		if(gm.estaVazio()) {
			System.out.println("Não há médicos cadastrados. Vamos cadastrar: ");
			gm.incluirMedico();
		}
		
		if(gp.estaVazio()) {
			System.out.println("Não há pacientes cadastrados. Vamos cadastrar: ");
			gp.incluirPaciente();
		}
		
		while(pos < consultas.length && consultas[pos] != null) {
			pos++;
		}
		
		if(pos < consultas.length) {
			Consulta consulta = new Consulta();
			
			consulta = lerDados(consulta);
			
			System.out.println("Escolha o médico da consulta pela sua posição: ");
			gm.gerarRelatorio();
			consulta.setMedico(gm.alocarMedico());
			
			System.out.println("Escolha o paciente da consulta pela sua posição: ");
			gp.gerarRelatorio();
			consulta.setPaciente(gp.alocarPaciente());
			
			consultas[pos] = consulta;
			
			System.out.println("Consulta cadastrada com sucesso");
		}
		else {
			System.out.println("Memória cheia");
		}
		
	}
	
	public void excluirConsulta() {
		int pos;
		System.out.println("==============================");
		System.out.println("---- EXCLUSÃO DE CONSULTA ----");
		
		System.out.println("Digite a posição da consulta a ser removido: ");
		
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 || pos < consultas.length) {
			if(consultas[pos] != null) {
				consultas[pos] = null;
			}
			else {
				System.out.println("Não existe conuslta na posição informada para exclusão");
			}
		}
		else {
			System.out.println("Posição deve ser um número entre 0 e N");
		}
	}
	
	public void alterarConsulta() {
		int pos, opcao;
		System.out.println("==============================");
		System.out.println("--- ALTERAÇÃO DE CONSULTAS ---");
		
		System.out.println("Digite a posição da consulta a ser alterada: ");
		
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 || pos < consultas.length) {
			if(consultas[pos] != null) {
				System.out.println("A consulta que deseja alterar é esta:");
				imprimir(consultas[pos]);
				
				System.out.println("[1] Sim");
				System.out.println("[2] Não");
				opcao = Integer.parseInt(sc.nextLine());
				
				if(opcao == 1) {
					consultas[pos] = lerDados(consultas[pos]);
					
					System.out.println("Escolha o médico da consulta pela sua posição: ");
					gm.gerarRelatorio();
					consultas[pos].setMedico(gm.alocarMedico());
					
					System.out.println("Escolha o paciente da consulta pela sua posição: ");
					gp.gerarRelatorio();
					consultas[pos].setPaciente(gp.alocarPaciente());
					
					System.out.println("Consulta cadastrada com sucesso");
					
				} else {
					System.out.println("Voltando ao menu principal");
				}
			}
			else {
				System.out.println("Não existe consulta na posição informada para alteração");
			}
		}
		else {
			System.out.println("Posição deve ser um número entre 0 e N");
		}
	}
	
	public void verConsultas() {
		int pos;
		System.out.println("Digite a posição da consulta a ser exibida: ");
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 || pos < consultas.length) {
			if(consultas[pos] != null) {
				imprimir(consultas[pos]);
			}
			else {
				System.out.println("Não existe médico na posição informada");
			}
		}
		else {
			System.out.println("Posição deve ser um número entre 0 e N");
		}
	}
	
	public void gerarRelatorio() {
		System.out.println("******************************");
		System.out.println("RELATÓRIO DE CONSULTAS");
		for(int i = 0; i < consultas.length; i++) {
			if(consultas[i] != null) {
				System.out.println("Posição #" + i);
				imprimir(consultas[i]);
				System.out.println("******************************");
			}
		}
	}
	
	private Consulta lerDados(Consulta consulta) {
		
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
		
		return consulta;
	}
	
	private void imprimir(Consulta consulta) {
		System.out.println("------------------------------");
		System.out.println("Médico: "); 
		gm.imprimir(consulta.getMedico());
		
		System.out.println("Paciente: "); 
		gp.imprimir(consulta.getPaciente());
		
		System.out.println("Data da consulta: ");
		String data = consulta.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(data);
		
		System.out.println("Hora da consulta: ");
		String horario = consulta.getHora().format(DateTimeFormatter.ofPattern("HH:mm"));
		System.out.println(horario);
		
		System.out.println("------------------------------");
	}

}
