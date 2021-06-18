import java.net.ServerSocket;
import java.net.Socket;

import java.util.Scanner;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import util.Parsing;
import util.Message;


public class ServidorIdea {
    

    public static void main (String args[]) throws IOException 
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
                String strMessage = (String) ois.readObject();
                Parsing objMsgOfClient = new Parsing(strMessage);
                Message msg = objMsgOfClient.GetMessageObj();

                // Manipula o objeto msg
                msg.salario = (float) msg.salario * 2;
                objMsgOfClient.UpdateMsg(msg);

                oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(objMsgOfClient.GetParsedString());

                ois.close();
                oos.close();
                socket.close();
            }

        } catch (Exception e) {
            System.out.println("[!] Erro - " + e);
        }
    }
}