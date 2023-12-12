package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soa.entities.Devise;
import soa.repository.DeviseRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/devises")
public class DeviseRESTController {

    @Autowired
    private DeviseRepository deviseRepository;

    @GetMapping(value = "/index")
    public String accueil() {
        return "Bienvenue au service Web REST 'devises'.....";
    }

    @GetMapping(value = "/getall", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Devise> getAllDevises() {
        return deviseRepository.findAll();
    }

    @GetMapping(value = "getCourant/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Devise> getDevise(@PathVariable Long id) {
        System.out.println("hhhhhhhh");
        Devise devise = deviseRepository.findById(id).orElse(null);
        if (devise != null) {
            return ResponseEntity.ok(devise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping(value = "getByName/{nomDevise}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Devise>> getDeviseByName(@PathVariable String nomDevise) {
        List<Devise> devises = deviseRepository.findByNomDeviseContaining(nomDevise);

        if (!devises.isEmpty()) {
            return ResponseEntity.ok(devises);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Devise saveDevise(@RequestBody Devise devise) {
        return deviseRepository.save(devise);
    }

    @PutMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Devise updateDevise(@RequestBody Devise devise) {
        return deviseRepository.save(devise);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Void> deleteDevise(@PathVariable Long id) {
      System.out.println("Iam here");
        if (deviseRepository.existsById(id)) {
            deviseRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
