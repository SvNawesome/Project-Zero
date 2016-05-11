package de.szut.ProjectZer0.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.szut.ProjectZer0.model.Lager;
import de.szut.ProjectZer0.service.LagerService;
/*
 * Dieser Controller ist f�r das Mapping des Models bzw. der Tabelle Lager zust�ndig.
 * Es existieren Mappings f�r die JSPs zum anlegen neuer Datens�tze (LagerNew) 
 * sowie dem anzeigen (LagerList) dieser.
 */

@Controller
public class LagerController {
	@Autowired
	LagerService lagerService;

	/*
	 * Dieses Mapping erstellt ein leeres Lager Objekt und gibt 
	 * dieses �ber die ModelMap an die JSP weiter.
	 */
	@RequestMapping(value = { "/lagerNew" }, method = RequestMethod.GET)
	public String lagerNew(HttpServletRequest req, ModelMap model) {
		if (req.getSession().getAttribute("user") != null) {
			Lager lager = new Lager();
			model.addAttribute("Lager", lager);
			model.addAttribute("edit", false);
			return "lagerNew";
		}
		return "redirect:login";
	}

	/*
	 * Dieses Mapping empf�ngt das nun mit Daten gef�llte Objekt und 
	 * speichert es �ber unseren LagerService in der Datenbank.
	 */
	@RequestMapping(value = { "/lagerNew" }, method = RequestMethod.POST)
	public String saveLager(HttpServletRequest req, Lager lager, BindingResult result, ModelMap model) {
		if (req.getSession().getAttribute("user") != null) {
			if (result.hasErrors()) {
				return "lagerNew";
			}

			lagerService.saveLager(lager);

			// model.addAttribute("success", "Lager " + lager.getBezeichnung() +
			// " registered successfully.");
			return "redirect:lagerList";
		}
		return "redirect:login";
	}

	/*
	 * Dieses Mapping zum anzeigen aller Datens�tze der Lager Tabelle in der Datenbank da.
	 * Alle Datens�tze werden �ber den LagerService aus der Datenbank geholt und �ber die 
	 * ModelMap an die JSP �bergeben
	 */
	@RequestMapping(value = { "/lagerList" }, method = RequestMethod.GET)
	public String listAllLager(HttpServletRequest req, ModelMap model) {
		if (req.getSession().getAttribute("user") != null) {
			List<Lager> lager = lagerService.getAllLager();
			model.addAttribute("Lager", lager);
			return "lagerList";
		}
		return "redirect:login";
	}
	
	/*
	 * Dieses Mapping dient dazu einen bestimmten Lager aus der Tabelle zu l�schen
	 */
	@RequestMapping(value = "/lagerDel", method = RequestMethod.POST)
	public String lagerDelete(ModelMap model, @RequestParam String lagerId){
		
		lagerService.deleteLagerById(lagerId);
		return "redirect:lagerList";
	}
}
