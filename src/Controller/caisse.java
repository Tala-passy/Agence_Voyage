package Controller;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import connexion.ConnexionDB;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;

public class caisse implements Initializable {
	@FXML
    private JFXListView<String> listview;

	    @FXML
	    private JFXTextField nom;

	    @FXML
	    private JFXTextField image;

	    @FXML
	    private JFXTextField salaire;

	    @FXML
	    private JFXTextField numt;

	    @FXML
	    private JFXTextField cni;

	    @FXML
	    private JFXTextField adresse;

	    @FXML
	    private JFXTextField mail;

	    @FXML
	    private JFXComboBox<String> sexe;

	    @FXML
	    private JFXComboBox<String> poste;

	    @FXML
	    private JFXButton ajouter;

	    @FXML
	    private JFXButton modifier;

	    @FXML
	    private JFXButton supprimer;

	    @FXML
	    private JFXButton actualiser;
	    
	    @FXML
	    private Circle photo;
	    @FXML
	    private Label nums;
	    int count=0;
	    String num;
  ObservableList<String> bg= FXCollections.observableArrayList("M","F");
	   
	    
	    ObservableList<String> ds= FXCollections.observableArrayList("caisse");
	    

	    List<String> cass=new ArrayList<>();
	    @FXML
	    void Actualiser(ActionEvent event) throws SQLException {

	    }

	    @FXML
	    void Ajouter(ActionEvent event) throws SQLException {
	    	int valeur=0;
Connection con=ConnexionDB.connect();
String sql="Insert into employe(nom,numcni,password,poste,numtel,adresse,email,sexe,salaire,image) values(?,?,?,?,?,?,?,?,?,?)";
	   PreparedStatement stat=con.prepareStatement(sql);
	   stat.setString(1, nom.getText());
	   stat.setString(2, cni.getText());
	   stat.setString(3, null);
	   stat.setNString(4, poste.getSelectionModel().getSelectedItem());
	   stat.setInt(5,Integer.parseInt(numt.getText()));
	   stat.setString(6, adresse.getText());
	   stat.setString(7, mail.getText());
	   stat.setString(8, sexe.getSelectionModel().getSelectedItem());
	   stat.setDouble(9, Double.parseDouble(salaire.getText()));
	   stat.setString(10, image.getText());
	   valeur=stat.executeUpdate();
	   if(valeur>0) {
    	   Image img =new Image("/images/images java/tick_box_100px.png");
			 Notifications notification=Notifications.create()
			 .title("Caisse")
			 .text("Le caissier à été ajouté")
		      .graphic(new ImageView(img))
		      .hideAfter(Duration.seconds(5))
		      .position(Pos.CENTER_RIGHT)
		      .onAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					System.out.println("Clique sur la notification");
				}
			});
			 
			 notification.show();
       }else {
    	   Image img =new Image("/images/images java/cancel_100px.png");
			 Notifications notification=Notifications.create()
			 .title("Caisse")
			.text("Le caissier n'a pas été ajouté")
		      .graphic(new ImageView(img))
		      .hideAfter(Duration.seconds(5))
		      .position(Pos.CENTER_RIGHT)
		      .onAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					System.out.println("Clique sur la notification");
				}
			});
			
			 notification.show();
       }
	    }
	   

	    @FXML
	    void Modifier(ActionEvent event) throws SQLException {
	    	int valeur=0;
	    	Connection con=ConnexionDB.connect();
	    	String sql="Update employe set nom=?,numcni=?,password=?,poste=?,numtel=?,adresse=?,email=?,sexe=?,salaire=?,image=? where numcni='"+num+"'";
	    		   PreparedStatement stat=con.prepareStatement(sql);
	    		   stat.setString(1, nom.getText());
	    		   stat.setString(2, cni.getText());
	    		   stat.setString(3, null);
	    		   stat.setNString(4, poste.getSelectionModel().getSelectedItem());
	    		   stat.setInt(5,Integer.parseInt(numt.getText()));
	    		   stat.setString(6, adresse.getText());
	    		   stat.setString(7, mail.getText());
	    		   stat.setString(8, sexe.getSelectionModel().getSelectedItem());
	    		   stat.setDouble(9, Double.parseDouble(salaire.getText()));
	    		   stat.setString(10, image.getText());
	    		   valeur=stat.executeUpdate();
	    		   if(valeur>0) {
	    	    	   Image img =new Image("/images/images java/tick_box_100px.png");
	    				 Notifications notification=Notifications.create()
	    				 .title("Caisse")
	    				 .text("Le caissier à été modifié")
	    			      .graphic(new ImageView(img))
	    			      .hideAfter(Duration.seconds(5))
	    			      .position(Pos.CENTER_RIGHT)
	    			      .onAction(new EventHandler<ActionEvent>() {
	    					
	    					@Override
	    					public void handle(ActionEvent event) {
	    						// TODO Auto-generated method stub
	    						System.out.println("Clique sur la notification");
	    					}
	    				});
	    				 
	    				 notification.show();
	    	       }else {
	    	    	   Image img =new Image("/images/images java/cancel_100px.png");
	    				 Notifications notification=Notifications.create()
	    				 .title("Caisse")
	    				.text("Le caissier n'a pas été modifié")
	    			      .graphic(new ImageView(img))
	    			      .hideAfter(Duration.seconds(5))
	    			      .position(Pos.CENTER_RIGHT)
	    			      .onAction(new EventHandler<ActionEvent>() {
	    					
	    					@Override
	    					public void handle(ActionEvent event) {
	    						// TODO Auto-generated method stub
	    						System.out.println("Clique sur la notification");
	    					}
	    				});
	    				
	    				 notification.show();
	    	       }
	    }

	    @FXML
	    void Supprimer(ActionEvent event) throws SQLException {
	    	int valeur=0;
	    	Connection con=ConnexionDB.connect();
	    	String sql="Delete from employe where numcni='"+num+"'";
	    		   PreparedStatement stat=con.prepareStatement(sql);
	    		   valeur=stat.executeUpdate();
	    		   if(valeur>0) {
	    	    	   Image img =new Image("/images/images java/tick_box_100px.png");
	    				 Notifications notification=Notifications.create()
	    				 .title("Caisse")
	    				 .text("Le caissier à été supprimé")
	    			      .graphic(new ImageView(img))
	    			      .hideAfter(Duration.seconds(5))
	    			      .position(Pos.CENTER_RIGHT)
	    			      .onAction(new EventHandler<ActionEvent>() {
	    					
	    					@Override
	    					public void handle(ActionEvent event) {
	    						// TODO Auto-generated method stub
	    						System.out.println("Clique sur la notification");
	    					}
	    				});
	    				 
	    				 notification.show();
	    	       }else {
	    	    	   Image img =new Image("/images/images java/cancel_100px.png");
	    				 Notifications notification=Notifications.create()
	    				 .title("Caisse")
	    				.text("Le caissier n'a pas été supprimé")
	    			      .graphic(new ImageView(img))
	    			      .hideAfter(Duration.seconds(5))
	    			      .position(Pos.CENTER_RIGHT)
	    			      .onAction(new EventHandler<ActionEvent>() {
	    					
	    					@Override
	    					public void handle(ActionEvent event) {
	    						// TODO Auto-generated method stub
	    						System.out.println("Clique sur la notification");
	    					}
	    				});
	    				
	    				 notification.show();
	    	       }
	    }

	    @FXML
	    void image(MouseEvent event) {
	    	FileChooser fc = new FileChooser();
 	    	fc.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png","*.jpg"));
 	    	File f = fc.showOpenDialog(null);
 	    	if(f != null) {
 	    	
 	    image.setText(f.getAbsolutePath().substring(50));
 	  // C:\Users\TOSHIBA\eclipse-workspace\Agence\src\Image\81993.jpg
 	   ImagePattern pattern=new ImagePattern(new Image(""+image.getText()));
		photo.setFill(pattern);
		photo.setEffect(new DropShadow());
 	    		
 	    		
 	    	}
	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// TODO Auto-generated method stub
		poste.setItems(ds);
		sexe.setItems(bg);
		
		Connection con;
		
		try {
			con = ConnexionDB.connect();
			String query="select count(nom) from employe where poste='caissier'";
	    	PreparedStatement stat=con.prepareStatement(query);
	    	ResultSet rs1=stat.executeQuery();
	    	if(rs1.next()) {
	    	count=rs1.getInt(1);	
	    	}
	    
	    	nums.setText(String.valueOf(count));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
	}

}
