package Controller;

import java.util.HashMap;
import java.util.Map;

import Modelo.DAOjson;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class InicioController {
	private Map<String, Object> model=new HashMap<>();
	
	public ModelAndView inicio(Request req, Response res){
		//DAOjson modelSuper = DAOjson.getInstance();
		//modelSuper.addAllStruct();
		//model.put("empresas", modelSuper.getAll());
		return new ModelAndView(model, "inicio.hbs");
	}
}