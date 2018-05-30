package entities;
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
public class Client implements Serializable
{
	int idClient;
	String login;
	String password;
	String firstName;
	String lastName;
	String phoneNumber;
	Set<Order> orders = new HashSet<Order>();
	@Id
	@GeneratedValue
	@XmlAttribute
	public int getIdClient() 
	{
		return idClient;
	}
	@OneToMany
	public Set<Order> getOrders()
	{
		return orders;
	}
	public String getLogin()
	{
		return login;
	}
	public String getPassword()
	{
		return password;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setLogin(String log)
	{
		login = log;
	}
	public void setPassword(String pass)
	{
		password = pass;
	}
	public void setFirstName(String name)
	{
		firstName = name;
	}
	public void setLastName(String name)
	{
		lastName = name;
	}
	public void stPhoneNumber(String number)
	{
		phoneNumber = number;
	}
}
