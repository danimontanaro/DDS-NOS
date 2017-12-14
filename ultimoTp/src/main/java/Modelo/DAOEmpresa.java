package Modelo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entity.Cuenta;
import Entity.Empresa;

/*
 * @Author : Grupo 13
 */
public interface DAOEmpresa {

	public void addAllStruct() throws IOException;
    public ArrayList<Empresa> getAll();
	public void add(Empresa empresa) throws IOException;
	public void delete(Empresa empresa);
	public void update(Empresa empresa,String nombre);
	public List<Empresa> find(String desde,String hasta);
//	public ArrayList<Cuenta> findCta(ArrayList<Empresa> listaDeEmpresas,int anioEnInt);
	public ArrayList<Cuenta> findCtaPorEmpresa(ArrayList<Empresa> listaDeEmpresas,String fecha, String empresa);

}