package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import Entity.CondicionTaxativa;
import Entity.Cuenta;
import Entity.Empresa;
import Entity.Indicador;
import Entity.Metodologia;
import Entity.Periodo;
import Entity.Usuario;
import Modelo.DAOGlobalMYSQL;
import Modelo.DAOjson;
import Modelo.DAOmetodologiaJson;
import Modelo.RepositorioDeEmpresas;
import Modelo.RepositorioDeMetodologia;
import db.EntityManagerHelper;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiaEmpresaContoller {
	private Map<String, Object> model=new HashMap<>();
	
	public ModelAndView inicioMetodologia(Request req, Response res){
		
		String nombre_usuario = req.session().attribute("usuario");
		DAOGlobalMYSQL<Periodo> modelPeriodo = new DAOGlobalMYSQL<Periodo>(Periodo.class);
		DAOGlobalMYSQL<Empresa> modelEmpresa = new DAOGlobalMYSQL<Empresa>(Empresa.class); 
		DAOGlobalMYSQL<Metodologia> dao = new DAOGlobalMYSQL<Metodologia>(Metodologia.class);
		RepositorioDeMetodologia repo = new RepositorioDeMetodologia(dao);
		List<Metodologia> metodologiaUsuario = repo.getLista().stream().filter(m -> m.getUsuario().getNombre().equals(nombre_usuario)).collect(Collectors.toList());
	
		model.put("empresas", modelEmpresa.getAll());
		model.put("periodosDesde", modelPeriodo.getAllPeriodos());
		model.put("periodosHasta", modelPeriodo.getAllPeriodos());
		model.put("metodologia", metodologiaUsuario);
		
		return new ModelAndView(model, "metodologiaEmpresa.hbs");
	}
	public ModelAndView consultaMetodologia(Request req, Response res){
		
		DAOGlobalMYSQL<Metodologia> dao = new DAOGlobalMYSQL<Metodologia>(Metodologia.class);
		RepositorioDeMetodologia repo = new RepositorioDeMetodologia(dao);
		String empresaSeleccionada = req.queryParams("empresa");
		String desde = req.queryParams("periodoDesde");
		String hasta = req.queryParams("periodoHasta");
		String metodologiaSeleccionada = req.queryParams("metodologia");

		Metodologia metodologia=repo.findMetodologia(metodologiaSeleccionada);
		List<CondicionTaxativa> listaC = metodologia.getCondiciones();
		
		List<Cuenta> listaCuentas = dao.getCuentas(empresaSeleccionada, desde, hasta);
		ArrayList<String> cuentasDeIndicadores = new ArrayList<>();
		boolean sePuedeCalcular = false;
		
		for(CondicionTaxativa c : listaC){
			if(!esCuenta(c.getIndicadorOCuenta())){
				Indicador aux = dao.findIndicador(c.getIndicadorOCuenta());
				cuentasDeIndicadores.addAll(aux.cuentasDeLaFormula(aux.getFormula()));
			}
			if(existeCuenta(listaCuentas,c.getIndicadorOCuenta())){
				sePuedeCalcular = true;
			}
		}
		
		for(String a: cuentasDeIndicadores){
			if(existeCuenta(listaCuentas,a)){
				sePuedeCalcular=true;
			}
			else
				sePuedeCalcular = false;
		}
		
		if(!sePuedeCalcular){
			return new ModelAndView(model, "noPuede.hbs");
		}
		else{		
			boolean resultado =listaC.stream().allMatch(c -> c.cumpleCondicion(empresaSeleccionada, desde, hasta,c.obtenerValorDeCuentaOIndicador(empresaSeleccionada, desde, hasta)));
			model.clear();
			model.put("resultado", resultado);
			if(resultado){
				return new ModelAndView(model, "Invertir.hbs");
			}
			else
				return new ModelAndView(model, "noInvertir.hbs");
		}
	}
	
	private boolean esCuenta(String indicadorCuenta){
		DAOGlobalMYSQL<Cuenta> dao = new DAOGlobalMYSQL<Cuenta>(Cuenta.class);
		List<Cuenta> lista = dao.getAll();
		if(lista.stream().anyMatch((Cuenta c)-> c.getNombre().equals(indicadorCuenta)))
			return true;
		else
			return false;
	}
	
	public boolean existeCuenta(List<Cuenta> cuentasDeEmpresa, String cuentaDeMetodologia){
		if(cuentasDeEmpresa.stream().anyMatch((Cuenta c)-> c.getNombre().equals(cuentaDeMetodologia)))
			return true;
		else
			return false;
	}
	public Usuario findPorNombre(String nombre) {
		EntityManager em = EntityManagerHelper.entityManager();
		
		Usuario use = (Usuario) em.createNativeQuery(
				  "select * from redinversiones.usuario  where nombre = :username", Usuario.class).
				  setParameter("username", nombre).getSingleResult();
		return use;
	}
	
	public int buscarValorINmysql(String cuenta, String desde, String hasta, String empresa){
		EntityManager em = EntityManagerHelper.entityManager();
				return (int) em.createNativeQuery("Select valorCuenta "
				+ "from redinversiones.periodo p "
				+ "join redinversiones.empresa_cuenta ce on(ce.id=p.empresa_cuenta_id) "
				+ "join redinversiones.empresa e on(e.id=ce.empresa_id) join redinversiones.cuenta c "
				+ "on(c.id=ce.cuenta_id) where c.nombre='"+cuenta+"' and p.desde ='"+desde+"' "
						+ "and p.hasta ='"+hasta+"' and e.nombre ='"+empresa+"'").getSingleResult();

	}
}
