package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;

import com.dao.ExpanseDAO;
import com.dao.UserDAO;
import com.model.AnotherUser;
import com.model.Expanses;

@WebServlet("/newexpanse")
public class NewExpanse extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("id");
		System.out.println(userId);
		String desc = request.getParameter("desc");
		int amount = Integer.parseInt(request.getParameter("amount"));
		UserDAO usdao = new UserDAO();
		AnotherUser user = usdao.getUserById(userId);
		LocalDateTime time = LocalDateTime.now();
		Expanses exp = new Expanses(desc,amount,time,user);
		System.out.println(exp);
		ExpanseDAO dao = new ExpanseDAO();
		dao.insertExpanse(exp, userId);
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("home");
//		requestDispatcher.forward(request, response);
response.sendRedirect("home");
	}

}
