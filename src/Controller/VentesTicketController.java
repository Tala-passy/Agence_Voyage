package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import connexion.ConnexionDB;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

public class VentesTicketController implements Initializable {
	 @FXML
	    private AnchorPane VentesT;

	    @FXML
	    private LineChart<String, Integer> mensuelles;

	    @FXML
	    private LineChart<String, Integer> Annuelles;
	    int janvier=0;
	    int fevrier=0;
	    int mars=0;
	    int avril=0;
	    int mai=0;
	    int juin=0;
	    int juillet=0;
	    int aout=0;
	    int septembre=0;
	    int octobre=0;
	    int novembre=0;
	    int decembre=0;
	    
	    Connection con=null;
	    
	    LocalDate date = LocalDate.now();
  int  year=date.getYear();
	    public void janvier()  {
	    	
	    	try {
				con= ConnexionDB.connect();
				String sql = "SELECT SUM(prixtick) FROM `client` WHERE dateEnreg BETWEEN '"+year+"-01-01' and '"+year+"-01-31'";
				
				PreparedStatement Stat = con.prepareStatement(sql);

				ResultSet rs = Stat.executeQuery();
				if(rs.next()) {
				janvier=rs.getInt(1);
				}
				
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	    }
	    
	    public void fevrier() throws SQLException {
	    	//2. fevrier
			 con= ConnexionDB.connect();
				String sql = "SELECT SUM(prixtick) FROM `client` WHERE dateEnreg BETWEEN '"+year+"-02-01' and '"+year+"-02-28'";
				PreparedStatement Stat = con.prepareStatement(sql);

				ResultSet rs = Stat.executeQuery();
				if(rs.next()) {
					 fevrier=rs.getInt(1);
					}
					
					con.close();
					
	    }
	    public void mars() throws SQLException {
	    	//3. mars
			 con= ConnexionDB.connect();
		String sql2 = "SELECT SUM(prixtick) FROM `client` WHERE dateEnreg BETWEEN '"+year+"-03-01' and '"+year+"-03-31'";
		PreparedStatement Stat = con.prepareStatement(sql2);
		ResultSet rs2 = Stat.executeQuery();
		if(rs2.next()) {
				 mars=rs2.getInt(1);
				}
				
				con.close();
				
	    }
	    public void  avril() throws SQLException {
	    	//4. avril
			 con= ConnexionDB.connect();
			String sql3 = "SELECT SUM(prixtick) FROM `client` WHERE dateEnreg BETWEEN '"+year+"-04-01' and '"+year+"-04-30'";
			PreparedStatement Stat = con.prepareStatement(sql3);

			ResultSet rs3 = Stat.executeQuery();
			if(rs3.next()) {
					 avril=rs3.getInt(1);
					}
						
					con.close();
				
	    }
	    public void mai() throws SQLException {
	    	//5. mai
			con= ConnexionDB.connect();
	String sql4 = "SELECT SUM(prixtick) FROM `client` WHERE dateEnreg BETWEEN '"+year+"-05-01' and '"+year+"-05-31'";
    PreparedStatement Stat = con.prepareStatement(sql4);

	ResultSet rs4 = Stat.executeQuery();
	if(rs4.next()) {
	 mai=rs4.getInt(1);
									}
	
	con.close();

	    }
	    public void juin() throws SQLException {
	    	//6. juin
	    	 con= ConnexionDB.connect();
	    		String sql5 = "SELECT SUM(prixtick) FROM `client` WHERE dateEnreg BETWEEN '"+year+"-06-01' and '"+year+"-06-30'";
	    		PreparedStatement Stat = con.prepareStatement(sql5);

	    		ResultSet rs5 = Stat.executeQuery();
	    	while(rs5.next()) {
	    				 juin=rs5.getInt(1);
	    				 
	    				}
	    				
	    				con.close();
	    			
	    }
	    public void juillet() throws SQLException {
	    	 con= ConnexionDB.connect();
				String sql6 = "SELECT SUM(prixtick) FROM `client` WHERE dateEnreg BETWEEN '"+year+"-07-01' and '"+year+"-07-31'";
				PreparedStatement Stat = con.prepareStatement(sql6);

				ResultSet rs6 = Stat.executeQuery();
				if(rs6.next()) {
					 juillet=rs6.getInt(1);
						}
					
						con.close();
						    }
	    public void aout() throws SQLException {
	    	//8. aout
			 con= ConnexionDB.connect();
String sql7 = "SELECT SUM(prixtick) FROM `client` WHERE dateEnreg BETWEEN '"+year+"-08-01' and '"+year+"-08-31'";
PreparedStatement Stat = con.prepareStatement(sql7);

ResultSet rs7 = Stat.executeQuery();
if(rs7.next()) {
aout=rs7.getInt(1);
	}

	con.close();

	    }
	    public void septembre() throws SQLException {
			
			//9. septembre
			 con= ConnexionDB.connect();
			String sql8 = "SELECT SUM(prixtick) FROM `client` WHERE dateEnreg BETWEEN '"+year+"-09-01' and '"+year+"-09-30'";
			PreparedStatement Stat = con.prepareStatement(sql8);

			ResultSet rs8 = Stat.executeQuery();
			if(rs8.next()) {
			 septembre=rs8.getInt(1);
					}
	
	con.close();

	    }
	    public void octobre() throws SQLException {
	    	//10. octobre
	   	 con= ConnexionDB.connect();
	   			String sql9 = "SELECT SUM(prixtick) FROM `client` WHERE dateEnreg BETWEEN '"+year+"-10-01' and '"+year+"-10-31'";
	   			PreparedStatement Stat = con.prepareStatement(sql9);

	   			ResultSet rs9 = Stat.executeQuery();
	   			if(rs9.next()) {
	   			 octobre=rs9.getInt(1);
	   					}
	   		
	   			con.close();
	   			
	    }
	    public void novembre() throws SQLException {
	    	//11. novembre
	   	 con= ConnexionDB.connect();
	   			String sql10 = "SELECT SUM(prixtick) FROM `client` WHERE dateEnreg BETWEEN '"+year+"-11-01' and '"+year+"-11-30'";
	   			PreparedStatement Stat = con.prepareStatement(sql10);

	   			ResultSet rs10 = Stat.executeQuery();
	   			if(rs10.next()) {
	   		 novembre=rs10.getInt(1);
	   					}
	 
	   con.close();
	
	    }
	    public void decembre() throws SQLException {
	    	//12. decembre
	    	 con= ConnexionDB.connect();
	    			String sql11 = "SELECT SUM(prixtick) FROM `client` WHERE dateEnreg BETWEEN '"+year+"-12-01' and '"+year+"-12-31'";
	    			PreparedStatement Stat = con.prepareStatement(sql11);

	    			ResultSet rs11 = Stat.executeQuery();
	    			if(rs11.next()) {
	    			decembre=rs11.getInt(1);
	    					}
	    						
	    					con.close();
	    					
	    }
	    @Override
	public void initialize(URL location, ResourceBundle resources) {
		//recuperation des donnees dans la bd

	    try {
	    	janvier();
	    	fevrier();
	    	mars();
	    	avril();
	    	mai();
			juin();
			juillet();
			aout();
			septembre();
			octobre();
			novembre();
			decembre();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(juin);	
		
		// creation de la serie qui va etre ajoutee dans le graph
		XYChart.Series<String,Integer> serie=new XYChart.Series<>();
		
		serie.setName("ventes");
	serie.getData().add(new XYChart.Data<String, Integer>("janvier",janvier));
		serie.getData().add(new XYChart.Data<String, Integer>("Fevrier",fevrier));
		serie.getData().add(new XYChart.Data<String, Integer>("Mars",mars));
		serie.getData().add(new XYChart.Data<String, Integer>("Avril",avril));
		serie.getData().add(new XYChart.Data<String, Integer>("Mai",mai));
		serie.getData().add(new XYChart.Data<String, Integer>("Juin",juin));
		serie.getData().add(new XYChart.Data<String, Integer>("Juillet",juillet));
		serie.getData().add(new XYChart.Data<String, Integer>("Aout",aout));
		serie.getData().add(new XYChart.Data<String, Integer>("Septembre",septembre));
		serie.getData().add(new XYChart.Data<String, Integer>("Octobre",octobre));
		serie.getData().add(new XYChart.Data<String, Integer>("Novembre",novembre));
		serie.getData().add(new XYChart.Data<String, Integer>("Decembre",decembre));
			
		
		mensuelles.getData().add(serie);
		
		
		
		// TODO Auto-generated method stub
		if(Parametres.theme()=="vrai") {
			VentesT.getStylesheets().clear();	
			VentesT.getStylesheets().add(getClass().getResource("/CSS/darktheme.css").toExternalForm());	
		}else {
			VentesT.getStylesheets().clear();	
		VentesT.getStylesheets().add(getClass().getResource("/CSS/Acceuil.css").toExternalForm());
    }
	}

}
