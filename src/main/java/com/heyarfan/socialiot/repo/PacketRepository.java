package com.heyarfan.socialiot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heyarfan.socialiot.model.Packet;

@Repository("packetRepository")
public interface PacketRepository extends JpaRepository<Packet, Integer>{
	 
	 public Packet findById(Long id);
	 public Packet findByIdentifier(String identifier);
	
}

