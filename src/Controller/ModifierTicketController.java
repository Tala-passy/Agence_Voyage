package Controller;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import DAO.GestionTicketDAO;
import Model.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class ModifierTicketController implements Initializable {
	 @FXML
	    private JFXDatePicker dateEnreg;

	    @FXML
	    private JFXTimePicker Hdep;
	
	  @FXML
	    private JFXTextField numgui;

	    @FXML
	    private JFXTextField numtick;

	    @FXML
	    private RadioButton vip;
	    
	    @FXML
	    private RadioButton classique;
	    @FXML
	    private JFXTextField prix;


	    @FXML
	    private JFXTextField ncnicli;

	    @FXML
	    private JFXTextField ntelcli;

	    @FXML
	    private JFXTextField Ncli;

	    @FXML
	    private JFXTextField bus;

	    @FXML
	    private JFXButton enreg;

	    @FXML
	    private JFXButton effacer;
	    
	    @FXML
	    private AnchorPane main;

	    @FXML
	    private JFXComboBox<String> cat;

	    @FXML
	    private JFXComboBox<String> destination;
	    
	    @FXML
	    private JFXComboBox<Integer> numplc;

	    @FXML
	    private JFXComboBox<Integer> numbg;
	    
	    ObservableList<String> bg= FXCollections.observableArrayList("Classique","VIP");
	   
	    
	    ObservableList<String> ds= FXCollections.observableArrayList("Baffoussam","Yaounde"," Kribi");
	    ObservableList<Integer> p= FXCollections.observableArrayList(0,1,2,3,4,5,6,7,8,9,10);
	    ObservableList<Integer> u= FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
	    
	    
		@FXML
	    void Effacer(ActionEvent event) {
	    	
	    	Ncli.clear();
	    	ntelcli.clear();
	    	bus.clear();
	    	numbg.getSelectionModel().clearSelection();
	    	numplc.getSelectionModel().clearSelection();
	    	numtick.clear();
	    	destination.getSelectionModel().clearSelection();
	    	dateEnreg.setValue(null);
	    	Hdep.setValue(null);
	    	ncnicli.clear();
	    	cat.getSelectionModel().clearSelection();
	    	
	    	
	    }
		
		
		 @FXML
		    void cap(ActionEvent event) {
			 if(cat.getSelectionModel().getSelectedItem().toString().equals("VIP")) {
					prix.setText("10.000 frs");
				}else if(cat.getSelectionModel().getSelectedItem().toString().equals("Classique")) {
					prix.setText("6.000 frs");
				}
		    }
		 

	    @FXML
	    void EnregitrerTicket(ActionEvent event) throws SQLException {
	    	String nomcli = Ncli.getText();
	    	String tel = ntelcli.getText();
          int tele=Integer.parseInt(tel);
          String cni = ncnicli.getText();
         
          int Cni=Integer.parseInt(cni);
          
         
         
          String BUS= bus.getText();
          int Bus=Integer.parseInt(BUS);
          LocalDate d = dateEnreg.getValue();
  		String date=d.toString();
  		LocalTime H = Hdep.getValue();
  		String h=H.toString();
  		SingleSelectionModel<String> pr=cat.getSelectionModel();
  		String ca=pr.getSelectedItem();
  		
  		String pri=prix.getText();
    	int price=Integer.parseInt(pri);
  		SingleSelectionModel<String> dest=destination.getSelectionModel();
  		String des=dest.getSelectedItem();
  		
  		//String b= numbg.getValue().toString();
  		SingleSelectionModel<Integer> nb=numbg.getSelectionModel();
  		int bag=nb.getSelectedItem();
  		
  		SingleSelectionModel<Integer> np=numplc.getSelectionModel();
  		int plc=np.getSelectedItem();
  		
  		if(nomcli.isEmpty()) {
 

  			Alert alert= new Alert(AlertType.INFORMATION);
  			alert.setTitle("Information");
  			alert.setHeaderText("Enregistrement");
  			alert.setContentText("Veuillez remplir tous les chapms");
  			alert.showAndWait();	

  		}else {
  			
  		Client c = new Client();

  		c.setnomcli(nomcli);
  		c.setnumtelcli(tele);
  		c.setprixtick(price);
  		
  		c.setdestination(des);
  		c.setdateEnreg(date);
  		c.setheureDepart(h);
  		c.setnumBus(Bus);
  		c.setnumcnicli(Cni);
  		c.setcategorie(ca);
        c.setnumbg(bag);
      
          Alert alert= new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Modification");
			alert.setHeaderText("Information");
			alert.setContentText("Voulez-vous modifier ce Ticket?");
			Optional<ButtonType> rep = alert.showAndWait();	
			if(rep.get()==ButtonType.OK) {
  		int status =GestionTicketDAO.Modifierticket(c);

if(status>0) {
    		
    		Alert alert1= new Alert(AlertType.INFORMATION);
    		alert1.setTitle("Modification");
    		alert1.setHeaderText("Information");
    		alert1.setContentText("Ticket bien modifié");
    		alert1.showAndWait();	
    		
    		
    	}else {
    		
    		Alert alert1= new Alert(AlertType.INFORMATION);
    		alert1.setTitle("Modification");
    		alert1.setHeaderText("Information");
    		alert1.setContentText("Ticket non modifié");
    		alert1.showAndWait();	
    		
    		
    	}
    	
		}else {
			
			Alert alert1= new Alert(AlertType.INFORMATION);
    		alert1.setTitle("Modification");
    		alert1.setHeaderText("Information");
    		alert1.setContentText("modification annulée");
    		alert1.showAndWait();	
    		
    		
    	}
		
  		}
  		 Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
  	        stage.close();
  		}

	    
	          

	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
destination.setItems(ds);
cat.setItems(bg);
numbg.setItems(p);
numplc.setItems(u);
/*SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
valueFactory.setValue(0);
numbg.setValueFactory(valueFactory);
SpinnerValueFactory<Integer> value = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,70);

value.setValue(1);
numplc.setValueFactory(value);*/




/*public void ac() {
	 /*CurrentValue1=cate.getValue().toString();
	 prix.setText(Integer.toString(CurrentValue1)+"FCFA")*/
	 
	/* if (cate.getValue().toString().equals("Classique")) {
		 CurrentValue1=10000;
		 prix.setText(Integer.toString(CurrentValue1));
	 }else  if (cate.getValue().toString().equals("VIP")) {
		 CurrentValue1=5000;
		 prix.setText(Integer.toString(CurrentValue1));
	 }
	 
}*/



}



	

	public void setUpdate(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void setTextField(String getnomcli, int getnumtelcli, int getnumcnicli,int getprixtick, int i,
			String getcategorie, int getnumBus, String getdateEnreg, String getheureDepart, String getdestination,int getnumbg) {
		// TODO Auto-generated method stub
		
		
	      Ncli.setText(getnomcli);
	      ntelcli.setText(String.valueOf(getnumtelcli));
	      ncnicli.setText(String.valueOf(getnumcnicli));
	     prix.setText(String.valueOf(getprixtick));
	      destination.setValue(getdestination);
	      numtick.setText(String.valueOf(i));
	      bus.setText(String.valueOf(getnumBus));
	      numbg.setValue(getnumbg);
	      cat.setValue(getcategorie);
	      LocalTime time=LocalTime.parse(getheureDepart);
	      Hdep.setValue(time);
	      LocalDate dateN= LocalDate.parse(getdateEnreg);
	      dateEnreg.setValue(dateN);
	      /*hdep1.setText(String.valueOf(getheureDepart));
			datedep.setText(String.valueOf(getdateEnreg));
			datedep1.setText(String.valueOf(getdateEnreg));*/
	      
	    // dateEnreg.setValue(getdateEnreg);
	   // categorie.selectToggle(get);
		
		
	}


}
