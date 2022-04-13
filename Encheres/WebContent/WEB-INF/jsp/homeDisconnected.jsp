<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
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
<title>ENI-Enchères | Accueil </title>
</head>
<body>

<!-- Navbar -->
<jsp:include page="/WEB-INF/jsp/navbar.jsp"></jsp:include>

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
					  <option selected>Selectionner une catégorie</option>
					  <option value="1">Toutes</option>
					  <option value="2">Catégorie 1</option>
					  <option value="3">Catégorie 2</option>
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
	   <h5>Enchères En Cours D</h5>
	</div>

    <div class="card-grid row">
       
       <div class="col-6 my-3">
	       <div class="card shadow bg-white rounded">
	             <div class="card-header">
	                 <div class="card-title">Article<a href="#"></a></div>
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
			                 	<p><i class="fa-solid fa-tag text-secondary"></i><span class="text-muted"> Prix:</span>100</p>
			                 </div>
			                 
			                 <div class="card-date-enchere">
			                     <p><i class="fa-solid fa-calendar-check text-secondary"></i><span class="text-muted"> Fin de l'enchère:</span> 22/04/2022</p>
			                 </div>
			                 <div class="vendeur">
			                     <p><i class="fa-solid fa-user text-secondary"></i><span class="text-muted"> Vendeur:</span> yana1</p>
			                 </div>
			             </div>
			         </div>
	             </div>             
	         </div>
       </div>
           
       <div class="col-6 my-3">
	       <div class="card shadow bg-white rounded">
	             <div class="card-header">
	                 <div class="card-title">Article<a href="#"></a></div>
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
			                 	<p><i class="fa-solid fa-tag text-secondary"></i><span class="text-muted"> Prix:</span>100</p>
			                 </div>
			                 
			                 <div class="card-date-enchere">
			                     <p><i class="fa-solid fa-calendar-check text-secondary"></i><span class="text-muted"> Fin de l'enchère:</span> 22/04/2022</p>
			                 </div>
			                 <div class="vendeur">
			                     <p><i class="fa-solid fa-user text-secondary"></i><span class="text-muted"> Vendeur:</span> yana1</p>
			                 </div>
			             </div>
			         </div>
	             </div>             
	         </div>
       </div>
       
       <div class="col-6 my-3">
	       <div class="card shadow bg-white rounded">
	             <div class="card-header">
	                 <div class="card-title">Article<a href="#"></a></div>
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
			                 	<p><i class="fa-solid fa-tag text-secondary"></i><span class="text-muted"> Prix:</span>100</p>
			                 </div>
			                 
			                 <div class="card-date-enchere">
			                     <p><i class="fa-solid fa-calendar-check text-secondary"></i><span class="text-muted"> Fin de l'enchère:</span> 22/04/2022</p>
			                 </div>
			                 <div class="vendeur">
			                     <p><i class="fa-solid fa-user text-secondary"></i><span class="text-muted"> Vendeur:</span> yana1</p>
			                 </div>
			             </div>
			         </div>
	             </div>             
	         </div>
       </div>
       
       <div class="col-6 my-3">
	       <div class="card shadow bg-white rounded">
	             <div class="card-header">
	                 <div class="card-title">Article<a href="#"></a></div>
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
			                 	<p><i class="fa-solid fa-tag text-secondary"></i><span class="text-muted"> Prix:</span>100</p>
			                 </div>
			                 
			                 <div class="card-date-enchere">
			                     <p><i class="fa-solid fa-calendar-check text-secondary"></i><span class="text-muted"> Fin de l'enchère:</span> 22/04/2022</p>
			                 </div>
			                 <div class="vendeur">
			                     <p><i class="fa-solid fa-user text-secondary"></i><span class="text-muted"> Vendeur:</span> yana1</p>
			                 </div>
			             </div>
			         </div>
	             </div>             
	         </div>
       </div>
    </div>
</div>
</body>
</html>