package Server;

import Tchat.Tchat;
import Tchat.TchatImp;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class TchatServer {
    public static void main(String[] args){
        System.setProperty("java.rmi.server.hostname", "localhost");
        try {
            LocateRegistry.createRegistry(1099);
        } catch (RemoteException e1) {
            System.err.println("rmiregistry is already launched on this port");
            System.exit(1);
        }
        Tchat tchat;
        try {
            tchat = new TchatImp();
            Naming.rebind("rmi://localhost:1099/Hello",tchat);
        } catch (RemoteException e) {
            System.err.println("have you launched rmiregistry?");
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (MalformedURLException e) {
            throw new InternalError("the URL is incorrect");
        }
    }
}
