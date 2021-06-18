package demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import jaxb.*;
import data.*;

public class servidor {
	public static void main (String args[], String xml) throws IOException 
    {
        try {
            ServerSocket servidorSocket = new ServerSocket(1234);

            while(true) {
                ObjectInputStream ois = null;
                ObjectOutputStream oos = null;

                System.out.println("[*] Esperando conexões");

                Socket socket = servidorSocket.accept();
                System.out.println("[*] Cliente conectado!");
                
                ois = new ObjectInputStream(socket.getInputStream());
                //String strMessage = (String) ois.readObject();
                FileOutputStream fos = new FileOutputStream(xml);
                System.out.println("Servidor");
                System.out.println();
                System.out.println("Servidor");
                //Product pro = new Product (strMessage);
//                //Parsing objMsgOfClient = new Parsing(strMessage);
//               // Message msg = objMsgOfClient.GetMessageObj();
//
//                // Manipula o objeto msg
//                if ( msg.cargo .equals("Operador") ) {
//                float reajuste = (msg.salario *2);
//                msg.salario = reajuste + msg.salario;
//                objMsgOfClient.UpdateMsg(msg);
//                }
//                else    {
//                	float reajuste = (float) (msg.salario *0.3);
//                    msg.salario = reajuste + msg.salario;
//                    objMsgOfClient.UpdateMsg(msg);
//                	
//                }

                
                
                oos = new ObjectOutputStream(socket.getOutputStream());
              //  oos.writeObject(objMsgOfClient.GetParsedString());

                ois.close();
                oos.close();
                socket.close();
            }

        } catch (Exception e) {
            System.out.println("[!] Erro - " + e);
        }
    }
}


