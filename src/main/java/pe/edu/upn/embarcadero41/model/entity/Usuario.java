package pe.edu.upn.embarcadero41.model.entity;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name = "users")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username",length = 30, nullable = false)
    private String username;

    @Column(name = "password",length = 60, nullable = false)
    private String password;

    private boolean enable;
    
  
    @Column(name = "nombres",length = 40, nullable = false)
    private String nombres;
    
  
    /*
    @Column(name = "cargo",length = 30, nullable = false)
    private String cargo;
    */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tipousuario_id")
    private TipoUsuario tipousuario;
    
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)    
    private List<Authority> authorities;
    
    @OneToMany(mappedBy="usuario")
	private List<Pedido>listapedido;
    
    @OneToMany(mappedBy="usuario")
	private List<DetallePedido>listaDetallePedido;
	
    
    public Usuario() {
		this.enable = true;
		this.authorities = new ArrayList<>();
		listapedido=new ArrayList<>();
		listaDetallePedido=new ArrayList<>();
	}
    public Usuario( String username, String password ) {
		this.username = username;
		this.password = password;
		this.enable = true;
		this.authorities = new ArrayList<>();
	}
    
    public void addAuthority( String _authority ) {
		Authority authority = new Authority();
		authority.setAuthority( _authority );
		authority.setUsuario(this);
		this.authorities.add(authority);
	}
   
    public void addPedido(Pedido pedido) {
		   pedido.setUsuario(this);
		   this.listapedido.add(pedido);
		}
    public void addDetallePedido(DetallePedido detallePedido) {
    	detallePedido.setUsuario(this);
    	this.listaDetallePedido.add(detallePedido);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	

	
	public TipoUsuario getTipousuario() {
		return tipousuario;
	}
	public void setTipousuario(TipoUsuario tipousuario) {
		this.tipousuario = tipousuario;
	}
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	public List<Pedido> getListapedido() {
		return listapedido;
	}
	public void setListapedido(List<Pedido> listapedido) {
		this.listapedido = listapedido;
	}
	public List<DetallePedido> getListaDetallePedido() {
		return listaDetallePedido;
	}
	public void setListaDetallePedido(List<DetallePedido> listaDetallePedido) {
		this.listaDetallePedido = listaDetallePedido;
	}
	
	
    
    
}
