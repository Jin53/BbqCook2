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
 * Servlet implementation class ToolEdit
 */
@WebServlet("/ToolEdit")
public class ToolEdit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToolEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        String _token = request.getParameter("_token");
        System.out.println("ToolEdit+" + _token);
        if (_token != null && _token.equals(request.getSession().getId())) {
        EntityManager em = DBUtil.createEntityManager();
        Tool t= em.find(Tool.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("toolEdit", t);
        request.setAttribute("_token", request.getSession().getId());

        request.getSession().setAttribute("tool_id", t.getTool_id());



        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/toolEdit.jsp");
        rd.forward(request, response);
        }
        }catch(Exception e){
            System.out.println("aaa");
        }
    }

}
