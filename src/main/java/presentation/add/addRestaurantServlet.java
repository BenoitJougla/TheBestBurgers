package presentation.add;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Restaurant;

@WebServlet("/add/restaurant")
public class addRestaurantServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final String latitude = req.getParameter("latitude");
        final String longitude = req.getParameter("longitude");

        final Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setLatitude(Double.parseDouble(latitude));
        restaurant.setLongitude(Double.parseDouble(longitude));

        try {
            restaurant.save();
        } catch (final RuntimeException e) {
            resp.sendError(500, e.getMessage());
        }
    }

}
