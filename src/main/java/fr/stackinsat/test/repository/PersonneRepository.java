package fr.stackinsat.test.repository;

import fr.stackinsat.test.entity.Personne;
import fr.stackinsat.test.vm.PersonneVM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

    @Query("SELECT new fr.stackinsat.test.vm.PersonneVM(p) FROM Personne p ORDER BY p.nom ASC, p.prenom ASC")
    List<PersonneVM> getAll();
}
