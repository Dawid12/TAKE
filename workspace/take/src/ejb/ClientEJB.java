package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

import entities.Client;

@Stateless
public class ClientEJB 
{
	@PersistenceContext(name="warehouse")
	EntityManager manager;
	
	public void create(Client client)
	{
		manager.persist(client);
	}
	
	public Client find(int idClient)
	{
		Client client = manager.find(Client.class, idClient);
		return client;
	}
	
	public List<Client> getClients()
	{
		Query query = manager.createQuery("select c from Client c");
		@SuppressWarnings("unchecked")
		List<Client> list = query.getResultList();
		return list;
	}
	
	public void update(Client client)
	{
		client = manager.merge(client);
	}
	
	public void delete(int id)
	{
		Client client = manager.find(Client.class, id);
		manager.remove(client);
	}
}
