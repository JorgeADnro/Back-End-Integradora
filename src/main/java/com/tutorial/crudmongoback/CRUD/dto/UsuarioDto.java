package com.tutorial.crudmongoback.CRUD.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class UsuarioDto {
    @NotBlank(message = "El nombre es requerido")
    private String nombre;
    @Min(value = 1, message = "La edad es requerida")
    private int edad;
    @Min(value = 1, message = "El telefono es requerido")
    private int telefono;
    @NotBlank(message = "El correo es requerido")
    private String correo;

    public UsuarioDto() {
    }

    public UsuarioDto(String nombre, int edad,int telefono,String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}


	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}


    
}
