package com.heyarfan.socialiot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.heyarfan.socialiot.model.Packet;
import com.heyarfan.socialiot.repo.FaceRepository;
import com.heyarfan.socialiot.repo.PacketRepository;

@RestController
//@RequestMapping("/")
public class Controller {

	@Autowired
	PacketRepository packetRepository;

	@Autowired
	FaceRepository faceRepository;

	@GetMapping("/{packet}")
	public @ResponseBody Packet packet(@PathVariable String packet) {
		
		
		return null;
	}

	

}