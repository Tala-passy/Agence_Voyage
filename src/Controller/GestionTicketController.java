package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;

import Model.Client;
import connexion.ConnexionDB;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.octicons.OctIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

public class GestionTicketController implements Initializable {
	 @FXML
	    private AnchorPane gestionT;
	 
	  @FXML
	    private StackPane main;

	  @FXML
	    private TableView<Client> tabTick;
	    @FXML
	    private TableColumn<Client, String> Nom;

	    @FXML
	    private TableColumn<Client, Integer> tel;

	    @FXML
	    private TableColumn<Client, Integer> CNI;

	    @FXML
	    private TableColumn<Client, Integer> prix;

	    @FXML
	    private TableColumn<Client, Integer> numt;

	    @FXML
	    private TableColumn<Client, String> categorie;

	    @FXML
	    private TableColumn<Client, Integer> numgui;

	    @FXML
	    private TableColumn<Client, Integer> numbus;

	    @FXML
	    private TableColumn<Client, String> dateE;

	    @FXML
	    private TableColumn<Client, String> Hdep;
	    @FXML
	    private TableColumn<Client, String> Action;
	   
	    @FXML
	    private TableColumn<Client, Integer> bagages;

	    @FXML
		private TableColumn<Client, String> destination;
	   
	    @FXML
	    private JFXButton ajout;

	    @FXML
	    private JFXButton afficher;

	    @FXML
	    private JFXButton retour;

	    @FXML
	    private OctIconView searchicon;

	    @FXML
	    private FontAwesomeIconView crossicon;

	    @FXML
	    private TextField numticket;
	    
	    String query = null;
	    Connection connection = null ;
	    PreparedStatement preparedStatement = null ;
	    ResultSet resultSet = null ;
	    Client client = null ;
		
		ObservableList<Client> listTick = FXCollections.observableArrayList();
        ObservableList<Client> search =FXCollections.observableArrayList();
		 @FXML
		    void Afficher(ActionEvent event) {
			search.clear();
			 Connection con;

					try {
						action();

						
						con = ConnexionDB.connect();

						String sql = "SELECT * FROM client";
						PreparedStatement stat = con.prepareStatement(sql);

						ResultSet rs = stat.executeQuery();
						while(rs.next()) {
							String nomclient=rs.getString("nomcli");
							Integer numtel=rs.getInt("numtelcli");
							Integer numcni=rs.getInt("numcnicli");
							Integer prixtick=rs.getInt("prixtick");
							Integer numtick=rs.getInt("numtick");
							String dateEn=rs.getString("dateEnreg");
							String heured=rs.getString("HeureDep");
							String categorie=rs.getString("Categorie");
							String destina=rs.getString("destination");
							Integer numbagages=rs.getInt("numbagages");
							Integer numb=rs.getInt("numbus");
							search.add(new Client(nomclient,numtel, numcni,prixtick,numtick, dateEn, heured,categorie,destina, numbagages, numb));
						} 
						Nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nomcli"));
				           tel.setCellValueFactory(new PropertyValueFactory<Client,Integer>("numtelcli"));
							CNI.setCellValueFactory(new PropertyValueFactory<Client,Integer>("numcnicli"));
							 prix.setCellValueFactory(new PropertyValueFactory<Client,Integer>("prixtick"));
							numt.setCellValueFactory(new PropertyValueFactory<Client,Integer>("numTick"));
							 categorie.setCellValueFactory(new PropertyValueFactory<Client,String>("categorie"));
							numbus.setCellValueFactory(new PropertyValueFactory<Client,Integer>("numBus"));
							dateE.setCellValueFactory(new PropertyValueFactory<Client,String>("dateEnreg"));
						    Hdep.setCellValueFactory(new PropertyValueFactory<Client,String>("heureDepart"));
						    destination.setCellValueFactory(new PropertyValueFactory<Client,String>("destination"));	         	
						    bagages.setCellValueFactory(new PropertyValueFactory<Client,Integer>("numbg"));

					tabTick.setItems(search);
						
						con.close();

					} catch (Exception e) {

						e.printStackTrace();
					}
							
				}

	    @FXML
	    void add(ActionEvent event) throws IOException {
	    	ajout.getScene().getWindow();
	    	Stage stage= new Stage();
			
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("/View/AjouterTicketView.fxml"));
		Parent	main1=loader.load();
			
			Scene scene= new Scene(main1);
			stage.setScene(scene);
			stage.show();
			stage.setResizable(false);
			
	    }
	    @FXML
	    void clear(MouseEvent event) {
numticket.clear();
crossicon.setVisible(false);
searchicon.setVisible(true);

	    }

	    @FXML
	    void change(KeyEvent event) {
if(numticket.getText().equals("")) {
	crossicon.setVisible(false);
	searchicon.setVisible(true);
}else {
	crossicon.setVisible(true);
	searchicon.setVisible(false);
	
	String rech=numticket.getText();
	if(rech.equals("")) {
		tabTick.getItems().clear();
		 JFXButton button = new JFXButton ("D'accord");
		Alertsmaker.alertmmaterial1(main ,gestionT, Arrays.asList(button),"RECHERCHE","Veuillez entrer quelque chose avant de faire votre recherche ");	
	}else {
		FilteredList<Client> filteredData=new FilteredList<>(search, b-> true);
		numticket.textProperty().addListener((observable, oldvalue,newvalue) ->{
			filteredData.setPredicate(Client ->{
				if(newvalue.isEmpty() ||newvalue==null) {
					return true;
				}
				
				
				String searchwords=newvalue.toLowerCase();
				if(Client.getnomcli().toLowerCase().indexOf(searchwords)> -1) {
					return true;
				}else if(Client.getcategorie().toLowerCase().indexOf(searchwords)> -1) {
					return true;
				}else if(String.valueOf(Client.getnumtelcli()).indexOf(searchwords)> -1){
					return true;
				}else if(String.valueOf(Client.getnumTick()).indexOf(searchwords)> -1) {
					return true;
				}else if(String.valueOf(Client.getnumbg()).indexOf(searchwords)> -1) {
					return true;
				}else if(String.valueOf(Client.getnumBus()).indexOf(searchwords)> -1) {
					return true;
				}else if(String.valueOf(Client.getnumcnicli()).indexOf(searchwords)> -1) {
					return true;
				}else if(String.valueOf(Client.getprixtick()).indexOf(searchwords)> -1) {
					return true;
				}else if(Client.getdateEnreg().toLowerCase().indexOf(searchwords)> -1) {
					return true;
				}else if(Client.getdestination().toLowerCase().indexOf(searchwords)> -1) {
					return true;
				}else if(Client.getheureDepart().toLowerCase().indexOf(searchwords)> -1) {
					return true;
				}
				else {
					return false;
				}
			});
		});
		
		SortedList<Client> sortedData=new  SortedList <>(filteredData);
		sortedData.comparatorProperty().bind(tabTick.comparatorProperty());
		tabTick.setItems(sortedData);
		
	}
}
	    }
 @FXML
	    void retour(ActionEvent event) {

	    }
	    
	    
	    private void action() throws SQLException {
	      	 connection = ConnexionDB.connect();
	         
	           
	           Nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nomcli"));
	           tel.setCellValueFactory(new PropertyValueFactory<Client,Integer>("numtelcli"));
	   			CNI.setCellValueFactory(new PropertyValueFactory<Client,Integer>("numcnicli"));
	   			 prix.setCellValueFactory(new PropertyValueFactory<Client,Integer>("prixtick"));
	   			numt.setCellValueFactory(new PropertyValueFactory<Client,Integer>("numTick"));
	   			 categorie.setCellValueFactory(new PropertyValueFactory<Client,String>("categorie"));
	   			numbus.setCellValueFactory(new PropertyValueFactory<Client,Integer>("numBus"));
	   			dateE.setCellValueFactory(new PropertyValueFactory<Client,String>("dateEnreg"));
	   		    Hdep.setCellValueFactory(new PropertyValueFactory<Client,String>("heureDepart"));
	   		    destination.setCellValueFactory(new PropertyValueFactory<Client,String>("destination"));	         	
	   		    bagages.setCellValueFactory(new PropertyValueFactory<Client,Integer>("numbg"));
	          
	           //add cell of button edit 
	            Callback<TableColumn<Client, String>, TableCell<Client, String>> cellFoctory = (TableColumn<Client, String> param) -> {
	               // make cell containing buttons
	               final TableCell<Client, String> cell = new TableCell<Client, String>() {
	                   @Override
	                   public void updateItem(String item, boolean empty) {
	                       super.updateItem(item, empty);
	                       //that cell created only on non-empty rows
	                       if (empty) {
	                           setGraphic(null);
	                           setText(null);

	                       } else {

	                           FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
	                           FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL);
	                           FontAwesomeIconView printIcon = new FontAwesomeIconView(FontAwesomeIcon.PRINT);
	                           deleteIcon.setStyle(
	                                   " -fx-cursor: hand ;"
	                                   + "-glyph-size:24px;"
	                                   + "-fx-fill:#555555;"
	                           );
	                           editIcon.setStyle(
	                                   " -fx-cursor: hand ;"
	                                   + "-glyph-size:24px;"
	                                   + "-fx-fill:#555555;"
	                           );
	                           printIcon.setStyle(
	                                   " -fx-cursor: hand ;"
	                                   + "-glyph-size:24px;"
	                                   + "-fx-fill:#555555;"
	                           );
	                           deleteIcon.setOnMouseClicked((MouseEvent event) -> {
	                               
	                               JFXButton yesbutton=new JFXButton("Oui");
								   yesbutton.addEventHandler(MouseEvent.MOUSE_CLICKED , (MouseEventevent1)->{
									   client = tabTick.getSelectionModel().getSelectedItem();
								       query = "DELETE FROM `client` WHERE numTick ="+client.getnumTick();
								       int valeur=0;
								       try {
										connection = ConnexionDB.connect();
										  preparedStatement = connection.prepareStatement(query);
								           preparedStatement.execute();
								           valeur=preparedStatement.executeUpdate();
										
								           Afficher(null);
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								       
								       if(valeur>0) {
								    	   Image img =new Image("/Image/tick_box_100px.png");
											 Notifications notification=Notifications.create()
											 .title("Suppression")
											 .text("Le Ticket n'a pas supprime")
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
											 if(Parametres.theme()=="vrai") {
												 notification.darkStyle();
											 }
											 notification.show();
								       }else {
								    	   Image img =new Image("/Image/tick_box_100px.png");
											 Notifications notification=Notifications.create()
											 .title("Ticket")
											 .text("Ticket a ete supprime")
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
											 if(Parametres.theme()=="vrai") {
												 notification.darkStyle();
											 }
											 notification.show();
								       }
								     
								   });
								   
								   JFXButton button = new JFXButton ("Non");
								   button.addEventHandler(MouseEvent.MOUSE_CLICKED , (MouseEventevent1)->{
									   JFXButton button1 = new JFXButton ("D'accord");
									   Alertsmaker.alertmmaterial1(main,gestionT, Arrays.asList(button1),"SUPPRESSION"," Operation annule");
								     
								   });
								Alertsmaker.alertmmaterial1(main,gestionT, Arrays.asList(yesbutton,button),"SUPPRESSION","Voulez vous supprimer ce ticket? ");
	                               
	                              
	                               
	                             

	                           });
	                          editIcon.setOnMouseClicked((MouseEvent event) -> {
	                               
	                               client =tabTick.getSelectionModel().getSelectedItem();
	                               FXMLLoader loader = new FXMLLoader ();
	                               loader.setLocation(getClass().getResource("/View/ModifierTicket.fxml"));
	                               
	                              try {
	                                   loader.load();
	                               } catch (IOException ex) {
	                                   Logger.getLogger(ModifierTicketController.class.getName()).log(Level.SEVERE, null, ex);
	                               }
	                               
	                               ModifierTicketController enregistrement = loader.getController();
	                               enregistrement.setUpdate(true);
	                               enregistrement.setTextField(client.getnomcli(), client.getnumtelcli(), 
	                                       client.getnumcnicli(),client.getprixtick(), client.getnumTick(), client.getcategorie(),client.getnumBus(),client.getdateEnreg(),
	                                       client.getheureDepart(),client.getdestination(),client.getnumbg());
	                               Parent parent = loader.getRoot();
	                               if(Parametres.theme()=="vrai") {
	                       			parent.getStylesheets().clear();	
	                       			parent.getStylesheets().add(getClass().getResource("/CSS/darktheme.css").toExternalForm());	
	                       		}else {
	                       			parent.getStylesheets().clear();	
	                       		parent.getStylesheets().add(getClass().getResource("/CSS/Acceuil.css").toExternalForm());
	                           }
	                               Stage stage = new Stage();
	                               stage.setScene(new Scene(parent));
	                              // stage.initStyle(StageStyle.UTILITY);
	                               stage.show();
	                               
	                               stage.setResizable(false);
	                              
	                           	/*Image img= new Image("/CSS/imagesjava/bus_48px.png");
	              				  stage.getIcons().add(img);
	              				stage.setTitle("UNITED EXPRESS");*/
	                              

	                           });

	                          printIcon.setOnMouseClicked((MouseEvent event) -> {
	                          	 client =tabTick.getSelectionModel().getSelectedItem();
	                               FXMLLoader loader = new FXMLLoader ();
	                               loader.setLocation(getClass().getResource("/View/ticketview.fxml"));
	                              try {
	                              	
	                        				 loader.load();
	                        			
	                               } catch (IOException ex) {
	                                   Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
	                               }
	                               
	                              TicketController tick = loader.getController();
	                             tick.setUpdate(true);
	                              tick.setlabel(client.getnomcli(), client.getnumtelcli(), client.getnumcnicli(),client.getprixtick(),
	                              		client.getnumTick(), client.getcategorie(),client.getnumBus(),client.getdateEnreg(),
	                                      client.getheureDepart(),client.getdestination(),client.getnumbg());
	                               Parent parent = loader.getRoot();
	                               Stage stage = new Stage();
	                               stage.setScene(new Scene(parent));
	                              // stage.initStyle(StageStyle.UTILITY);
	                               stage.show();
	                               
	                               stage.setResizable(false);
	                           	/*Image img= new Image("/CSS/imagesjava/bus_48px.png");
	              				  stage.getIcons().add(img);
	              				stage.setTitle("UNITED EXPRESS");*/
	                          	 
	                          });
	                           HBox managebtn = new HBox(editIcon, deleteIcon,printIcon);
	                           managebtn.setStyle("-fx-alignment:center");
	                           HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
	                           HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));
	                           HBox.setMargin(printIcon, new Insets(2, 4, 0, 4));
	                           setGraphic(managebtn);

	                           setText(null);

	                       }
	                   }

	               };

	               return cell;
	           };
	            Action.setCellFactory(cellFoctory);
	            tabTick.setItems(listTick);
	            
	            
	       }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Recherche dynamique
		
		
			Afficher(null);
			
		
		
crossicon.setVisible(false);
		
		if(Parametres.theme()=="vrai") {
			gestionT.getStylesheets().clear();	
			gestionT.getStylesheets().add(getClass().getResource("/CSS/darktheme.css").toExternalForm());	
		}else {
			gestionT.getStylesheets().clear();	
	gestionT.getStylesheets().add(getClass().getResource("/CSS/Acceuil.css").toExternalForm());
    }
	}

}
