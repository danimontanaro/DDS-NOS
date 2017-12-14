package Entity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name ="empresa")
public class Empresa implements Entidad{
	
	@Id
	@GeneratedValue
	private int id;
	private String nombre;
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="empresas")
//	private List<Cuenta> cuentas;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="empresa")
	private List<EmpresaCuenta> empresas ;
	
	@Transient
	private double valor;
	
	public Empresa(){
		super();
		this.empresas = new LinkedList<>();
	}
		
	public List<EmpresaCuenta> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<EmpresaCuenta> empresas) {
		this.empresas = empresas;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<EmpresaCuenta> getLista() {
		return empresas;
	}

	public void setLista(List<EmpresaCuenta> lista) {
		this.empresas = lista;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//	public List<Cuenta> getCuentas() 
//	{
//		return cuentas;
//	}
//	
//	public void addCuenta(Cuenta cuenta){
//		cuentas.add(cuenta);
//	}
//
//	public void setCuentas(List<Cuenta> cuenta) 
//	{
//		this.cuentas=cuenta;
//	}

public ArrayList<String> allNombresEmpresa(ArrayList<Empresa> listaDeEmpresas )
{	
	 ArrayList<String> nombres = new ArrayList<String>();
	 nombres.addAll(listaDeEmpresas.stream().map(empresa->empresa.getNombre()).collect(Collectors.toList()));
	 return nombres;
	 
}
//tengo que modificarlocon stream
public int findEmpresa(String nombre,ArrayList<Empresa> listaDeEmpresas)
{	
	for (int i = 0; i < listaDeEmpresas.size(); i++){
		if(listaDeEmpresas.get(i).getNombre().equals(nombre)){				
			return i;
		}
	}
	
	return 0;
}

//public Boolean pertenecePeriodo(String desde, String hasta,List<Cuenta> ctas)
//{
//    Boolean result = ctas.stream()   // Convierte la lista en un Stream
//	                .filter(unaCuenta -> this.periodoEs(desde,hasta,unaCuenta.getPeriodo())).count()>0;
//	return result;
//}

public Boolean periodoEs(String desde, String hasta,List<Periodo> ctas)
{
    Boolean result = ctas.stream()   // Convierte la lista en un Stream
	                .filter(unPeriodo -> unPeriodo.getDesde().equals(desde) && unPeriodo.getHasta().equals(hasta)).count()>0;
	return result;
}

//public ArrayList<Empresa> empresasQuePertenecen(List<Empresa> empresas,String desde,String hasta)
//{
//	  ArrayList<Empresa> result = (ArrayList<Empresa>) empresas.stream()   // Convierte la lista en un Stream
//	          .filter(empresa -> empresa.pertenecePeriodo(desde,hasta,empresa.getCuentas()))  //Filtro segun criterio de Periodo
//	          .collect(Collectors.toList());       // Convierte el Stream en lista de nuevo
//	  return result;
//}


}
