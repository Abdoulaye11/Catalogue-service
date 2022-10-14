package dia.civipol.catservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dia.civipol.catservice.dao.ProduitRepository;
import dia.civipol.catservice.entities.Produit;

//permet de gérer ses propes services 
@RestController
public class ProduitRestService {
    @Autowired
    ProduitRepository produitRepository;
   
    @GetMapping(value = "/listProduit")
    public List<Produit> listProduit(){
       return produitRepository.findAll();
    }

    @GetMapping(value = "/listProduit/{id}")
    public Produit listProduit(@PathVariable(name = "id") Long id){
       return produitRepository.findById(id).get();
    }

    @PutMapping(value = "/updtateProduit/{id}")
    public Produit updateProduit(@PathVariable(name = "id") Long id,@RequestBody Produit p){
        p.setId(id);
       return produitRepository.save(p);
    }

    @PostMapping(value = "/produit")
    public Produit produit(@RequestBody Produit p){
       return produitRepository.save(p);
    }

    @DeleteMapping(value = "/deleteProduit/{id}")
    public void deleteProduit(@PathVariable(name = "id") Long id){
       produitRepository.deleteById(id);
    }
}
