package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.IASOfficer;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.repo.MyEMRepo;

@RestController
public class MyController {
	
	
	@Autowired
	private EmployeeRepo repo;
	
	@GetMapping("/home")
	public String  hello() {
		return "Hello frnd";
	}

	
	@GetMapping("/allEmp")
	public List<IASOfficer>  all() {
		return repo.findAll();
	}
	
	@GetMapping("/all")
	public Page<IASOfficer>  allPerPage(@RequestParam("pgNO") int pgNo) {
		Pageable p = PageRequest.of(pgNo, 4);//itemPerPage=4
		
		return repo.getIASOfficerPerPage(p);
	}
	
	@Autowired
	private MyEMRepo emRepo;
	
	@GetMapping("/designationentity/{desig}/{pgNo}")
	public List<IASOfficer>  allPerPageWithdesignationByENTITYMNANAGER(@PathVariable("desig") String designation,@PathVariable("pgNo") int pagNo) {
		
		
		return emRepo.IASOfficerByDEsignation(designation, pagNo);
	}
	
	
	
	@GetMapping("/designation/{desig}/{pgNo}") //with PathVariable
	public Page<IASOfficer>  allPerPageWithdesignationNormal(@PathVariable("desig") String designation,@PathVariable("pgNo") int pagNo) {
		Pageable p = PageRequest.of(pagNo, 2);//itemPerPage=4
		return repo.getIASOfficerPerPageByDesignation(designation, p);
	}
	
	
	
	
	
	
	@GetMapping("/designation/param/") //with RequestParam
	public Page<IASOfficer>  allPerPageWithdesignationNormalByRParam(@RequestParam("desig") String designation,@RequestParam("pgNo") int pagNo) {
		Pageable p = PageRequest.of(pagNo, 2);//itemPerPage=4
		return repo.getIASOfficerPerPageByDesignation(designation, p);
	}
	
	
	//IF you pass  Pageable as argument in JPQL method the automatically skip and limit done
}
