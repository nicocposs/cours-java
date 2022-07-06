package org.formation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.formation.hibernate.entity.Conseiller;
import org.formation.service.IService;
import org.formation.service.ServiceImpl;


@WebServlet("/ServletList")
public class ServletList extends HttpServlet {
	
	private IService service = new ServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Conseiller> Clist = service.getAll();
		request.setAttribute("list", Clist);
		request.getRequestDispatcher("WEB-INF/result/liste.jsp").forward(request, response);
	}

}
