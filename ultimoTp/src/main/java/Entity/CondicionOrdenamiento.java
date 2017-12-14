package Entity;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import Comparator.Comparador;
import Modelo.DAOGlobalMYSQL;
import db.EntityManagerHelper;

@Entity
@Table(name = "CondicionOrdenamiento")
public class CondicionOrdenamiento {
	
	@Transient
	private List<Empresa> listaEmpresasSeleccionadas;
	
	@Id@GeneratedValue
	private int id;
	private Comparador comparador;
	private String indicadorCuenta;
	
	@ManyToOne
	@JoinColumn(name="metodologia_id", nullable=false)
	private Metodologia metodologia;
	
	//private List<CondicionTaxativa> listaCondiciones;
		
	public CondicionOrdenamiento(){
		
	}
	
	public CondicionOrdenamiento( List<Empresa> lista, Comparador comparador,String indicadorOCuenta) {
		super();	
		this.listaEmpresasSeleccionadas = lista;
		this.comparador = comparador;
		this.indicadorCuenta = indicadorOCuenta;
	}	
	
	public List<Empresa> getListaEmpresasSeleccionadas() {
		return listaEmpresasSeleccionadas;
	}

	public void setListaEmpresasSeleccionadas(List<Empresa> listaEmpresasSeleccionadas) {
		this.listaEmpresasSeleccionadas = listaEmpresasSeleccionadas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Comparador getComparador() {
		return comparador;
	}

	public void setComparador(Comparador comparador) {
		this.comparador = comparador;
	}

	public String getIndicadorCuenta() {
		return indicadorCuenta;
	}

	public void setIndicadorCuenta(String indicadorCuenta) {
		this.indicadorCuenta = indicadorCuenta;
	}

	public Metodologia getMetodologia() {
		return metodologia;
	}

	public void setMetodologia(Metodologia metodologia) {
		this.metodologia = metodologia;
	}

	public List<Empresa> getListaEmpresas() {
		return this.listaEmpresasSeleccionadas;
	}
	
	public void setListaEmpresas(List<Empresa> lista) {
		this.listaEmpresasSeleccionadas = lista;
	}
	
	public void darValorAEmpresas(String desde, String hasta){
		listaEmpresasSeleccionadas.stream().forEach((Empresa e)-> e.setValor(this.obtenerValorDeCuentaOIndicador(e.getNombre(), desde, hasta)));
	}
	
	public  List<Empresa> ordenar(){
		this.listaEmpresasSeleccionadas.sort((Empresa e, Empresa a)-> compararEmpresas(e,a,comparador));
		return null;
	}
	 
	public int compararEmpresas(Empresa empresa, Empresa otraEmpresa,Comparador comparador){
		if(comparador.comparar(empresa.getValor(), otraEmpresa.getValor()))
			return 1;
		else
			return -1;
	}
	
	public double obtenerValorDeCuentaOIndicador(String empresa,String desde,String hasta){
		if(esCuenta())
			return this.buscarValorCuenta(desde, hasta, empresa);
		else{
			Indicador ind = new Indicador();
			String formula = ind.getFormulaDeIndicador(this.indicadorCuenta);
			return this.obtenerValorDeFormula(empresa, desde, hasta, formula);
		}
	}
	
	public boolean esCuenta(){
		DAOGlobalMYSQL<Cuenta> dao = new DAOGlobalMYSQL<Cuenta>(Cuenta.class);
		List<Cuenta> lista = dao.getAll();
		if(lista.stream().anyMatch((Cuenta c)-> c.getNombre().equals(this.indicadorCuenta)))
			return true;
		else {
			System.out.println("ES INDICADORRRRR");
			return false;
		}
	}
	
	public double obtenerValorDeFormula(String empresa,String desde,String hasta,String formula){
		Indicador ind = new Indicador();
		return ind.metodoCoolConFormula(desde, hasta, empresa, formula);
	}
	
	public int buscarValorCuenta(String desde, String hasta, String empresa){
		EntityManager em = EntityManagerHelper.entityManager();
		return (int) em.createNativeQuery("Select p.valor_cuenta "
				+ "from inversiones.periodo p "
				+ "join inversiones.empresa_cuenta ce on(ce.id=p.empresa_cuenta_id) "
				+ "join inversiones.empresa e on(e.id=ce.empresa_id) join inversiones.cuenta c "
				+ "on(c.id=ce.cuenta_id) where c.nombre='"+indicadorCuenta+"' and p.desde ='"+desde+"' "
						+ "and p.hasta ='"+hasta+"' and e.nombre ='"+empresa+"'").getSingleResult();
	}
	
	public double obtenerValorCuenta(String nombre){
		double valor=0;
		DAOGlobalMYSQL<EmpresaCuenta> dao = new DAOGlobalMYSQL<EmpresaCuenta>(EmpresaCuenta.class);
		List<EmpresaCuenta> lista = dao.getAll();
		
		for(EmpresaCuenta ec: lista){
			if(ec.getEmpresa().getNombre().equals(nombre)&&ec.getCuenta().getNombre().equals(this.indicadorCuenta)){
				valor = ec.getPeriodo().get(0).getValorCuenta();
			}
			else
				valor= 0;
		}
		return valor;
	}
	
	public int darPeso(Empresa empresa){
		int peso = 0;		
		
//		for(CondicionTaxativa condicion: listaCondiciones){
//			for(Cuenta cuenta: empresa.getCuentas()){
//				for(Periodo per:cuenta.getPeriodo()){
//					if(condicion.cumpleCondicion(empresa.getNombre(), per.getDesde(), per.getHasta())){
//						peso+=20;
//						System.out.println("true "+ peso);
//					}
//					else
//						System.out.println("no cumple con condicion " + peso);
//				}
//			}
//		}
					
		return peso;
	
	}	

}

