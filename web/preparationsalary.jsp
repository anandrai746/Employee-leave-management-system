<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leave</title>
        <%@include file="headerfiles.jsp"%> 	        
        <script src="scripts/application/js/preparationsalary.js" type="text/javascript" ></script> 

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
                <h3 class="pagetitle">Preparation of Salary </h3>
                <form id="salaryform" name="salaryform" method="POST" action="">
                    <table>   
                        <tfoot>
                            <tr>
                                <td colspan="2" style="padding:10px;width: 40%">
                                    <select id="foryear" class="select" onchange="salaryPending();">
                                        <option value="">-</option>
                                    </select>
                                    <select id="formonth" class="select" onchange="salaryPending();">
                                        <option value="">-</option>
                                    </select>
                                    <span id="validate" class="error"></span>
                                    <input type="button" value="Print Pending" onclick="printPending();" class="button" style="float:right;"/>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 50%" valign="top">
                                    <table style="width: 100%">
                                        <thead>
                                            <tr>
                                                <th colspan="2" style="padding: 5px;">Salary Processing</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Emp. Name</td>
                                                <td id="fullname"></td>
                                            </tr>
                                            <tr>
                                                <td>Designation</td>
                                                <td id="designationname"></td>
                                            </tr>
                                            <tr>
                                                <td>Pay Scale</td>
                                                <td id="payscaledescription"></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label>Basic <span class="mandatory">*</span></label>
                                                </td>
                                                <td>
                                                    <input type="text" id="basic" name="basic" class="typetext" />
                                                    <span id="basicMsg" class="error"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label> TA <span class="mandatory">*</span></label>
                                                </td> 
                                                <td>
                                                    <input type="text" id="ta" name="ta" class="typetext" />
                                                    <span id="taMsg" class="error"></span>
                                                </td>        
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label> DA <span class="mandatory">*</span></label>
                                                </td> 
                                                <td>
                                                    <input type="text" id="da" name="da" class="typetext"/>
                                                    <span id="daMsg" class="error"></span>
                                                </td>        
                                            </tr>

                                            <tr>
                                                <td>
                                                    <label> HRA <span class="mandatory">*</span></label>
                                                </td> 
                                                <td>
                                                    <input type="text" id="hra" name="hra" class="typetext" />
                                                    <span id="hraMsg" class="error"></span>
                                                </td>        
                                            </tr>

                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <td colspan="2">
                                                    <input type="button" value="Submit" onclick="submitSalary()" class="button" style="float:right;"/>
                                                    <div id="serverresponse" class="error"></div>
                                                </td>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </td>
                                <td style="width: 50%" valign="top">
                                    <div  style="height:280px;overflow: auto;">
                                        <table id="salarypending" style="width: 100%">
                                            <thead>
                                                <tr>
                                                    <th colspan="4" style="padding: 5px;">Salary Pending List</th>
                                                </tr>
                                                <tr>
                                                    <th style="width:25%;padding:5px;">Emp. Name</th>
                                                    <th style="width:25%;padding:5px;">Designation</th>
                                                    <th style="width:25%;padding:5px;">Pay Scale</th>
                                                    <th style="width:25%;padding:5px;">Action</th>
                                                </tr>    
                                            </thead>
                                            <tbody>
                                                <tr><td colspan="4">&nbsp;</td></tr>                                        
                                            </tbody>
                                            <tfoot>
                                                <tr><td colspan="4">&nbsp;</td></tr>
                                            </tfoot>
                                        </table>
                                    </div>    
                                </td>
                            </tr>
                        </tfoot>
                    </table> 
                    <table id="salaryprocessed">
                        <thead>
                            <tr>
                                <th colspan="4" style="padding: 5px;">Salary Processed List</th>
                            </tr>
                            <tr>
                                <th style="width:25%;padding:5px;">Emp. Name</th>
                                <th style="width:25%;padding:5px;">Designation</th>
                                <th style="width:25%;padding:5px;">Pay Scale</th>
                                <th style="width:25%;padding:5px;">Action</th>
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
