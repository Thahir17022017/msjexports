<%@page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MSJ Exports</title>
        <meta name="keywords" content="coconut, coir pith, nutmeg and mace, cardamom, turmeric, clove, pepper, black pepper, exports, agricultural products, agri products" />
        <meta name="description" content="We are engaged in the trading of Agricultural products, sourcing directly from the places where they are grown. Quality and Trust comes first compared to other parameters in our business" />
        <meta name="Author" content="http://www.MSJExports.com" />
        <meta name="copyright" content="Copyright MSJExports.">
        <meta name="language" content="EN">
        <meta name="robots" content="index, follow">
        <meta name="revisit-after" content="30 days">
        <meta name="document-classification" content="Internet">
        <meta name="document-type" content="Public">
        <meta name="document-rating" content="Safe for Kids">
        <meta name="document-distribution" content="Global">
        <!-- fav../icons for IE-->
        <link rel="shortcut icon" type="image/x-icon" href="icons/favicon.ico" />
        <link rel="shortcut icon" type="image/x-icon" href="icons/favicon.ico">

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- all other icons -->
        <link rel="apple-touch-icon" sizes="57x57" href="icons/apple-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60" href="icons/apple-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72" href="icons/apple-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="icons/apple-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="icons/apple-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="icons/apple-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="icons/apple-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="icons/apple-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180" href="icons/apple-icon-180x180.png">
        <link rel="icon" type="image/png" sizes="192x192"  href="icons/android-icon-192x192.png">
        <link rel="icon" type="image/png" sizes="32x32" href="icons/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96" href="icons/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16" href="icons/favicon-16x16.png">
        <link rel="manifest" href="icons/manifest.json">
        <meta name="msapplication-TileColor" content="#ffffff">
        <meta name="msapplication-TileImage" content="icons/ms-icon-144x144.png">
        <meta name="theme-color" content="#ffffff">

        <!-- Font Awesome -->
        <link rel="stylesheet" href="fontawesome/css/all.min.css">

        <!-- bootstrap 4 links -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

         <!--swiper css -->
        <link rel="stylesheet" href="css/swiper.min.css">

        <link rel="stylesheet" href="css/enquiry.css">

</head>
<body onload="loadMessage()">
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">&times;</span>
    </div>
    <div class="modal-body">
      <p class="textfield-text">We thank you for your valuable enquiry.<br>
      Sooner we will reply to it.<br><span class="textfield-text" style="font-size:24px">Thank you....!</span></p>
      
    </div>
   </div>

</div>
        <div class="container-fluid header-bg"> 
                <header class="row">
                    <div class="col-sm-2">
                        <a href="./index">
                       <img src="icons/logo.png" alt="logo image"></a>
                    </div>
                    <div class="col-sm-8 mt-4">
                           <i class="fas fa-phone" style="color:green"></i>
                           <span class="first-strip"> +91 90809 39033</span> <br>
                           <i class="fas fa-envelope"style="color:orange"></i>
                           <span class="first-strip"> msjexportsindia@gmail.com</span>
                    </div>
                    <div class="col-sm-2">
                        <a href="https://www.facebook.com/MSJ-Exports-377005156365861" target="_blank"><i class="fab fa-facebook-square fa-2x float-right mr-2 social-icons" style="color:#3b5999"></i></a>
                        <a href="https://www.instagram.com/msj_exports/" target="_blank"><i class="fab fa-instagram fa-2x float-right mr-2 social-icons" style="color:#e4405f"></i></a>
                        <a href="https://twitter.com/MSJExports" target="_blank"><i class="fab fa-twitter-square fa-2x float-right mr-2 social-icons" style="color:#55acee"></i></a>
                    </div>       
                </header>
            </div>
            <nav class="navbar navbar-expand-sm nav1-color nav1-shadow">
        
                    <!-- <a class="navbar-brand" href="#">Navbar</a> -->
                    
                 
                    <button class="navbar-toggler dp-hover" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                      <span class="navbar-toggler-icon">
                            <i class="fas fa-bars dp-hover" style="color:white"></i>
                      </span>
                    </button>
                    <div class="collapse navbar-collapse" id="collapsibleNavbar">
                      <ul class="navbar-nav ml-auto">
                        <li class="nav-item dp-hover">
                          <a class="nav-link text-white"  href="./index">Home</a>
                        </li>
                        <li class="nav-item dp-hover">
                          <a class="nav-link text-white" href="./about">About Us</a>
                        </li>
                        
                        <!-- Dropdown -->
                        <li class="nav-item dropdown dp-hover">
                        <a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">
                                Products
                        </a>
                        <div class="dropdown-menu dp-menu">
                                <c:forEach items="${IndexList}"  var="IndexListItem">
                                	<a class="dropdown-item text-white dp-hover" href="./product?value=${IndexListItem}">${IndexListItem}</a>
                                </c:forEach>
                        </div>
                        </li>
                        <li class="nav-item dp-hover">
                                <a class="nav-link text-white " href="#">Enquiry</a>
                        </li>
                        <li class="nav-item dp-hover">
                                <a class="nav-link text-white" href="./contact">Contact Us</a>
                        </li>    
                      </ul>
                    </div>  
            </nav>
            <div class="parallax">
            </div>
            <div class="sec2 sec2-tab sec2-mob">
                    <div class="container shadow-card containerpos">
                            <div class="row">
                                <div class="col-sm-12 mt-4">
                                    <p class="heading-text-p pt-1"> 
                                                <i class="fas fa-bars fa-1x"></i>&nbsp;Enquiry 
                                    </p>
                               </div>
                            </div>
                            <div class="row">
                                    <div class="col-sm-4">
                                            <img style="position:relative;left:10%;top:5%;" src="img/enquiry/telephone-operator.png" width="85%" height="50%" alt="telephone operator image">
                                    </div>
                                    <div class="col-sm-8">
                                                <form action="./sendenquiry" method="POST">
                                                                <div class="form-group">
                                                                				
                                                                                <label class="textfield-text" for="name">Name: *</label>
                                                                                <input type="text" class="form-control" name="name" placeholder="Name" required>
                                                                </div>
                                                                <div class="form-group">
                                                                                <label class="textfield-text" for="email">Email: *</label>
                                                                                <input type="email" class="form-control" name="email" placeholder="Email" required>
                                                                </div>
                                                                <div class="form-group">
                                                                                <label class="textfield-text" for="phone">Phone/Mobile: *</label>
                                                                                <input type="number" class="form-control" name="phone" placeholder="Phone/Mobile" required>
                                                                </div>
                                                                <div class="form-group">
                                                                                <label class="textfield-text" for="country">Country: *</label>
                                                                                <input type="text" class="form-control" name="country" placeholder="Country" required>
                                                                </div>
                                                                <div class="form-group">
                                                                                <label class="textfield-text" for="products">Products: *</label>
                                                                                <input type="text" class="form-control" name="products" placeholder="Products" required>
                                                                </div>
                                                                <div class="form-group">
                                                                                <label class="textfield-text" for="message">Message: *</label>
                                                                                <textarea class="form-control" rows="5" name="message" placeholder="Kindly provide your requirement in detail..." required></textarea>
                                                                                
                                                                </div>
                                                                <div class="form-group">
                                                                				<img src="./captcha"/>
                                                                				<input class="textfield-text" type="text" name="captcha" value="" placeholder="Enter the code here..." required/>
                                                                				
                                                                </div>
                                                                <div>
                                                                                <button type="submit" class="btn btn-success mb-2 textfield-text textfield-width">Submit</button>
                                                                                <button type="reset" class="btn btn-dark mb-2 textfield-text textfield-width">Clear</button>
                                                                </div>
                                                                
                                                          
                                                </form>
                                    </div>        
                            </div>        
                    </div> 
            </div>
            <footer>
                    <!-- <div class="parallax"></div> -->
                    <div class="container-fluid parallax2 p-2">
                        <div class="row">
                            <div class="col-sm-3">
                                    <div class="container">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                    <h6 class="text-white font-weight-bold">About Company</h6>
                                             </div>   
                                        </div>
                                        <div class="row">
                                                <div class="col-sm-12">
                                                        <p class="text-justify text-white">MSJ Exports is an experienced merchant exporter of coconut products and Spices from Tamilnadu - India, exporting finest quality products to our global clients.</p>
                                                 </div>   
                                        </div>    
                                   </div>     
                            </div>
                            <div class="col-sm-3">
                                    <div class="container">
                                            <div class="row">
                                                <div class="col-sm-12">
                                                        <h6 class="text-white font-weight-bold">Why Us</h6>
                                                 </div>   
                                            </div>
                                            <div class="row">
                                                    <div class="col-sm-12">
                                                            <p class="text-justify text-white font-weight-bold"><i class="i right"></i>&nbsp;&nbsp;Wide range of products</p>
                                                     </div>   
                                            </div>
                                            <div class="row">
                                                    <div class="col-sm-12">
                                                           <p class="text-justify text-white font-weight-bold"><i class="i right"></i>&nbsp;&nbsp;Premium Quality</p>
                                                     </div>   
                                            </div>
                                            <div class="row">
                                                    <div class="col-sm-12">
                                                            <p class="text-justify text-white font-weight-bold"><i class="i right"></i>&nbsp;&nbsp;Fair Pricing</p>
                                                     </div>   
                                            </div>
                                            <div class="row">
                                                    <div class="col-sm-12">
                                                            <p class="text-justify text-white font-weight-bold"><i class="i right"></i>&nbsp;&nbsp;Proper Packing</p>
                                                     </div>   
                                            </div>
                                            <div class="row">
                                                    <div class="col-sm-12">
                                                            <p class="text-justify text-white font-weight-bold"><i class="i right"></i>&nbsp;&nbsp;Timely Delivery</p>
                                                     </div>   
                                            </div>     
                                       </div>   
                            </div>
                            <div class="col-sm-3">
                                    <div class="container">
                                            <div class="row">
                                                <div class="col-sm-12">
                                                        <h6 class="text-white font-weight-bold">Membership</h6>
                                                 </div>   
                                            </div>
                                            <div class="row">
                                                    <div class="col-sm-12">
                                                            <img src="img/mem-logo/coir_logo.png" width="100px" height="100px" alt="coir logo">
                                                            <img src="img/mem-logo/spices_logo.png" width="100px" height="100px" alt="spices logo">
                                                     </div>
                                                          
                                            </div>
                                                
                                    </div>  
                            </div>
                            <div class="col-sm-3">
                                    <div class="container">
                                            <div class="row">
                                                <div class="col-sm-12">
                                                        <h6 class="text-white font-weight-bold">Contact Us</h6>
                                                 </div>   
                                            </div>
                                            <div class="row">
		                                        <div class="col-sm-12">
		                                                <p class="text-white font-weight-bold">
		                                                   MahendraKumar.J (Managing Director) <br>
		                                                   msjexportsindia@gmail.com <br>
		                                                   +91 90809 39033<br>
		                                                   
		                                                </p>
		                                         </div>
		                                         <div class="col-sm-12">
		                                                <a class="text-white font-weight-bold" href="#">Factory Unit:</a>
		                                                <p class="text-white"> Aliyar Dam Road, Pollachi, Tamilnadu, India</p>
		                                         </div>
		                                         <div class="col-sm-12">
		                                                <a class="text-white font-weight-bold" href="#">Registered Office:</a>
		                                                <p class="text-white"> 144, Sundarraj Nagar, Subramaniapuram,Trichy – 620020, Tamilnadu, India</p>
		                                         </div>     
                                		   </div>
                                                
                                    </div>  
                            </div>
                                  
                        </div>   
                    </div>
                    <div class="container-fluid text-white copyright">
                        <div class="row">
                            <div class="col-sm-12 mx-auto mt-3">
                                <p class="text-center">© 2019 Copyright:
                                    <a class="text-white" href="#">MSJ Exports. All rights reserved |</a> 
                                    <a class="text-white design-font" target="_blank" href="https://www.google.com/maps/search/?api=1&query=Fz+Systems+Trichy">Powered by Fz Systems,Trichy</a>
                                </p>    
                            </div>
                        </div>        
                            
                            
                    </div>    
            </footer>
            <button onclick="topFunction()" id="myBtn" title="Go to top"><i class="fas fa-angle-double-up fa-2x"></i></button>
                  
               
             <!-- jquery js link -->
           <script type="text/javascript" src="js/jquery-3.1.1.js"></script>
           <!-- popper js link -->
           <script type="text/javascript" src="js/popper-min.js"></script>
           <!-- bootstrap js  -->
           <script type="text/javascript" src="js/bootstrap.min.js"></script>
         
           <script type="text/javascript" src="js/enquiry.js"></script>
</body>
</html>        