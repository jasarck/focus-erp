package com.focus;

//import com.focus.model.Country;
//import com.focus.model.Role;
//import com.focus.model.State;
//import com.focus.model.User;
//import com.focus.service.LocationService;
//import com.focus.service.UserService;
import com.focus.model.Role;
import com.focus.model.User;
import com.focus.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class FocusErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(FocusErpApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "SUPER ADMIN"));
			userService.saveRole(new Role(null, "ADMIN"));
			userService.saveRole(new Role(null, "OPERATOR"));
			userService.saveUser(new User(null,"jasarck","jasar","1234", new ArrayList<>() ));
			userService.saveUser(new User(null,"Sarah","sarah","1234", new ArrayList<>() ));
			userService.saveUser(new User(null,"Hannah","hannah","1234", new ArrayList<>() ));

			userService.addRoleToUser("jasar", "SUPER ADMIN");
			userService.addRoleToUser("sarah", "OPERATOR");
			userService.addRoleToUser("hannah", "ADMIN");
		};
	}
//
//	@Bean
//	CommandLineRunner run_country(LocationService locationService){
//		return args -> {
//			locationService.saveCountry(new Country(null, "India"));
//			locationService.saveCountry(new Country(null, "USA"));
//			locationService.saveState(new State(null, "Kerala", new Country(1l, "India")));
//		};
//	}
}
