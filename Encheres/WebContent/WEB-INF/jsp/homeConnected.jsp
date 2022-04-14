<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="fr.eni.encheres.bll.ArticleManager"%>
<%@page import="fr.eni.encheres.bll.CategorieManager"%>
<%@page import="fr.eni.encheres.bo.Categorie"%>
<%@page import="fr.eni.encheres.bo.Article"%>

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

<title>Accueil</title>
</head>
<body>
<!-- Navbar -->
<%@ include file = "navbar.jsp" %>
  
<div class="container">
	<!-- Filters -->
	<div class="row">
		<!-- Search bar -->
		<div class="col mt-5 pe-5">
			<div class="row filters mb-4">      
		       <div class="search"> 
		       	 <input type="text" class="form-control" placeholder="Le nom de l'article contient...">
		        </div>
			</div>
			<!-- Select -->
			<div class="row filters mb-4">
				<div class="col-3">
					<p class="text-muted">Catégories</p>
				</div>
				<div class="col-9">
					<select class="form-select" aria-label="Default select example"> 
					  <% for(Categorie categorie : CategorieManager.getAll()) { %>
			            <option name="categorie" value ="<%=categorie.getId()%>"><%=categorie.getLibelle()%></option>
			            <% } %>
					</select>
				</div>
			</div>
		</div>
		
		<div class="col mt-5">
			<!-- Radios -->
			<div class="row filters mb-4">
				<div class="form-check col">
				  <input class="form-check-input" type="radio" name="radioAchats" id="radioAchats">
				  <label class="form-check-label" for="radioAchats">
				    Achats
				  </label>
				  
				  <div class="form-check">
					  <input class="form-check-input" type="checkbox" value="" id="check1">
					  <label class="form-check-label" for="check1">
					    enchères ouvertes
					  </label>
				  </div>
				  <div class="form-check">
					  <input class="form-check-input" type="checkbox" value="" id="check1">
					  <label class="form-check-label" for="check1">
					    mes enchères en cours
					  </label>
				  </div>
				  <div class="form-check">
					  <input class="form-check-input" type="checkbox" value="" id="check1">
					  <label class="form-check-label" for="check1">
					    mes enchères remportées
					  </label>
				  </div>
				  
				</div>
				
				<div class="form-check col">
				  <input class="form-check-input" type="radio" name="radioVentes" id="radioVentes">
				  <label class="form-check-label" for="radioVentes">
				    Mes ventes
				  </label>
				  
				  <div class="form-check">
					  <input class="form-check-input" type="checkbox" value="" id="check1">
					  <label class="form-check-label" for="check1">
					    ventes en cours
					  </label>
				  </div>
				  <div class="form-check">
					  <input class="form-check-input" type="checkbox" value="" id="check1">
					  <label class="form-check-label" for="check1">
					   ventes non débutées
					  </label>
				  </div>
				  <div class="form-check">
					  <input class="form-check-input" type="checkbox" value="" id="check1">
					  <label class="form-check-label" for="check1">
					    ventes terminées
					  </label>
				  </div>
				  
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col w-50 text-center mt-3">
			<button class="btn btn-custom text-light">Rechercher</button>
		</div>	
	</div>

	<div class="text-center my-5">
	   <h5>Enchères En Cours</h5>
	</div>

    <div class="card-grid row">
    
     <% List<Article> listeArticles = ArticleManager.getAll(); %>
     <% if(listeArticles.size() != 0) { %>
   			<% for(Article article : listeArticles) { %> 
		      <div class="col-6 my-3">
		       <div class="card shadow bg-white rounded card-article">
		             <div class="card-header">
		                 <div class="card-title">
		                 <a href="<%=request.getContextPath()%>/article?id=<%=article.getId() %>" class="link-custom">
		                 <%=article.getNom()%></a>
		                 </div>
		             </div>
		             <div class="row">
		             	<div class="col-3">
			             	<div class="card-img">
				                  <img class="rounded-circle" width="150px" src="https://www.arraymedical.com/wp-content/uploads/2018/12/product-image-placeholder.jpg">
				             </div>
			             </div>
			             <div class="col-9">
				             <div class="card-body">
				                 <div class="prix">
				                 	<p><i class="fa-solid fa-tag text-secondary"></i><span class="text-muted"> Mise à prix: </span><%=article.getMiseAPrix()%> crédits</p>
				                 </div>
				                 <% if(article.getPrixVente() != 0) { %> 
			                   	 	<div class="prix">
					                 	<p><i class="fa-solid fa-tag text-secondary"></i><span class="text-muted"> Prix actuel: </span><%=article.getPrixVente()%> crédits</p>
					                 </div>
			                   	 <%} else { %>
			                   	 	 <div class="prix">
					                 	<p><i class="fa-solid fa-tag text-secondary"></i><span class="text-muted"> Prix actuel: </span><%=article.getMiseAPrix()%> crédits</p>
					                 </div>
			                   	 <%}  %>
				                 
				                 <div class="card-date-enchere">
				                     <p><i class="fa-solid fa-calendar-check text-secondary"></i><span class="text-muted"> Fin de l'enchère: </span> <%=article.getDateDebutEncheres().format(DateTimeFormatter.ofPattern("dd/MM/YYYY", Locale.FRANCE))%></p>
				                 </div>
				                 <div class="vendeur">
				                     <p><i class="fa-solid fa-user text-secondary"></i><span class="text-muted"> Vendeur: </span> 
				                     <a href="<%=request.getContextPath()%>/profil?id=<%=article.getVendeur().getId() %>"
				                     class="z-index"><%=article.getVendeur().getPseudo()%></a>
				                     </p>
				                 </div>
				             </div>
				         </div>
		             </div>             
		         </div>
		      </div>
   	       <% } %>    
	   <% } else { %>
           <h1>Aucun article</h1>
       <% } %>
           
       
    </div>
</div>
</body>
</html>