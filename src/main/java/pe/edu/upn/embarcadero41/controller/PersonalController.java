package pe.edu.upn.embarcadero41.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import org.springframework.security.crypto.password.PasswordEncoder;

import pe.edu.upn.embarcadero41.model.entity.Personal;
import pe.edu.upn.embarcadero41.model.entity.TipoPersonal;
import pe.edu.upn.embarcadero41.service.PersonalService;
import pe.edu.upn.embarcadero41.service.TipoPersonalService;


@Controller
@RequestMapping("/personal")
@SessionAttributes("personal")
public class PersonalController {

	@Autowired
	private PersonalService personalService;
	@Autowired
	private TipoPersonalService tipoPersonalService;
	@Autowired
	 private PasswordEncoder passwordEncoder;
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Personal>personals=personalService.findAll();
			
			model.addAttribute("personals", personals);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/personal/lista";
	}
	@GetMapping("/nuevo")
	public String register(Model model) {
		Personal personal=new Personal();
		model.addAttribute("personal", personal);
		
		try {
			List<TipoPersonal>tipoPersonals=tipoPersonalService.findAll();
			model.addAttribute("tipoPersonals", tipoPersonals);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "/personal/nuevo";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("personal") Personal personal, Model model, SessionStatus status) {
		try {
			
			Optional<Personal>optional=personalService.findByUsername(personal.getUsername());
			if(optional.isPresent()) {
				model.addAttribute("dangerNuevo", "Error en el username "+personal.getUsername()+" </strong> ya existe");
				return "/personal/register";
			}
			else {
				personal.setPassword(passwordEncoder.encode(personal.getPassword()));
				
				personal.addAuthority("ROLE_CLIENTE");
				personalService.save(personal);
				status.setComplete();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/login";
		
	}
}
