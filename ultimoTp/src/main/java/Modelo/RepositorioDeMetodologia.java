package Modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entity.Metodologia;

public class RepositorioDeMetodologia {
	
	private List<Metodologia> Lista;
	private DAOGlobalMYSQL<Metodologia> daometodologia;

	public RepositorioDeMetodologia(DAOGlobalMYSQL<Metodologia> dao){
		this.daometodologia = dao;
		this.setLista(dao.getAll());
	}
	
	public List<Metodologia> getLista() {
		return Lista;
	}

	public void setLista(List<Metodologia> lista) {
		Lista = lista;
	}

	public void add(Metodologia metodologia) throws IOException{
		this.daometodologia.add(metodologia);
	}

	public void delete(String nombre){
		this.daometodologia.delete(nombre);
	}

	public List<Metodologia> getAllmetodologias(){
		return this.daometodologia.getAll();
	}

	
	public void update(Metodologia metodologia){
		this.daometodologia.update(metodologia);
	}

	public List<Metodologia> find(String desde){
		return this.daometodologia.find(desde);
	}
	
	public Metodologia findMetodologia(String nombre){
		return this.daometodologia.findEntidadWithNombre(nombre);
	}
	
//	public void writeArray(ArrayList<Metodologia> lista) throws IOException{
//		this.daometodologia.writeArray(lista);
//	}
}                    