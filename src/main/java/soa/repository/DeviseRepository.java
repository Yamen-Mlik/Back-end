package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.entities.Devise;

import java.util.List;

public interface DeviseRepository extends JpaRepository<Devise, Long> {

    // Rechercher des devises par nomDevise
    List<Devise> findByNomDeviseContaining(String nomDevise);

    // Rechercher des devises par tauxEchange supérieur à une valeur donnée
    List<Devise> findByNomDeviseContainingAndTauxEchangeGreaterThan(String nomDevise, double tauxEchangeMin);

    Devise findByNomDevise(String nomDevise);
    // Autres méthodes personnalisées selon vos besoins
}
