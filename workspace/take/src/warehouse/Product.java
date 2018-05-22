package warehouse;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class Product implements Serializable
{
	int idProduct;
	String productName;
	double netPrice;
	double grossPrice;
	String description;
	boolean isAvailable;
	Set<Specimen> specimens = new HashSet<Specimen>();
	@Id
	@GeneratedValue
	@XmlAttribute
	public int getIdOrder() 
	{
		return idProduct;
	}
	@OneToMany
	public Set<Specimen> getSpecimens()
	{
		return specimens;
	}
	public String getProductName()
	{
		return productName;
	}
	public double getNetPrice()
	{
		return netPrice;
	}
	public double getGrossPrice()
	{
		return grossPrice;
	}
	public String getDescription()
	{
		return description;
	}
	public boolean getIsAvailable()
	{
		return isAvailable;
	}
	

	public void setProductName(String name)
	{
		productName = name;
	}
	public void setNetPrice(double price)
	{
		netPrice = price;
	}
	public void setGrossPrice(double price)
	{
		grossPrice = price;
	}
	public void setDescription(String desc)
	{
		description = desc;
	}
	public void setIsAvailable(boolean available)
	{
		isAvailable = available;
	}
}
