package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Entity.Metodologia;
import Modelo.DAOGlobalMYSQL;
import Modelo.RepositorioDeMetodologia;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiaEliminacionController {
private Map<String, Object> model=new HashMap<>();
	
	public ModelAndView inicioMetodologiaEliminacion(Request req, Response res){
		
		String nombre_usuario = req.session().attribute("usuario");
		DAOGlobalMYSQL<Metodologia> modelMetodologia = new DAOGlobalMYSQL<Metodologia>(Metodologia.class);
		RepositorioDeMetodologia repo = new RepositorioDeMetodologia(modelMetodologia);
		List<Metodologia> metodologiaUsuario = repo.getLista().stream().filter(m -> m.getUsuario().getNombre().equals(nombre_usuario)).collect(Collectors.toList());
		
		model.put("metodologia", metodologiaUsuario);
		return new ModelAndView(model, "metodologiaEliminacion.hbs");
	}
	
	public ModelAndView verificarEliminacion(Request req, Response res){
		
		String nombre_usuario = req.session().attribute("usuario");
		DAOGlobalMYSQL modelSuper = new DAOGlobalMYSQL();
		String nombreMetodologia =req.queryParams("Metodologia");
		int idUsuario = modelSuper.findIdUsuario(nombre_usuario);
		modelSuper.borraMetodologia(nombreMetodologia, idUsuario);
		return new ModelAndView(model,"borradoOKIndic.hbs");
	}
}
