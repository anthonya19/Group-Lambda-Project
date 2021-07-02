package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeliveryDAOImpl;
import model.FeedBack;

public class ClientLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private DeliveryDAOImpl dao;
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		dao = new DeliveryDAOImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//FeedBack feedBack = new FeedBack(req.getParameter("name"), req.getParameter("email"), req.getParameter("phone"),
		//		req.getParameter("message"));
		//dao.addfeedBack(feedBack);
		//System.out.println(feedBack.toString());
		System.out.println(req.getParameter("email")+"  "+ req.getParameter("pwd"));
		req.setAttribute("login", "Login");
		req.getRequestDispatcher("ClientHomePage.jsp").forward(req, resp);
	}
}
