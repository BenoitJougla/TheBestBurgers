package presentation.get;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Burger;
import dataAccess.DAOManager;

@WebServlet(urlPatterns = { "/home", "/index.html" })
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Burger> burgerList = DAOManager.getInstance().getAllBurgers();

        final List<BurgerViewBean> burgers = new ArrayList<>();
        burgerList.forEach(burger -> {
            burgers.add(new BurgerViewBean(burger));
        });

        req.setAttribute("burgers", burgers);

        final RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/home.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
