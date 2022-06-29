package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1328358874047967105L;


	public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<html><body><h1>Hello</h1></body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		System.out.println("Passe dans le post post_nom="+nom+" post_pass="+pass);
		
		request.setAttribute("nom",nom);
		request.setAttribute("pass", pass);
		
		request.getRequestDispatcher("test.jsp").forward(request, response);
	}

}
