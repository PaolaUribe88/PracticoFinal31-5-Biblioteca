package cl.aiep.java.biblioteca.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.aiep.java.biblioteca.modelo.Autor;
import cl.aiep.java.biblioteca.modelo.Libro;

@Repository
public class LibroRepositoryImp implements LibroRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate; 
	@Autowired
	AutorRepository autorRepository;
	
	private Libro makeObject(ResultSet rs, int filaNum) throws SQLException {
		Long id			 = rs.getLong("id");
		Long autorId	 = rs.getLong("autor_id");
		String isbn 	 = rs.getString("isbn");
		String titulo 	 = rs.getString("titulo");
		String editorial = rs.getString("editorial");
		Autor autor 	 = autorRepository.findById(autorId);
		return new Libro (id, isbn, titulo, editorial, autor);
	}
	
	@Override
	public List<Libro> findAll() {
		return jdbcTemplate.query("SELECT * FROM libros ", this::makeObject);
	}

	@Override
	public Libro findById(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM libros WHERE id = ? ", this::makeObject, id);
		}

	@Override
	public void crear(Libro libro) {
		String sql = "INSERT INTO libros(isbn, titulo, editorial, autor_id) VALUE (?,?,?,?) ";
		jdbcTemplate.update(sql,
				libro.getIsbn(),
				libro.getTitulo(),
				libro.getEditorial(),
				libro.getAutor().getId());
	}

	@Override
	public void editar(Libro libro) {
		String sql = "UPDATE libros SET isbn = ?, titulo = ?, editorial = ?, autor_id = ? WHERE id = ?";
		jdbcTemplate.update(sql,
				libro.getIsbn(),
				libro.getTitulo(),
				libro.getEditorial(),
				libro.getAutor().getId(),
				libro.getId());
	}

	@Override
	public void eliminar(Long id) {
		String sql = "DELETE FROM libros WHERE id = ? ";
		jdbcTemplate.update(sql,id);
	}

	@Override
	public List<Libro> findByTitle(String title) {
		return jdbcTemplate.query("SELECT * FROM libros WHERE titulo LIKE ?", this::makeObject, "%" + title + "%");
	}

}
