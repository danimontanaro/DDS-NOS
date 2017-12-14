package Controller;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiaEliminacionController {
private Map<String, Object> model=new HashMap<>();
	
	public ModelAndView inicioMetodologiaEliminacion(Request req, Response res){
		
		//DAOmetodologiaJson modelSuper = DAOmetodologiaJson.getInstance();
		//modelSuper.addAllStruct();
		//model.put("empresas", modelSuper.getAllEmp());
		//model.put("periodosDesde", modelSuper.getAllPeriodos());
		//model.put("periodosHasta", modelSuper.getAllPeriodos());
		//model.put("metodologias", modelSuper.getAllMetodogologia());
		return new ModelAndView(model, "metodologiaEliminacion.hbs");
	}
}
