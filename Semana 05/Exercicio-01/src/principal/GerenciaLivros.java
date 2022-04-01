package principal;

import java.util.Scanner;

public class GerenciaLivros {
	private Livro[] vetLivros;
	private Scanner sc;
	
	public GerenciaLivros(Livro vetor[]) {
		vetLivros = vetor;
		sc = new Scanner(System.in);
	}
	
	public void incluir() {
		int pos = 0;
		System.out.println("=================================");
		System.out.println("CADASTRO DE LIVROS");
		
		while( (pos < vetLivros.length) && (vetLivros[pos] != null) ) {
			pos++;
		}
		
		if(pos < vetLivros.length) {
			Livro li = new Livro();
			
			System.out.println("Digite os dados do novo livro: ");
			
			li = cadastrarDados(li);
			
			vetLivros[pos] = li;
			System.out.println("Livro cadastrado com sucesso");
		}
		else {
			System.out.println("Memória cheia");
		}
	}
	
	public void excluir() {
		int pos;
		System.out.println("=================================");
		System.out.println("EXCLUSÃO DE LIVROS");

		System.out.println("Digite a posição em que se encontra o livro para exclusão: ");
		pos = Integer.parseInt(sc.nextLine());
		
		if(validarPosicao(pos, vetLivros)) {
			vetLivros[pos] = null;
		}
	
	}
	
	public void consultar() {
		int pos;
		System.out.println("=================================");
		System.out.println("CONSULTA DE LIVROS");

		System.out.println("Digite a posição em que se encontra o livro para consulta: ");
		pos = Integer.parseInt(sc.nextLine());
		
		if(validarPosicao(pos, vetLivros)) {
			imprimir(vetLivros[pos]);
		}

	}
	
	public void alterar() {
		System.out.println("=================================");
		System.out.println("ALTERAR LIVRO");
		System.out.println("Digite a posição em que se encontra o livro para alteração: ");
		int pos = Integer.parseInt(sc.nextLine());
		
		if(validarPosicao(pos, vetLivros)) {
			vetLivros[pos] = cadastrarDados(vetLivros[pos]);
		}
	}
	
	public void gerarRelatorio() {
		System.out.println("=================================");
		System.out.println("RELATÓRIO DE LIVROS");
		for(int i = 0; i < vetLivros.length; i++) {
			if(vetLivros[i] != null) {
				System.out.println("Posição #" + i);
				imprimir(vetLivros[i]);
				System.out.println("=================================");
			}
		}
	}
	
	public void imprimir(Livro livro) {
		System.out.println("Título: " + livro.getTitulo());
		System.out.println("Autor: " + livro.getAutor());
		System.out.println("Editora: " + livro.getEditora());
		System.out.println("Ano da publicação: " + livro.getAnoDaPublicacao());
		System.out.println("Edição: " + livro.getEdicao());
		System.out.println("ISBN: " + livro.getIsbn());
	}
	
	private Livro cadastrarDados(Livro li) {
		
		System.out.println("Título do livro: ");
		li.setTitulo(sc.nextLine());
		
		System.out.println("Autor do livro: ");
		li.setAutor(sc.nextLine());
		
		System.out.println("Editora do livro: ");
		li.setEditora(sc.nextLine());
		
		System.out.println("Ano de publicação do livro: ");
		li.setAnoDaPublicacao(Integer.parseInt(sc.nextLine()));
		
		System.out.println("Edição do livro: ");
		li.setEdicao(Integer.parseInt(sc.nextLine()));
		
		System.out.println("ISBN do livro: ");
		li.setIsbn(sc.nextLine());
		
		return li;
	}
	
	private boolean validarPosicao(int pos, Livro vetLivros[]) {
		int err = 0;
		
		if(pos < 0 || pos >= vetLivros.length) {
			System.out.println("Posição inválida. Digite uma posição de 0 a n-1, onde n é o tamanho da memória");
			err++;
		}
		
		if(vetLivros[pos] == null) {
			System.out.println("Não existe um livro na posição informada");
			err++;
		}
		
		if(err == 0)
			return true;
		else
			return false;
		
	}
}
