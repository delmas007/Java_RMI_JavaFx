package Controller;

import Tchat.Tchat;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class TRUCController implements Initializable {
    public TextField getQuestion() {
        return question;
    }

    @FXML
    private TextField question;

    @FXML
    private TextArea reponse;

    @FXML
    void entrez(ActionEvent event) throws Exception {
        reponse.setText(null);
        String Text=question.getText();
        String url = null;
        Tchat tchat = null;
        try {
            url = "rmi://localhost/Hello";
            tchat = (Tchat) Naming.lookup(url);
        } catch (MalformedURLException e1) {
            System.err.println("The URL " + url + "is incorrect");
            System.exit(1);
        } catch (RemoteException e2) {
            System.err.println("Have you launched the rmiregistry ?");
            System.exit(2);
        } catch (NotBoundException e3) {
            System.err.println("Have you launched the server?");
            System.exit(2);
        }
        try {
            reponse.setText(tchat.getReponse(Text));
            question.setText(null);
        }catch (RemoteException e){
            System.err.println("The server appears to be down");
            System.err.println(e.getMessage());
            System.exit(4);
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



}








