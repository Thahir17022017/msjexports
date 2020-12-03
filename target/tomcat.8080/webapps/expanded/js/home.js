window.onload = function(){
    getUserInfo();
};

function getUserInfo()
{
      console.log(window.performance.navigation.type);
      if( window.performance.navigation.type === 0 )
      {
            var newUser = localStorage.getItem("Old User");
            console.log(" Old User from local storage",newUser);
            if(newUser === null)
            {
                console.log(" he is a new guy ");
                localStorage.setItem("Old User","yes");
                console.log(" local storage is set ");
                var jsonObj={};
                jsonObj.newUser=true;
                console.log(" jsonObj val : "+jsonObj.newUser);
                sendServer("./user","Post",jsonObj);
            }

      }
      
}



function sendServer(url,type,jsonPayload)
{
	var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance 
		
	// xmlhttp.onreadystatechange = function() {
	// 	    if (this.readyState == 4 && this.status == 200) {
	// 	    	try {
	// 	    		var myArr = JSON.parse(this.responseText);
	// 	    		loadErrorMessage(myArr);
	// 	    	} catch(e) {
	// 	    	    //JSON parse error, this is not json (or JSON isn't in your browser)
	// 	    		loadAdminPage(this.responseText);
		    		
	// 	    	}
		        
		       
		    	
	// 	    }
	// 	};
	if(type === "Post")
	{
		xmlhttp.open("POST", url,true);
		xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		xmlhttp.send(JSON.stringify(jsonPayload));
	}
	else
	{
		xmlhttp.open("GET", url,true);
		xmlhttp.send();
	}
	
}


  var swiper = new Swiper('.swiper-container', {
    effect: 'coverflow',
    grabCursor: true,
    centeredSlides: true,
    slidesPerView: 'auto',
    coverflowEffect: {
      rotate: 50,
      stretch: 0,
      depth: 100,
      modifier: 1,
      slideShadows : true,
    },
    autoplay: {
        delay: 2000,
        disableOnInteraction: false,
      },
    pagination: {
      el: '.swiper-pagination',
    },
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
  });


  // When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    document.getElementById("myBtn").style.display = "block";
  } else {
    document.getElementById("myBtn").style.display = "none";
  }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0; // For Safari
  document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
}



function loadItem(item)
{
	console.log("The Item to be loaded ",item);
}

