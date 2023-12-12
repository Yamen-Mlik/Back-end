package soa.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soa.entities.Devise;
import soa.repository.DeviseRepository;

import java.util.List;

@Service
public class DeviseMetierImpl implements DeviseMetierInterface {

    @Autowired
    private DeviseRepository deviseRepository;

    @Override
    public void ajouterDevise(Devise devise) {
        deviseRepository.save(devise);
    }

    @Override
    public Devise rechercherDevise(Long id) {
        return deviseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Devise> listerDevises() {
        return deviseRepository.findAll();
    }

    @Override
    public void mettreAJourTauxEchange(Long idDevise, double nouveauTauxEchange) {
        Devise devise = deviseRepository.findById(idDevise).orElse(null);
        if (devise != null) {
            devise.setTauxEchange(nouveauTauxEchange);
            deviseRepository.save(devise);
        }
    }

    @Override
    public void supprimerDevise(Long idDevise) {
        deviseRepository.deleteById(idDevise);
    }

    @Override
    public Devise trouverDeviseParNom(String nomDevise) {
        // Implémentation de la recherche par nom
        return deviseRepository.findByNomDevise(nomDevise);
    }

    @Override
    public double convertirMontantEnEuro(double montant, String deviseCible) {
        Devise deviseCibleObjet = trouverDeviseParNom(deviseCible);

        if (deviseCibleObjet != null) {
            double tauxEchangeCible = deviseCibleObjet.getTauxEchange();

            // Convertir le montant en euros
            return montant * tauxEchangeCible;
        } else {
            // Gérer le cas où la devise cible n'est pas trouvée
            throw new RuntimeException("Devise cible non trouvée");
        }
    }
}
