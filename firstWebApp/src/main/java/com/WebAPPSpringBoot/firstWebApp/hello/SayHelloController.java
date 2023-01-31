package com.WebAPPSpringBoot.firstWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	@RequestMapping("say-Hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today?";
	}
	
	@RequestMapping("say-Hello-Html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>");
		sb.append("My first html title");
		sb.append("</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html body");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
	
	
	
}
