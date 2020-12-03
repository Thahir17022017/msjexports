<%@page pageEncoding="utf-8" %>
<img alt="admin logo image" src="icons/logo.png" style="border-radius:50%;position:relative;top:5px;left:5px;">
<div class="container bgcontainer" style="height:450px;">
                <form id="form" action="login" method="post">
                    <div class="row">
                        <div class="col-sm-12 pushcol">
                        		<div class="group1" >      
                                        <input id="username" class="input1 customfont" type="text" required>
                                        <span class="highlight1"></span>
                                        <span class="bar1"></span>
                                        <label class="label1 customfont">Username *</label>
                                        <div id="usermsg" class="customfont" style="visibility:hidden;color:red;opacity:1;">Username is required</div>
                                </div>
                                <div class="group1">      
                                        <input id="password" class="input1 customfont" type="password" required>
                                        <span class="highlight1"></span>
                                        <span class="bar1"></span>
                                        <label class="label1 customfont">Password *</label>
                                        <div id="pwdmsg" class="customfont" style="visibility:hidden;color:red;opacity:1;">Password is required</div>
                               </div>
                                <div>
                               			<span id="adminerror" class="customfont" style="visibility:hidden;position:relative;color:red;left:50px;opacity:1;">! Admin credentials are incorrect</span><br>
                               			<span id="sessionexp" class="customfont" style="visibility:visible;position:relative;color:red;left:50px;opacity:1;">! Session Expired </span>
                               </div>
                               <div class="col-sm-12 pt-4">
                              
                                    <button type="button" class="loginbtn customfont" onclick="sendData()">Login</button>
                               </div>
                        </div>
                    </div>
                </form>        
</div>
  

