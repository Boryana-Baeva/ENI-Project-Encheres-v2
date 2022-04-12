

<!-- Connected page  -->
<!-- commit -->
<%@page import="fr.eni.encheres.bo.Utilisateur"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
  crossorigin="anonymous"></script>
<link rel="stylesheet" href="styles/navbar.css">

<% if( session.getAttribute("ConnectedUser") != null){ %>
 		<!--Navbar-->		
 	<nav class="navbar navbar-expand-lg navbar-dark gradient-custom">
 	
	  <div class="container-fluid">
	  
	    <a class="navbar-brand" href="<%=request.getContextPath()%>/accueil">ENI Enchères</a>
	    
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link" aria-current="page" href="#">Enchères</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="#">Vendre</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="#">Mon Profil</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<%=request.getContextPath()%>/logout">Déconnexion</a>
	        </li>
	      </ul>
	    </div>
	    
	  </div>
	</nav>
 
<% } else {  %>
<!-- Deconnected page -->

 <!--Navbar-->
 <nav class="navbar navbar-expand-lg navbar-dark gradient-custom">
 	
	  <div class="container-fluid">
	  
	    <a class="navbar-brand" href="<%=request.getContextPath()%>/accueil">ENI Enchères</a>
	    
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link" href="<%=request.getContextPath()%>/register">S'inscrire</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<%=request.getContextPath()%>/login">Se connecter</a>
	        </li>
	      </ul>
	    </div>
	    
	  </div>
	</nav>
 
<% } %>