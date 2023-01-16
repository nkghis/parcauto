package ci.nkagou.parcauto;

import ci.nkagou.parcauto.dtos.vehicule.VehiculeDtoOut;
import ci.nkagou.parcauto.entities.*;
import ci.nkagou.parcauto.enums.Couleur;
import ci.nkagou.parcauto.enums.Genre;
import ci.nkagou.parcauto.repositories.RoleRepository;
import ci.nkagou.parcauto.repositories.UserRepository;
import ci.nkagou.parcauto.repositories.UserRoleRepository;
import ci.nkagou.parcauto.services.*;
import ci.nkagou.parcauto.utils.EncrytedPasswordUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ParcautoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(ParcautoApplication.class, args);

		/*System.out.println("===============DEBUT TRANSACTION=======================");

		EmployeService employeService = ctx.getBean(EmployeService.class);
		SiteService siteService = ctx.getBean(SiteService.class);
		DirectionService directionService = ctx.getBean(DirectionService.class);
		DmdService dmdService = ctx.getBean(DmdService.class);
		EmployeDmdService employeDmdService = ctx.getBean(EmployeDmdService.class);*/


	/*	System.out.println("List des employés");
		List<Site> sites = siteService.all();
		Optional<Site> site = siteService.findById(1L);*/

		//Dmd mydmd = dmdService.getById(2L);
		//Optional<Dmd> dmd = dmdService.findById(2L);
		/*Dmd dmd = dmdService.findbyIDS(2L);
		List<Employe> employes1 = dmd.getEmployes();

		employes1.forEach(u -> System.out.println( u.getNom()));*/

		//EmployeDmd employeDmd = new EmployeDmd();


		//System.out.println("Dmd ajoutées avec succes");


		/*Site sitePerso = new Site("CENTRE DE PERSO");
		Site siteProduction = new Site("PRODUCTION");
		Site siteSiege = new Site("SIEGE");
		siteService.create(sitePerso);
		siteService.create(siteProduction);
		siteService.create(siteSiege);
		System.out.println("Sites ajoutés avec succes");
		siteService.all().forEach(u -> System.out.println(u.getLibelle()));
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===============AJOUT DIRECTION=======================");

		Direction directionDSI = new Direction("DSI");
		Direction directionPRODUCTION = new Direction("DIRECTION PRODUCTION");
		Direction directionTECNHIQUE = new Direction("DIRECTION TECNHIQUE");
		Direction directionDAF = new Direction("DAF");
		directionService.create(directionDSI);
		directionService.create(directionPRODUCTION);
		directionService.create(directionTECNHIQUE);
		directionService.create(directionDAF);
		System.out.println("Directions ajoutées avec succes");
		directionService.all().forEach(u->System.out.println(u.getLibelle()));
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");


		Employe employeYao = new Employe();
		employeYao.setNumMatEmpl(12L);
		employeYao.setNom("YAO");
		employeYao.setPrenom("FRANCK");
		employeYao.setDateEmbauche(LocalDate.of(2000,12, 12));
		employeYao.setDateNaissance(LocalDate.of(1980,1, 1));
		employeYao.setEmail("franck.yao@aaa.ci");
		employeYao.setFonction("Agent de maitrise");
		employeYao.setGenre(Genre.MASCULIN);
		employeYao.setEstSuperieureHierachique(false);
		employeYao.setEstChauffeur(false);
		employeYao.setTelephoneEmploye("0101010101");
		employeYao.setDirection(directionPRODUCTION);
		employeYao.setSite(siteProduction);
		employeService.create(employeYao);

		Employe employeKone = new Employe();
		employeKone.setNumMatEmpl(13L);
		employeKone.setNom("VAKABA");
		employeKone.setPrenom("TRO");
		employeKone.setDateEmbauche(LocalDate.of(2001,11, 11));
		employeKone.setDateNaissance(LocalDate.of(1983,2, 3));
		employeKone.setEmail("tro.vakaba@aaa.ci");
		employeKone.setFonction("Agent de maitrise");
		employeKone.setGenre(Genre.FEMININ);
		employeKone.setEstSuperieureHierachique(false);
		employeKone.setEstChauffeur(false);
		employeKone.setTelephoneEmploye("0101010102");
		employeKone.setDirection(directionPRODUCTION);
		employeKone.setSite(siteProduction);
		employeService.create(employeKone);
		System.out.println("Employé ajoutés avec succes");
		employeService.all().forEach(u->System.out.println(u.getNom()));
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&FIN DE LA TRANSACTION&&&&&&&&&&&&&&&&&&&");


		String p = "123";
		String password = EncrytedPasswordUtils.encrytePassword(p);

		System.out.println("===============DEBUT TRANSACTION=======================");
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		AppUser admin = userRepository.save(new AppUser("admin",password,true));
		AppUser user = userRepository.save(new AppUser("user",password,true));
		AppUser access = userRepository.save(new AppUser("access",password,true));
		System.out.println("===============AJOUT CLIENT=======================");
		userRepository.findAll().forEach(u->System.out.println(u.getUserName()));
		System.out.println("Utilisateurs ajoutés avec succes");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(
				"===============AJOUT ROLE=======================");
		RoleRepository roleRepository = ctx.getBean(RoleRepository.class);
		AppRole roleadmin = roleRepository.save(new AppRole("ROLE_ADMIN"));
		AppRole roleaccess = roleRepository.save(new AppRole("ROLE_ACCES"));
		AppRole roleuser = roleRepository.save(new AppRole("ROLE_USER"));
		roleRepository.findAll().forEach(u->System.out.println(u.getRoleName()));
		System.out.println("Roles ajoutés avec succes");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		System.out.println("===============AFFECTATION ROLE PAR USER=======================");
		UserRoleRepository userRoleRepository = ctx.getBean(UserRoleRepository.class);
		userRoleRepository.save(new UserRole(admin,roleadmin));
		userRoleRepository.save(new UserRole(admin,roleuser));
		userRoleRepository.save(new UserRole(admin,roleaccess));
		userRoleRepository.save(new UserRole(access,roleaccess));
		userRoleRepository.save(new UserRole(user,roleuser));
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&FIN DE LA TRANSACTION&&&&&&&&&&&&&&&&&&&");*/

		/*UserRepository userRepository = ctx.getBean(UserRepository.class);
		AppUser admin = userRepository.findByUserName("admin");
		List<AppRole> roles = admin.getRoles();
		roles.forEach(u -> System.out.println(u.getRoleName()));
		List<UserRole> userRoles = admin.getUserRoles();*/

		/*Employe employeYao = employeService.findById(1L);
		Employe employeTro = employeService.findById(2L);

		List<Employe> employes = new ArrayList<>();
		employes.add(employeTro);
		employes.add(employeYao);

		Dmd dmd = new Dmd();
		dmd.setMotif("Enlevement centre de perso");
		dmd.setKmDepart(10);
		dmd.setKmRetour(30);
		dmd.setHeureDepart(LocalTime.now());
		dmd.setHeureRetour(LocalTime.now());
		dmd.setDateRemplissageDmd(LocalDate.now());
		//dmd.setEmployes(employes);
		dmdService.create(dmd);

		employeDmdService.create(new EmployeDmd(employeTro,dmd, LocalDateTime.now()));
		employeDmdService.create(new EmployeDmd(employeYao,dmd, LocalDateTime.now()));

		Dmd dmd1 = dmdService.findById(3L);
		dmd1.getEmployes().forEach(u -> System.out.println(u.getNom()));*/

/*

		VehiculeService vehiculeService = ctx.getBean(VehiculeService.class);
		TypevehiculeService typevehiculeService = ctx.getBean(TypevehiculeService.class);
		MarqueService marqueService = ctx.getBean(MarqueService.class);

		System.out.println("===============DEBUT TRANSACTION=======================");

		typevehiculeService.create(new Typevehicule("BERLINE"));
		typevehiculeService.create(new Typevehicule("CAMION"));
		typevehiculeService.create(new Typevehicule("FOURGON"));
		typevehiculeService.create(new Typevehicule("FOURGONNETTE"));
		typevehiculeService.create(new Typevehicule("PICKUP 4x4"));
		System.out.println("===============AJOUT TYPE VEHICULE=======================");
		typevehiculeService.all().forEach(u-> System.out.println(u.getLibelle()));
		System.out.println("Type vehicule ajoutés avec succès");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");




		marqueService.create(new Marque("BMW"));
		marqueService.create(new Marque("FIAT"));
		marqueService.create(new Marque("FORD"));
		marqueService.create(new Marque("GREATWALL"));
		marqueService.create(new Marque("HYUNDAI"));
		marqueService.create(new Marque("TOYOTA"));
		System.out.println("===============AJOUT MARQUE=======================");
		marqueService.all().forEach(u -> System.out.println(u.getName()));
		System.out.println("Marques ajoutées avec succès");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		System.out.println("===============AJOUT VEHICULE=======================");

		Marque marqueBmw = marqueService.findByName("BMW");
		Marque marqueHyundai = marqueService.findByName("HYUNDAI");
		Marque marqueFiat = marqueService.findByName("FIAT");
		Marque marqueGreatwall = marqueService.findByName("GREATWALL");

		Typevehicule typevehiculeBerline = typevehiculeService.findByLibelle("BERLINE");
		Typevehicule typevehiculeFourgon = typevehiculeService.findByLibelle("FOURGON");
		Typevehicule typevehiculeFourgonnette = typevehiculeService.findByLibelle("FOURGONNETTE");
		Typevehicule typevehiculePickup = typevehiculeService.findByLibelle("PICKUP 4x4");

		vehiculeService.create(new Vehicule("1234GT01", Couleur.BEIGE,LocalDate.now(), "123FRSQA", marqueBmw, typevehiculeBerline ));
		vehiculeService.create(new Vehicule("1234GT02", Couleur.NOIR,LocalDate.now(), "123FRSQB", marqueHyundai, typevehiculeFourgon ));
		vehiculeService.create(new Vehicule("1234GT03", Couleur.BLEU,LocalDate.now(), "123FRSQC", marqueFiat, typevehiculeFourgonnette ));
		vehiculeService.create(new Vehicule("1234GT04", Couleur.JAUNE,LocalDate.now(), "123FRSQC", marqueGreatwall, typevehiculePickup ));
		vehiculeService.all().forEach(u -> System.out.println(u.getImmatriculation()));
		System.out.println("Vehicules ajoutés avec succès");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		System.out.println("===============FIN TRANSACTION=======================");*/


		/*List<Vehicule> vehicules = vehiculeService.all();
		List<VehiculeDtoOut> dtos = vehiculeService.listVehiculesToDto(vehicules);
		String c = "test";*/
		String server ="Server start on http://localhost:8089";
		System.out.println(server);
	}

}
