package cl.aiep.java.biblioteca.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.aiep.java.biblioteca.modelo.Autor;

@Repository
public class AutorRepositoryImp implements AutorRepository{
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	private Autor makeObject(ResultSet rs, int filaNum) throws SQLException{
		Long id 					= rs.getLong("id");
		String nombre 				= rs.getString("nombre");
		LocalDate fechaNacimiento 	= rs.getObject("fecha_nacimiento", LocalDate.class);
		return new Autor (id,nombre,fechaNacimiento);
	}
	public List<Autor> findAll() {
		
		return jdbcTemplate.query("SELECT * FROM autores ", this::makeObject);
	}

	@Override
	public Autor findById(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM autores WHERE id = ? ", this::makeObject, id);
	}

	@Override
	public void crear(Autor autor) {
		String sql = "INSERT INTO autores(nombre, fecha_nacimiento) VALUE (?,?) ";
		jdbcTemplate.update(sql,
				autor.getNombre(),
				autor.getFechaNacimiento());
	}

	@Override
	public void editar(Autor autor) {
		String sql = "UPDATE autores SET nombre = ?, fecha_nacimiento = ? WHERE id = ?";
		jdbcTemplate.update(sql,
				autor.getNombre(),
				autor.getFechaNacimiento(),
				autor.getId());
	}

	@Override
	public void eliminar(Long id) {
		String sql = "DELETE FROM autores WHERE id = ? ";
		jdbcTemplate.update(sql,id);
		
	}

}
