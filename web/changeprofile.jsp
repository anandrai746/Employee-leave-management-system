<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Profile</title>
        <%@include file="headerfiles.jsp"%> 
        <script src="scripts/application/js/changeprofile.js" type="text/javascript" ></script> 
    </head>
    <body>
        <div id="header" class="conts">
            <%@include file="header.jsp"%>             
        </div>
        <div id="body" class="conts">
            <div id="left">
                <%@include file="leftmenu.jsp"%>    
            </div>
            <div id="right">
                <h3 class="pagetitle">Change Profile</h3>
                <form id="dataForm" name="dataForm" method="POST" action="">
                <%
                    String userfname  = (String)session.getAttribute("session_userfname");
                    String userlname  = (String)session.getAttribute("session_userlname");
                    String usergender = (String)session.getAttribute("session_usergender");
                    String userdob    = (String)session.getAttribute("session_userdob");
                    String usermobile = (String)session.getAttribute("session_usermobile");
                    String mchecked = (usergender.equals("M"))?"checked":"";
                    String fchecked = (usergender.equals("F"))?"checked":"";
                %>                    
                 <table>
                    <tbody> 
                        <tr>
                            <td><label>User Id</label> </td>
                            <td>
                                <%out.print((String)session.getAttribute("session_useremail"));%>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>First Name</label> <span class="mandatory">*</span>
                            </td>
                            <td>
                                <input type="text" id="userfname" name="userfname" maxlength="50" class="inputtext" value="<%=userfname%>"/>
                                <span id="userfnameMsg" class="error"></span>
                            </td>
                        </tr>  
                        <tr>
                            <td>
                                <label>Last Name</label> <span class="mandatory">*</span>
                            </td>
                            <td>
                                <input type="text" id="userlname" name="userlname" maxlength="50" class="inputtext" value="<%=userlname%>"/>
                                <span id="userlnameMsg" class="error"></span>
                            </td>
                        </tr>  
                        <tr>
                            <td>
                                <label>DOB</label> <span class="mandatory">*</span>
                            </td>
                            <td>
                                <input type="text" id="userdob" name="userdob" maxlength="10" class="inputtext" value="<%=userdob%>"/> (YYYY-MM-DD)
                                <span id="userdobMsg" class="error"></span>
                            </td>
                        </tr>  
                        <tr>
                            <td>
                                <label>Gender</label> <span class="mandatory">*</span>
                            </td>
                            <td>
                                <input type="radio" id="usergenderM" name="usergender" value="M" class="usergender" <%=mchecked%>/> Male
                                <input type="radio" id="usergenderF" name="usergender" value="F" class="usergender" <%=fchecked%>/> Female
                                <span id="usergenderMMsg" class="error"></span>
                            </td>
                        </tr>  
                        <tr>
                            <td>
                                <label>Mobile</label> <span class="mandatory">*</span>
                            </td>
                            <td>
                                <input type="text" id="usermobile" name="usermobile" maxlength="10" class="inputtext" value="<%=usermobile%>"/>
                                <span id="usermobileMsg" class="error"></span>
                            </td>
                        </tr>                        
                        
                        <tr>
                            <td>&nbsp;</td>
                            <td>
                                <input type="button" id="submit" value="Submit" class="button"/>
                                <input type="reset" id="reset" value="Reset" class="button reset"/>
                            </td>
                        </tr>  
                    </tbody> 
                    <tfoot>    
                        <tr>
                            <td colspan="2">
                                <div id="serverresponse" class="error"></div>&nbsp;
                            </td>
                        </tr>                         
                    </tfoot>    
                 </table>
                </form>                 
            </div>
        </div>		
        <div id="footer" class="conts">
            <%@include file="footer.jsp"%> 
        </div>			
    </body>
</html>
