package Modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entity.Entidad;
import Entity.Indicador;
import Entity.Metodologia;

public interface DAOGlobal<T> {
	public void add(T objetoT) throws IOException;
	public void delete(String nombre);
	public void update(T objetoT);
	public List<T> getAll();
	public List<T> find(String nombre);
	public T findEntidadWithNombre(String nombre);
}
