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
		
		public Hotel getHotelManager(int id_manager) {
			Hotel hotel = new Hotel();
			try {
				Connection cnx = ConnectionDB.loadDatabase();
				System.out.println("plala");
				PreparedStatement ps = cnx.prepareStatement("select personne.id_prs,hotel.id_hotel,hotel.nom_hotel, hotel.ville_hotel,hotel.adresse_hotel,hotel.tel_hotel"
						+ ", hotel.description, hotel.image_hotel,hotel.nbr_etoiles from hotel,personne where hotel.id_prs=personne.id_prs;");
			
				System.out.println(ps);
				ResultSet rs = ps.executeQuery();
				System.out.println(rs);
				
				if(rs.next()) {
					
					hotel.setId_hotel(rs.getInt("id_hotel"));
					hotel.setNom_hotel(rs.getString("nom_hotel"));
					hotel.setVille_hotel(rs.getString("ville_hotel"));
					hotel.setNbr_etoiles(rs.getString("nbr_etoiles"));
					hotel.setImage_hotel(rs.getString("image_hotel"));
					hotel.setAdresse_hotel(rs.getString("adresse_hotel"));
					hotel.setDescription(rs.getString("description"));
					hotel.setTel_hotel(rs.getString("tel_hotel"));
					hotel.setId_prs(rs.getInt("id_prs"));
					System.out.println(hotel.getAdresse_hotel());
					System.out.println(hotel.getId_prs());
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return hotel;
		}
		
		//Update hotel data
		public int updateHotel(Hotel h) {
			int rowUpdated = 0;
			try {
				Connection cnx = ConnectionDB.loadDatabase();
				PreparedStatement ps = cnx.prepareStatement("update hotel set nom_hotel=?, ville_hotel=?,nbr_etoiles=?,"
						+ "adresse_hotel=?,description=?, tel_hotel=?  where id_hotel=?;");
				System.out.println("cole");
				ps.setString(1, h.getNom_hotel());
				ps.setString(2, h.getVille_hotel());
				ps.setString(3, h.getNbr_etoiles());
				
				ps.setString(4, h.getAdresse_hotel());
				ps.setString(5, h.getDescription());
				ps.setString(6, h.getTel_hotel());
				
				ps.setInt(7, h.getId_hotel());
				System.out.println("colee");
				rowUpdated= ps.executeUpdate();
				
			}catch(Exception e) {
				System.out.println("so sorry");
				e.printStackTrace();
			}
			return rowUpdated;
		}
		
		public int deleteHotel(int id) {
			int status = 0;
			try {
				Connection cnx = ConnectionDB.loadDatabase();
				PreparedStatement ps = cnx.prepareStatement("delete from hotel where id_hotel=?;");
				ps.setInt(1, id);
				status = ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return status;
		}
	
}
