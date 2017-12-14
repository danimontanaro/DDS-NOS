package server;

import Controller.CuentaController;
import Controller.IndicadorAltaController;
import Controller.IndicadorConsultaController;
import Controller.IndicadorEliminacionController;
import Controller.IndicadorModificacionController;
import Controller.InicioController;
import Controller.LoginController;
import Controller.MetodologiaAltaController;
import Controller.MetodologiaEliminacionController;
import Controller.MetodologiaEmpresaContoller;
import Controller.MetodologiaListaEmpresaController;
import Controller.MetodologiaModificacionController;
/*import controllers.InicioController;
import controllers.VentasController;*/
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
	public static void configure(){
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
				.create()
				.withDefaultHelpers()
				.withHelper("isTrue", BooleanHelper.isTrue)
				.build();

		Spark.staticFiles.location("/public");
		
		LoginController loginController = new LoginController();
		CuentaController cuentaController = new CuentaController();
		MetodologiaEmpresaContoller metodologiaController = new MetodologiaEmpresaContoller();
		MetodologiaListaEmpresaController metodologiaListaEmpresas = new MetodologiaListaEmpresaController();
		MetodologiaModificacionController metodologiaModificacion = new MetodologiaModificacionController();
		MetodologiaAltaController metodologiaAlta = new MetodologiaAltaController();
		MetodologiaEliminacionController metodologiaEliminacion = new MetodologiaEliminacionController();
		IndicadorAltaController indicadorAlta = new IndicadorAltaController();
		IndicadorEliminacionController indicadorEliminacion = new IndicadorEliminacionController();
		IndicadorModificacionController indicadorModificacion =new IndicadorModificacionController();
		IndicadorConsultaController indicadorConsulta =new IndicadorConsultaController();
		
		
		
		
		Spark.get("/", loginController::inicio, engine);
		Spark.post("/Home", loginController::verificarUsuario,engine);
		Spark.get("/cuentas", cuentaController::inicioCuenta, engine);
		Spark.post("/consultaCuenta", cuentaController::consultaCuenta,engine);
		/*Spark.post("/ventaDetalle", ventasController::verdetalleVenta, engine);
		*/
		Spark.get("/metodologias", metodologiaController::inicioMetodologia, engine);
		Spark.get("/consultar", metodologiaController::consultaMetodologia, engine);
		Spark.get("/metodologiasListaEmpresas", metodologiaListaEmpresas::inicioMetodologiaListaEmpresas, engine);
		Spark.post("/consultaMetodologiasListaEmpresas", metodologiaListaEmpresas::consultaMetodologiaListaEmpresas, engine);
		Spark.get("/metodologiasModificacion", metodologiaModificacion::inicioMetodologiaModificacion, engine);
		Spark.get("/metodologiasAlta", metodologiaAlta::inicioMetodologiaAlta, engine);
		Spark.get("/metodologiaEliminacion", metodologiaEliminacion::inicioMetodologiaEliminacion, engine);
		Spark.get("/eliminado", metodologiaEliminacion::verificarEliminacion, engine);
		Spark.get("/indicadorAlta", indicadorAlta::inicioIndicadorAlta, engine);
		Spark.post("/verificarAltaIndicador", indicadorAlta::verificarAltaIndicador, engine);
		Spark.get("/indicadorEliminacion", indicadorEliminacion::inicioIndicadorEliminacion, engine);	
		Spark.post("/indicadorEliminar", indicadorEliminacion::verificarEliminacion, engine);
		Spark.get("/indicadorModificacion", indicadorModificacion::inicioIndicadorModificacion, engine);
		Spark.post("/modificacionIndicador/:nombre/:formula", indicadorModificacion::indicadorModificacion, engine);
		Spark.get("/indicadorConsulta", indicadorConsulta::inicioIndicadorConsulta, engine);
		Spark.post("/consultaIndicadores",indicadorConsulta::indicadorConsulta,engine );
		Spark.get("/VerificarAltaMetodologia", metodologiaAlta::altaMetodologia, engine);
		Spark.get("/obtenerValorIndicador/:empresa/:periodoDesde/:periodoHasta/:formula", indicadorConsulta::consultarValor, engine);
		Spark.post("/altaMetodologia",metodologiaAlta::altaMetodologia, engine);
		Spark.get("/Integrantes", loginController::integrantes,engine);
		Spark.get("/cerrarSesion", loginController::logout,engine);
			
		
	}
}
