<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leave Process</title>
        <%@include file="headerfiles.jsp"%> 	        
        <script src="scripts/application/js/leaveprocess.js" type="text/javascript" ></script> 
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
                <h3 class="pagetitle">Process for leave</h3>
                <form id="leaveform" name="leaveform" method="POST" action="">
                    <table id="leavedisplay">
                        <thead>
                            <tr>
                                <td style="width:5%;">Sl No</td>
                                <td style="width:15%;">Leave categories</td>
                                <td style="width:10%;">From date</td>
                                <td style="width:10%;">To date</td>
                                <td style="width:20%;">Description</td>
                                <td style="width:10%;">Apply date</td>
                                <td style="width:10%;">App Status</td>
                                <td style="width:25%;">Action</td>
                                
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
