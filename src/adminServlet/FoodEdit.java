package adminServlet;

import java.io.IOException;

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
 * Servlet implementation class FoodEdit
 */
@WebServlet("/FoodEdit")
public class FoodEdit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodEdit() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        Food f= em.find(Food.class, Integer.parseInt(request.getParameter("food_id")));

        em.close();

        request.setAttribute("foodEdit", f);
        request.setAttribute("_token", request.getSession().getId());

        request.getSession().setAttribute("food_id", f.getFood_id());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/foodEdit.jsp");
        rd.forward(request, response);
    }

}
