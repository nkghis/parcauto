package ci.nkagou.parcauto.controllers;

import ci.nkagou.parcauto.dtos.vehicule.VehiculeDto;
import ci.nkagou.parcauto.dtos.vehicule.VehiculeDtoOut;
import ci.nkagou.parcauto.entities.Marque;
import ci.nkagou.parcauto.entities.Typevehicule;
import ci.nkagou.parcauto.entities.Vehicule;
import ci.nkagou.parcauto.enums.Couleur;
import ci.nkagou.parcauto.services.MarqueService;
import ci.nkagou.parcauto.services.TypevehiculeService;
import ci.nkagou.parcauto.services.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class VehiculeController {

    private final VehiculeService vehiculeService;

    private final TypevehiculeService typevehiculeService;

    private final MarqueService marqueService;

    public VehiculeController(VehiculeService vehiculeService, TypevehiculeService typevehiculeService, MarqueService marqueService) {
        this.vehiculeService = vehiculeService;
        this.typevehiculeService = typevehiculeService;
        this.marqueService = marqueService;
    }



    @RequestMapping(value =  "/vehicule/vehicules", method = RequestMethod.GET)
    public String index(Model model, Principal principal, HttpServletRequest request) {

        List<Vehicule> vehicules = vehiculeService.all();
        List<VehiculeDtoOut> dtos = vehiculeService.listVehiculesToDto(vehicules);

        model.addAttribute("listVehicules", dtos);
        model.addAttribute("title", "Vehicules - Liste");

        return "vehicule/index";
    }

    @RequestMapping(value = "/vehicule/vehicules/new", method = RequestMethod.GET)
    public String newVehicule(Model model, Principal principal){

        //AppUser user = userService.findByUserName(principal.getName());
        List<Typevehicule> typevehicules = typevehiculeService.all();
        List<Marque> marques = marqueService.all();
        List<Couleur> couleurs = Arrays.asList(Couleur.values());
        model.addAttribute("vehiculedto",new VehiculeDto());
        model.addAttribute("listTypevehicules",typevehicules);
        model.addAttribute("listMarques",marques);
        model.addAttribute("listCouleurs",couleurs);
        model.addAttribute("title", "Vehicule - Nouveau");

        return "vehicule/new";
    }

    @RequestMapping(value = "/vehicule/vehicules/save", method = RequestMethod.POST)
    public String saveVehicule(@Valid VehiculeDto vehiculeDto, Errors errors, Model model, RedirectAttributes redirectAttributes, Principal principal, BindingResult bindingResult) {
        if (errors.hasErrors()) {
       // if ((bindingResult.hasErrors())) {
            System.out.println("error YES");
            model.addAttribute("vehiculedto", new VehiculeDto());
            List<Typevehicule> typevehicules = typevehiculeService.all();
            List<Marque> marques = marqueService.all();
            List<Couleur> couleurs = Arrays.asList(Couleur.values());
            model.addAttribute("listTypevehicules",typevehicules);
            model.addAttribute("listMarques",marques);
            model.addAttribute("listCouleurs",couleurs);
            model.addAttribute("title", "Vehicule - Nouveau");
            model.addAttribute("errors", errors);
           // return  "vehicule/new";
            return "vehicule/new";
        }

        Vehicule vehicule = vehiculeService.dtoToVehicule(vehiculeDto);
        Vehicule v = vehiculeService.create(vehicule);
        //Get user connected
        // AppUser user = userService.findByUserName(principal.getName());



        redirectAttributes.addFlashAttribute("messagesucces", "Opération de création éffectuée avec succès");
        return "redirect:/vehicule/vehicules/";

    }

    @RequestMapping(value = "/vehicule/vehicules/edit/{id}", method = RequestMethod.GET)
    public String editVehicule(@PathVariable Long id, Model model){

        Vehicule vehicule = vehiculeService.findById(id);

        List<Typevehicule> typevehicules = typevehiculeService.all();

        List<Marque> marques = marqueService.all();
        List<Couleur> couleurs = Arrays.asList(Couleur.values());
        model.addAttribute("listTypevehicules",typevehicules);
        model.addAttribute("listMarques",marques);
        model.addAttribute("listCouleurs",couleurs);
        model.addAttribute("vehicule",vehicule);

        model.addAttribute("title", "Vehicule - Edition");
        return "vehicule/edit";
    }

    @RequestMapping(value = "/vehicule/vehicules/update", method = RequestMethod.POST)
    public String updateProjet(@Valid Vehicule vehicule, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            //model.addAttribute("monprojet", new Projet());
            return "vehicule/new";
        }




        return "redirect:/vehicule/vehicules";
    }

    @RequestMapping(value = "/vehicule/vehicules/delete/{id}", method = RequestMethod.GET)
    public String deleteVehicule(@PathVariable Long id){


        return "redirect:/vehicule/vehicules/";
    }

}
