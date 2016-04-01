package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.Burger;
import business.Grade;
import business.Ingredient;
import business.Restaurant;
import business.User;

@WebServlet("/burger")
public class BurgerServlet extends HttpServlet {

    private Grade buildGrade(HttpServletRequest request) {
        final String originality_str = request.getParameter("originality");
        final int originality = Integer.parseInt(originality_str);

        final String quality_str = request.getParameter("quality");
        final int quality = Integer.parseInt(quality_str);

        final String presentation_str = request.getParameter("presentation");
        final int presentation = Integer.parseInt(presentation_str);

        final String tasty_str = request.getParameter("tasty");
        final int taste = Integer.parseInt(tasty_str);

        final String observation = request.getParameter("observation");

        final Grade grade = new Grade();
        grade.setOriginality(originality);
        grade.setQuality(quality);
        grade.setPresentation(presentation);
        grade.setTaste(taste);
        grade.setObservation(observation);

        // User
        final HttpSession session = request.getSession();
        final User user = (User) session.getAttribute("user");
        user.addGrade(grade);

        return grade;
    }

    private List<Ingredient> buildIngredients(HttpServletRequest request) {
        final String[] ingredients_str = request.getParameterValues("ingredients[]");

        final List<Ingredient> ingredients = new ArrayList<>();

        for (final String str : ingredients_str) {
            final long id = Long.parseLong(str);
            ingredients.add(Ingredient.getIngredientById(id));
        }

        return ingredients;
    }

    private Burger buildBurger(HttpServletRequest request) {
        // Grade
        final Grade grade = buildGrade(request);

        // Ingredients
        final List<Ingredient> ingredients = buildIngredients(request);

        // Burger
        final String name = request.getParameter("name");
        final String description = request.getParameter("description");
        final String picture = request.getParameter("picture");

        final Burger burger = new Burger();
        burger.setName(name);
        burger.setDescription(description);
        burger.setPicture(picture);
        burger.setIngredients(ingredients);
        burger.addGrade(grade);

        return burger;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Burger
        final Burger burger = buildBurger(request);

        // Restaurant
        final String restaurant_str = request.getParameter("restaurant");
        final long restaurantId = Long.parseLong(restaurant_str);
        final Restaurant restaurant = Restaurant.getRestaurant(restaurantId);
        restaurant.addBurger(burger);

        restaurant.save();

        response.sendRedirect(request.getContextPath() + "/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // allow adding burger only if the user in logged in
        final HttpSession session = req.getSession();

        if (session == null || session.getAttribute("user") == null) {
            req.getRequestDispatcher("/signin.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/addBurger.jsp").forward(req, resp);
        }
    }

}
