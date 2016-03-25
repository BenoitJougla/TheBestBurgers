package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.RestaurantBean;
import business.Restaurant;

@WebServlet("/restaurant")
public class RestaurantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // allow adding burger only if the user in logged in
        final HttpSession session = req.getSession();

        if (session == null || session.getAttribute("user") == null) {
            req.getRequestDispatcher("/signin.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/addRestaurant.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final String latitude = req.getParameter("latitude");
        final String longitude = req.getParameter("longitude");

        if (name != null && latitude != null && longitude != null) {
            final RestaurantBean restaurantBean = new RestaurantBean();
            restaurantBean.setName(name);
            restaurantBean.setLatitude(Double.parseDouble(latitude));
            restaurantBean.setLongitude(Double.parseDouble(longitude));

            final Restaurant restaurant = new Restaurant(restaurantBean);
            restaurant.save();
        }

        req.getRequestDispatcher("/restaurants").forward(req, resp);
    }
}
