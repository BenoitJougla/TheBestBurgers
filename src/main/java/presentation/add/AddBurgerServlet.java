package presentation.add;

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
import presentation.ErrorResponse;

@WebServlet("/add/burger")
public class AddBurgerServlet extends HttpServlet {

    private Grade buildGrade(HttpServletRequest request, ErrorJsonBuilder json) {
        boolean error = false;

        final String originality_str = request.getParameter("originality");
        int originality = 0;
        try {
            originality = Integer.parseInt(originality_str);
        } catch (final NumberFormatException e) {
            error = true;
            json.add("originality", "Sélectionner une valeur entre 1 et 5");
        }

        final String quality_str = request.getParameter("quality");
        int quality = 0;
        try {
            quality = Integer.parseInt(quality_str);
        } catch (final NumberFormatException e) {
            error = true;
            json.add("quality", "Sélectionner une valeur entre 1 et 5");
        }

        final String presentation_str = request.getParameter("presentation");
        int presentation = 0;
        try {
            presentation = Integer.parseInt(presentation_str);
        } catch (final NumberFormatException e) {
            error = true;
            json.add("presentation", "Sélectionner une valeur entre 1 et 5");
        }

        final String tasty_str = request.getParameter("tasty");
        int taste = 0;
        try {
            taste = Integer.parseInt(tasty_str);
        } catch (final NumberFormatException e) {
            error = true;
            json.add("tasty", "Sélectionner une valeur entre 1 et 5");
        }

        final String observation = request.getParameter("observation");
        if (observation == null || observation.isEmpty()) {
            error = true;
            json.add("gradeDescription", "Veuiller renseigner ce champ");
        }

        if (!error) {
            final Grade grade = new Grade();
            grade.setOriginality(originality);
            grade.setQuality(quality);
            grade.setPresentation(presentation);
            grade.setTaste(taste);
            grade.setObservation(observation);

            // User
            final HttpSession session = request.getSession();
            final User user = (User) session.getAttribute("user");
            if (user == null) {
                json.add("errorMsg", "Vous devez être connecter pour ajouter un burger");
                return null;
            } else {
                user.addGrade(grade);
                return grade;
            }
        }

        return null;
    }

    private List<Ingredient> buildIngredients(HttpServletRequest request) {
        final String[] ingredients_str = request.getParameterValues("ingredients[]");

        final List<Ingredient> ingredients = new ArrayList<>();

        if (ingredients_str != null) {
            for (final String str : ingredients_str) {
                final long id = Long.parseLong(str);
                ingredients.add(Ingredient.getIngredientById(id));
            }
        }

        return ingredients;
    }

    private Burger buildBurger(HttpServletRequest request, ErrorJsonBuilder json) {
        boolean error = false;

        // Grade
        final Grade grade = buildGrade(request, json);

        if (grade == null) {
            error = true;
        }

        // Ingredients
        final List<Ingredient> ingredients = buildIngredients(request);

        // Burger
        final String name = request.getParameter("name");
        if (name == null || name.isEmpty()) {
            json.add("burgerName", " Le nom doit être renseigné");
            error = true;
        }

        final String description = request.getParameter("description");
        if (name == null || name.isEmpty()) {
            json.add("burgerDescription", "Ce champ doit être renseigné");
            error = true;
        }

        final String picture = request.getParameter("picture");
        if (name == null || name.isEmpty()) {
            json.add("burgerPicture", "Ce champ doit être renseigné");
            error = true;
        }

        if (error) {
            return null;
        }

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
        final ErrorJsonBuilder json = new ErrorJsonBuilder();

        // Burger
        final Burger burger = buildBurger(request, json);

        // Restaurant
        final String restaurant_str = request.getParameter("restaurant");
        final long restaurantId = Long.parseLong(restaurant_str);
        final Restaurant restaurant = Restaurant.getRestaurant(restaurantId);

        if (burger == null || restaurant == null) {
            ErrorResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, json.build(), response);
            return;
        }

        restaurant.addBurger(burger);
        restaurant.save();

        response.sendRedirect(request.getContextPath() + "/");
    }
}
