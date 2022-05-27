package cl.aiep.java.biblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.aiep.java.biblioteca.modelo.Autor;
import cl.aiep.java.biblioteca.repository.AutorRepository;

@Controller
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	AutorRepository autorRepository;
	@GetMapping ("/index")//http://localhost:8081/ AL NO TENER UN ASIGNADO SE ABRE DESDE EL NAVEGADOR DIRECTAMENTE EN EL LOCALHOST
	public String index() {
		
		return "index";//NOMBRE DE LA PLANTILLA DE Thymeleaf(sin html)
	}
	
	@GetMapping("/nuevo")
	public String nuevoAutor(Autor autor) {
		return "autor/formA";
	}
	@PostMapping("/procesar")
	public String procesarAutor(@Valid Autor autor, BindingResult validacion) {
		
		if(validacion.hasErrors()) {
			return "autor/formA";
		}
		if(autor.getId() == null || autor.getId() == 0) {
			autorRepository.crear(autor);
			
		}else {
			
			autorRepository.editar(autor);
		}
		return"redirect:/autor/listadoA";
	}
	@GetMapping("/listadoA")
	public String listarAutor(Model modelo) {
		List<Autor> autores = autorRepository.findAll();
		modelo.addAttribute("autores", autores);
		return "autor/listadoA";
	}
	
	@GetMapping("/editar/{id}")
	public String editarAutor(@PathVariable Long id , Model modelo) {
		Autor autor = autorRepository.findById(id);
		modelo.addAttribute("autor", autor);
		return "autor/formA";
	}
	
	@GetMapping("/eliminar")
	public String eliminarAutor(@RequestParam(name="id", required = true)Long id) {
		autorRepository.eliminar(id);
		return "redirect:/autor/listadoA";
	}
}
