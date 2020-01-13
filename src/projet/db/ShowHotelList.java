package projet.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import projet.beans.Hotel;

public class ShowHotelList {
		public ArrayList<Hotel> ShowList() {
			ArrayList<Hotel> list_hotels = new ArrayList<Hotel>();
			try {
				Connection cnx = ConnectionDB.loadDatabase();
				PreparedStatement ps = cnx.prepareStatement("select id_hotel,nom_hotel, ville_hotel, nbr_etoiles, image_hotel, adresse_hotel,"
						+ "description, tel_hotel from hotel");
				ResultSet st = ps.executeQuery();
				while(st.next()) {
					Hotel h = new Hotel();
					h.setId_hotel(st.getInt("id_hotel"));
		        	h.setNom_hotel(st.getString("nom_hotel"));
		            h.setVille_hotel(st.getString("ville_hotel"));
		            h.setNbr_etoiles(st.getString("nbr_etoiles"));
		            h.setImage_hotel(st.getString("image_hotel"));
		            h.setAdresse_hotel(st.getString("adresse_hotel"));
		            h.setDescription(st.getString("description"));
		            h.setTel_hotel(st.getString("tel_hotel"));
		            list_hotels.add(h);
				}
				cnx.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		return list_hotels;	
		}
		
		public Hotel findHotelById(int id) {
			Hotel h = new Hotel();
			try {
				Connection cnx = ConnectionDB.loadDatabase();
				PreparedStatement ps = cnx.prepareStatement("select id_hotel,nom_hotel, ville_hotel, nbr_etoiles, image_hotel, adresse_hotel,"
						+ "description, tel_hotel from hotel where id_hotel=?");
				ps.setInt(1, id);
				ResultSet st = ps.executeQuery();
				if(st.next()) {
					h.setId_hotel(st.getInt("id_hotel"));
		        	h.setNom_hotel(st.getString("nom_hotel"));
		            h.setVille_hotel(st.getString("ville_hotel"));
		            h.setNbr_etoiles(st.getString("nbr_etoiles"));
		            h.setImage_hotel(st.getString("image_hotel"));
		            h.setAdresse_hotel(st.getString("adresse_hotel"));
		            h.setDescription(st.getString("description"));
		            h.setTel_hotel(st.getString("tel_hotel"));
		           
				}
				
			}catch(Exception e) {
				
			}
				return h;
		}
	
}
