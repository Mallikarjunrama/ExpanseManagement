package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.dao.ExpanseDAO;
import com.dao.UserDAO;
import com.model.AnotherUser;
import com.model.Expanses;

@WebServlet("/login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAO userdao = new UserDAO();
		ExpanseDAO exdao = new ExpanseDAO();
		AnotherUser checkCreds = userdao.checkCreds(username, password);
		if(checkCreds!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", checkCreds);
//			int id = checkCreds.getUserId();
//			request.setAttribute("name", checkCreds.getFullName());
//			session.setAttribute("id", checkCreds.getUserId());
//			List<Expanses> expanses = userdao.getAllExpanses(id);
//			request.setAttribute("expanses", expanses);
		//	response.sendRedirect("Home.jsp");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("home");
			requestDispatcher.forward(request, response);
		}
		else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
			requestDispatcher.forward(request, response);
		}
		
		
	}

}
