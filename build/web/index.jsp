<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <%@include file="headerfiles.jsp"%> 	
        <script src="scripts/application/js/index.js" type="text/javascript" ></script> 
    </head>
    <body>
        <div id="header" class="conts">
            <%@include file="header.jsp"%>             
        </div>
        <div id="body" class="conts" >
            <div id="left">
                <%@include file="leftmenu.jsp"%>    
            </div>
            <div id="right">
                
            </div>
        </div>		
        <div id="footer" class="conts">
            <%@include file="footer.jsp"%> 
        </div>			
    </body>
</html>
