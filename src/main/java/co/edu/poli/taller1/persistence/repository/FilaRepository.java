package co.edu.poli.taller1.persistence.repository;

import co.edu.poli.taller1.persistence.entity.Fila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilaRepository extends JpaRepository<Fila, Long> {
}
