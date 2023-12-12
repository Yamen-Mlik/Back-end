package soa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Devise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomDevise;
    private Double tauxEchange;
    private Double montant;


    public Devise() {
        // Constructeur par défaut nécessaire pour JPA
    }

    public Devise(String nomDevise, Double tauxEchange,Double montant) {
        this.nomDevise = nomDevise;
        this.tauxEchange = tauxEchange;
         this.montant=montant;
    }

    // Getters et setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomDevise() {
        return nomDevise;
    }

    public void setNomDevise(String nomDevise) {
        this.nomDevise = nomDevise;
    }

    public Double getTauxEchange() {
        return tauxEchange;
    }

    public void setTauxEchange(Double tauxEchange) {
        this.tauxEchange = tauxEchange;
    }
    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Devise [id=" + id + ", nomDevise=" + nomDevise + ", tauxEchange=" + tauxEchange +", montant=" + montant + "]";
    }

    // Méthode pour convertir un montant vers une autre devise
    public Double convertirMontant(Devise autreDevise, Double montantAConvertir) {
        if (tauxEchange != null && autreDevise.getTauxEchange() != null) {
            return montantAConvertir * (autreDevise.getTauxEchange() / tauxEchange);
        } else {
            throw new IllegalStateException("Les taux de change ne sont pas définis pour les devises.");
        }
    }
    }




