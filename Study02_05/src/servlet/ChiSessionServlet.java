package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;


/**
 * Servlet implementation class ChiSessionServlet
 */
@WebServlet(name = "ChiSessionServlet", urlPatterns = "/ChiSessionServlet")
public class ChiSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//持久化Session-》持久化特殊的Cookie
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("JSESSIONID".equals(cookie.getName())) {
				cookie.setMaxAge(600);
				response.addCookie(cookie);
				break;
			}
		}
		//设置session的非活动时间
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(600);
		
		session.setAttribute("stu", new Student("zhangsan"));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
