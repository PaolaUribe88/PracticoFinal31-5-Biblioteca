package cl.aiep.java.biblioteca.repository;

import java.util.List;

import cl.aiep.java.biblioteca.modelo.Autor;

public interface AutorRepository {
	
	public List<Autor> findAll();
	public Autor findById (Long id);
	public void crear(Autor autor);
	public void editar(Autor autor);
	public void eliminar(Long id);
	

}
