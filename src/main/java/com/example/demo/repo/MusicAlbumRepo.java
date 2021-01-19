package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MusicAlbum;

@Repository
public interface MusicAlbumRepo extends JpaRepository<MusicAlbum, Long> {

}
