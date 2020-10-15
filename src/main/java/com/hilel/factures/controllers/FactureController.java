package com.hilel.factures.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hilel.factures.entities.Facture;
import com.hilel.factures.services.FactureService;
@Controller
public class FactureController {
@Autowired
FactureService factureService;
@RequestMapping("/showCreate")
public String showCreate()
{
return "createFacture";
}
@RequestMapping("/saveFacture")
public String saveFacture(@ModelAttribute("facture") Facture facture,
 @RequestParam("date") String date,
 ModelMap modelMap) throws
ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 facture.setDateCreation(dateCreation);

 Facture saveFacture = factureService.saveFacture(facture);
String msg ="facture enregistré avec Id "+saveFacture.getIdFacture();
modelMap.addAttribute("msg", msg);
return "createFacture";
}
@RequestMapping("/ListeFactures")
public String listeFactures(ModelMap modelMap)
{
List<Facture> facs = factureService.getAllFactures();
modelMap.addAttribute("factures", facs);
return "listeFactures";
}
@RequestMapping("/supprimerFacture")
public String supprimerFacture(@RequestParam("id") Long id,
 ModelMap modelMap)
{
factureService.deleteFactureById(id);
List<Facture> facs = factureService.getAllFactures();
modelMap.addAttribute("factures", facs);
return "listeFactures";
}
@RequestMapping("/modifierFacture")
public String editerFacture(@RequestParam("id") Long id,ModelMap modelMap)
{
Facture f= factureService.getFacture(id);
modelMap.addAttribute("facture", f);
return "editerfacture";
}
@RequestMapping("/updateFacture")
public String updateFacture(@ModelAttribute("facture") Facture facture,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException
{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 facture.setDateCreation(dateCreation);

	factureService.updateFacture(facture);
	 List<Facture> prods = factureService.getAllFactures();
	 modelMap.addAttribute("factures", prods);
	return "listeFactures";
	}


}