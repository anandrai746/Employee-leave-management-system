<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@include file="headerfiles.jsp"%> 
        <script src="scripts/application/js/login.js" type="text/javascript" ></script>
    </head>
    <body>
        <div id="header" class="conts">
            <%@include file="header.jsp"%>             
        </div>
        <div id="body" class="conts">            
            <div id="loginContant">
                <h3><center>Welcome to Fostai</center></h3>
                <form id="loginForm" name="loginForm" method="POST" action="ControllerLogin">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2"><center>Login</center></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td style="width: 30%">
                                    <label>User Type</label><span class="mandatory">*</span>
                                </td>
                                <td>
                                    <select id="usertype" name="usertype" class="select">
                                        <option value="">-</option>
                                        <option value="A">Admin</option>
                                        <option value="E">Employee</option>
                                        <option value="U">Office User</option>
                                    </select>
                                    <span id="usertypeMsg" class="error"></span>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 30%">
                                    <label>User Id</label><span class="mandatory">*</span>
                                </td>
                                <td>
                                    <input type="text" id="useremail" name="useremail" maxlength="50" class="inputtext"/>
                                    <span id="useremailMsg" class="error"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Password</label><span class="mandatory">*</span>
                                </td>
                                <td>
                                    <input type="password" id="userpassword" name="userpassword" maxlength="512" class="inputtext"/>
                                    <span id="userpasswordMsg" class="error"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>&nbsp;</td>
                                <td>
                                    <input type="button" id="login" value="Login" class="button"/>
                                    <input type="button" id="reset" value="reset" class="button"/>
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
