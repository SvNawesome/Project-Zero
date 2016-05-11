package de.szut.ProjectZer0.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import de.szut.ProjectZer0.model.Wareneingang;
import de.szut.ProjectZer0.service.WareneingangService;
/*
 * Dieser Controller ist f�r das Mapping des Models bzw. der Tabelle Wareneingang zust�ndig.
 * Es existiert ein Mapping f�r das anzeigen (WareneingangList) der Datens�tze.
 */

@Controller
public class WareneingangController {
	@Autowired
	WareneingangService wareneingangService;
	
	/*
	 * Dieses Mapping zum anzeigen aller Datens�tze der Wareneingang Tabelle in der Datenbank da.
	 * Alle Datens�tze werden �ber den WareneingangService aus der Datenbank geholt und �ber die 
	 * ModelMap an die JSP �bergeben
	 */
	@RequestMapping(value = {"/wareneingangList"}, method = RequestMethod.GET)
	public String listAllWareneingang(ModelMap model)
	{
		List<Wareneingang> wareneingang = wareneingangService.getAllBestandsartikel();
		model.addAttribute("Wareneingang", wareneingang);
		return "wareneingangList";
	}
}
