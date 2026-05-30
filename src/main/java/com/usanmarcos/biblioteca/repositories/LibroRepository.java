package com.usanmarcos.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.usanmarcos.biblioteca.models.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{

}
