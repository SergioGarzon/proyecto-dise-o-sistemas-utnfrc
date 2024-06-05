package edu.utnfrc.ppai_diseno_siistemas_utn_frc.controllers;


import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class controllerdsi {
	
	@GetMapping("/proyecto")
	public String start() {
		return "index";
	}
	
	@GetMapping("/GenerarReporte")
	public String habilitarVentana(Model model) {		
		String enabled = "1";
        model.addAttribute("enabled", enabled);
		return "generarreporte";
	}

	@PostMapping("/proyecto")
	public String salir() {
		return "redirect:";
	}
	
	@PostMapping("/GenerarReporte")
    public ModelAndView validarPeriodo(@RequestParam("fechaDesde") LocalDate fechaDesde, @RequestParam("fechaHasta") LocalDate fechaHasta, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("generarreporte");
		String enabled = "1";
		
		if (fechaHasta.isBefore(fechaDesde)) {
	        modelAndView.addObject("error", "La fecha hasta debe ser mayor que la fecha desde.");
	        enabled = "1";
	    } else {
	    	enabled = "2";
	    }	
	    
		modelAndView.addObject("enabled", enabled);
		
	    return modelAndView;
    }
	
	@PostMapping("/TomarSeleccionTipoResena")
	public ModelAndView tomarSeleccionTipoResena(@RequestParam("resenas") String valorSelect) {
		ModelAndView modelAndView = new ModelAndView("generarreporte");
		
		String enabled = "0";
		
		if (valorSelect.compareToIgnoreCase("sommelier") != 0) {
	        modelAndView.addObject("error2", "Por momentos solo podemos generar rese&ntilde;as de tipo sommelier");
	        enabled = "2";
	    } else {
	    	enabled = "3";
	    }			
		
		modelAndView.addObject("enabled", enabled);
		
		return modelAndView;
	}
	
	@PostMapping("/TomarSeleccionFormaVisualizacion")
	public ModelAndView tomarSeleccionFormaVisualizacion(@RequestParam("tipovisualizacion") String valorSelect) {
		ModelAndView modelAndView = new ModelAndView("generarreporte");
		
		String enabled = "0";
		
		if (valorSelect.compareToIgnoreCase("excel") != 0) {
	        modelAndView.addObject("error3", "Por momentos solo podemos generar reportes en formato Excel");
	        enabled = "3";
	    } else {
	    	enabled = "4";
	    }			
		
		modelAndView.addObject("enabled", enabled);
		
		return modelAndView;
	}
	
	@GetMapping("/TomarConfirmacionGeneracionReporte")
	public String tomarConfirmacionGeneracionReporte() {	
		return "excel";
	}
}
