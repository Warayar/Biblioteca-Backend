package com.usanmarcos.biblioteca.controllers;

import com.usanmarcos.biblioteca.models.Transaccion;
import com.usanmarcos.biblioteca.repositories.TransaccionRepository;
import com.usanmarcos.biblioteca.services.TransaccionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacciones")
@CrossOrigin(origins = "http://localhost:5173")

public class TransaccionController {

	@Autowired
	private TransaccionService transaccionService;

	TransaccionController(TransaccionRepository transaccionRepository) {
	}
	
	@GetMapping
	public List<Transaccion> listarTransacciones(){
		return transaccionService.obtenerTodasLasTransacciones();
	}
	
	@PostMapping
	public Transaccion crearTransaccion(@RequestBody Transaccion transaccion) {
		return transaccionService.guardarTransaccion(transaccion);
	}
	
	@PutMapping("/{id}")
	public Transaccion actualizarTransaccion(@PathVariable Integer id, @RequestBody Transaccion transaccion) {
		return transaccionService.actualizarTransaccion(id, transaccion);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarTransaccion(@PathVariable Integer id) {
		transaccionService.eliminarTransaccion(id);
	}
	
}