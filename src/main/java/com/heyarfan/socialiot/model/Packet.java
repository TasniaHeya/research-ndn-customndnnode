package com.heyarfan.socialiot.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "packet")
public class Packet {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;


    private String identifier;
    
    @Column(columnDefinition="LONGTEXT")
    public String content;
    
    public long expiresIn;

    @Column(name = "created_at")
    public Date createdAt;

    
    


    public Face getFace() {
		return face;
	}

	public void setFace(Face face) {
		this.face = face;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public Packet(String identifier, String content, long expiresIn, Face face, long cost) {
		super();
		this.identifier = identifier;
		this.content = content;
		this.expiresIn = expiresIn;
		this.face = face;
		this.cost = cost;
	}

	@OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "packet_face", joinColumns = @JoinColumn(name = "packet_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "face_id", referencedColumnName = "id"))
	public Face face;
	
	public long cost;
	

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Packet() {
        super();
       
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
    
	@PrePersist
	  void createdAt() {
	    this.createdAt = new Date();
	  }

	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.000 ", timezone="UTC")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


}