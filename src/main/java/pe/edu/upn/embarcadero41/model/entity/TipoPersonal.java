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
@Table(name="tipopersonal")
public class TipoPersonal {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "nombre",length = 25,nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy="tipopersonal",fetch = FetchType.LAZY)
	private List<Personal>listapersonal;
	
	public TipoPersonal() {
		listapersonal=new ArrayList<>();
	}
	public void addPersonal(Personal personal) {
		personal.setTipopersonal(this);
		this.listapersonal.add(personal);
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
	public List<Personal> getListapersonal() {
		return listapersonal;
	}
	public void setListapersonal(List<Personal> listapersonal) {
		this.listapersonal = listapersonal;
	}
	
	
	
}
