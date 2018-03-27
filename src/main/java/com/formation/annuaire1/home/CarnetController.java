package com.formation.annuaire1.home;

import com.formation.annuaire1.canet.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    	// On cree un nouvel objet qui genere une nouvelle page formulaire et l envoi au user
    	return new ModelAndView("pages/formulaire").addObject("carnet", new Carnet());
    	
    }

    			
// Pour recuperer les nouvelles donnees du formulaire via la methode post: SOUMISSION	
    @RequestMapping(value ="/carnetNew", method = RequestMethod.POST)
	// Pour le formulaire j ai supprime void et mis le type List<Carnet> 
	public ModelAndView add(@Validated Carnet carnet, BindingResult bindingResult){ // Recuperation des attributs du model  
    	//
    	if(bindingResult.hasErrors()){
    		// En cas d erreur dans le formuaire rempli
    		// Renvoyer un message d erreur
    		return new ModelAndView("pages/formulaire.html").addObject("carnet", carnet);
    		//return "errorview";
    	}
		carnet.setId(listeCarnets.size() + 1);// La longeur du tableau +1
		listeCarnets.add(carnet); // Ce que tu viens de recuperer tu me l ajoute dans ma liste
		// Ensuite j ai rajoute un retun 
		//Ainsi sur l url localhost:8080/carnet, j'ai EN JSON la liste avec la data en plus
		//return this.listeCarnets;
		return new ModelAndView("pages/carnets.html").addObject("carnets", this.listeCarnets);
		//ModelAndView maVue = new ModelAndView("/pages/carnets");
		//maVue.addObject("carnets", this.listeCarnets);
    	//return maVue;
		
	}
    
    
    
 // Pour supprimer un employer avec ses donnees du formulaire via la methode post: SOUMISSION	
  //  @RequestMapping(value ="/carnetNewDeal", method = RequestMethod.POST)
	
//	public ModelAndView destroy
    
    
    

	
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
	    @RequestMapping(value ="/carnet/{id}")
	    public void delete(@PathVariable Long id){
	    	Iterator<Carnet> it = listeCarnets.iterator();
	    	while(it.hasNext()){
	    		Carnet carnet = it.next();
	    		if (carnet.getId() == id){
	    			it.remove();
	    		}
	    	}
	    	//listeCarnet.removeIf(obj -> obj.getId().equals(id)); // Destroy à partir de java 8
	    }
	}

