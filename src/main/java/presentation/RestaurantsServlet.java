package presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Restaurant;
import dataAccess.DAOManager;

@WebServlet("/restaurants")
public class RestaurantsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final List<Restaurant> restaurantsList = DAOManager.getInstance().getAllRestaurants();

        req.setAttribute("restaurants", restaurantsList);

        final RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/restaurants.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doGet(req, resp);
    }

}
