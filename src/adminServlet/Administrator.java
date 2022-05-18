package adminServlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Admin;
import util.DBUtil;
import util.EncryptUtil;

@WebServlet("/Administrator")
public class Administrator extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Administrator() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/administrator.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Boolean check_result = false;

        String code = request.getParameter("id");
        String plain_pass = request.getParameter("adminPassword");

        Admin e = null;

        if (code != null && !code.equals("") && plain_pass != null && !plain_pass.equals("")) {
            EntityManager em = DBUtil.createEntityManager();

            String password = EncryptUtil.getPasswordEncrypt(
                    plain_pass,
                    (String) this.getServletContext().getAttribute("pepper"));
            System.out.println(password);
            try {
                e = em.createNamedQuery("checkLoginIdAndAdminPassword", Admin.class)
                        .setParameter("id", code)
                        .setParameter("adminpass", plain_pass)
                        .getSingleResult();
            } catch (NoResultException ex) {
            }
            em.close();
            if (e != null) {
                check_result = true;
            }
        }
        if (!check_result) {
            // 認証できなかったらログイン画面に戻る
            request.setAttribute("hasError", true);
            request.setAttribute("id", code);

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/administrator.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("_token", request.getSession().getId());
            request.getSession().setAttribute("flush", "ログインしました。");
            request.getSession().setAttribute("login_user", e);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/registerSelection.jsp");
            rd.forward(request, response);
        }
    }
}
