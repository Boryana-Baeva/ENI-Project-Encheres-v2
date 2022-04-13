

<!-- Connected page  -->
<!-- commit -->

<style>
.gradient-custom {
  /* fallback for old browsers */
  background: #c471f5;

  /* Chrome 10-25, Safari 5.1-6 */
  background: -webkit-linear-gradient(to right, rgba(196, 113, 245, 1), rgba(250, 113, 205, 1));

  /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  background: linear-gradient(to right, rgba(196, 113, 245, 1), rgba(250, 113, 205, 1))
}

.navbar-dark .navbar-nav .nav-link {
	color: #fff;
}

.btn-custom {
	background-color: #c471f4;
	color: #fff;
}
</style>

<%@page import="fr.eni.encheres.bo.Utilisateur"%>

<% if( session.getAttribute("ConnectedUser") != null){ %>
 		<!--Navbar-->		
 	<nav class="navbar navbar-expand-lg navbar-dark gradient-custom">
 	
	  <div class="container-fluid">
	  
	    <a class="navbar-brand" href="<%=request.getContextPath()%>/">ENI Enchères</a>
	    
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link" aria-current="page" href="<%=request.getContextPath()%>/">Enchères</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<%=request.getContextPath()%>/vendre">Vendre</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<%=request.getContextPath()%>/profil">Mon Profil</a>
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
	  
	    <a class="navbar-brand" href="<%=request.getContextPath()%>/">ENI Enchères</a>
	    
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