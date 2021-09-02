package fr.stackinsat.test.service;

import fr.stackinsat.test.entity.Personne;
import fr.stackinsat.test.repository.PersonneRepository;
import fr.stackinsat.test.vm.PersonneVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonneService {

    private static final Logger logger = LoggerFactory.getLogger(PersonneService.class);

    @Autowired
    private PersonneRepository personneRepository;

    public List<PersonneVM> getAll() {
        List<PersonneVM> personnes = personneRepository.getAll();
        logger.info("PersonneService - getAll {}", personnes);
        return personnes;
    }

    public Personne get(Long id) {
        Personne personne = personneRepository.getById(id);
        logger.info("PersonneService - get {} {}", id, personne);
        return personne;
    }

    public Personne add(Personne personne) {
        int age = personne.calcAge();
        if (age > 150) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Trop vieux !");
        }
        personne = personneRepository.save(personne);
        logger.info("PersonneService - add {}", personne);
        return personne;
    }
}
