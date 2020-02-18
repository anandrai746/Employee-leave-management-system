<%     
     session.removeAttribute("session_usercode");
     session.removeAttribute("session_userrole");
     session.removeAttribute("session_useremail");
     session.removeAttribute("session_userfname");
     session.removeAttribute("session_userlname");
     session.removeAttribute("session_usergender");
     session.removeAttribute("session_userdob");
     session.removeAttribute("session_usermobile");
     session.removeAttribute("session_username");
     session.removeAttribute("session_userphotograph");
     session.invalidate();        
     
     response.setHeader("Cache-Control","no-cache"); 
     response.setHeader("Cache-Control","no-store"); 
     response.addHeader("Cache-Control", "must-revalidate");
     response.setHeader("Pragma","no-cache"); 
     response.setDateHeader ("Expires", -1);
     response.sendRedirect("login.jsp");
%>
