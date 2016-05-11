package de.szut.ProjectZer0.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import de.szut.ProjectZer0.model.Mitarbeiter;
import de.szut.ProjectZer0.service.MitarbeiterService;
/*
 * Dieser Controller ist f�r das Mapping des Models bzw. der Tabelle Mitarbeiter zust�ndig.
 * Es existieren Mappings f�r die JSPs zum anlegen neuer Datens�tze (MitarbeiterNew) 
 * sowie dem anzeigen (MitarbeiterList) dieser.
 */

@Controller
public class MitarbeiterController {

	@Autowired
	MitarbeiterService mitarbeiterService;

	/*
	 * Dieses Mapping erstellt ein leeres Mitarbeiter Objekt und gibt 
	 * dieses �ber die ModelMap an die JSP weiter.
	 */
	@RequestMapping(value = { "/mitarbeiterNew" }, method = RequestMethod.GET)
	public String mitarbeiterNew(HttpServletRequest req, ModelMap model) {
		if (req.getSession().getAttribute("user") != null) {
			Mitarbeiter mitarbeiter = new Mitarbeiter();
			model.addAttribute("Mitarbeiter", mitarbeiter);
			model.addAttribute("edit", false);
			return "mitarbeiterNew";
		}
		return "redirect:login";
	}

	/*
	 * Dieses Mapping empf�ngt das nun mit Daten gef�llte Objekt und 
	 * speichert es �ber unseren MitarbeiterService in der Datenbank.
	 */
	@RequestMapping(value = { "/mitarbeiterNew" }, method = RequestMethod.POST)
	public String saveMitarbeiter(HttpServletRequest req, Mitarbeiter mitarbeiter, BindingResult result, ModelMap model) {
		if (req.getSession().getAttribute("user") != null) {
			if (result.hasErrors()) {
				return "mitarbeiterNew";
			}

			mitarbeiterService.saveMitarbeiter(mitarbeiter);

			// model.addAttribute("success", "Mitarbeiter " +
			// mitarbeiter.getBezeichnung() + " registered successfully.");
			return "mitarbeiterList";
		}
		return "redirect:login";
	}

	/*
	 * Dieses Mapping zum anzeigen aller Datens�tze der Mitarbeiter Tabelle in der Datenbank da.
	 * Alle Datens�tze werden �ber den MitarbeiterService aus der Datenbank geholt und �ber die 
	 * ModelMap an die JSP �bergeben
	 */
	@RequestMapping(value = { "/mitarbeiterList" }, method = RequestMethod.GET)
	public String listAllMitarbeiter(HttpServletRequest req, ModelMap model) {
		if (req.getSession().getAttribute("user") != null) {
			List<Mitarbeiter> mitarbeiter = mitarbeiterService.getAllMitarbeiter();
			model.addAttribute("Mitarbeiter", mitarbeiter);
			return "mitarbeiterList";
		}

		return "redirect:login";
	}
}
