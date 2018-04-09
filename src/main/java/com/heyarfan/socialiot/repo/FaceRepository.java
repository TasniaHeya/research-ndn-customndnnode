package com.heyarfan.socialiot.repo;

import java.util.List;

import org.springframework.boot.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heyarfan.socialiot.model.Face;

@Repository("faceRepository")
public interface FaceRepository extends JpaRepository<Face, Integer>{
	
	 
	 public Face findById(Long id);
	public Face findByUrl(String url);
	
}

