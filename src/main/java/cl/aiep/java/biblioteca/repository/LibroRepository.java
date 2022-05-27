package cl.aiep.java.biblioteca.repository;

import java.util.List;

import cl.aiep.java.biblioteca.modelo.Libro;

public interface LibroRepository {

	public List<Libro> findAll();
	public Libro findById(Long id);
	public void crear(Libro libro);
	public void editar(Libro libro);
	public void eliminar(Long id);
	public List<Libro> findByTitle(String title);
}
