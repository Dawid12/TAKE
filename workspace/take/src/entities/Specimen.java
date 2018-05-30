package entities;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Specimen implements Serializable
{
	int idSpecimen;
	String dateOfPurchase;
	Product product;
	Warehouse warehouse;	
	Set<Order_Product> orderProduct = new HashSet<Order_Product>();

	@Id
	@GeneratedValue
	@XmlAttribute
	public int getIdSpecimen() 
	{
		return idSpecimen;
	}
	public String getDateOfPurchase()
	{
		return dateOfPurchase;
	}
	public void setDateOfPurchase(String date)
	{
		dateOfPurchase = date;
	}
	@ManyToOne
	public Product getProduct()
	{
		return product;
	}
	public void setProduct(Product product)
	{
		this.product = product;
	}
	@ManyToOne
	public Warehouse getWarehouse()
	{
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse)
	{
		this.warehouse = warehouse;
	}
	@OneToMany
	public Set<Order_Product> getOrderProduct()
	{
		return orderProduct;
	}
}
