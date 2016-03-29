package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BurgerBean;
import business.Burger;


@WebServlet("/burger")
public class BurgerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String picture = request.getParameter("picture");
        
        if(name != null && description != null && picture != null){
        	
        	BurgerBean burgerBean = new BurgerBean();
        	burgerBean.setName(name);
        	burgerBean.setDescription(description);
        	burgerBean.setPicture(picture);
        	Burger b = new Burger(burgerBean);
        	b.save();
        }
        request.getRequestDispatcher("/").forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	//allow adding burger only if the user in logged in
    	final HttpSession session = req.getSession();

        if (session == null || session.getAttribute("user") == null) {
        	req.getRequestDispatcher("/signin.jsp").forward(req, resp);
        }else{
        	req.getRequestDispatcher("/WEB-INF/addBurger.jsp").forward(req, resp);
        }
    }

}
