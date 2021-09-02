package fr.stackinsat.test;

import fr.stackinsat.test.entity.Personne;
import fr.stackinsat.test.service.PersonneService;
import fr.stackinsat.test.vm.PersonneVM;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class TestServiceTest {

    @Autowired
    private PersonneService personneService;

    @org.junit.jupiter.api.Test
    public void add() {
        Personne personne = new Personne();
        personne.setNom("Le borgne");
        personne.setPrenom("Cyril");
        personne.setDateNaissance(LocalDate.of(1988, 1, 11));
        Personne personneNew = personneService.get(1L);
        Assertions.assertThat(personneNew).isNotNull();
        Assertions.assertThat(personne.getId()).isGreaterThan(0);
        Assertions.assertThat(personne.getNom()).isEqualTo("Le borgne");
        Assertions.assertThat(personne.getPrenom()).isEqualTo("Cyril");
        Assertions.assertThat(personne.getDateNaissance()).isEqualTo(LocalDate.of(1988, 1, 11));
    }

    @org.junit.jupiter.api.Test
    public void addOld() {
        Personne personne = new Personne();
        personne.setNom("Le borgne");
        personne.setPrenom("Cyril");
        personne.setDateNaissance(LocalDate.of(1788, 1, 11));
        Personne personneNew = personneService.get(1L);
        Assertions.assertThat(personneNew).isNotNull();
    }

    @org.junit.jupiter.api.Test
    public void get() {
        Personne personne = personneService.get(1L);
        Assertions.assertThat(personne).isNotNull();
        Assertions.assertThat(personne.getId()).isGreaterThan(0);
    }

    @org.junit.jupiter.api.Test
    public void getAll() {
        List<PersonneVM> personnes = personneService.getAll();
        Assertions.assertThat(personnes).isNotNull();
    }
}
