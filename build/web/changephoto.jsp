<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Photograph</title>
        <%@include file="headerfiles.jsp"%> 
        <script src="scripts/application/js/changephoto.js" type="text/javascript" ></script> 
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
                <h3 class="pagetitle">Change Photograph</h3>
                <form id="dataForm" name="dataForm" method="POST" action="">
                    <table>
                        <tbody> 
                            <tr>                            
                                <td>
                                    <div class="drop_zone">
                                        <span class="uploadText">
                                            Drop  File here 
                                            <small>[Allowed file types jpg,png etc.]</small>
                                        </span>
                                        <input id="imageUpload" class="file" type="file"/>
                                    </div>
                                    <div id="fileHolder"></div>                    
                                    <div id="fileHolderMsg"></div>   
                                    <img id="processing" src="scripts/application/css/images/processing.gif" style="display: none;"/>
                                </td>
                            </tr>
                            <tr>                                
                                <td>
                                    <input type="button" id="submit" value="Submit" class="button"/>
                                    <input type="reset"  id="reset" value="Reset" class="button"/>
                                </td>
                            </tr>  
                        </tbody> 
                        <tfoot>    
                            <tr>
                                <td>                                    
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
