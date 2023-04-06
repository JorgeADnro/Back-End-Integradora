package com.tutorial.crudmongoback.CRUD.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.tutorial.crudmongoback.global.entity.EntityId;

@Document(collection = "product")
public class Usuario extends EntityId{

    private String nombre;
    private int edad;
    private int telefono;
    private String correo;
 
    

    public Usuario() {
    }

    public Usuario(int id, String nombre, int edad,int telefono,String correo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
    }

    @Override
	public int getId() {
		return super.getId();
	}
	
	@Override
	public void setId(int id) {
		super.setId(id);
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
