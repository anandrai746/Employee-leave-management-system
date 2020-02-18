<%
    Integer session_usercode  = (Integer)session.getAttribute("session_usercode");
    String session_userrole  = (String)session.getAttribute("session_userrole");
    String session_username  = (String)session.getAttribute("session_username");
    String session_useremail  = (String)session.getAttribute("session_useremail");
    String session_regunitno  = "";
    if(session.getAttribute("session_username")!=null){
      session_regunitno=(String)session.getAttribute("session_username");
    }
    if(session_useremail==null){
        response.sendRedirect("login.jsp");
    }
%>