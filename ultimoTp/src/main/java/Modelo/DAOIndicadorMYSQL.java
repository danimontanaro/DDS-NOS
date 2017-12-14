package Modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import Entity.Indicador;
import db.EntityManagerHelper;

public class DAOIndicadorMYSQL implements DAOIndicador {

	@Override
	public void add(Indicador indicador) throws IOException {
		EntityManager entityManager= EntityManagerHelper.getEntityManager();
		EntityManagerHelper.beginTransaction();
		try
		{
			entityManager.persist(indicador);
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
		Indicador indicador= new Indicador();
		indicador= (Indicador) this.find(nombre);
		indicador.setSePuedeBorrar(false);
		EntityManager entityManager= EntityManagerHelper.getEntityManager();
		EntityManagerHelper.beginTransaction();
		try
		{
			entityManager.refresh(indicador);
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
	public void update(Indicador Oindicador, String nombre) {
		Indicador indicador= new Indicador();
		indicador= (Indicador) this.find(nombre);
		EntityManager entityManager= EntityManagerHelper.getEntityManager();
		EntityManagerHelper.beginTransaction();
		try
		{
			entityManager.refresh(Oindicador);
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
	public ArrayList<Indicador> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Indicador> find(String _nombre) {
		String consulta= "SELECT I FROM indicador as I WHERE I.nombre LIKE _nombre";
		EntityManager entityManager= EntityManagerHelper.getEntityManager();
		Query query=  EntityManagerHelper.getEntityManager().createQuery(consulta);
		
		return query.getResultList();
	}

	@Override
	public void addAllStruct() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
