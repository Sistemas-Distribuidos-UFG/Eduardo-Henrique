package idl;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface QuestionsIDL extends Remote {
	//metodo remoto
    public double CalculaPesoIdeal(String sexo, double altura, double peso) throws RemoteException;
   //assinatura de metodo
}
