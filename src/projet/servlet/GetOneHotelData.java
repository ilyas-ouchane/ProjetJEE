package projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.beans.Hotel;
import projet.db.HotelDB;

/**
 * Servlet implementation class GetOneHotelData
 */
@WebServlet("/GetOneHotelData")
public class GetOneHotelData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HotelDB hoteldb = null;
    public GetOneHotelData() {
        super();
        hoteldb = new HotelDB();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id = Integer.parseInt(request.getParameter("hotel"));
	        Hotel existingHotel = hoteldb.find(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("singhotel.jsp");
	        request.setAttribute("h", existingHotel);
	        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
