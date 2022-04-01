package exercicio1;

public class Aluno {
	private int matricula;
	private String nome;
	private String telefone;
	private int anoIngresso;
	private String curso;
	
	public Aluno(int matricula, String nome, String telefone, int anoIngresso, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.telefone = telefone;
		this.anoIngresso = anoIngresso;
		this.curso = curso;
	}
	
	public int getMatricula() {
		return matricula;
	}

	public void impressao() {
		System.out.println("=================================");
		System.out.println("Matricula: " + this.matricula);
		System.out.println("Nome: " + this.nome);
		System.out.println("Telefone: " + this.telefone);
		System.out.println("Ano de Ingresso: " + this.anoIngresso);
		System.out.println("Curso: " + this.curso);
		System.out.println("=================================");
	}
}
