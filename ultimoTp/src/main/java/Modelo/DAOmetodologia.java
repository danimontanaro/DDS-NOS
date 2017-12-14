package Modelo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entity.Metodologia;

/*
 * @Author : Grupo 13
 */
public interface DAOmetodologia {

	public void addAllStruct() throws IOException;
    public ArrayList<Metodologia> getAll();
	public void add(Metodologia metodologia) throws IOException;
	public void delete(String nombre);
	public void update(Metodologia metodologia,String nombre);
	public List<Metodologia> find(String desde);
	public void writeArray(ArrayList<Metodologia> lista)  throws IOException;
//	public ArrayList<Cuenta> findCta(ArrayList<Metodologia> listaDeMetodologias,int anioEnInt);
//	public ArrayList<Cuenta> findCtaPorMetodologia(ArrayList<Metodologia> listaDeMetodologias,String fecha, String Metodologia);

}