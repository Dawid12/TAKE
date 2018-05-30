package ejb;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

import entities.Product;
import entities.Warehouse;

@Stateless
public class WarehouseEJB 
{
	@PersistenceContext(name="warehouse")
	EntityManager manager;
	
	public void create(Warehouse warehouse)
	{
		manager.persist(warehouse);
	}
	
	public void delete(int idWarehouse)
	{
		Warehouse warehouse = manager.find(Warehouse.class, idWarehouse);
		manager.remove(warehouse);
	}
	
	public Warehouse find(int idWarehouse)
	{
		Warehouse warehouse = manager.find(Warehouse.class, idWarehouse);
		return warehouse;
	}
	
	public List<Warehouse> getWarehouses()
	{
		Query query = manager.createQuery("select w from Warehouse w");
		@SuppressWarnings("unchecked")
		List<Warehouse> list = query.getResultList();
		return list;
	}
	
	public void update(Warehouse warehouse)
	{
		warehouse = manager.merge(warehouse);
	}
	
	public List<Warehouse> findbyId(int id)
	{
		Query query = manager.createQuery("select w from Warehouse w where w.idWarehouse like :id");
		query.setParameter("name", id);
		@SuppressWarnings("unchecked")
		List<Warehouse> list = query.getResultList();
		return list;
	}
	
	public List<Warehouse> findByCity(String city)
	{
		Query query = manager.createQuery("select p from Product p where w.city like :city");
		query.setParameter("name",city);
		@SuppressWarnings("unchecked")
		List<Warehouse> list = query.getResultList();
		return list;
	}
}
