package pe.edu.upn.embarcadero41.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import pe.edu.upn.embarcadero41.model.entity.Cliente;
import pe.edu.upn.embarcadero41.model.entity.Pedido;
import pe.edu.upn.embarcadero41.model.entity.Personal;
import pe.edu.upn.embarcadero41.model.entity.Plato;
import pe.edu.upn.embarcadero41.model.entity.TipoCliente;
import pe.edu.upn.embarcadero41.model.entity.TipoPersonal;
import pe.edu.upn.embarcadero41.service.ClienteService;
import pe.edu.upn.embarcadero41.service.PedidoService;
import pe.edu.upn.embarcadero41.service.PersonalService;
import pe.edu.upn.embarcadero41.service.PlatoService;
import pe.edu.upn.embarcadero41.service.TipoClienteService;
import pe.edu.upn.embarcadero41.service.TipoPersonalService;

@Controller
@RequestMapping("/cliente")
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private TipoClienteService tipoClienteService;
	@Autowired
	 private PasswordEncoder passwordEncoder;
	
	@Autowired
	private PlatoService platoService;
	
	@Autowired
	private PedidoService pedidoService;
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Cliente>clientes=clienteService.findAll();
			
			model.addAttribute("clientes", clientes);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cliente/lista";
	}
	@GetMapping("/nuevo")
	public String register(Model model) {
		Cliente cliente=new Cliente();
		model.addAttribute("cliente", cliente);
		
		try {
			List<TipoCliente>tipoClientes=tipoClienteService.findAll();
			model.addAttribute("tipoClientes", tipoClientes);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "/Cliente/nuevo";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("cliente") Cliente cliente, Model model, SessionStatus status) {
		try {
			
			Optional<Cliente>optional=clienteService.findByUsername(cliente.getUsername());
			if(optional.isPresent()) {
				model.addAttribute("dangerNuevo", "Error en el username "+cliente.getUsername()+" </strong> ya existe");
				return "/cliente/register";
			}
			else {
				cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
				
				cliente.addAuthority("ROLE_CLIENTE");
				clienteService.save(cliente);
				status.setComplete();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/login";
		
	}
	
	@GetMapping("/{id}/nuevopedido")
	public String nuevoPedido(@PathVariable("id") int id,Model model) {
		Pedido pedido=new Pedido();
		try {
			Optional<Cliente> cliente= clienteService.findById(id);
			if(cliente.isPresent()) {
				List<Plato>platos=platoService.findAll();
			    pedido.setCliente(cliente.get());
			    model.addAttribute("pedido", pedido);
			    model.addAttribute("platos", platos);
				
				
			} else {
				return "redirect:/";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/cliente/nuevopedido";
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
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		
		
		try {
			
			Optional<Cliente>optional=clienteService.findById(id);
			if(optional.isPresent()) {
				List<Pedido>pedidos=pedidoService.findAll();
				
				for (Pedido v:pedidos)
					if(v.getCliente().equals(optional.get()))
					
					;
				
				model.addAttribute("cliente", optional.get());
				
			} else {
				return "redirect:/";
			}
		} catch (Exception e) {

		}	
		
		return "/cliente/info";
	}
}
