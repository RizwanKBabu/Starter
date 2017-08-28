package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EJBCreater")
public class EjbCreater implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	
	
	public EjbCreater() {}


	public void setId(int id) {
		this.id = id;
	}

	public EjbCreater(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence_ejb")
	@SequenceGenerator(name = "id_Sequence_ejb", sequenceName = "ID_SEQ_ejb",initialValue=1)
	@Column(name = "id")
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	@Column(name = "name")
	public void setName(String name) {
		this.name = name;
	}

}
