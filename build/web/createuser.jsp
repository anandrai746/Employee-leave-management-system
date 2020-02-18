<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
        <%@include file="headerfiles.jsp"%> 	        
        <script src="scripts/application/js/createuser.js" type="text/javascript" ></script> 
        <script src="scripts/application/js/common.js" type="text/javascript" ></script> 
    </head>
    <body>
        <div id="header" class="conts">
            <%@include file="header.jsp"%>             
        </div>
        <div id="body" class="conts" style="height: 1024px;">
            <div id="left">
                <%@include file="leftmenu.jsp"%>    
            </div>
            <div id="right">
                <h3 class="pagetitle">Create User</h3>
                <form id="createuserForm" name="createuserForm" method="POST" action="">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2"><center>Create User</center></th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr>    
                                <td><label>User Id</label> </td>
                                <td>
                                    <%out.print((String) session.getAttribute("session_useremail"));%>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>First Name</label> <span class="mandatory">*</span>
                                </td>
                                <td>
                                    <input type="text" id="userfname" name="userfname" maxlength="50" class="inputtext"/>
                                    <span id="userfnameMsg" class="error"></span>
                                </td>
                            </tr>  
                            <tr>
                                <td>
                                    <label>Last Name</label> <span class="mandatory">*</span>
                                </td>
                                <td>
                                    <input type="text" id="userlname" name="userlname" maxlength="50" class="inputtext"/>
                                    <span id="userlnameMsg" class="error"></span>
                                </td>
                            </tr>  
                            <tr>
                                <td>
                                    <label>Date of birth</label> <span class="mandatory">*</span>
                                </td>
                                <td>
                                    <input type="text" id="userdob" name="userdob" maxlength="10" readonly="true" class="inputtext"/> YYYY-MM-DD
                                    <span id="userdobMsg" class="error"></span>
                                </td>
                            </tr>  
                            <tr>
                                <td>
                                    <label>Gender</label> <span class="mandatory">*</span>
                                </td>
                                <td>
                                    <input type="radio" id="usergenderM" name="usergender" value="M" class="usergender"/> Male
                                    <input type="radio" id="usergenderF" name="usergender" value="F" class="usergender"/> Female
                                    <span id="usergenderMMsg" class="error"></span>
                                </td>
                            </tr>  
                            <tr>
                                <td>
                                    <label>Mobile</label> <span class="mandatory">*</span>
                                </td>
                                <td>
                                    <input type="text" id="usermobile" name="usermobile" maxlength="10" class="inputtext"/>
                                    <span id="usermobileMsg" class="error"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Email</label> <span class="mandatory">*</span>
                                </td>
                                <td>
                                    <input type="text" id="useremail" name="useremail" maxlength="50" class="inputtext"/>
                                    <span id="useremailMsg" class="error"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Password</label> <span class="mandatory">*</span>
                                </td>
                                <td>
                                    <input type="password" id="userpassword" name="userpassword" maxlength="512" class="inputtext"/>
                                    <span id="userpasswordMsg" class="error"></span>
                                </td>
                            </tr> 
                            <tr>
                                <td>
                                    <label>Confirm Password</label> <span class="mandatory">*</span>
                                </td>
                                <td>
                                    <input type="password" id="conuserpassword" name="conuserpassword" maxlength="512" class="inputtext"/>
                                    <span id="conuserpasswordMsg" class="error"></span>
                                </td>
                            </tr> 
                            <tr>
                                <td>
                                    <label>User Role</label> <span class="mandatory">*</span>
                                </td>
                                <td>
                                    <select  id="userrole" name="userrole"  class="select">
                                        <option value="-1" >-</option>
                                        <option value="A" >Admin</option>
                                        <option value="U" >User</option>
                                    </select>
                                    <span id="userroleMsg" class="error"></span>
                                </td>
                            </tr> 
                            <tr>
                                <td>
                                    <label>Status</label> <span class="mandatory">*</span>
                                </td>
                                <td>
                                    <select  id="userstatus" name="userstatus"  class="select">
                                        <option value="-1">-</option>
                                        <option value="Y">Enable</option>
                                        <option value="N">Disable</option>
                                    </select>
                                    <span id="userstatusMsg" class="error"></span>
                                </td>
                            </tr> 
                            <tr>
                                <td>&nbsp;</td>
                                <td>
                                    <input type="button" id="submit" value="Submit" class="button" />
                                    <input type="button" id="reset" class="button reset" value="Reset"/>
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
                    <div id="asspro"></div>

                    <table id="userCont">
                        <thead>
                            <tr>
                                <th style="width:2%;">Sl No</th>
                                <th style="width:30%;">User Name</th>
                                <th style="width:15%;">User Id</th>
                                <th style="width:10%;">Mobile No</th>
                                <th style="width:20%;">Process</th>
                                <th style="width:20%;">Action</th>
                            </tr>
                        </thead>
                        <tbody>    
                        </tbody>    
                    </table>
                </form>

            </div>
        </div>

        <div id="footer" class="conts">
            <%@include file="footer.jsp"%> 
        </div>			
    </body>
</html>
