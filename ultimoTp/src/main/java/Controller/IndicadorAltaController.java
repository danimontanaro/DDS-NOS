package Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Entity.Indicador;
import Entity.Usuario;
import Modelo.DAOGlobalMYSQL;
import Modelo.DAOIndicador;
import Modelo.DAOIndicadorMYSQL;
import Modelo.DAOUsuario;
import Modelo.DAOUsuarioMYSQL;
import db.EntityManagerHelper;
import parserIndicadores.GrammarIndicadores;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class IndicadorAltaController {
private Map<String, Object> model=new HashMap<>();
	
	public ModelAndView inicioIndicadorAlta(Request req, Response res){
		return new ModelAndView(model, "indicadorAlta.hbs");
	}
	public ModelAndView verificarAltaIndicador(Request req, Response res){
		
		String nombre_usuario = req.session().attribute("usuario");
		Indicador indicador= new Indicador();
		String nombreIndicador = req.queryParams("nombreIndicador");
		String sentence = req.queryParams("formula");
		indicador.setFormula(sentence);
		indicador.setNombre(nombreIndicador);
		indicador.setSePuedeBorrar(false);
		//Usuario u=new Usuario();
		//DAOUsuarioMYSQL daousuario= new DAOUsuarioMYSQL();
		DAOGlobalMYSQL daousuario = new DAOGlobalMYSQL();
		
		//indicador.setUsuario((daousuario).findPorId(1));
		indicador.setUsuario(findPorNombre(nombre_usuario));
		
		System.out.println("QUEESTO "+nombre_usuario);
		GrammarIndicadores parser = null;
        // Put parens around sentence so that parser knows scope
        sentence = "(" + sentence + ")";
        InputStream is = new ByteArrayInputStream(sentence.getBytes());
        if(parser == null)  parser = new GrammarIndicadores(is);
        else GrammarIndicadores.ReInit(is);
        try
        {
          switch (GrammarIndicadores.start())
          {
            case 0 :
            	System.out.println("La formula esta Sintacticamente correcta.");
            	//DAOIndicador daoindicador= new DAOIndicadorMYSQL();
            	DAOGlobalMYSQL daoindicador = new DAOGlobalMYSQL();
            	daoindicador.add(indicador);
            	//GrammarIndicadores.symbol();
            	//IF del se puede aplicar
            	//si esta todo OK aplicateA
            break;
            default :
            break;
          }
        }
        catch (Exception e)
        {
        System.out.println("Error de Sintaxis.");
        }
        catch (Error e)
        {
        System.out.println("Error de Sintaxis.");
        }
        finally
        {
          
        }
        return new ModelAndView(model, "verificarAlta.hbs");
	}
	public Usuario findPorNombre(String nombre) {
		EntityManager em = EntityManagerHelper.entityManager();
		
		Usuario use = (Usuario) em.createNativeQuery(
				  "select * from redinversiones.usuario  where nombre = :username", Usuario.class).
				  setParameter("username", nombre).getSingleResult();
		return use;
	}
	
	private List<Indicador> findUsuario(String usuario) {
		  EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		  CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		  CriteriaQuery<Indicador> criteriaQuery = criteriaBuilder.createQuery(Indicador.class);
		  Root<Indicador> root = criteriaQuery.from(Indicador.class);
		  criteriaQuery.select(root);
		  ParameterExpression<String> params = criteriaBuilder.parameter(String.class);
		  criteriaQuery.where(criteriaBuilder.equal(root.get("usuario"), params));
		  TypedQuery<Indicador> query = entityManager.createQuery(criteriaQuery);
		  query.setParameter(params, usuario);
		  return query.getResultList();
	}
	
}
