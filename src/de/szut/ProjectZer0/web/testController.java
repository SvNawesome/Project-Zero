package de.szut.ProjectZer0.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.szut.ProjectZer0.model.testModel;

@Controller
public class testController {

		@RequestMapping("/eins.htm")
		public ModelAndView myAction()
		{
			ModelMap map = new ModelMap();
			map.addAttribute("test", new testModel());	
			return new ModelAndView("test/test", map);
		}
		
		@RequestMapping("/login.htm")
		public ModelAndView erpLogin()
		{
			ModelMap map = new ModelMap();
			map.addAttribute("login", new testModel());	
			return new ModelAndView("login/login", map);
		}
		
		@RequestMapping("/loginCheck.htm")
		public ModelAndView erpLoginCheck()
		{
			ModelMap map = new ModelMap();
			map.addAttribute("login", new testModel());	
			return new ModelAndView("login/loginCheck", map);
		}
		
		@RequestMapping("/loginError.htm")
		public ModelAndView erpLoginError()
		{
			ModelMap map = new ModelMap();
			map.addAttribute("login", new testModel());	
			return new ModelAndView("login/error", map);
		}
		
		@RequestMapping("/successfullLogin.htm")
		public ModelAndView erpLoginSuccessfull()
		{
			ModelMap map = new ModelMap();
			map.addAttribute("login", new testModel());	
			return new ModelAndView("login/successfullLogin", map);
		}
}
