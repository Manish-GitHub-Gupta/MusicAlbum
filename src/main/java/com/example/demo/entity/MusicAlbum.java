package com.example.demo.entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class MusicAlbum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String albumName;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	private String genere;
	
	private Double price;
	
	private String description;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Album_Musician",joinColumns = @JoinColumn(name = "MusicAlbum_ID",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="Musician_ID",referencedColumnName = "mid"))
	Set<Musicians> musician = new LinkedHashSet<>();	

//	@Override
//	public String toString() {
//		return "MusicAlbum [id=" + id + ", albumName=" + albumName + ", date=" + date + ", genere=" + genere
//				+ ", price=" + price + ", description=" + description + ", musician=" + musician + "]";
//	}

	public Set<Musicians> getMusician() {
		return musician;
	}

	public void setMusician(Set<Musicians> musician) {
		this.musician = musician;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
