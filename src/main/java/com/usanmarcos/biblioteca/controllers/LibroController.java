package com.usanmarcos.biblioteca.controllers;

import com.usanmarcos.biblioteca.models.Libro;
import com.usanmarcos.biblioteca.services.LibroService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/libros")
@CrossOrigin(origins = "*")


public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	@GetMapping
	public List<Libro> obtenerLibros(){
		return libroService.obtenerTodosLosLibros();
	}
	
	@PostMapping
	public Libro crearLibro(@RequestBody Libro libro) {
		return libroService.guardarLibro(libro);
	}
	
	@PutMapping("/{id}")
	public Libro actualizarLibro(@PathVariable Integer id, @RequestBody Libro libro) {	
		//TODO: process PUT request
		
		return libroService.actualizarLibro(id, libro);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarLibro(@PathVariable Integer id) {
		libroService.eliminarLibro(id);
	}

}
