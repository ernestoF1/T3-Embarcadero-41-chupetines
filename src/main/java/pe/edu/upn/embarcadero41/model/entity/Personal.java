package pe.edu.upn.embarcadero41.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "personal")
public class Personal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "username", length = 30, nullable = false)
	private String username;

	@Column(name = "password", length = 60, nullable = false)
	private String password;

	private boolean enable;

	@Column(name = "nombre", length = 40, nullable = false)
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipousuario_id")
	private TipoPersonal tipopersonal;

	@OneToMany(mappedBy = "personal", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Authority> authorities;

	public Personal() {
		this.enable = true;
		this.authorities = new ArrayList<>();
	}

	public Personal(String username,String password) {
		this.username = username;
		this.password = password;
		this.enable = true;
		this.authorities = new ArrayList<>();
	}
	public void addAuthority(String _authority) {
		Authority authority = new Authority();
		authority.setAuthority(_authority);
		authority.setPersonal(this);
		this.authorities.add(authority);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoPersonal getTipopersonal() {
		return tipopersonal;
	}

	public void setTipopersonal(TipoPersonal tipopersonal) {
		this.tipopersonal = tipopersonal;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	

}
