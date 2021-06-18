package jaxb;

import  java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "products")
public class ListProduct {

	
	private List <Product> listProduct = new ArrayList<Product>();

	@XmlElement ( name = "product")
	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}
	 
	
}
