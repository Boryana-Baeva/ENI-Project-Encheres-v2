<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ENI-Enchères | Accueil </title>
</head>
<body>

<!-- Navbar -->
 	<%@ include file = "navbar.jsp" %>

    <div class="head">
        <h5>Enchères En Cours</h5>
    </div>
    
    <div class="container">
        <div class="card-grid">
           <div class="card">
             <div class="card-header">
                 <h1><a href="#"></a></h1>
             </div>
             <div class="card-img-container">
                 <!--  <img src="" alt="">-->
             </div>
             <div class="card-body">
                 <div class="prix"><i class="fas fa-tag"></i>100</div>
                 
                 <div class="card-date-enchere">
                     <p><i class="far fa-clock"></i>22/04/2022</p>
                 </div>
                 <div class="vendeur">
                     <p><i class="fas fa-id-badge"></i> yana1</p>
                 </div>
             </div>
         </div>  
        </div>
    </div>
</body>
</html>