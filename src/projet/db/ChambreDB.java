package projet.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import projet.beans.Chambre;

public class ChambreDB {
	
	
	public List<Chambre> getRoomsById(int id_hotel){
		List<Chambre> rooms = new ArrayList<Chambre>();
		try {
			Connection cnx = ConnectionDB.loadDatabase();
			System.out.println("jeu");
			PreparedStatement ps = cnx.prepareStatement("select * from chambre where id_hotel=? and etat_ch=0;");
			ps.setInt(1, id_hotel);
			System.out.println("fie");
			ResultSet rs = ps.executeQuery();
			System.out.println("yew");
			while(rs.next()) {
				Chambre room = new Chambre();
				System.out.println("ppopo");
				room.setId_ch(rs.getInt("id_ch"));
				room.setId_hotel(rs.getInt("id_hotel"));
				room.setId_deal(rs.getInt("id_deal"));
				room.setEtat_ch(rs.getInt("etat_ch"));
				System.out.println("lalal");
				room.setDate_end(rs.getDate("date_end"));
				System.out.println("lalal");
				room.setDate_init(rs.getDate("date_init"));
				System.out.println("lalal");
				room.setNbr_pers(rs.getInt("nbr_pers"));
				System.out.println("lalal");
				
				room.setSuperfice(rs.getString("superfice"));
				System.out.println("lalal");
				room.setDescp_ch(rs.getString("descp_ch"));
				System.out.println("lalal");
				room.setPrix_ch(rs.getString("prix_ch"));
				System.out.println("lalal");
				room.setType_ch(rs.getInt("type_ch"));
				System.out.println("psak");
				room.setImage_ch(rs.getString("image_ch"));
				room.setTitre_ch(rs.getString("titre_ch"));
				rooms.add(room);
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return rooms;
	}
}
