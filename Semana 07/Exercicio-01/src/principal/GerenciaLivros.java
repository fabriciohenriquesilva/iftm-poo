package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaLivros {
	private ArrayList<Livro> vetLivros;
	private Scanner sc;
	private int tam;
	
	public GerenciaLivros(ArrayList<Livro> livros, int tam) {
		vetLivros = livros;
		sc = new Scanner(System.in);
		this.tam = tam;
	}
	
	public void incluir() {
		System.out.println("=================================");
		System.out.println("CADASTRO DE LIVROS");
		
		if(vetLivros.size() <= tam) {
			Livro li = new Livro();
			
			System.out.println("Digite os dados do novo livro: ");
			
			li = cadastrarDados(li);
			
			vetLivros.add(li);
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
			vetLivros.remove(pos);
		}
		
		System.out.println("Livro removido");
	
	}
	
	public void consultar() {
		int pos;
		System.out.println("=================================");
		System.out.println("CONSULTA DE LIVROS");

		System.out.println("Digite a posição em que se encontra o livro para consulta: ");
		pos = Integer.parseInt(sc.nextLine());
		
		System.out.println("=================================");
		if(validarPosicao(pos, vetLivros)) {
			imprimir(vetLivros.get(pos));
		}

	}
	
	public void alterar() {
		System.out.println("=================================");
		System.out.println("ALTERAR LIVRO");
		System.out.println("Digite a posição em que se encontra o livro para alteração: ");
		int pos = Integer.parseInt(sc.nextLine());
		
		if(validarPosicao(pos, vetLivros)) {
			vetLivros.set(pos, cadastrarDados(vetLivros.get(pos)));
		}
	}
	
	public void gerarRelatorio() {
		System.out.println("=================================");
		System.out.println("RELATÓRIO DE LIVROS");
		
		if(!vetLivros.isEmpty()) {
			for(Livro li : vetLivros) {
				System.out.println("Posição #" + vetLivros.indexOf(li));
				imprimir(li);
				System.out.println("=================================");
			}
		} else {
			System.out.println("Não há livros cadastrados");
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
	
	private boolean validarPosicao(int pos, ArrayList<Livro> vetLivros) {
		int err = 0;
		
		if(pos < 0 || pos >= vetLivros.size()) {
			System.out.println("Posição inválida. Digite uma posição de 0 a n-1, onde n é o tamanho da memória");
			err++;
		}
		
		if(vetLivros.isEmpty()) {
			System.out.println("Não há livros cadastrados");
			err++;
		}
		
		if(err == 0)
			return true;
		else
			return false;
		
	}
}
