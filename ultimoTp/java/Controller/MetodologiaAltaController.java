package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import Entity.CondicionTaxativa;
import Entity.Metodologia;
import Entity.Usuario;
import Modelo.DAOGlobalMYSQL;
import Modelo.DAOmetodologiaJson;
import db.EntityManagerHelper;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiaAltaController {
	private Map<String, Object> model=new HashMap<>();
	
	public ModelAndView inicioMetodologiaAlta(Request req, Response res){
		return new ModelAndView(model, "metodologiaAlta.hbs");
	}
	
	public ModelAndView altaMetodologia(Request req, Response res){
		
		String nombre_usuario = req.session().attribute("usuario");
		DAOGlobalMYSQL<Metodologia> daoMetodologia= new DAOGlobalMYSQL<Metodologia>(Metodologia.class);
		
		//GUARDA METODOLOGIA TAXATIVA
		Metodologia metodologia = new Metodologia();
		CondicionTaxativa condicionTaxativa = new CondicionTaxativa();
		String nombre = req.queryParams("nombreMetodologia");
		String condicion = req.queryParams("condicion");
		
		System.out.println("Nombre Metodologia " + nombre + " Cuenta: "+condicion);
		String strar[]=condicion.split(" ");
		System.out.println(strar[0]);
				
		//--AGREGO CONDICION 
		condicionTaxativa.setIndicadorOCuenta(strar[0]);
		condicionTaxativa.setExpresion(strar[1]);
		int valorAComparar= Integer.parseInt(strar[2]);
		condicionTaxativa.setValorAComparar(valorAComparar);	
				
		ArrayList<CondicionTaxativa> listaCondiciones= new ArrayList<CondicionTaxativa>();	
		listaCondiciones.add(condicionTaxativa);
		
		//AGREGO METODOLOGIA
		metodologia.setNombre(nombre);
		metodologia.setCondiciones(listaCondiciones);
		metodologia.setUsuario(findPorNombre(nombre_usuario));
	
		
		System.out.println("Nombre Metodologia " + nombre + " Cuenta: "+ strar[0] + "A comparar: " +strar[1]+" valor: "+valorAComparar);
				
		try {
			daoMetodologia.add(metodologia);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return new ModelAndView(model, "verificarAlta.hbs");
	}
	
	public int findCondicion(String nombre){
//		EntityManager em = EntityManagerHelper.entityManager();
//		CondicionTaxativa cond = (Entity.CondicionTaxativa) em.createNativeQuery("select * from redinversiones.condiciontaxativa where nombre = '"+nombre+"'",CondicionTaxativa.class).getSingleResult();
//		if(cond.getNombre().equals(nombre))
//			return 0;
//		else return 1;
		return 0;
	}
	public Usuario findPorNombre(String nombre) {
		EntityManager em = EntityManagerHelper.entityManager();
		
		Usuario use = (Usuario) em.createNativeQuery(
				  "select * from redinversiones.usuario  where nombre = :username", Usuario.class).
				  setParameter("username", nombre).getSingleResult();
		return use;
	}
}
