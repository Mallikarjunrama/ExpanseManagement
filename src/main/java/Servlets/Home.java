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

import com.dao.UserDAO;
import com.model.AnotherUser;
import com.model.Expanses;

@WebServlet("/home")
public class Home extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AnotherUser user = (AnotherUser) session.getAttribute("user");
		int id = user.getUserId();
		UserDAO userdao = new UserDAO();
		request.setAttribute("name", user.getFullName());
		session.setAttribute("id", user.getUserId());
		List<Expanses> expanses = userdao.getAllExpanses(id);
		request.setAttribute("expanses", expanses);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Home.jsp")
				;requestDispatcher.forward(request, response);
	}

}
