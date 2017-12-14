package Controller;

import java.util.HashMap;
import java.util.Map;

import Entity.Usuario;
import Modelo.DAOGlobalMYSQL;
import Modelo.DAOUsuarioJson;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LoginController {
	private Map<String, Object> model=new HashMap<>();
		
		public ModelAndView inicio(Request req, Response res){
			/*String usuario = req.session().attribute("usuario");
	    	if (usuario == null) {
	    		res.redirect("/");
	    		return null;
	    	}*/
			return new ModelAndView(model, "login.hbs");
		}
		
		public ModelAndView logout(Request request, Response response) {
			  request.session().removeAttribute("usuario");
			  response.redirect("/");
			  return null;
		  }
		public ModelAndView integrantes(Request req,Response res)
		{
			return new ModelAndView(model,"integrantes.hbs");
		}
		public ModelAndView verificarUsuario(Request req, Response res)
		{
//			DAOUsuarioJson usuariojson= DAOUsuarioJson.getInstance();
//			usuariojson.addAllStruct();
			DAOGlobalMYSQL daoUsuario=new DAOGlobalMYSQL();
			String usuarioBuscado = req.queryParams("Usuario");
			String contraseñaBuscada = req.queryParams("Password");
			boolean existe = daoUsuario.existeUsuarioYContraseña(usuarioBuscado, contraseñaBuscada);
			if(!existe)
			{	
				return  new ModelAndView(model,"errorLogin.hbs");
			}
			else
			{
			Usuario usuario=daoUsuario.findPorId(1);
			model.put("usuario", usuario);
			req.session().attribute("usuario", usuarioBuscado);
			return new ModelAndView(model,"inicio.hbs");
			}
		}
}
