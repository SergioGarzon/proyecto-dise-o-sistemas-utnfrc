package edu.utnfrc.ppai_diseno_siistemas_utn_frc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class controllerdsi {
	
	@GetMapping("/proyecto")
	public String handle(Model model) {
		return "index";
	}

}
