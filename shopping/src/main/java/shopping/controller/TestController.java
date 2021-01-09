package shopping.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


	
	@CrossOrigin(origins = "*")
	@RestController
	@RequestMapping("/api/shopping")
	public class TestController {
		@GetMapping("/all")
		public String allAccess() {
			return "Home Page..viewed by all.";
		}
		
		@GetMapping("/user")	
		public String userAccess() {
			return "User Content.";
		}

		@GetMapping("/admin")
		public String adminAccess() {
			return "Admin Board.";
		}
	}



