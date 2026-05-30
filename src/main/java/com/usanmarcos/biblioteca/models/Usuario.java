package com.usanmarcos.biblioteca.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdUsuario")
	
	private Long idUsuario;

	@Column(name = "Nombre", nullable = false, length = 50)
	private String nombre; 
	
	@Column(name = "Apellido1", nullable = false, length = 50)
	private String apellido1;
	
	@Column(name = "Apellido2", nullable = false, length = 50)
	private String apellido2;
	
	@Column(name = "Cedula", nullable = false, length = 25, unique = true)
	private String cedula;
	
	@Column(name = "Correo", nullable = false, length = 50)
	private String correo;
	
	@Column(name = "Telefono", nullable = false, length = 15)
	private String telefono;
	
	@Column(name = "Estado", nullable = false)
	private Boolean estado = true;



public Usuario() {}

public Usuario (String nombre, String apellido1, String apellido2, String cedula, String correo, String telefono, Boolean estado) {
	this.nombre = nombre;
	this.apellido1 = apellido1;
	this.apellido2 = apellido2;
	this.cedula = cedula;
	this.correo = correo;
	this.telefono = telefono;
	this.estado = estado;		
}

public Long getIdUsuario() {return idUsuario;}
public void setIdUsuario(Long idUsuario) {this.idUsuario = idUsuario;}

public String getNombre() {return nombre;}
public void setNombre(String nombre) {this.nombre = nombre;}

public String getApellido1() {return apellido1;}
public void setApellido1(String apellido1) {this.apellido1 = apellido1;}

public String getApellido2() {return apellido2;}
public void setApellido2(String apellido2) {this.apellido2 = apellido2;}

public String getCedula() {return cedula;}
public void setCedula (String cedula) {this.cedula = cedula;}

public String getCorreo() {return correo;}
public void setCorreo(String correo) {this.correo = correo;}

public String getTelefono() {return telefono;}
public void setTelefono(String telefono) {this.telefono = telefono;}

public Boolean getEstado() {return estado;}
public void setEstado(Boolean estado) {this.estado = estado;}




}