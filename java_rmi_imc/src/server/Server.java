package server;

import idl.QuestionsIDL;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server  {
    public static void main(String[] args) {
        try {
            // cria uma instancia da classe quantions
        	Questions questions = new Questions();

            QuestionsIDL stub = (QuestionsIDL) UnicastRemoteObject.exportObject(questions, 0);
           //interface
            Registry registry = LocateRegistry.createRegistry(55554);
           //inicializa o serviço de nomes 
            //associa o objeto stub do servidor a um nome no registry
            //registra o nome e a referencia ao objeto
            
            registry.rebind("RMIQuestions", stub);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}