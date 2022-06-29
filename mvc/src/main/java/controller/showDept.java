package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.DeptNumService;
import services.DeptPair;
import services.NumDeptMapper;

/**
 * Servlet implementation class showDept
 */
@WebServlet("/showDept")
public class showDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptNumService deptNumMapper = new NumDeptMapper();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptNum = request.getParameter("dept");
		
		deptNum = deptNum.trim();
		String deptName = deptNumMapper.findDept(deptNum);
		DeptPair pair = new DeptPair(deptNum,deptName);
		
		RequestDispatcher rqd;
		
		if(deptNum.isEmpty()) {
			rqd = request.getRequestDispatcher("/WEB-INF/results/missing-num.jsp");
		}else if(pair.getDeptName() == null) {
			request.setAttribute("deptInfo", pair);
			rqd = request.getRequestDispatcher("/WEB-INF/results/unknown-num.jsp");
		}else {
			request.setAttribute("deptInfo", pair);
			rqd = request.getRequestDispatcher("/WEB-INF/results/show-department.jsp");
		}
		
		rqd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
