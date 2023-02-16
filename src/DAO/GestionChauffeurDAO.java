package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Chauffeur;

import connexion.ConnexionDB;

public class GestionChauffeurDAO {
	public static int save(Chauffeur Ti) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		try {
		String sql="INSERT INTO chauffeur(Identifiant,nom,Prenom,Numtel,immatriculation) values(?,?,?,?,?)";
		Stat=con.prepareStatement(sql);
		Stat.setInt(1,Ti.getidch());
		Stat.setString(2,Ti.getnomch());
		Stat.setString(3,Ti.getprch());
		Stat.setInt(4,Ti.getntch());
		Stat.setInt(5,Ti.getimma());
		
		
		valeur=Stat.executeUpdate();
		}
		catch(SQLException e){	
		}
		return valeur;
	}
	public static int Modifierticket(Chauffeur Ti) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
		int valeur=0;
		try {
			String sql="UPDATE chauffeur SET nom=?,Prenom=?,Numtel=?,immatriculation=? WHERE Identifiant=?";
			Stat=con.prepareStatement(sql);
			Stat.setString(1,Ti.getnomch());
			Stat.setString(2,Ti.getprch());
			Stat.setInt(3,Ti.getntch());
			Stat.setInt(4,Ti.getimma());
			Stat.setInt(5,Ti.getidch());
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
	public static Chauffeur rechercheClient(String Identifiant) throws SQLException {
		Connection con=ConnexionDB.connect();
		PreparedStatement Stat=null;
	     Chauffeur Ti=new Chauffeur();
		ResultSet rs=null;
		try {
			String sql="SELECT * from clients where numtick=?";
			Stat=con.prepareStatement(sql);
			Stat.setString(5,Identifiant);
			rs=Stat.executeQuery();
			if(rs.next()){
				Stat.setInt(1,Ti.getidch());
				Stat.setString(2,Ti.getnomch());
				Stat.setString(3,Ti.getprch());
				Stat.setInt(4,Ti.getntch());
				Stat.setInt(5,Ti.getimma());
			
				
			}
			}
		catch(SQLException e){
			}
			return Ti;		
		}
	
	
}
