package org.formation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.formation.hibernate.entity.Conseiller;
import org.formation.service.IService;
import org.formation.service.ServiceImpl;


@WebServlet("/ServletDelete")
public class ServletDelete extends HttpServlet {
	
	private IService service = new ServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		service.deleteConseiller(id);
		request.getRequestDispatcher("ServletList").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
