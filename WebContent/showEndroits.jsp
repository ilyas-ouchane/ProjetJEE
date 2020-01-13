<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div class="col-lg-9">
          	<div class="row">
          			  <c:forEach var = "e" items = "${endroits}"> 
		    			<div class="col-sm col-md-6 col-lg-4 ftco-animate">
		    				<div class="destination">
		    					<a href="#" class="img img-2 d-flex justify-content-center align-items-center" style="background-image: url(${e.image_endroit});">
		    						<div class="icon d-flex justify-content-center align-items-center">
		    							<span class="icon-link"></span>
		    						</div>
		    					</a> 
						    		<div class="row no-gutters">
						    			<div class="col-lg-6">
						    				<div class="room-wrap d-md-flex ftco-animate">
						    					<a href="#" class="img" style="background-image: url(images/room-6.jpg);"></a>
						    					<div class="half left-arrow d-flex align-items-center">
						    						<div class="text p-4 text-center">
						    							<p class="mb-0"><p>${e.getVille_endroit()} </p>
						    							<p class="mb-0"><span class="price mr-1">${e.getNom_endroit()}</span> <span class="per">per night</span></p>
							    						<h3 class="mb-3"><a href="#"><p>${h.getDescp_endroit()}</p></a></h3>
							    						<p class="pt-1"><a href="GetOneHotelData?hotel=<c:out value="${h.getId_endroit()}"/>" class="btn-custom px-3 py-2 rounded">View Details <span class="icon-long-arrow-right"></span></a></p>
						    						</div>
						    					</div>
						    				</div>
						    			</div>
						    		</div>		
		    				</div>
		    			</div>
		     </c:forEach>
		     </div>
		     <a href="addendroit.jsp"></a>
</body>
</html>