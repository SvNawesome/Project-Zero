package de.szut.ProjectZer0.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.szut.ProjectZer0.model.Artikelstamm;
import de.szut.ProjectZer0.model.Bestandsartikel;
import de.szut.ProjectZer0.model.Lager;
import de.szut.ProjectZer0.model.Lieferant;
import de.szut.ProjectZer0.model.Mitarbeiter;
import de.szut.ProjectZer0.model.User;
import de.szut.ProjectZer0.service.ArtikelstammService;
import de.szut.ProjectZer0.service.BestandsartikelService;
import de.szut.ProjectZer0.service.LagerService;
import de.szut.ProjectZer0.service.LieferantService;
import de.szut.ProjectZer0.service.MitarbeiterService;
import de.szut.ProjectZer0.service.UserService;

// home.jsp erreichbar �ber Men�

@Controller
public class MenuController {

	@Autowired
	UserService userService;

	/*
	 * Dieser Controller beinhaltet lediglich das Mapping f�r die /home Page,
	 * welche direkt nach dem erfolgreichen einloggen angezeigt wird
	 */
	@RequestMapping("/home")
	public String home(HttpServletRequest req, ModelMap model) {
		if (req.getSession().getAttribute("user") != null) {
			return "home";
		} else {
			return "redirect:login";
		}
	}
}
