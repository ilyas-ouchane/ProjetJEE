package projet.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.beans.Chambre;
import projet.beans.Hotel;
import projet.db.ChambreDB;
import projet.db.HotelDB;

/**
 * Servlet implementation class GetOneHotelData
 */
@WebServlet("/GetOneHotelData")
public class GetOneHotelData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HotelDB hoteldb = null;
	 ChambreDB chdb = null;
    public GetOneHotelData() {
        super();
        hoteldb = new HotelDB();
        chdb = new ChambreDB();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(true);	
			int id = Integer.parseInt(request.getParameter("hotel"));
			session.setAttribute("id_hotel", id);
	        Hotel existingHotel = hoteldb.find(id);
			
			 List<Chambre> rooms= chdb.getRoomsById(id);
			 
			 System.out.println(rooms);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("hotel-single.jsp");
	        request.setAttribute("rooms", rooms);
	        request.setAttribute("h", existingHotel);
	        dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
