package com.usanmarcos.biblioteca.services;

import com.usanmarcos.biblioteca.repositories.LibroRepository;
import com.usanmarcos.biblioteca.models.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    // Solo lectura por ahora, preparándonos para el CRUD completo
    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }
    
    public Libro guardarLibro(Libro libro) {
    	return libroRepository.save(libro);
    }
    
    public Libro actualizarLibro(Integer id, Libro libroDetalles) {
    	Libro libroExistente = libroRepository.findById(id).orElseThrow();
    	
    	libroExistente.setTitulo(libroDetalles.getTitulo());
    	libroExistente.setAnioPublicacion(libroDetalles.getAnioPublicacion());
    	libroExistente.setDisponible(libroDetalles.getDisponible());
    	
    	return libroRepository.save(libroExistente);
    }
    
    public void eliminarLibro(Integer id) {
    	libroRepository.deleteById(id);
    }
}