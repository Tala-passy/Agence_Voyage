package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

import connexion.ConnexionDB;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.jensd.fx.glyphs.octicons.OctIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class AcceuilController implements Initializable {
	
	

	 @FXML
	    private AnchorPane parent;

	    @FXML
	    private AnchorPane menu;

	    @FXML
	    private Pane info;

	    @FXML
	    private Label nomutilisateur;
	    @FXML
	    private Circle account;

	    @FXML
	    private JFXButton home;

	    @FXML
	    private MaterialDesignIconView icon21;

	    @FXML
	    private JFXButton Tickets;

	    @FXML
	    private MaterialDesignIconView icon2;

	    @FXML
	    private JFXButton Vehicule;

	    @FXML
	    private MaterialDesignIconView icon3;

	    @FXML
	    private JFXButton personnel;

	    @FXML
	    private FontAwesomeIconView icon4;

	    @FXML
	    private JFXButton expedition;

	    @FXML
	    private FontAwesomeIconView icon5;

	    @FXML
	    private JFXButton Itineraires;

	    @FXML
	    private MaterialDesignIconView icon6;

	    @FXML
	    private JFXButton finances;

	    @FXML
	    private MaterialDesignIconView icon61;

	    @FXML
	    private JFXButton parametres;

	    @FXML
	    private FontAwesomeIconView icon7;

	    @FXML
	    private JFXButton deconnexion;

	    @FXML
	    private OctIconView icon8;

	    @FXML
	    private Label titre;

	    @FXML
	    private AnchorPane main;

	    @FXML
	    private AnchorPane root;

	    @FXML
	    void Finances(ActionEvent event) {

	    }


	    @FXML
	    void home(ActionEvent event) {

	    }

	   

	    @FXML
	    void vehicule(ActionEvent event) {

	    }


    @FXML
    void tickets(ActionEvent event) throws IOException {
    	StackPane pane=FXMLLoader.load(getClass().getResource("/View/GestionTickets.fxml"));
    	root.getChildren().setAll(pane);
    	if (Parametres.theme()=="vrai") {
    		
    		main.getStylesheets().add(getClass().getResource("/CSS/darktheme.css").toExternalForm());
    		
    		
    	}else {
    		main.getStylesheets().clear();
    		main.getStylesheets().add(getClass().getResource("/CSS/Acceuil.css").toExternalForm());
    		
    		}
    }

// methodes pour les Expeditions
    
    @FXML
    void Expedition(ActionEvent event) {
    	if (Parametres.theme()=="vrai") {
    		main.getStylesheets().add(getClass().getResource("/CSS/darktheme.css").toExternalForm());
    	}else {
    		main.getStylesheets().clear();
    		main.getStylesheets().add(getClass().getResource("/CSS/Acceuil.css").toExternalForm());
    		
    		}
    }

    //Methodes pour les parametres
    
    @FXML
    void parametres(ActionEvent event) throws IOException {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("/View/Parametres.fxml"));
    	root.getChildren().setAll(pane);
    	if (Parametres.theme()=="vrai") {
    		
    		
    		main.getStylesheets().add(getClass().getResource("/CSS/darktheme.css").toExternalForm());
    		
    		
    	}else {
    		main.getStylesheets().clear();
    		main.getStylesheets().add(getClass().getResource("/CSS/Acceuil.css").toExternalForm());
    		
    		}
    	
    	
    }

  //Methodes pour les itinneraires
    
    @FXML
    void itineraires(ActionEvent event) {
    	if (Parametres.theme()=="vrai") {
    		
    		main.getStylesheets().add(getClass().getResource("/CSS/darktheme.css").toExternalForm());
    		
    		
    	}else {
    		main.getStylesheets().clear();
    		main.getStylesheets().add(getClass().getResource("/CSS/Acceuil.css").toExternalForm());
    		
    		}
    }
    
    
  //Methodes pour le personnel


    @FXML
    void personnel(ActionEvent event) throws IOException {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("/View/personnelview.fxml"));
    	root.getChildren().setAll(pane);
    	if (Parametres.theme()=="vrai") {
    		
    		main.getStylesheets().add(getClass().getResource("/CSS/darktheme.css").toExternalForm());
    		
    		
    	}else {
    		main.getStylesheets().clear();
    		main.getStylesheets().add(getClass().getResource("/CSS/Acceuil.css").toExternalForm());
    		
    		}
    }
    
    //Methodes pour la deconnexion

    @FXML
    void deconnexion(ActionEvent event) {

    }
    
    
    
    
    @FXML
    void change(KeyEvent event) {

    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//Affichage du nom de l'utilisateur dans la fenetre d'acceuil
		nomutilisateur.setText(Authentification.nom().toUpperCase());
		//Attribution des differeents droits aux utilisateurs
		if(Authentification.post()=="guichet") {
			expedition.setDisable(true);
			Vehicule.setDisable(true);
			personnel.setDisable(true);
			Itineraires.setDisable(true);
			
		}
		try {
			Connection conn=ConnexionDB.connect();
			PreparedStatement stat=null;
	    	ResultSet rs=null;
	    	String sql="SELECT imgsrc FROM personnel WHERE nom='"+nomutilisateur.getText()+"'";
	    	stat=conn.prepareStatement(sql);
	    	rs=stat.executeQuery();
	    	if(rs.next()) {
			ImagePattern pattern=new ImagePattern(new Image(""+rs.getString("imgsrc")));
			account.setFill(pattern);
			account.setEffect(new DropShadow());
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	


//la methode pour donner le theme par defaut de l'application

main.getStylesheets().add(getClass().getResource("/CSS/Acceuil.css").toExternalForm());


//La methode pour changer let theme de l'application

	}
	}


