package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Entity.Indicador;
import Modelo.DAOGlobalMYSQL;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class IndicadorEliminacionController {
private Map<String, Object> model=new HashMap<>();
	
	public ModelAndView inicioIndicadorEliminacion(Request req, Response res){
		DAOGlobalMYSQL modelSuper = new DAOGlobalMYSQL();
		ArrayList<Indicador> indicadores= new ArrayList<Indicador>();
		indicadores=modelSuper.getAllIndicadores();
		model.put("indicadores", indicadores);
		return new ModelAndView(model, "indicadorEliminacion.hbs");
	}
	public ModelAndView verificarEliminacion(Request req, Response res)
	{
		DAOGlobalMYSQL modelSuper = new DAOGlobalMYSQL();
		String nombreIndicador =req.queryParams("Indicador");
		boolean existe = modelSuper.sePuedeBorrarIndicador(nombreIndicador);
		if(!existe)
		{	
			return  new ModelAndView(model,"errorBorradoIndic.hbs");
		}
		else
		{
		modelSuper.borrarIndicador(nombreIndicador);
		return new ModelAndView(model,"borradoOKIndic.hbs");
		}
	}
}
