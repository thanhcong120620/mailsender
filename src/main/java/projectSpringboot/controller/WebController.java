package projectSpringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebController {
	
	
	
	/*------------------------------------------WEB CONTROLLER------------------------------------*/
	
	@GetMapping("/")
	public String test(Model model) {

		return "redirect:/mail-home";
	}
	
	

	
}
