package pe.edu.upn.embarcadero41.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.embarcadero41.model.entity.Plato;


@Repository
public interface PlatoRepository extends JpaRepository<Plato, Integer>{

}
