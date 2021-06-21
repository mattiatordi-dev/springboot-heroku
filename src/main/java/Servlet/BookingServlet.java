package Servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AutoDao;
import Dao.BookingDao;
import Dao.UserDao;
import bean.Mezzo;
import bean.Prenotazione;
import bean.Utente;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserDao userDao = new UserDao();
		AutoDao autoDao = new AutoDao();
		
		System.out.println("ID UTENTE: " + request.getSession().getAttribute("idUser"));
		System.out.println("ID MEZZO: " + request.getParameter("id"));
		
		int idUser = (int) request.getSession().getAttribute("idUser");
		int idAuto = Integer.parseInt(String.valueOf(request.getParameter("id")));
		
		String data = LocalDate.now().toString().substring(0, 4);
		
		Prenotazione prenotazione = new Prenotazione(0, userDao.getUser(idUser), autoDao.getAuto(idAuto),Integer.parseInt(data));
        
		BookingDao bookingDao = new BookingDao();
		bookingDao.insertBooking(prenotazione);
		System.out.println("arrivato alla prenotazione");
		
		Utente u = userDao.getUser(idUser);
		Mezzo m = autoDao.getAuto(idAuto);
		
		request.getSession().setAttribute("UserRegistered", u);
		request.getSession().setAttribute("AutoRegistered", m);
		
		request.getRequestDispatcher("jsp/successBooking.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
