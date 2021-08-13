package com.example.demo.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.IASOfficer;

@Repository
public interface EmployeeRepo extends JpaRepository<IASOfficer, Integer>{
	
	@Query("select e from IASOfficer e order by e.ID")
	Page<IASOfficer> getIASOfficerPerPage(Pageable p);
	
	
	
	//IF you pass  Pageable as argument in JPQL method the automatically skip and limit done
	
	
	@Query("select e from IASOfficer e where e.designation =:designation order by e.ID")
	Page<IASOfficer> getIASOfficerPerPageByDesignation(@Param("designation") String designation,Pageable p);
	

}
