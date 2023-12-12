package soa.metier;



import soa.entities.Devise;

import java.util.List;

public interface DeviseMetierInterface {
    void ajouterDevise(Devise devise);
    Devise rechercherDevise(Long id);
    List<Devise> listerDevises();
    void mettreAJourTauxEchange(Long idDevise, double nouveauTauxEchange);
    void supprimerDevise(Long idDevise);
    Devise trouverDeviseParNom(String nomDevise);
    double convertirMontantEnEuro(double montant, String deviseCible);


}
