package server;

import java.rmi.RemoteException;

import idl.QuestionsIDL;


public class Questions  implements QuestionsIDL {
//implementa o metodo, força a reescrita
    
	public double CalculaPesoIdeal(String sexo, double altura, double peso) throws RemoteException {
		if ("m".equals(sexo)) {
            peso = (72.7 * altura) - 58;
            
        } else if ("f".equals(sexo)) {
            peso = (62.1 * altura) - 44.7;
        }
        return peso;
        
	}
}