package de.szut.ProjectZer0.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.szut.ProjectZer0.model.Artikelstamm;
import de.szut.ProjectZer0.model.Bestandsartikel;
import de.szut.ProjectZer0.model.Lieferant;
import de.szut.ProjectZer0.service.ArtikelstammService;
import de.szut.ProjectZer0.service.BestandsartikelService;
import de.szut.ProjectZer0.service.LieferantService;
/*
 * Dieser Controller ist f�r das Mapping des Models bzw. der Tabelle Artikelstamm zust�ndig.
 * Es existieren Mappings f�r die JSPs zum anlegen neuer Datens�tze (ArtikelstammNew) 
 * sowie dem anzeigen (ArtikelstammList) dieser.
 */

@Controller
public class ArtikelstammController {
	@Autowired
	ArtikelstammService artikelstammService;

	/*
	 * Dieses Mapping erstellt ein leeres Artikelstamm Objekt und gibt 
	 * dieses �ber die ModelMap an die JSP weiter.
	 */
	@RequestMapping(value = { "/artikelstammNew" }, method = RequestMethod.GET)
	public String artikelstammNew(HttpServletRequest req, ModelMap model) {
		if (req.getSession().getAttribute("user") != null) {
			Artikelstamm artikelstamm = new Artikelstamm();
			model.addAttribute("Artikelstamm", artikelstamm);
			model.addAttribute("edit", false);
			return "artikelstammNew";
		}
		return "redirect:login";
	}

	/*
	 * Dieses Mapping empf�ngt das nun mit Daten gef�llte Objekt und 
	 * speichert es �ber unseren ArtikelstammService in der Datenbank.
	 */
	@RequestMapping(value = { "/artikelstammNew" }, method = RequestMethod.POST)
	public String saveArtikelstamm(HttpServletRequest req, Artikelstamm artikelstamm, BindingResult result, ModelMap model) {
		if (req.getSession().getAttribute("user") != null) {
			artikelstammService.saveArtikelstamm(artikelstamm);
			return "redirect:artikelstammList";
		}
		return "redirect:login";
	}


	/*
	 * Dieses Mapping zum anzeigen aller Datens�tze der Artikelstamm Tabelle in der Datenbank da.
	 * Alle Datens�tze werden �ber den ArtikelstammService aus der Datenbank geholt und �ber die 
	 * ModelMap an die JSP �bergeben
	 */
	@RequestMapping(value = {"/artikelstammList"}, method = RequestMethod.GET)
	public String listAllArtikelstamm(HttpServletRequest req, ModelMap model)
	{
		if (req.getSession().getAttribute("user") != null) {
			List<Artikelstamm> artikelstamm = artikelstammService.getAllArtikelstamm();
			model.addAttribute("Artikelstamm", artikelstamm);
			return "artikelstammList";
		}
		return "redirect:login";
	}
	
	/*
	 * Dieses Mapping dient dazu einen bestimmten Artikelstamm aus der Tabelle zu l�schen
	 */
	@RequestMapping(value = "/artikelstammDel", method = RequestMethod.POST)
	public String artikelstammDelete(ModelMap model, @RequestParam String artikelstammId){
		
		artikelstammService.deleteArtikelstammById(artikelstammId);
		return "redirect:artikelstammList";
	}
}
