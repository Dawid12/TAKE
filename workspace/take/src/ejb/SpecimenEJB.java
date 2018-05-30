package ejb;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

import entities.Order;
import entities.Product;
import entities.Specimen;

@Stateless
public class SpecimenEJB 
{
	@PersistenceContext(name="warehouse")
	EntityManager manager;
	
	public void create(Specimen specimen)
	{
		manager.persist(specimen);
	}
	
	public void delete(int idSpecimen)
	{
		Specimen specimen = manager.find(Specimen.class, idSpecimen);
		manager.remove(specimen);
	}
	
	public Specimen find(int idSpecimen)
	{
		Specimen specimen = manager.find(Specimen.class, idSpecimen);
		return specimen;
	}
	
	public List<Specimen> getSpecimens()
	{
		Query query = manager.createQuery("select s from Specimen s");
		@SuppressWarnings("unchecked")
		List<Specimen> list = query.getResultList();
		return list;
	}
	
	public void update(Specimen specimen)
	{
		specimen = manager.merge(specimen);
	}
	
	public List<Specimen> findById(int id)
	{
		Query query = manager.createQuery("select s from Specimen s where s.idSpecimen like :id");
		query.setParameter("name", id);
		@SuppressWarnings("unchecked")
		List<Specimen> list = query.getResultList();
		return list;
	}
	
	public List<Specimen> findByProduct(int idProduct)
	{
		Query query = manager.createQuery("selec s from Specimen s where s.Product.idProduct like :idProduct");
		query.setParameter("idClient", idProduct);
		@SuppressWarnings("unchecked")
		List<Specimen> list = query.getResultList();
		return list;
	}
	
	public List<Specimen> findByWarehouse(int idWarehouse)
	{
		Query query = manager.createQuery("selec s from Specimen s where s.Warehouse.idWarehouse like :idWarehouse");
		query.setParameter("idClient", idWarehouse);
		@SuppressWarnings("unchecked")
		List<Specimen> list = query.getResultList();
		return list;
	}

}
