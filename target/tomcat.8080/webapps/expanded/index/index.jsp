<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="UTF-8">
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
        <!-- favicons for IE-->
        <link rel="shortcut icon" type="image/x-icon" href="icons/favicon.ico" />
       

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

        <link rel="stylesheet" href="css/index.css">

</head>
<body>
        <div class="container-fluid"> 
                <header class="row">
                    <div class="col-sm-2">
                       <img src="icons/logo.png" alt="logo image">
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
          <a class="nav-link text-white  href="#">Home</a>
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
        		<!--<a class="dropdown-item text-white dp-hover" onclick="loadItem('${IndexListItem}')">${IndexListItem}</a> -->
        	</c:forEach>
         <!-- <a class="dropdown-item text-white dp-hover" href="products/products.html">Coir Pith</a>
          <a class="dropdown-item text-white dp-hover" href="products/products.html">Coconut</a>
          <a class="dropdown-item text-white dp-hover" href="products/products.html">Cardamom</a>
          <a class="dropdown-item text-white dp-hover" href="products/products.html">Turmeric</a>
          <a class="dropdown-item text-white dp-hover" href="products/products.html">Pepper</a>
          <a class="dropdown-item text-white dp-hover" href="products/products.html">Nutmeg & Mace</a>
          <a class="dropdown-item text-white dp-hover" href="products/products.html">Clove</a> -->
        </div>
        </li>
        <li class="nav-item dp-hover">
                <a class="nav-link text-white " href="./enquiry">Enquiry</a>
        </li>
        <li class="nav-item dp-hover">
                <a class="nav-link text-white" href="./contact">Contact Us</a>
        </li>    
      </ul>
    </div>  
  </nav>
  
  <div class="bg">
        <div class="swiper-container">
                <div class="swiper-wrapper">
                <div class="swiper-slide">
                      <div>
                        <img src="icons/large.png" width="600px" height="300px" class="moblogoImg" alt="cardamom image">
                      </div>
                      
                  </div>
                  <div class="swiper-slide">
                      <div>
                        <img src="img/home/cocopeat5.png" width="600px" height="300px" alt="cardamom image">
                      </div>
                      <div class="overlay">
                          <p class="overlay-text">Coir Pith</p>
                      </div>
                  </div>
                  <div class="swiper-slide">
                        <div>
                          <img src="img/home/cocopeat3.png" width="600px" height="300px" alt="cardamom image">
                        </div>
                        <div class="overlay">
                            <p class="overlay-text">Coir Pith</p>
                        </div>
                  </div>
                  <div class="swiper-slide">
                        <div>
                          <img src="img/home/coirfibre1.png" width="600px" height="300px" alt="cardamom image">
                        </div>
                        <div class="overlay">
                            <p class="overlay-text">Coir Fibre</p>
                        </div>
                  </div> 
                  <div class="swiper-slide">
                        <div>
                                <img src="img/home/coconut4.png" width="600px" height="300px" alt="cardamom image">
                        </div>
                        <div class="overlay overlay-text">
                                Coconut
                        </div>
                  </div>
                  
                  <div class="swiper-slide">
                       <div>
                            <img src="img/home/cardamom1.png" width="600px" height="300px" alt="cardamom image">
                      </div>
                      <div class="overlay overlay-text">
                            Cardamom
                       </div>
                   </div>
                  <div class="swiper-slide">
                       <div>
                            <img src="img/home/pepper1.png" width="600px" height="300px" alt="cardamom image">
                      </div>
                      <div class="overlay overlay-text">
                            Pepper
                      </div>
                  </div>
                  <div class="swiper-slide">
                      <div>
                            <img src="img/home/clove1.png" width="600px" height="300px" alt="cardamom image">
                      </div>
                      <div class="overlay overlay-text">
                            Clove
                      </div>
                  </div>
                  <div class="swiper-slide">
                      <div>
                            <img src="img/home/nutmug2.png" width="600px" height="300px" alt="cardamom image">
                      </div>
                      <div class="overlay overlay-text">
                            Nutmeg & Mace
                      </div>
                  </div>
                  
                  
                </div>
                <!-- Add Pagination -->
                <div class="swiper-pagination"></div>
                <!-- Add Arrows -->
                <div class="swiper-button-next"></div>
                <div class="swiper-button-prev"></div>
        </div>
       
         
 </div>
 <br>
 <main>
        <div class="container welcome-item">
            <div class="row p-2">
                    <img src="img/welcome2.png" height="20%" width="50%" alt="welcome logo" class="welcome">
               </div>
              <br> 
             <div class="row">
                  <div class="col-sm-12">
                          <p class="paragraph-text text-justify">
                              Our Company "MSJ Exports" is based at India, in the state of Tamilnadu, which is the
                                  southern most part of Indian subcontinent.
                          </p> 
                          <p class="paragraph-text text-justify">
                              Tamilnadu has enriched cultural heritage, varied and superior vegetation are nature's gift to
                              this state.
                          </p> 
                          <p class="paragraph-text text-justify">
                              We are engaged in the trading of Agricultural products, sourcing directly from the places
                              where they are grown. Quality and Trust comes first compared to other parameters in our
                              business......
                          </p>
                          <form action="./about" method="GET">
                                <button type="submit" class="float-right btn btn btn-success read-more-btn shadow-card">Read More</button>
                          </form>
                  </div>
             </div>
             <div class="row">
                 <div class="col-sm-12">
                      <h1 class="heading-text">Certifications</h1>
                 </div>   
             </div>
             <div class="row">
                 <div class="col-sm-6 shadow-card p-2">
                     <img src="img/certifications/coir_board.png" height="100px" width="100%" alt="coir board image" >
                 </div>
                 <div class="col-sm-6 shadow-card p-2">
                      <img src="img/certifications/spice_board.png" height="100px" width="100%" alt="spice board image">
                 </div>
             </div>

         </div>

          
          
  </main>
  <br>
  <br>
  <footer>
        <!-- <div class="parallax"></div> -->
        <div class="container-fluid parallax p-2">
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
   <!-- swiper  js -->
   <script src="js/swiper.min.js"></script>
   <script type="text/javascript" src="js/home.js" async defer></script>
</body>
</html>
