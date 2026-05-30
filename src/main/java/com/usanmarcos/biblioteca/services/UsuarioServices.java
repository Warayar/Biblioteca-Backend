package com.usanmarcos.biblioteca.services;

import com.usanmarcos.biblioteca.models.Usuario;
import com.usanmarcos.biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> obtenerTodosLosUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario actualizarUsuario(Integer id, Usuario usuarioDetalles) {
		Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow();
		
		usuarioExistente.setNombre(usuarioDetalles.getNombre());
		usuarioExistente.setApellido1(usuarioDetalles.getApellido1());
		usuarioExistente.setApellido2(usuarioDetalles.getApellido2());
		usuarioExistente.setCedula(usuarioDetalles.getCedula());
		usuarioExistente.setCorreo(usuarioDetalles.getCorreo());
		usuarioExistente.setTelefono(usuarioDetalles.getTelefono());
		usuarioExistente.setEstado(usuarioDetalles.getEstado());
		
		return usuarioRepository.save(usuarioExistente);
		
	}
	
	public void eliminarUsuario(Integer id) {
		usuarioRepository.deleteById(id);
	}
}
