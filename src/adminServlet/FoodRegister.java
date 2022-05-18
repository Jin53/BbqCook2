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

import entity.Food;
import util.DBUtil;

/**
 * Servlet implementation class FoodRegister
 */
@WebServlet("/FoodRegister")
@MultipartConfig
public class FoodRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/foodRegister.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String _token = request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();
            Food f = new Food();
            String foodName = request.getParameter("registerFood");
            f.setFood_name(foodName);
            int s = (Integer) em.createQuery("select max(food_id) from Food").getSingleResult();
            f.setFood_id(s + 1);
            Part part = request.getPart("pict");
            System.out.println("part"+part);
            String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            String path = getServletContext().getRealPath("/upload");
            System.out.println(path);
            part.write(path + File.separator + filename);
            f.setFood_image(filename);
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            em.close();
            request.setAttribute("newFood", f.getFood_name());
            request.setAttribute("_token", request.getSession().getId());
            if (request.getSession().getAttribute("flush") != null) {
                request.getSession().removeAttribute("flush");
            }
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/foodRegisterSet.jsp");
            rd.forward(request, response);
        }
    }

}
