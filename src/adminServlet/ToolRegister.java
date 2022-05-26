package adminServlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
            //画像アップロード
            Part part = request.getPart("toolpict");
            System.out.println("part"+part);
            String toolfilename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            String path = getServletContext().getRealPath("/upload");
            System.out.println(path);
            part.write(path + File.separator + toolfilename);
            t.setTool_image(toolfilename);
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
