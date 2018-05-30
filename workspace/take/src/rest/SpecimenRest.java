package rest;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ejb.SpecimenEJB;
import entities.Specimen;

@Path("/specimen")
@Produces({"application/xml"})
@Consumes({"application/xml"})
public class SpecimenRest 
{
	@EJB
	SpecimenEJB bean;
	@POST
	@Path("/create")
	public String add(Specimen specimen)
	{
		bean.create(specimen);
		return "Specimen has been successfully created";
	}
	
	@GET
	@Path("/find/{idSpecimen}")
	public Specimen find(@PathParam("idSpecimen") int idSpecimen)
	{
		Specimen specimen  = (Specimen) bean.find(idSpecimen);
		return specimen;
	}
	
	@GET
	@Path("/get")
	public List<Specimen> get()
	{
		List<Specimen> list = bean.getSpecimens();
		return list;
	}
	
	@POST
	@Path("/update")
	public String update(Specimen specimen)
	{
		try
		{
			bean.update(specimen);
			return "Updated";
		}
		catch(Exception ex)
		{
			return "NOT Updated";
		}
	}
	
	@GET
	@Path("/delete/{idSpecimen}")
	public void delete(@PathParam("idSpecimen") int idSpecimen)
	{
		bean.delete(idSpecimen);
	}
	
	@GET
	@Path("/find/product/{idProduct}")
	public List<Specimen> findByProduct(@PathParam("idProduct") int idProduct)
	{
		List<Specimen> list = bean.findByProduct(idProduct);
		return list;
	}
	
	@GET
	@Path("/find/warehouse/{idWarehouse}")
	public List<Specimen> findByWarehouse(@PathParam("idWarehouse") int idWarehouse)
	{
		List<Specimen> list = bean.findByProduct(idWarehouse);
		return list;
	}
}
