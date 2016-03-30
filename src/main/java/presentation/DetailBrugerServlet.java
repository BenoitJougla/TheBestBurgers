package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Burger;
import dataAccess.DAOManager;

@WebServlet("/detailBurger")
public class DetailBrugerServlet extends HttpServlet {
	
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String id = req.getParameter("id");
		 
		 if(id != null){
			 Burger b = DAOManager.getInstance().getBurgerById(Long.parseLong(id));
			 req.setAttribute("burger", b);
			 final RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/detailBurger.jsp");
		     rd.forward(req, resp);
		 }else{
			 resp.sendRedirect(req.getContextPath() + "/");
		 }
		 
		 
	 }

}
