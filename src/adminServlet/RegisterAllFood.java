package adminServlet;

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
 * Servlet implementation class RegisterAllFood
 */
@WebServlet("/RegisterAllFood")
public class RegisterAllFood extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAllFood() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
        EntityManager em = DBUtil.createEntityManager();

        int page = 1;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
        }
        List<Food> allFood = em.createNamedQuery("getAllFood", Food.class)
                .setFirstResult(15 * (page - 1))
                .setMaxResults(15)
                .getResultList();
        long food_count = (long) em.createNamedQuery("getFoodCount", Long.class)
                .getSingleResult();

        em.close();
        request.setAttribute("allFood", allFood);
        request.setAttribute("food_count", food_count);
        request.setAttribute("page", page);
        request.setAttribute("_token", request.getSession().getId());
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/registerAllFood.jsp");
        rd.forward(request, response);
    }

}
