<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <%@include file="headerfiles.jsp"%> 
        <script src="scripts/application/js/changepass.js" type="text/javascript" ></script> 
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
                 <h3 class="pagetitle">Change Password</h3>
                 <form id="dataForm" name="dataForm" method="POST" action="">
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
                                <label>Password</label> <span class="mandatory">*</span>
                            </td>
                            <td>
                                <input type="password" id="userpassword" name="userpassword" maxlength="512" class="inputtext" autocomplete="off"/>
                                <span id="userpasswordMsg" class="error"></span>
                            </td>
                        </tr>  
                        <tr>
                            <td>
                                <label>Confirm Password</label> <span class="mandatory">*</span>
                            </td>
                            <td>
                                <input type="password" id="userpasswordconfirm" name="userpasswordconfirm" maxlength="512" class="inputtext"/>
                                <span id="userpasswordconfirmMsg" class="error"></span>
                            </td>
                        </tr>  
                        <tr>
                            <td>&nbsp;</td>
                            <td >
                                <input type="button" id="submit" value="Submit" class="button"/>
                                <input type="reset" id="reset" value="Reset" class="button"/>
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
