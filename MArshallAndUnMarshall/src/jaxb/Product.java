package jaxb;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "product")

//@XmlRootElement(name = "products")
public class Product {

	private String id;
	private String name;
	private double price;
	private int quantity;
	private Date datecreation;
	
	
	@XmlElement
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@XmlElement
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@XmlElement
	public Date getDatecreationlaration() {
		return datecreation;
	}
	public void setDatecreationlaration(Date datecreation) {
		this.datecreation = datecreation;
	}
	
	public Product(String id, String name, double price, int quantity, Date datecreation) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.datecreation = datecreation;
	}
	public Product() {
		super();
	}
	
}
