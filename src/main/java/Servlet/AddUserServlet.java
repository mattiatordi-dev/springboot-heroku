package Servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.JpaUtil;
import bean.Mezzo;
import bean.Prenotazione;
import bean.Utente;

import org.apache.commons.lang3.RandomStringUtils;

import Dao.InsertUserDao;
import Dao.UserDao;


/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    UserDao userdao = new UserDao();
		InsertUserDao dao = new InsertUserDao();
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String dataNasc = request.getParameter("data_nasc");
		
		Utente utente = new Utente(0,nome,cognome,dataNasc,generaPassword());
		dao.insertUser(utente);
		List<Utente> lista = new ArrayList<>();
		lista = userdao.getAllUsers();
		request.getSession().setAttribute("listaUtenti", lista);
		
		request.getRequestDispatcher("jsp/Homepage.jsp").forward(request, response);
		
	}
	
	public static String generaPassword()
    {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return RandomStringUtils.random(6, chars);
    }
	


}
