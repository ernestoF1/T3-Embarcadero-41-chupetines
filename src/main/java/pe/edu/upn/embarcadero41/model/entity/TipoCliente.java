package pe.edu.upn.embarcadero41.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipoclientes")
public class TipoCliente {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "nombre",length = 25,nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy="tipocliente",fetch = FetchType.LAZY)
	private List<Cliente>listaclientes;
	
	public TipoCliente() {
		listaclientes=new ArrayList<>();
	}
	public void addCliente(Cliente cliente) {
		cliente.setTipocliente(this);
		this.listaclientes.add(cliente);
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
	public List<Cliente> getListaclientes() {
		return listaclientes;
	}
	public void setListaclientes(List<Cliente> listaclientes) {
		this.listaclientes = listaclientes;
	}
	
	
	
}
