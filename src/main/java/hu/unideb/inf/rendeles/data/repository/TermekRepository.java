package hu.unideb.inf.rendeles.data.repository;

import hu.unideb.inf.rendeles.data.entity.TermekEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermekRepository extends JpaRepository<TermekEntity, Long> {
}
