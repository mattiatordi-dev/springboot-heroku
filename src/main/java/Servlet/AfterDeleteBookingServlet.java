package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookingDao;

/**
 * Servlet implementation class AfterDeleteBookingServlet
 */
@WebServlet("/AfterDeleteBookingServlet")
public class AfterDeleteBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfterDeleteBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookingDao bookingDao = new BookingDao();
		
		int idUtente = (int) request.getSession().getAttribute("idUser");
		request.getSession().setAttribute("prenotazioni",bookingDao.getBookingUser(idUtente));
		
		request.getRequestDispatcher("/jsp/HomepageCustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
