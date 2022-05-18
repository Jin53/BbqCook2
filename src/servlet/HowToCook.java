package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Cook;
import util.DBUtil;

@WebServlet("/HowToCook")
public class HowToCook extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HowToCook() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Cook> aryCook = new ArrayList<Cook>();
        Cook c = null;
        String[] fooParams = request.getParameterValues("cookname");
        if (fooParams != null) {
            EntityManager em = DBUtil.createEntityManager();

            for (String fooParam : fooParams) {
                System.out.println("How" + fooParam);
                c = em.createNamedQuery("selectCookId", Cook.class)
                        .setParameter("cook_id", Integer.parseInt(fooParam))
                        .getSingleResult();
                aryCook.add(c);
            }
            request.getSession().setAttribute("cook_make", aryCook);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/howToCook.jsp");
            rd.forward(request, response);
        } else {
            String[] fooToolParams = request.getParameterValues("cookTool");
            EntityManager e = DBUtil.createEntityManager();
            for (String fooToolParam : fooToolParams) {
                c = e.createNamedQuery("selectCookId", Cook.class)
                        .setParameter("cook_id", Integer.parseInt(fooToolParam))
                        .getSingleResult();
                aryCook.add(c);

                request.getSession().setAttribute("cook_make", aryCook);
                request.setAttribute("_token", request.getSession().getId());
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/howToCook.jsp");
                rd.forward(request, response);
            }
        }
    }
}