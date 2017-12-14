import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import Entity.CondicionTaxativa;
import Entity.Cuenta;
import Entity.Empresa;
import Entity.EmpresaCuenta;
import Entity.Indicador;
import Entity.Metodologia;
import Entity.Periodo;
import Modelo.DAOGlobalMYSQL;
import Modelo.RepositorioDeEmpresas;
import Modelo.RepositorioDeMetodologia;
import db.EntityManagerHelper;

public class PruebaMetodologia {

	public static void main(String[] args) {
		DAOGlobalMYSQL<Cuenta> daoCuenta = new DAOGlobalMYSQL<Cuenta>(Cuenta.class);
		DAOGlobalMYSQL<Metodologia> dao = new DAOGlobalMYSQL<Metodologia>(Metodologia.class);
		RepositorioDeMetodologia repo = new RepositorioDeMetodologia(dao);
	
		List<Metodologia> lista = repo.getLista();
//		for(Metodologia m: lista){
//			System.out.println("FUNCIONANANAN: "+ m.getNombre());
//		}
		Metodologia m = lista.get(1);
		List<CondicionTaxativa> listaC = m.getCondiciones();
//		
//		DAOGlobalMYSQL<Periodo> daoPeriodo = new DAOGlobalMYSQL<Periodo>(Periodo.class);
//		ArrayList<Periodo> p = (ArrayList<Periodo>) daoPeriodo.getAll();
//		for(Periodo c : p){
//			System.out.println("eee" + c.getValorCuenta());
//		}
		
		DAOGlobalMYSQL<Empresa> daoE = new DAOGlobalMYSQL<Empresa>(Empresa.class);
		RepositorioDeEmpresas repoE = new RepositorioDeEmpresas(daoE);
//		System.out.println("valores "+repoE.findEmpresa("Facebook").getNombre());
		
		String empresa="Cloud";String desde ="2016";String hasta="2016";
		DAOGlobalMYSQL<EmpresaCuenta> daoEC = new DAOGlobalMYSQL<EmpresaCuenta>(EmpresaCuenta.class);

		//List<EmpresaCuenta> l = daoEC.getAll();
//		List<EmpresaCuenta> EmpCu = daoEC.getAll().stream().filter(emp->emp.getEmpresa().getNombre().equals(empresa)).collect(Collectors.toList()); 
//		System.out.println("sixe " + EmpCu.size());
//		List<Cuenta> listafinal = new LinkedList<>();
//		for(EmpresaCuenta ec:EmpCu){
//			Cuenta cu=ec.getCuenta();
//			System.out.println("Nombre Empresa "+ ec.getEmpresa().getNombre());
//			System.out.println("Nombre Cuenta "+ ec.getCuenta().getNombre());
//			System.out.println("vaaaalor " + buscarValorINmysql(cu.getNombre(),desde,hasta,empresa));
//			cu.setValor(buscarValorINmysql(cu.getNombre(),desde,hasta,empresa));
//			listafinal.add(ec.getCuenta());
//		}
//		System.out.println("sizeee " + listafinal.get(0).getValor());
		///*************APLICAR LISTA DE CONDICIONTAX A EMPRESAPERIODO************************ 
		
//		for (CondicionTaxativa c: listaC){
//			//System.out.println("VALORRR "+buscarValorINmysql(c.getIndicadorOCuenta(),desde,hasta,empresa));
//			boolean valor = c.cumpleCondicion(empresa, desde, hasta,buscarValorINmysql(c.getIndicadorOCuenta(),desde,hasta,empresa));
//		}
//		System.out.println("ss "+listaC.get(0).getExpresion() + "VLAORRR "+buscarValorINmysql(listaC.get(0).getIndicadorOCuenta(),desde,hasta,empresa));
//		System.out.println("FUNCIONA ? " + listaC.stream().allMatch(c -> c.cumpleCondicion(empresa, desde, hasta,buscarValorINmysql(c.getIndicadorOCuenta(),desde,hasta,empresa))));

		//********** APLICANDO METODOLOGIA CON INDICADOR/CUENTA*************
		CondicionTaxativa condicionTaxativa = new CondicionTaxativa();
		condicionTaxativa.setExpresion("Mayor");
		condicionTaxativa.setIndicadorOCuenta("AC");
		condicionTaxativa.setValorAComparar(2000000);
		
		Indicador ind = new Indicador();
		System.out.println("Valor de indicador " + condicionTaxativa.obtenerValorDeCuentaOIndicador(empresa, desde, hasta));
		//System.out.println("Formula "+ ind.getFormulaDeIndicador(condicionTaxativa.getIndicadorOCuenta()));
		//System.out.println("Valor de empresa en sus cuenta "+ condicionTaxativa.obtenerValorDeCuentaOIndicador(desde, hasta, empresa));
		//System.out.println(condicionTaxativa.cumpleCondicion(empresa, desde, hasta,condicionTaxativa.obtenerValorDeCuentaOIndicador(empresa, desde, hasta)));
		//System.out.println("Tamaño " + listaC.size());
		System.out.println("FUNCIONA ? " + listaC.stream().allMatch(c -> c.cumpleCondicion(empresa, desde, hasta,c.obtenerValorDeCuentaOIndicador(empresa, desde, hasta))));
		
//		for (CondicionTaxativa c: listaC){
//			//System.out.println("Valor " + c.obtenerValorDeCuentaOIndicador(empresa, desde, hasta));
//			double nro = c.obtenerValorDeCuentaOIndicador(empresa, desde, hasta);
//			boolean valor = c.cumpleCondicion(empresa, desde, hasta,nro);
//			System.out.println("Verdad "+valor );
//		}
	}
	//public static intbusca()
	
	public static int buscarValorINmysql(String cuenta, String desde, String hasta, String empresa){
		EntityManager em = EntityManagerHelper.entityManager();
				return (int) em.createNativeQuery("Select valorCuenta "
				+ "from redinversiones.periodo p "
				+ "join redinversiones.empresa_cuenta ce on(ce.id=p.empresa_cuenta_id) "
				+ "join redinversiones.empresa e on(e.id=ce.empresa_id) join redinversiones.cuenta c "
				+ "on(c.id=ce.cuenta_id) where c.nombre='"+cuenta+"' and p.desde ='"+desde+"' "
						+ "and p.hasta ='"+hasta+"' and e.nombre ='"+empresa+"'").getSingleResult();

	}

}
