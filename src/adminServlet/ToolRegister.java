package adminServlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Tool;
import util.DBUtil;

/**
 * Servlet implementation class ToolRegister
 */
@WebServlet("/ToolRegister")
public class ToolRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ToolRegister() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/toolRegister.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();
            Tool t = new Tool();
            String toolName = request.getParameter("registTool");
            t.setTool_name(toolName);
            int s = (Integer) em.createQuery("select max(tool_id) from Tool").getSingleResult();
            t.setTool_id(s + 1);
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            em.close();
            request.setAttribute("newTool", t.getTool_name());
            request.setAttribute("_token", request.getSession().getId());
            if (request.getSession().getAttribute("flush") != null) {
                request.getSession().removeAttribute("flush");
            }
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/toolRegisterSet.jsp");
            rd.forward(request, response);
        }
    }
}
