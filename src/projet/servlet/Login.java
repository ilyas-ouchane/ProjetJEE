package projet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.beans.Personne;
import projet.db.PersonneDB;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(request.getServletContext().getContextPath()+ "/login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonneDB prsdb = new PersonneDB();
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		Personne prs = new Personne();
		prs.setEmail(request.getParameter("email"));
		prs.setPassword_prs(request.getParameter("password"));
		String status = prsdb.validate(prs);
		try {
			if(status.equals("success")) {
				HttpSession session = request.getSession(true);	
				session.setAttribute("currentSessionUser",prs); 
				response.sendRedirect("loginsuccess.jsp");
			}else {
				request.setAttribute("test", status );
				out.print(status);
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
