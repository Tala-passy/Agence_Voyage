package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Client;
import connexion.ConnexionDB;




public class GestionTicketDAO {
	public static int save(Client Ti) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		try {
			String sql="INSERT INTO client('nomcli', 'numtelcli', numcnicli, prixtick, numtick,dateEnreg,HeureDep,Categorie,destination,numbagages,numbus) values(?,?,?,?,NULL,?,?,?,?,?,?)";
			Stat=con.prepareStatement(sql);
			Stat.setString(1,Ti.getnomcli());
			Stat.setInt(2,Ti.getnumtelcli());
			Stat.setInt(3,Ti.getnumcnicli());
			Stat.setInt(4,Ti.getprixtick());
			Stat.setString(5, null);
			Stat.setString(6,Ti.getdateEnreg());
			Stat.setString(7,Ti.getheureDepart());
			Stat.setString(8,Ti.getcategorie());
			Stat.setString(9,Ti.getdestination());
			Stat.setInt(10,Ti.getnumbg());
			Stat.setInt(11,Ti.getnumBus());
			
			valeur=Stat.executeUpdate();
		}
		catch(SQLException e){	
		}
		return valeur;
	}
	public static int Modifierticket(Client Ti) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		try {
			String sql="UPDATE clients SET nomcli=?, numtelcli=?, numcnicli=?, prixtick=?, dateEnreg=?,HeureDep=?,Categorie=?,numbus=?,destination=?,numbagages=? WHERE numtick=?";
			Stat=con.prepareStatement(sql);
			Stat.setString(1,Ti.getnomcli());
			Stat.setInt(2,Ti.getnumtelcli());
			Stat.setInt(3,Ti.getnumcnicli());
			Stat.setInt(4,Ti.getprixtick());
			Stat.setString(5,Ti.getdateEnreg());
			Stat.setString(6,Ti.getheureDepart());
			Stat.setString(7,Ti.getcategorie());
			Stat.setInt(8,Ti.getnumBus());
			Stat.setString(9,Ti.getdestination());
			Stat.setInt(10,Ti.getnumbg());
			
			Stat.setString(11,Ti.getnumTick());
			valeur=Stat.executeUpdate();
			}
			catch(SQLException e){	
			}
			return valeur;		
		}
	
	public static int deleteClient(int numTick) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		
		try {
			String sql="DELETE FROM clients WHERE numtick=?";
			Stat=con.prepareStatement(sql);
			
			Stat.setInt(5,numTick);
			
			valeur=Stat.executeUpdate();
			}
			catch(SQLException e){	
			}
			return valeur;		
		}
	public static Client rechercheClient(String numTick) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
	     Client Ti=new Client();
		ResultSet rs=null;
		try {
			String sql="SELECT * from clients where numtick=?";
			Stat=con.prepareStatement(sql);
			Stat.setString(5,numTick);
			rs=Stat.executeQuery();
			if(rs.next()){
				Ti.setnomcli(rs.getString(1));
				Ti.setnumtelcli(rs.getInt(2));
				Ti.setnumcnicli(rs.getInt(3));
				Ti.setprixtick(rs.getInt(4));

				Ti.setdateEnreg(rs.getString(6));
				Ti.setheureDepart(rs.getString(7));
				Ti.setcategorie(rs.getString(8));
				Ti.setnumBus(rs.getInt(9));
				
			}
			}
		catch(SQLException e){
			}
			return Ti;		
		}
	
	
}
