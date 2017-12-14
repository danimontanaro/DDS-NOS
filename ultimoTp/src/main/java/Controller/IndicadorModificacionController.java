package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Entity.Empresa;
import Entity.Indicador;
import Modelo.DAOGlobalMYSQL;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class IndicadorModificacionController {
	private Map<String, Object> model=new HashMap<>();
	
	public ModelAndView inicioIndicadorModificacion(Request req, Response res){
		DAOGlobalMYSQL modelSuper = new DAOGlobalMYSQL();
		//ArrayList x = ;
		model.put("indicador", modelSuper.getAllIndicadores() );
			
		return new ModelAndView(model, "indicadorModificacion.hbs");
	}
	
	public ModelAndView indicadorModificacion(Request req, Response res)
	{
		DAOGlobalMYSQL modelSuper = new DAOGlobalMYSQL();
		String nombre = req.queryParams("nombre");
		String formula = req.queryParams("formula");
		System.out.println(nombre);
		System.out.println(formula);
		/*Empresa empresa =modelSuper.findEmpresa(empresaB);
		ArrayList<Indicador> indicadores=modelSuper.getIndicadores(empresaB,periodoDesde,periodoHasta);
		model.put("periodoDesde", periodoDesde);
		model.put("periodoHasta",periodoHasta);
		model.put("empresa", empresa);
		model.put("indicadores",indicadores);*/
		return new ModelAndView(model, "consultaIndicador.hbs");
	}
}
