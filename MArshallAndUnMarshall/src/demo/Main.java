package demo;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.Socket;
import java.security.spec.MGF1ParameterSpec;
import java.util.Date;
import java.util.Scanner;

import javax.xml.stream.XMLOutputFactory;

import jaxb.*;

import data.*;


public class Main {

	
	public static void main(String []args) {
		
//		ProductJAXB parsing = new ProductJAXB();
//		parsing.marshall();
//		parsing.unmarshall();
		//parsing.marshallList();
		//parsing.unmarshallList();
		
	    ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Scanner scanner = new Scanner(System.in);
		
		
		
		try {
			
		 
            Socket socket = new Socket("127.0.0.1", 1234);
            System.out.println("[*] O cliente se conectou ao servidor!");
            
            
            System.out.print("Nome: ");
            String name = scanner.nextLine();

            System.out.print("ID: ");
            String id =  scanner.nextLine();

            System.out.print("Preço: ");
            double price = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Quantidade: ");
            int quantity =  scanner.nextInt();
            
            Date datecreation = new Date();
            
            
           
		    Product p = new Product(name, id, price, quantity, datecreation );
		    ProductJAXB  objMsgToMarshall = new ProductJAXB(p) ;
		    OutputStream outputStream = socket.getOutputStream();
		    objMsgToMarshall.marshall(p ,outputStream);
		    //objMsgToMarshall.marshall();
		    //objMsgToMarshall.unmarshallList();
		    //objMsgToMarshall.marshallList();
		   //objMsgToMarshall.marshallstring();
		   
		   File xml = new File ("src/data/Listproduct.xml");
		  
		   //String msgToServer = objMsgToMarshall.marshallstring();
		   oos = new ObjectOutputStream(socket.getOutputStream());
		   oos.writeObject(xml);
		   //
            
//           // Parsing objMsgToServer = new Parsing(msg);
//            String msgToServer = objMsgToMarshall.GetParsedString();
//
//            oos = new ObjectOutputStream(socket.getOutputStream());
//
//            System.out.println("[*] Sending request to Socket Server");
//            
//
//            ois = new ObjectInputStream(socket.getInputStream());
//            String message = (String) ois.readObject();
//            
//            System.out.println("Message: " + message);

		} catch (Exception e) {
			
		}
	
}}
	

