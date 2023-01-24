package com.java.learnSpringFramework.enterprise;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class MyWebController {
	public long returnValueFromBusinessService() {
		return 200;
	}
}

@Component

class BusinessService {
	@Autowired
	private DataService dataservice;

	public long calculateSum() {
		List<Integer> data = dataservice.getData();
		return data.stream().reduce(Integer::sum).get();
	}

}

@Component

class DataService {
	public List<Integer> getData() {
		return Arrays.asList(10, 20, 30, 40);

	}
}