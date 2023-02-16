package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.Printer.MarginType;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TicketController implements Initializable {
	
	
	  @FXML
	    private Label nom;

	    @FXML
	    private Label destina;

	    @FXML
	    private Label datedep;

	    @FXML
	    private Label hdep;

	    @FXML
	    private Label catego;

	    @FXML
	    private Label ntick;

	    @FXML
	    private Label nbagages;

	    @FXML
	    private Label nom1;

	    @FXML
	    private Label destina1;

	    @FXML
	    private Label datedep1;

	    @FXML
	    private Label nbagages1;

	    @FXML
	    private Label ntick1;

	    @FXML
	    private Label hdep1;
	    
	    @FXML
	    private Button print;

	    @FXML
	    private Label prix;
	    
	    @FXML
	    private AnchorPane anchor;
	    
	    void doprintSecond(Node anchor) {
	    	PrinterJob job= PrinterJob.createPrinterJob();
	    	Printer printer= Printer.getDefaultPrinter();
	    	PageLayout pagelayout=printer.createPageLayout(Paper.A3, PageOrientation.LANDSCAPE,MarginType.HARDWARE_MINIMUM);
	    	
	    	
	    	if (job!=null && job.showPrintDialog(anchor.getScene().getWindow())) {
	    		boolean printed =job.printPage(pagelayout,anchor);
	    		if(printed) {
	    			job.endJob();
	    		}else {
	    			Alert alert= new Alert(AlertType.CONFIRMATION);
	    			alert.setTitle("Confirmation");
	    			alert.setHeaderText("Impréssion");
	    			alert.setContentText("Impréssion raté");	
	    		}
	    	}else {
	    		Alert alert= new Alert(AlertType.CONFIRMATION);
    			alert.setTitle("Confirmation");
    			alert.setHeaderText("Impréssion");
    			alert.setContentText("Impréssion Réussie");
	    	}
	    	
	    }
	    @FXML
	    void print(ActionEvent event) {
	    	
	    	doprintSecond(anchor);
	    	
	    	
	    	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
	        stage.close();
	    	

	    }
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void setlabel(String getnomcli, int getnumtelcli, int getnumcnicli, int getprixtick, int i,
			String getcategorie, int getnumBus, String getdateEnreg, String getheureDepart, String getdestination,
			 int getnumbg) {
		// TODO Auto-generated method stub
		
		nom.setText(getnomcli);
		nom1.setText(getnomcli);
		destina.setText(getdestination);
		destina1.setText(getdestination);
		ntick.setText(String.valueOf(i));
		ntick1.setText(String.valueOf(i));
		hdep.setText(String.valueOf(getheureDepart));
		hdep1.setText(String.valueOf(getheureDepart));
		datedep.setText(String.valueOf(getdateEnreg));
		datedep1.setText(String.valueOf(getdateEnreg));
		nbagages.setText(String.valueOf(getnumbg));
		nbagages1.setText(String.valueOf(getnumbg));
		catego.setText(getcategorie);
		prix.setText(String.valueOf(getprixtick));
	}

	public void setUpdate(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
