package hu.unideb.inf.rendeles.data.repository;

import hu.unideb.inf.rendeles.data.entity.TermekEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TermekRepository extends JpaRepository<TermekEntity, Long> {

    //select * from Termek where nev = ?nev
    List<TermekEntity> findAllByNev(String nev);
}
