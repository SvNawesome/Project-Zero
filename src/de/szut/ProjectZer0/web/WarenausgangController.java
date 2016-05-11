package de.szut.ProjectZer0.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.szut.ProjectZer0.model.Bestandsartikel;
import de.szut.ProjectZer0.model.Lager;
import de.szut.ProjectZer0.model.Warenausgang;
import de.szut.ProjectZer0.service.WarenausgangService;
/*
 * Dieser Controller ist f�r das Mapping des Models bzw. der Tabelle Warenausgang zust�ndig.
 * Es existiert ein Mapping f�r das anzeigen (WarenausgangList) der Datens�tze.
 */

@Controller
public class WarenausgangController {
	@Autowired
	WarenausgangService warenausgangService;

	/*
	 * Dieses Mapping zum anzeigen aller Datens�tze der Warenausgang Tabelle in der Datenbank da.
	 * Alle Datens�tze werden �ber den WarenausgangService aus der Datenbank geholt und �ber die 
	 * ModelMap an die JSP �bergeben
	 */
	@RequestMapping(value = {"/warenausgangList"}, method = RequestMethod.GET)
	public String listAllWarenausgang(ModelMap model) {
			List<Bestandsartikel> bestandsartikel = warenausgangService.getAllBestandsartikel();
			model.addAttribute("Bestandsartikel", bestandsartikel);
			return "warenausgangList";
	}
}
