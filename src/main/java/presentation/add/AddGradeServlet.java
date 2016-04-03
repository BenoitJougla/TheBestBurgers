package presentation.add;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.Burger;
import business.Grade;
import business.User;
import dataAccess.DAOManager;

@WebServlet("/add/grade")
public class AddGradeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        // Burger
        final String burger_id = request.getParameter("burgerId");
        final long id = Long.parseLong(burger_id);
        final Burger burger = DAOManager.getInstance().getBurgerById(id);
        burger.addGrade(grade);
        burger.save();
    }
}
