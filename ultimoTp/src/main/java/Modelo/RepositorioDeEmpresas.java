package Modelo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entity.Cuenta;
import Entity.Empresa;
import Modelo.DAOEmpresa;

public class RepositorioDeEmpresas {

	private List<Empresa> Lista;
	private DAOGlobalMYSQL<Empresa> dao;

	public RepositorioDeEmpresas(DAOGlobalMYSQL<Empresa> daoE){
		this.dao = daoE;
		
	}

	public void add(Empresa empresa) throws IOException{
		this.dao.add(empresa);
	}

	public void delete(String nombre){
		this.dao.delete(nombre);
	}

	public List<Empresa> getLista(){
		return this.dao.getAll();
	}

	public void setLista(List<Empresa> lista) {
		Lista = lista;
	}

	public void update(Empresa empresa){
		this.dao.update(empresa);
	}
	
	public List<Empresa> find(String desde){
		return this.dao.find(desde);
	}

	public Empresa findEmpresa(String nombre){
		return this.dao.findEntidadWithNombre(nombre);
	}

}