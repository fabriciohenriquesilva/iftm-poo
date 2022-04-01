package principal;

public class Tempo {
	private int hora;
	private int min;
	private int seg;
	
	public Tempo() {
		this.hora = 0;
		this.min = 0;
		this.seg = 0;
	}

	public Tempo(int hora, int min, int seg) {
		this.hora = hora;
		this.min = min;
		this.seg = seg;
	}
	
	public void impressao() {
		System.out.printf("%02d:%02d:%02d \n", this.hora, this.min, this.seg);
	}
	
	private void validaTempo(Tempo tempo) {
		if(tempo.seg > 60) {
			tempo.seg = tempo.seg % 60;
			tempo.min++;
		}
		
		if(tempo.min > 60) {
			tempo.min = tempo.min % 60;
			tempo.hora++;
		}
		
		if(tempo.hora > 24) {
			tempo.hora = tempo.hora % 24;
		}
		
		if(tempo.hora == 24) {
			tempo.hora = 0;
		}
	}
	
	public void soma(Tempo tempo1, Tempo tempo2) {
		this.hora = tempo1.hora + tempo2.hora;
		this.min = tempo1.min + tempo2.min;
		this.seg = tempo1.seg + tempo2.seg;
		
		validaTempo(this);
	}

	public Tempo soma(Tempo tempo) {
		Tempo t = new Tempo();
		t.hora = this.hora + tempo.hora;
		t.min = this.min + tempo.min;
		t.seg = this.seg + tempo.seg;
		
		validaTempo(t);
		
		return t;
	}
	
	public static int diferencaEmSegundos(Tempo maior, Tempo menor) {
		int segMaior, segMenor;
		segMaior = maior.hora * 3600;
		segMenor = menor.hora * 3600;
		
		int diferenca = segMaior - segMenor;
		
		return diferenca;
	}
	
}
