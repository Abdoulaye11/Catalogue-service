package dia.civipol.catservice.entities;

import org.springframework.data.rest.core.config.Projection;

//permet d'afficher une entité parmi les entités
@Projection (name = "P1",types = Produit.class)
public interface ProduitProjection {
    public double getPrice();
}
