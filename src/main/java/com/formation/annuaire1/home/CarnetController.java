package com.formation.annuaire1.home;

import com.formation.annuaire1.canet.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.formation.annuaire1.canet.Carnet;

@RestController
public class CarnetController {
	
	List<Carnet> listeCarnets = new ArrayList<Carnet>(Arrays.asList(
			new Carnet(1, Civilite.MONSIEUR, "Besson", "Luc", "1959-13-18", "0000000000", "5 avenue de l'Element",
					"75015", "Paris"),
			new Carnet(2, Civilite.MADAME, "Ullmann", "Liv", "1938-12-16", "0101010101", "1-16-5", "22", "Tokyo"),
			new Carnet(3, Civilite.MONSIEUR, "Lynch", "David", "1946-01-20", "0202020202", "423 Fire Terrace", "59801",
					"Missoula")));
	
	@GetMapping("/carnets")// Renvoie la liste de carnet en json
	 public List<Carnet> getAllRest(Model model) {
		return this.listeCarnets;
	}
    @GetMapping("/carnetshtml") // Tout recuperer
    public ModelAndView getAll(){
        ModelAndView maVue = new ModelAndView("pages/carnets");
     // Ici on indique que dans le fichier carnets on retourne une liste: listeCarnets
        maVue.addObject("carnets", listeCarnets);
		return maVue;// Pour envoyer vers une vue
    }
	//Pour acceder au formulaire via la methode get: REQUETE
    @RequestMapping(value = "/carnet", method = RequestMethod.GET)
    public ModelAndView getFormulaire(){
    	ModelAndView maVue = new ModelAndView("/pages/formulaire");
    	return maVue;
    }

				
// Pour recuperer les nouvelles donnees du formulaire	 via la methode post: SOUMISSION	
	@RequestMapping(value ="/carnet", method = RequestMethod.POST)
	public void add(@ModelAttribute Carnet carnet){ // Recuperation des attributs du model (
		carnet.setId(listeCarnets.size() + 1);// La longeur du tableau +1
		listeCarnets.add(carnet); // Ce que tu viens de recuperer tu me l ajoute dans ma liste
	}
	
// Pour acceder au donnees d un employer en fonction de l id que l on marque sur URL (1, 2 ou 3) d ou la methode get
	    @RequestMapping(method = RequestMethod.GET, value = "/carnet/{id}")
	    public ModelAndView getById(@PathVariable Integer id){
	        ModelAndView maVue = new ModelAndView("pages/carnet");
	        for ( Carnet carnet : listeCarnets){
	            if (id.equals(carnet.getId())){
	            	maVue.addObject("carnet", carnet);
	                return maVue;
	            }
	        }
	        return null;
	    }
	
	    private ModelAndView modelAndView(String page, List<Object> tabVar){
	        ModelAndView maVue = new ModelAndView(page);
	        for( Object str : tabVar){
	        	maVue.addObject(str.toString(),str);
	        }
	        return maVue;
	    }
	}

