package de.szut.ProjectZer0.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.szut.ProjectZer0.model.User;
import de.szut.ProjectZer0.service.UserService;
/*
 * Dieser Controller ist f�r das Mapping des Models bzw. der Tabelle User zust�ndig.
 * Es existieren Mappings f�r die JSPs zum anlegen neuer Datens�tze (UserNew) 
 * sowie dem anzeigen (UserList) dieser.
 */

@Controller
public class UserController {
	@Autowired
	UserService userService;
	

	/*
	 * Dieses Mapping zum anzeigen aller Datens�tze der User Tabelle in der Datenbank da.
	 * Alle Datens�tze werden �ber den UserService aus der Datenbank geholt und �ber die 
	 * ModelMap an die JSP �bergeben
	 */
	@RequestMapping(value = {"/userlist"}, method = RequestMethod.GET)
	public String listAllUser(HttpServletRequest req, ModelMap model)
	{
		User checkUser = (User) req.getSession().getAttribute("user");
		if(checkUser != null)
		{
			if(checkUser.getPermissionPriority() >=3)
			{
			List<User> user = userService.getAllUser();
			model.addAttribute("User", user);
			return "userList";
			}
			return "berechtigung";
		}
		return "redirect:login";
	}
	
	/*
	 * Dieses Mapping erstellt ein leeres User Objekt und gibt 
	 * dieses �ber die ModelMap an die JSP weiter.
	 */
	@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
	public String register(ModelMap model) {
		User user = new User();
        model.addAttribute("User", user);
        model.addAttribute("edit", false);
        return "register";
	}
	
	/*
	 * Dieses Mapping empf�ngt das nun mit Daten gef�llte Objekt und 
	 * speichert es �ber unseren UserService in der Datenbank.
	 */
	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
    public String saveAccount(User user, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "register";
        }
         
        userService.saveUser(user);
 
        model.addAttribute("success", "User " + user.getUsername()+ " registered successfully.");
        return "redirect:userlist";

    }

	@RequestMapping("/registerCheck")
	public String registercheck() {
		return "redirect:login";
	}

	@RequestMapping("/userDel")
	public String userDelete(){
		userService.deleteUserByUsername("admin");
		return "redirect:userlist";
	}
	
}