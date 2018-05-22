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
public class Warehouse implements Serializable
{
	int idWarehouse;
	String country;
	String city;
	String street;
	int numberOfBuilding;
	Set<Specimen> specimens = new HashSet<Specimen>();
	@Id
	@GeneratedValue
	@XmlAttribute
	public int getIdWarehouse() 
	{
		return idWarehouse;
	}
	@OneToMany
	public Set<Specimen> getSpecimens()
	{
		return specimens;
	}
	public String getCountry()
	{
		return country;
	}
	public String getCity()
	{
		return city;
	}
	public String getStreet()
	{
		return street;
	}
	public int getNumberOfBuilding()
	{
		return numberOfBuilding;
	}
	
	public void setCountry(String country_)
	{
		country = country_;
	}
	public void setCity(String city_)
	{
		city = city_;
	}
	public void setStreet(String str)
	{
		street = str;
	}
	public void setNumberOfBuilding(int number)
	{
		numberOfBuilding = number;
	}
}
