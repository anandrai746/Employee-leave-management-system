<img id="logo" src="scripts/application/css/images/fostai_1.png" />
<span id="logotext">A Human Resource Management System</span>
<%
    String session_userrole1  = (String)session.getAttribute("session_userrole");
    String session_useremail1  = (String)session.getAttribute("session_useremail");
    if (session_useremail1 != null) {
%>
<div id="tmenu">    
    <span><a href="home.jsp">Home</a>&nbsp;|&nbsp;</span>
    <%    
     if (session_userrole1.equals("E")) {
       out.print("<span><a href='viewprofile.jsp'>View Profile</a>&nbsp;|&nbsp;</span>");
     }else{
        out.print("<span><a href='changeprofile.jsp'>Change Profile</a>&nbsp;|&nbsp;</span>");
     }
    %>    
    <span><a href="changephoto.jsp">Change Photograph</a>&nbsp;|&nbsp;</span>
    <span><a href="changepass.jsp">Change Password</a>&nbsp;|&nbsp;</span>
    <span><a href="logout.jsp">Logout</a></span>
</div> 
<%} else {
%>
<!--<div id="tmenu">
    <span><a href="login.jsp">Login</a></span>    
</div>-->
<%        }
%>  