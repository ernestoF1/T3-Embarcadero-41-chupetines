package pe.edu.upn.embarcadero41.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.edu.upn.embarcadero41.model.entity.Personal;
import pe.edu.upn.embarcadero41.model.repository.PersonalRepository;



@Service
public class PersonalDetailsService implements UserDetailsService{

	
	@Autowired
	private PersonalRepository personalRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Retornando el usuario 
		Optional<Personal> buscado = this.personalRepository.findByUsername(username);
		
		if(buscado.isPresent()) {
			PersonalDetails personalDetails = new PersonalDetails(buscado.get());
			return personalDetails;
		}
		throw new UsernameNotFoundException("Invalid User");
	}
}
