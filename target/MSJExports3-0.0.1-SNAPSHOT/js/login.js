function  sendData()
{
	
	var progressBar = document.getElementById("greenprogress");
	progressBar.style.display = "block";
	console.log("progressbar display : ",progressBar);
	
	var progressTrack = document.getElementById("greenprogresstrack");
	progressTrack.style.display = "block";
	console.log("progressTrack display : ",progressTrack);
	
	var userTag = document.getElementById("username");
	var userMsg = document.getElementById("usermsg");
	
	var pwdTag = document.getElementById("password");
	var pwdMsg = document.getElementById("pwdmsg");
	
	var adminMsg = document.getElementById("adminerror");
	var sessionMsg = document.getElementById("sessionexp");
	var logoutMsg = document.getElementById("adminlogout");
	console.log("normal logout var",logoutMsg);
	
	
	
	var user = userTag.value;
	var pwd = pwdTag.value;
	
	console.log("Username :",user);
	console.log("Password :",pwd);
	
	
	progressBar.style.width="10%";
	progressBar.setAttribute("aria-valuenow","10");
	console.log("10% update progressbar : ",progressBar);
	
	
	if(adminMsg.style.visibility === "visible")
	{
		adminMsg.style.visibility="hidden";
	}
	
	if(sessionMsg !== "" && sessionMsg !== null)
	{
		if(sessionMsg.style.visibility === "visible")
		{
			sessionMsg.style.visibility="hidden";
		}
	}
	
	if(logoutMsg !== "" && logoutMsg !== null)
	{
		console.log("code trying to change visibility during normal logout flow");
		if(logoutMsg.style.visibility === "visible")
		{
			logoutMsg.style.visibility="hidden";
		}
	}
	
	
	if(user === "" || user === null)
	{
		userMsg.style.visibility="visible";
		progressBar.style.display = "none";
		progressTrack.style.display = "none";
		progressBar.style.width="0%";
		progressBar.setAttribute("aria-valuenow","0");
	}
	else
	{
		userMsg.style.visibility="hidden";
	}
	
	if(pwd === "" || pwd === null)
	{
		pwdMsg.style.visibility="visible";
		progressBar.style.display = "none";
		progressTrack.style.display = "none";
		progressBar.style.width="0%";
		progressBar.setAttribute("aria-valuenow","0");
	}
	else
	{
		pwdMsg.style.visibility="hidden";
	}
	
	if(user !== "" && pwd !== "" && user !== null && pwd !== null)
	{
		progressBar.style.width="30%";
		progressBar.setAttribute("aria-valuenow","30");
		
		userTag.value="";
		pwdTag.value="";
		
		progressBar.style.width="40%";
		progressBar.setAttribute("aria-valuenow","40");
		
		var payLoad = "{\"user\":\""+user+"\",\"password\":\""+pwd+"\"}";
		progressBar.style.width="50%";
		progressBar.setAttribute("aria-valuenow","50");
		
		var jsonPayload = JSON.parse(payLoad);
		progressBar.style.width="60%";
		progressBar.setAttribute("aria-valuenow","60");
		
		console.log(" json object :"+payLoad);
		progressBar.style.width="70%";
		progressBar.setAttribute("aria-valuenow","70");
		
		console.log(" one json object : "+jsonPayload["user"]);
		progressBar.style.width="80%";
		progressBar.setAttribute("aria-valuenow","80");
		
		sendServer("./login","Post",jsonPayload,progressBar,progressTrack);
		
		
		
	}
	
	
	
	
	
	
	
}

function sendServer(url,type,jsonPayload,progressBar,progressTrack)
{
	var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance 
	progressBar.style.width="81%";
	progressBar.setAttribute("aria-valuenow","81");
	
	xmlhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	try {
		    		var myArr = JSON.parse(this.responseText);
		    		if(myArr["Message"] !== undefined)
		    		{
		    			loadErrorMessage(myArr);
		    		}
		    		if(myArr["ProductName"] !== undefined)
		    		{
		    			loadProductName(myArr);
		    		}
		    		if(myArr["ProductNames"] !== undefined)
		    		{
		    			loadProductNames(myArr);
		    		}
		    		if(myArr["DelProductName"] !== undefined)
		    		{
		    			delProdName(myArr);
		    		}
		    		if(myArr["DelProductNames"] !== undefined)
		    		{
		    			delProdNames(myArr);
		    		}
		    		if(myArr["DelAllProductNames"] !== undefined)
		    		{
		    			delAllProdNames();
		    		}
		    		if(myArr["UpdateProductName"] !== undefined)
		    		{
		    			updateProdName(myArr);
		    		}
		    		if(myArr["paraId"] !== undefined)
		    		{
		    			loadNewPara(myArr);
		    		}
		    		if(myArr["editParaId"] !== undefined)
		    		{
		    			loadEditPara(myArr);
		    		}
		    		if(myArr["deleteParaId"] !== undefined)
		    		{
		    			loadDeletePara(myArr);
		    		}
		    		if(myArr["listId"] !== undefined)
		    		{
		    			loadNewList(myArr);
		    		}
		    		if(myArr["editListId"] !== undefined)
		    		{
		    			loadEditList(myArr);
		    		}
		    		if(myArr["deleteListId"]!== undefined)
		    		{
		    			loadDeleteList(myArr);
		    		}
		    		if(myArr["addUseslistId"] !== undefined)
		    		{
		    			loadNewUsesList(myArr);
		    		}
		    		if(myArr["editUsesListId"] !== undefined)
		    		{
		    			loadEditUses(myArr);
		    		}
		    		if(myArr["deleteUsesListId"] !== undefined)
		    		{
		    			loadDeleteUsesList(myArr);
		    		}	
		    		progressBar.style.width="100%";
		    		progressBar.setAttribute("aria-valuenow","100");
		    		progressBar.style.display = "none";
		    		progressTrack.style.display = "none";
		    		progressBar.style.width="0%";
		    		progressBar.setAttribute("aria-valuenow","0");
		    	} catch(e) {
		    	    //JSON parse error, this is not json (or JSON isn't in your browser)
		    		var decider = this.getResponseHeader("resultfor");
		    		console.log("decider value :",decider);
		    		if(decider === "configure")
		    		{
		    			loadConfProducts(this.responseText);
		    		}
		    		if(decider === "configureDetail")
		    		{
		    			loadConfDetailProducts(this.responseText);
		    		}
		    		if(decider === "" || decider === null)
		    		{
		    			loadAdminPage(this.responseText);
		    		}
		    		
		    		progressBar.style.width="100%";
		    		progressBar.setAttribute("aria-valuenow","100");
		    		progressBar.style.display = "none";
		    		progressTrack.style.display = "none";
		    		progressBar.style.width="0%";
		    		progressBar.setAttribute("aria-valuenow","0");
		    		
		    	}
		        
		       
		    	
		    }
		};
	progressBar.style.width="85%";
	progressBar.setAttribute("aria-valuenow","85");
	
	if(type === "Post")
	{
		xmlhttp.open("POST", url,true);
		
		
		if(jsonPayload instanceof FormData)
		{
			xmlhttp.setRequestHeader("imageType",jsonPayload.get("imageType"));
			xmlhttp.setRequestHeader("productType",jsonPayload.get("productType"));
		}
		else
		{
			xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		}
		
		progressBar.style.width="90%";
		progressBar.setAttribute("aria-valuenow","90");
		
		xmlhttp.send(JSON.stringify(jsonPayload));
	}
	else
	{
		progressBar.style.width="90%";
		progressBar.setAttribute("aria-valuenow","90");
		console.log("GET method jsonPayload",jsonPayload);
		xmlhttp.open("GET", url,true);
		xmlhttp.setRequestHeader("detailType", jsonPayload);
		xmlhttp.send();
	}
	
}

function loadErrorMessage(result)
{
	console.log(" Json Response :",result);
	document.getElementById("adminerror").style.visibility="visible";
	
//	document.getElementById("adminpage").innerHTML = result;
//	document.getElementById("loginpage").style.display="none";
}

function loadAdminPage(result)
{
	document.getElementById("body").innerHTML = result;
	
}

function sendLogout()
{
	var progressBar = document.getElementById("greenprogress");
	progressBar.style.display = "block";
	var progressTrack = document.getElementById("greenprogresstrack");
	progressTrack.style.display = "block";
	
	progressBar.style.width="80%";
	progressBar.setAttribute("aria-valuenow","80");
	
	console.log("Running in Logout");
	sendServer("./logout","Get","",progressBar,progressTrack);
}

function confProducts()
{
	var progressBar = document.getElementById("greenprogress");
	progressBar.style.display = "block";
	var progressTrack = document.getElementById("greenprogresstrack");
	progressTrack.style.display = "block";
	progressBar.style.width="80%";
	progressBar.setAttribute("aria-valuenow","80");
	
	
	
	sendServer("./confproducts","Get","",progressBar,progressTrack);
}

function loadConfProducts(result)
{
	document.getElementById("configure").innerHTML = result;
}

function loadConfDetailProducts(result)
{
	document.getElementById("configure").innerHTML = result;
}

function addProducts()
{
	var progressBar = document.getElementById("greenprogress");
	progressBar.style.display = "block";
	var progressTrack = document.getElementById("greenprogresstrack");
	progressTrack.style.display = "block";
	progressBar.style.width="80%";
	progressBar.setAttribute("aria-valuenow","80");
	
	console.log("im running in addproducts")
	var addProd = document.getElementById("addProd");
	var addProdVal = addProd.value;
	var addprodmsg1 = document.getElementById("addprodmsg1");
	
	if(addprodmsg1.style.visibility === "visible")
	{
		addprodmsg1.style.visibility = "hidden";
	}
	
	if(addprodmsg1.style.visibility === "visible")
	{
		addprodmsg1.style.visibility="hidden";
	}
	
	if(addProdVal === null || addProdVal === "")
	{
		if(addprodmsg1.style.visibility === "hidden")
		{
			addprodmsg1.style.visibility="visible";
			progressBar.style.display = "none";
			progressTrack.style.display = "none";
			progressBar.style.width="0%";
			progressBar.setAttribute("aria-valuenow","0");
		}
	}
	
	if(addProdVal !== null && addProdVal !== "")
	{
		var jsonPayload;
		addProd.value="";
		console.log("Producs to be added",addProdVal);
		if (addProdVal.indexOf(',') > -1) 
		{ 
			console.log("Comma is found"); 
			jsonPayload = addProdVal.split(",");
			console.log("array",jsonPayload);
		}
		else
		{
			console.log("Comma is not found");
			jsonPayload = {};
			jsonPayload.addProduct=addProdVal;
			console.log("strVal",jsonPayload);
			
		}	
		sendServer("./addproducts","Post",jsonPayload,progressBar,progressTrack);
	}	
}

function loadProductName(myArr){
	
	var olTag = document.getElementById("productlist");
	
	var listItem = document.createElement("li");
	listItem.style.color="white";
	listItem.style.cursor="pointer";
	
	listItem.onclick="confIndProducts('"+myArr["ProductName"]+"')";
	
	var node = document.createTextNode(myArr["ProductName"]);
	listItem.appendChild(node);
	
	var att = document.createAttribute("class");
	att.value = "customfont";
	
	var att2 = document.createAttribute("onclick");
	att2.value = "confIndProducts('"+myArr["ProductName"]+"')";
	
	listItem.setAttributeNode(att); 
	listItem.setAttributeNode(att2); 
	
	olTag.appendChild(listItem);
	
}

function loadProductNames(myArr){
	
	var olTag = document.getElementById("productlist");
	var myArr2= myArr["ProductNames"];
	for(i = 0;i < myArr2.length;i++)
	{
		
		
		var listItem = document.createElement("li");
		listItem.style.color="white";
		listItem.style.cursor="pointer";
		
		var node = document.createTextNode(myArr2[i]);
		listItem.appendChild(node);
		
		var att = document.createAttribute("class");
		att.value = "customfont";    
		
		var att2 = document.createAttribute("onclick");
		att2.value = "confIndProducts('"+myArr2[i]+"')";
		
		listItem.setAttributeNode(att);
		listItem.setAttributeNode(att2); 
		
		olTag.appendChild(listItem);
	}
    
}


function delProducts()
{
	var progressBar = document.getElementById("greenprogress");
	progressBar.style.display = "block";
	var progressTrack = document.getElementById("greenprogresstrack");
	progressTrack.style.display = "block";
	progressBar.style.width="80%";
	progressBar.setAttribute("aria-valuenow","80");
	
	console.log("im running in delproducts")
	var delProd = document.getElementById("delProd");
	var delProdVal = delProd.value;
	var addprodmsg2 = document.getElementById("addprodmsg2");
	
	if(addprodmsg2.style.visibility === "visible")
	{
		addprodmsg2.style.visibility = "hidden";
	}
	
	if(addprodmsg2.style.visibility === "visible")
	{
		addprodmsg2.style.visibility="hidden";
	}
	
	if(delProdVal === null || delProdVal === "")
	{
		if(addprodmsg2.style.visibility === "hidden")
		{
			addprodmsg2.style.visibility="visible";
			progressBar.style.display = "none";
			progressTrack.style.display = "none";
			progressBar.style.width="0%";
			progressBar.setAttribute("aria-valuenow","0");
		}
	}
	
	if(delProdVal !== null && delProdVal !== "")
	{
		var jsonPayload;
		delProd.value="";
		console.log("Producs to be deleted",delProdVal);
		if (delProdVal.indexOf(',') > -1) 
		{ 
			console.log("Comma is found"); 
			jsonPayload = delProdVal.split(",");
			console.log("array",jsonPayload);
		}
		else
		{
			console.log("Comma is not found");
			jsonPayload = {};
			jsonPayload.delProduct=delProdVal;
			console.log("strVal",jsonPayload);
			
		}	
		sendServer("./deleteproducts","Post",jsonPayload,progressBar,progressTrack);
	}	
}

function delProdName(myArr)
{
	var myNodeList = document.querySelectorAll("li");
	console.log("Query Selector",myNodeList);
	var olTag = document.getElementById("productlist");
	var i;
	console.log("Nodelist length",myNodeList.length);
	for (i = 0; i < myNodeList.length; i++)
	{
	  console.log("Inside for loop");
	  if(myNodeList[i].innerText === myArr["DelProductName"])
	  {
		  olTag.removeChild(myNodeList[i]);
		  break;
	  }
	}
		

}

function delProdNames(myArr)
{

	var myNodeList = document.querySelectorAll("li");
	console.log("Query Selector",myNodeList);
	var olTag = document.getElementById("productlist");
	var i;
	console.log("Nodelist length",myNodeList.length);
	var delProdsArr = myArr["DelProductNames"];
	console.log("delProdsArr ",delProdsArr);
	console.log("delProdsArr length",delProdsArr.length);
	for(j=0;j<delProdsArr.length;j++)
	{
		console.log("Array value",delProdsArr[j]);
		for(i = 0; i < myNodeList.length; i++)
		{
				console.log("Nodelist value",myNodeList[i].innerText);
				
				if(myNodeList[i].innerText === delProdsArr[j])
				{
					olTag.removeChild(myNodeList[i]);
					
				}
		}
	}
	
	
}


function delAllProdNames()
{
	var myNodeList = document.querySelectorAll("li");
	console.log("Query Selector",myNodeList);
	var olTag = document.getElementById("productlist");
	var i;
	console.log("Nodelist length",myNodeList.length);
	for(i = 0; i < myNodeList.length; i++)
	{
			olTag.removeChild(myNodeList[i]);
	}
	
}

function updateProductName()
{
	var progressBar = document.getElementById("greenprogress");
	progressBar.style.display = "block";
	console.log("progressbar display : ",progressBar);
	
	var progressTrack = document.getElementById("greenprogresstrack");
	progressTrack.style.display = "block";
	console.log("progressTrack display : ",progressTrack);
	
	var fromProdTag = document.getElementById("fromProd");
	var toProdTag = document.getElementById("toProd");
	
	var addprodMsg3 = document.getElementById("addprodmsg3");
	
	var fromProd = fromProdTag.value;
	console.log("fromProd",fromProd);
	var toProd = toProdTag.value;
	console.log("toProd",toProd);
	

	progressBar.style.width="10%";
	progressBar.setAttribute("aria-valuenow","10");
	console.log("10% update progressbar : ",progressBar);
	
	
	if(fromProd === "" || fromProd === null)
	{
		addprodMsg3.style.visibility="visible";
		addprodMsg3.innerText="From Product Name is Required";
		progressBar.style.display = "none";
		progressTrack.style.display = "none";
		progressBar.style.width="0%";
		progressBar.setAttribute("aria-valuenow","0");
	}
	
	
	if(toProd === "" || toProd === null)
	{
		addprodMsg3.style.visibility="visible";
		addprodMsg3.innerText="To Product Name is Required";
		progressBar.style.display = "none";
		progressTrack.style.display = "none";
		progressBar.style.width="0%";
		progressBar.setAttribute("aria-valuenow","0");
	}
	

	if(toProd === "" && fromProd === "")
	{
		addprodMsg3.style.visibility="visible";
		addprodMsg3.innerText="To and From Product Name are Required";
		progressBar.style.display = "none";
		progressTrack.style.display = "none";
		progressBar.style.width="0%";
		progressBar.setAttribute("aria-valuenow","0");
	}
	
	if(toProd !== "" && fromProd !== "")
	{
		addprodMsg3.style.visibility="hidden";
		addprodMsg3.innerText="";
		
		jsonPayload = {};
		jsonPayload.fromProduct=fromProd;
		jsonPayload.toProduct=toProd;
		progressBar.style.width="20%";
		progressBar.setAttribute("aria-valuenow","20");
		sendServer("./updateproduct","Post",jsonPayload,progressBar,progressTrack);
	}
	
	
}

function updateProdName(myArr)
{ 
    var res = myArr["UpdateProductName"];
    var fromProdTag = document.getElementById("fromProd");
	var toProdTag = document.getElementById("toProd");
	fromProdTag.value="";
	toProdTag.value="";
    console.log("Update Res value",res);
    var myNodeList = document.querySelectorAll("li");
	console.log("Query Selector",myNodeList);
	
	for(i = 0; i < myNodeList.length; i++)
	{
	    	if(myNodeList[i].innerText === res[0])
	    	{
	    		myNodeList[i].innerText = res[1];
	    		
	    		break;
	    	}
	}
}

function confIndProducts(prodName)
{
	console.log(" You clicked on product ",prodName);
	var progressBar = document.getElementById("greenprogress");
	progressBar.style.display = "block";
	var progressTrack = document.getElementById("greenprogresstrack");
	progressTrack.style.display = "block";
	progressBar.style.width="80%";
	progressBar.setAttribute("aria-valuenow","80");
	sendServer("./confindproducts","Get",prodName,progressBar,progressTrack);
}

function selectGalleryImage(image)
{
	var galleryImage = document.getElementById("galleryImageDrop");
	galleryImage.innerText = image+" ";
	var iTag = document.createElement("i");
	var att = document.createAttribute("class");
	att.value = "fas fa-caret-down fa-1x";
	iTag.style.color="white";
	iTag.setAttributeNode(att); 
	galleryImage.appendChild(iTag);
	console.log("iTag",iTag);
	
}


function bannerImageUpload()
{
	
	var bannerImage = document.getElementById("bannerImage").files[0];
	console.log("bannerImage",bannerImage);
	if(bannerImage !== undefined)
	{
		var formData = new FormData();
		formData.append("file",bannerImage);
//		formData.append("imageType","bannerImage");
//		formData.append("productType",document.getElementById("productType").getAttribute("name"));
//		document.getElementById("bannerImage").value = null;
		document.getElementById("chooseLbl").innerHTML ="Choose a file";
		uploadBannerImage(formData,"bannerImage",document.getElementById("productType").getAttribute("name"));
	}
	
	
	
}

function uploadBannerImage(formData,imageType1,productType1)
{
	
	var progressBar = document.getElementById("greenprogress");
	progressBar.style.display = "block";
	var progressTrack = document.getElementById("greenprogresstrack");
	progressTrack.style.display = "block";
	progressBar.style.width="80%";
	progressBar.setAttribute("aria-valuenow","80");
	
	
	
	$.ajax({
	       url : './BannerImage',
	       type : 'POST',
	       headers:{
	    	   imageType:imageType1,
	    	   productType:productType1
	       },
	       data : formData,
	       processData: false,  // tell jQuery not to process the data
	       contentType: false,  // tell jQuery not to set contentType
	       success : function(data) {
	    	    progressBar.style.width="100%";
	    		progressBar.setAttribute("aria-valuenow","100");
	    		progressBar.style.display = "none";
	    		progressTrack.style.display = "none";
	    		progressBar.style.width="0%";
	    		progressBar.setAttribute("aria-valuenow","0");
	    		document.getElementById("bannerImgRes").innerText = " "+data["fileName"];
	       },
	       failure : function(data){
	    	    progressBar.style.width="100%";
	    		progressBar.setAttribute("aria-valuenow","100");
	    		progressBar.style.display = "none";
	    		progressTrack.style.display = "none";
	    		progressBar.style.width="0%";
	    		progressBar.setAttribute("aria-valuenow","0");
	    		document.getElementById("bannerImgRes").innerText = " "+data["fileName"];
	    		document.getElementById("bannerImgRes").style.color = "red";
	       }
	});
}


function changeLabel(){
    
	document.getElementById("chooseLbl").innerHTML  = "1 File Selected"
	
}

function changeLabel2(){
    
	document.getElementById("chooseLbl2").innerHTML  = "1 File Selected"
	
}

function  galleryImageUpload()
{
	var  galleryImageLblTag= document.getElementById("chooseLbl2");
	var galleryImageDropTag=document.getElementById("galleryImageDrop");
	
	if((galleryImageLblTag.innerText !== "Choose a file") && (galleryImageDropTag.innerText !== "Image Positions "))
	{
				
		var galleryImage = document.getElementById("galleryImage").files[0];
		console.log("galleryImage",galleryImage);
		
		var formData = new FormData();
		formData.append("file",galleryImage);
		document.getElementById("chooseLbl2").innerHTML ="Choose a file";
		
		uploadGalleryImage(formData,document.getElementById("productType").getAttribute("name"),galleryImageDropTag.innerText,galleryImageDropTag)
		
	}
}

function uploadGalleryImage(formData,productType1,imagePos1,galleryImageDropTag)
{
	
	var progressBar = document.getElementById("greenprogress");
	progressBar.style.display = "block";
	var progressTrack = document.getElementById("greenprogresstrack");
	progressTrack.style.display = "block";
	progressBar.style.width="80%";
	progressBar.setAttribute("aria-valuenow","80");
	
	
	
	$.ajax({
	       url : './GalleryImage',
	       type : 'POST',
	       headers:{
	    	   imagePos:imagePos1,
	    	   productType:productType1
	       },
	       data : formData,
	       processData: false,  // tell jQuery not to process the data
	       contentType: false,  // tell jQuery not to set contentType
	       success : function(data) {
	    	    progressBar.style.width="100%";
	    		progressBar.setAttribute("aria-valuenow","100");
	    		progressBar.style.display = "none";
	    		progressTrack.style.display = "none";
	    		progressBar.style.width="0%";
	    		progressBar.setAttribute("aria-valuenow","0");
	    		if(data["ImagePosition"]==="Image 1")
	    		{
	    			document.getElementById("Image 1").innerText = " "+data["fileName"];
	    		}
	    		if(data["ImagePosition"]==="Image 2")
	    		{
	    			document.getElementById("Image 2").innerText = " "+data["fileName"];
	    		}
	    		if(data["ImagePosition"]==="Image 3")
	    		{
	    			document.getElementById("Image 3").innerText = " "+data["fileName"];
	    		}
	    		
	    		galleryImageDropTag.innerHTML = "Image Positions ";
	    		var iTag = document.createElement("i");
	    		var att = document.createAttribute("class");
	    		att.value = "fas fa-caret-down fa-1x";
	    		iTag.style.color="white";
	    		iTag.setAttributeNode(att); 
	    		galleryImageDropTag.appendChild(iTag);
	    		console.log("iTag",iTag);
	    		
	       },
	       failure : function(data){
	    	    progressBar.style.width="100%";
	    		progressBar.setAttribute("aria-valuenow","100");
	    		progressBar.style.display = "none";
	    		progressTrack.style.display = "none";
	    		progressBar.style.width="0%";
	    		progressBar.setAttribute("aria-valuenow","0");
	    		if(data["ImagePosition"]==="Image 1")
	    		{
	    			document.getElementById("Image 1").innerText = " "+data["fileName"];
	    			document.getElementById("Image 1").style.color="red";
	    		}
	    		if(data["ImagePosition"]==="Image 2")
	    		{
	    			document.getElementById("Image 2").innerText = " "+data["fileName"];
	    			document.getElementById("Image 1").style.color="red";
	    		}
	    		if(data["ImagePosition"]==="Image 3")
	    		{
	    			document.getElementById("Image 3").innerText = " "+data["fileName"];
	    			document.getElementById("Image 1").style.color="red";
	    		}
	    		
	    		galleryImageDropTag.innerHTML = "Image Positions ";
	    		var iTag = document.createElement("i");
	    		var att = document.createAttribute("class");
	    		att.value = "fas fa-caret-down fa-1x";
	    		iTag.style.color="white";
	    		iTag.setAttributeNode(att); 
	    		galleryImageDropTag.appendChild(iTag);
	    		console.log("iTag",iTag);
	       }
	});
}
    
function addProdPara()
{
	var paraText = document.getElementById("paraText").value;
	var prodName = document.getElementById("productType").getAttribute("name");
	console.log("paraTextTag",paraText);
	if(paraText !== "")
	{
		console.log("value of paraTextTag",paraText);
		console.log("value of prodName",prodName);
		
		var progressBar = document.getElementById("greenprogress");
		progressBar.style.display = "block";
		var progressTrack = document.getElementById("greenprogresstrack");
		progressTrack.style.display = "block";
		
		progressBar.style.width="80%";
		progressBar.setAttribute("aria-valuenow","80");
		
		var jsonPayLoad = {};
		jsonPayLoad.addParaValue = paraText;
		jsonPayLoad.productName = prodName;
		console.log(" add para json payload",jsonPayLoad);
		
		sendServer("./AddProdDescPara","Post",jsonPayLoad,progressBar,progressTrack);
	}
}

function loadNewPara(myArr)
{
	var paraId = myArr["paraId"];
	console.log("paraId value",paraId);
	var paraText = myArr["paraText"];
	console.log("paraText value",paraText);
	var parentList1 = document.getElementById("paraList1");
	
	var liTag = document.createElement("li");
	var att = document.createAttribute("class");
	att.value = "list-group-item list-group-item-action customfont style-list";
	
	var att2 = document.createAttribute("id");
	att2.value = paraId;
	
	var att3 = document.createAttribute("onclick");
	att3.value = "selectProdDescPara('"+paraId+"')";
	
	var att4 = document.createAttribute("ondblclick");
	att4.value = "delProdDescPara('"+paraId+"')";
	
	liTag.setAttributeNode(att); 
	liTag.setAttributeNode(att2);
	liTag.setAttributeNode(att3);
	liTag.setAttributeNode(att4);
	liTag.innerText = paraText;

	
	parentList1.appendChild(liTag);
	
		
		
	document.getElementById("paraText").value="";
	
}


function selectProdDescPara(selectedId)
{
	console.log("selected list value "+selectedId);
	document.getElementById("updateProdDescBtn").name=selectedId;
	document.getElementById("paraText").value = document.getElementById(selectedId).innerText;
}


function delProdDescPara(selectedId)
{
	console.log("deleted list value "+selectedId);
	var parentList1 = document.getElementById("paraList1");
	var childNodes = parentList1.childNodes;
	for(i=0;i<childNodes.length;i++)
	{
		if(childNodes[i].id === selectedId)
		{
			
			console.log("Text to be deleted",childNodes[i].innerText);
			var progressBar = document.getElementById("greenprogress");
			progressBar.style.display = "block";
			var progressTrack = document.getElementById("greenprogresstrack");
			progressTrack.style.display = "block";
			
			progressBar.style.width="80%";
			progressBar.setAttribute("aria-valuenow","80");
			
			var jsonPayLoad = {};
			jsonPayLoad.deleteParaValue = childNodes[i].innerText;
			jsonPayLoad.deleteParaId = selectedId;
			sendServer("./DeleteProdDescPara","Post",jsonPayLoad,progressBar,progressTrack);
			break;
		}
	}
}
function loadDeletePara(myArr)
{
	var parentList1 = document.getElementById("paraList1");
	var childNodes = parentList1.childNodes;
	for(i=0;i<childNodes.length;i++)
	{
		if(childNodes[i].id === myArr["deleteParaId"])
		{
			parentList1.removeChild(childNodes[i]);
			break;
		}
	}
	document.getElementById("paraText").value="";
}
function editProdPara()
{
	var paraText = document.getElementById("paraText").value;
	var paraId = document.getElementById("updateProdDescBtn").name;
	
	console.log("editProdPara paraId",paraId);
	console.log("editProdPara paraText",paraText);
	if(paraId !== "" && paraText !== "")
	{
		console.log("value of editProdPara paraId",paraId);
		console.log("value of editProdPara paraText",paraText);
		var progressBar = document.getElementById("greenprogress");
		progressBar.style.display = "block";
		var progressTrack = document.getElementById("greenprogresstrack");
		progressTrack.style.display = "block";
		
		progressBar.style.width="80%";
		progressBar.setAttribute("aria-valuenow","80");
		
		var jsonPayLoad = {};
		
		jsonPayLoad.editParaValue = paraText;
		jsonPayLoad.editParaId = paraId;
		console.log(" edit para json payload",jsonPayLoad);
		
		sendServer("./EditProdDescPara","Post",jsonPayLoad,progressBar,progressTrack);
	}
}

function loadEditPara(myArr)
{
	var parentList1 = document.getElementById("paraList1");
	var childNodes = parentList1.childNodes;
	for(i=0;i<childNodes.length;i++)
	{
		if(childNodes[i].id === myArr["editParaId"])
		{
			childNodes[i].innerText = myArr["editParaText"];
			break;
		}
	}
	document.getElementById("paraText").value="";

}

// add list items in prod desc section

function addProdList()
{
	var listText = document.getElementById("listText").value;
	var prodName = document.getElementById("productType").getAttribute("name");
	
	if(listText !== "")
	{
		console.log("value of listText",listText);
		console.log("value of prodName",prodName);
		
		var progressBar = document.getElementById("greenprogress");
		progressBar.style.display = "block";
		var progressTrack = document.getElementById("greenprogresstrack");
		progressTrack.style.display = "block";
		
		progressBar.style.width="80%";
		progressBar.setAttribute("aria-valuenow","80");
		
		var jsonPayLoad = {};
		jsonPayLoad.addListValue = listText;
		jsonPayLoad.productName = prodName;
		console.log(" add list json payload",jsonPayLoad);
		
		sendServer("./AddProdDescList","Post",jsonPayLoad,progressBar,progressTrack);
	}
}

function loadNewList(myArr)
{
	var listId = myArr["listId"];
	console.log("listId value",listId);
	var listText = myArr["listText"];
	console.log("listText value",listText);
	var parentList1 = document.getElementById("paraList2");
	
	var liTag = document.createElement("li");
	var att = document.createAttribute("class");
	att.value = "list-group-item list-group-item-action customfont style-list";
	
	var att2 = document.createAttribute("id");
	att2.value = listId;
	
	var att3 = document.createAttribute("onclick");
	att3.value = "selectProdDescList('"+listId+"')";
	
	var att4 = document.createAttribute("ondblclick");
	att4.value = "delProdDescList('"+listId+"')";
	
	liTag.setAttributeNode(att); 
	liTag.setAttributeNode(att2);
	liTag.setAttributeNode(att3);
	liTag.setAttributeNode(att4);
	liTag.innerText = listText;

	
	parentList1.appendChild(liTag);
	
		
		
	document.getElementById("listText").value="";
	
}

//edit list items in prod desc section

function editProdList()
{
	var listText = document.getElementById("listText").value;
	var listId = document.getElementById("updateProdDescListBtn").name;
	
	console.log("editProdPara listId",listId);
	console.log("editProdPara listText",listText);
	if(listId !== "" && listText !== "")
	{
		console.log("value of editProdPara paraId",listId);
		console.log("value of editProdPara paraText",listText);
		var progressBar = document.getElementById("greenprogress");
		progressBar.style.display = "block";
		var progressTrack = document.getElementById("greenprogresstrack");
		progressTrack.style.display = "block";
		
		progressBar.style.width="80%";
		progressBar.setAttribute("aria-valuenow","80");
		
		var jsonPayLoad = {};
		
		jsonPayLoad.editListValue = listText;
		jsonPayLoad.editListId = listId;
		console.log(" edit list json payload",jsonPayLoad);
		
		sendServer("./EditProdDescList","Post",jsonPayLoad,progressBar,progressTrack);
	}
}

function loadEditList(myArr)
{
	var parentList2 = document.getElementById("paraList2");
	var childNodes = parentList2.childNodes;
	for(i=0;i<childNodes.length;i++)
	{
		if(childNodes[i].id === myArr["editListId"])
		{
			childNodes[i].innerText = myArr["editListValue"];
			break;
		}
	}
	document.getElementById("listText").value="";

}

function selectProdDescList(selectedId)
{
	console.log("selected list value "+selectedId);
	document.getElementById("updateProdDescListBtn").name=selectedId;
	var parentList2 = document.getElementById("paraList2");
	var childNodes = parentList2.childNodes;
	for(i=0;i<childNodes.length;i++)
	{
		if(childNodes[i].id === selectedId)
		{
			document.getElementById("listText").value = childNodes[i].innerText;
			break;
		}
	}	
}

//delete list item in prod desc section

function delProdDescList(selectedId)
{
	console.log("deleted list value "+selectedId);
	var parentList2 = document.getElementById("paraList2");
	var childNodes = parentList2.childNodes;
	for(i=0;i<childNodes.length;i++)
	{
		if(childNodes[i].id === selectedId)
		{
			
			console.log("Text to be deleted",childNodes[i].innerText);
			var progressBar = document.getElementById("greenprogress");
			progressBar.style.display = "block";
			var progressTrack = document.getElementById("greenprogresstrack");
			progressTrack.style.display = "block";
			
			progressBar.style.width="80%";
			progressBar.setAttribute("aria-valuenow","80");
			
			var jsonPayLoad = {};
			jsonPayLoad.deleteListValue = childNodes[i].innerText;
			jsonPayLoad.deleteListId = selectedId;
			sendServer("./DeleteProdDescList","Post",jsonPayLoad,progressBar,progressTrack);
			break;
		}
	}
}
function loadDeleteList(myArr)
{
	var paraList2 = document.getElementById("paraList2");
	var childNodes = paraList2.childNodes;
	for(i=0;i<childNodes.length;i++)
	{
		if(childNodes[i].id === myArr["deleteListId"])
		{
			paraList2.removeChild(childNodes[i]);
			break;
		}
	}
	document.getElementById("listText").value="";
}



//add list items in prod uses section

function addProdUsesList()
{
	var usesText = document.getElementById("usesText").value;
	var prodName = document.getElementById("productType").getAttribute("name");
	
	if(usesText !== "")
	{
		console.log("value of usesText",usesText);
		console.log("value of prodName",prodName);
		
		var progressBar = document.getElementById("greenprogress");
		progressBar.style.display = "block";
		var progressTrack = document.getElementById("greenprogresstrack");
		progressTrack.style.display = "block";
		
		progressBar.style.width="80%";
		progressBar.setAttribute("aria-valuenow","80");
		
		var jsonPayLoad = {};
		jsonPayLoad.addUsesListValue = usesText;
		jsonPayLoad.productName = prodName;
		console.log(" add Uses list json payload",jsonPayLoad);
		
		sendServer("./AddProdUsesList","Post",jsonPayLoad,progressBar,progressTrack);
	}
}

function loadNewUsesList(myArr)
{
	var addUseslistId = myArr["addUseslistId"];
	console.log("listId value",addUseslistId);
	var addUseslistText = myArr["addUseslistText"];
	console.log("addUseslistText value",addUseslistText);
	var paraList3 = document.getElementById("paraList3");
	
	var liTag = document.createElement("li");
	var att = document.createAttribute("class");
	att.value = "list-group-item list-group-item-action customfont style-list";
	
	var att2 = document.createAttribute("id");
	att2.value = addUseslistId;
	
	var att3 = document.createAttribute("onclick");
	att3.value = "selectProdUsesList('"+addUseslistId+"')";
	
	var att4 = document.createAttribute("ondblclick");
	att4.value = "delProdUsesList('"+addUseslistId+"')";
	
	liTag.setAttributeNode(att); 
	liTag.setAttributeNode(att2);
	liTag.setAttributeNode(att3);
	liTag.setAttributeNode(att4);
	liTag.innerText = addUseslistText;

	paraList3.appendChild(liTag);
	
		
	document.getElementById("usesText").value="";
	
}

function selectProdUsesList(selectedId)
{
	console.log("selected list value "+selectedId);
	document.getElementById("usesListBtn").name=selectedId;
	var paraList3 = document.getElementById("paraList3");
	var childNodes = paraList3.childNodes;
	for(i=0;i<childNodes.length;i++)
	{
		if(childNodes[i].id === selectedId)
		{
			document.getElementById("usesText").value = childNodes[i].innerText;
			break;
		}
	}	
}

//edit list items in prod uses section

function editProdUses()
{
	var listText = document.getElementById("usesText").value;
	var listId = document.getElementById("usesListBtn").name;
	
	console.log("editProdUses listId",listId);
	console.log("editProdUses listText",listText);
	if(listId !== "" && listText !== "")
	{
		console.log("value of editProduses listId",listId);
		console.log("value of editProduses listText",listText);
		var progressBar = document.getElementById("greenprogress");
		progressBar.style.display = "block";
		var progressTrack = document.getElementById("greenprogresstrack");
		progressTrack.style.display = "block";
		
		progressBar.style.width="80%";
		progressBar.setAttribute("aria-valuenow","80");
		
		var jsonPayLoad = {};
		
		jsonPayLoad.editListValue = listText;
		jsonPayLoad.editListId = listId;
		console.log(" edit list json payload",jsonPayLoad);
		
		sendServer("./EditProdUsesList","Post",jsonPayLoad,progressBar,progressTrack);
	}
}

function loadEditUses(myArr)
{
	var parentList3 = document.getElementById("paraList3");
	var childNodes = parentList3.childNodes;
	for(i=0;i<childNodes.length;i++)
	{
		if(childNodes[i].id === myArr["editUsesListId"])
		{
			childNodes[i].innerText = myArr["editUsesListValue"];
			break;
		}
	}
	document.getElementById("usesText").value="";

}

//delete list item in prod desc section

function delProdUsesList(selectedId)
{
	console.log("deleted list value "+selectedId);
	var paraList3 = document.getElementById("paraList3");
	var childNodes = paraList3.childNodes;
	for(i=0;i<childNodes.length;i++)
	{
		if(childNodes[i].id === selectedId)
		{
			
			console.log("Text to be deleted",childNodes[i].innerText);
			var progressBar = document.getElementById("greenprogress");
			progressBar.style.display = "block";
			var progressTrack = document.getElementById("greenprogresstrack");
			progressTrack.style.display = "block";
			
			progressBar.style.width="80%";
			progressBar.setAttribute("aria-valuenow","80");
			
			var jsonPayLoad = {};
			jsonPayLoad.deleteUsesListValue = childNodes[i].innerText;
			jsonPayLoad.deleteUsesListId = selectedId;
			sendServer("./DeleteProdUsesList","Post",jsonPayLoad,progressBar,progressTrack);
			break;
		}
	}
}
function loadDeleteUsesList(myArr)
{
	var paraList3 = document.getElementById("paraList3");
	var childNodes = paraList3.childNodes;
	for(i=0;i<childNodes.length;i++)
	{
		if(childNodes[i].id === myArr["deleteUsesListId"])
		{
			paraList3.removeChild(childNodes[i]);
			break;
		}
	}
	document.getElementById("usesText").value="";
}
