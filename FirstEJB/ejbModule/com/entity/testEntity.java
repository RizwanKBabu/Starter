package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FIRSTDB")
public class testEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	

	   
	public testEntity() {}


	public void setId(int id) {
		this.id = id;
	}

	public testEntity(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
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

	@PrePersist
	   public void prePersist(){
	      System.out.println("testEntityCallbackListener.prePersist:" 
	         + "FIRSTDB to be created with FIRSTDB id: ");
	   }

	   @PostPersist
	   public void postPersist(){
	      System.out.println("testEntityCallbackListener.postPersist::"
	         + "FIRSTDB created with FIRSTDB id: ");
	   }
	
	   @PreRemove
	   public void preRemove() {
	      System.out.println("testEntityCallbackListener.preRemove:"
	         + " About to delete FIRSTDB: ");
	   }

	   @PostRemove
	   public void postRemove(){
	      System.out.println("testEntityCallbackListener.postRemove::"
	         + " Deleted FIRSTDB: " );
	   }

	   @PreUpdate
	   public void preUpdate(){
	      System.out.println("testEntityCallbackListener.preUpdate::"
	         + " About to update FIRSTDB: ");
	   }

	   @PostUpdate
	   public void postUpdate(){
	      System.out.println("testEntityCallbackListener.postUpdate::"
	         + " Updated FIRSTDB: ");
	   }

	   @PostLoad
	   public void postLoad(){
	      System.out.println("testEntityCallbackListener.postLoad::"
	         + " Loaded FIRSTDB: " );
	   }
	
}
