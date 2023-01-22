package ci.nkagou.parcauto.controllers;

import ci.nkagou.parcauto.dtos.dmd.DmdParcDto;
import ci.nkagou.parcauto.dtos.dmd.DmdParcDtoOut;
import ci.nkagou.parcauto.dtos.dmd.DmdUserDto;
import ci.nkagou.parcauto.dtos.dmd.DmdUserDtoOut;
import ci.nkagou.parcauto.entities.AppUser;
import ci.nkagou.parcauto.entities.Dmd;
import ci.nkagou.parcauto.entities.Employe;
import ci.nkagou.parcauto.entities.EmployeDmd;
import ci.nkagou.parcauto.enums.MoyenDemande;
import ci.nkagou.parcauto.enums.Statut;
import ci.nkagou.parcauto.services.DmdService;
import ci.nkagou.parcauto.services.EmployeService;
import ci.nkagou.parcauto.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class DmdController {

    private final DmdService dmdService;
    private final EmployeService employeService;
    public static Principal principal;
    //private final UserService userService;


    public DmdController(DmdService dmdService, EmployeService employeService/*, UserService userService*/) {
        this.dmdService = dmdService;
        this.employeService = employeService;
        //this.userService = userService;
    }

    @RequestMapping("/dmd/dmds")
    public String index(Model model, Principal principal, HttpServletRequest request) {

        //Get User connected
        //AppUser user = userService.findByUserName(principal.getName());

        //Get Employe by user connected
        Employe employe = employeService.getEmployeByUserName(principal.getName());

        //Set roleParcauto
        String roleParcauto = "ROLE_PARCAUTO";

        List<DmdUserDtoOut> dtos = new ArrayList<>();

        //Check in  user connected have role "ROLE_PARCAUTO"
        if (request.isUserInRole(roleParcauto)) {

            //Get all EmployeDmd
            List<EmployeDmd> epDmds = dmdService.all();

            dtos = dmdService.listDmdsToDto(epDmds);

            //Convert EmployeDmd to DmdParcDtoOut
            //List<DmdParcDtoOut> dmds = dmdService.listDmdsParcToDto(epDmds);
            //model.addAttribute("listDmdParcauto",dmds);
            //return "indexParc";

        } else {

            //Get EmployeDmd by Employe
            List<EmployeDmd> epDmds = dmdService.findEmployeDmdsByEmploye(employe);
            dtos = dmdService.listDmdsToDto(epDmds);

            //Convert EmployeDmd to DmdUserDtoOut
            //List<DmdUserDtoOut> dmds = dmdService.listDmdsToDto(epDmds);
            //model.addAttribute("listDmdUser",dmds);
            //return "indexUser";

        }
        List<Statut> statuts = Arrays.asList(Statut.values());

        model.addAttribute("listDmds", dtos);
        model.addAttribute("listStatuts", statuts);

        return "dmd/index";


    }

    @RequestMapping(value = "/dmd/dmds/user", method = RequestMethod.GET)
    public String newDmdUser(Model model) {

        List<MoyenDemande> moyenDemandes = Arrays.asList(MoyenDemande.values());
        model.addAttribute("dmdUserDto", new DmdUserDto());
        model.addAttribute("title", "Dmd - Nouveau");
        model.addAttribute("listMoyenDemandes", moyenDemandes);

        return "dmd/new";

    }

    @RequestMapping(value = "/dmd/dmds/parc", method = RequestMethod.GET)
    public String newDmdParc(Model model) {

        List<MoyenDemande> moyenDemandes = Arrays.asList(MoyenDemande.values());
        model.addAttribute("dmdParcDto", new DmdParcDto());
        model.addAttribute("title", "Dmd - Nouveau");
        model.addAttribute("listMoyenDemandes", moyenDemandes);

        return "dmd/newParc";

    }

    @RequestMapping(value = "/dmd/dmds/user/save", method = RequestMethod.POST)
    public String saveDmdUser(@Valid DmdUserDto dmdUserDto, Errors errors,  Model model, RedirectAttributes redirectAttributes, Principal principal) {

        if (errors.hasErrors()) {
            System.out.println("error YES");
            List<MoyenDemande> moyenDemandes = Arrays.asList(MoyenDemande.values());
            model.addAttribute("dmdUserDto", new DmdUserDto());
            model.addAttribute("title", "Dmd - Nouveau");
            model.addAttribute("listMoyenDemandes", moyenDemandes);
            return "dmd/dmd/user";
        }

        //Get Employe by user connected
        Employe employe = employeService.getEmployeByUserName(principal.getName());

        //Set employe to DmDtoUser
        dmdUserDto.setEmploye(employe);

        //Create Dmd and Employe Dmd on DataBase
        dmdService.createDmdUser(dmdUserDto);


        //Get information of flash message
        redirectAttributes.addFlashAttribute("messagesucces", "Opération de création éffectuée avec succès");

        return "redirect:/dmd/dmds";
    }

    @RequestMapping(value = "/dmd/dmds/parc/save", method = RequestMethod.POST)
    public String saveDmdParc(@Valid DmdParcDto dmdParcDto, Errors errors,  Model model, RedirectAttributes redirectAttributes) {

        if (errors.hasErrors()) {
            System.out.println("error YES");
            List<MoyenDemande> moyenDemandes = Arrays.asList(MoyenDemande.values());
            model.addAttribute("dmdParcDto", new DmdParcDto());
            model.addAttribute("title", "Dmd - Nouveau");
            model.addAttribute("listMoyenDemandes", moyenDemandes);
            return "Dmd/dmd";
        }


        redirectAttributes.addFlashAttribute("messagesucces", "Opération de création éffectuée avec succès");
        return "redirect:/dmd/dmds";
    }


    @RequestMapping(value = "/dmd/dmds/user/edit/{id}", method = RequestMethod.GET)
    public String editDmdUser(@PathVariable Long id, Model model){

        //Get EmployeDmd By id
        EmployeDmd employeDmd = dmdService.findById(id);

        //Set DmdUserDto
        DmdUserDto dto = new DmdUserDto();
        dto.setId(employeDmd.getIdEmployeDmd());
        dto .setDatePrevue(employeDmd.getDmd().getDatePrevue());
        dto.setHeurePrevue(employeDmd.getDmd().getHeurePrevue());
        dto.setMoyenDemande(employeDmd.getDmd().getMoyenDemande().name());
        dto.setMotif(employeDmd.getMotifDmd());
        dto.setDestination(employeDmd.getDestination());
        //dto.setEmploye(employeDmd.getEmploye());

        //Get Moyen demande list
        List<MoyenDemande> moyenDemandes = Arrays.asList(MoyenDemande.values());
        model.addAttribute("dmdUserDto", dto);
        model.addAttribute("listMoyenDemandes", moyenDemandes);
        model.addAttribute("title", "Dmd - Edition");
        return "dmd/edit";
    }


    @RequestMapping(value = "/dmd/dmds/user/update", method = RequestMethod.POST)
    public String updateDmdUser(@Valid DmdUserDto dmdUserDto, Errors errors,  Model model, RedirectAttributes redirectAttributes, Principal principal) {

        if (errors.hasErrors()) {
            System.out.println("error YES");
            List<MoyenDemande> moyenDemandes = Arrays.asList(MoyenDemande.values());
            model.addAttribute("dmdParcDto", new DmdParcDto());
            model.addAttribute("title", "Dmd - Nouveau");
            model.addAttribute("listMoyenDemandes", moyenDemandes);
            return "Dmd/dmd";
        }

        String s = "";

        //Get Employe by user connected
        Employe employe = employeService.getEmployeByUserName(principal.getName());

        //Set employe to DmDtoUser
        dmdUserDto.setEmploye(employe);
        //update Dmd and Employe Dmd on DataBase
        dmdService.updateDmdUser(dmdUserDto);


        redirectAttributes.addFlashAttribute("messagesucces", "Opération de création éffectuée avec succès");
        return "redirect:/dmd/dmds";
    }

    @RequestMapping(value = "/dmd/dmds/parc/edit/{id}", method = RequestMethod.GET)
    public String editDmdParc(@PathVariable Long id, Model model){



        model.addAttribute("title", "Dmd - Edition");
        return "dmd/edit";
    }

    @RequestMapping(value = "/dmd/dmds/parc/update", method = RequestMethod.POST)
    public String updateDmdParc(@Valid DmdParcDto dmdParcDto, Errors errors,  Model model, RedirectAttributes redirectAttributes) {

        if (errors.hasErrors()) {
            System.out.println("error YES");
            List<MoyenDemande> moyenDemandes = Arrays.asList(MoyenDemande.values());
            model.addAttribute("dmdParcDto", new DmdParcDto());
            model.addAttribute("title", "Dmd - Nouveau");
            model.addAttribute("listMoyenDemandes", moyenDemandes);
            return "Dmd/dmd";
        }


        redirectAttributes.addFlashAttribute("messagesucces", "Opération de création éffectuée avec succès");
        return "redirect:/dmd/dmds";
    }

    @RequestMapping(value = "/dmd/dmds/delete/{id}", method = RequestMethod.GET)
    public String deleteDmd(@PathVariable Long id){

        EmployeDmd employeDmd = dmdService.findById(id);
        dmdService.delete(employeDmd);
        //return "redirect:/acces/Dmd";
        return "redirect:/dmd/dmds";
    }




}
