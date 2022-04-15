<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fr.eni.encheres.bo.Utilisateur"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
  crossorigin="anonymous"></script>
  <!--  <link rel="stylesheet" href="styles/style.css">-->
  <link href="${pageContext.request.contextPath}/styles/style.css" rel="stylesheet">
<title>Connexion</title>
</head>
<body>


<% if( session.getAttribute("ConnectedUser") == null){ %>
	<div class="containter-fluid h-100">
	    <div class="container" id="login-form-container">
	        <div class="row">
	            <div class="col col-md-8 col-lg-5 offset-md-4 mx-auto">
	
	                <div class="card bg-white shadow mt-4 p-4 px-5">
	                    <div class="card-body">
	
	                        <form method="post" class="g-3" id="login-form">
	                            <h4 class="col card-title text-center pt-3 pb-5">Connexion</h4>
	
								<div class="input-group">
									<div class="input-group-prepend">
									    <span class="input-group-text" id="basic-addon1">
										    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="24" fill="currentColor" class="bi bi-envelope-fill" viewBox="0 0 16 16">
											  <path d="M.05 3.555A2 2 0 0 1 2 2h12a2 2 0 0 1 1.95 1.555L8 8.414.05 3.555ZM0 4.697v7.104l5.803-3.558L0 4.697ZM6.761 8.83l-6.57 4.027A2 2 0 0 0 2 14h12a2 2 0 0 0 1.808-1.144l-6.57-4.027L8 9.586l-1.239-.757Zm3.436-.586L16 11.801V4.697l-5.803 3.546Z"/>
											</svg>
									    </span>
								  	</div>
		                            <div class="col pb-4">
		                                
		                                <input id="username" type="text" name="username" class="form-control" placeholder="Indentifiant">
		                            </div>
		                        </div>
		
								<div class="input-group">
									<div class="input-group-prepend">
									    <span class="input-group-text" id="basic-addon1">
										    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="24" fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">
											  <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"/>
											</svg>
									    </span>
								  	</div>
		                            <div class="col pb-4">

		                                <input id="password" type="password" name="password" id="password" class="form-control" placeholder="******">
		                                <i class="bi bi-eye-slash position-absolute d-none d-md-block" id="togglePassword"></i>
		                            </div>
		                       	</div>
	
								<div class="input-group">
		                            <!-- Remember me -->
		                            <div class="col pb-4">
		                                <div class="form-check">
		                                    <input class="form-check-input" type="checkbox" id="rememberMe" name="remember_me">
		                                    <label class="form-check-label" for="rememberMe"> Se souvenir de moi</label>
		                                </div>
		                            </div>
	                            </div>
	
								
								<!-- Button Submit  -->
	                            <div class="col text-center pt-4">
	                                <button type="submit" id="btn-login" name="btn-login"
	                                        class="btn btn-custom btn-primary w-100">Se connecter
	                                </button>
	                            </div> 
	                            
	                            
	                            <div class="col text-center pt-4">
	                            <h6>Vous avez pas encore de compte ?</h6>
	                                <a href="<%=request.getContextPath()%>/register" id="btn-register" name="btn-register"
	                                        class="btn btn-secondary w-100">S'inscrire
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
		  				    <p><span class="test-muted fw-bold">Désolé.</span> Vous etês déjà connecté. Vous n'avez pas l'accès à cette page.</p>
				       </div>
			        </div>
		  		</div>
	    	</div>
	    </div>
	</div>
<% } %>
</body>
</html>