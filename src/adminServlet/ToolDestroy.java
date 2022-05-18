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

@WebServlet("/ToolDestroy")
public class ToolDestroy extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ToolDestroy() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        System.out.println(_token);
        if (_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Tool t = em.find(Tool.class, (Integer)(request.getSession().getAttribute("tool_id")));
            String toolName = request.getParameter("toolName");
            System.out.println(toolName);
            t.setTool_name(toolName);
            em.getTransaction().begin();
            em.remove(t);       // データ削除
            em.getTransaction().commit();
            em.close();
            // セッションスコープ上の不要になったデータを削除
            request.getSession().removeAttribute("tool_id");
            request.setAttribute("toolName", toolName);
            request.setAttribute("_token", request.getSession().getId());
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/toolDestroy.jsp");
            rd.forward(request, response);
        }
    }

}
