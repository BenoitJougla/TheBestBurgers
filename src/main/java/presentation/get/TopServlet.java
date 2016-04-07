package presentation.get;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Burger;
import dataAccess.DAOManager;

@WebServlet("/top")
public class TopServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Burger> burgerList = DAOManager.getInstance().getAllBurgers();
		List<BurgerViewBean> viewBeanList = new ArrayList<BurgerViewBean>();
		Collections.sort(burgerList);
		for(Burger b : burgerList){
			viewBeanList.add(new BurgerViewBean(b));
		}
		req.setAttribute("sortedList", viewBeanList);
		
		final RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/top.jsp");
        rd.forward(req, resp);
		
	}
}

