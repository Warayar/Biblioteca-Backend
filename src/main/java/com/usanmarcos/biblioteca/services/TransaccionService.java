package com.usanmarcos.biblioteca.services;

import com.usanmarcos.biblioteca.models.Transaccion;
import com.usanmarcos.biblioteca.models.Libro;
import com.usanmarcos.biblioteca.repositories.LibroRepository;
import com.usanmarcos.biblioteca.repositories.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionService {
	@Autowired
	private TransaccionRepository transaccionRepository;
	
	@Autowired
    private LibroRepository libroRepository;

	
	
	public List<Transaccion> obtenerTodasLasTransacciones(){
		return transaccionRepository.findAll();
	}
	
	public Transaccion guardarTransaccion(Transaccion transaccion) {
        Libro libro = libroRepository.findById(transaccion.getLibro().getId())
            .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        if ("ACTIVO".equals(transaccion.getEstado())) {
            if (!libro.getDisponible()) {
                throw new RuntimeException("Error: El libro ya se encuentra prestado.");
            }
            libro.setDisponible(false);
            libroRepository.save(libro); 
        }

        return transaccionRepository.save(transaccion);
    }
	
	public Transaccion actualizarTransaccion(Integer id, Transaccion detalles) {
		Transaccion transaccion=transaccionRepository.findById(id).orElseThrow();
		transaccion.setLibro(detalles.getLibro());
		transaccion.setUsuario(detalles.getUsuario());
		transaccion.setFechaPrestamo(detalles.getFechaPrestamo());
		transaccion.setFechaDevolucionEsperada(detalles.getFechaDevolucionEsperada());
		transaccion.setEstado(detalles.getEstado());
		return transaccionRepository.save(transaccion);
		
	}
	
	public void eliminarTransaccion(Integer id) {
		transaccionRepository.deleteById(id);
	}

}
