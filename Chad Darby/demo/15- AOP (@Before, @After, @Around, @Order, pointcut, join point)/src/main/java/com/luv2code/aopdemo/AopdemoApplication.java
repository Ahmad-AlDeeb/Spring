package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   TrafficFortuneService theTrafficFortuneService) {
		return runner -> {
//			 beforeDemo(theAccountDAO, theMembershipDAO);
			 afterDemo(theAccountDAO);
//			 aroundDemo(theTrafficFortuneService);
		};
	}

	private void beforeDemo(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		// Make a sample account
		Account account = new Account();
		account.setName("Madhu");

		// Try calling a method
		theAccountDAO.addAccount(account);

		// Try calling a getter/setter
		theAccountDAO.setName("foobar");
		String name = theAccountDAO.getName();
	}
	private void afterDemo(AccountDAO theAccountDAO) {
		try {
			System.out.println(theAccountDAO.getAllAccounts(false));
		}
		catch (Exception exc) {
			System.out.println("Run-time exception from afterDemo()!!!");
		}
	}
	private void aroundDemo(TrafficFortuneService theTrafficFortuneService) {
		theTrafficFortuneService.getFortune(true);
	}
}








