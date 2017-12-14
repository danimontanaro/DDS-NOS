package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;
import Modelo.DAOmetodologiaJson;
import db.EntityManagerHelper;

@Entity
@Table(name = "Metodologia")
public class Metodologia implements Entidad{
	
	@Id	@GeneratedValue
	private int id;
	private String nombre;
	private boolean creadoPorUsuario;
	
	@OneToMany(mappedBy = "metodologia",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CondicionTaxativa> condiciones;
	
	@OneToMany(mappedBy = "metodologia",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CondicionOrdenamiento> condicionesOrdenamiento;
	
	@ManyToOne
	@JoinColumn(name="usuario_id", nullable=false)
	private Usuario usuario;
	
	//constructor agregue para alta
	 public Metodologia(String nombre,List<CondicionTaxativa> condiciones,List<CondicionOrdenamiento> lista) {
		super();
		this.nombre = nombre;
		this.condiciones = condiciones;
		this.condicionesOrdenamiento =lista;
	}
	
	 //Agrego por que me tira errores..
	public Metodologia(){
		 
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCreadoPorUsuario() {
		return creadoPorUsuario;
	}

	public void setCreadoPorUsuario(boolean creadoPorUsuario) {
		this.creadoPorUsuario = creadoPorUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
			return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<CondicionTaxativa> getCondiciones()  {
		return condiciones;
	}
	
	public void setCondiciones(List<CondicionTaxativa> condiciones) {
		this.condiciones = condiciones;
	}
	
	public boolean cumpleCondiciones(String empresa,String desde, String hasta) {
		return condiciones.stream().allMatch(c -> c.cumpleCondicion(empresa, desde, hasta,c.obtenerValorDeCuentaOIndicador(empresa, desde, hasta)));

	}
	
	
//	public boolean cumpleCondiciones(String empresa,String desde, String hasta) {
//			return condiciones.stream().allMatch(c -> c.cumpleCondicion(empresa, desde, hasta));
//	}
//		public List<CondicionTaxativa> condicionesQueCumplen(String desde, String hasta,String empresa)
//		{
//			DAOmetodologiaJson dao= new DAOmetodologiaJson();
//			ArrayList<Metodologia> metodologias=dao.getAll();
//			Cuenta cuenta= new Cuenta();
//			List<CondicionTaxativa> condiciones=metodologias.get(0).getCondiciones();
//			List<CondicionTaxativa> condiciones2 = new ArrayList<CondicionTaxativa>();
//			//System.out.println(condiciones.get(1).indicadorOCuenta);
//			condiciones2=(ArrayList<CondicionTaxativa>) condiciones.stream().filter(condicion->cuenta.getNombresCuentasPorPeriodo(desde, hasta, empresa).equals(condicion.getIndicadorOCuenta())).collect(Collectors.toList());
//		
//			return condiciones2;
//		}
		
		public List<CondicionOrdenamiento> getCondicionesOrdenamiento() {
		return condicionesOrdenamiento;
	}

	public void setCondicionesOrdenamiento(List<CondicionOrdenamiento> condicionesOrdenamiento) {
		this.condicionesOrdenamiento = condicionesOrdenamiento;
	}

	public int buscarValorINmysql(String cuenta, String desde, String hasta, String empresa){
		EntityManager em = EntityManagerHelper.entityManager();
		return (int) em.createNativeQuery("Select valorCuenta "
		+ "from tp.periodo p join tp.empresa_cuenta ce on(ce.id=p.empresa_cuenta_id) "
		+ "join tp.empresa e on(e.id=ce.empresa_id) join tp.cuenta c "
		+ "on(c.id=ce.cuenta_id) where c.nombre='"+cuenta+"' and p.desde ='"+desde+"' "
		+ "and p.hasta ='"+hasta+"' and e.nombre ='"+empresa+"'").getSingleResult();

	}
		
}
