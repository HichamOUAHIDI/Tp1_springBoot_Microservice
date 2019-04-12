package org.ms;
import java.util.Date;

import org.ms.entites.Etudiant;
import org.ms.entites.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class TpSpringMicroServiceApplication implements CommandLineRunner {
    @Autowired
	private EtudiantRepository etudiantRepository;
	
    @Autowired
    private FormationRepository formationRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    
    
	public static void main(String[] args) {
		SpringApplication.run(TpSpringMicroServiceApplication.class, args);
	}
    
	@Override
	public void run(String... args) throws Exception {
		Formation f1=formationRepository.save(new Formation(null,"PHP",20,null));
		Formation f2=formationRepository.save(new Formation(null,"oracle",20,null));
		Formation f3=formationRepository.save(new Formation(null,"java",20,null));
		//afficher id dans api rest
		repositoryRestConfiguration.exposeIdsFor(Formation.class,Etudiant.class);
		// pour autorisation d'accée 
		repositoryRestConfiguration.getCorsRegistry()
		.addMapping("/**").allowedOrigins("*")
		.allowedHeaders("*").allowedMethods("OPTIONS","HEAD","GET","PUT","POST","DELETE","PATCH");
		
		etudiantRepository.save(new Etudiant(null,"OUAHIDI","Hicham", new Date(),f1));
		etudiantRepository.save(new Etudiant(null,"Rachid","wardi", new Date(),f2));
		etudiantRepository.save(new Etudiant(null,"monir","mardi", new Date(),f3));
		etudiantRepository.save(new Etudiant(null,"yassin","nabil", new Date(),f1));
		etudiantRepository.save(new Etudiant(null,"bilal","farssi", new Date(),f2));
		etudiantRepository.save(new Etudiant(null,"wajedi","ABC", new Date(),f3));
	}
	
}
