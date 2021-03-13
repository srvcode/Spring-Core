package com.srvcode.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {

	// Field Injection
	/*
	 * Since there are multiple FortuneService implementations
	 * we have to use @Qualifier to provide specific implementation
	 */
	//@Autowired
	//@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	// define a setter method
	
	/*
	 * Setter any method Injection
	 * 
	@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
		fortuneService = theFortuneService;
	}
	 */
	
	/*
	 * Setter Injection
	 * 
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		fortuneService = theFortuneService;
	}
	*/
	
	/*
	 * Constructor Injection
	 * 
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	@Autowired
	public TennisCoach(@Qualifier("happyFortuneService") FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside constructor using @Autowired & @Qualifier");
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
