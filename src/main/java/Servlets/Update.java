package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.ExpanseDAO;
@WebServlet("/update")
public class Update extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int expId =(int)( session.getAttribute("eid"));
		String desc = request.getParameter("desc");
		int amount = Integer.parseInt( request.getParameter("amount"));
		System.out.println(expId+" "+desc+" "+amount);
		ExpanseDAO dao = new ExpanseDAO();
		dao.updateExpanse(expId, desc, amount);
		response.sendRedirect("home");
	}
}
