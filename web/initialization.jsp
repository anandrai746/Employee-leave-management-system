<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Initialization</title>
        <%@include file="headerfiles.jsp"%> 
        <script src="scripts/application/js/initialization.js" type="text/javascript" ></script> 
    </head>
    <body>
        <div id="header" class="conts">
            <%@include file="header.jsp"%>             
        </div>
        <div id="body" class="conts" style="height: 1024px">
            <div id="left">
                <%@include file="leftmenu.jsp"%>    
            </div>
            <div id="right">
                <h3 class="pagetitle">Initialization</h3>
                <table>
                    <tfoot>
                        <tr>
                            <td style="width:50%;border: 0px;background-color: #FFF;" valign="top">
                                <table id="courses" class="initialization">   
                                    <thead>
                                        <tr>
                                            <th>Courses</th>
                                        </tr>
                                        <tr>
                                            <th>
                                                <input type="text" id="coursecode" style="display:none;"/>
                                                <input type="text" id="coursename" class="inputtext" maxlength="100" style="width: 100%;"/>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th>
                                                <input type="button" id="submitcoursesI" class="button" value="Insert" style="width: 49%;"/>
                                                <input type="button" id="submitcoursesU" class="button" value="Update" style="width: 49%;display:none;"/>
                                                <input type="button" id="reset" class="button reset" value="Reset" style="width: 49%;"/>
                                                <span id="serverresponse1" class="error"></span>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>&nbsp;</td>
                                        </tr> 
                                    </tbody>
                                </table>   
                            </td>


                            <td style="width:50%;border: 0px;background-color: #FFF;" valign="top">
                                <table id="designations" class="initialization">   
                                    <thead>
                                        <tr>
                                            <th>Designations</th>
                                        </tr>
                                        <tr>
                                            <th>
                                                <input type="text" id="designationcode" style="display:none;"/>
                                                <input type="text" id="designationname" class="inputtext" maxlength="100" style="width: 100%;"/>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th>
                                                <input type="button" id="submitdesignationsI" class="button" value="Insert" style="width: 49%;"/>
                                                <input type="button" id="submitdesignationsU" class="button" value="Update" style="width: 49%;display:none;"/>
                                                <input type="button" id="reset" class="button reset" value="Reset" style="width: 49%;"/>
                                                <span id="serverresponse2" class="error"></span>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>&nbsp;</td>
                                        </tr> 
                                    </tbody>
                                </table>   
                            </td>
                            <td style="width:50%;border: 0px;background-color: #FFF;"  valign="top">
                            </td>
                        </tr>



                        <tr>
                            <td style="width:50%;border: 0px;background-color: #FFF;" valign="top">
                                <table id="enclosures" class="initialization">   
                                    <thead>
                                        <tr>
                                            <th>Enclosures</th>
                                        </tr>
                                        <tr>
                                            <th>
                                                <input type="text" id="enclosurecode" style="display:none;"/>
                                                <input type="text" id="enclosurename" class="inputtext" maxlength="100" style="width: 100%;"/>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th>
                                                <input type="button" id="submitenclosuresI" class="button" value="Insert" style="width: 49%;"/>
                                                <input type="button" id="submitenclosuresU" class="button" value="Update" style="width: 49%;display:none;"/>
                                                <input type="button" id="reset" class="button reset" value="Reset" style="width: 49%;"/>
                                                <span id="serverresponse3" class="error"></span>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>&nbsp;</td>
                                        </tr> 
                                    </tbody>
                                </table>   
                            </td>


                            <td style="width:50%;border: 0px;background-color: #FFF;" valign="top">
                                <table id="leavecategories" class="initialization">   
                                    <thead>
                                        <tr>
                                            <th>Leave Categories</th>
                                        </tr>
                                        <tr>
                                            <th>
                                                <input type="text" id="lccode" style="display:none;"/>
                                                <input type="text" id="lcdescription" class="inputtext" maxlength="100" style="width: 100%;"/>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th>
                                                <input type="button" id="submitleavecategoriesI" class="button" value="Insert" style="width: 49%;"/>
                                                <input type="button" id="submitleavecategoriesU" class="button" value="Update" style="width: 49%;display:none;"/>
                                                <input type="button" id="reset" class="button reset" value="Reset" style="width: 49%;"/>
                                                <span id="serverresponse4" class="error"></span>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>&nbsp;</td>
                                        </tr> 
                                    </tbody>
                                </table>   
                            </td>
                            <td style="width:50%;border: 0px;background-color: #FFF;"  valign="top">
                            </td>
                        </tr>



                        <tr>
                            <td style="width:50%;border: 0px;background-color: #FFF;" valign="top">
                                <table id="payscales" class="initialization">   
                                    <thead>
                                        <tr>
                                            <th>Pay Scales</th>
                                        </tr>
                                        <tr>
                                            <th>
                                                <input type="text" id="payscalecode" style="display:none;"/>
                                                <input type="text" id="payscaledescription" class="inputtext" maxlength="100" style="width: 100%;"/>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th>
                                                <input type="button" id="submitpayscalesI" class="button" value="Insert" style="width: 49%;"/>
                                                <input type="button" id="submitpayscalesU" class="button" value="Update" style="width: 49%;display:none;"/>
                                                <input type="button" id="reset" class="button reset" value="Reset" style="width: 49%;"/>
                                                <span id="serverresponse5" class="error"></span>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>&nbsp;</td>
                                        </tr> 
                                    </tbody>
                                </table>   
                            </td>



                            <td style="width:50%;border: 0px;background-color: #FFF;" valign="top">
                                   <table id="designationpayscale" class="initialization">   
                                    <thead>
                                        <tr>
                                            <th colspan="2">Designation+Pay Scale</th>
                                        </tr>
                                        <tr>
                                            <th colspan="2">
                                                <select id="designation" name="designation" class="select" style="width: 100%">
                                                    <option value="">-</option>
                                                 </select>                                                  
                                            </th>
                                        </tr>
                                        <tr>
                                            <th colspan="2">
                                                <select id="payscale" name="payscale" class="select" style="width: 100%">
                                                    <option value="">-</option>
                                                 </select>                                                   
                                            </th>
                                        </tr>
                                        <tr>
                                            <th colspan="2">                                                
                                                <input type="text" id="despaycode" style="display:none;"/>
                                                <input type="button" id="submitpaysdesI" class="button" value="Insert" style="width: 49%;"/>
                                                <input type="button" id="submitpaysdesU" class="button" value="Update" style="width: 49%;display:none;"/>
                                                <input type="button" id="reset" class="button reset" value="Reset" style="width: 49%;"/>
                                                <span id="serverresponse7" class="error"></span>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th style="width: 40%;">Designation</th>
                                            <th>Pay Scale</th>
                                        </tr>                                        
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td> 
                                        </tr> 
                                    </tbody>
                                </table>
                            </td>
                            
                            <td style="width:50%;border: 0px;background-color: #FFF;"  valign="top">
                            </td>   
                        </tr>

                    </tfoot>
                </table>
            </div>
        </div>

        <div id="footer" class="conts">
            <%@include file="footer.jsp"%> 
        </div>			
    </body>
</html>
