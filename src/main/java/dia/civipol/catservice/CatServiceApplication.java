package dia.civipol.catservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import dia.civipol.catservice.dao.ProduitRepository;
import dia.civipol.catservice.entities.Produit;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner{
	@Autowired
	private ProduitRepository produitRepository;
    @Autowired
	//permet d'afficher l'id dans spring data rest
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(CatServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Produit.class);
		produitRepository.save(new Produit(null,"Mac OS",50000,2));
		produitRepository.save(new Produit(null,"HP",120000,3));

		produitRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});;
		
	}

}
