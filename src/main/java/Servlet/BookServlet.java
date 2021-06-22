package Servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AutoDao;
import bean.Mezzo;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int idUser = Integer.parseInt(String.valueOf(request.getParameter("id")));
		request.getSession().setAttribute("idUser", idUser);
		
		AutoDao dao = new AutoDao();
		List<Mezzo> lista = dao.getAllAuto();
		request.getSession().setAttribute("listaAuto", lista);
		
		request.getRequestDispatcher("jsp/AutoView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idUser = (int) request.getSession().getAttribute("idUser");
		request.getSession().setAttribute("idUser", idUser);
		
		String modello = request.getParameter("modello");
		String casaCostr = request.getParameter("casa_costr");
		String targa = request.getParameter("targa");
		int annoImm = Integer.parseInt(String.valueOf(request.getParameter("anno_imm")));
		String tipologia = request.getParameter("tipologia");
		
		Mezzo mezzo = new Mezzo(0,targa,modello,casaCostr,annoImm,tipologia);
		
		AutoDao dao = new AutoDao();
		dao.insertAuto(mezzo);
		
		List<Mezzo> lista = dao.getAllAuto();
		request.getSession().setAttribute("listaAuto", lista);
		
		request.getRequestDispatcher("jsp/AutoView.jsp").forward(request, response);
		

	}

}
