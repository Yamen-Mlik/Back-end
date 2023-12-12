package soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import soa.entities.Devise;
import soa.metier.DeviseMetierInterface;

import java.util.List;

@SpringBootApplication
public class SpringJpaApplication2 {

    static DeviseMetierInterface deviseMetier;

    public static void main(String[] args) {
        ApplicationContext contexte = SpringApplication.run(SpringJpaApplication2.class, args);
        deviseMetier = contexte.getBean(DeviseMetierInterface.class);

        // Exemple d'utilisation pour la gestion des devises
        System.out.println("---------Exemple pour la gestion des devises----------");
        ajouterDevisesExemple();
        afficherToutesLesDevises();

        // Appel de la méthode pour tester la conversion
        testerConversion();
    }

    // Méthode d'exemple pour ajouter quelques devises
    static void ajouterDevisesExemple() {
        deviseMetier.ajouterDevise(new Devise("EUR", 1.0, 100.0));
        deviseMetier.ajouterDevise(new Devise("USD", 1.18, 2222.0));
        deviseMetier.ajouterDevise(new Devise("GBP", 0.86, 67.98));
        deviseMetier.ajouterDevise(new Devise("JPY", 133.50, 57492.78));
        deviseMetier.ajouterDevise(new Devise("TDN", 3.3, 376.76));
    }

    // Méthode d'exemple pour afficher toutes les devises
    static void afficherToutesLesDevises() {
        System.out.println("********************Début**********************");
        System.out.println("Afficher toutes les devises...");
        System.out.println("***********************************************");

        List<Devise> devises = deviseMetier.listerDevises();
        for (Devise devise : devises) {
            System.out.println(devise);
        }

        System.out.println("********************Fin************************");
    }

    // Méthode d'exemple pour tester la conversion
    // Méthode d'exemple pour tester la conversion
    static void testerConversion() {
        double montantEnEuro = 1;
        System.out.println("Montant en Euro à convertir : " + montantEnEuro);

        String deviseCible = "TDN";
        System.out.println("Devise cible : " + deviseCible);

        double montantConverti = deviseMetier.convertirMontantEnEuro(montantEnEuro, deviseCible);
        System.out.println("Montant converti en " + deviseCible + ": " + montantConverti);
    }

}
