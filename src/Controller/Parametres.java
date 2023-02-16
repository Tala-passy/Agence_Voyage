package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXToggleButton;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Parametres implements Initializable {
	  @FXML
	    private AnchorPane Parametres;

	    @FXML
	    private JFXToggleButton theme;

	    @FXML
	    private Label themelabel;
	    
	    
	    static String them;
	    public static String theme() {
	    	return them;
	    }
	    
	    
	    @FXML
	    void theme(ActionEvent event) {
	    	if (theme.isSelected()==true) {
				them="vrai";
			}else {
				them="faux";
			}
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		if(theme()=="vrai") {
			theme.setSelected(true);
		}else {
			theme.setSelected(false);
		}
		theme.selectedProperty().addListener(new ChangeListener<Boolean>(){
			@Override
		public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

			if (theme()=="vrai") {
				
				
				Parametres.getStylesheets().add(getClass().getResource("/CSS/darktheme.css").toExternalForm());
				theme.setText("ON");
				theme.setStyle("-fx-text-fill:white;");
				
			}else if(theme()=="faux") {
				Parametres.getStylesheets().clear();
				Parametres.getStylesheets().add(getClass().getResource("/CSS/Acceuil.css").toExternalForm());
				theme.setText("OFF");
				theme.setStyle("-fx-text-fill:black;");
				}}});



			}
	}


