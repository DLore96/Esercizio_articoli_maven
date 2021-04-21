package it.gestionearticolijspservletjpamaven.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionearticolijspservletjpamaven.model.Articolo;
import it.gestionearticolijspservletjpamaven.service.MyServiceFactory;
import it.gestionearticolijspservletjpamaven.utility.UtilityArticoloForm;

/**
 * Servlet implementation class ExecuteUpdateArticoloServlet
 */
@WebServlet("/ExecuteUpdateArticoloServlet")
public class ExecuteUpdateArticoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteUpdateArticoloServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParameter = request.getParameter("inputid");
		String codiceInputParameter = request.getParameter("codice");
		String descrizioneInputParameter = request.getParameter("descrizione");
		String prezzoInputParameter = request.getParameter("prezzo");
		String dataArrivoParameter = request.getParameter("dataArrivo");

		Date dataArrivoParsed = UtilityArticoloForm.parseDateArrivoFromString(dataArrivoParameter);

		Articolo articoloInstance = new Articolo(codiceInputParameter, descrizioneInputParameter,
				Integer.parseInt(prezzoInputParameter), dataArrivoParsed);
		articoloInstance.setId(Long.parseLong(idParameter));

		if (!UtilityArticoloForm.validateInput(codiceInputParameter, descrizioneInputParameter, prezzoInputParameter,
				dataArrivoParameter) || dataArrivoParsed == null) {

			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.setAttribute("articolo_attribute", articoloInstance);
			request.getRequestDispatcher("/articolo/edit.jsp").forward(request, response);
			return;
		}

		try {

			MyServiceFactory.getArticoloServiceInstance().aggiorna(articoloInstance);
			request.setAttribute("articolo_attribute", articoloInstance);
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
