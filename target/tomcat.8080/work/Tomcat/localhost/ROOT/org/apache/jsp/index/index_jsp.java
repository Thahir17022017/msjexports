/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.39
 * Generated at: 2019-02-08 09:48:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.index;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1538217528000L));
    _jspx_dependants.put("jar:file:/C:/Users/sheriff/Desktop/RestApi/MSJExports3/target/tomcat.8080/webapps/expanded/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153365282000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\r\n");
      out.write("        <title>MSJ Exports</title>\r\n");
      out.write("        <meta name=\"keywords\" content=\"coconut, coir pith, nutmeg and mace, cardamom, turmeric, clove, pepper, black pepper, exports, agricultural products, agri products\" />\r\n");
      out.write("        <meta name=\"description\" content=\"We are engaged in the trading of Agricultural products, sourcing directly from the places where they are grown. Quality and Trust comes first compared to other parameters in our business\" />\r\n");
      out.write("        <meta name=\"Author\" content=\"http://www.MSJExports.com\" />\r\n");
      out.write("        <meta name=\"copyright\" content=\"Copyright MSJExports.\">\r\n");
      out.write("        <meta name=\"language\" content=\"EN\">\r\n");
      out.write("        <meta name=\"robots\" content=\"index, follow\">\r\n");
      out.write("        <meta name=\"revisit-after\" content=\"30 days\">\r\n");
      out.write("        <meta name=\"document-classification\" content=\"Internet\">\r\n");
      out.write("        <meta name=\"document-type\" content=\"Public\">\r\n");
      out.write("        <meta name=\"document-rating\" content=\"Safe for Kids\">\r\n");
      out.write("        <meta name=\"document-distribution\" content=\"Global\">\r\n");
      out.write("        <!-- favicons for IE-->\r\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"icons/favicon.ico\" />\r\n");
      out.write("       \r\n");
      out.write("\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("        <!-- all other icons -->\r\n");
      out.write("        <link rel=\"apple-touch-icon\" sizes=\"57x57\" href=\"icons/apple-icon-57x57.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" sizes=\"60x60\" href=\"icons/apple-icon-60x60.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"icons/apple-icon-72x72.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"icons/apple-icon-76x76.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"icons/apple-icon-114x114.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" sizes=\"120x120\" href=\"icons/apple-icon-120x120.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" sizes=\"144x144\" href=\"icons/apple-icon-144x144.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" sizes=\"152x152\" href=\"icons/apple-icon-152x152.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"icons/apple-icon-180x180.png\">\r\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" sizes=\"192x192\"  href=\"icons/android-icon-192x192.png\">\r\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"icons/favicon-32x32.png\">\r\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"icons/favicon-96x96.png\">\r\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"icons/favicon-16x16.png\">\r\n");
      out.write("        <link rel=\"manifest\" href=\"icons/manifest.json\">\r\n");
      out.write("        <meta name=\"msapplication-TileColor\" content=\"#ffffff\">\r\n");
      out.write("        <meta name=\"msapplication-TileImage\" content=\"icons/ms-icon-144x144.png\">\r\n");
      out.write("        <meta name=\"theme-color\" content=\"#ffffff\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Font Awesome -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"fontawesome/css/all.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- bootstrap 4 links -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("         <!--swiper css -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/swiper.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/index.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("        <div class=\"container-fluid\"> \r\n");
      out.write("                <header class=\"row\">\r\n");
      out.write("                    <div class=\"col-sm-2\">\r\n");
      out.write("                       <img src=\"icons/logo.png\" alt=\"logo image\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-sm-8 mt-4\">\r\n");
      out.write("                           <i class=\"fas fa-phone\" style=\"color:green\"></i>\r\n");
      out.write("                           <span class=\"first-strip\"> +91 90809 39033</span> <br>\r\n");
      out.write("                           <i class=\"fas fa-envelope\"style=\"color:orange\"></i>\r\n");
      out.write("                           <span class=\"first-strip\"> msjexportsindia@gmail.com</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-sm-2\">\r\n");
      out.write("                           <a href=\"https://www.facebook.com/MSJ-Exports-377005156365861\" target=\"_blank\"><i class=\"fab fa-facebook-square fa-2x float-right mr-2 social-icons\" style=\"color:#3b5999\"></i></a>\r\n");
      out.write("                           <a href=\"https://www.instagram.com/msj_exports/\" target=\"_blank\"><i class=\"fab fa-instagram fa-2x float-right mr-2 social-icons\" style=\"color:#e4405f\"></i></a>\r\n");
      out.write("                           <a href=\"https://twitter.com/MSJExports\" target=\"_blank\"><i class=\"fab fa-twitter-square fa-2x float-right mr-2 social-icons\" style=\"color:#55acee\"></i></a>\r\n");
      out.write("                    </div>       \r\n");
      out.write("                       \r\n");
      out.write("                       \r\n");
      out.write("                               \r\n");
      out.write("                </header>\r\n");
      out.write("        </div>\r\n");
      out.write("  <nav class=\"navbar navbar-expand-sm nav1-color nav1-shadow\">\r\n");
      out.write("\r\n");
      out.write("    <!-- <a class=\"navbar-brand\" href=\"#\">Navbar</a> -->\r\n");
      out.write("    \r\n");
      out.write(" \r\n");
      out.write("    <button class=\"navbar-toggler dp-hover\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\">\r\n");
      out.write("      <span class=\"navbar-toggler-icon\">\r\n");
      out.write("            <i class=\"fas fa-bars dp-hover\" style=\"color:white\"></i>\r\n");
      out.write("      </span>\r\n");
      out.write("    </button>\r\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\r\n");
      out.write("      <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("        <li class=\"nav-item dp-hover\">\r\n");
      out.write("          <a class=\"nav-link text-white  href=\"#\">Home</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item dp-hover\">\r\n");
      out.write("          <a class=\"nav-link text-white\" href=\"./about\">About Us</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        <!-- Dropdown -->\r\n");
      out.write("        <li class=\"nav-item dropdown dp-hover\">\r\n");
      out.write("        <a class=\"nav-link dropdown-toggle text-white\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">\r\n");
      out.write("                Products\r\n");
      out.write("        </a>\r\n");
      out.write("        <div class=\"dropdown-menu dp-menu\">\r\n");
      out.write("        \t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("         <!-- <a class=\"dropdown-item text-white dp-hover\" href=\"products/products.html\">Coir Pith</a>\r\n");
      out.write("          <a class=\"dropdown-item text-white dp-hover\" href=\"products/products.html\">Coconut</a>\r\n");
      out.write("          <a class=\"dropdown-item text-white dp-hover\" href=\"products/products.html\">Cardamom</a>\r\n");
      out.write("          <a class=\"dropdown-item text-white dp-hover\" href=\"products/products.html\">Turmeric</a>\r\n");
      out.write("          <a class=\"dropdown-item text-white dp-hover\" href=\"products/products.html\">Pepper</a>\r\n");
      out.write("          <a class=\"dropdown-item text-white dp-hover\" href=\"products/products.html\">Nutmeg & Mace</a>\r\n");
      out.write("          <a class=\"dropdown-item text-white dp-hover\" href=\"products/products.html\">Clove</a> -->\r\n");
      out.write("        </div>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item dp-hover\">\r\n");
      out.write("                <a class=\"nav-link text-white \" href=\"./enquiry\">Enquiry</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item dp-hover\">\r\n");
      out.write("                <a class=\"nav-link text-white\" href=\"./contact\">Contact Us</a>\r\n");
      out.write("        </li>    \r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>  \r\n");
      out.write("  </nav>\r\n");
      out.write("  \r\n");
      out.write("  <div class=\"bg\">\r\n");
      out.write("        <div class=\"swiper-container\">\r\n");
      out.write("                <div class=\"swiper-wrapper\">\r\n");
      out.write("                <div class=\"swiper-slide\">\r\n");
      out.write("                      <div>\r\n");
      out.write("                        <img src=\"icons/large.png\" width=\"600px\" height=\"300px\" class=\"moblogoImg\" alt=\"cardamom image\">\r\n");
      out.write("                      </div>\r\n");
      out.write("                      \r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"swiper-slide\">\r\n");
      out.write("                      <div>\r\n");
      out.write("                        <img src=\"img/home/cocopeat5.png\" width=\"600px\" height=\"300px\" alt=\"cardamom image\">\r\n");
      out.write("                      </div>\r\n");
      out.write("                      <div class=\"overlay\">\r\n");
      out.write("                          <p class=\"overlay-text\">Coir Pith</p>\r\n");
      out.write("                      </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"swiper-slide\">\r\n");
      out.write("                        <div>\r\n");
      out.write("                          <img src=\"img/home/cocopeat3.png\" width=\"600px\" height=\"300px\" alt=\"cardamom image\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"overlay\">\r\n");
      out.write("                            <p class=\"overlay-text\">Coir Pith</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"swiper-slide\">\r\n");
      out.write("                        <div>\r\n");
      out.write("                          <img src=\"img/home/coirfibre1.png\" width=\"600px\" height=\"300px\" alt=\"cardamom image\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"overlay\">\r\n");
      out.write("                            <p class=\"overlay-text\">Coir Fibre</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                  </div> \r\n");
      out.write("                  <div class=\"swiper-slide\">\r\n");
      out.write("                        <div>\r\n");
      out.write("                                <img src=\"img/home/coconut4.png\" width=\"600px\" height=\"300px\" alt=\"cardamom image\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"overlay overlay-text\">\r\n");
      out.write("                                Coconut\r\n");
      out.write("                        </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  \r\n");
      out.write("                  <div class=\"swiper-slide\">\r\n");
      out.write("                       <div>\r\n");
      out.write("                            <img src=\"img/home/cardamom1.png\" width=\"600px\" height=\"300px\" alt=\"cardamom image\">\r\n");
      out.write("                      </div>\r\n");
      out.write("                      <div class=\"overlay overlay-text\">\r\n");
      out.write("                            Cardamom\r\n");
      out.write("                       </div>\r\n");
      out.write("                   </div>\r\n");
      out.write("                  <div class=\"swiper-slide\">\r\n");
      out.write("                       <div>\r\n");
      out.write("                            <img src=\"img/home/pepper1.png\" width=\"600px\" height=\"300px\" alt=\"cardamom image\">\r\n");
      out.write("                      </div>\r\n");
      out.write("                      <div class=\"overlay overlay-text\">\r\n");
      out.write("                            Pepper\r\n");
      out.write("                      </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"swiper-slide\">\r\n");
      out.write("                      <div>\r\n");
      out.write("                            <img src=\"img/home/clove1.png\" width=\"600px\" height=\"300px\" alt=\"cardamom image\">\r\n");
      out.write("                      </div>\r\n");
      out.write("                      <div class=\"overlay overlay-text\">\r\n");
      out.write("                            Clove\r\n");
      out.write("                      </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"swiper-slide\">\r\n");
      out.write("                      <div>\r\n");
      out.write("                            <img src=\"img/home/nutmug2.png\" width=\"600px\" height=\"300px\" alt=\"cardamom image\">\r\n");
      out.write("                      </div>\r\n");
      out.write("                      <div class=\"overlay overlay-text\">\r\n");
      out.write("                            Nutmeg & Mace\r\n");
      out.write("                      </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  \r\n");
      out.write("                  \r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- Add Pagination -->\r\n");
      out.write("                <div class=\"swiper-pagination\"></div>\r\n");
      out.write("                <!-- Add Arrows -->\r\n");
      out.write("                <div class=\"swiper-button-next\"></div>\r\n");
      out.write("                <div class=\"swiper-button-prev\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("       \r\n");
      out.write("         \r\n");
      out.write(" </div>\r\n");
      out.write(" <br>\r\n");
      out.write(" <main>\r\n");
      out.write("        <div class=\"container welcome-item\">\r\n");
      out.write("            <div class=\"row p-2\">\r\n");
      out.write("                    <img src=\"img/welcome2.png\" height=\"20%\" width=\"50%\" alt=\"welcome logo\" class=\"welcome\">\r\n");
      out.write("               </div>\r\n");
      out.write("              <br> \r\n");
      out.write("             <div class=\"row\">\r\n");
      out.write("                  <div class=\"col-sm-12\">\r\n");
      out.write("                          <p class=\"paragraph-text text-justify\">\r\n");
      out.write("                              Our Company \"MSJ Exports\" is based at India, in the state of Tamilnadu, which is the\r\n");
      out.write("                                  southern most part of Indian subcontinent.\r\n");
      out.write("                          </p> \r\n");
      out.write("                          <p class=\"paragraph-text text-justify\">\r\n");
      out.write("                              Tamilnadu has enriched cultural heritage, varied and superior vegetation are nature's gift to\r\n");
      out.write("                              this state.\r\n");
      out.write("                          </p> \r\n");
      out.write("                          <p class=\"paragraph-text text-justify\">\r\n");
      out.write("                              We are engaged in the trading of Agricultural products, sourcing directly from the places\r\n");
      out.write("                              where they are grown. Quality and Trust comes first compared to other parameters in our\r\n");
      out.write("                              business......\r\n");
      out.write("                          </p>\r\n");
      out.write("                          <form action=\"./about\" method=\"GET\">\r\n");
      out.write("                                <button type=\"submit\" class=\"float-right btn btn btn-success read-more-btn shadow-card\">Read More</button>\r\n");
      out.write("                          </form>\r\n");
      out.write("                  </div>\r\n");
      out.write("             </div>\r\n");
      out.write("             <div class=\"row\">\r\n");
      out.write("                 <div class=\"col-sm-12\">\r\n");
      out.write("                      <h1 class=\"heading-text\">Certifications</h1>\r\n");
      out.write("                 </div>   \r\n");
      out.write("             </div>\r\n");
      out.write("             <div class=\"row\">\r\n");
      out.write("                 <div class=\"col-sm-6 shadow-card p-2\">\r\n");
      out.write("                     <img src=\"img/certifications/coir_board.png\" height=\"100px\" width=\"100%\" alt=\"coir board image\" >\r\n");
      out.write("                 </div>\r\n");
      out.write("                 <div class=\"col-sm-6 shadow-card p-2\">\r\n");
      out.write("                      <img src=\"img/certifications/spice_board.png\" height=\"100px\" width=\"100%\" alt=\"spice board image\">\r\n");
      out.write("                 </div>\r\n");
      out.write("             </div>\r\n");
      out.write("\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("          \r\n");
      out.write("          \r\n");
      out.write("  </main>\r\n");
      out.write("  <br>\r\n");
      out.write("  <br>\r\n");
      out.write("  <footer>\r\n");
      out.write("        <!-- <div class=\"parallax\"></div> -->\r\n");
      out.write("        <div class=\"container-fluid parallax p-2\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-sm-3\">\r\n");
      out.write("                        <div class=\"container\">\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"col-sm-12\">\r\n");
      out.write("                                        <h6 class=\"text-white font-weight-bold\">About Company</h6>\r\n");
      out.write("                                 </div>   \r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-sm-12\">\r\n");
      out.write("                                            <p class=\"text-justify text-white\">MSJ Exports is an experienced merchant exporter of coconut products and Spices from Tamilnadu - India, exporting finest quality products to our global clients.</p>\r\n");
      out.write("                                     </div>   \r\n");
      out.write("                            </div>    \r\n");
      out.write("                       </div>     \r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-sm-3\">\r\n");
      out.write("                        <div class=\"container\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-sm-12\">\r\n");
      out.write("                                            <h6 class=\"text-white font-weight-bold\">Why Us</h6>\r\n");
      out.write("                                     </div>   \r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-sm-12\">\r\n");
      out.write("                                                <p class=\"text-justify text-white font-weight-bold\"><i class=\"i right\"></i>&nbsp;&nbsp;Wide range of products</p>\r\n");
      out.write("                                         </div>   \r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-sm-12\">\r\n");
      out.write("                                               <p class=\"text-justify text-white font-weight-bold\"><i class=\"i right\"></i>&nbsp;&nbsp;Premium Quality</p>\r\n");
      out.write("                                         </div>   \r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-sm-12\">\r\n");
      out.write("                                                <p class=\"text-justify text-white font-weight-bold\"><i class=\"i right\"></i>&nbsp;&nbsp;Fair Pricing</p>\r\n");
      out.write("                                         </div>   \r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-sm-12\">\r\n");
      out.write("                                                <p class=\"text-justify text-white font-weight-bold\"><i class=\"i right\"></i>&nbsp;&nbsp;Proper Packing</p>\r\n");
      out.write("                                         </div>   \r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-sm-12\">\r\n");
      out.write("                                                <p class=\"text-justify text-white font-weight-bold\"><i class=\"i right\"></i>&nbsp;&nbsp;Timely Delivery</p>\r\n");
      out.write("                                         </div>   \r\n");
      out.write("                                </div>     \r\n");
      out.write("                           </div>   \r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-sm-3\">\r\n");
      out.write("                        <div class=\"container\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-sm-12\">\r\n");
      out.write("                                            <h6 class=\"text-white font-weight-bold\">Membership</h6>\r\n");
      out.write("                                     </div>   \r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-sm-12\">\r\n");
      out.write("                                                <img src=\"img/mem-logo/coir_logo.png\" width=\"100px\" height=\"100px\" alt=\"coir logo\">\r\n");
      out.write("                                                <img src=\"img/mem-logo/spices_logo.png\" width=\"100px\" height=\"100px\" alt=\"spices logo\">\r\n");
      out.write("                                         </div>\r\n");
      out.write("                                              \r\n");
      out.write("                                </div>\r\n");
      out.write("                                    \r\n");
      out.write("                        </div>  \r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-sm-3\">\r\n");
      out.write("                        <div class=\"container\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-sm-12\">\r\n");
      out.write("                                            <h6 class=\"text-white font-weight-bold\">Contact Us</h6>\r\n");
      out.write("                                     </div>   \r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-sm-12\">\r\n");
      out.write("                                                <p class=\"text-white font-weight-bold\">\r\n");
      out.write("                                                   MahendraKumar.J (Managing Director) <br>\r\n");
      out.write("                                                   msjexportsindia@gmail.com <br>\r\n");
      out.write("                                                   +91 90809 39033<br>\r\n");
      out.write("                                                   \r\n");
      out.write("                                                </p>\r\n");
      out.write("                                         </div>\r\n");
      out.write("                                         <div class=\"col-sm-12\">\r\n");
      out.write("                                                <a class=\"text-white font-weight-bold\" href=\"#\">Factory Unit:</a>\r\n");
      out.write("                                                <p class=\"text-white\"> Aliyar Dam Road, Pollachi, Tamilnadu, India</p>\r\n");
      out.write("                                         </div>\r\n");
      out.write("                                         <div class=\"col-sm-12\">\r\n");
      out.write("                                                <a class=\"text-white font-weight-bold\" href=\"#\">Registered Office:</a>\r\n");
      out.write("                                                <p class=\"text-white\"> 144, Sundarraj Nagar, Subramaniapuram,Trichy – 620020, Tamilnadu, India</p>\r\n");
      out.write("                                         </div>     \r\n");
      out.write("                                </div>\r\n");
      out.write("                                    \r\n");
      out.write("                        </div>  \r\n");
      out.write("                </div>\r\n");
      out.write("                      \r\n");
      out.write("            </div>   \r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"container-fluid text-white copyright\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-sm-12 mx-auto mt-3\">\r\n");
      out.write("                    <p class=\"text-center\">© 2019 Copyright:\r\n");
      out.write("                        <a class=\"text-white\" href=\"#\">MSJ Exports. All rights reserved |</a> \r\n");
      out.write("                        <a class=\"text-white design-font\" target=\"_blank\" href=\"https://www.google.com/maps/search/?api=1&query=Fz+Systems+Trichy\">Powered by Fz Systems,Trichy</a>\r\n");
      out.write("                    </p>    \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>        \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("        </div>    \r\n");
      out.write("    </footer>\r\n");
      out.write("    <button onclick=\"topFunction()\" id=\"myBtn\" title=\"Go to top\"><i class=\"fas fa-angle-double-up fa-2x\"></i></button>\r\n");
      out.write("   <!-- jquery js link -->\r\n");
      out.write("   <script type=\"text/javascript\" src=\"js/jquery-3.1.1.js\"></script>\r\n");
      out.write("   <!-- popper js link -->\r\n");
      out.write("   <script type=\"text/javascript\" src=\"js/popper-min.js\"></script>\r\n");
      out.write("   <!-- bootstrap js  -->\r\n");
      out.write("   <script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("   <!-- swiper  js -->\r\n");
      out.write("   <script src=\"js/swiper.min.js\"></script>\r\n");
      out.write("   <script type=\"text/javascript\" src=\"js/home.js\" async defer></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /index/index.jsp(105,9) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/index/index.jsp(105,9) '${IndexList}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${IndexList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /index/index.jsp(105,9) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("IndexListItem");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("        \t\t<a class=\"dropdown-item text-white dp-hover\" href=\"./product?value=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${IndexListItem}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${IndexListItem}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</a>\r\n");
            out.write("        \t\t<!--<a class=\"dropdown-item text-white dp-hover\" onclick=\"loadItem('");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${IndexListItem}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("')\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${IndexListItem}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</a> -->\r\n");
            out.write("        \t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
    } finally {
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}