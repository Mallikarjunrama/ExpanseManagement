package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.Expanses;
import com.dao.ExpanseDAO;

@WebServlet("/getExpanse")
public class getExpanse extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int expId =Integer.parseInt(request.getParameter("expid"));
	HttpSession session = request.getSession();
	ExpanseDAO dao = new ExpanseDAO();
	Expanses expanse = dao.getExpanse(expId);
	session.setAttribute("eid", expId);
	session.setAttribute("expanse",expanse);
	System.out.println(expId);
	response.sendRedirect("Update.jsp");
	}

}
