import java.net.ServerSocket;
import java.net.Socket;

import java.util.Scanner;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import util.Message;
import util.Parsing;

public class ClienteIdea {
    public static void main (String args[]) throws IOException 
    {
        ObjectOutputStream oos = null;               //serelizar os dados
        ObjectInputStream ois = null;
        Scanner scanner = new Scanner(System.in);

        try {
            Socket socket = new Socket("127.0.0.1", 1234);
            System.out.println("[*] O cliente se conectou ao servidor!");
            
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Salario: ");
            float salario = Float.parseFloat(scanner.nextLine());

            System.out.print("Cargo: ");
            String cargo = scanner.nextLine();
            
            Message msg = new Message(nome, salario, cargo);
            Parsing objMsgToServer = new Parsing(msg);
            String msgToServer = objMsgToServer.GetParsedString();

            oos = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("[*] Sending request to Socket Server");
            oos.writeObject(msgToServer);

            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);

            ois.close();
            oos.close();
        } catch (Exception e) {
            System.out.println("[!] Erro - " + e);
        }
    }
}