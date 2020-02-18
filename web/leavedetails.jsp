<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leave</title>
        <%@include file="headerfiles.jsp"%> 	        
        <script src="scripts/application/js/leavedetails.js" type="text/javascript" ></script> 
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
                <h3 class="pagetitle">Apply for Leave</h3>
                <form id="leaveform" name="leaveform" method="POST" action="">
                    <fieldset>
                        <legend>Leave</legend>
                    <table id="leavelist">
                        <tr>
                           <td>
                                <label>Leave Categories <span class="mandatory">*</span></label>
                            </td>
                            <td>
                                <select id="leavecatagories" name="leavecatagories" class="select">
                                    <option value="">-</option>
                                    </select>
                                  <span id="leavecatagoriesMsg" class="error"></span>
                             </td>
                        </tr>
                        <tr>
                            <td>
                                <label> From Date <span class="mandatory">*</span></label>
                            </td> 
                            <td>
                                <input type="text" id="fromdate" name="fromdate" class="typetext" placeholder="YYYY-MM-YY"/>
                                 <span id="fromdateMsg" class="error"></span>
                            </td>        
                        </tr>
                        <tr>
                            <td>
                                <label> To Date <span class="mandatory">*</span></label>
                            </td> 
                            <td>
                                <input type="text" id="todate" name="todate" class="typetext" placeholder="YYYY-MM-YY"/>
                                 <span id="todateMsg" class="error"></span>
                            </td>        
                        </tr>
                        
                         <tr>
                            <td>
                                <label> Description <span class="mandatory">*</span></label>
                            </td> 
                            <td>
                                <textarea id="description" name="description" class="textarea" maxlength="500" ></textarea>
                                 <span id="descriptionMsg" class="error"></span>
                            </td>        
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td>
                                <input type="button" id="submitleave" value="submit" class="button"/>
                                <input type="button" id="reset" value="reset" class="button reset"/>
                            </td>
                        </tr>
                        
                        <tbody>
                            
                        
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="2">
                                    <div id="serverresponse" class="error"></div>&nbsp;
                                </td>
                            </tr>
                        </tfoot>
                     </table>
                     </fieldset>
                    <table id="leavedisplay">
                        <thead>
                            <tr>
                                <td style="width:5%;">Sl No</td>
                                <td style="width:15%;">Leave categories</td>
                                <td style="width:15%;">From date</td>
                                <td style="width:15%;">To date</td>
                                <td style="width:40%;">Description</td>
                                <td style="width:10%;">App Status</td>
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
