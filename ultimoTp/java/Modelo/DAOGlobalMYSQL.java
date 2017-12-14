package Modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import Entity.Cuenta;
import Entity.Empresa;
import Entity.Entidad;
import Entity.Indicador;
import Entity.Periodo;
import Entity.Usuario;
import db.EntityManagerHelper;

public class DAOGlobalMYSQL<T> implements DAOGlobal<T>{

	private EntityManager entityManager;
	private List<T> lista;
	private Class<T> entityClass;
	
	public DAOGlobalMYSQL(Class<T> a){
		super();
		entityClass=a;
	}
	
	public DAOGlobalMYSQL(){}
	
	@Override
	public void add(T objetoT) throws IOException {
		
		EntityManager entityManager= EntityManagerHelper.getEntityManager();
		EntityManagerHelper.beginTransaction();
		try
		{
			entityManager.persist(objetoT);
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
		Entidad entidad = entityManager.find(Entidad.class, 1);		 
		entityManager.getTransaction().begin();
		entityManager.remove(entidad);
		entityManager.getTransaction().commit();
	}

	public Usuario findPorId(int id) {
		EntityManager em = EntityManagerHelper.entityManager();
		Usuario usuario = (Usuario) em.find(Usuario.class, id);
		return usuario;
	}
	public boolean existeUsuarioYContraseña(String nombre,String contraseña) {
		EntityManager em = EntityManagerHelper.entityManager();
	return em.createNativeQuery("select nombre from redinversiones.usuario where contraseña='" +contraseña+"'").getResultList().contains(nombre);
		
	}
	public ArrayList<Indicador> getIndicadores(String empresaB,String periodoDesde,String periodoHasta) {
		EntityManager em = EntityManagerHelper.entityManager();
		return  (ArrayList<Indicador>) em.createNativeQuery("select * from indicador",Indicador.class).getResultList();

	}
	public boolean sePuedeBorrarIndicador(String nombreIndicador) {
		EntityManager em = EntityManagerHelper.entityManager();
		return em.createNativeQuery("select sePuedeBorrar from indicador where nombre= '"+nombreIndicador+"'").getSingleResult().equals(false);
	}
	public void borrarIndicador(String nombreIndicador) {
		EntityManager em = EntityManagerHelper.entityManager();
		EntityManagerHelper.beginTransaction();
		 em.createNativeQuery("delete from indicador where nombre= '"+nombreIndicador+"'").executeUpdate();
		 em.flush();
		EntityManagerHelper.commit();		 
		 //Indicador foo= new Indicador();
//		
//		 foo = em.find(Indicador.class, foo.getIdByName(nombreIndicador));
//		 em.remove(foo);

	}
	public ArrayList<Empresa> getAllEmp(){
		EntityManager em = EntityManagerHelper.entityManager();
		ArrayList<Empresa> emp= new ArrayList<Empresa>();
		//emp=em.createNativeQuery("select * from redinversiones.empresa").getResultList();
		
		return (ArrayList<Empresa>) em.createNativeQuery("select * from empresa",Empresa.class).getResultList();

	}
	public ArrayList<Cuenta> getCuentas(String empresaB,String periodoDesde,String periodoHasta) {
		EntityManager em = EntityManagerHelper.entityManager();
		return  (ArrayList<Cuenta>) em.createNativeQuery("select c.id, c.nombre,c.valor from empresa e join cuenta_empresa ce on (ce.empresas_id=e.id) join periodo p on (p.cuenta_empresa=ce.id) join cuenta c on(c.id=ce.cuentas_cuenta_id) where e.nombre ='"+empresaB+"' and  p.desde='"+periodoDesde+"' and  p.hasta= '"+periodoHasta+"'",Cuenta.class).getResultList();

	}
	public Empresa findEmpresa(String empresaB)
	{
		EntityManager em = EntityManagerHelper.entityManager();
		return (Empresa) em.createNativeQuery("select * from empresa e where e.nombre='"+empresaB+"'"
                                     ,Empresa.class).getSingleResult();

	}
	
	//FormaGenral de buscar
	public ArrayList<Periodo> getAllPeriodos() {
		EntityManager em = EntityManagerHelper.entityManager();
		ArrayList<Periodo> per= new ArrayList<Periodo>();
		return (ArrayList<Periodo>) em.createNativeQuery("select  id,desde,hasta,valorCuenta,cuenta_empresa,cuenta_id from periodo",Periodo.class).getResultList();

	}
	public ArrayList<Periodo> getAllPeriodo() {
		EntityManager em = EntityManagerHelper.entityManager();
		return (ArrayList<Periodo>) em.createNativeQuery("select * from periodo",Periodo.class).getResultList();

	}
	//public List<T>
	public ArrayList<Indicador> getAllIndicadores() {
		EntityManager em = EntityManagerHelper.entityManager();
		return  (ArrayList<Indicador>) em.createNativeQuery("select * from indicador",Indicador.class).getResultList();

		
	}

	@Override
	public void update(T objetoT) {
		entityManager.merge(objetoT);	
	}

	@Override
	public List<T> getAll() {
		//System.out.println("AAAH "+entityClass.toString());
		entityManager= EntityManagerHelper.getEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(entityClass);
		criteria.from(entityClass);
		return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	public List<T> find(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findEntidadWithNombre(String nombre) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadEntidades");
//		entityManager = emf.createEntityManager();
//		T entidad = entityManager.find(entityClass, nombre);
//		return entidad;
		entityManager = EntityManagerHelper.entityManager();
		return (T) entityManager.createNativeQuery("select * from empresa e where e.nombre='"+nombre+"'"
                                     ,entityClass).getSingleResult();
	}
	

}
