package pe.edu.upn.embarcadero41.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.embarcadero41.model.entity.Cliente;
import pe.edu.upn.embarcadero41.model.entity.Personal;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	Optional<Cliente> findByUsername(String username);
}
