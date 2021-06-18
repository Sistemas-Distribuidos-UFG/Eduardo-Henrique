package jaxb;

import data.*;
import java.util.*;
import javax.xml.bind.*;
import java.io.*;


public class ProductJAXB {
	public String parsed = null;
	
	Product product_obj = null;
	public ProductJAXB(Product p) 
	{
		product_obj = p;
	}
	
	

	 public void marshall () {
		 try {
			
			
			 JAXBContext jc = JAXBContext.newInstance(Product.class);
			 Marshaller ms = jc.createMarshaller();
			 ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			 
			
			 ms.marshal(product_obj, System.out);
			 ms.marshal(product_obj, new File("src/data/product.xml"));
			
			
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 
	 }
	 
	public void marshallToString() {
			 
		
		try {
			
			JAXBContext jc = JAXBContext.newInstance(Product.class);
			Marshaller ms = jc.createMarshaller();
			StringWriter sw = new StringWriter();
			ms.marshal(product_obj, sw);
			String xmlString = sw.toString();
			System.out.println("xml string, xml string");
			System.out.println(xmlString);
			System.out.println("xml string, xml string");
			
		} catch (Exception e) {
			
		}
			 
		 }
		 
	 
	 public void marshallList () {
		 try {
			 List<Product> listProduct = new ArrayList<Product>();
			 listProduct.add(product_obj);
			 //listProduct.add(new Product("p2", "Name 2", 2000, 3, new Date()));
			 
			 ListProduct lp = new ListProduct();
			 lp.setListProduct(listProduct);
			 JAXBContext jc = JAXBContext.newInstance(ListProduct.class);
			 Marshaller ms = jc.createMarshaller();
			 ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			 String stringList =  listProduct.toString();
			
			 ms.marshal(lp, System.out);
			 System.out.println("=========================");
			
			 ms.marshal(lp,new File("src/data/Listproduct.xml"));
			
			 
			 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 
	 }
	 
	 public String marshallstring() {
	        if (this.product_obj == null) 

	        this.parsed = this.product_obj.getId() +"," + this.product_obj.getName()+ "," +this.product_obj.getPrice() + this.product_obj.getQuantity()+ "," + this.product_obj.getDatecreationlaration();
	 System.out.println(parsed);
	return parsed;  
	 }
	 

	public void unmarshall() {
		
		try {
			
			JAXBContext jc = JAXBContext.newInstance(Product.class);
			Unmarshaller ums = jc.createUnmarshaller(); 
			Product p = (Product)ums.unmarshal(new File("src/data/product.xml"));
			System.out.println("Product Information");
			System.out.println("Id: " +p.getId());
			System.out.println("Name: " + p.getName());
			System.out.println("Price: " +p.getPrice());
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
public void unmarshallList() {
		
		try {
			
			JAXBContext jc = JAXBContext.newInstance(ListProduct.class);
			Unmarshaller ums = jc.createUnmarshaller(); 
			ListProduct lp = (ListProduct)ums.unmarshal(new File("src/data/Listproduct.xml"));
			
			for(Product p : lp.getListProduct()) {
			System.out.println("=========================");
			System.out.println("List Product Information");
			System.out.println("Id: " +p.getId());
			System.out.println("Name: " + p.getName());
			System.out.println("Price: " +p.getPrice());
			System.out.println("=========================");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		

		
	
}



public void marshall(Product p, OutputStream outputStream) {
	// TODO Auto-generated method stub
	
}
	
	
}
