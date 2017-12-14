package Modelo;
import Controller.*;
import java.io.IOException;
import java.util.*;

import Controller.Cuenta;
import Controller.Empresa;

public class RepositorioDeIndicadores {
	
	private DAOIndicador daoIndicador;
	
	public RepositorioDeIndicadores(DAOIndicador dao){
		this.daoIndicador = dao;		
	}

	public void add(Indicador indicador) throws IOException{
		this.daoIndicador.add(indicador);
	}

	public void delete(Indicador indicador){
		this.daoIndicador.delete(indicador);
	}

	public ArrayList<Indicador> getAll() throws IOException{
		return this.daoIndicador.getAll();
	}

	
	public void update(Indicador indicador,String nombre){
		this.daoIndicador.update(indicador, nombre);
	}	
	
	public List<Indicador> find(String nombre){
		return this.daoIndicador.find(nombre);
	}
	
	public void addAllStruct() throws IOException
	{
		this.daoIndicador.addAllStruct();
	

}}
