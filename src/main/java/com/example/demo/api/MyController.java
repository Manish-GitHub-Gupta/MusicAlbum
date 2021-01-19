package com.example.demo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MusicAlbum;
import com.example.demo.exception.AlbumNameMandatoryException;
import com.example.demo.repo.MusicAlbumRepo;

@RestController
public class MyController {
	
	@Autowired
	private MusicAlbumRepo musicAlbumRepo;
	
	@PostMapping("/create")
	public MusicAlbum create(@RequestBody MusicAlbum musicAlbum)
	{
		if(musicAlbum.getAlbumName() == null)
			throw new AlbumNameMandatoryException("Name Mandatory");
		if(musicAlbum.getAlbumName().length() < 5)
			throw new AlbumNameMandatoryException("Lenght should be greater than 5.");
		if(musicAlbum.getDate() == null)
			throw new AlbumNameMandatoryException("Date Mandatory");
		if(musicAlbum.getPrice() > 1000.0 || musicAlbum.getPrice() < 100.00 )
			throw new AlbumNameMandatoryException("Prices should be between 100 to 1000");
		
		MusicAlbum music = musicAlbumRepo.save(musicAlbum);
		
		return music;
	}
	
	@PutMapping("/update")
	public MusicAlbum update(@RequestBody MusicAlbum musicAlbum) 
	{
		
		if(musicAlbum.getAlbumName() == null)
			throw new AlbumNameMandatoryException("Name Mandatory");
		if(musicAlbum.getAlbumName().length() < 5)
			throw new AlbumNameMandatoryException("Lenght should be greater than 5.");
		if(musicAlbum.getDate() == null)
			throw new AlbumNameMandatoryException("Date Mandatory");
		if(musicAlbum.getPrice() > 1000.0 && musicAlbum.getPrice() < 100.00 )
			throw new AlbumNameMandatoryException("Prices should be between 100 to 1000");
		
		return musicAlbumRepo.save(musicAlbum);
	}
	
	@GetMapping("/getData")
	public List<MusicAlbum> select()
	{
		List<MusicAlbum> list = musicAlbumRepo.findAll();
//		for(int i=0;i<list.size();i++)
//		{
//			for(int j=i;j<list.size();j++)
//			{
//				MusicAlbum music = list.get(i);
//				if(list.get(i).getDate().compareTo(list.get(j).getDate()) < 0)
//				
//				{
//					list.set(i, list.get(j));
//					list.set(j, music);
//				}
//					
//			}
//			
//		}
		System.out.println(list.toString());
		return list;
	}
	

}
