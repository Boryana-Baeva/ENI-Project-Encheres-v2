<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" /> 
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
  crossorigin="anonymous"></script>
<title>Inscription</title>
</head>
<body>
<% if( session.getAttribute("ConnectedUser") == null){ %>
	<div class="containter-fluid">
	    <div class="container" id="login-form-container">
	        <div class="row">
	            <div class="col col-md-8 col-lg-6 offset-md-4 mx-auto">
	                <div class="card bg-white shadow mt-4 p-4 px-5">
	                    <div class="card-body">
	                        <form method="post" action="<%=request.getContextPath() %>/register" class="g-3" id="login-form">
	                            <h4 class="col card-title text-center pt-3 pb-5">Inscription</h4>
	
								<div class="row">
									<div class="form-group">
										 <div class="input-group">
										     <div class="input-group-prepend">
											    <span class="input-group-text" id="basic-addon1">
												    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="24" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
													  <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
													</svg>
											    </span>
											  </div>
											<div class="col pb-4">
				                                <input type="text" name="pseudo" class="form-control" placeholder="Identifiant">
				                            </div>
				                         </div>
		                            </div>
								</div>
								
								<div class="row">
									<div class="input-group">
										<div class="col pb-4 pe-5">
			                                <input type="text" name="prenom" class="form-control" placeholder="Prénom">
		                            	</div>
		                            	<div class="col pb-4">
			                                <input type="text" name="nom" class="form-control" placeholder="Nom">
		                            	</div>
	                            	</div>
								</div>
								
								<br> 
								
								<div class="row">
									<div class="input-group">
										<div class="input-group-prepend">
										    <span class="input-group-text" id="basic-addon1">
											    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="24" fill="currentColor" class="bi bi-envelope-fill" viewBox="0 0 16 16">
												  <path d="M.05 3.555A2 2 0 0 1 2 2h12a2 2 0 0 1 1.95 1.555L8 8.414.05 3.555ZM0 4.697v7.104l5.803-3.558L0 4.697ZM6.761 8.83l-6.57 4.027A2 2 0 0 0 2 14h12a2 2 0 0 0 1.808-1.144l-6.57-4.027L8 9.586l-1.239-.757Zm3.436-.586L16 11.801V4.697l-5.803 3.546Z"/>
												</svg>
										    </span>
										</div>
										<div class="col pb-4">
			                                <input type="email" name="email" class="form-control" placeholder="Email">
		                            	</div>
		                            </div>
								</div>
								
								<div class="row">
									<div class="input-group">
		                            	<div class="input-group-prepend">
										    <span class="input-group-text" id="basic-addon1">
											    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="24" fill="currentColor" class="bi bi-telephone-fill" viewBox="0 0 16 16">
												  <path fill-rule="evenodd" d="M1.885.511a1.745 1.745 0 0 1 2.61.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
												</svg>
										    </span>
										</div>
		                            	<div class="col pb-4">
			                                <input type="tel" name="telephone" class="form-control" placeholder="06 12 34 56 78">
		                            	</div>
	                             	</div>
								</div>	
								
								<div class="row">
									<div class="input-group">
										<div class="input-group-prepend">
											    <span class="input-group-text" id="basic-addon1">
												    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="24" fill="currentColor" class="bi bi-building" viewBox="0 0 16 16">
													  <path fill-rule="evenodd" d="M14.763.075A.5.5 0 0 1 15 .5v15a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5V14h-1v1.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V10a.5.5 0 0 1 .342-.474L6 7.64V4.5a.5.5 0 0 1 .276-.447l8-4a.5.5 0 0 1 .487.022zM6 8.694 1 10.36V15h5V8.694zM7 15h2v-1.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5V15h2V1.309l-7 3.5V15z"/>
													  <path d="M2 11h1v1H2v-1zm2 0h1v1H4v-1zm-2 2h1v1H2v-1zm2 0h1v1H4v-1zm4-4h1v1H8V9zm2 0h1v1h-1V9zm-2 2h1v1H8v-1zm2 0h1v1h-1v-1zm2-2h1v1h-1V9zm0 2h1v1h-1v-1zM8 7h1v1H8V7zm2 0h1v1h-1V7zm2 0h1v1h-1V7zM8 5h1v1H8V5zm2 0h1v1h-1V5zm2 0h1v1h-1V5zm0-2h1v1h-1V3z"/>
													</svg>
											    </span>
										</div>
										<div class="col pb-4">
			                                <input type="text" name="adresse" class="form-control" placeholder="Adresse">
			                            </div>
		                            </div>
								</div>
								
								<div class="row">
									<div class="col pb-4">
		                                <input type="text" name="ville" class="form-control" placeholder="Ville">
		                            </div>
		                            <div class="col pb-4">
		                                <input type="text" name="code_postal" class="form-control" placeholder="Code postal">
		                            </div>
								</div>
								
								<br> 
								
								<div class="row">
									<div class="col pb-4 position-relative">
										<label>Mot de passe</label>
		                                <input type="password" name="password" id="password" class="form-control" placeholder="******">
		                                <i class="bi bi-eye-slash position-absolute d-none d-md-block" id="togglePassword"></i>
		                            </div>
		                            <div class="col pb-4 position-relative">
		                                <label>Confirmation</label>
		                                <input type="password" name="password_confirmation" id="password" class="form-control" placeholder="******">
		                                <i class="bi bi-eye-slash position-absolute d-none d-md-block" id="togglePassword"></i>
		                            </div>
								</div>
								
	                            
	                            <div class="row">
		                            	<!-- Button Submit  -->
		                            <div class="col text-center pt-4">
		                                <button type="submit" id="btn-register" name="btn-register"
		                                        class="btn btn-primary w-100">Créer
		                                </button>
		                            </div>
		                            <div class="col text-center pt-4">
		                                <a href="<%=request.getContextPath()%>/accueil" id="btn-cancel" name="btn-cancel"
		                                        class="btn btn-secondary w-100">Annuler
		                                </a>
		                            </div>       
	                            </div>
	                            
	                            <div class="col text-center pt-4">
	                            <h6>Vous avez déjà un compte ?</h6>
	                                <a href="<%=request.getContextPath()%>/login" id="btn-login" name="btn-login"
	                                        class="btn btn-primary w-100">Se connecter
	                                </a>
	                            </div>
	            
	                        </form>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	<% } else { %>
	<jsp:include page="/WEB-INF/jsp/navbar.jsp"></jsp:include>
	<div class="container bg-white mt-5 mb-5">
	    <div class="row">
	    	<div class="col-6 mx-auto">
	    		<div class="p-3 py-5">
	            <div class="card shadow bg-white rounded">
	            		<div class="card-header">
			                 <div class="card-title fw-bold fs-4"><i class='fas fa-exclamation-triangle'></i> Accès restreint</div>
			             </div>
		  				<div class="card-body">
		  				    <p><span class="test-muted fw-bold">Désolé.</span> En tant qu'utilisateur connecté, vous n'avez pas l'autorisation d'accéder à la page d'inscription.</p>
				       </div>
			        </div>
		  		</div>
	    	</div>
	    </div>
	</div>
<% } %>
</body>
</html>