package presentation;

import java.io.IOException;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Restaurant;
import dataAccess.DAOManager;

@WebServlet("/restaurant")
public class RestaurantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Restaurant> restaurantsList = DAOManager.getInstance().getAllRestaurants();

        final JsonArrayBuilder jab = Json.createArrayBuilder();

        restaurantsList.forEach(restaurant -> {
            final JsonObjectBuilder restaurant_job = Json.createObjectBuilder();
            restaurant_job.add("id", restaurant.getId());
            restaurant_job.add("name", restaurant.getName());

            jab.add(restaurant_job);
        });

        final JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("restaurants", jab);

        Json.createWriter(resp.getOutputStream()).writeObject(job.build());
    }

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
