package com.Springbootlearning.firstrestapi.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserdetailsRepo extends JpaRepository<UserDet, Long> {
	
	List<UserDet>findByRole(String role);
}
