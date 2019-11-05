package pe.edu.upn.embarcadero41.service;

import java.util.Optional;

import pe.edu.upn.embarcadero41.model.entity.Cliente;

public interface ClienteService extends CrudService<Cliente, Integer>{
	Optional<Cliente> findByUsername(String username) throws Exception;
}
