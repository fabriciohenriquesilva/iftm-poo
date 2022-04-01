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
			System.out.println("N�o h� m�dicos cadastrados. Vamos cadastrar: ");
			gm.incluirMedico();
		}
		
		if(gp.estaVazio()) {
			System.out.println("N�o h� pacientes cadastrados. Vamos cadastrar: ");
			gp.incluirPaciente();
		}
		
		while(pos < consultas.length && consultas[pos] != null) {
			pos++;
		}
		
		if(pos < consultas.length) {
			Consulta consulta = new Consulta();
			
			consulta = lerDados(consulta);
			
			System.out.println("Escolha o m�dico da consulta pela sua posi��o: ");
			gm.gerarRelatorio();
			consulta.setMedico(gm.alocarMedico());
			
			System.out.println("Escolha o paciente da consulta pela sua posi��o: ");
			gp.gerarRelatorio();
			consulta.setPaciente(gp.alocarPaciente());
			
			consultas[pos] = consulta;
			
			System.out.println("Consulta cadastrada com sucesso");
		}
		else {
			System.out.println("Mem�ria cheia");
		}
		
	}
	
	public void excluirConsulta() {
		int pos;
		System.out.println("==============================");
		System.out.println("---- EXCLUS�O DE CONSULTA ----");
		
		System.out.println("Digite a posi��o da consulta a ser removido: ");
		
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 || pos < consultas.length) {
			if(consultas[pos] != null) {
				consultas[pos] = null;
			}
			else {
				System.out.println("N�o existe conuslta na posi��o informada para exclus�o");
			}
		}
		else {
			System.out.println("Posi��o deve ser um n�mero entre 0 e N");
		}
	}
	
	public void alterarConsulta() {
		int pos, opcao;
		System.out.println("==============================");
		System.out.println("--- ALTERA��O DE CONSULTAS ---");
		
		System.out.println("Digite a posi��o da consulta a ser alterada: ");
		
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 || pos < consultas.length) {
			if(consultas[pos] != null) {
				System.out.println("A consulta que deseja alterar � esta:");
				imprimir(consultas[pos]);
				
				System.out.println("[1] Sim");
				System.out.println("[2] N�o");
				opcao = Integer.parseInt(sc.nextLine());
				
				if(opcao == 1) {
					consultas[pos] = lerDados(consultas[pos]);
					
					System.out.println("Escolha o m�dico da consulta pela sua posi��o: ");
					gm.gerarRelatorio();
					consultas[pos].setMedico(gm.alocarMedico());
					
					System.out.println("Escolha o paciente da consulta pela sua posi��o: ");
					gp.gerarRelatorio();
					consultas[pos].setPaciente(gp.alocarPaciente());
					
					System.out.println("Consulta cadastrada com sucesso");
					
				} else {
					System.out.println("Voltando ao menu principal");
				}
			}
			else {
				System.out.println("N�o existe consulta na posi��o informada para altera��o");
			}
		}
		else {
			System.out.println("Posi��o deve ser um n�mero entre 0 e N");
		}
	}
	
	public void verConsultas() {
		int pos;
		System.out.println("Digite a posi��o da consulta a ser exibida: ");
		pos = Integer.parseInt(sc.nextLine());
		
		if(pos >= 0 || pos < consultas.length) {
			if(consultas[pos] != null) {
				imprimir(consultas[pos]);
			}
			else {
				System.out.println("N�o existe m�dico na posi��o informada");
			}
		}
		else {
			System.out.println("Posi��o deve ser um n�mero entre 0 e N");
		}
	}
	
	public void gerarRelatorio() {
		System.out.println("******************************");
		System.out.println("RELAT�RIO DE CONSULTAS");
		for(int i = 0; i < consultas.length; i++) {
			if(consultas[i] != null) {
				System.out.println("Posi��o #" + i);
				imprimir(consultas[i]);
				System.out.println("******************************");
			}
		}
	}
	
	private Consulta lerDados(Consulta consulta) {
		
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
		
		return consulta;
	}
	
	private void imprimir(Consulta consulta) {
		System.out.println("------------------------------");
		System.out.println("M�dico: "); 
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
