package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Burger;
import business.Grade;
import business.Ingredient;
import business.User;
import dataAccess.DAOManager;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final User user = new User("augustin");
        user.setName("augustin");
        user.save();

        Burger b = new Burger();
        final Grade g = new Grade();
        g.setObservation("not so bad !!!");
        g.setOriginality(0);
        g.setPresentation(0);
        g.setQuality(0);
        g.setTaste(0);
        Ingredient i = new Ingredient();
        i.setName("Steak");
        
        b.addGrade(g.getBean());
        b.addIngredient(i.getBean());
        b.setDescription("Burger de test trop beau !");
        b.setName("Burger test");
        b.setPicture("le chemin ...");
        
        b.save();
        
        b = DAOManager.getInstance().getBurgerById(b.getId());
        
        resp.getWriter().write(User.getUserByName("augustin").getName());
        

    }

}
