<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.gestionearticolijspservletjpamaven.model.Articolo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp" />
	<title>pagina di modifica</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
	<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Modifica il tuo elemento</h5> 
		    </div>
		    <div class='card-body'>
		    
		    <%Articolo articoloInPage=(Articolo)request.getAttribute("articolo_attribute"); %>
		    
		    <form method="post" action="ExecuteUpdateArticoloServlet" >
		    

					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Codice <span class="text-danger">*</span></label>
								<input type="text" name = "codice" id="codice" class="form-control"  placeholder="Inserire il codice" value="<%=articoloInPage.getCodice() %>">
							</div>
							
							<div class="form-group col-md-6">
								<label>Descrizione <span class="text-danger">*</span></label>
								<input type="text" name = "descrizione" id="descrizione" class="form-control" placeholder="Inserire la descrizione" value="<%=articoloInPage.getDescrizione()%>">
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Data Arrivo <span class="text-danger">*</span></label>
								<input class="form-control" id="dataArrivo" type="date" value = "<%=articoloInPage.getDataArrivo()!=null? new SimpleDateFormat("yyyy-MM-dd").format(articoloInPage.getDataArrivo()):""%>"
								          title="formato : gg/mm/aaaa"  name="dataArrivo">
							</div>
							
							<div class="form-group col-md-3">
								<label>Prezzo<span class="text-danger">*</span></label>
                        		<input type="number" class="form-control" name="prezzo" id="prezzo" placeholder="Inserire prezzo" value="<%=articoloInPage.getPrezzo() %>">
							</div>
							
						</div>
						
						<div class="form-group col-md-6">	
							<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
							<input type="hidden" name="inputid" value="<%= articoloInPage.getId()%>">
						</div>
						
					</form>
					<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
		
	
</body>
</html>