package com.java.learnSpringFramework;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.java.learnSpringFramework.enterprise.MyWebController;
import com.java.learnSpringFramework.game.GameRunner;
import com.java.learnSpringFramework.game.PacmanGame;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		//GameRunner runner = context.getBean(GameRunner.class);
		//SupercontraGame game = new SupercontraGame();
		//MarioGame game = new MarioGame();
		//PacmanGame game = new PacmanGame();
		//GameRunner runner = new GameRunner(game);
		//runner.run();
		
		MyWebController bus = context.getBean(MyWebController.class);
		System.out.println(bus.returnValueFromBusinessService());
	}

}
