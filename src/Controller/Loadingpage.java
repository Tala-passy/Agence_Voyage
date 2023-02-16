package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Loadingpage implements Initializable {

	@FXML
    private AnchorPane main;

    @FXML
    private AnchorPane layer;

    @FXML
    private AnchorPane load;
	 
    private void load() {
    	
try {
				
				Parent	pane = FXMLLoader.load(getClass().getResource("/View/Authentification.fxml"));
					Scene news=new Scene(pane);
					Stage curstage = (Stage)main.getScene().getWindow();
					curstage.setScene(news);
					
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					Logger.getLogger(Loadingpage.class.getName()).log(Level.SEVERE,null,e2);
				}    	
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		 
	  
	      

			 TranslateTransition slide= new TranslateTransition();
	      slide.setDuration(Duration.seconds(5));
	      slide.setCycleCount(4);
	      slide.setNode(load);
	      slide.setToX(1500);
	      slide.setByX(0);
	      slide.play();
	    
	   
	      slide.setOnFinished((e ->{
	    	  FadeTransition fade= new FadeTransition(Duration.millis(2000));
		       
		       fade.setNode(main);
		      fade.setFromValue(1);
		      fade.setToValue(0);
		      fade.play();
		      fade.setOnFinished((e1 ->{
		     	 
		    	 load();
				
			    	
		      })); 	
	      }));      
	 
	}

}
