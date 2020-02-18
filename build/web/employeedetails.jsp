<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Of Employee</title>
        <%@include file="headerfiles.jsp"%> 	        
        <script src="scripts/application/js/employeedetails.js" type="text/javascript" ></script> 
        <script src="scripts/application/js/common.js" type="text/javascript" ></script> 

    </head>
    <body>
        <div id="header" class="conts">
            <%@include file="header.jsp"%>             
        </div>
        <div id="body" class="conts" style="height: 2500px;">
            <div id="left">
                <%@include file="leftmenu.jsp"%>    
            </div>
            <div id="right">
                <h3 class="pagetitle">Registration Of Employee</h3>
                <form id="employeedetailsForm" name="employeedetailsForm" method="POST" action="">
                
                    <table>
                        <tr>
                            <td style="width:30%">
                                <label>Designation <span class="mandatory">*</span></label>
                            </td>				
                            <td>
                                <select id="designation" name="designation" class="select">
                                    <option value="">-</option>
                                </select>
                                <span id="designationMsg" class="error"></span>
                            </td>					
                        </tr>	
                        <tr>
                            <td style="width:30%">
                                <label>First Name <span class="mandatory">*</span></label>
                            </td>				
                            <td>
                                <input type="text" id="fname" name="fname" class="inputtext" maxlength="20"/>
                                <span id="fnameMsg" class="error"></span>
                            </td>					
                        </tr>	
                        <tr>
                            <td>
                                <label>Middle Name</label>
                            </td>				
                            <td>
                                <input type="text" id="mname" name="mname" class="inputtext" maxlength="20"/>
                                <span id="mnameMsg" class="error"></span>
                            </td>					
                        </tr>
                        <tr>
                            <td>
                                <label>Last Name <span class="mandatory">*</span></label>
                            </td>				
                            <td>
                                <input type="text" id="lname" name="lname" class="inputtext" maxlength="20"/>
                                <span id="lnameMsg" class="error"></span>
                            </td>					
                        </tr>
                        <tr>
                            <td>
                                <label>Date of birth</label> <span class="mandatory">*</span>
                            </td>
                            <td>
                                <input type="text" id="dob" name="dob" readonly="true" maxlength="10" class="inputtext"/> 
                                <span id="dobMsg" class="error"></span>
                            </td>
                        </tr>				
                        <tr>
                            <td>
                                <label>Gender</label> <span class="mandatory">*</span>
                            </td>
                            <td>
                                <input type="radio" id="genderM" name="gender" value="M" class="empgender"/> Male
                                <input type="radio" id="genderF" name="gender" value="F" class="empgender"/> Female
                                <span id="genderMMsg" class="error"></span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Mobile Number</label> <span class="mandatory">*</span>
                            </td>
                            <td>
                                <input type="text" id="mobile" name="mobile" maxlength="10" class="inputtext"/>
                                <span id="mobileMsg" class="error"></span>
                            </td>
                        </tr>
                            <td>
                                <label>User Email</label> <span class="mandatory">*</span>
                            </td>
                            <td>
                                <input type="email" id="empemail" name="empemail" maxlength="100" class="inputtext"/> 
                                <span id="empemailMsg" class="error"></span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Password</label> <span class="mandatory">*</span>
                            </td>
                            <td>
                                <input type="password" id="emppassword" name="emppassword" maxlength="100" class="inputtext"/> 
                                <span id="emppasswordMsg" class="error"></span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Confirm Password</label> <span class="mandatory">*</span>
                            </td>
                            <td>
                                <input type="password" id="conemppassword" name="conemppassword" maxlength="100" class="inputtext"/> 
                                <span id="conemppasswordMsg" class="error"></span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Blood Group <span class="mandatory">*</span></label>
                            </td>			
                            <td>
                                <select id="bloodgroup" name="bloodgroup" class="select">
                                    <option value="">-</option>
                                    <option value="O+">O+</option>
                                    <option value="O-">O-</option>
                                    <option value="A+">A+</option>
                                    <option value="A-">A-</option>
                                    <option value="B+">B+</option>
                                    <option value="B-">B-</option>
                                    <option value="AB+">AB+</option>
                                    <option value="AB-">AB-</option>
                                </select>	
                                <span id="bloodgroupMsg" class="error"></span>
                            </td>				
                        </tr>
                        <tr>
                            <td>
                                <label>Father Name<span class="mandatory">*</span></label>
                            </td>				
                            <td>
                                <input type="text" id="fathersname" name="fathersname" class="inputtext" maxlength="20"/>
                                <span id="fathersnameMsg" class="error"></span>
                            </td>					
                        </tr>	
                        <tr>
                            <td>
                                <label>Present Address</label>
                            </td>				
                            <td>
                                <textarea type="text" id="preaddress" name="preadd" class="textarea" maxlength="200"></textarea>
                                <span id="preaddressMsg" class="error"></span>
                            </td>					
                        </tr>
                        <tr>
                            <td>
                                <label>Present Pin code <span class="mandatory">*</span></label>
                            </td>				
                            <td>
                                <input type="text" id="prepin" name="prepin" class="inputtext" maxlength="7"/>
                                <span id="prepinMsg" class="error"></span>
                            </td>					
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="checkbox" name="sameaspre" id="sameaspre"/><label>Same as Present Address </label>
                            </td>				
                        </tr>
                        <tr>
                            <td>
                                <label>Permanent Address</label>
                            </td>				
                            <td>
                                <textarea type="text" id="peraddress" name="peradd" class="textarea" maxlength="200"></textarea>
                                <span id="peraddressMsg" class="error"></span>
                            </td>					
                        </tr>
                        <tr>
                            <td>
                                <label>Permanent Pin code <span class="mandatory">*</span></label>
                            </td>				
                            <td>
                                <input type="text" id="perpin" name="perpin" class="inputtext" maxlength="7"/>
                                <span id="perpinMsg" class="error"></span>
                            </td>					
                        </tr>
                        <tr>
                            <td>
                                <label>Pan No <span class="mandatory">*</span></label>
                            </td>				
                            <td>
                                <input type="text" id="panno" name="panno" class="inputtext" maxlength="10"/>
                                <span id="pannoMsg" class="error"></span>
                            </td>					
                        </tr>				
                        <tr>
                            <td>
                                <label>Epic ID<span class="mandatory">*</span></label>
                            </td>				
                            <td>
                                <input type="text" id="epicid" name="epicid" class="inputtext" maxlength="10"/>
                                <span id="epicidMsg" class="error"></span>
                            </td>					
                        </tr>	
                        <tr>
                            <td>
                                <label>Aadhar No </label>
                            </td>			
                            <td>
                                <input type="text" id="adharno" name="adharno" class="inputtext" maxlength="12"/>	
                                <span id="adharnoMsg" class="error"></span>
                            </td>				
                        </tr>
                        <tr>
                            <td>
                                <label>Driving License No</label>
                            </td>				
                            <td>
                                <input type="text" id="drivinglicenceno" name="drivinglic" class="inputtext" maxlength="20"/>
                                <span id="drivinglicencenoMsg" class="error"></span>
                            </td>					
                        </tr>				
                        <tr>
                            <td>
                                <label>Passport No</label>
                            </td>				
                            <td>
                                <input type="text" id="passportno" name="passportno" class="inputtext" maxlength="10"/>
                                <span id="passportnoMsg" class="error"></span>
                            </td>					
                        </tr>	
                        <tr>
                            <td colspan="2">
                                <label>Educational Details</label>
                            </td>
                        </tr>	
                        <tr>
                            <td colspan="2">
                              <table style="width:100%;" id="qualtable">
                                  <thead>
                                      <tr>
                                          <th style="width:15%;">Course</th>
                                          <th style="width:20%;">Institute</th>
                                          <th style="width:15%;">Year</th>
                                          <th style="width:15%;">Percentage</th>
                                          <th style="width:10%;">Division</th>
                                          <th style="width:10%;">Certificate</th>
                                          <th style="width:10%;">Mark sheet</th>
                                          <th style="width:5%;">&nbsp;</th>
                                      </tr>
                                  <thead>
                                  <tr id="qualrow1">
                                      <td style="width:15%;">
                                          <select id="coursecode1" name="coursecode" class="select" style="width:100%;" >
                                              <option value="-1">-</option>
                                          </select>
                                          <div id="coursecode1Msg" class="msg"></div>
                                      </td>
                                      <td style="width:20%;">
                                          <input type="text" id="institute1" name="institute" class="inputtext"  maxlength="100" style="width:100%;" />
                                          <div id="institute1Msg" class="msg"></div>
                                      </td>
                                      <td style="width:15%;">
                                          <input type="text" id="passingyear1" name="passingyear" class="inputtext" maxlength="4" style="width:100%;"/>
                                          <div id="passingyear1Msg" class="msg"></div>
                                      </td>
                                      <td style="width:15%;">
                                          <input type="text" id="percentage1" name="percentage" class="inputtext" style="width:100%;"  size="5" maxlength="5"/>
                                          <div id="percentage1Msg" class="msg"></div>
                                      </td>
                                      <td style="width:10%;">
                                          <input type="text" id="division1" name="division" style="width:100%;"  maxlength="5"/> 
                                          <div id="division1Msg" class="msg"></div>
                                      </td>
                                      <td style="width:10%;">
                                          <span class="button" style="z-index: 0;">Brows</span>    
                                          <input type="file" id="passcertificate" name="passcertificate" style="display: none;z-index: 100;"/>
                                      </td>
                                      <td style="width:10%;">
                                          <span class="button" style="z-index: 0;">Brows</span>        
                                          <input type="file" id="marksheet" name="marksheet" class="inputtext" style="display: none;z-index: 100;"/>
                                      </td>
                                      <td style="width:5%;">
                                          &nbsp;
                                      </td>
                                  </tr>
                                  <tr>
                                      <td colspan="8"><center><input type="button" value="Add More" id="addmorebtn" name="1" class="button"></center></td>
                                  </tr>
                                  </table>
                           
                            </td>
                        </tr>	
                
                        <tr>
                            <td>&nbsp;</td>
                            <td>
                                <input type="button" id="register" value="submit" class="button"/>
                                <input type="button" id="reset" value="reset" class="button reset"/>
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
                  <h3>Employee Details</h3>
                 <div  style="height:280px;overflow: auto;">
                  <table id="employeeCont">
                        <thead>
                            <tr>
                                <th style="width:2%;">Sl No</th>
                                <th style="width:30%;">Employee Name</th>
                                <th style="width:15%;">Date Of Birth</th>
                                <th style="width:15%;">designation</th>
                                <th style="width:10%;">Email ID</th>
                                <th style="width:20%;">Mobile</th>
                                <th style="width:8%;">Action</th>

                             </tr>
                        </thead>
                        <tbody>    
                        </tbody>    
                    </table>
                </div>
                </form>
            </div>
        </div>		
        <div id="footer" class="conts">
            <%@include file="footer.jsp"%> 
        </div>			
    </body>
</html>
