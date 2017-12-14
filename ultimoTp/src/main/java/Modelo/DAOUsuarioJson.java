package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Entity.Indicador;
import Entity.Usuario;

public class DAOUsuarioJson implements DAOUsuario {

	private Gson myGson;
	private BufferedWriter bufferToWrite;
	private ArrayList<Usuario> listaDeUsuarios;	

	private static DAOUsuarioJson instance = null;
	public DAOUsuarioJson() {
		super();
		this.myGson = new Gson();
		listaDeUsuarios = new ArrayList<Usuario>();
	}
	public static DAOUsuarioJson getInstance() {
		if(instance==null){
			instance = new DAOUsuarioJson();
		}
		return instance;
	}
	public void addAllStruct() 
	{
		//CREA al json
		
		 Usuario oUsuario1=new Usuario();
		 oUsuario1.setNombre("Admin");
		 oUsuario1.setContraseña("w23e");
		
		 
		 Indicador indicUsu1= new Indicador();
		 indicUsu1.setNombre("asd");
		 indicUsu1.setFormula("ROE-FDS");
		 indicUsu1.setSePuedeBorrar(true);
		 ArrayList<Indicador> indicadoresUsu1= new ArrayList<Indicador>();
		 indicadoresUsu1.add(indicUsu1);
		 oUsuario1.setIndicadores(indicadoresUsu1);
		 
		 listaDeUsuarios.add(oUsuario1);

		 //-------------------- 
		 //otroIndicador
		 Usuario oUsuario2=new Usuario();
		 oUsuario2.setNombre("gr13");
		 oUsuario2.setContraseña("capas");
		//no tiene indicadores
		 
		 listaDeUsuarios.add(oUsuario2);
		 
		
		 
		  Gson gson = new Gson();
		  
		  // Convierte un objeto de java en un JSON,
		  // retorna un json con un formato sting 
		  String json = gson.toJson(listaDeUsuarios);
		  
		  try {
		//   write convierte un json en un archivo llamado "modeloGSON.json"
		   FileWriter writer = new FileWriter("C:\\Home\\UsuariosGSON.json");
		   writer.write(json);
		   writer.close();
		  
		  } catch (IOException e) {

		   e.printStackTrace();
		  }

		  System.out.println(json);
		  
	 }

	@Override
	public void add(Usuario user) throws IOException {
		String userSerializado = myGson.toJson(user);
		this.writeJson(userSerializado);		
	}

	private void writeJson(String userSerializado) throws IOException{
		this.bufferToWrite = new BufferedWriter(new FileWriter("C:\\Home\\UsuariosGSON.json", true));
		this.bufferToWrite.append(userSerializado);
		this.bufferToWrite.close();		
	}
	
	public int findUser(String nombre){
		this.listaDeUsuarios = this.getAll();		
		for (int i = 0; i < listaDeUsuarios.size(); i++){
			if(listaDeUsuarios.get(i).getNombre().equals(nombre)){				
				return i;
			}
		}
		return 0;
	}
	
	public void escribirArchivo(ArrayList<Usuario> lista){			
		String json = myGson.toJson(lista);		
		try {
			FileWriter writer = new FileWriter("C:\\Home\\UsuariosGSON.json");
			writer.write(json);
			writer.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}


	public void delete(String nombre) {
	
		listaDeUsuarios = this.getAll();
		int a = this.findUser(nombre);
		try{
			listaDeUsuarios.remove(a);
			escribirArchivo(listaDeUsuarios);
		}catch(Exception e){
			e.fillInStackTrace();
		}
	}

	@Override
	public void update(Usuario user,String name) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Usuario> getAll()
	{
	
		//DEBO FILTRAR POR EL AÑO!!!
		Gson gson = new Gson();
		ArrayList<Usuario> listaDeUsers= new ArrayList<Usuario>();
		try {
			  
		 BufferedReader br = new BufferedReader(new FileReader("C:\\Home\\UsuariosGSON.json"));


		final Type tipoListaUsers = new TypeToken<List<Usuario>>(){}.getType();
		listaDeUsers = gson.fromJson(br,tipoListaUsers);

		 return listaDeUsers;		  
		 } catch (IOException e) {
			 e.printStackTrace();
			 return null;
		 }
		
	}
	
	@Override
	public List<Usuario> find(String nombre) {
		Gson gson = new Gson();
		try 
		 {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Home\\UsuariosGSON.json"));
			final Type tipoListaUsers = new TypeToken<List<Usuario>>(){}.getType();
			List<Usuario> usuarios =  gson.fromJson(br,tipoListaUsers);
		    List<Usuario> result = usuarios.stream()   // Convierte la lista en un Stream
			                .filter(unUser -> unUser.getNombre().equals(nombre))  //Filtro segun criterio de nombre
			                .collect(Collectors.toList());       // Convierte el Stream en lista de nuevo

	      	//System.out.println(result.get(0).getNombre());

	        return result;
		} 
		catch (IOException e) 
		{
			 e.printStackTrace();
		}
		return null;
	}

	public Usuario get(String nombreUser){
		List<Usuario> lista = this.listaDeUsuarios.stream().filter(s->s.getNombre().equals(nombreUser)).collect(Collectors.toList());
		return lista.get(0);
	}


}
