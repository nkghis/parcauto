package ci.nkagou.parcauto;

import ci.nkagou.parcauto.entities.*;
import ci.nkagou.parcauto.enums.Genre;
import ci.nkagou.parcauto.repositories.RoleRepository;
import ci.nkagou.parcauto.repositories.UserRepository;
import ci.nkagou.parcauto.repositories.UserRoleRepository;
import ci.nkagou.parcauto.services.DirectionService;
import ci.nkagou.parcauto.services.EmployeService;
import ci.nkagou.parcauto.services.SiteService;
import ci.nkagou.parcauto.utils.EncrytedPasswordUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ParcautoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(ParcautoApplication.class, args);

		System.out.println("===============DEBUT TRANSACTION=======================");

		EmployeService employeService = ctx.getBean(EmployeService.class);
		SiteService siteService = ctx.getBean(SiteService.class);
		DirectionService directionService = ctx.getBean(DirectionService.class);
		System.out.println("===============AJOUT SITE=======================");

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
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");*/
/*		Direction directionPRODUCTION = directionService.getById(1L);
		//String lib = directionPRODUCTION.getLibelle();
		Site siteProduction = siteService.getById(1L);
		//String libSite = siteProduction.getLibelle();
		System.out.println("===============AJOUT EMPLOYE=======================");*/

		/*Employe employeYao = new Employe();
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
		employeService.create(employeYao);*/

/*		Employe employeKone = new Employe();
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
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&FIN DE LA TRANSACTION&&&&&&&&&&&&&&&&&&&");*/


	/*
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
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&FIN DE LA TRANSACTION&&&&&&&&&&&&&&&&&&&");
*/
		String server ="Server start on http://localhost:8089";
		System.out.println(server);
	}

}
