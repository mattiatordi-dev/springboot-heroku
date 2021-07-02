package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.BookingDao;
import Dao.LoginDao;
import Dao.UserDao;
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
        boolean role_admin = false;
		LoginDao dao = new LoginDao();
		UserDao userDao = new UserDao();
		BookingDao bookingDao = new BookingDao();
		Utente admin = dao.findBySurname("tordi");
		boolean role = dao.findByRoleAdmin("tordi");
		System.out.println(role);
		if(role = true) {
			admin.setRuolo_admin(true);
		}
		System.out.println(admin.isRuolo_admin());
		String user = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		List<Utente> lista = new ArrayList<Utente>();
		
		Utente u = dao.findBySurname(request.getParameter("username"));
		
		if(admin.getCognome().equalsIgnoreCase(user) && admin.getPassword().equalsIgnoreCase(pwd) && admin.isRuolo_admin()){
			HttpSession session = request.getSession();
			lista = userDao.getAllUsers();
			request.getSession().setAttribute("listaUtenti", lista);
			response.sendRedirect("/Servlet-Jsp-Project/jsp/Homepage.jsp");
		}else if(u == null) {
			request.setAttribute("invalid", "Username o password errati");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/Login.jsp");
			rd.forward(request, response);
		}else if(u.getCognome().equalsIgnoreCase(request.getParameter("username")) && u.getPassword().equalsIgnoreCase(pwd) && !u.isRuolo_admin()){
			request.getSession().setAttribute("utente", u);
			request.getSession().setAttribute("prenotazioni",bookingDao.getBookingUser(u.getId()));
			request.getRequestDispatcher("/jsp/HomepageCustomer.jsp").forward(request, response);
		}
		else{
			request.setAttribute("invalid", "Username o password errati");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/Login.jsp");
			rd.forward(request, response);
		}

	}


	}


