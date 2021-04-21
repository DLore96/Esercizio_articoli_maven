package it.gestionearticolijspservletjpamaven.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.gestionearticolijspservletjpamaven.service.MyServiceFactory;

/**
 * Servlet implementation class PrepareDeleteArtcoloServlet
 */
@WebServlet("/PrepareDeleteArtcoloServlet")
public class PrepareDeleteArtcoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareDeleteArtcoloServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramaetroIDArticoloDaEliminare = request.getParameter("idArticolo");

		if (!NumberUtils.isCreatable(paramaetroIDArticoloDaEliminare)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/articolo/results.jsp").forward(request, response);
			return;
		}

		try {

			request.setAttribute("articolo_attribute", MyServiceFactory.getArticoloServiceInstance()
					.caricaSingoloElemento(Long.parseLong(paramaetroIDArticoloDaEliminare)));

		} catch (Exception e) {
		}

		request.getRequestDispatcher("/articolo/delete.jsp").forward(request, response);
	}

}
