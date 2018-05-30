package rest;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ejb.WarehouseEJB;
import entities.Warehouse;

import java.util.List;

@Path("/warehouse")
@Produces({"application/xml"})
@Consumes({"application/xml"})
public class WarehouseRest 
{
	@EJB
	WarehouseEJB bean;
	
	@POST
	@Path("/create")
	public String add(Warehouse warehouse)
	{
		bean.create(warehouse);
		return "Warehouse has been successfully created";
	}
	@GET
	@Path("/find/{idWarehouse}")
	public Warehouse find(@PathParam("idWarehouse") int idWarehouse)
	{
		Warehouse warehouse = (Warehouse) bean.find(idWarehouse);
		return warehouse;
	}
	
	@GET
	@Path("/get")
	public List<Warehouse> get()
	{
		List<Warehouse> list = bean.getWarehouses();
		return list;
	}
	
	@POST
	@Path("/update")
	public String update(Warehouse warehouse)
	{
		try
		{
			bean.update(warehouse);
			return "Updated";
		}
		catch(Exception ex)
		{
			return "NOT Updated";
		}
	}
	
	@GET
	@Path("/delete/{idWarehouse}")
	public void delete(@PathParam("idWarehouse") int idWarehouse)
	{
		bean.delete(idWarehouse);
	}
	
	@GET
	@Path("/find/{idWarehouse}")
	public List<Warehouse> findById(@PathParam("idWarehouse") int idWarehouse)
	{
		List<Warehouse> list = bean.findbyId(idWarehouse);
		return list;
	}
	
	@GET
	@Path("/find/{city}")
	public List<Warehouse> findByCity(@PathParam("city") String city)
	{
		List<Warehouse> list = bean.findByCity(city);
		return list;
	}
}
