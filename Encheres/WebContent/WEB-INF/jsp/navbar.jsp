

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

.btn-custom:hover {
	color: #fff;
	opacity: 0.8;
}

.link-custom {
	color: #c471f4;
	text-decoration: none;
	font-weight: 600;
}

.link-custom:hover {
	color: #f570d0;
	opacity: 0.8;
}

.card-article {
	transition: all 0.3s ease-in-out;
}
.card-article:hover {
	transform: scale(1.03);
}

</style>

<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@page import="fr.eni.encheres.bo.Utilisateur"%>

<% if( session.getAttribute("ConnectedUser") != null){ 
	 Utilisateur connectedUser = (Utilisateur) session.getAttribute("ConnectedUser");%>
 		<!--Navbar-->		
 	<nav class="navbar navbar-expand-lg navbar-dark gradient-custom">
 	
	  <div class="container-fluid">
	  
	    <a class="navbar-brand fw-bold fs-4" href="<%=request.getContextPath()%>/">ENI Enchères</a>
	    
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
	        <li class="nav-item me-3 me-lg-1">
		        <a class="nav-link d-sm-flex align-items-sm-center" href="<%=request.getContextPath()%>/profil"> | &nbsp;
		          <img
		            src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"
		            class="rounded-circle" height="22" width="22" alt="User photo"/>
		          <strong class="d-none d-sm-block ms-1"> <%=connectedUser.getPseudo()%> </strong>
		        </a>
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