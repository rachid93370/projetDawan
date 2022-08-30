<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp">
	<c:param name="titre" value="springboot project" />
</c:import>
<main class="container">
	<h2 class="text-center bg-dark text-light rounded p-5 mx-auto">Bienvenue sur notre boutique retrogaming !!!</h2>
	<c:forTokens items = "Jeux,Consoles,Accessoires" delims = "," var = "categorie">	   
		<div class="container my-5" value="${ i }" >
			<h2 class="mb-3">Nos <c:out value = "${categorie}"/></h2>
    		<div class="row">
        		<div id="recipeCarousel<c:out value = "${categorie}"/>" class="carousel slide" data-bs-ride="carousel">
           	 		<div class="carousel-inner" role="listbox">
                		<div class="carousel-item active">
                   			<div class="col-lg-3 px-3 col-md-6">
                        		<div class="card border-0 rounded">
                            		<div class="card-img">
                                		<img src="https://www.tradergames.fr/241796-home_default/metal-slug-3-neo-geo-aes-japan-complete-good-condition-first-run.jpg" class="img-fluid">
                            		</div>
                        		</div>
                    		</div>
                		</div>
                		<div class="carousel-item">
                    		<div class="col-lg-3 col-md-6 px-3">
                        		<div class="card border-0 rounded">
                            		<div class="card-img">
                                		<img src="https://www.picclickimg.com/d/l400/pict/275425012779_/SEGA-MEGADRIVE-PAL-FlashBack-Sans-notice.jpg" class="img-fluid">
                            		</div>                           		
                        		</div>
                    		</div>
                		</div>
                		<div class="carousel-item">
                    		<div class="col-lg-3 col-md-6 px-3">
                        		<div class="card border-0 rounded">
                            		<div class="card-img">
                               			<img src="" class="img-fluid">
                            		</div>
                        		</div>
                    		</div>
                		</div>
                		<div class="carousel-item">
                    		<div class="col-lg-3 col-md-6 px-3">
                        		<div class="card border-0 rounded"> 
                            		<div class="card-img">
                                		<img src="" class="img-fluid">
                            		</div>
                        		</div>
                    		</div>
                		</div>
                		<div class="carousel-item">
                    		<div class="col-lg-3 col-md-6 px-3">
                        		<div class="card border-0 ">
                            		<div class="card-img">
                                		<img src="" class="img-fluid">
                            		</div>
                        		</div>
                    		</div>
                		</div>
                		<div class="carousel-item ">
                    		<div class="col-lg-3 col-md-6 px-3">
                        		<div class="card border-0 rounded">
                            		<div class="card-img">
                                		<img src="" class="img-fluid">
                            		</div>
                        		</div>
                    		</div>
                		</div>
            		</div>
            		<a class="carousel-control-prev bg-transparent w-aut" href="#recipeCarousel<c:out value = "${categorie}"/>" role="button" data-bs-slide="prev">
                		<span class="carousel-control-prev-icon" aria-hidden="true"></span>
            		</a>
            		<a class="carousel-control-next bg-transparent w-aut" href="#recipeCarousel<c:out value = "${categorie}"/>" role="button" data-bs-slide="next">
                		<span class="carousel-control-next-icon" aria-hidden="true"></span>
            		</a>
        		</div>
    		</div>
		</div>
		<hr>
	</c:forTokens>
</main>
<c:import url="footer.jsp" />