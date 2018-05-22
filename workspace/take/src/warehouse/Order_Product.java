package warehouse;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Order_Product implements Serializable
{
	int idOrderProduct;
	Specimen specimen;
	Order order;
	
	@Id
	@GeneratedValue
	@XmlAttribute
	public int getIdOrderProduct() 
	{
		return idOrderProduct;
	}
	@ManyToOne
	public Specimen getSpecimen()
	{
		return specimen;
	}
	public void setSpecimen(Specimen specimen)
	{
		this.specimen = specimen;
	}
	@ManyToOne
	public Order getOrder()
	{
		return order;
	}
	public void setOrder(Order order)
	{
		this.order = order;
	}
}
