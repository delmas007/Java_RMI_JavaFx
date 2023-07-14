package Tchat;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Tchat extends Remote{
    public  String getReponse(String request) throws RemoteException;
}
