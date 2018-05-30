package ejb;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

import entities.Order;
import entities.Product;
@Stateless
public class OrderEJB 
{
	@PersistenceContext(name="warehouse")
	EntityManager manager;
	
	public void create(Order order)
	{
		manager.persist(order);
	}
	
	public void delete(int idOrder)
	{
		Order order = manager.find(Order.class, idOrder);
		manager.remove(order);
	}
	
	public Order find(int idOrder)
	{
		Order order = manager.find(Order.class, idOrder);
		return order;
	}
	
	public List<Order> getOrders()
	{
		Query query = manager.createQuery("select o from Order o");
		@SuppressWarnings("unchecked")
		List<Order> list = query.getResultList();
		return list;
	}
	
	public void update(Order order)
	{
		order = manager.merge(order);
	}
	
	public List<Order> findByClient(int idClient)
	{
		Query query = manager.createQuery("selec o from Order o where o.Client.idClient like :idClient");
		query.setParameter("idClient", idClient);
		@SuppressWarnings("unchecked")
		List<Order> list = query.getResultList();
		return list;
	}
}
