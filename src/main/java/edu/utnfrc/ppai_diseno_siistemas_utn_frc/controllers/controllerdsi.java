package edu.utnfrc.ppai_diseno_siistemas_utn_frc.controllers;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.boundary.PantallaGenerarReporte;
import edu.utnfrc.ppai_diseno_siistemas_utn_frc.domain.entidad.Vino;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static edu.utnfrc.ppai_diseno_siistemas_utn_frc.util.Constants.*;


@Controller
public class controllerdsi {

	private LocalDate fechaDesde;
	private LocalDate fechaHasta;

	@Autowired
	private PantallaGenerarReporte pantallaGenerarReporte;
	
	@GetMapping("/proyecto")
	public String start() {
		return "index";
	}
	
	@GetMapping("/GenerarReporte")
	public String habilitarVentana(Model model) {		
		String enabled = "1";

		model.addAttribute("fechaDesdeOriginal", LocalDate.now());
        model.addAttribute(ENABLED, enabled);
		return GENERAR_REPORTE;
	}

	@PostMapping("/proyecto")
	public String salir() {
		return "redirect:";
	}

	@PostMapping("/tomarPrimerFecha")
	public ModelAndView tomarPrimerFecha(@RequestParam("fechaDesde") LocalDate fechaDesde, Model model) {

		ModelAndView modelAndView = new ModelAndView("generarreporte");
		String enabled = "2";

		this.fechaDesde = fechaDesde;
		pantallaGenerarReporte.tomarSeleccionFechaDesde(fechaDesde);

		modelAndView.addObject("fechaDesdeOriginal", this.fechaDesde);
		modelAndView.addObject(ENABLED, enabled);

		return modelAndView;
	}

	@PostMapping("/validarPeriodo")
	public ModelAndView validarPeriodo(@RequestParam("fechaHasta") LocalDate fechaHasta, Model model) {

		ModelAndView modelAndView = new ModelAndView("generarreporte");
		String enabled;

		this.fechaHasta = fechaHasta;

		if (this.fechaHasta.isBefore(this.fechaDesde)) {
			modelAndView.addObject("error", "La fecha hasta debe ser mayor que la fecha desde.");
			enabled = "2";
		} else {
			enabled = "3";
			pantallaGenerarReporte.tomarSeleccionFechaHasta(fechaHasta);
		}

		modelAndView.addObject("fechaDesdeOriginal", this.fechaDesde);
		modelAndView.addObject("fechaHastaOriginal", this.fechaHasta);
		modelAndView.addObject(ENABLED, enabled);

		return modelAndView;
	}
	
	@PostMapping("/TomarSeleccionTipoResena")
	public ModelAndView tomarSeleccionTipoResena(@RequestParam("resenas") String valorSelect) {
		ModelAndView modelAndView = new ModelAndView(GENERAR_REPORTE);
		
		String enabled;
		
		if (valorSelect.compareToIgnoreCase("sommelier") != 0) {
	        modelAndView.addObject("error2", "Por momentos solo podemos generar reseñas de tipo sommelier");
	        enabled = "3";
	    } else {
	    	enabled = "4";
			pantallaGenerarReporte.tomarSeleccionTipoReseña(valorSelect);
	    }

		modelAndView.addObject("fechaDesdeOriginal", this.fechaDesde);
		modelAndView.addObject("fechaHastaOriginal", this.fechaHasta);
		modelAndView.addObject(ENABLED, enabled);
		
		return modelAndView;
	}
	
	@PostMapping("/TomarSeleccionFormaVisualizacion")
	public ModelAndView tomarSeleccionFormaVisualizacion(@RequestParam("tipovisualizacion") String valorSelect) {
		ModelAndView modelAndView = new ModelAndView(GENERAR_REPORTE);
		
		String enabled;
		
		if (valorSelect.compareToIgnoreCase("excel") != 0) {
	        modelAndView.addObject("error3", "Por momentos solo podemos generar reportes en formato Excel");
	        enabled = "4";
	    } else {
	    	enabled = "5";
			pantallaGenerarReporte.tomarSeleccionFormasVisualizacion(valorSelect);
	    }

		modelAndView.addObject("fechaDesdeOriginal", this.fechaDesde);
		modelAndView.addObject("fechaHastaOriginal", this.fechaHasta);
		modelAndView.addObject(ENABLED, enabled);
		
		return modelAndView;
	}
	
	@GetMapping("/TomarConfirmacionGeneracionReporte")
	public String tomarConfirmacionGeneracionReporte(@RequestParam(value = "valor", required = true, defaultValue = "true") boolean valor, Model model) {
		List<Vino> lista =pantallaGenerarReporte.confirmarGeneracionReporte(valor);

		model.addAttribute("lista", lista);
		return "excel";
	}
}
