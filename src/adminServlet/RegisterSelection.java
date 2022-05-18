package adminServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterSelection
 */
@WebServlet("/RegisterSelection")
public class RegisterSelection extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterSelection() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String _token = request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
            request.setAttribute("_token", request.getSession().getId());
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/registerSelection.jsp");
            rd.forward(request, response);
        }
    }

}
