package pe.edu.upn.embarcadero41.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.edu.upn.embarcadero41.model.entity.Cliente;
import pe.edu.upn.embarcadero41.model.entity.Personal;
import pe.edu.upn.embarcadero41.model.repository.ClienteRepository;
import pe.edu.upn.embarcadero41.model.repository.PersonalRepository;



@Service
public class ClienteDetailsService implements UserDetailsService{

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Retornando el usuario 
		Optional<Cliente> buscado = this.clienteRepository.findByUsername(username);
		
		if(buscado.isPresent()) {
			ClienteDetails clienteDetails = new ClienteDetails(buscado.get());
			return clienteDetails;
		}
		throw new UsernameNotFoundException("Invalid User");
	}
}
