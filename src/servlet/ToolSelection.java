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

import entity.Tool;
import util.DBUtil;


@WebServlet("/ToolSelection")
public class ToolSelection extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public ToolSelection() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        List<Tool> tools = em.createNamedQuery("getAllTool", Tool.class).getResultList();

        em.close();

        request.getServletContext().setAttribute("tool",tools);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/toolSelection2.jsp");
        rd.forward(request, response);
    }

}
