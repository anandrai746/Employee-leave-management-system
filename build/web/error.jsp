<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <%@include file="headerfiles.jsp"%> 	        
    </head>
    <body>
        <div id="header" class="conts">
            <%@include file="header.jsp"%>             
        </div>
        <div id="body" class="conts">
            <div class="error" style="margin: 0 auto;width: 80%">                                  
                <h2>
                    <img src="scripts/application/css/images/error.gif"/>
                    <br>
                    Due to internal server error request can't be process.Please try again later...!
                    <br>
                    <input type="button" class="button" value="Go back to the previous page" onclick="history.back();" style="width: 200px;"/>
                </h2>
            </div>
        </div>		
        <div id="footer" class="conts">
            <%@include file="footer.jsp"%> 
        </div>			
    </body>
</html>
