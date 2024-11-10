package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.example.demo.dao.AnnexeRepository;
import com.example.demo.dao.CategorieRepository;
import com.example.demo.dao.DistrictRepository;
import com.example.demo.dao.FonctionHommeAutoriteRepostitory;
import com.example.demo.dao.FonctionRepostitory;
import com.example.demo.dao.PachalikRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.SexRepository;
import com.example.demo.dao.SituationRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Annexe;
import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.District;
import com.example.demo.entities.Fonction;
import com.example.demo.entities.FonctionHommeAUtorite;
import com.example.demo.entities.Pachalik;
import com.example.demo.entities.Quartier;
import com.example.demo.entities.Sex;
import com.example.demo.entities.Situation;


@SpringBootApplication
public class SgiApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	@Autowired
	private AnnexeRepository annexeRepository;
	
	@Autowired
	private PachalikRepository pachalikRepository ;
	
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private DistrictRepository districtRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private SexRepository sexRepository;
	@Autowired
	private SituationRepository situationRepository;
	@Autowired
	FonctionRepostitory fonctionRepostitory;
	@Autowired
	FonctionHommeAutoriteRepostitory fonctionHommeAutoriteRepostitory;
	@Autowired
	@Lazy
	private com.example.demo.services.AccountService accountService;
	@Bean
	public BCryptPasswordEncoder getBPE() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public ProjectionFactory projectionFactory() {
	    return new SpelAwareProxyProjectionFactory();
	}
	public static void main(String[] args) {
		SpringApplication.run(SgiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		restConfiguration.exposeIdsFor(Annexe.class);
		restConfiguration.exposeIdsFor(District.class);
		restConfiguration.exposeIdsFor(Pachalik.class);
		restConfiguration.exposeIdsFor(Categorie.class);
		restConfiguration.exposeIdsFor(AppUser.class);
		restConfiguration.exposeIdsFor(Quartier.class);
		restConfiguration.exposeIdsFor(AppRole.class);
		restConfiguration.exposeIdsFor(Sex.class);
		restConfiguration.exposeIdsFor(Situation.class);
		
		restConfiguration.exposeIdsFor(Fonction.class);
		restConfiguration.exposeIdsFor(FonctionHommeAUtorite.class);

		if(!fonctionRepostitory.findById(1).isPresent()) {

			Fonction s1 = new Fonction("مقدم");
			Fonction s2 = new Fonction("خليفة");
			Fonction s3 = new Fonction("شيخ");
			
			fonctionRepostitory.save(s1);
			fonctionRepostitory.save(s2);
			fonctionRepostitory.save(s3);
			
		}
		if(!fonctionHommeAutoriteRepostitory.findById(1).isPresent()) {
		
			FonctionHommeAUtorite s1 = new FonctionHommeAUtorite("قائد");
			FonctionHommeAUtorite s2 = new FonctionHommeAUtorite("باشا");
			FonctionHommeAUtorite s3 = new FonctionHommeAUtorite("عامل");
			FonctionHommeAUtorite s4 = new FonctionHommeAUtorite("الوالي");
			
			fonctionHommeAutoriteRepostitory.save(s1);
			fonctionHommeAutoriteRepostitory.save(s2);
			fonctionHommeAutoriteRepostitory.save(s3);
			fonctionHommeAutoriteRepostitory.save(s4);
			
		}
		
		if(!situationRepository.findById(1).isPresent()) {
			
			Situation s1 = new Situation("single");
			Situation s2 = new Situation("married");
			Situation s3 = new Situation("divored");
			Situation s4 = new Situation("widow");
			
			
		situationRepository.save(s1);
		situationRepository.save(s2);
		situationRepository.save(s3);
		situationRepository.save(s4);
			
		}

		if(roleRepository.findByRoleName("ADMIN")==null) {
			accountService.saveRole(new AppRole(1,"ADMIN","مدير النظام"));
			accountService.saveRole(new AppRole(2,"USER-DSIT","DSIT-موظفي الولاية"));
			accountService.saveRole(new AppRole(3,"USER-AAL","موظفي الملحقات"));
			AppUser u = new AppUser("Laayoune2023@","yahya");
			AppRole role = 	roleRepository.findById(1).get();
			u.setRole(role);
			accountService.save(u);
			
		}

		if(!sexRepository.findById(1).isPresent()) {
			
			Sex s1 = new Sex("male");
			Sex s2 = new Sex("female");
			
			
		sexRepository.save(s1);
		sexRepository.save(s2);
			
		}

		
		if(pachalikRepository.findByDesignationFr("Pachalik Laayoune")==null) {
			pachalikRepository.save(new Pachalik("باشوية العيون","Pachalik Laayoune"));
			pachalikRepository.save(new Pachalik("دائرة العيون","Cercle Laayoune"));
			pachalikRepository.save(new Pachalik("باشوية المرسى","Pachalik El marsa"));
			
		}
		
		
	
	
	}


	

}
