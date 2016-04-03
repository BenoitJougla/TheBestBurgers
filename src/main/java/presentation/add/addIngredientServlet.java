package presentation.add;

import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Ingredient;
import dataAccess.UniqueConstraintException;
import presentation.ErrorResponse;

@WebServlet("/add/ingredient")
public class addIngredientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        if (name == null || name.isEmpty()) {
            final JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("field", "ingredientName");
            job.add("message", "Le nom doit être renseigné");

            ErrorResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, job.build(), resp);
            return;
        }

        final Ingredient ingredient = new Ingredient(name);

        final String picture = req.getParameter("picture");
        if (picture != null) {
            ingredient.setPicture(picture);
        }

        try {
            ingredient.save();
        } catch (final UniqueConstraintException e) {
            final JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("field", "ingredientName");
            job.add("message", "L'ingrédient " + name + " existe déjà");

            ErrorResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, job.build(), resp);
        }
    }

}
