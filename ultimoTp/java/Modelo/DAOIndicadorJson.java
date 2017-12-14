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

import Entity.Cuenta;
import Entity.Empresa;
import Entity.Indicador;
import Entity.Periodo;

public class DAOIndicadorJson implements DAOIndicador {

	private Gson myGson;
	private BufferedWriter bufferToWrite;
	private ArrayList<Indicador> listaDeIndicadores;	
	
	public DAOIndicadorJson() {
		super();
		this.myGson = new Gson();
		listaDeIndicadores = new ArrayList<Indicador>();
	}
	
	public void addAllStruct() 
	{
		//CREA al json
		 ArrayList<Indicador> listaDeIndicadores = new  ArrayList<Indicador>();
		 Indicador oIndicador1=new Indicador();
		 oIndicador1.setNombre("Ingreso Neto");
		 oIndicador1.setFormula("IngresoNetoEnOperacionesContinuas + IngresoNetoEnOperacionesDiscontinuas");
		 oIndicador1.setSePuedeBorrar(false);
		 
		 listaDeIndicadores.add(oIndicador1);

		 //-------------------- 
		 //otroIndicador
		 Indicador oIndicador2=new Indicador();
		 oIndicador2.setNombre("ROE");
		 oIndicador2.setFormula("(IngresoNeto - Dividendo) / CapitalTotal");
		 oIndicador2.setSePuedeBorrar(false);
		 
		 listaDeIndicadores.add(oIndicador2);
		 
		//otroIndicador
		 Indicador oIndicador3=new Indicador();
		 oIndicador3.setNombre("Prueba");
		 oIndicador3.setFormula("(IngresoNeto - Dividendo) / CapitalTotal");
		 oIndicador3.setSePuedeBorrar(false);
		 
		 listaDeIndicadores.add(oIndicador3);
		 
		 
		  Gson gson = new Gson();
		  
		  // Convierte un objeto de java en un JSON,
		  // retorna un json con un formato sting 
		  String json = gson.toJson(listaDeIndicadores);
		  
		  try {
		//   write convierte un json en un archivo llamado "modeloGSON.json"
		   FileWriter writer = new FileWriter("C:\\Home\\IndicadorGSON.json");
		   writer.write(json);
		   writer.close();
		  
		  } catch (IOException e) {

		   e.printStackTrace();
		  }

		  System.out.println(json);
		  
	 }

	@Override
	public void add(Indicador indicador) throws IOException {
		String indicadorSerializado = myGson.toJson(indicador);
		this.writeJson(indicadorSerializado);		
	}

	private void writeJson(String indicadorSerializado) throws IOException{
		this.bufferToWrite = new BufferedWriter(new FileWriter("C:\\Home\\workspace\\gr13\\IndicadorGSON.json", true));
		this.bufferToWrite.append(indicadorSerializado);
		this.bufferToWrite.close();		
	}
	
	public int findIndicador(String nombre){
		this.listaDeIndicadores = this.getAll();		
		for (int i = 0; i < listaDeIndicadores.size(); i++){
			if(listaDeIndicadores.get(i).getNombre().equals(nombre)){				
				return i;
			}
		}
		return 0;
	}
	
	public void escribirArchivo(ArrayList<Indicador> lista){			
		String json = myGson.toJson(lista);		
		try {
			FileWriter writer = new FileWriter("C:\\Home\\workspace\\gr13\\IndicadorGSON.json");
			writer.write(json);
			writer.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}


	public void delete(String nombre) {
	
		listaDeIndicadores = this.getAll();
		int a = this.findIndicador(nombre);
		try{
			listaDeIndicadores.remove(a);
			escribirArchivo(listaDeIndicadores);
		}catch(Exception e){
			e.fillInStackTrace();
		}
	}

	@Override
	public void update(Indicador indicador,String name) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Indicador> getAll()
	{
	
		//DEBO FILTRAR POR EL AÑO!!!
		Gson gson = new Gson();
		ArrayList<Indicador> listaDeIndicadores= new ArrayList<Indicador>();
		try {
			
			// ACA MODIFIQUELA RUTA PARA QUE ME LA TOME
			BufferedReader br = new BufferedReader(new FileReader("C:\\Home\\workspace\\gr13\\IndicadorGSON.json"));
			final Type tipoListaIndicador = new TypeToken<List<Indicador>>(){}.getType();
			listaDeIndicadores = gson.fromJson(br,tipoListaIndicador);

			return listaDeIndicadores;		  
		 } catch (IOException e) {
			 e.printStackTrace();
			 return null;
		 }
		
	}
	
	@Override
	public List<Indicador> find(String nombre) {
		Gson gson = new Gson();
		try 
		 {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Home\\IndicadorGSON.json"));
			final Type tipoListaIndicador = new TypeToken<List<Indicador>>(){}.getType();
			List<Indicador> indicadores =  gson.fromJson(br,tipoListaIndicador);
		    List<Indicador> result = indicadores.stream()   // Convierte la lista en un Stream
			                .filter(indicador -> indicador.getNombre().equals(nombre))  //Filtro segun criterio de nombre
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
	
	public String findFormula(String nombre)
	{
		String formula="";
		ArrayList<Indicador> listaDeIndicadores=this.getAll();
		for(int i=0;i<listaDeIndicadores.size();i++)
		{
			if(listaDeIndicadores.get(i).getNombre().equals(nombre))
			{
				formula=listaDeIndicadores.get(i).getFormula();
			}
		}
	 return formula;
	}
	

}
