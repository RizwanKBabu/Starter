package com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;


@Entity
@Table(name = "HSQL_FIRST")
public class HSQLTestEntity implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	
	public HSQLTestEntity() {
	}
	
	public HSQLTestEntity(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = AUTO)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HSQLTestEntity [id=" + id + ", name=" + name + "]";
	}

	
}
