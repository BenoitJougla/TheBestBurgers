package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.User;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();

        if (session == null || session.getAttribute("user") == null) {
            final String name = req.getParameter("firstName");

            User user = User.getUserByName(name);

            if (user == null) {
                user = new User(name);
                user.save();
            }

            session.setAttribute("user", user);
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
