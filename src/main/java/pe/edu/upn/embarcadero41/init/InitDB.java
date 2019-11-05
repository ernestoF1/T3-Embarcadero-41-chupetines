package pe.edu.upn.embarcadero41.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upn.embarcadero41.model.entity.Cliente;
import pe.edu.upn.embarcadero41.model.entity.Personal;
import pe.edu.upn.embarcadero41.model.entity.TipoCliente;
import pe.edu.upn.embarcadero41.model.entity.TipoPersonal;
import pe.edu.upn.embarcadero41.model.repository.AuthorityRepository;
import pe.edu.upn.embarcadero41.model.repository.ClienteRepository;
import pe.edu.upn.embarcadero41.model.repository.PersonalRepository;
import pe.edu.upn.embarcadero41.model.repository.TipoClienteRepository;
import pe.edu.upn.embarcadero41.model.repository.TipoPersonalRepository;

@Service
public class InitDB implements CommandLineRunner{

	
	@Autowired
	private PersonalRepository personalRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private AuthorityRepository authorityRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private TipoPersonalRepository tipoPersonalRepository;
	@Autowired
	private TipoClienteRepository tipoClienteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		this.personalRepository.deleteAll();
		this.authorityRepository.deleteAll();
		
		this.tipoPersonalRepository.deleteAll();
		
		TipoPersonal tipo1=new TipoPersonal();
		tipo1.setNombre("Gerente");
		
		
		
		TipoPersonal tipo2=new TipoPersonal();
		tipo2.setNombre("Camareros");
		
		List<TipoPersonal>tipos=Arrays.asList(tipo1,tipo2);
        this.tipoPersonalRepository.saveAll(tipos);
        
	
        Personal personal1=new Personal();
        personal1.setUsername("ernesto");
        personal1.setPassword(passwordEncoder.encode("ernesto"));
        personal1.setNombre("ernesto");
        personal1.setTipopersonal(tipo1);
        personal1.setEnable(true);
        
		
        Personal personal2=new Personal();
        personal2.setUsername("maria");
        personal2.setPassword(passwordEncoder.encode("maria"));
        personal2.setNombre("maria");
        personal2.setTipopersonal(tipo2);
        personal2.setEnable(true);
		
		personal2.addAuthority("ROLE_USER");
		personal1.addAuthority("ROLE_ADMIN");
		personal1.addAuthority("ACCESS_REST1");
        personal1.addAuthority("ACCESS_REST2");
        
        List<Personal>personals=Arrays.asList(personal1, personal2);
       this.personalRepository.saveAll(personals);  
        
		
		TipoCliente tipo3=new TipoCliente();
		tipo3.setNombre("Identificados");
		
		
		
		TipoCliente tipo4=new TipoCliente();
		tipo4.setNombre("Invitados");
		
		List<TipoCliente>tiposs=Arrays.asList(tipo3,tipo4);
        this.tipoClienteRepository.saveAll(tiposs);
        
	
        Cliente cliente1=new Cliente();
        cliente1.setUsername("cliente");
        cliente1.setPassword(passwordEncoder.encode("cliente"));
        cliente1.setNombre("steven");
        cliente1.setTipocliente(tipo3);
        cliente1.setEnable(true);
        
		cliente1.addAuthority("ACCESS_IDENTIFICADOS");
		
        
        List<Cliente>clientes=Arrays.asList(cliente1);
       this.clienteRepository.saveAll(clientes);  
       */
	}
}