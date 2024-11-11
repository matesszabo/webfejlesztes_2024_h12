package hu.unideb.inf.rendeles.data.repository;

import hu.unideb.inf.rendeles.data.entity.FelhasznaloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FelhasznaloRepository extends JpaRepository<FelhasznaloEntity, Long> {
    //select * from felhasznalo where email = ?email
    FelhasznaloEntity findByEmail(String email);
}
