package dia.civipol.catservice.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import dia.civipol.catservice.entities.Produit;

//permet l'accé aux autres plateforme qui veulent utilisé les services
@CrossOrigin("*")
//Anotation pour les microservices avec Spring Data Rest
@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit,Long>{
    //faire la recherche par mot clé
    @RestResource(path = "/byDesignation")
    public List<Produit> findByDesignationContains(@Param("motCle") String des);
   
    //générer la pagination
    @RestResource(path = "/byDesignationPage")
    public Page<Produit> findByDesignationContains(@Param("motCle") String des,Pageable pageable);
    
}
