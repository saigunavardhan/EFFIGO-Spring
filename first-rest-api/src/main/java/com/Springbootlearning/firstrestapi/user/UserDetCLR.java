package com.Springbootlearning.firstrestapi.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDetCLR implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private UserdetailsRepo repo;

	public UserDetCLR(UserdetailsRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void run(String... args) throws Exception {
		repo.save(new UserDet("Guna", "Admin"));
		repo.save(new UserDet("Alex", "User"));
		repo.save(new UserDet("Aman", "Dev"));
		
		List<UserDet> user = repo.findByRole("Admin");
		user.forEach(users->logger.info(users.toString()));
	}

}
