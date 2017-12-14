package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Entity.Empresa;
import Entity.Indicador;
import Modelo.DAOGlobalMYSQL;
import Modelo.DAOIndicadorJson;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class IndicadorConsultaController {
	private Map<String, Object> model=new HashMap<>();
	
	public ModelAndView inicioIndicadorConsulta(Request req, Response res){
		DAOGlobalMYSQL modelSuper = new DAOGlobalMYSQL();
		model.put("empresas", modelSuper.getAllEmp());
		model.put("periodosDesde", modelSuper.getAllPeriodos());
		model.put("periodosHasta", modelSuper.getAllPeriodos());		
		return new ModelAndView(model, "indicadorConsulta.hbs");
	}
	public ModelAndView indicadorConsulta(Request req, Response res)
	{
		DAOGlobalMYSQL modelSuper = new DAOGlobalMYSQL();
		String nombre_usuario = req.session().attribute("usuario");
		String empresaB = req.queryParams("empresa");
		String periodoDesde = req.queryParams("periodoDesde");
		System.out.println(empresaB);
		System.out.println(periodoDesde);
		String periodoHasta = req.queryParams("periodoHasta");
		Empresa empresa =modelSuper.findEmpresa(empresaB);
		
		List<Indicador> lista = modelSuper.getAllIndicadores();
		List<Indicador> indicadores = (List<Indicador>) lista.stream().filter((Indicador in)->in.getUsuario().getNombre().equals(nombre_usuario)).collect(Collectors.toList());
		
		model.put("periodoDesde", periodoDesde);
		model.put("periodoHasta",periodoHasta);
		model.put("empresa", empresa);
		model.put("indicadores",indicadores);
		return new ModelAndView(model, "consultaIndicador.hbs");
	}
	public ModelAndView listarCuentas(Request req, Response res){
		
		//DAOIndicadorJson modelSuper = DAOIndicadorJson.getInstance();
	
		//String empresaBuscada = req.queryParams("empresa");
		//Empresa empresa = modelSuper.get(empresaBuscada);
		//model.put("empresa", empresa);
		
		return new ModelAndView(model, "indicadorConsulta.hbs");
	}
	
	public ModelAndView consultarValor(Request req, Response res)
	{
		DAOGlobalMYSQL modelSuper = new DAOGlobalMYSQL();
		String formula = req.params("formula");
		String stringDeFormula = formula.replace("%2F","/");
		String desde= req.params("periodoDesde");
		String desdePeriodo = desde.replace("%2F","/");
		String hasta = req.params("periodoHasta");
		String hastaPeriodo = hasta.replace("%2F","/");
		String empresa= req.params("empresa");
		Indicador indic=new Indicador();
		System.out.println("dddd formula "+ formula);
		try{
			double result = indic.metodoCoolConFormula(desdePeriodo, hastaPeriodo, empresa, stringDeFormula);
			model.put("resultado",result);
		} catch (Exception e) {
			return new ModelAndView(model, "noPuedeIndicador.hbs");
		} 
		
		
		
		//System.out.println(indic.metodoCoolConFormula(desde, hasta, empresa, formula));
		
		return new ModelAndView(model, "resultadoObtenido.hbs");
	}
	/*
	public ModelAndView consultaCuenta(Request req, Response res){
		DAOIndicadorJson modelSuper = DAOIndicadorJson.getInstance();
		String empresaB = req.queryParams("empresa");
		String periodoDesde = req.queryParams("periodoDesde");
		String periodoHasta = req.queryParams("periodoHasta");
		Empresa empresa =modelSuper.findEmpresa(empresaB);
		ArrayList<Cuenta> cuentas=empresa.getCuentas();
		ArrayList<Cuenta> cta2 =new ArrayList<Cuenta>() ;
		for(int i=0;i<  cuentas.size();i++)
		{
			List<Cuenta> ctaPorPeriodo=cuentas.get(i).getCuentasPorPeriodo(periodoDesde,periodoHasta, empresaB);
			for(int j=0;j<ctaPorPeriodo.size();j++)
			{
				cta2.add(ctaPorPeriodo.get(j));
			}
			
		}
		//= (ArrayList<Cuenta>) cuentas.stream().map(cta->cta.getCuentasPorPeriodo(periodoDesde, periodoHasta, empresa.getNombre()));
		model.clear();
		model.put("empresa", empresa);
		model.put("cuentas",cta2);
		return new ModelAndView(model, "indicadorConsulta.hbs");
	}
	*/
}
