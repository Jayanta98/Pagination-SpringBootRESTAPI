package com.example.demo.repo;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.xml.crypto.dsig.keyinfo.PGPData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.IASOfficer;

@Repository
public class MyEMRepo {
	
	@Autowired
	private EntityManager em;
	
	//HERE  You have to do  skip and limit done
	
	public List<IASOfficer> IASOfficerByDEsignation(String designation, int pagNo){
		
		List<IASOfficer> lOff= em.createQuery("select e from IASOfficer e where e.designation =:designation")
				.setParameter("designation", designation)
				.getResultList();
		List<IASOfficer> res= lOff.stream().skip(pagNo*4).limit(4).collect(Collectors.toList());
		return res;
		
	}

}
