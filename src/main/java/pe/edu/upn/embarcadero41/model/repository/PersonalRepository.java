package pe.edu.upn.embarcadero41.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.embarcadero41.model.entity.Personal;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer>{
	Optional<Personal> findByUsername(String username);
}
