package shopping.controller;

import shopping.request.*;
import shopping.response.LoginResponse;
import shopping.model.ERole;
import shopping.model.Role;
import shopping.model.User;
import shopping.repository.RoleRepository;
import shopping.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	static final String ROLENOTFOUND="Error: Role is not found.";
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@PostMapping("/signin")
	public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
		Boolean isEmail = userRepository.existsByEmail(loginRequest.getEmail());
		if(Boolean.TRUE.equals(isEmail)) {
			// no password check
		 return new ResponseEntity<>(new LoginResponse("Login Successful",1), HttpStatus.OK);
		}
		return new ResponseEntity<>(new LoginResponse("Invalid username or password",0), HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<LoginResponse> registerUser(@RequestBody SignupRequest signUpRequest) {
		Boolean isEmail = userRepository.existsByEmail(signUpRequest.getEmail());
		if (Boolean.TRUE.equals(isEmail)) {
			return new ResponseEntity<>(new LoginResponse("Account exists already",0), HttpStatus.BAD_REQUEST);
		}
		
		User user = new User(signUpRequest.getFirstname(), 
				 signUpRequest.getLastname(),
				 signUpRequest.getEmail(),
				 signUpRequest.getPassword());
		
		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException(ROLENOTFOUND));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				if(role.equals("admin")) {
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException(ROLENOTFOUND));
					roles.add(adminRole);
				}

				else	{
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException(ROLENOTFOUND));
					roles.add(userRole);
				
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);
		return new ResponseEntity<>(new LoginResponse("User registered successfully!",1), HttpStatus.OK);
		
		 
	}

}
