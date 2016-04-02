package presentation.get;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import business.Ingredient;
import dataAccess.DAOManager;

@WebServlet("/ingredients")
public class IngredientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Ingredient> ingredientsList = DAOManager.getInstance().getAllIngredients();
        final String json = new Gson().toJson(ingredientsList);
        resp.getOutputStream().write(json.getBytes());
    }

}
