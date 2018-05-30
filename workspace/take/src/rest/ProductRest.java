package rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

import ejb.ProductEJB;
import entities.Product;

@Path("/product")
@Produces({"application/xml"})
@Consumes({"application/xml"})

public class ProductRest 
{
	@EJB
	ProductEJB bean;
	
	@POST
	@Path("/create")
	public String add(Product product)
	{
		bean.create(product);
		return "Successfully created";
	}
	
	@GET
	@Path("/find/{idProduct}")
	public Product find(@PathParam("idProduct") int idProduct)
	{
		Product product = (Product) bean.find(idProduct);
		return product;
	}
	
	@GET
	@Path("/get")
	public List<Product> get()
	{
		List<Product> products = bean.getProducts();
		return products;
	}
	
	@POST
	@Path("/update")
	public String update(Product product)
	{
		try
		{
			bean.update(product);
			return "Updated";
		}
		catch(Exception ex)
		{
			return "NOT Updated";
		}
	}
	
	@GET
	@Path("/delete/{idProduct}")
	public void delete(@PathParam("idProduct") int idProduct)
	{
		bean.delete(idProduct);
	}
	
	@GET
	@Path("/findbyName/{name}")
	public List<Product> findByName(@PathParam("name") String name)
	{
		List<Product> list = bean.findbyName(name);
		return list;
	}
}
