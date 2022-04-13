<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		  				<div class="row">
		  					<div class="col">
			  					<div class="row mt-3">
				                    <div class="col text-muted"><label class="labels">Article</label>
				                    	<input type="text" class="form-control" placeholder="Nom de l'article" name="nom">
				                    </div>
				                </div>
				                <div class="row mt-3">
				                 	<div class="col text-muted"><label class="labels">Description</label>
				                    	<textarea class="form-control" name="description" placeholder="Description..." rows="4" cols="50"></textarea>
				                    </div>
			                	</div>
			  				</div>
			  				<div class="col">
			  					<div class="row mt-3">
				                    <div class="col-8">
				                    	<label class="labels text-muted">Catégorie</label>
				                    	<select class="form-select" aria-label="categories" name="category">
										  <option selected>Choisir une catégorie</option>
										  <option value="1">Catégorie 1</option>
										  <option value="2">Catégorie 2</option>
										  <option value="3">Catégorie 3</option>
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
			  				</div>
		  				</div>
		  				
		                <div class="row mt-5">
		                 	<div class="col text-end"><button class="btn btn-custom profile-button" type="button">Enregistrer</button></div>
		                	<div class="col text-start"><button class="btn btn-secondary profile-button" type="button">Annuler</button></div>
		                </div>
			                            
			       </div>
		        </div>
	  		</div>
	  	</div>
                 
    </div>
</div>


</body>
</html>