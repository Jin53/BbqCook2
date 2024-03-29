package adminServlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entity.Tool;
import util.DBUtil;

@WebServlet("/ToolUpdate")
@MultipartConfig
public class ToolUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ToolUpdate() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
        String _token = request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Tool t = em.find(Tool.class, (Integer)(request.getSession().getAttribute("tool_id")));

            // フォームの内容を各フィールドに上書き
            String toolName = request.getParameter("toolName");
            System.out.println(toolName);
            t.setTool_name(toolName);
            Part part = request.getPart("pict");
            String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            String path = getServletContext().getRealPath("/upload");
            part.write(path + File.separator + filename);
            t.setTool_image(filename);
            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();
            // セッションスコープ上の不要になったデータを削除
            request.getSession().removeAttribute("tool_id");
            request.setAttribute("tool", t);
            request.setAttribute("_token", request.getSession().getId());

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/toolUpdate.jsp");
            rd.forward(request, response);
        }
        }catch(Exception e){
            System.out.println("bbb");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/toolUpdate.jsp");
            rd.forward(request, response);
        }
    }
}
