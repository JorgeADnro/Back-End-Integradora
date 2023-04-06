package com.tutorial.crudmongoback.security.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.tutorial.crudmongoback.global.entity.EntityId;
import com.tutorial.crudmongoback.security.enums.RoleEnum;

@Document(collection="users") 
public class UserEntity extends EntityId{
	
	private String username;
	private String email;
	private String passwd;
	List<RoleEnum> roles;
	
	public UserEntity() {
	
	}

	public UserEntity(int id, String username, String email, String passwd, List<RoleEnum> roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.passwd = passwd;
		this.roles = roles;
	}


	@Override
	public int getId() {
		return super.getId();
	}
	
	@Override
	public void setId(int id) {
		super.setId(id);
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public List<RoleEnum> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEnum> roles) {
		this.roles = roles;
	}
	
	

}
