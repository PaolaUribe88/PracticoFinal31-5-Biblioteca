package cl.aiep.java.biblioteca.modelo;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Libro {

	@Min(0)
	private Long id;
	@Size (min = 1, max=13, message ="El ISBN  debe ir entre 1 y 13 caracteres")
	private String isbn;
	@Size (min = 3, max=50, message ="El Titulo  debe ir entre 1 y 20 caracteres")
	private String titulo;
	@Size (min = 3, max=50, message ="La Editorial  debe ir entre 1 y 20 caracteres")
	private String editorial;

	private Autor autor;
	
	//CONSTRUCTOR VACIO
	public Libro() {
		super();
	}
	//CONSTRUCTOR COMPLETO
	public Libro(Long id,String isbn, String titulo, String editorial,Autor autor) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.editorial = editorial;
		this.autor = autor;
	}
	//GETTER Y SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
}
