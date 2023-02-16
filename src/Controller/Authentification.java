package Controller;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import connexion.ConnexionDB;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Authentification implements Initializable {
	 @FXML
	    private StackPane main;

	    @FXML
	    private AnchorPane layer1;

	    @FXML
	    private AnchorPane layer2;

	    @FXML
	    private Label b3;

	    @FXML
	    private Label d1;

	    @FXML
	    private Label b1;

	    @FXML
	    private Label b2;

	    @FXML
	    private JFXButton secon;

	    @FXML
	    private Label d3;

	    @FXML
	    private ImageView d2;

	    @FXML
	    private AnchorPane layer3;

	    @FXML
	    private JFXButton connexion;

	    @FXML
	    private TextField nom;

	    @FXML
	    private ComboBox<String> poste;

	    @FXML
	    private JFXButton oublie;

	    @FXML
	    private Label d4;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private Label b4;

	    @FXML
	    private MaterialDesignIconView d5;
	    @FXML
	    private StackPane stack;

	   static String well;
	   static String post;
	   ObservableList<String>pos= FXCollections.observableArrayList("guichet","gerant");
	   
	  
	    @FXML
	    void seconnecter(MouseEvent event) {
	    	TranslateTransition slide= new TranslateTransition();
	        slide.setDuration(Duration.seconds(0.5));
	        slide.setNode(layer2);
	        layer3.setTranslateX(0);
	        slide.setToX(0);
	        slide.play();
	        d1.setVisible(true);
			d2.setVisible(true);
			d3.setVisible(true);
			d4.setVisible(true);
			d5.setVisible(true);
	        b1.setVisible(false);
	        b2.setVisible(false);
	        b3.setVisible(false);
	        b4.setVisible(false);
	       // d8.setVisible(true);
	        secon.setVisible(false);
	        password.setVisible(true);
	        nom.setVisible(true);
	        poste.setVisible(true);
	        oublie.setVisible(true);
	        connexion.setVisible(true);
	        slide.setOnFinished((e ->{
	        	
	        }));
	    }
	    @FXML
	    void connexion(ActionEvent event) throws SQLException {
	    	well = nom.getText().toString();
	    	post=poste.getSelectionModel().getSelectedItem();
	    	Connection conn=ConnexionDB.connect();
	    	
	    	PreparedStatement stat=null;
	    	ResultSet rs=null;
	    	String sql="SELECT nom,poste,password FROM personnel WHERE nom= ? AND password=? AND poste=?";
	    	
	    		try {
	    			
	    			
	    			stat=conn.prepareStatement(sql);
	    			stat.setString(1, nom.getText().toString());
	    			stat.setString(2, password.getText().toString());
	    			stat.setString(3, poste.getSelectionModel().getSelectedItem().toString());
	    			rs=stat.executeQuery();
	    			if(poste.getSelectionModel().getSelectedItem().toString().equals("gerant")) {
	    			
	    			if(rs.next()) {
	    	
	    				
	    				connexion.getScene().getWindow().hide();
	    				Stage stage= new Stage();
	    				
	    				FXMLLoader loader= new FXMLLoader();
	    				loader.setLocation(getClass().getResource("/View/Acceuil.fxml"));
	    			Parent	main=loader.load();
	    				
	    				Scene scene= new Scene(main);
	    				stage.setScene(scene);
	    				
	    				stage.show();
	    				
	    				    				//connexion.getScene().getWindow().hide();
	    				
	    				
	    			}else {
	    	       JFXButton button = new JFXButton ("D'accord");
	    				Alertsmaker.alertmmaterial1(main ,layer2, Arrays.asList(button),"CONNEXION","Il n'existe pas d'utilisatuer ayant les informations entree ");
	    				
	    			}
	    			}else if(poste.getSelectionModel().getSelectedItem().toString().equals("guichet")) {
	    				if(rs.next()) {
	    			    	
	        				
	        				connexion.getScene().getWindow().hide();
	        				Stage stage= new Stage();
	        				
	        				FXMLLoader loader= new FXMLLoader();
	        				loader.setLocation(getClass().getResource("/View/Acceuil.fxml"));
	        			Parent	main=loader.load();
	        				
	        				Scene scene= new Scene(main);
	        				stage.setScene(scene);
	        				
	        				stage.show();
	        				stage.setResizable(false);
	        				
	        			}else {
	        				
	        				
	        				 JFXButton button = new JFXButton ("D'accord");
	 	    				Alertsmaker.alertmmaterial1(main ,layer2, Arrays.asList(button),"CONNEXION","Il n'existe pas d'utilisatuer ayant les informations entree  ");
	 	    				
	        				
	        				
	        			}
	    			}else {
	    				 JFXButton button = new JFXButton ("D'accord");
		    				Alertsmaker.alertmmaterial1(main ,layer2, Arrays.asList(button),"CONNEXION","Information incorrectes veuillez bien remplir les champs");
		    				
	    				
	    			}
	    			
	    			
	    			
	    		}catch (Exception e) {
	    			// TODO: handle exception
	    			
	    		}

	    }

	    @FXML
	    void oublie(MouseEvent event) {
	    	 TranslateTransition slide= new TranslateTransition();
	         slide.setDuration(Duration.seconds(0.5));
	         slide.setNode(layer2);
	         slide.setToX(580);
	         slide.play();
	        layer3.setTranslateX(-400);
	         d1.setVisible(false);
	 		d2.setVisible(false);
	 		d3.setVisible(false);
	 		d4.setVisible(false);
	 		d5.setVisible(false);
	         b1.setVisible(true);
	         b2.setVisible(true);
	         b3.setVisible(true);
	         b4.setVisible(true);
	      // d8.setVisible(false);
	       
	         password.setVisible(false);
	         nom.setVisible(false);
	         poste.setVisible(false);
	         oublie.setVisible(false);
	         connexion.setVisible(false);
	        
	         secon.setVisible(true);
	      
	         slide.setOnFinished((e ->{
	         	
	         }));
	    }
	    
    
	
	    public static String nom(){
	    	
			return well;
	    	
	    }
	    public static String post() {
	    	return post;
	    }
	  
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		d1.setVisible(true);
		d2.setVisible(true);
		d3.setVisible(true);
		d4.setVisible(true);
		d5.setVisible(true);
        b1.setVisible(false);
        b2.setVisible(false);
        b3.setVisible(false);
        b4.setVisible(false);
       //d8.setVisible(true);
        secon.setVisible(false);
        password.setVisible(true);
        nom.setVisible(true);
        poste.setVisible(true);
        oublie.setVisible(true);
        connexion.setVisible(true);
       poste.setItems(pos);
       
       
       
     
	}

}
