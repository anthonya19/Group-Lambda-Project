package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeliveryDAO;
import dao.DeliveryDAOImpl;
import model.FeedBack;

public class MainServlet extends HttpServlet {

	DeliveryDAOImpl dao;
	public void init()throws ServletException{
		dao=new DeliveryDAOImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		req.getRequestDispatcher("Delivery.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		FeedBack feedBack=new FeedBack(req.getParameter("name"), req.getParameter("email"), req.getParameter("phone"),req.getParameter("message") );
		dao.addfeedBack(feedBack);
		System.out.println(feedBack.toString());
		//req.setAttribute("FeedBack", feedBack);
		req.getRequestDispatcher("Delivery.jsp").forward(req, resp);
		
	}
	
}
