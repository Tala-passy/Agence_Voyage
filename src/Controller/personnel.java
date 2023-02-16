package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTabPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class personnel implements Initializable {
	  @FXML
	    private JFXTabPane tabpane;

	    @FXML
	    private AnchorPane caisse;

	    @FXML
	    private AnchorPane chauffeur;

	    @FXML
	    private AnchorPane gardiens;

	    @FXML
	    private AnchorPane hotesses;

	    @FXML
	    private AnchorPane bagages;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		StackPane pane;

	    AnchorPane pane1;

		try {
			pane1 = FXMLLoader.load(getClass().getResource("/View/caisse.fxml"));
			caisse.getChildren().setAll(pane1);
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
