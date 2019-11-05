package pe.edu.upn.embarcadero41.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class IndexController {

	
	
	@GetMapping
	public String index(Model model) {
		
		
		
		return "index";	// Archivo html que se devuelve
	}

	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	@GetMapping("access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
