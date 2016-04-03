package presentation.get;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Burger;
import dataAccess.DAOManager;

@WebServlet("/detailBurger")
public class DetailBurgerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");

        if (id != null) {
            final Burger burger = DAOManager.getInstance().getBurgerById(Long.parseLong(id));

            if (burger != null) {
                req.setAttribute("burger", new BurgerViewBean(burger));
                final RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/detailBurger.jsp");
                rd.forward(req, resp);
                return;
            }
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }

}
