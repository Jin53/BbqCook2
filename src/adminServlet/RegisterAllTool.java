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

import entity.Tool;
import util.DBUtil;


@WebServlet("/RegisterAllTool")
public class RegisterAllTool extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterAllTool() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _token = request.getParameter("_token");
       System.out.println(_token);
        if (_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            int page = 1;
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (NumberFormatException e) {
            }
            List<Tool> allTool = em.createNamedQuery("getAllTool", Tool.class)
                    .setFirstResult(15 * (page - 1))
                    .setMaxResults(15)
                    .getResultList();
            long tool_count = (long) em.createNamedQuery("getToolCount", Long.class)
                    .getSingleResult();

            em.close();
            request.setAttribute("allTool", allTool);
            request.setAttribute("tool_count", tool_count);
            request.setAttribute("page", page);
            request.setAttribute("_token", request.getSession().getId());
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/registerAllTool.jsp");
        rd.forward(request, response);
    }

}