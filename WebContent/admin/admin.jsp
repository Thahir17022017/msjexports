<%@page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<div class="container-fluid">
 
  <div class="row">
  		<div class="col-sm-2 mt-2">
  			<div style="position:fixed;z-index:1;overflow-x:hidden;height:100%;overflow-y:show;padding:20px;">
  					<img alt="admin logo image" src="icons/logo.png" style="border-radius:50%;">
  				
  					<p class="customfont mt-3 ml-4" onclick="confProducts()" style="color:white;cursor:pointer;font-size:20px;">Products</p>
  				
	  					<ol id="productlist">
	        				<c:forEach items="${list}"  var="ListItem">
	            					<li class="customfont" onclick="confIndProducts('${ListItem}')" style="color:white;cursor:pointer;">${ListItem}</li>
	        				</c:forEach> 
	    				</ol>
    		</div>
   		</div>
  		<div class="col-sm-10 mt-2">
  		         <div class="dropdown" style="display:inline;">
	  						<button class="dropbtn customfont" style="font-size:20px;"> Welcome ! ${name} <i class="fas fa-caret-down fa-1x" style="color:white;"></i></button>
	  						<div id="myDropdown" class="dropdown-content">
								    <a class="customfont" onclick="sendLogout()">Logout</a>
							</div>
	     	    </div>
         		<div class="customfont p-3" style="color:white;font-size:20px;display:inline;">
       					<i class="fas fa-users fa-1x" style="color:white;"></i>&nbsp; Total User Visits : ${usercount}
       			</div>
       			<div id="configure">
       			 	<br>
       			 	<br>
       			 	<br>
       			 	<br>
       			 	<br>
	     	    </div>
	     	    

       </div> 
  </div>
  <!-- <div class="row">
  			<div class="col-sm-2 mt-2">
  					 
  			</div>
  			<div class="col-sm-10 mt-2">
  				     	    <div id="configure">
	     	    			</div>
	     	</div>      
  </div> -->
  	 
</div>
  

