package Tchat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TchatImp extends UnicastRemoteObject implements Tchat {

    public TchatImp() throws RemoteException {
    }

    @Override
    public String getReponse(String request) {
        String response;
        switch (request) {
            case "Comment allez-vous ?":
                response = " Je vais bien DIEU fait grâce";
                break;
            case "Qui est le respo du master Genie-Informatique ?":
                response = "Dr. KANGA";
                break;
            case "Les soutenances auront lieu quand ?":
                response = " C’est au chef de département d’en décider, aucune idée";
                break;
            case "Aurevoir":
                response = "A bientôt";
                break;
            default:
                response = "Je ne comprends pas la question";
                break;
        }
        return response;
    }
}
