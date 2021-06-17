package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.LoginDao;
import bean.Utente;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginDao dao = new LoginDao();
		Utente admin = dao.findBySurname("tordi");
		
		String user = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		if(admin.getCognome().equalsIgnoreCase(user) && admin.getPassword().equalsIgnoreCase(pwd)){
			HttpSession session = request.getSession();
			response.sendRedirect("/Servlet-Jsp-Project/jsp/header.jsp");
		}else{
			request.setAttribute("invalid", "Username o password errati");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/Login.jsp");
			rd.forward(request, response);
		}

	}


	}


