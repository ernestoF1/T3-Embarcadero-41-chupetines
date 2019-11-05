package pe.edu.upn.embarcadero41.service;

import java.util.Optional;

import pe.edu.upn.embarcadero41.model.entity.Usuario;


public interface UsuarioService extends CrudService<Usuario, Long>{

	Optional<Usuario> findByUsername(String username) throws Exception;
}
