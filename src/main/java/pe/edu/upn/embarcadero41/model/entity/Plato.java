package pe.edu.upn.embarcadero41.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "platos")
public class Plato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nomPlato", length = 60)
	private String nombre; 
	
	@OneToMany(mappedBy="plato")
	private List<Pedido>listapedido2;
	
	public Plato() {
		listapedido2=new ArrayList<>();
	}

	 public void addPedido2(Pedido pedido) {
		   pedido.setPlato(this);
		   this.listapedido2.add(pedido);
		}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pedido> getListapedido2() {
		return listapedido2;
	}

	public void setListapedido2(List<Pedido> listapedido2) {
		this.listapedido2 = listapedido2;
	}

 

}
