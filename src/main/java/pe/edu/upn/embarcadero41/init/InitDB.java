package pe.edu.upn.embarcadero41.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upn.embarcadero41.model.entity.TipoUsuario;
import pe.edu.upn.embarcadero41.model.entity.Usuario;
import pe.edu.upn.embarcadero41.model.repository.AuthorityRepository;
import pe.edu.upn.embarcadero41.model.repository.TipoUsuarioRepository;
import pe.edu.upn.embarcadero41.model.repository.UsuarioRepository;

@Service
public class InitDB implements CommandLineRunner {

	
	@Autowired
	private AuthorityRepository authorityRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		/*

		this.usuarioRepository.deleteAll();
		this.authorityRepository.deleteAll();

		this.tipoUsuarioRepository.deleteAll();

		TipoUsuario tipo1 = new TipoUsuario();
		tipo1.setNombre("Gerente");

		TipoUsuario tipo2 = new TipoUsuario();
		tipo2.setNombre("Camarero");

		TipoUsuario tipo3 = new TipoUsuario();
		tipo3.setNombre("Identificado");

		TipoUsuario tipo4 = new TipoUsuario();
		tipo4.setNombre("Invitado");

		List<TipoUsuario> tipos = Arrays.asList(tipo1, tipo2, tipo3, tipo4);
		this.tipoUsuarioRepository.saveAll(tipos);

		Usuario camarero = new Usuario();
		camarero.setUsername("maria");
		camarero.setPassword(passwordEncoder.encode("maria"));
		camarero.setNombres("Maria Fernanda");
		camarero.setTipousuario(tipo2);
		camarero.setEnable(true);

		Usuario gerente = new Usuario();
		gerente.setUsername("ernesto");
		gerente.setPassword(passwordEncoder.encode("ernesto"));
		gerente.setNombres("Ernesto Fidel Alejandro");
		gerente.setTipousuario(tipo1);
		gerente.setEnable(true);

		Usuario identificado = new Usuario();
		identificado.setUsername("cliente");
		identificado.setPassword(passwordEncoder.encode("cliente"));
		identificado.setNombres("Raul Ramos");
		identificado.setTipousuario(tipo3);
		identificado.setEnable(true);
		
		Usuario invitado = new Usuario();
		invitado.setUsername("juan");
		invitado.setPassword(passwordEncoder.encode("juan"));
		invitado.setNombres("Juan Gomez");
		invitado.setTipousuario(tipo4);
		invitado.setEnable(true);

		camarero.addAuthority("ROLE_CAMARERO");
		gerente.addAuthority("ROLE_GERENTE");
		identificado.addAuthority("ROLE_IDENTIFICADO");
		invitado.addAuthority("ROLE_INVITADO");

		List<Usuario> usuarios = Arrays.asList(camarero, gerente,identificado,invitado);
		this.usuarioRepository.saveAll(usuarios);
*/
	}
}