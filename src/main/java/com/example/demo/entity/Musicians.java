package com.example.demo.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
public class Musicians
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mid;
	
	private String mname;
	private String mtype;
	
	public Set<MusicAlbum> getMusicAlbums() {
		return musicAlbums;
	}
	public void setMusicAlbums(Set<MusicAlbum> musicAlbums) {
		this.musicAlbums = musicAlbums;
	}
	@ManyToMany(mappedBy = "musician")
	Set<MusicAlbum> musicAlbums = new LinkedHashSet<>();
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
//	@Override
//	public String toString() {
//		return "Musicians [mid=" + mid + ", mname=" + mname + ", mtype=" + mtype + ", musicAlbums=" + musicAlbums + "]";
//	}
	
	
}
