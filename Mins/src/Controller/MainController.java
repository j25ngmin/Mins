package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

@WebServlet(urlPatterns="/index")
public class MainController extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		
		try{
			ServletContext sc = this.getServletContext();
			//Connection conn = (Connection) sc.getAttribute("conn");
			
			/*new 라는 키워드로 생성하지 않는다.
			재사용 한다.*/
			//UserDAO userDAO = new UserDAO();
			UserDAO userDAO = (UserDAO)sc.getAttribute("userDAO");
			//userDAO.setConnection(conn);
			request.setAttribute("adminVO",userDAO.selectAdminVO());
		
		 }catch (Exception e) {
			 //에러페이지로 이동.
		 }
		rd.include(request, response);
		
	}
}
