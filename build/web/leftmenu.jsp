<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@include file="loginauthenticated.jsp"%> 
<div style="color:#9e0303;padding: 5px;border-bottom: 3px solid #9e0303;font-weight: bold;">
<%
    String ph ="<img src='"+(String)session.getAttribute("session_userphotograph")+"' class='img-circle' style='width:50px;'>";
    String nm = "<span style='padding:5px;'>"+(String)session.getAttribute("session_username")+"</span>";
    out.print(ph+nm);
    String today = new SimpleDateFormat("yyyy-MM-dd (E hh:mm a)").format(new Date());
%>
</div>
<div style="color:#9e0303;padding: 5px;border-bottom: 3px solid #9e0303;font-weight: bold;">
    <%=today%>
</div>
<ul id="lmenu">
    <li><a href="home.jsp">Home</a></li>
    <%  
     String session_userrole2  = (String)session.getAttribute("session_userrole");   
    if(session_userrole2.equals("A")) {
      out.print("<li><a href='createuser.jsp'>Create User</a></li>");
      out.print("<li><a href='initialization.jsp'>Initialization</a></li>");   
    } 
     
        else if (session_userrole2.equals("E")){
         out.print("<li><a href='applyleave.jsp'>Apply Leave</a></li>");
         out.print("<li><a href='viewsalary.jsp'>Salary Details</a></li>");
     }else if(session_userrole2.equals("U")){         
         String session_menu  = (String)session.getAttribute("session_menu"); 
            
         out.print(session_menu);       
     }
     else 
     {       
    %>     
      
    <%
    }
    %>         
</ul>