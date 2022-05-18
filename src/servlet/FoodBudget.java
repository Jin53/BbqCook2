package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FoodBudget")
public class FoodBudget extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FoodBudget() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] fooParams = request.getParameterValues("foo");
        request.getSession().setAttribute("food_id", fooParams);
        String[] toolParams = request.getParameterValues("tool");
        request.getSession().setAttribute("tool_id", toolParams);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/foodBudget.jsp");
        rd.forward(request, response);
    }

}
