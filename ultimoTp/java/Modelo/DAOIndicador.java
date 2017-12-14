package Modelo;

import java.io.IOException;
import java.util.*;
import Controller.*;
import Entity.Indicador;


public interface DAOIndicador {
	public void add(Indicador indicador) throws IOException;
	public void delete(String nombre);
	public void update(Indicador indicador,String nombre);
	public ArrayList<Indicador> getAll();
	public List<Indicador> find(String nombre);
	public void addAllStruct() throws IOException;
}
