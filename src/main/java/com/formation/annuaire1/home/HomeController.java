package com.formation.annuaire1.home;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	
	@GetMapping("/")// pour renvoyer une page
	@ResponseBody  // et ensuite son contenu 
	public String index() {
		return "<h1>Hello world !</h1>";
		}
	
	
	@GetMapping("/test")	// pour renvoyer une page
	public String index2(@RequestParam(required = false, defaultValue="defaut") String name, Model model) { // name = nom du parametre
		//j envoie mon parametre vers la page index
		model.addAttribute("key", name);//le mapping donc cle et valeur correspondante
		return "index";
		}

}
