package com.brasilprev.test.brasilprevtest.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String cpf; 
	
	@Column(nullable = false)
	private String address;
	
	public Client(String name, String cpf, String address) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.address = address;
	
	}
	
	public Client() {
		super();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, cpf, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(address, other.address) && Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
