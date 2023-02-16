package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;

import Model.Client;
import connexion.ConnexionDB;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.octicons.OctIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class arrange implements Initializable {
	 @FXML
	    private AnchorPane gestionT;

	    @FXML
	    private TableView<Client> tabTick;

	    @FXML
	    private TableColumn<Client, String> Nom;

	  
	   
	    @FXML
	    private TableColumn<Client, String> prix;

	   
	    @FXML
	    private TableColumn<Client, String> categorie;

	    @FXML
	    private TableColumn<Client, String> destination;

	   
	    @FXML
	    private TableColumn<Client, String> dateE;

	    @FXML
	    private TableColumn<Client, String> Hdep;

	   

	    @FXML
	    private TextField numticket1;

	    @FXML
	    private JFXButton ajout1;

	    @FXML
	    private JFXButton afficher1;

	    @FXML
	    private JFXButton retour;

	    @FXML
	    private OctIconView searchicon;

	    @FXML
	    private FontAwesomeIconView crossicon;

	    ObservableList<Client> listTick = FXCollections.observableArrayList();
	    
	    
	    @FXML
	    void Afficher(ActionEvent event) {
	      	tabTick.getItems().clear();

	    			try {
	    				
	    				Connection con = ConnexionDB.connect();

	    				String sql = "SELECT * FROM client";
	    				PreparedStatement stat = con.prepareStatement(sql);

	    				ResultSet rs = stat.executeQuery();
	    				while(rs.next()) {

	    					listTick.add(new Client(rs.getString(1),rs.getInt(2) , rs.getInt(3), rs.getString(4), "2022A"+rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8),
	    							rs.getInt(9),rs.getString(10),rs.getInt(11),rs.getInt(12)));

	    				}
	    				con.close();

	    			} catch (Exception e) {

	    				e.printStackTrace();
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    			Nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nomcli"));
	    	    			 prix.setCellValueFactory(new PropertyValueFactory<Client,String>("prixtick"));
	    			
	    			 categorie.setCellValueFactory(new PropertyValueFactory<Client,String>("categorie"));
	    			
	    			dateE.setCellValueFactory(new PropertyValueFactory<Client,String>("dateEnreg"));
	    		    Hdep.setCellValueFactory(new PropertyValueFactory<Client,String>("heureDepart"));
	    		    destination.setCellValueFactory(new PropertyValueFactory<Client,String>("destination"));	         	
	    		   
	    		   // places.setCellValueFactory(new PropertyValueFactory<Client,Integer>("numplc"));

	    		    tabTick.setItems(listTick);
	    		    
	    }

	  

	    @FXML
	    void change(MouseEvent event) {

	    }

	   

	    @FXML
	    void retour(ActionEvent event) {

	    }

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Afficher(null);
		// TODO Auto-generated method stub
		tabTick.getItems().clear();
		
		try {
			String sql ="SELECT * FROM client WHERE numtick=?";
		
				Connection con=ConnexionDB.connect();
				PreparedStatement stat;
				stat = con.prepareStatement(sql);
				stat.setString(1, numticket1.getText().toString());
				ResultSet rs=stat.executeQuery();
				
				while(rs.next()) {

					listTick.add(new Client(rs.getString(1),
							rs.getInt(2) , 
							rs.getInt(3), 
							rs.getString(4), 
							rs.getString(5), 
							rs.getString(6), 
							rs.getString(7),
							rs.getString(8),
							rs.getInt(9),
							rs.getString(10),
							rs.getInt(11),
							rs.getInt(12)));

				}
				con.close();
				
				Nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nomcli"));
					 prix.setCellValueFactory(new PropertyValueFactory<Client,String>("prixtick"));
					 categorie.setCellValueFactory(new PropertyValueFactory<Client,String>("categorie"));
					dateE.setCellValueFactory(new PropertyValueFactory<Client,String>("dateEnreg"));
				    Hdep.setCellValueFactory(new PropertyValueFactory<Client,String>("heureDepart"));
				    destination.setCellValueFactory(new PropertyValueFactory<Client,String>("destination"));	         	
				   

				//rechERCHE Automatique
				FilteredList<Client> filteredData = new FilteredList<>(listTick, b -> true);
				numticket1.textProperty().addListener((observable, oldvalue, newvalue) -> {
					filteredData.setPredicate(Client -> {
						//si la nouvelle valeur est vide 
						if(newvalue.isEmpty()  || newvalue==null) {
							return true;
					}
						String searchkeyword = newvalue.toLowerCase();
						if(Client.getnumTick().toLowerCase().indexOf(searchkeyword) > -1) {
							return true; // ca veut dire que nous avons trouve un produit qui correspond
						}else if(Client.getcategorie().toLowerCase().indexOf(searchkeyword) > -1) {
							return true;
						}else if(Client.getdateEnreg().toLowerCase().indexOf(searchkeyword) > -1) {
							return true;
						}else if(Client.getdestination().toLowerCase().indexOf(searchkeyword) > -1) {
							return true;
						}else if(Client.getheureDepart().toLowerCase().indexOf(searchkeyword) > -1) {
							return true;
						}else if(Client.getnomcli().toLowerCase().indexOf(searchkeyword) > -1) {
							return true;
							
						}else {
							
							return false;
												
						}
					});
				});
				SortedList<Client> sortedData = new SortedList<>(filteredData);
				// cette methode lie le sorted list au table view des tickets
				sortedData.comparatorProperty().bind(tabTick.comparatorProperty());

			}catch (SQLException e2) {
				// TODO: handle exception
			Logger.getLogger(arrange.class.getName()).log(Level.SEVERE, null,e2);
			e2.printStackTrace();
			}
		
		
			   // places.setCellValueFactory(new PropertyValueFactory<Client,Integer>("numplc"));
			
    	
		tabTick.setItems(listTick);
		numticket1.clear();
		

}

	}


