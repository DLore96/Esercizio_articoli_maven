package it.gestionearticolijspservletjpamaven.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.gestionearticolijspservletjpamaven.model.Articolo;
import it.gestionearticolijspservletjpamaven.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteDeleteArticoloServlet
 */
@WebServlet("/ExecuteDeleteArticoloServlet")
public class ExecuteDeleteArticoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteDeleteArticoloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idArticoloParameter = request.getParameter("inputid");

		if (!NumberUtils.isCreatable(idArticoloParameter)) {

			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		Articolo articoloInstance = null;

		try {

			articoloInstance = MyServiceFactory.getArticoloServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idArticoloParameter));
			MyServiceFactory.getArticoloServiceInstance().rimuovi(articoloInstance);
			request.setAttribute("listaArticoliAttribute", MyServiceFactory.getArticoloServiceInstance().listAll());

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/articolo/results.jsp").forward(request, response);
	}

}
