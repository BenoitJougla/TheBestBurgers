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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("from");

        if (page == null || page.isEmpty()) {
            page = "/";
        }

        final String url = req.getContextPath() + page;

        req.setAttribute("form", url);
        req.getRequestDispatcher("signin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();

        String url = req.getParameter("from");

        System.out.println(url);

        if (url == null || url.isEmpty()) {
            url = req.getContextPath() + "/";
        }

        if (session == null || session.getAttribute("user") == null) {
            final String name = req.getParameter("firstName");

            User user = User.getUserByName(name);

            if (user == null) {
                user = new User(name);
                user.save();
            }

            session.setAttribute("user", user);
        }

        resp.sendRedirect(url);
    }
}
