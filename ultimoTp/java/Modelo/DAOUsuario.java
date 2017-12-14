package Modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entity.Usuario;;

public interface DAOUsuario {
	public void add(Usuario usuario) throws IOException;
	public void delete(String nombre);
	public void update(Usuario usuario,String nombre);
	public ArrayList<Usuario> getAll();
	public List<Usuario> find(String nombre);
	public void addAllStruct() throws IOException;
}
