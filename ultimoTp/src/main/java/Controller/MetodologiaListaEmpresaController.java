package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import Comparator.Comparador;
import Entity.CondicionOrdenamiento;
import Entity.Empresa;
import Entity.Metodologia;
import Entity.Periodo;
import Modelo.DAOGlobalMYSQL;
import Modelo.DAOjson;
import Modelo.DAOmetodologiaJson;
import Modelo.RepositorioDeMetodologia;
import db.EntityManagerHelper;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiaListaEmpresaController {
	private Map<String, Object> model=new HashMap<>();
		
	public ModelAndView inicioMetodologiaListaEmpresas(Request req, Response res){
		String nombre_usuario = req.session().attribute("usuario");
		DAOGlobalMYSQL<Periodo> modelPeriodo = new DAOGlobalMYSQL<Periodo>(Periodo.class);
		DAOGlobalMYSQL<Empresa> modelEmpresa = new DAOGlobalMYSQL<Empresa>(Empresa.class);
		DAOGlobalMYSQL<Metodologia> modelMetodologia = new DAOGlobalMYSQL<Metodologia>(Metodologia.class);
		RepositorioDeMetodologia repo = new RepositorioDeMetodologia(modelMetodologia);
		List<Metodologia> metodologiaUsuario = repo.getLista().stream().filter(m -> m.getUsuario().getNombre().equals(nombre_usuario)).collect(Collectors.toList());
		
		model.put("empresas", modelEmpresa.getAllEmp());
		model.put("periodosDesde", modelPeriodo.getAllPeriodos());
		model.put("periodosHasta", modelPeriodo.getAllPeriodos());	
		model.put("metodologia", metodologiaUsuario);	
		return new ModelAndView(model, "metodologiaListaEmpresas.hbs");
	}
		
	public ModelAndView consultaMetodologiaListaEmpresas(Request req, Response res){
		String nombre_usuario = req.session().attribute("usuario");
		String periodoDesde = req.queryParams("periodoDesde");
		String periodoHasta = req.queryParams("periodoHasta");
		String condicionOrdenamiento = req.queryParams("metodologia");
		//aca va arrays de strings
		String[] empresasPrueba = req.queryParamsValues("empresas");

		List<String> empresasSeleccionadas= new ArrayList<>();
		
		//empresasSeleccionadas.add("Cloud");empresasSeleccionadas.add("Ford");empresasSeleccionadas.add("Google"); 
		
		for(int i = 0;i<empresasPrueba.length;i++){
			empresasSeleccionadas.add(empresasPrueba[i]);
		}

		DAOGlobalMYSQL<Empresa> dao = new DAOGlobalMYSQL<Empresa>(Empresa.class);
		List<Empresa> lista = dao.getAllEmp();
		
		//**Agregar empresas mediante stringsss****
		List<Empresa> empresas = new ArrayList<>();
		
		for(Empresa e : lista){
			if(empresasSeleccionadas.stream().anyMatch((String nombre)-> nombre.equals(e.getNombre()))){
				empresas.add(e);
			}
		}

		CondicionOrdenamiento condicion = this.findCondicion(nombre_usuario, condicionOrdenamiento);
		condicion.setListaEmpresas(empresas);
		condicion.darValorAEmpresas(periodoDesde,periodoHasta);
		condicion.ordenar();
		
		model.put("empresas", empresas);
		return new ModelAndView(model, "consultaMetodologiasListaEmpresas.hbs");
		
	}
	
	public CondicionOrdenamiento findCondicion(String usuario, String condicion)
	{
		EntityManager em = EntityManagerHelper.entityManager();
		return (CondicionOrdenamiento) em.createNativeQuery("SELECT c.id, c.comparador, c.indicadorCuenta,c.metodologia_id FROM inversiones.condicionordenamiento c "
				+ "join inversiones.metodologia m on (m.id=c.metodologia_id) "
				+ "join inversiones.usuario u "
				+ "where m.nombre = '"+condicion+"' and u.nombre ='"+usuario+"'"
                                     ,CondicionOrdenamiento.class).getSingleResult();

	}

	
}
