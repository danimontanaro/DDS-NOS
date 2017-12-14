package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import Entity.*;
import Modelo.DAOGlobalMYSQL;
import Modelo.DAOjson;
import db.EntityManagerHelper;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class CuentaController {
	
	private Map<String, Object> model=new HashMap<>();
	
	public ModelAndView inicioCuenta(Request req, Response res){
		//String nombre_usuario = req.session().attribute("usuario");
		DAOGlobalMYSQL<Periodo> modelPeriodo = new DAOGlobalMYSQL<Periodo>(Periodo.class);
		DAOGlobalMYSQL<Empresa> modelEmpresa = new DAOGlobalMYSQL<Empresa>(Empresa.class);
		
		model.put("empresas", modelEmpresa.getAllEmp());
		model.put("periodosDesde", modelPeriodo.getAll());
		model.put("periodosHasta", modelPeriodo.getAll());		
		return new ModelAndView(model, "cuentas.hbs");
	}

	public ModelAndView listarCuentas(Request req, Response res){
		//***************PERSISTOIR CON SQL******************
		DAOGlobalMYSQL<Empresa> modelEmpresa = new DAOGlobalMYSQL<Empresa>(Empresa.class);
		String empresaBuscada = req.queryParams("empresa");
		Empresa empresa = modelEmpresa.findEntidadWithNombre(empresaBuscada);
		model.put("empresa", empresa);
		
		return new ModelAndView(model, "cuentas.hbs");
	}
	public ModelAndView consultaCuenta(Request req, Response res){		
		DAOGlobalMYSQL<EmpresaCuenta> modelSuper =new DAOGlobalMYSQL<EmpresaCuenta>(EmpresaCuenta.class);
		String empresa = req.queryParams("empresa");
		String periodoDesde = req.queryParams("periodoDesde");
		String periodoHasta = req.queryParams("periodoHasta");
				
		List<EmpresaCuenta> EmpCu = modelSuper.getAll().stream().filter(emp->emp.getEmpresa().getNombre().equals(empresa)).collect(Collectors.toList());
		//List<Cuenta> cuentas=modelSuper.getCuentas(empresaB,periodoDesde,periodoHasta);
		
		List<Cuenta> cuentas = new LinkedList<>();
		for(EmpresaCuenta ec:EmpCu){
			Cuenta cu=ec.getCuenta();
			cu.setValor(buscarValorINmysql(cu.getNombre(),periodoDesde,periodoHasta,empresa));
			cuentas.add(ec.getCuenta());
		}				
		//= (ArrayList<Cuenta>) cuentas.stream().map(cta->cta.getCuentasPorPeriodo(periodoDesde, periodoHasta, empresa.getNombre()));
		model.clear();
		model.put("empresa", empresa);
		model.put("cuentas",cuentas);
		model.put("desde", periodoDesde);
		model.put("hasta", periodoHasta);
		return new ModelAndView(model, "consultaCuenta.hbs");
	}
	
	public static int buscarValorINmysql(String cuenta, String desde, String hasta, String empresa){
		EntityManager em = EntityManagerHelper.entityManager();
				return (int) em.createNativeQuery("Select valorCuenta "
				+ "from redinversiones.periodo p "
				+ "join redinversiones.empresa_cuenta ce on(ce.id=p.empresa_cuenta_id) "
				+ "join redinversiones.empresa e on(e.id=ce.empresa_id) join redinversiones.cuenta c "
				+ "on(c.id=ce.cuenta_id) where c.nombre='"+cuenta+"' and p.desde ='"+desde+"' "
						+ "and p.hasta ='"+hasta+"' and e.nombre ='"+empresa+"'").getSingleResult();

	}
	
//	public ArrayList<Periodo> obtenerPeriodos(){
//		EntityManager em = EntityManagerHelper.getEntityManager();
//		ArrayList<Periodo> desde= (ArrayList<Periodo>) em.createNativeQuery("select  * from periodo",Periodo.class).getResultList();
//		return desde;
//	}
	
}