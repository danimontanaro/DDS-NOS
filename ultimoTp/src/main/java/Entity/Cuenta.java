package Entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Transient;

import Modelo.DAOGlobalMYSQL;
import Modelo.DAOjson;
/*
 * @Author : Grupo 13
 */
import db.EntityManagerHelper;

@Entity
@Table(name = "cuenta")
public class Cuenta implements Entidad {
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	String nombre;
	
	@Transient
	private double valor;
	//private String valorCTA;
	//private ArrayList<Integer> valoresDeCuentas = new ArrayList<Integer>();
	//private ArrayList<String> cuentaLista;
	//String b[] = new String[9];
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="cuenta")
	private List<EmpresaCuenta> cuentas ;

//	@OneToMany(mappedBy="cuenta",cascade = CascadeType.ALL)
//	private List<Periodo> periodos;
	 
	public Cuenta(){
		super();
		this.cuentas=new LinkedList<>();
		//periodos = new LinkedList<>();
	}	

	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public List<EmpresaCuenta> getCuentas() {
		return cuentas;
	}


	public void setCuentas(List<EmpresaCuenta> cuentas) {
		this.cuentas = cuentas;
	}


	public int getId() {
		return id;
	}


	
	public boolean perteneceALasCuentas(String cuenta,String desde, String hasta, String empresa){
		ArrayList<String> ctas1 = null;
		ctas1 = getNombresCuentasPorPeriodoSQL(desde,hasta,empresa);
		//ArrayList<String> ctas = this.getNombresCuentasPorPeriodo(desde,hasta, empresa);
		//me devulve las cuentas que tiene esa empresa en ese periodo
		
		//esUnaCuenta = ctas2.contains(cuenta);
		return ctas1.contains(cuenta); // se fija si la cuenta que quiero , esta en esa lista de cuentas por empresa
	}

	
	public ArrayList<String> getNombresCuentasPorPeriodoSQL(String desde, String hasta, String empresa){	
		ArrayList<String> ctas1 = null;
		EntityManager ctas = EntityManagerHelper.entityManager();
		ArrayList<String> authors=
		(ArrayList<String>) ctas.createNativeQuery("Select C.nombre from cuenta C join empresa_cuenta EC on (C.id = EC.cuenta_id) join empresa E on (E.id = EC.empresa_id) join periodo P on (P.empresa_cuenta_id = EC.id ) where E.nombre='"+empresa+"' and P.desde='"+desde+"' and P.hasta='"+hasta+"'").getResultList();
		//(ArrayList<String>) ctas.createNativeQuery("Select C.nombre from cuenta C join empresa_cuenta EC on (C.id = EC.cuenta_id) join empresa E on (E.id = EC.empresa_id) join periodo P on (P.cuenta_empresa = EC.id ) where E.nombre='"+empresa+"' and P.desde='"+desde+"' and P.hasta='"+hasta+"'").getResultList();
				
				
		 
		//System.out.println((ArrayList<String>) ctas.createNativeQuery("Select C.nombre from cuenta C join empresa_cuenta EC on (C.id = EC.cuenta_id) join empresa E on (E.id = EC.empresa_id) join periodo P on (P.cuenta_empresa = EC.id ) where E.nombre='"+empresa+"' and P.desde='"+desde+"' and P.hasta='"+hasta+"'").getSingleResult());
		return authors;
		//return (ArrayList<String>) ctas.createNativeQuery("Select C.nombre from cuenta C join empresa_cuenta EC on (C.id = EC.cuenta_id) join empresa E on (E.id = EC.empresa_id) join periodo P on (P.cuenta_empresa = EC.id ) where E.nombre='"+empresa+"' and P.desde='"+desde+"' and P.hasta='"+hasta+"'").getSingleResult(); 
	}
	
	public int obtenerValorIndicado (String cuenta, String desde, String hasta, String empresa){
		if (perteneceALasCuentas(cuenta,desde,hasta,empresa))
			return obtenerValor(cuenta,desde,hasta,empresa);
		return 0;
	}
public int obtenerValor(String cuenta, String desde, String hasta, String empresa) 
{
	return buscarValorINmysql(cuenta, desde,hasta,empresa);
}

public String getStringDeFormulaConNrosDeCuenta(String stringDeFormula, String[] arrayDeSimbolos, Integer[] arrayDeValores){
	for (int i=0; i < arrayDeSimbolos.length ; i++) {
	    stringDeFormula = stringDeFormula.replace(arrayDeSimbolos[i],Integer.toString(arrayDeValores[i]));
	}
	return stringDeFormula;
}

public int buscarValorINmysql(String cuenta, String desde, String hasta, String empresa){
	
	/* buscar en mySql el valor de la cuenta en un periodo especifico 
		y de tal empresa
	*/
	EntityManager em = EntityManagerHelper.entityManager();
	return  (int) em.createNativeQuery("Select valor_cuenta from periodo p join empresa_cuenta ec on(ec.id=p.empresa_cuenta_id) join empresa e on(e.id=ec.empresa_id) join cuenta c on(c.id=ec.cuenta_id) where c.nombre='"+cuenta+"' and p.desde ='"+desde+"' and p.hasta ='"+hasta+"' and e.nombre ='"+empresa+"'").getSingleResult();
}
public ArrayList<String> cuentasDeLaFormula(String formula)
{
	
	int i=0;
	String word;
	StringTokenizer elementos,subelementos;
	ArrayList<String> palabra= new ArrayList<String>();
	elementos = new StringTokenizer(formula,"(+/*-)");
	while(elementos.hasMoreTokens()){
	  word = elementos.nextToken();
	  i=1;
	  subelementos = new StringTokenizer(word,",");
	  while(subelementos.hasMoreTokens()){
	    palabra.add( subelementos.nextToken());
	    
	    i++;
	  }
	}
	return palabra;
}


public ArrayList<Integer> getValorFormula(String formula,String desde, String hasta, String empresa){
	
	//int valor;
	//int[] valoresDeCuentasDeFormula = new int[100];
	String valorCTA;
	ArrayList<Integer> valoresDeCuentas = new ArrayList<Integer>();
	ArrayList<String> cuentaLista;
	
	
	cuentaLista= this.cuentasDeLaFormula(formula); //me parsea la formula ejemplo, "x+y" devuelve [x,y]
	 for(int x=0;x<cuentaLista.size();x++) {  // recorro [x,y] 
			valorCTA = cuentaLista.get(x); // devuelve valor = x
			int valor1 = this.obtenerValorIndicado(valorCTA, desde, hasta, empresa);  //devuelve el valor de x, ej: x=10
			//valoresDeCuentasDeFormula[x] = valor1;
			valoresDeCuentas.add(valor1); //lo agrego a la lista de valores
			}
	
	return valoresDeCuentas;

}



}