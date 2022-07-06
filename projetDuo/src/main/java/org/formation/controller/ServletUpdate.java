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


@WebServlet("/ServletUpdate")
public class ServletUpdate extends HttpServlet {
	
	private IService service = new ServiceImpl();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Conseiller c = service.getConseiller(id);
		request.setAttribute("conseiller", c);
		request.getRequestDispatcher("WEB-INF/result/update.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Integer salaire = Integer.parseInt(request.getParameter("salaire"));
		LocalDate dateDeNaissance = LocalDate.parse(request.getParameter("dateDeNaissance"));
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		Conseiller c = new Conseiller(prenom, nom, dateDeNaissance, salaire);
		c.setId(id);

		
		service.updateConseiller(c);
		
		request.getRequestDispatcher("ServletList").forward(request, response);
	}

}
