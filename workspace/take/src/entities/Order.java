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
public class Order implements Serializable
{
	int idOrder;
	String dateOfAcceptance;
	String dateOfSubmission;
	String sendDate;
	Client client;
	Set<Order_Product> orderProduct = new HashSet<Order_Product>();
	
	@Id
	@GeneratedValue
	@XmlAttribute
	public int getIdOrder() 
	{
		return idOrder;
	}
	@ManyToOne
	public Client getClient()
	{
		return client;
	}
	public void setClient(Client client)
	{
		this.client = client;
	}
	public String getDateOfAcceptance()
	{
		return dateOfAcceptance;
	}
	public String getDateOfSubmission()
	{
		return dateOfSubmission;
	}
	public String getSendDate()
	{
		return sendDate;
	}
	public void setDateOfAcceptance(String date)
	{
		dateOfAcceptance = date;
	}
	public void setDateOfSubmission(String date)
	{
		dateOfSubmission = date;
	}
	public void setSendDate(String date)
	{
		sendDate = date;
	} 
	@OneToMany
	public Set<Order_Product> getOrderProduct()
	{
		return orderProduct;
	}

}
