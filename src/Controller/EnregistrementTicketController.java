package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import DAO.GestionTicketDAO;
import Model.Client;
import connexion.ConnexionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class EnregistrementTicketController  implements Initializable {
	  @FXML
	    private StackPane main;

	    @FXML
	    private JFXButton enreg;

	    @FXML
	    private JFXButton effacer;

	    @FXML
	    private JFXDatePicker dateEnreg;

	    @FXML
	    private JFXTextField ncnicli;

	    @FXML
	    private JFXTextField ntelcli;

	    @FXML
	    private JFXTextField Ncli;

	    @FXML
	    private JFXComboBox<String> destination;

	    @FXML
	    private JFXComboBox<String> cat;

	    @FXML
	    private JFXTextField prix;

	    @FXML
	    private JFXComboBox<Integer> numbg;

	    @FXML
	    private JFXComboBox<String> Hdep;

	    @FXML
	    private JFXComboBox<Integer > bus;	    
	    ObservableList<String> bg= FXCollections.observableArrayList("Classique","VIP");
	   
	    
	    ObservableList<String> ds= FXCollections.observableArrayList("Baffoussam","Yaounde"," Kribi");
	    ObservableList<Integer> p= FXCollections.observableArrayList(0,1,2,3,4,5,6,7,8,9,10);
	   
	    ObservableList<String> h= FXCollections.observableArrayList("4h","6h","8h","10h","12h","14h","16h","18h","20h","22h");
	    ObservableList <Integer>li = FXCollections.observableArrayList();
		@FXML
	    void Effacer(ActionEvent event) {
	    	
	    	Ncli.clear();
	    	ntelcli.clear();
	    	bus.getSelectionModel().clearSelection();
	    	numbg.getSelectionModel().clearSelection();
	    	Hdep.getSelectionModel().clearSelection();
	    	destination.getSelectionModel().clearSelection();
	    	dateEnreg.setValue(null);
	    	Hdep.setValue(null);
	    	ncnicli.clear();
	    	cat.getSelectionModel().clearSelection();
	    	
	    	
	    }
		
		
		 @FXML
		    void cap(ActionEvent event) {
			 if(cat.getSelectionModel().getSelectedItem().toString().equals("VIP")) {
					prix.setText("10000");
				}else if(cat.getSelectionModel().getSelectedItem().toString().equals("Classique")) {
					prix.setText("6000");
				}else if(cat.getValue().isEmpty()) {
					prix.clear();
				}
			 String query = null;
			 Connection connection = null ;
			 PreparedStatement preparedStatement = null ;
			 ResultSet rs = null ;
			 query = "SELECT numbus FROM vehicule WHERE etat = 'E' and typebus='"+cat.getSelectionModel().getSelectedItem()+"' and "
			 		+ "itineraire='"+destination.getSelectionModel().getSelectedItem()+"'";
			
			 try {
			 	connection = ConnexionDB.connect();
			 	preparedStatement= connection.prepareStatement(query);
			 	rs = preparedStatement.executeQuery();
			 	li.clear();
			 	while(rs.next()) {
			 		
			 		li.add(rs.getInt("numbus"));
			 	}
			 } catch (SQLException e) {
			 	// TODO Auto-generated catch block
			 	e.printStackTrace();
			 }
			 if (li.isEmpty()) {
				 Image img =new Image("/Image/close_window_100px.png");
				 Notifications notification=Notifications.create()
				 .title("Bus indisponible")
				 .text("Il y a plus de bus "+cat.getSelectionModel().getSelectedItem()+" allant a "+destination.getSelectionModel().getSelectedItem())
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
		    }
		 
		 
	    @FXML
	    void EnregitrerTicket(ActionEvent event) throws SQLException {
	    	// recuperation des donnes des diffeerents champs
	    	String nomcli=Ncli.getText();
	    	String tel=ntelcli.getText();
	    	int tele=Integer.parseInt(tel);
	    	String cni=ncnicli.getText();
	    	int Cni=Integer.parseInt(cni);
	    	String des=destination.getSelectionModel().getSelectedItem();
	    	String ca= cat.getSelectionModel().getSelectedItem();
	    	int nb=bus.getSelectionModel().getSelectedItem();
	    	String pri=prix.getText();
	    	int price=Integer.parseInt(pri);
	    	int bag=numbg.getSelectionModel().getSelectedItem();
	    	LocalDate dat=dateEnreg.getValue();
	    	String date=dat.toString();
	    	String hdep=Hdep.getSelectionModel().getSelectedItem();
	    	
	    	// test pour verifier que la date entree n'est pas avant celle d'aujourd'hui
	    	LocalDate datedeb = LocalDate.now();
	    	
	    	if( dat.isBefore(datedeb) ) {
	    		
				 dateEnreg.setValue(null);
				 JFXButton button = new JFXButton ("D'accord");
	 				Alertsmaker.alertmmaterial2(main ,main, Arrays.asList(button),"ENREGISTREMENT","Veuillez re-remplir la date et choisir une date superieur ou egale a celle d'aujourd'hui ");
	 			
				 
	    	}else {
	    		//verification si tout les champs on ete remplis
	    		if((nomcli.isEmpty() || tel.isEmpty() || cni.isEmpty() || des.isEmpty() || ca.isEmpty() || pri.isEmpty() || numbg.getSelectionModel().isEmpty() || date.isEmpty()|| hdep.isEmpty())
    				||(nomcli.isEmpty() && tel.isEmpty() && cni.isEmpty() && des.isEmpty() && ca.isEmpty()&& pri.isEmpty() && numbg.getSelectionModel().isEmpty() && date.isEmpty()&& hdep.isEmpty())) {
   
    			 JFXButton button = new JFXButton ("D'accord");
 				Alertsmaker.alertmmaterial2(main ,main, Arrays.asList(button),"ENREGISTREMENT","Veuillez remplir tous les chapms ");
 			

    		}else {
    			//enregistrement des donnees dans la bd
    			Connection con=ConnexionDB.connect();
    			PreparedStatement Stat=null;
    			int valeur=0;
    			try {
    				String sql="INSERT INTO client(nomcli, numtelcli, numcnicli, prixtick,numtick,dateEnreg,HeureDep,Categorie,destination,numbagages,numbus) values(?,?,?,?,NULL,?,?,?,?,?,?)";
    				Stat=con.prepareStatement(sql);
    				Stat.setString(1, nomcli);
    				Stat.setInt(2,tele);
    				Stat.setInt(3,Cni);
    				Stat.setInt(4,price);
    				
    				Stat.setString(5,date);
    				Stat.setString(6,hdep);
    				Stat.setString(7,ca);
    				Stat.setString(8,des);
    				Stat.setInt(9,bag);
    				Stat.setInt(10,nb);
    				
    				valeur=Stat.executeUpdate();
    			}
    			catch(SQLException e){	
    			}
           
    		

    		if(valeur>0) {

    			 Image img =new Image("/Image/tick_box_100px.png");
				 Notifications notification=Notifications.create()
				 .title("Ticket")
				 .text("Ticket  enregistre")
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

    			Ncli.clear();
    	    	ntelcli.clear();
    	    	bus.getSelectionModel().clearSelection();;
    	    	cat.getSelectionModel().clearSelection();
    	    	dateEnreg.setValue(null);
    	    	Hdep.setValue(null);
    	    	ncnicli.clear();
    	    	prix.clear();
    	    	destination.getSelectionModel().clearSelection();
    	    	numbg.getSelectionModel().clearSelection();
    	    	li.clear();
    	    	
    	    	
    		}else {
    			 Image img =new Image("/Image/close_window_100px.png");
				 Notifications notification=Notifications.create()
				 .title("Ticket")
				 .text("Ticket non enregistre")
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

    		
    		}
	    	}
    		}

    	    
	          

	  
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
destination.setItems(ds);
cat.setItems(bg);
numbg.setItems(p);
Hdep.setItems(h);
main.getStylesheets().add(getClass().getResource("/CSS/Acceuil.css").toExternalForm());
if(Parametres.theme()=="vrai") {
	main.getStylesheets().clear();	
	main.getStylesheets().add(getClass().getResource("/CSS/darktheme.css").toExternalForm());	
}else if(Parametres.theme()=="faux") {
	main.getStylesheets().clear();	
main.getStylesheets().add(getClass().getResource("/CSS/Acceuil.css").toExternalForm());
}

bus.setItems(li);


}

 
 
	

	public void setUpdate(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void setTextField(String getnomcli, int getnumtelcli, int getnumcnicli, String getprixtick,
			String getcategorie, int getnumBus, String getdateEnreg, String getheureDepart, String getdestination,int getnumbg) {
		// TODO Auto-generated method stub
		
		
	      Ncli.setText(getnomcli);
	      ntelcli.setText(String.valueOf(getnumtelcli));
	      ncnicli.setText(String.valueOf(getnumcnicli));
	     prix.setText(getprixtick);
	      destination.setValue(getdestination);
	    
	      bus.setValue(getnumBus);;
	      numbg.setValue(getnumbg);
	     Hdep.setValue(getheureDepart);
	      cat.setValue(getcategorie);
	      		
	      /*hdep1.setText(String.valueOf(getheureDepart));
			datedep.setText(String.valueOf(getdateEnreg));
			datedep1.setText(String.valueOf(getdateEnreg));*/
	      
	    // dateEnreg.setValue(getdateEnreg);
	   // categorie.selectToggle(get);
		
		
	}

	

}
