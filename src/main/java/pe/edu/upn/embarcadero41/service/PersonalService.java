package pe.edu.upn.embarcadero41.service;

import java.util.Optional;

import pe.edu.upn.embarcadero41.model.entity.Personal;


public interface PersonalService extends CrudService<Personal, Integer>{

	Optional<Personal> findByUsername(String username) throws Exception;
}
