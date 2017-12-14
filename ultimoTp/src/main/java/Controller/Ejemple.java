package Controller;

import java.io.IOException;
import java.util.ArrayList;
import Modelo.*;
import parserIndicadores.GrammarIndicadores;
import Controller.*;
import Entity.Indicador;

import java. util. Scanner;
import java.util.StringTokenizer;

public class Ejemple {
	static GrammarIndicadores parser = null;
	
	public static void main(String[] args) {
		/*String x = "hola,";
		String y = " como estas";
		
		System.out.println(cuentasDeLaFormula(x + y));*/
	//PRUEBAS PARA DAR DE ALTA IDENTIFICADORES
		
//PASOS PARA DAR DE ALTA UN INDICADOR.
		//-1--- INGRESO NOMBRE, - VEO QUE NO EXISTA YA
		//						- VER SINTAXIS(OPCIONAL) 
		//-2---INGRESAR FORMULA, - VER SINTAXIS
		//						 - SI ES CORRECTA OBTENER LISTA DE COMPONENTES
		//						 - DE CADA COMPONENTE HAY QUE VER SI ES:
		//								*UN INDICADOR , VERIFICO QUE EXISTA EN EL JSON DE INDICADORES.
		//								*UNA CUENTA , TENGO QUE VERIFICAR QUE EXISTA EN EL JSON DE EMPRESAS 
		//-3---GUARDAR, SI TODO LO ANTERIOR SE CUMPLE ENTONCES SE GUARDA EN EL JSON DE INDICADORES
		//- SI ALGO NO CUMPLE SE MUESTRA EL MENSAJE DE ERROR Y NO SE GUARDA.
		
//		
//		
//		DAOIndicadorJson daoInd = new DAOIndicadorJson();
//		daoInd.addAllStruct();
//		ArrayList<Indicador> listaDeIndicadores= daoInd.getAll();
//		
//		Indicador indicador =new Indicador();
//		
//		String nombreIndicador= "Prueba";
//		String formulaInd= "(ing + egreso)";
//		
//		
//		
//		if( indicador.existeIndicador(nombreIndicador)){
//			
//			System.out.println("Este nombre de indicador ya existe, ingrese uno diferente");
//			
//			
//		}
//		else {		 
//			System.out.println("guardando");
//			
//			
//		indicador.setNombre(nombreIndicador);
//		indicador.setFormula(formulaInd);
//		  
//		 listaDeIndicadores.add(indicador);
//		
//		
//		 daoInd.escribirArchivo(listaDeIndicadores);}
//		
//		
//		
//		
//		
//		 
//		// for (int i = 0; i < listaDeIndicadores.size(); i++){
//		//		System.out.println(listaDeIndicadores.get(i).getNombre());}
//			
//// PRUEBAS PARA ELIMINAR ALGUN INDICADOR O EMPRESA.....		
//		
//	/*Empresa e = new Empresa();
//	DAOjson	 dao = new DAOjson();
//	dao.addAllStruct();
//	ArrayList<Empresa> listaDeEmpresas= dao.getAll();
//	
//	
////BUSCA una empresa en particular y te devuelve el nro de lugar en donde está en la lista.
//	int a =dao.findEmpresa("Facebook");
//	System.out.println(a); 
//	//Te muestra el nombre de la empresa en la posicion a
//	System.out.println(listaDeEmpresas.get(a).getNombre());
//	
////--------REMOVE--------------
//	listaDeEmpresas.remove(a);
//
////Recorres  la lista y mostras los nombres de los mismos
//	    for (int i = 0; i < listaDeEmpresas.size(); i++){
//		System.out.print(listaDeEmpresas.get(i).getNombre());}
//	
//	
//	
///*	int a = dao.findEmpresa(e.getNombre());
//		
//	listaDeEmpresas.remove(a);
//		
//	dao.escribirArchivo(listaDeEmpresas);
//	
//	System.out.println(e.findEmpresa("Facebook", listaDeEmpresas));
//	System.out.println(e.allNombresEmpresa(listaDeEmpresas));
//	dao.delete(e);
//	 
//	System.out.println(e.allNombresEmpresa(dao.getAll()));
//*/
//	
////-----BORRAR UN INDICADOR  DEL JSON A TRAVES DE SU NOMBRE-----		
//		
///*	Indicador ind = new Indicador();
//	
//	DAOIndicadorJson daoInd = new DAOIndicadorJson();
//	daoInd.addAllStruct();
//	ArrayList<Indicador> listaDeIndicadores= daoInd.getAll();
//	
//	    //---VEO LOS INDICADORES QUE TIENE EL JSON
//	    //for (int i = 0; i < listaDeIndicadores.size(); i++){
//		//System.out.println("1" + listaDeIndicadores.get(i).getNombre());}
//	
//	//daoInd.delete("ROE");
//	
//	//int b = daoInd.findIndicador("ROE");
//	//listaDeIndicadores.remove(b);
//		
//	//for (int i = 0; i < listaDeIndicadores.size(); i++){
//	//	System.out.println("2" + listaDeIndicadores.get(i).getNombre());}
//	
//	daoInd.escribirArchivo(listaDeIndicadores);*/
//	
//	// ME permite ver lo que hay en el dao luego de haber borrado algo.
//	ArrayList<Indicador> lista= daoInd.getAll();
//
//	for (int i = 0; i < lista.size(); i++){
//		System.out.println("3" + lista.get(i).getNombre());}	
//	
/*	}
	public static ArrayList<String> cuentasDeLaFormula(String formula)
	{
		
		int i=0;
		String word;
		StringTokenizer elementos,subelementos;
		ArrayList<String> palabra= new ArrayList<String>();
		elementos = new StringTokenizer(formula,"(+/*-)");
		while(elementos.hasMoreTokens()){
		  word = elementos.nextToken();
		  i=1;
		  subelementos = new StringTokenizer(word,",");
		  while(subelementos.hasMoreTokens()){
		    palabra.add( subelementos.nextToken());
		    
		    i++;
		  }
		}
		return palabra;*/
		
		
		
		
		
		DAOIndicadorJson daoInd = new DAOIndicadorJson();
		//daoInd.addAllStruct();
		ArrayList<Indicador> listaDeIndicadores= daoInd.getAll();
		
		Indicador indicador =new Indicador();
		indicador.setNombre("Indicado");
		indicador.setFormula("vhbvhsd+dsvsdv");
		indicador.setSePuedeBorrar(false);
		
		if(daoInd.findIndicador(indicador.getNombre())==0){
			listaDeIndicadores.add(indicador);
			daoInd.escribirArchivo(listaDeIndicadores);
		}
		else{
			System.out.println("Ese nombre ya existe");
		}
		/*for (int i = 0; i < listaDeIndicadores.size(); i++){
		System.out.println("2" + listaDeIndicadores.get(i).getNombre());}
		
		System.out.println("ingrese nombre");
		
		 String nombreIndicador = "";
	     Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
	     nombreIndicador = entradaEscaner.nextLine ();*/
		
	     
		
		//String nombreIndicador= "Prueb";
		//String formulaInd= "(ing + egreso)";
		
		
		
		/*if( indicador.existeIndicador(nombreIndicador)){
			
			System.out.println("Este nombre de indicador ya existe, ingrese uno diferente");
			
			
		}
		else {		 
			System.out.println("ingrese formula");
	     String formulaInd = "";
	        Scanner entrada = new Scanner (System.in); //Creación de un objeto Scanner
	        formulaInd = entrada.nextLine ();
			System.out.println("guardando");
			
			
		indicador.setNombre(nombreIndicador);
		indicador.setFormula(formulaInd);
		indicador.setSePuedeBorrar(true);
		  
		 listaDeIndicadores.add(indicador);
		
		
		 daoInd.escribirArchivo(listaDeIndicadores);}
		
		// ME permite ver lo que hay en el dao luego de haber borrado algo.
		ArrayList<Indicador> lista= daoInd.getAll();

		for (int i = 0; i < lista.size(); i++){
			System.out.println("3" + lista.get(i).getNombre());}	*/
		
	}
}
