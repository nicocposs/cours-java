package org.formation.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.formation.hibernate.entity.Conseiller;
import org.formation.service.IService;
import org.formation.service.ServiceImpl;



/**
 * Servlet implementation class ServletAdd
 */
@WebServlet("/ServletAdd")
public class ServletAdd extends HttpServlet {
	
	private IService service = new ServiceImpl();



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/result/creation.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String nom = request.getParameter("nom");
	String prenom = request.getParameter("prenom");
	Integer salaire = Integer.parseInt(request.getParameter("salaire"));
	LocalDate dateDeNaissance = LocalDate.parse(request.getParameter("dateDeNaissance"));
	
	Conseiller c = new Conseiller(prenom, nom, dateDeNaissance, salaire);
	
	service.addConseiller(c);
	
	request.getRequestDispatcher("index.html").forward(request, response);
	}

}
