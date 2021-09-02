package fr.stackinsat.test.controller;

import fr.stackinsat.test.entity.Personne;
import fr.stackinsat.test.service.PersonneService;
import fr.stackinsat.test.vm.PersonneVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonneController {

    private static final Logger logger = LoggerFactory.getLogger(PersonneController.class);

    @Autowired
    private PersonneService personneService;

    @GetMapping("/personne/{id}")
    public ResponseEntity<Personne> get(@PathVariable Long id) {
        logger.info("PersonneController - get");

        Personne personne = personneService.get(id);

        if (personne != null) {
            return ResponseEntity.ok(personne);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/personne")
    public ResponseEntity<Personne> post(@RequestBody Personne personne) {
        logger.info("PersonneController - post");

        Personne personneNew = personneService.add(personne);

        return ResponseEntity.ok(personne);
    }

    @GetMapping("/personnes")
    public ResponseEntity<List<PersonneVM>> getAll() {
        logger.info("PersonneController - getAll");

        List<PersonneVM> personnes = personneService.getAll();

        return ResponseEntity.ok(personnes);
    }
}
