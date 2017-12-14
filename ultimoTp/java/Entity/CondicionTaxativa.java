package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import metodologiaFactory.*;

@Entity
@Table(name="CondicionTaxativa")
public class CondicionTaxativa implements Entidad {
	
	@Id
	@GeneratedValue
	private int id;
	private String indicadorOCuenta;
	private String expresion;
	private int valorAComparar;
	
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
	public int getValorAComparar() 
	{
		return valorAComparar;
	}
	public void setValorAComparar(int valorAComparar) 
	{
		this.valorAComparar = valorAComparar;
	}
	
	//Por ahora supongo que es una cuenta nomas
//	public int obtenerValorDelIndicadorOCuenta(String empresa, String desde, String hasta) 
//	{
//		int valor=0;
//		Cuenta cuenta = new Cuenta();
//		if(cuenta.perteneceALasCuentas(indicadorOCuenta, desde,hasta, empresa))
//		{
//			valor=cuenta.obtenerValor(indicadorOCuenta,desde,hasta,empresa);
//
//			System.out.println("El valor de la cuenta"+valor+ "eem" +indicadorOCuenta);
//		}
//		return valor;
//	}
	public boolean cumpleCondicion(String empresa, String desde, String hasta,int valorCuentaEmpresa) {
		return this.obtenerExpresion(this.getExpresion()).cumpleCondicion(valorCuentaEmpresa, this.valorAComparar);
	}
	public expresion obtenerExpresion(String expresion) 
	{
		ManejadorDeExpresiones manejador= new ManejadorDeExpresiones();
		manejador.setCreadorFactory(manejador.concatenarPackage(expresion));
		manejador.crearExpresion();
		System.out.println("Estoy en el metodo obetenerExpresion. CONDICIONTAX " + manejador.getExpresion());
		return manejador.getExpresion();
		
	}
}
