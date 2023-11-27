package co.in.vwits.dao.imp;

import java.util.List;
import java.util.Optional;

import co.in.vwits.dao.EmpDao;
import co.in.vwits.model.Emp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EmpDaoJpaImpl implements EmpDao{
	
	private EntityManagerFactory factory;
	
	public EmpDaoJpaImpl() {
		factory = Persistence.createEntityManagerFactory("empapp");
	}
	
	@Override
	public List<Emp> findAll() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		String jpql = "FROM Emp";
		TypedQuery<Emp> query = em.createQuery(jpql,Emp.class);
		List<Emp> employeeList = query.getResultList();
		tx.commit();
		em.close();	
		return employeeList;
	}

	@Override
	public void save(Emp e) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e);
		tx.commit();
		em.close();			
	}

	@Override
	public Optional<Emp> findById(int empId) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Emp e = em.find(Emp.class, empId);
		tx.commit();
		em.close();	
		return Optional.of(e);
	}

	@Override
	public void deleteByEmpId(int empId) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Emp.class,empId));
		tx.commit();
		em.close();
	}

	@Override
	public void updateByEmpId(int empId, double modifiedSalary) {
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Emp e = em.find(Emp.class, empId);
		e.setSalary(modifiedSalary);
		em.merge(e);
		tx.commit();
		em.close();		
	}

}
