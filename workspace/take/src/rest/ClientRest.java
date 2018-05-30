package rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ejb.ClientEJB;
import entities.Client;
import java.util.List;

@Path("/client")
@Produces({"application/xml"})
@Consumes({"application/xml"})

public class ClientRest 
{
	@EJB
	ClientEJB bean;
	
	@POST
	@Path("/create")
	public String add(Client client)
	{
		bean.create(client);
		return "Clien has been successfully created";
	}
	
	@GET
	@Path("/find/{idClient}")
	public Client find(@PathParam("idClient") int idClient)
	{
		Client client = (Client) bean.find(idClient);
		return client;
	}
	
	@GET
	@Path("/get")
	public List<Client> get()
	{
		List<Client> listClient = bean.getClients();
		return listClient;
	}
	
	@POST
	@Path("/update")
	public String update(Client client)
	{
		try
		{
			bean.update(client);
			return "Updated";
		}
		catch(Exception ex)
		{
			return "NOT Updated";
		}
	}
	
	@GET
	@Path("/delete/{idClient}")
	public void delete(@PathParam("idClient") int idClient)
	{
		bean.delete(idClient);
	}
}
