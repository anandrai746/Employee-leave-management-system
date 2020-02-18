<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leave</title>
        <%@include file="headerfiles.jsp"%> 	        
        <script src="scripts/application/js/viewsalary.js" type="text/javascript" ></script> 

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
                <h3 class="pagetitle">Salary Details</h3>
                <form id="viewsalary" name="viewsalary" method="POST" action="">
                   <table id="viewsalary">
                        <thead>
                            <tr>
                                <th colspan="10" style="padding: 5px;">Salay</th>
                            </tr>
                            <tr>
                                <th style="width:10%;padding:5px;">SLNO.</th>
                                <th style="width:10%;padding:5px;">For Year</th>
                                <th style="width:10%;padding:5px;">For Month</th>
                                <th style="width:10%;padding:5px;">Basic (Rs)</th>
                                <th style="width:10%;padding:5px;">TA (Rs)</th>
                                <th style="width:10%;padding:5px;">DA (Rs)</th>
                                <th style="width:10%;padding:5px;">HRA (Rs)</th>
                                <th style="width:10%;padding:5px;">Total (Rs)</th>
                                <th style="width:10%;padding:5px;">Date</th>
                                <th style="width:10%;padding:5px;">Action</th>
                            </tr>    
                        </thead>
                        <tbody>
                            <tr><td colspan="10"></td></tr>
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
  

