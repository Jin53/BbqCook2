package adminServlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Food;
import util.DBUtil;

@WebServlet("/FoodUpdate")
public class FoodUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FoodUpdate() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String _token = request.getParameter("_token");
            if (_token != null && _token.equals(request.getSession().getId())) {
                EntityManager em = DBUtil.createEntityManager();

                Food f = em.find(Food.class, (Integer)(request.getSession().getAttribute("food_id")));

                // フォームの内容を各フィールドに上書き
                String foodName = request.getParameter("foodName");
                System.out.println(foodName);
                f.setFood_name(foodName);

                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                // セッションスコープ上の不要になったデータを削除
                request.getSession().removeAttribute("food_id");
                request.setAttribute("foodName", foodName);
                request.setAttribute("_token", request.getSession().getId());

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/foodUpdate.jsp");
                rd.forward(request, response);
            }
            }catch(Exception e){
                System.out.println("bbb");
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/foodUpdate.jsp");
                rd.forward(request, response);
            }
        }
    }
