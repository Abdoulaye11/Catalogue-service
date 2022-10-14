package dia.civipol.catservice.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
//fonction lombok pour générer les getters et les setters de méme que les constructeurs
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Produit implements Serializable{
    //la clé primaire
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private double price;
    private int quantite;
    
}
