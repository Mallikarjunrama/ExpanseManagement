package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.ExpanseDAO;

@WebServlet("/delete")
public class Delete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int  id =Integer.parseInt(request.getParameter("expid"));
//		int expId = (int) session.getAttribute("expid");
		System.out.println(id);
		ExpanseDAO dao = new ExpanseDAO();
		dao.deleteExpanse(id);
		response.sendRedirect("home");

	}

}
