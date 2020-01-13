package projet.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import projet.beans.Personne;

public class PersonneDB implements Serializable{
	
	public PersonneDB() {
		super();
	}
	//Récupérer les utilisateurs
	public List<Personne> getAll(){
		List<Personne> personnes = new ArrayList<Personne>();
		
		ResultSet resultat = null;
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement statement = cnx.prepareStatement("SELECT * FROM personne;");           
            resultat = statement.executeQuery();
            while(resultat.next()) {
            	int id = resultat.getInt("id_prs");
            	String nom = resultat.getString("nom_prs") ;
            	String prenom = resultat.getString("prenom_prs") ;
            	String email = resultat.getString("email") ;
            	String tele = resultat.getString("tel_prs") ;
            	String type= resultat.getString("type_prs") ;
            	String password= resultat.getString("password_prs") ;
            	Personne personne = new Personne();
            	personne.setId_prs(id);
            	personne.setNom_prs(nom);
            	personne.setPrenom_prs(prenom);
            	personne.setEmail(email);
            	personne.setTel_prs(tele);
            	personne.setType_prs(type);
            	personne.setPassword_prs(password);
            	personnes.add(personne);
            	cnx.close();
            }
		}catch(Exception e ) {
			e.printStackTrace();
		}
		return personnes;
		
	}
	//delete un utilisateur
	public void delete(int id) {
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement stmt = cnx.prepareStatement("delete from personne where id = "+id);
			stmt.executeUpdate();
			cnx.close();
			
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	//modifier un utilisateur
	public boolean update(Personne p) {
		try {
		    Connection connexion = (Connection ) ConnectionDB.loadDatabase();
		    PreparedStatement stmt=connexion.prepareStatement("update personne set nom_prs=?, prenom_prs=?, tel_prs=?, password_prs=?   where id=?"); 
			stmt.setString(1,p.getNom_prs());
			stmt.setString(2,p.getPrenom_prs());
			stmt.setString(3,p.getTel_prs());
			stmt.setString(4, p.getPassword_prs());
			stmt.setInt(5, p.getId_prs());
			int i =stmt.executeUpdate();
			if(i == 1) {
				connexion.close();
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	//Insérer un utilisateur
	public String getInsert(Personne p) {
		int rslt = 0;
		Connection cnx = ConnectionDB.loadDatabase();
		System.out.println("coll");
		try {
			System.out.println("hey");
			PreparedStatement ps = cnx.prepareStatement("Insert into personne(id_prs,nom_prs,prenom_prs,email,tel_prs,type_prs,password_prs) values(?,?,?,?,?,?,?);");
			System.out.println(ps);
			System.out.println("hello");
			ps.setString(1, null);
			ps.setString(2, p.getNom_prs());
			ps.setString(3, p.getPrenom_prs());
			System.out.println("pe");
			ps.setString(4, p.getEmail());
			ps.setString(5, p.getTel_prs());
			ps.setString(6, p.getType_prs());
			ps.setString(7, p.getPassword_prs());
			rslt =  ps.executeUpdate();
			System.out.println("cooooool");
		}catch(Exception e) {
			System.out.println("sorry");
			e.printStackTrace();
		}
		if(rslt!=0) {
			return "sc";
		}else return "nn";
		
		
	}
	//Vérifier le login
	public String validate(Personne p) {
		String status = null;
		
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("select * from personne");
			ResultSet st = ps.executeQuery();
			String email = p.getEmail();
			String password = p.getPassword_prs();
			String type = p.getType_prs();
			System.out.println(type);
			while(st.next()) {
				if(email.equals(st.getString("email"))) {
					if(password.equals(st.getString("password_prs"))) {
						status = "success";
					}else {
						status = "password incorrecte";
					}
				}else {
					status = "email not found";
				}
			}
			cnx.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}

}
