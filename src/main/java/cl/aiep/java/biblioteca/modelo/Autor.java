package cl.aiep.java.biblioteca.modelo;

import java.time.LocalDate;

import javax.validation.constraints.Min;

public class Autor {
	
	@Min(0)
	private Long id;
	
	private String nombre;
	
	private LocalDate fechaNacimiento;
	
	//CONSTRUCTOR VACIO	
	public Autor() {
		super();
	}

	//CONSTRUCTOR COMPLETO
	public Autor(Long id, String nombre, LocalDate fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	//GETTER Y SETTER
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
