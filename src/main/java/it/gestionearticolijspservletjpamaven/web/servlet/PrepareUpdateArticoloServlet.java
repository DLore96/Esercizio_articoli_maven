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
 * Servlet implementation class PrepareUpdateArticoloServlet
 */
@WebServlet("/PrepareUpdateArticoloServlet")
public class PrepareUpdateArticoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareUpdateArticoloServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idArticoloParameter = request.getParameter("idArticolo");
		System.out.println(idArticoloParameter);

		if (!NumberUtils.isCreatable(idArticoloParameter)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {

			request.setAttribute("articolo_attribute", MyServiceFactory.getArticoloServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idArticoloParameter)));

		} catch (Exception e) {

		}

		request.getRequestDispatcher("/articolo/edit.jsp").forward(request, response);
	}

}
