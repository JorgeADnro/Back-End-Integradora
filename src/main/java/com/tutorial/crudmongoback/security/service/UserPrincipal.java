package com.tutorial.crudmongoback.security.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tutorial.crudmongoback.security.entity.UserEntity;

public class UserPrincipal implements UserDetails{
	
	private String username;
	private String email;
	private String passwd;
	private Collection<? extends GrantedAuthority> authorities; 
	
	
	
	public UserPrincipal(String username, String email, String passwd,Collection<? extends GrantedAuthority> authorities) {
		this.username = username;
		this.email = email;
		this.passwd = passwd;
		this.authorities = authorities;
	}
	
	public static UserPrincipal build(UserEntity userEntity) {
		Collection<GrantedAuthority> authorities = userEntity.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.name())).collect(Collectors.toList());
		return new UserPrincipal(userEntity.getUsername(),userEntity.getEmail(),userEntity.getPasswd(),authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}
	@Override
	public String getPassword() {
		
		return passwd;
	}
	@Override
	public String getUsername() {
		
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	
}
