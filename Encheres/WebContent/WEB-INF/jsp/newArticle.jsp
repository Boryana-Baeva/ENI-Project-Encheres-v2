<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fr.eni.encheres.bll.CategorieManager"%>
<%@page import="fr.eni.encheres.bo.Categorie"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
  crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="styles/navbar.css">
<title>Nouvelle vente</title>
</head>
<body>
<!-- Navbar -->
<jsp:include page="/WEB-INF/jsp/navbar.jsp"></jsp:include>

<%if(session.getAttribute("ConnectedUser")!=null){ %>
<div class="container bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center py-5">
            <img class="rounded img-fluid img-thumbnail" width="300px" src="https://media.istockphoto.com/vectors/thumbnail-image-vector-graphic-vector-id1147544807?k=20&m=1147544807&s=612x612&w=0&h=pBhz1dkwsCMq37Udtp9sfxbjaMl27JUapoyYpQm0anc=">
            </div>
        </div>
        <div class="col-md-9 border-right">
            <div class="p-3 py-5">
            <div class="card shadow bg-white rounded">
            		<div class="card-header">
		                 <div class="card-title fw-bold fs-4">Nouvelle vente</div>
		             </div>
	  				<div class="card-body">
	  				<form class="vente" action="<%=request.getContextPath() %>/vendre" method="POST">
		  				<div class="row">
		  					<div class="col">
			  					<div class="row mt-3">
				                    <div class="col text-muted"><label class="labels">Article</label>
				                    	<input type="text" class="form-control" placeholder="Nom de l'article" name="nom">
				                    </div>
				                </div>
				                <div class="row mt-3">
				                 	<div class="col text-muted"><label class="labels">Description</label>
				                    	<textarea class="form-control" name="description" placeholder="Description..." rows="11" cols="50"></textarea>
				                    </div>
			                	</div>
			  				</div>
			  				<div class="col">
			  					<div class="row mt-3">
				                    <div class="col-8">
				                    	<label class="labels text-muted">Catégorie</label>
				                    	<select class="form-select" aria-label="categories" name="category">
										  <% for(Categorie categorie : CategorieManager.getAll()) { %>
								            <option name="categorie" value ="<%=categorie.getId()%>"><%=categorie.getLibelle()%></option>
								           <% } %>
										</select>
									</div>
				                    <div class="col-4">
				                    	<label class="labels text-muted">Mise à prix</label><input type="number" class="form-control" placeholder="0" name="initial-price">          
				                    </div>
			                    </div>	
			                    
			                 	<div class="row mt-3">
				                 	<div class="col">
				                 		<label class="labels text-muted">Début de l'enchère</label><input type="date" class="form-control" name="date-start">
				                 	</div>
				                 	<div class="col">
				                 		<label class="labels text-muted">Fin de l'enchère</label><input type="date" class="form-control" name="date-end">
				                 	</div>
			                 	</div>   
			                 	
			                 	<hr class="card-title mt-5">
			                 	<div class="card-title text-center text-muted fs-5">Lieu de retrait</div>
			                 	<div class="row mt-3">
				                 	<div class="col">
				                 		<label class="labels text-muted">Adresse</label>
				                 		<input type="text" class="form-control" name="rue">
				                 	</div>
			                 	</div> 
			                 	<div class="row mt-3">
									<div class="col-8">
				                 		<label class="labels text-muted">Ville</label>
				                 		<input type="text" class="form-control" name="ville">
				                 	</div>
				                 	<div class="col-4">
				                 		<label class="labels text-muted">Code Postal</label>
				                 		<input type="text" class="form-control" name="code-postal">
				                 	</div>  	
			                 	</div> 
			  				</div>
		  				</div>
		  				
		                <div class="row mt-5">
		                 	<div class="col text-end"><button class="btn btn-custom profile-button w-50" type="submit">Enregistrer</button></div>
		                	<div class="col text-start"><a class="btn btn-secondary profile-button w-50" type="button" href="<%=request.getContextPath()%>/">Annuler</a></div>
		                </div>
			         </form>                   
			       </div>
		        </div>
	  		</div>
	  	</div>
                 
    </div>
</div>
<% } else { %>
<div class="container bg-white mt-5 mb-5">
    <div class="row">
    	<div class="col-6 mx-auto">
    		<div class="p-3 py-5">
            <div class="card shadow bg-white rounded">
            		<div class="card-header">
		                 <div class="card-title fw-bold fs-4"><i class='fas fa-exclamation-triangle'></i> Accès restreint</div>
		             </div>
	  				<div class="card-body">
	  				    <p><span class="test-muted fw-bold">Désolé.</span> Vous n'avez pas l'autorisation d'accéder à cette page.</p>
			       		<p>Veuillez vous connecter afin de pouvoir la consulter. <a href="<%=request.getContextPath()%>/login">Connexion</a></p>
			       </div>
		        </div>
	  		</div>
    	</div>
    </div>
</div>
<% } %>

</body>
</html>