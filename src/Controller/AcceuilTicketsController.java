package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTabPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class AcceuilTicketsController implements Initializable {


    @FXML
    private AnchorPane acceuilticket;

    @FXML
    private JFXTabPane tabpane;

    @FXML
    private AnchorPane gestiontick;

 

    @FXML
    private AnchorPane ventes;

    AnchorPane pane1;

  @Override
	public void initialize(URL location, ResourceBundle resources) {
	StackPane pane;
		try {
			pane1 = FXMLLoader.load(getClass().getResource("/View/ventesTicket.fxml"));
			ventes.getChildren().setAll(pane1);
		pane = FXMLLoader.load(getClass().getResource("/View/GestionTickets.fxml"));
		gestiontick.getChildren().setAll(pane);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
		// TODO Auto-generated method stub
		if(Parametres.theme()=="vrai") {
			acceuilticket.getStylesheets().clear();	
			acceuilticket.getStylesheets().add(getClass().getResource("/CSS/darktheme.css").toExternalForm());	
		}else {
			acceuilticket.getStylesheets().clear();	
	acceuilticket.getStylesheets().add(getClass().getResource("/CSS/Acceuil.css").toExternalForm());
    }
	}

}
