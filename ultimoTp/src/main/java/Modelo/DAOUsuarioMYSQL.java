package Modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entity.Usuario;
import db.EntityManagerHelper;

public class DAOUsuarioMYSQL implements DAOUsuario {

	@Override
	public void add(Usuario usuario) throws IOException {
		// TODO Auto-generated method stub
		EntityManager entityManager= EntityManagerHelper.getEntityManager();
		EntityManagerHelper.beginTransaction();
		try
		{
			entityManager.persist(usuario);
			entityManager.flush();
			EntityManagerHelper.commit();	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			EntityManagerHelper.rollback();
		}
		
	}

	@Override
	public void delete(String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Usuario usuario, String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> find(String nombre) {
//		EntityManager em = EntityManagerHelper.entityManager();
//		Usuario usuario = (Usuario) em.find(Usuario.class, nombre);
//		List<Usuario> usuarios= null;
//		usuarios.add(usuario);
		return null;
	}
	public Usuario findPorId(int id) {
		EntityManager em = EntityManagerHelper.entityManager();
		Usuario usuario = (Usuario) em.find(Usuario.class, id);
		return usuario;
	}

	@Override
	public void addAllStruct() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
