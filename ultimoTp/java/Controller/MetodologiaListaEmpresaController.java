package Controller;


	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.LinkedList;
	import java.util.Map;

	import Modelo.DAOjson;
	import Modelo.DAOmetodologiaJson;
	import spark.ModelAndView;
	import spark.Request;
	import spark.Response;

	public class MetodologiaListaEmpresaController {
		private Map<String, Object> model=new HashMap<>();
		
		public ModelAndView inicioMetodologiaListaEmpresas(Request req, Response res){
			
			DAOmetodologiaJson modelSuper = DAOmetodologiaJson.getInstance();
			modelSuper.addAllStruct();
			model.put("empresas", modelSuper.getAll());
			//model.put("periodosDesde", modelSuper.getAllPeriodos());
			//model.put("periodosHasta", modelSuper.getAllPeriodos());
			//model.put("metodologias", modelSuper.getAllMetodogologia());
			return new ModelAndView(model, "metodologiaListaEmpresas.hbs");
		}

	
}
