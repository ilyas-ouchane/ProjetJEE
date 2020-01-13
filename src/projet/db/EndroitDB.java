package projet.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import projet.beans.Endroit;
public class EndroitDB {
	public List<Endroit> getEndroits(){
		List<Endroit> endroits = new ArrayList<Endroit>();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("select * from endroit;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Endroit end = new Endroit();
				end.setId_endroit(rs.getInt("id_endroit"));
				end.setNom_endroit(rs.getString("nom_endroit"));
				end.setVille_endroit(rs.getString("ville_endroit"));
				end.setLocation_endroit(rs.getString("localisation_endroit"));
				end.setImage_endroit(rs.getString("image_endroit"));
				end.setDescp_endroit(rs.getString("descp_endroit"));
				endroits.add(end);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return endroits;
	}
	
	public String AddEndroit(Endroit e) {
		int rslt=0;
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			PreparedStatement ps = cnx.prepareStatement("Insert into endroit(id_endroit,nom_endroit,ville_endroit,descp_endroit,localisation_endroit,"
					+ "image_endroit) values(?,?,?,?,?,?);");
			ps.setString(1, null);
			ps.setString(2, e.getNom_endroit());
			System.out.println("lol");
			ps.setString(3, e.getVille_endroit());
			System.out.println("lol");
			ps.setString(4, e.getDescp_endroit());
			System.out.println("lol");
			ps.setString(5, e.getLocation_endroit());
			System.out.println("lol");
			ps.setString(6, e.getImage_endroit());
			System.out.println("lol");
			rslt = ps.executeUpdate();
			System.out.println("lol");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		if(rslt!=0) {
			return "sc";
		}else return "fls";
	}
}
