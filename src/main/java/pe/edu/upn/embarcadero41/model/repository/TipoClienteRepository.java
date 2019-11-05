package pe.edu.upn.embarcadero41.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.embarcadero41.model.entity.Personal;
import pe.edu.upn.embarcadero41.model.entity.TipoCliente;

@Repository
public interface TipoClienteRepository extends JpaRepository<TipoCliente, Integer>{


}
