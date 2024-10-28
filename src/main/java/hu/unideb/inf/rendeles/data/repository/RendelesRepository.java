package hu.unideb.inf.rendeles.data.repository;

import hu.unideb.inf.rendeles.data.entity.RendelesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendelesRepository extends JpaRepository<RendelesEntity, Long> {
}
