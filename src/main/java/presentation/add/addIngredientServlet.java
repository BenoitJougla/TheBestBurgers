package presentation.add;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Ingredient;

@WebServlet("/add/ingredient")
public class addIngredientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final String picture = req.getParameter("picture");

        final Ingredient ingredient = new Ingredient(name);

        if (picture != null) {
            ingredient.setPicture(picture);
        }

        try {
            ingredient.save();
        } catch (final RuntimeException e) {
            resp.sendError(500, name + " already exist");
        }
    }

}
