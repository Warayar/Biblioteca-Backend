package com.usanmarcos.biblioteca.models;

import java.time.LocalDate;

import jakarta.persistence.*;
//import jakarta.time.LocalDate;

@Entity
@Table(name = "Transacciones")

public class Transaccion {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdTransaccion")	
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "IdLibro", nullable = false)
	private Libro libro;
	
	
	@ManyToOne
	@JoinColumn(name = "IdUsuario", nullable = false)
	private Usuario usuario;
	
	@Column (name = "Fecha_prestamo", nullable = false)
	private LocalDate fechaPrestamo;
	
	@Column (name="Fecha_devolucion_esperada", nullable = false)
	private LocalDate fechaDevolucionEsperada;
	
	@Column (name = "Estado")
	private String estado;
	
	public Transaccion() {}
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public Libro getLibro() {return libro;}
	public void setLibro(Libro libro) {this.libro = libro;}
	
	public Usuario getUsuario() {return usuario;}
	public void setUsuario(Usuario usuario) {this.usuario = usuario;}
	
	public LocalDate getFechaPrestamo() {return fechaPrestamo;}
	public void setFechaPrestamo(LocalDate fechaPrestamo) {this.fechaPrestamo = fechaPrestamo;}
	
	public LocalDate getFechaDevolucionEsperada() { return fechaDevolucionEsperada; }
    public void setFechaDevolucionEsperada(LocalDate fechaDevolucionEsperada) { this.fechaDevolucionEsperada = fechaDevolucionEsperada; }
	
    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}
	
}
