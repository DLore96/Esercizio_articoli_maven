<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.gestionearticolijspservletjpamaven.model.Articolo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../header.jsp" />
	<title>elimina elementp</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
</head>
<body>
		<jsp:include page="../navbar.jsp" />
	
		<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Ecco l'articolo che stai eliminando:
		    </div>
		     <% Articolo articoloInPagina = (Articolo)request.getAttribute("articolo_attribute"); %>
		
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Codice</dt>
				  <dd class="col-sm-9"><%=articoloInPagina.getCodice() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Descrizione:</dt>
				  <dd class="col-sm-9"><%=articoloInPagina.getDescrizione() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Prezzo:</dt>
				  <dd class="col-sm-9"><%=articoloInPagina.getPrezzo() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Data di Arrivo:</dt>
				  <dd class="col-sm-9"><%=articoloInPagina.getDataArrivo()!=null? new SimpleDateFormat("dd/MM/yyyy").format(articoloInPagina.getDataArrivo()):"N.D."  %></dd>
		    	</dl>
		    	
		    </div>
		    
		    
		    <form action="ExecuteDeleteArticoloServlet" method="post"   >
			        <a href="ListArticoliServlet" class='btn btn-outline-secondary' style='width:80px'>
			            <i class='fa fa-chevron-left'></i> Back
			        </a>
		        
		        	<input type="hidden"   name="inputid" value="<%= articoloInPagina.getId()%>">
		        	<button type="submit" class='btn btn-outline-secondary' style='color: black;background-color: red'>Elimina</button>
		        
		        </form>
	
		    
		
		<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />

</body>
</html>