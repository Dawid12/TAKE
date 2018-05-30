package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ejb.OrderEJB;
import entities.Client;
import entities.Order;

@Path("/order")
@Produces({"application/xml"})
@Consumes({"application/xml"})
public class OrderRest 
{
	@EJB
	OrderEJB bean;
	@POST
	@Path("/create")
	public String add(Order order)
	{
		bean.create(order);
		return "Oder has been successfully created";
	}
	
	@GET
	@Path("/find/{idOrder}")
	public Order find(@PathParam("idOrder") int idOrder)
	{
		Order order = (Order) bean.find(idOrder);
		return order;
	}
	
	@GET
	@Path("/get")
	public List<Order> get()
	{
		List<Order> list = bean.getOrders();
		return list;
	}
	
	@POST
	@Path("/update")
	public String update(Order order)
	{
		try
		{
			bean.update(order);
			return "Updated";
		}
		catch(Exception ex)
		{
			return "NOT Updated";
		}
	}
	
	@GET
	@Path("/delete/{idOrder}")
	public void delete(@PathParam("idOrder") int idOrder)
	{
		bean.delete(idOrder);
	}
	
	@GET
	@Path("/find/client/{idClient}")
	public List<Order> findByClient(@PathParam("idClient") int idClient)
	{
		List<Order> list = bean.findByClient(idClient);
		return list;
	}
}
