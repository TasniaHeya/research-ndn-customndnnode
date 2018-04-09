package com.heyarfan.socialiot;

import java.util.Arrays;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.heyarfan.socialiot.model.Face;
import com.heyarfan.socialiot.model.Packet;
import com.heyarfan.socialiot.repo.FaceRepository;
import com.heyarfan.socialiot.repo.PacketRepository;


@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {


	@Autowired
	PacketRepository packetRepository;

	@Autowired
	FaceRepository faceRepository;
	

	@Override
	@Transactional
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		
		//cloud
		if(Constants.node_type.equals(Constants.LEVEL_1)) {
			
			Face f = new Face("cloud");
			faceRepository.save(f);
			char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	        iterate(chars, Constants.packet_identifier_length, new char[ Constants.packet_identifier_length], 0);
	        
	        
		}else if(Constants.node_type.equals(Constants.LEVEL_2)) {
			
		}else if(Constants.node_type.equals(Constants.LEVEL_3)) {
			
		}
	}

//	@Transactional
//	private final Privilege createPrivilegeIfNotFound(final String name) {
//		Privilege privilege = privilegeRepository.findByName(name);
//		if (privilege == null) {
//			privilege = new Privilege(name);
//			privilege = privilegeRepository.save(privilege);
//		}
//		return privilege;
//	}
//
//	
//	String getRandomWord() {
//		
//		Random random = new Random();
//		
//		char[] identifer = new char[Constants.packet_identifier_length];
//        for(int j = 0; j < identifer.length; j++)
//        {
//        	identifer[j] = (char)('a' + random.nextInt(26));
//        }
//        return new String(identifer); 
//	}

	public void iterate(char[] chars, int len, char[] build, int pos) {
        if (pos == len) {
            String word = new String(build);
            
            // do what you need with each word here
            Packet p = new Packet();
            p.setIdentifier(word);
            p.setExpiresIn(Constants.one_year);
            p.setContent(dummyData());
            p.setCost(0);
            p.setFace(faceRepository.findByUrl("cloud"));
            packetRepository.save(p);
            
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            build[pos] = chars[i];
            iterate(chars, len, build, pos + 1);
        }
    }
	
	public String dummyData() {
		
		
		char[] chars = new char[Constants.packet_data_size];
		for(int i =0 ; i< chars.length;i++) {
			chars[i] = randomChar();
		}
		//Arrays.fill(chars, randomChar());
		return new String(chars);

	}
	
	public char randomChar() {
		 Random r = new Random();
		 	char c = 'a';
		    String alphabet = "abcdefghijklmnopqrstuvwxyz";
		    for (int i = 0; i < 50; i++) {
		        c = alphabet.charAt(r.nextInt(alphabet.length()));
		    }
		    return c;
	}
	

}