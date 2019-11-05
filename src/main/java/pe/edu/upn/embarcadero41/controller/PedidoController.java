package pe.edu.upn.embarcadero41.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.embarcadero41.model.entity.Pedido;
import pe.edu.upn.embarcadero41.model.entity.Plato;
import pe.edu.upn.embarcadero41.service.PedidoService;
import pe.edu.upn.embarcadero41.service.PlatoService;

@Controller
@RequestMapping("/pedido")
@SessionAttributes("pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private PlatoService platoService;
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") int id,Model model) {
		try {
			Optional<Pedido>optional=pedidoService.findById(id);
			if(optional.isPresent()) {
				List<Plato> platos=platoService.findAll();
				
				model.addAttribute("pedido", optional.get());
				model.addAttribute("platos",platos );
			}
			else {
				return "redirect:/";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/pedido/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("pedido")Pedido pedido, Model model,SessionStatus status) {
	     try {
			pedidoService.save(pedido);
			status.setComplete();
		} catch (Exception e) {
			// TODO: handle exception
		}
	     return "redirect:/";
	}
	
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id")int id, Model model) {
		try {
			Optional<Pedido>pedido=pedidoService.findById(id);
			if(pedido.isPresent()) {
				pedidoService.deleteById(id);
			}
		} catch (Exception e) {
			 model.addAttribute("dangerDel","ERROR");
			 try {
				List<Pedido>pedidos=pedidoService.findAll();
				model.addAttribute("pedidos", pedidos);
				/*model.addAttribute("ventas", ventas);*/
			} catch (Exception e2) {
				// TODO: handle exception
			}
			 return "/usuario";
		}
		return "redirect:/";
	}
}
