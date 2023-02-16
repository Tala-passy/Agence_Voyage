 package DAO;

import java.sql.Connection;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Vehicule;
import connexion.ConnexionDB;

public class GestionVehicules {
	public static int save(Vehicule Ve) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		try {
		String sql="INSERT INTO vehicule(imma,numbus,typebus,nombreplaces,etat,itineraire,datedep,heureDepart,heureArrive) values(?,?,?,?,?,?,?,?,?)";
		Stat=con.prepareStatement(sql);
		Stat.setString(1,Ve.getImma());
		Stat.setInt(2,Ve.getNumbus());
		Stat.setString(3,Ve.getTypebus());
		Stat.setInt(4,Ve.getNbrplc());
		Stat.setString(5,Ve.getEtat());
		
		valeur=Stat.executeUpdate();
		}
		catch(SQLException e){	
		}
		return valeur;
	}
	public static Vehicule rechercheVehicule(int imma) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
	     Vehicule Ve=new Vehicule();
	    		 ResultSet rs=null;
		try {
			String sql="SELECT * from vehicule where imma=?";
			Stat=con.prepareStatement(sql);
			Stat.setInt(4,imma);
			rs=Stat.executeQuery();
			if(rs.next()){
				Stat=con.prepareStatement(sql);
				Stat.setInt(1,Ve.getNumbus());
				Stat.setString(2,Ve.getTypebus());
				Stat.setInt(3,Ve.getNbrplc());
				Stat.setString(4,Ve.getImma());
				Stat.setString(5,Ve.getdatedep());
				Stat.setString(6,Ve.getheureDepart());
				Stat.setString(7,Ve.getheureArrive());
				
			}
			}
		catch(SQLException e){
			}
			return Ve;		
		}

	public static int deleteVehicule(int imma) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		
		try {
			String sql="DELETE FROM vehicule WHERE imma=?";
			Stat=con.prepareStatement(sql);
			
			Stat.setInt(5,imma);
			
			valeur=Stat.executeUpdate();
			}
			catch(SQLException e){	
			}
			return valeur;		
		}
	
	
	
	public static int ModifierVehicule(Vehicule Ve) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		try {
			String sql="UPDATE vehicule SET numbus=?,typebus=?,nombreplaces=?,etat=?,itineraire=?,datedep=?,heureDepart=?,heureArrive=? WHERE  imma=?";
			Stat=con.prepareStatement(sql);
			Stat.setInt(1,Ve.getNumbus());
			Stat.setString(2,Ve.getTypebus());
			Stat.setInt(3,Ve.getNbrplc());
			Stat.setString(4,Ve.getitineraire());
			Stat.setString(5,Ve.getEtat());
			Stat.setString(6,Ve.getdatedep());
			Stat.setString(7,Ve.getheureDepart());
			Stat.setString(8,Ve.getheureArrive());
			Stat.setString(9,Ve.getImma());
			valeur=Stat.executeUpdate();
			}
			catch(SQLException e){	
			}
			return valeur;		
		}
	
}

