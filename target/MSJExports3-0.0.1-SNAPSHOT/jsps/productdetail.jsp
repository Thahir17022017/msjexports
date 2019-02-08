<%@page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
<br>
<br>
<br>
<br>
<div class="row">
  <div class="col-sm-12 mt-1 p-2">
   <!-- <form action="/MSJExports/FileUploadServlet" method="post" enctype="multipart/form-data"> -->
   <form action="/MSJExports/FileUploadServlet" method="POST" enctype="multipart/form-data" id="BannerImageForm">
  	<h2 id="productType" class="customfont" style="color:white;" name="${detailType}">${detailType} Configurations:</h2>
    <label class="customfont" style="color:white;font-size:28px;">Banner Image :</label><span id="bannerImgRes" class="customfont" style="color:white;font-size:28px;">${bannerName}</span>
    <br>

    <input accept="image/png" class="customfont inputfile" id="bannerImage" type="file" name="fileName" style="color:white;border:none;outline:none;cursor:pointer;" onchange="changeLabel()" >
    <label id="chooseLbl" for="bannerImage" class="customfont">Choose a file</label>
    
    <div><input id="btnSubmit" class="btn btn-success customfont mt-3" type="button" value="Upload Image" style="color:white;cursor:pointer;" onclick="bannerImageUpload()">
    
    
    
    </div>
    
    
   </form> 
  </div>

  
</div>
<br>
<br>
<label class="customfont" style="color:white;font-size:28px;">Gallery Images :</label>
<div class="row">
  <div class="col-sm-4">
   <!-- <form action="/MSJExports/UploadBannerImage" method="post" enctype="multipart/form-data">-->
   <form>
  	
    
    
    <input accept="image/png" class="customfont inputfile" id="galleryImage" type="file" name="fileName" style="color:white;border:none;outline:none;cursor:pointer;" onchange="changeLabel2()" >
    <label id="chooseLbl2" for="galleryImage" class="customfont">Choose a file</label>
    
    
    
    
   </form> 
  </div>
  <div class="col-sm-4">
      <div class="dropdown">
  		<button id="galleryImageDrop" class="dropbtn customfont btn btn-success" style="color:white;background-color:#218838">Image Positions <i class="fas fa-caret-down fa-1x" style="color:white;"></i></button>
  		<div id="myDropdown" class="dropdown-content customfont">
			    <a href="#" class="customfont" onclick="selectGalleryImage('Image 1')">Image 1</a>
			    <a href="#" class="customfont" onclick="selectGalleryImage('Image 2')">Image 2</a>
			    <a href="#" class="customfont" onclick="selectGalleryImage('Image 3')">Image 3</a>
  		</div>
	</div>
	</div>
  <div class="col-sm-4">
  	 	<div><input class="btn btn-success customfont" type="button" value="Upload Image" style="color:white;cursor:pointer;padding:9px;" onclick="galleryImageUpload()"></div>
  </div>
  
  
</div>
<br>
<br>
<div class="row">
    <div class="col-sm-12">
      			<label class="customfont" style="color:white;font-size:22px;">Configured Images :</label>
				<ul>
					  <li class="customfont"  style="background-color:transparent;color:white;border:none;font-size:20px;list-style-type: none;">Image 1  : <span id="Image 1" class="customfont" style="color:white">${Image1}</span></li>
					  <li class="customfont"  style="background-color:transparent;color:white;border:none;font-size:20px;list-style-type: none;">Image 2 : <span id="Image 2" class="customfont" style="color:white">${Image2}</span></li>
					  <li class="customfont"  style="background-color:transparent;color:white;border:none;font-size:20px;list-style-type: none;">Image 3 : <span id="Image 3" class="customfont" style="color:white">${Image3}</span></li>
				</ul>
	</div>
</div>
<br>
<br>
<label class="customfont" style="color:white;font-size:28px;">Product Description :</label>
<div class="row">
    <div class="col-sm-6">
    			<span class="customfont" style="color:white;font-size:20px;">Description Paragraph :</span>
      			<textarea id="paraText" class="customfont" name="paragraph_text" cols="50" rows="10"></textarea>
      			<br>
      			<input class="btn btn-success customfont mt-3" type="button" value="Add" style="color:white;cursor:pointer;padding:9px;" onclick="addProdPara()">
      			<input id="updateProdDescBtn" class="btn btn-success customfont mt-3" type="button" value="Update" style="color:white;cursor:pointer;padding:9px;" onclick="editProdPara()">
      			
	</div>
	<div class="col-sm-6">
       			
      			<ul id="paraList1" class="list-group mt-4 pt-2">
					  <!--  <li class="list-group-item list-group-item-action"></li>-->
					  	<c:forEach items="${descPara}"  var="ListItem1">
	            					<li class="list-group-item list-group-item-action customfont style-list" id="${ListItem1.key}" onclick="selectProdDescPara('${ListItem1.key}')" ondblclick="delProdDescPara('${ListItem1.key}')">${ListItem1.value}</li>
	        			</c:forEach>
				</ul> 	
      			
	</div>
</div>
<br>
<br>
<div class="row">
    <div class="col-sm-6">
    			<span class="customfont" style="color:white;font-size:20px;">Description List Items :</span>
      			<textarea id="listText" class="customfont" name="paragraph_text" cols="50" rows="10"></textarea>
      			<br>
      			<input class="btn btn-success customfont mt-3" type="button" value="Add" style="color:white;cursor:pointer;padding:9px;" onclick="addProdList()">
      			<input id="updateProdDescListBtn" class="btn btn-success customfont mt-3" type="button" value="Update" style="color:white;cursor:pointer;padding:9px;" onclick="editProdList()">
      			
	</div>
	<div class="col-sm-6">
       		     <ul id="paraList2" class="list-group mt-4 pt-2">
					  <!--  <li class="list-group-item list-group-item-action"></li>-->
					  <c:forEach items="${descList}"  var="ListItem2">
	            					<li class="list-group-item list-group-item-action customfont style-list" id="${ListItem2.key}" onclick="selectProdDescList('${ListItem2.key}')" ondblclick="delProdDescList('${ListItem2.key}')">${ListItem2.value}</li>
	        		  </c:forEach>
				</ul> 	
      			
	</div>
</div>
<br>
<br>
<label class="customfont" style="color:white;font-size:28px;">Product Uses :</label>
<div class="row">
    <div class="col-sm-6">
    			<span class="customfont" style="color:white;font-size:20px;">Uses List Items :</span>
      			<textarea id="usesText" class="customfont" name="paragraph_text" cols="50" rows="10"></textarea>
      			<br>
      			<input class="btn btn-success customfont mt-3" type="button" value="Add" style="color:white;cursor:pointer;padding:9px;" onclick="addProdUsesList()">
      			<input id="usesListBtn" class="btn btn-success customfont mt-3" type="button" value="Update" style="color:white;cursor:pointer;padding:9px;" onclick="editProdUses()">
      			
	</div>
	<div class="col-sm-6">
       		     <ul id="paraList3" class="list-group mt-4 pt-2">
					  <!--  <li class="list-group-item list-group-item-action"></li>-->
					  <c:forEach items="${usesList}"  var="ListItem3">
	            					<li class="list-group-item list-group-item-action customfont style-list" id="${ListItem3.key}" onclick="selectProdUsesList('${ListItem3.key}')" ondblclick="delProdUsesList('${ListItem3.key}')">${ListItem3.value}</li>
	        		  </c:forEach>
				</ul> 	
      			
	</div>
</div>
</div>
