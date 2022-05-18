package servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Food;
import util.DBUtil;

/**
 * servlet implementation class FoodSelection
 */
@WebServlet("/FoodSelection")
public class FoodSelection extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FoodSelection() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        List<Food> foods = em.createNamedQuery("getAllFood", Food.class).getResultList();
        em.close();

        request.getServletContext().setAttribute("foods", foods);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/foodSelection.jsp");
        rd.forward(request, response);
    }

}
