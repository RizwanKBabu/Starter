package com.entity;

import java.io.Serializable;
import java.sql.Clob;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import callback.listener.testEntityStatelessCallbackListener;

@Entity
@Table(name = "FromEJB")
@EntityListeners(testEntityStatelessCallbackListener.class)
public class testEntityStateless implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private int id;
	private String fullName;
	private Publisher publisher;
	private byte[] image;
	private String xml_request;
	
	@Lob @Basic(fetch= FetchType.EAGER)
	@Column(name = "image")
	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}

	@Lob @Basic(fetch= FetchType.EAGER)
	@Column(name = "xml_request")
	public String getXml_request() {
		return xml_request;
	}


	public void setXml_request(String xml_request) {
		this.xml_request = xml_request;
	}


	public testEntityStateless() {}


	public void setId(int id) {
		this.id = id;
	}

	public testEntityStateless(String name) {
		this.fullName = name;
		this.publisher=new Publisher("Default", "Default");
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence_stateless")
	@SequenceGenerator(name = "id_Sequence_stateless", sequenceName = "ID_SEQ_STATELESS",initialValue=1)
	@Column(name = "id")
	public int getId() {
		return id;
	}


	public String getfullName() {
		return fullName;
	}

	@Column(name = "fullName")
	public void setfullName(String name) {
		this.fullName = name;
	}



	
	@Override
	public String toString() {
		return "testEntityStateless [id=" + id + ", fullName=" + fullName + ", publisher-name=" + publisher.getName() + ", publisher-address=" + publisher.getName() + ", image=" + (image != null?image.toString():"NULL") + ", xml_request=" + xml_request +"]";
	}


	@Embedded
	   @AttributeOverrides({	
	      @AttributeOverride(name = "name", 
	         column = @Column(name = "PUBLISHER")),
	      @AttributeOverride(name = "address", 
	         column = @Column(name = "PUBLISHER_ADDRESS"))
	   })
	   public Publisher getPublisher() {
	      return publisher;
	   }
	
	public void setPublisher(Publisher publisher) {
	      this.publisher = publisher;
	   } 
	
}
