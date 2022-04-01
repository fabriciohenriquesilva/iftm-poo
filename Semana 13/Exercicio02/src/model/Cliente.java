package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Cliente extends Pessoa {
	
	private float limiteDeCredito;
	private float valorDaCompra;
	private LocalDate dataDaCompra;
	private LocalDate dataLimiteParaPagamento;
	private LocalDate dataDePagamento;
	
	public Cliente() {
		super();
	}

	public Cliente(float limiteDeCredito, float valorDaCompra, LocalDate dataDaCompra,
			LocalDate dataLimiteParaPagamento, LocalDate dataDePagamento) {
		super();
		this.limiteDeCredito = limiteDeCredito;
		this.valorDaCompra = valorDaCompra;
		this.dataDaCompra = dataDaCompra;
		this.dataLimiteParaPagamento = dataLimiteParaPagamento;
		this.dataDePagamento = dataDePagamento;
	}

	public float getLimiteDeCredito() {
		return limiteDeCredito;
	}

	public void setLimiteDeCredito(float limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}

	public float getValorDaCompra() {
		return valorDaCompra;
	}

	public void setValorDaCompra(float valorDaCompra) {
		this.valorDaCompra = valorDaCompra;
	}

	public LocalDate getDataDaCompra() {
		return dataDaCompra;
	}

	public void setDataDaCompra(LocalDate dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}

	public LocalDate getDataLimiteParaPagamento() {
		return dataLimiteParaPagamento;
	}

	public void setDataLimiteParaPagamento(LocalDate dataLimiteParaPagamento) {
		this.dataLimiteParaPagamento = dataLimiteParaPagamento;
	}

	public LocalDate getDataDePagamento() {
		return dataDePagamento;
	}

	public void setDataDePagamento(LocalDate dataDePagamento) {
		this.dataDePagamento = dataDePagamento;
	}
	
	public float calculaJuros() {
		long diferencaEmDias = ChronoUnit.DAYS.between(dataDaCompra, dataDePagamento);
		float valorFinal = (float) (( diferencaEmDias * 0.03 ) * valorDaCompra);
		return valorFinal;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return super.toString() +
				"\nLimite de Crédito        : " + limiteDeCredito +
				"\nValor da Compra          : " + valorDaCompra +
				"\nData da Compra           : " + dataDaCompra.format(formatador) +
				"\nData de Pagamento        : " + dataDePagamento.format(formatador) + 
				"\nData Limite de Pagamento : " + dataLimiteParaPagamento.format(formatador) +
				"\n--------------------------------------" +
				"\nVALOR FINAL              : R$ " + calculaJuros();
  	}
}
