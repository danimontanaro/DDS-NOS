package Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Modelo.DAOGlobalMYSQL;
import db.EntityManagerHelper;
import metodologiaFactory.*;

@Entity
@Table(name="CondicionTaxativa")
public class CondicionTaxativa implements Entidad {
	
	@Id
	@GeneratedValue
	private int id;
	private String indicadorOCuenta;
	private String expresion;
	private double valorAComparar;
	
	@ManyToOne
	@JoinColumn(name="metodologia_id", nullable=false)
	private Metodologia metodologia;
	
	public CondicionTaxativa(){
		
	}
	
	public CondicionTaxativa(String indicadorOCuenta, String expresion, int valorAComparar) {
		super();
		this.indicadorOCuenta = indicadorOCuenta;
		this.expresion = expresion;
		this.valorAComparar = valorAComparar;
	}
	
	public Metodologia getMetodologia() {
		return metodologia;
	}
	public void setMetodologia(Metodologia metodologia) {
		this.metodologia = metodologia;
	}
	public int getId() {
		return id;
	}
	public String getIndicadorOCuenta()
	{
		return indicadorOCuenta;
	}
	public void setIndicadorOCuenta(String indicadorOCuenta) 
	{
		this.indicadorOCuenta = indicadorOCuenta;
	}
	public String getExpresion() 
	{
		return expresion;
	}
	public void setExpresion(String expresion) 
	{
		this.expresion = expresion;
	}
	public double getValorAComparar() 
	{
		return valorAComparar;
	}
	public void setValorAComparar(double valorAComparar) 
	{
		this.valorAComparar = valorAComparar;
	}
	
	public double obtenerValorDeCuentaOIndicador(String empresa,String desde,String hasta){
		if(esCuenta())
			return this.buscarValorCuenta(desde, hasta, empresa);
		else{
			Indicador ind = new Indicador();
			String formula = ind.getFormulaDeIndicador(indicadorOCuenta);
			return this.obtenerValorDeFormula(empresa, desde, hasta, formula);
		}
	}
	
	public boolean esCuenta(){
		DAOGlobalMYSQL<Cuenta> dao = new DAOGlobalMYSQL<Cuenta>(Cuenta.class);
		List<Cuenta> lista = dao.getAll();
		if(lista.stream().anyMatch((Cuenta c)-> c.getNombre().equals(this.indicadorOCuenta)))
			return true;
		else {
			System.out.println("ES INDICADORRRRR");
			return false;
		}
	}
	public boolean cumpleCondicion(String empresa, String desde, String hasta, double valor) {
		return this.obtenerExpresion(this.getExpresion()).cumpleCondicion(valor, this.valorAComparar);
	}
	
	public expresion obtenerExpresion(String expresion) {
		ManejadorDeExpresiones manejador= new ManejadorDeExpresiones();
		manejador.setCreadorFactory(manejador.concatenarPackage(expresion));
		manejador.crearExpresion();
		return manejador.getExpresion();		
	}
	
	public int buscarValorCuenta(String desde, String hasta, String empresa){
		EntityManager em = EntityManagerHelper.entityManager();
		return (int) em.createNativeQuery("Select p.valor_cuenta "
				+ "from inversiones.periodo p "
				+ "join inversiones.empresa_cuenta ce on(ce.id=p.empresa_cuenta_id) "
				+ "join inversiones.empresa e on(e.id=ce.empresa_id) join inversiones.cuenta c "
				+ "on(c.id=ce.cuenta_id) where c.nombre='"+indicadorOCuenta+"' and p.desde ='"+desde+"' "
						+ "and p.hasta ='"+hasta+"' and e.nombre ='"+empresa+"'").getSingleResult();
	}
	
	public double obtenerValorDeFormula(String empresa,String desde,String hasta,String formula){
		Indicador ind = new Indicador();
		return ind.metodoCoolConFormula(desde, hasta, empresa, formula);
	}
}
