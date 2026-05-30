package com.usanmarcos.biblioteca.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Libro")

public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name =  "id")
	private Integer id;
	
	@Column(name = "Titulo", nullable = false, length = 100)
	private String titulo;
	
	@Column(name = "Autor", nullable = false, length = 100)
	private String autor;
	
	@Column(name = "AnioPublicacion")
	private Integer anioPublicacion;
	
	@Column(name = "Disponible")
	private Boolean disponible;
	
	//Constructor vacio Requerido por JPA
	public Libro() {				
		
	}
	
	//--Getters Setters
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public Integer getAnioPublicacion() {
		return anioPublicacion;
	}
	
	public void setAnioPublicacion(Integer anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
	
	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	
	
	
	
	
	
	
	
	
}
