<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
  crossorigin="anonymous"></script>
<title>Inscription</title>
</head>
<body>
	<div class="containter-fluid h-100">
	    <div class="container" id="login-form-container">
	        <div class="row">
	            <div class="col col-md-8 col-lg-5 offset-md-4 mx-auto">
	
	                <div class="card bg-white shadow mt-4 p-4 px-5">
	                    <div class="card-body">
	
	                        <form method="post" class="g-3" id="login-form">
	                            <h4 class="col card-title text-center pt-3 pb-5">Inscription</h4>
	
	                            <div class="col pb-4">
	                                <label>Email</label>
	                                <input type="email" name="email" class="form-control" placeholder="Email">
	                            </div>
	
	                            <div class="col pb-4 position-relative">
	                                <label>Mot de passe</label>
	                                <input type="password" name="password" id="password" class="form-control" placeholder="Password">
	                                <i class="bi bi-eye-slash position-absolute d-none d-md-block" id="togglePassword"></i>
	                            </div>
	
	                            <!-- Button Submit  -->
	                            <div class="col text-center pt-4">
	                                <button type="submit" id="btn-login" name="btn-login"
	                                        class="btn btn-primary w-100">S'inscrire
	                                </button>
	                            </div>        
	
	                        </form>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>