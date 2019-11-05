package pe.edu.upn.embarcadero41.config.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import pe.edu.upn.embarcadero41.model.entity.Cliente;
import pe.edu.upn.embarcadero41.model.entity.Personal;




// Implementación de una clase detail que manipula al usuario
public class ClienteDetails implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	// @Autowired
	private Cliente cliente;
	
	
	public ClienteDetails(Cliente cliente) {
		super();
		this.cliente=cliente;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		// Extraer la lista de las Authorities
		
		this.cliente.getAuthorities().forEach(authority -> {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
			grantedAuthorities.add(grantedAuthority);
		});

		return grantedAuthorities;
	}

	

	@Override
	public String getPassword() {
		return this.cliente.getPassword();
	}

	@Override
	public String getUsername() {
		return this.cliente.getUsername();
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	
	@Override
	public boolean isEnabled() {
		return this.cliente.isEnable();
	}
	
	// Datos de la Clase Usuario
	public String getNombre() {
		return this.cliente.getNombre();
	}
	
	public Integer getId() {
		return this.cliente.getId();
	}
	
	
	/*
	public String getCargo() {
		return this.usuario.getCargo();
	}
	*/

	/*
	public TipoUsuario getTipoUsuario() {
		
		
		return this.usuario.getTipousuario();
	}
*/
}
