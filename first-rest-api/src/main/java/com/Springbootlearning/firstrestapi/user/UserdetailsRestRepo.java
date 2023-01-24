package com.Springbootlearning.firstrestapi.user;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserdetailsRestRepo extends PagingAndSortingRepository<UserDet, Long> {
	
	List<UserDet>findByRole(String role);
}
