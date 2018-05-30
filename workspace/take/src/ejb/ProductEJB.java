package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

import entities.Product;

@Stateless
public class ProductEJB 
{
	@PersistenceContext(name="warehouse")
	EntityManager manager;
	
	public void create(Product product)
	{
		manager.persist(product);
	}
	
	public void delete(int idProduct)
	{
		Product product = manager.find(Product.class, idProduct);
		manager.remove(product);
	}
	
	public Product find(int idProduct)
	{
		Product product = manager.find(Product.class, idProduct);
		return product;
	}
	
	public List<Product> getProducts()
	{
		Query query = manager.createQuery("select p from Product p");
		@SuppressWarnings("unchecked")
		List<Product> list = query.getResultList();
		return list;
	}
	
	public void update(Product product)
	{
		product = manager.merge(product);
	}

	public List<Product> findbyName(String name)
	{
		Query query = manager.createQuery("select p from Product p where p.productName like :name");
		query.setParameter("name", name);
		@SuppressWarnings("unchecked")
		List<Product> list = query.getResultList();
		return list;
	}
}
