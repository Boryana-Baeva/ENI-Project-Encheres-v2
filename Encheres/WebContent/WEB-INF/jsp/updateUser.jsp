<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fr.eni.encheres.bll.CategorieManager"%>
<%@page import="fr.eni.encheres.bo.Categorie"%>
<%@page import="fr.eni.encheres.bo.Article"%>
<%@page import="fr.eni.encheres.bo.Utilisateur"%>

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
<title>Modifier Mon Profil</title>
</head>
<body>
<!-- Navbar -->
<jsp:include page="/WEB-INF/jsp/navbar.jsp"></jsp:include>


<% Utilisateur connectedUser = (Utilisateur) session.getAttribute("ConnectedUser");
	Utilisateur user = (Utilisateur) request.getAttribute("user");
%>

<% if(connectedUser.getId() == user.getId()  || connectedUser.isAdministrateur()) { %>

<div class="container bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center py-5">
           		<img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">    
            	<span class="font-weight-bold"><%=connectedUser.getPseudo() %></span>
	            <span class="text-black-50"><%=connectedUser.getEmail()%></span>
            </div>
        </div>
        <div class="col-md-9 border-right">
            <div class="p-3 py-5">
            <div class="card shadow bg-white rounded">
            		<div class="card-header">
		                 <div class="card-title fw-bold fs-4">Modifier Profil</div>
		             </div>
	  				<div class="card-body">
	  				<form class="update-user" action="<%=request.getContextPath() %>/modifier-profil?id=<%= user.getId() %>" method="POST">
		  				
	  					<div class="row mt-3">
		                    <div class="col text-muted"><label class="labels">Prénom</label>
		                    	<input type="text" class="form-control"
		                    	 name="prenom"value="<%= user.getPrenom() %>">
		                    </div>
		                    <div class="col text-muted"><label class="labels">Nom</label>
		                    	<input type="text" class="form-control"
		                    	 name="nom" value="<%= user.getNom() %>">
		                    </div>
		                </div>
		                
		                <div class="row mt-3">
		                    <div class="col text-muted"><label class="labels">Email</label>
		                    	<input type="text" class="form-control"
		                    	 name="email" value="<%= user.getEmail() %>">
		                    </div>
		                    <div class="col text-muted"><label class="labels">Téléphone</label>
		                    	<input type="text" class="form-control"
		                    	 name="telephone" value="<%= user.getTelephone() %>">
		                    </div>
		                </div>
		                
		                <div class="row mt-3">
		                    <div class="col-md-6 text-muted"><label class="labels">Adresse</label>
		                    	<input type="text" class="form-control"
		                    	name="rue" value="<%= user.getRue() %>">
		                    </div>
		                    <div class="col-md-2 text-muted"><label class="labels">Code Postal</label>
		                    	<input type="text" class="form-control"
		                    	 name="code_postal" value="<%= user.getCodePostal() %>">
		                    </div>
		                    <div class="col-md-4 text-muted"><label class="labels">Ville</label>
		                    	<input type="text" class="form-control"
		                    	name="ville" value="<%= user.getVille() %>">
		                    </div>
		                </div>
		                
		                <div class="row mt-3">
		                    <div class="col-md-2 text-muted"><label class="labels">Crédit </label>
		                    	<input type="number" class="form-control"
		                    	name="credit" value="<%= user.getCredit()%>">
		                    </div>
		                </div>
			  				
		  				
		                <div class="row mt-5">
		                 	<div class="col text-end"><button class="btn btn-custom profile-button w-50" type="submit">Enregistrer</button></div>
		                	<div class="col text-start"><a class="btn btn-secondary profile-button w-50" type="button" href="<%=request.getContextPath() %>/profil">Annuler</a></div>
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
			       </div>
		        </div>
	  		</div>
    	</div>
    </div>
</div>
<% } %>

</body>
</html>