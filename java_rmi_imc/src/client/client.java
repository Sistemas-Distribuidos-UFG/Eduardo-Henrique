package client;

import idl.QuestionsIDL;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(55554);
            //cliente precisa obter do serviço de nomes a referencia para o objeto remoto
            
            QuestionsIDL stub;
            stub = (QuestionsIDL) registry.lookup("RMIQuestions");
                                       //diferenca para o naming.lookup é a url
           
            
            double pesoideal1 = stub.CalculaPesoIdeal("m", 1.75, 79);
            double pesoideal2 = stub.CalculaPesoIdeal("m", 1.75, 79);
            
           
            System.out.printf("Peso ideal é  %.2f\\n" , pesoideal1);
            System.out.printf("Peso ideal é %.2f\\n", pesoideal2);

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

    }
}