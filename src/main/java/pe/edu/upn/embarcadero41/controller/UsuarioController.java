package pe.edu.upn.embarcadero41.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.embarcadero41.model.entity.DetallePedido;
import pe.edu.upn.embarcadero41.model.entity.Pedido;
import pe.edu.upn.embarcadero41.model.entity.Plato;
import pe.edu.upn.embarcadero41.model.entity.TipoUsuario;
import pe.edu.upn.embarcadero41.model.entity.Usuario;
import pe.edu.upn.embarcadero41.service.DetallePedidoService;
import pe.edu.upn.embarcadero41.service.PedidoService;
import pe.edu.upn.embarcadero41.service.PlatoService;
import pe.edu.upn.embarcadero41.service.TipoUsuarioService;
import pe.edu.upn.embarcadero41.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
@SessionAttributes({"usuario","pedido"})
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	 private PasswordEncoder passwordEncoder;
	
	@Autowired
	private TipoUsuarioService tipoUsuarioService;
	
	@Autowired
	private PlatoService platoService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private DetallePedidoService detallePedidoService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Usuario>usuarios=usuarioService.findAll();
			
			model.addAttribute("usuarios", usuarios);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/usuario/lista";
	}
	
	@GetMapping("/del/{id}")
	public String eliminarUsuario(@PathVariable("id")long id, Model model) {
		try {
			Optional<Usuario>usuario=usuarioService.findById(id);
			if(usuario.isPresent()) {
				usuarioService.deleteById(id);
			}
		} catch (Exception e) {
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			 try {
				List<Usuario>usuarios=usuarioService.findAll();
				model.addAttribute("usuarios",usuarios);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			 return "/usuario/lista";
		}
		return "redirect:/";
	}
	
	@GetMapping("/listacliente")
	public String listaCliente(Model model) {
		try {
			List<Usuario>usuarios=usuarioService.findAll();
			
			model.addAttribute("usuarios", usuarios);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/usuario/listacliente";
	}
	@GetMapping("/nuevoclienteInvitado")
	public String registerClienteInvitado(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario", usuario);
		
		try {
			
			List<TipoUsuario>tipoUsuarios=tipoUsuarioService.findAll();
			model.addAttribute("tipoUsuarios", tipoUsuarios);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "/usuario/nuevoclienteinvitado";
	}
	@PostMapping("/saveclienteInvitado")
	public String saveClienteInvitado(@ModelAttribute("usuario") Usuario usuario, Model model, SessionStatus status) {
		try {
			Optional<Usuario>optional=usuarioService.findByUsername(usuario.getUsername());
			if(optional.isPresent()) {
				model.addAttribute("dangerNuevo", "Error en el username "+usuario.getUsername()+" </strong> ya existe");
				return "/usuario/nuevoclienteInvi";
			}
			else {
				usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
				usuario.addAuthority("ROLE_INVITADO");
				usuarioService.save(usuario);
				status.setComplete();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/login";
		
	}
	
	@GetMapping("/nuevoclienteIdentificado")
	public String registerClienteIdentificado(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario", usuario);
		
		try {
			
			List<TipoUsuario>tipoUsuarios=tipoUsuarioService.findAll();
			model.addAttribute("tipoUsuarios", tipoUsuarios);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "/usuario/nuevoclienteidentificado";
	}
	@PostMapping("/saveclienteIdentificado")
	public String saveClienteIdentificado(@ModelAttribute("usuario") Usuario usuario, Model model, SessionStatus status) {
		try {
			Optional<Usuario>optional=usuarioService.findByUsername(usuario.getUsername());
			if(optional.isPresent()) {
				model.addAttribute("dangerNuevo", "Error en el username "+usuario.getUsername()+" </strong> ya existe");
				return "/usuario/nuevoclienteIden";
			}
			else {
				usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
				usuario.addAuthority("ROLE_IDENTIFICADO");
				usuarioService.save(usuario);
				status.setComplete();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/login";
		
	}
	
	@GetMapping("/nuevogerente")
	public String registerGerente(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario", usuario);
		
		try {
			
			List<TipoUsuario>tipoUsuarios=tipoUsuarioService.findAll();
			model.addAttribute("tipoUsuarios", tipoUsuarios);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "/usuario/nuevogerente";
	}
	@PostMapping("/savegerente")
	public String saveGerente(@ModelAttribute("usuario") Usuario usuario, Model model, SessionStatus status) {
		try {
			Optional<Usuario>optional=usuarioService.findByUsername(usuario.getUsername());
			if(optional.isPresent()) {
				model.addAttribute("dangerNuevo", "Error en el username "+usuario.getUsername()+" </strong> ya existe");
				return "/usuario/nuevogerente";
			}
			else {
				usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
				usuario.addAuthority("ROLE_GERENTE");
				usuarioService.save(usuario);
				status.setComplete();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/login";
		
	}
	
	@GetMapping("/nuevocamarero")
	public String registerCamarero(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario", usuario);
		
		try {
			
			List<TipoUsuario>tipoUsuarios=tipoUsuarioService.findAll();
			model.addAttribute("tipoUsuarios", tipoUsuarios);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "/usuario/nuevocamarero";
	}
	@PostMapping("/savecamarero")
	public String saveCamarero(@ModelAttribute("usuario") Usuario usuario, Model model, SessionStatus status) {
		try {
			Optional<Usuario>optional=usuarioService.findByUsername(usuario.getUsername());
			if(optional.isPresent()) {
				model.addAttribute("dangerNuevo", "Error en el username "+usuario.getUsername()+" </strong> ya existe");
				return "/usuario/register";
			}
			else {
				usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
				usuario.addAuthority("ROLE_CAMARERO");
				usuarioService.save(usuario);
				status.setComplete();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/login";
		
	}
	
	@GetMapping("/nuevo")
	public String register(Model model) {
		Usuario usuario=new Usuario();
		model.addAttribute("usuario", usuario);
		
		try {
			
			List<TipoUsuario>tipoUsuarios=tipoUsuarioService.findAll();
			model.addAttribute("tipoUsuarios", tipoUsuarios);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "/usuario/nuevo";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("usuario") Usuario usuario, Model model, SessionStatus status) {
		try {
			Optional<Usuario>optional=usuarioService.findByUsername(usuario.getUsername());
			if(optional.isPresent()) {
				model.addAttribute("dangerNuevo", "Error en el username "+usuario.getUsername()+" </strong> ya existe");
				return "/usuario/register";
			}
			else {
				usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
				usuario.addAuthority("ROLE_CLIENTE");
				usuarioService.save(usuario);
				status.setComplete();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/login";
		
	}
	
	@GetMapping("/{id}/nuevopedido")
	public String nuevoPedido(@PathVariable("id") long id,Model model) {
		Pedido pedido=new Pedido();
		try {
			Optional<Usuario> usuario= usuarioService.findById(id);
			if(usuario.isPresent()) {
				List<Plato>platos=platoService.findAll();
			    pedido.setUsuario(usuario.get());
			    model.addAttribute("pedido", pedido);
			    model.addAttribute("platos", platos);
				
				
			} else {
				return "redirect:/";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/usuario/nuevopedido";
	}
	
	
	
	
	@PostMapping("/savepedido")
	public String savePedidos(@ModelAttribute("pedido") Pedido pedido, 
			Model model, SessionStatus status) {
		
		try {
			pedidoService.save(pedido);
			
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/pedido/{id}")
	public String pedido(@PathVariable("id") long id, Model model) {
		
		
		try {
			
			Optional<Usuario>optional=usuarioService.findById(id);
			if(optional.isPresent()) {
				List<Pedido>pedido=pedidoService.findAll();
				
				for (Pedido v:pedido)
					if(v.getUsuario().equals(optional.get()))
						model.addAttribute("pedido", v);
					
				model.addAttribute("usuario", optional.get());
				
				
			} else {
				return "redirect:/";
			}
		} catch (Exception e) {

		}	
		
		return "/usuario/pedido";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable("id")long id,Model model,SessionStatus status) {
		
		DetallePedido detallepedido=new DetallePedido();
		try {
			Optional<Usuario>usuario=usuarioService.findById(id);
		
			if(usuario.isPresent()) {
				
				List<Pedido>pedido=pedidoService.findAll();
				for (Pedido v:pedido) 
					if(v.getUsuario().equals(usuario.get())) 
					
						detallepedido.setUsuario(usuario.get());
						detallepedido.setNombre(usuario.get().getNombres());
						
				        
						model.addAttribute("detallepedido", detallepedido);
						detallePedidoService.save(detallepedido);
						status.setComplete();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "redirect:/";
	}
	@GetMapping("/informacion/{username}")
	public String pedidoRealizados(@PathVariable("username")String username, Model model) {
		try {
			Optional<Usuario>usuario=usuarioService.findByUsername(username);
			if(usuario.isPresent()) {
				model.addAttribute("usuario", usuario.get());
				
			}
		} catch (Exception e) {
			
		}
		return "/usuario/informacionpedido";
	}
	
	@GetMapping("/detalleMostrarPedido/{id}")
	public String DetalleMostrarMiPedido(@PathVariable("id") long id, Model model) {
		
		
		
		try {
			
			Optional<Usuario>optional=usuarioService.findById(id);
			if(optional.isPresent()) {
				List<DetallePedido>detallepedido=detallePedidoService.findAll();
				
				for(DetallePedido d:detallepedido)
				if(d.getUsuario().equals(optional.get()))
					model.addAttribute("detallpedido", detallepedido);
				model.addAttribute("usuario", optional.get());
					
				
				
			} else {
				return "redirect:/";
			}
		} catch (Exception e) {

		}	
		
		return "/usuario/mostrarmipedido";
	}
	
}
