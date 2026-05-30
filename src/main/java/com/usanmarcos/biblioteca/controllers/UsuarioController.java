package com.usanmarcos.biblioteca.controllers;

import com.usanmarcos.biblioteca.models.Usuario;
import com.usanmarcos.biblioteca.services.UsuarioServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("api/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {
	@Autowired
	private UsuarioServices usuarioServices;
	
	@GetMapping
	public List<Usuario> obtenerUsuarios(){
		return usuarioServices.obtenerTodosLosUsuarios();
	}
	
	@PostMapping
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		return usuarioServices.guardarUsuario(usuario);
	}
	
	@PutMapping("/{id}")
	public Usuario actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
		return usuarioServices.actualizarUsuario(id,  usuario);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarUsuario(@PathVariable Integer id) {
		usuarioServices.eliminarUsuario(id);
	}
	

}
