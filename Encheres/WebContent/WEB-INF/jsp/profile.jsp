<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
  crossorigin="anonymous"></script>
  
<title>Profil</title>
</head>
<body>
<!-- Navbar -->
 	<%@ include file = "navbar.jsp" %>

	<%if(session.getAttribute("ConnectedUser")!=null){
		Utilisateur connectedUser = (Utilisateur) session.getAttribute("ConnectedUser");	%>
		

	<div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
	            <img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
	            <!-- <img class="rounded-circle mt-5" width="150px" src="img/icons8-brown-long-hair-lady-with-red-glasses.png"> -->
	            
	            <span class="font-weight-bold"><%=connectedUser.getPseudo() %></span>
	            <span class="text-black-50"><%=connectedUser.getEmail()%></span>
            </div>
        </div>
        <div class="col-md-6 border-right">
            <div class="p-3 py-5">
            	<div class="card shadow bg-white rounded">
            		<div class="card-header">
		                 <div class="card-title fw-bold fs-4">Mon Profil</div>
		             </div>
	  				<div class="card-body">
		                <div class="row mt-2">
		                	<div class="col">
		                		<div class="col-md-6 card-subtitle mb-2 text-muted">Prénom</div>
		                    	<p class="card-text"><%=connectedUser.getPrenom() %></p> 
		                	</div>
		                    
		                    <div class="col">
		                		<div class="col-md-6 card-subtitle mb-2 text-muted">Nom</div>
		                    	<p class="card-text"><%=connectedUser.getNom() %></p>
		                	</div>
		                </div>
		                <div class="row mt-4">
		                <div class="col">
		                		<div class="col-md-6 card-subtitle mb-2 text-muted">Email</div>
		                    	<p class="card-text"><%=connectedUser.getEmail() %></p> 
		                	</div>
		                    
		                    <div class="col">
		                		<div class="col-md-6 card-subtitle mb-2 text-muted">Téléphone</div>
		                    	<p class="card-text"><%=connectedUser.getTelephone() %></p>
		                	</div>	 
		                </div>
		                <div class="row mt-5">
		                <div class="col-md-6 card-subtitle mb-2 text-muted">Adresse</div>
		                    <p class="card-text"><%=connectedUser.getRue() %></p>
		                   
		                </div>
		                <div class="row mt-3">
		                   <div class="col">
		                		<div class="col-md-6 card-subtitle mb-2 text-muted">Ville</div>
		                    	<p class="card-text"><%=connectedUser.getVille() %></p> 
		                	</div>
		                    
		                    <div class="col">
		                		<div class="col-md-6 card-subtitle mb-2 text-muted">Code postal</div>
		                    	<p class="card-text"><%=connectedUser.getCodePostal() %></p>
		                	</div>
		                </div>
		            </div>
				</div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="p-3 py-5 d-flex">        
               <div class="text-center d-inline w-100"><button class="btn btn-warning profile-button" type="button">Modifier</button></div>
               <div class="text-center d-inline w-100"><button class="btn btn-danger profile-button" type="button">Suprimmer</button></div>
            </div>
        </div>
    </div>
</div>

<%}%>


</body>
</html>