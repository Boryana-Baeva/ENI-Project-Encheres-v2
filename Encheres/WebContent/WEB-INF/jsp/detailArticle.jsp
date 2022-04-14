<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fr.eni.encheres.bo.Article"%>
<%@page import="fr.eni.encheres.bo.Retrait"%>
<%@page import="fr.eni.encheres.bo.Enchere"%>
<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@page import="fr.eni.encheres.bll.RetraitManager"%>
<%@page import="fr.eni.encheres.bll.EnchereManager"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.List"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
  crossorigin="anonymous"></script>
<link rel="stylesheet" href="styles/navbar.css">
<title>Article</title>
</head>
<body>

<!-- Navbar -->
<jsp:include page="/WEB-INF/jsp/navbar.jsp"></jsp:include>

<% Article article = (Article) request.getAttribute("article"); %>

<div class="container bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center py-5">
            <img class="rounded img-fluid img-thumbnail" width="300px" src="https://media.istockphoto.com/vectors/thumbnail-image-vector-graphic-vector-id1147544807?k=20&m=1147544807&s=612x612&w=0&h=pBhz1dkwsCMq37Udtp9sfxbjaMl27JUapoyYpQm0anc=">
            </div>
        </div>
        <div class="col-md-7 border-right">
            <div class="p-3 py-5">
            <div class="card shadow bg-white rounded" style="min-height: 350px">
            		<div class="card-header">
		                 <div class="card-title fw-bold fs-4"><%=article.getNom() %></div>
		             </div>
	  				<div class="card-body">
		  				<div class="row">
		  					<div class="col">
			  					<div class="row mt-3">
				                    <div class="col"><label class="labels card-subtitle text-muted">Catégorie: </label>  	
		                    			<p class="card-text"><%=article.getCategorie().getLibelle() %></p>
				                    </div>
				                </div>
				                <div class="row mt-3">
				                 	<div class="col"><label class="labels text-muted">Description: </label>
				                    	<p class="card-text"><%=article.getDescription() %></p>
				                    </div>
			                	</div>
			                	<div class="row mt-3">
				                 	<div class="col"><label class="labels text-muted">Vendeur: </label>
				                    	<p class="card-text">
				                    	<a href="<%=request.getContextPath()%>/profil?id=<%=article.getVendeur().getId() %>">
				                    	<%=article.getVendeur().getPseudo() %></a></p>
				                    </div>
			                	</div>
			                	
			  				</div>
			  				<div class="col">
			  					<div class="row mt-3">    
				                    <div class="col-6">
				                    	<label class="labels text-muted">Mise à prix: </label>
				                    	      <p class="card-text"><%=article.getMiseAPrix() %> crédits</p>  
				                    </div>
				                    <div class="col-6">
				                    	<label class="labels text-muted">Prix actuel: </label>
				                    	      <p class="card-text">
				                    	      <% if(article.getPrixVente() != 0) { %>
				                    	      	<%=article.getPrixVente() %> crédits
				                    	      <% } else { %>
				                    	      	<%=article.getMiseAPrix() %> crédits
				                    	      <% } %>
				                    	      </p>  
				                    </div>
			                    </div>	
			                    
			                 	<div class="row mt-3">
				                 	<div class="col">
				                 		<label class="labels text-muted">Début de l'enchère: </label>
				                 		<p class="card-text"><%=article.getDateDebutEncheres().format(DateTimeFormatter.ofPattern("dd/MM/YYYY", Locale.FRANCE)) %></p>  
				                 	</div>
				                 	<div class="col">
				                 		<label class="labels text-muted">Fin de l'enchère: </label>
				                 		<p class="card-text"><%=article.getDateFinEncheres().format(DateTimeFormatter.ofPattern("dd/MM/YYYY", Locale.FRANCE)) %></p>  
				                 	</div>
			                 	</div> 
			                 	
			                 	<div class="row mt-3">
				                 	<div class="col"><label class="labels text-muted">Lieu de retrait: </label>
				                 	<% if(RetraitManager.selectionnerRetraitById(article.getId()) == null) { %>
				                    	<p class="card-text">
				                    	<%= article.getVendeur().getLieuRetraitParDefaut().getRue() %>, 
				                    	<%= article.getVendeur().getLieuRetraitParDefaut().getCodePostal() %>
				                    	<%= article.getVendeur().getLieuRetraitParDefaut().getVille() %>
				                    	</p>
				                    <% } else { %>
				                    	<% Retrait retrait = RetraitManager.selectionnerRetraitById(article.getId()); %>
				                    	<p class="card-text">
				                    	<%= retrait.getRue() %>, 
				                    	<%= retrait.getCodePostal() %>
				                    	<%= retrait.getVille() %>
				                    	</p>
				                    <% }  %>
				                    </div>
			                	</div>  
			  				</div>
		  				</div>
		  				
		  				<% if( session.getAttribute("ConnectedUser") != null){ 
	  						Utilisateur connectedUser = (Utilisateur) session.getAttribute("ConnectedUser");
	  					    if(!article.getVendeur().getPseudo().equals(connectedUser.getPseudo()) 
	  					    		&& !LocalDate.now().isBefore(article.getDateDebutEncheres())
	  					    		&& !LocalDate.now().isAfter(article.getDateFinEncheres()) ) { %>
	  					    
		  					<% Integer minPrixEnchere = null;
		  					  if(article.getPrixVente() != 0) { 
                    	      	 minPrixEnchere = Integer.valueOf(article.getPrixVente());
                    	      } else {
                    	      	 minPrixEnchere = Integer.valueOf(article.getMiseAPrix());
                    	      } %>
				                    	      
								<form action="<%=request.getContextPath()%>/encherir?idArticle=<%=article.getId()%>" method="POST">
									<div class="row mt-5">
										<div class="col-3">
					                    	<label class="labels text-muted">Ma Proposition :</label>
					                    	<input type="number" class="form-control" placeholder="<%= minPrixEnchere %>" name="proposed-price" step="1" min= "<%= minPrixEnchere %>" required>                          
										</div>
									    <div class="col mt-4">
									        <button class="btn btn-custom btn-encherir" type="submit">Enchérir</button>
									    </div>
								      	<!--  <input value="<%=article.getId()%>" type="text" id="idArticle" name="idArticle" style="visibility:hidden;">-->
									</div>
								</form>
							
							<% } %>
						<% } %>
						
										
						<% if(EnchereManager.getAllByArticle(article.getId()) != null) { 
							List<Enchere> encheres = EnchereManager.getAllByArticle(article.getId());%>
								<ul class="list-group mt-4">
								<% for(Enchere enchere : encheres) { %>
								  	<li class="list-group-item">
								  	<span class="fw-bold"><%= enchere.getDate().format(DateTimeFormatter.ofPattern("dd/MM/YYYY", Locale.FRANCE)) %> :</span> enchère pour 
								  	<span class="fw-bold"><%=enchere.getMontant()%> crédits </span> par 
								  	<a href="<%=request.getContextPath()%>/profil?id=<%=enchere.getEncherisseur().getId() %>">
								  	<%=enchere.getEncherisseur().getPseudo()%></a> 
								  	
								  	</li>
								 <% }%> 
								</ul>
						<% } else if(EnchereManager.getAllByArticle(article.getId()).size() == 0) { %>
							<ul class="list-group">
							  <li class="list-group-item">Aucune enchère pour cet article</li>
							</ul>
		  				<% } %>
                
    
		  				
			       </div>
		        </div>
	  		</div>
	  	</div>
	  	
	  	<% if( session.getAttribute("ConnectedUser") != null){ %>
	  	<% Utilisateur connectedUser = (Utilisateur) session.getAttribute("ConnectedUser");
		  	if (Integer.valueOf(connectedUser.getId()).equals(Integer.valueOf(article.getVendeur().getId()))) {%>	  	
		  	 <div class="col-md-2">          
	             <div class="text-start mt-5">
	             	<button class="btn btn-custom article-button w-100" type="button">
	             	<i class="fa-solid fa-pen-to-square"></i> Modifier</button>
	             </div>
	             <div class="text-start mt-2">
	             	<button class="btn btn-danger article-button w-100" type="button">
	             	<i class="fa-solid fa-trash-can"></i> Supprimer</button>
	             </div>      
	        </div>
	        <% } %>
        <% } %>
                 
    </div>
</div>

</body>
</html>