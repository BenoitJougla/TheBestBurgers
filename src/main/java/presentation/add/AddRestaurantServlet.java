package presentation.add;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Restaurant;
import presentation.ErrorResponse;

@WebServlet("/add/restaurant")
public class AddRestaurantServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");

        final Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setLatitude(0.0);
        restaurant.setLongitude(0.0);

        try {
            restaurant.save();
        } catch (final RuntimeException e) {
            final ErrorJsonBuilder json = new ErrorJsonBuilder();
            json.add("restaurantName", "Ce restaurant existe déjà");
            ErrorResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, json.build(), resp);
        }
    }

}
