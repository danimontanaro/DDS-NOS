import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import Entity.CondicionOrdenamiento;
import Entity.CondicionTaxativa;
import Entity.Cuenta;
import Entity.Empresa;
import Entity.Indicador;
import Entity.Metodologia;
import Entity.Usuario;
import Modelo.DAOGlobalMYSQL;
import db.EntityManagerHelper;
import spark.ModelAndView;
import Comparator.Comparador;

public class Program {

	public static void main(String[] args) {
//		Indicador ind = new Indicador();
//		String nombre = "Liquidez Corriente";
//		System.out.println("vfdvdf "+ind.getFormulaDeIndicador(nombre));
//		String nombr = "Super Liquida";
//		DAOGlobalMYSQL<Metodologia> metodologia = new DAOGlobalMYSQL<Metodologia>(Metodologia.class);
//		Metodologia m = metodologia.findEntidadWithNombre(nombr);
//		System.out.println("  " + m.getNombre());
//		List<String> empresasSeleccionadas= new ArrayList<>();
//		empresasSeleccionadas.add("Cloud");empresasSeleccionadas.add("Ford");empresasSeleccionadas.add("Google"); 
//		DAOGlobalMYSQL<Empresa> dao = new DAOGlobalMYSQL<Empresa>(Empresa.class);
//		List<Empresa> lista = dao.getAllEmp();
//		
//		//**Agregar empresas mediante stringsss****
//		List<Empresa> empresas = new ArrayList<>();
//		
//		for(Empresa e : lista){
//			Empresa a = new Empresa();
//			if(empresasSeleccionadas.stream().anyMatch((String nombre)-> nombre.equals(e.getNombre()))){
//				empresas.add(e);
//			}
//		}
//		
//		//CondicionOrdenamiento condicion = new CondicionOrdenamiento(empresas,Comparador.MENORAMAYOR,"Liquidez Corriente");
//		CondicionOrdenamiento condicion = findCondicion("Paula","prueba");
//		condicion.setListaEmpresas(empresas);
//		condicion.darValorAEmpresas("2016","2016");
//		
//		for(Empresa e: empresas){
//			System.out.println("Nopmbre "+ e.getNombre()+" vaslor "+ e.getValor());
//		}
//		
//		condicion.ordenar();
//		System.out.println("Ordenado");
//		
//		for(Empresa e: empresas){			
//			System.out.println("Nopmbre "+ e.getNombre()+" vaslor "+ e.getValor());
//		}
//		
		//****AGREGAR USUARIO CON CONDICIONORDENIAMIENTO
//		DAOGlobalMYSQL dao = new DAOGlobalMYSQL();
//		Usuario usuario =  dao.findPorId(2);
//		Metodologia metodologia = new Metodologia();
//		metodologia.setNombre("pruuueba");
//		metodologia.setUsuario(usuario);
//		CondicionOrdenamiento condicion = new CondicionOrdenamiento(null,Comparador.MAYORAMENOR,"Liquiedezz");
//		List<CondicionOrdenamiento> lista = new ArrayList<>();
//		lista.add(condicion);
//		condicion.setMetodologia(metodologia);
//		metodologia.setCondicionesOrdenamiento(lista);
//		EntityManager entityManager= EntityManagerHelper.getEntityManager();
//		EntityManagerHelper.beginTransaction();
//		try
//		{
//			entityManager.persist(metodologia);
//			entityManager.flush();
//			EntityManagerHelper.commit();	
//		}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//			EntityManagerHelper.rollback();
//		}
		
//		DAOGlobalMYSQL<Metodologia> dao = new DAOGlobalMYSQL<Metodologia>(Metodologia.class);
//		List<Metodologia> lista = dao.getAll().stream().filter(m -> m.getUsuario().getNombre().equals("Paula")).collect(Collectors.toList());
//		//System.out.println("TAMAÑOOO "+ lista.get(2).getNombre());
//		CondicionOrdenamiento cond = findCondicion("Paula","prueba");
//		System.out.println("dddd "+ cond.getIndicadorCuenta());
		
//		//***** VER SI EXISTE CUENTA
//		String empresa = "Google";String desde = "2016";	String hasta = "2016";
//		
		DAOGlobalMYSQL repo = new DAOGlobalMYSQL<>();
//		Metodologia metodologia=repo.findEntidadWithNombre("Cumplidora");
//		List<CondicionTaxativa> listaC = metodologia.getCondiciones();
//		
//		List<Cuenta> listaCuentas = repo.getCuentas(empresa,desde,hasta);
//		
//		ArrayList<String> cuentasDeIndicadores = new ArrayList<>();
//
//		boolean sePuedeCalcular =false;
//		
//		for(CondicionTaxativa c : listaC){
//			if(!esCuenta(c.getIndicadorOCuenta())){
//				Indicador aux = repo.findIndicador(c.getIndicadorOCuenta());
//				cuentasDeIndicadores.addAll(aux.cuentasDeLaFormula(aux.getFormula()));
//			}
//			if(existeCuenta(listaCuentas,c.getIndicadorOCuenta())){
//				sePuedeCalcular = true;
//			}
//		}
//		
//		for(String a: cuentasDeIndicadores){
//			if(existeCuenta(listaCuentas,a)){
//				sePuedeCalcular=true;
//			}
//			else
//				sePuedeCalcular = false;
//		}
//		
//		System.out.println("valorr "+ sePuedeCalcular);
//		
//		if(!sePuedeCalcular){
//			System.out.println("No se puede calcular");
//		}
//		else{		
//			boolean resultado =listaC.stream().allMatch(c -> c.cumpleCondicion(empresa,desde,hasta,c.obtenerValorDeCuentaOIndicador(empresa, desde, hasta)));
//			
//			if(resultado){
//				System.out.println("Conviene Invertir");
//			}
//			else
//				System.out.println("No Conviene Invertir");
//		}
		
//		List<Metodologia> metodologia = repo.getAll();
//		List<Metodologia> metodologiaUsuario = metodologia.stream().filter((Metodologia m)->m.getUsuario().getNombre().equals("Paula")).collect(Collectors.toList());
//		
//		List<CondicionTaxativa> condicionesTaxativas = new ArrayList<>();
//		
//		for(Metodologia m : metodologiaUsuario){
//			condicionesTaxativas.addAll(m.getCondiciones());
//		}
//		
//		condicionesTaxativas.stream().distinct().collect(Collectors.toList());
//		
//		for(CondicionTaxativa cv : condicionesTaxativas){
//			System.out.println("Nombre "+ cv.getMetodologia().getNombre());
//		}
		List<Indicador> lista = repo.getAllIndicadores();
		List<Indicador> indicadores = (List<Indicador>) lista.stream().filter((Indicador in)->in.getUsuario().getNombre().equals("Eze")).collect(Collectors.toList());
		for(Indicador i: indicadores){
			System.out.println("nombre "+ i.getNombre());
		}
	}
	
	private static boolean esCuenta(String indicadorCuenta){
		DAOGlobalMYSQL<Cuenta> dao = new DAOGlobalMYSQL<Cuenta>(Cuenta.class);
		List<Cuenta> lista = dao.getAll();
		if(lista.stream().anyMatch((Cuenta c)-> c.getNombre().equals(indicadorCuenta)))
			return true;
		else
			return false;
	}
	
	public static boolean existeCuenta(List<Cuenta> cuentasDeEmpresa, String cuentasDeMetodologia){
		if(cuentasDeEmpresa.stream().anyMatch((Cuenta c)-> c.getNombre().equals(cuentasDeMetodologia)))
			return true;
		else
			return false;
	}

	public static CondicionOrdenamiento findCondicion(String usuario, String condicion)
	{
		EntityManager em = EntityManagerHelper.entityManager();
		return (CondicionOrdenamiento) em.createNativeQuery("SELECT c.id, c.comparador, c.indicadorCuenta,c.metodologia_id FROM inversiones.condicionordenamiento c "
				+ "join inversiones.metodologia m on (m.id=c.metodologia_id) "
				+ "join inversiones.usuario u "
				+ "where m.nombre = '"+condicion+"' and u.nombre ='"+usuario+"'"
                                     ,CondicionOrdenamiento.class).getSingleResult();

	}

}
