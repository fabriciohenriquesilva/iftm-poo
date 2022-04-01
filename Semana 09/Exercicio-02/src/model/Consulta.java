package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Consulta {
	
	private Medico medico;
	private Paciente paciente;
	private LocalDate data;
	private LocalTime hora;
	
	public Consulta() { }

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	@Override
	public String toString() {
		
		String dataConsulta = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String horarioConsulta = hora.format(DateTimeFormatter.ofPattern("HH:mm"));
		
		return    "MÉDICO: \n" + medico +
				"\n------------------------------" +
				"\nPACIENTE: \n" + paciente +
				"\n------------------------------" +
				"\nData da consulta    = " + dataConsulta +
				"\nHorário da consulta = " + horarioConsulta;
	}
	
}
