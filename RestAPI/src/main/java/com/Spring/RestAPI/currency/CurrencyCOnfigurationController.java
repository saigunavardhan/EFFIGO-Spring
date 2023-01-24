package com.Spring.RestAPI.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyCOnfigurationController {

	@Autowired
	private CurrencyServiceConfiguration conf;
	
	

//	public CurrencyCOnfigurationController(CurrencyServiceConfiguration conf) {
//		super();
//		this.conf = conf;
//	}



	@RequestMapping("/currency-configuration")
	public CurrencyServiceConfiguration configs() {
		return conf;

	}

}
