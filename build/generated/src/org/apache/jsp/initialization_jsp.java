package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class initialization_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(5);
    _jspx_dependants.add("/headerfiles.jsp");
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/leftmenu.jsp");
    _jspx_dependants.add("/loginauthenticated.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Initialization</title>\n");
      out.write("        ");
      out.write("<link href=\"scripts/application/css/images/fostai-fbic.png\" rel=\"shortcut icon\" type=\"image/x-icon\" />\r\n");
      out.write("<link href=\"scripts/application/css/application.min.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"scripts/application/css/fostai.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"scripts/application/css/bootstrap.min.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"scripts/application/css/fostai.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<script src=\"scripts/jquery/jquery.min.js\" type=\"text/javascript\" ></script> \r\n");
      out.write("<script src=\"scripts/jquery/bootstrap.min.js\" type=\"text/javascript\" ></script> \r\n");
      out.write("<script src=\"scripts/utility/utility.min.js\" type=\"text/javascript\" ></script> \r\n");
      out.write("<script src=\"scripts/utility/sha256.min.js\" type=\"text/javascript\" ></script> \r\n");
      out.write("<link href=\"scripts/jquery/datepicker/jsDatePick.min.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<script src=\"scripts/jquery/datepicker/jsDatePick.min.js\" type=\"text/javascript\"></script>");
      out.write(" \n");
      out.write("        <script src=\"scripts/application/js/initialization.js\" type=\"text/javascript\" ></script> \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"header\" class=\"conts\">\n");
      out.write("            ");
      out.write("<img id=\"logo\" src=\"scripts/application/css/images/fostai_1.png\" />\r\n");
      out.write("<span id=\"logotext\">A Human Resource Management System</span>\r\n");

    String session_userrole1  = (String)session.getAttribute("session_userrole");
    String session_useremail1  = (String)session.getAttribute("session_useremail");
    if (session_useremail1 != null) {

      out.write("\r\n");
      out.write("<div id=\"tmenu\">    \r\n");
      out.write("    <span><a href=\"home.jsp\">Home</a>&nbsp;|&nbsp;</span>\r\n");
      out.write("    ");
    
     if (session_userrole1.equals("E")) {
       out.print("<span><a href='viewprofile.jsp'>View Profile</a>&nbsp;|&nbsp;</span>");
     }else{
        out.print("<span><a href='changeprofile.jsp'>Change Profile</a>&nbsp;|&nbsp;</span>");
     }
    
      out.write("    \r\n");
      out.write("    <span><a href=\"changephoto.jsp\">Change Photograph</a>&nbsp;|&nbsp;</span>\r\n");
      out.write("    <span><a href=\"changepass.jsp\">Change Password</a>&nbsp;|&nbsp;</span>\r\n");
      out.write("    <span><a href=\"logout.jsp\">Logout</a></span>\r\n");
      out.write("</div> \r\n");
} else {

      out.write("\r\n");
      out.write("<!--<div id=\"tmenu\">\r\n");
      out.write("    <span><a href=\"login.jsp\">Login</a></span>    \r\n");
      out.write("</div>-->\r\n");
        }

      out.write(' ');
      out.write(' ');
      out.write("             \n");
      out.write("        </div>\n");
      out.write("        <div id=\"body\" class=\"conts\" style=\"height: 1024px\">\n");
      out.write("            <div id=\"left\">\n");
      out.write("                ");
      out.write("\r\n");
      out.write("\r\n");

    Integer session_usercode  = (Integer)session.getAttribute("session_usercode");
    String session_userrole  = (String)session.getAttribute("session_userrole");
    String session_username  = (String)session.getAttribute("session_username");
    String session_useremail  = (String)session.getAttribute("session_useremail");
    String session_regunitno  = "";
    if(session.getAttribute("session_username")!=null){
      session_regunitno=(String)session.getAttribute("session_username");
    }
    if(session_useremail==null){
        response.sendRedirect("login.jsp");
    }

      out.write(" \r\n");
      out.write("<div style=\"color:#9e0303;padding: 5px;border-bottom: 3px solid #9e0303;font-weight: bold;\">\r\n");

    String ph ="<img src='"+(String)session.getAttribute("session_userphotograph")+"' class='img-circle' style='width:50px;'>";
    String nm = "<span style='padding:5px;'>"+(String)session.getAttribute("session_username")+"</span>";
    out.print(ph+nm);
    String today = new SimpleDateFormat("yyyy-MM-dd (E hh:mm a)").format(new Date());

      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div style=\"color:#9e0303;padding: 5px;border-bottom: 3px solid #9e0303;font-weight: bold;\">\r\n");
      out.write("    ");
      out.print(today);
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<ul id=\"lmenu\">\r\n");
      out.write("    <li><a href=\"home.jsp\">Home</a></li>\r\n");
      out.write("    ");
  
     String session_userrole2  = (String)session.getAttribute("session_userrole");   
    if(session_userrole2.equals("A")) {
      out.print("<li><a href='createuser.jsp'>Create User</a></li>");
      out.print("<li><a href='initialization.jsp'>Initialization</a></li>");   
    } 
     
        else if (session_userrole2.equals("E")){
         out.print("<li><a href='applyleave.jsp'>Apply Leave</a></li>");
         out.print("<li><a href='viewsalary.jsp'>Salary Details</a></li>");
     }else if(session_userrole2.equals("U")){         
         String session_menu  = (String)session.getAttribute("session_menu"); 
            
         out.print(session_menu);       
     }
     else 
     {       
    
      out.write("     \r\n");
      out.write("      \r\n");
      out.write("    ");

    }
    
      out.write("         \r\n");
      out.write("</ul>");
      out.write("    \n");
      out.write("            </div>\n");
      out.write("            <div id=\"right\">\n");
      out.write("                <h3 class=\"pagetitle\">Initialization</h3>\n");
      out.write("                <table>\n");
      out.write("                    <tfoot>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width:50%;border: 0px;background-color: #FFF;\" valign=\"top\">\n");
      out.write("                                <table id=\"courses\" class=\"initialization\">   \n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>Courses</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>\n");
      out.write("                                                <input type=\"text\" id=\"coursecode\" style=\"display:none;\"/>\n");
      out.write("                                                <input type=\"text\" id=\"coursename\" class=\"inputtext\" maxlength=\"100\" style=\"width: 100%;\"/>\n");
      out.write("                                            </th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>\n");
      out.write("                                                <input type=\"button\" id=\"submitcoursesI\" class=\"button\" value=\"Insert\" style=\"width: 49%;\"/>\n");
      out.write("                                                <input type=\"button\" id=\"submitcoursesU\" class=\"button\" value=\"Update\" style=\"width: 49%;display:none;\"/>\n");
      out.write("                                                <input type=\"button\" id=\"reset\" class=\"button reset\" value=\"Reset\" style=\"width: 49%;\"/>\n");
      out.write("                                                <span id=\"serverresponse1\" class=\"error\"></span>\n");
      out.write("                                            </th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>&nbsp;</td>\n");
      out.write("                                        </tr> \n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>   \n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <td style=\"width:50%;border: 0px;background-color: #FFF;\" valign=\"top\">\n");
      out.write("                                <table id=\"designations\" class=\"initialization\">   \n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>Designations</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>\n");
      out.write("                                                <input type=\"text\" id=\"designationcode\" style=\"display:none;\"/>\n");
      out.write("                                                <input type=\"text\" id=\"designationname\" class=\"inputtext\" maxlength=\"100\" style=\"width: 100%;\"/>\n");
      out.write("                                            </th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>\n");
      out.write("                                                <input type=\"button\" id=\"submitdesignationsI\" class=\"button\" value=\"Insert\" style=\"width: 49%;\"/>\n");
      out.write("                                                <input type=\"button\" id=\"submitdesignationsU\" class=\"button\" value=\"Update\" style=\"width: 49%;display:none;\"/>\n");
      out.write("                                                <input type=\"button\" id=\"reset\" class=\"button reset\" value=\"Reset\" style=\"width: 49%;\"/>\n");
      out.write("                                                <span id=\"serverresponse2\" class=\"error\"></span>\n");
      out.write("                                            </th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>&nbsp;</td>\n");
      out.write("                                        </tr> \n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>   \n");
      out.write("                            </td>\n");
      out.write("                            <td style=\"width:50%;border: 0px;background-color: #FFF;\"  valign=\"top\">\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width:50%;border: 0px;background-color: #FFF;\" valign=\"top\">\n");
      out.write("                                <table id=\"enclosures\" class=\"initialization\">   \n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>Enclosures</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>\n");
      out.write("                                                <input type=\"text\" id=\"enclosurecode\" style=\"display:none;\"/>\n");
      out.write("                                                <input type=\"text\" id=\"enclosurename\" class=\"inputtext\" maxlength=\"100\" style=\"width: 100%;\"/>\n");
      out.write("                                            </th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>\n");
      out.write("                                                <input type=\"button\" id=\"submitenclosuresI\" class=\"button\" value=\"Insert\" style=\"width: 49%;\"/>\n");
      out.write("                                                <input type=\"button\" id=\"submitenclosuresU\" class=\"button\" value=\"Update\" style=\"width: 49%;display:none;\"/>\n");
      out.write("                                                <input type=\"button\" id=\"reset\" class=\"button reset\" value=\"Reset\" style=\"width: 49%;\"/>\n");
      out.write("                                                <span id=\"serverresponse3\" class=\"error\"></span>\n");
      out.write("                                            </th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>&nbsp;</td>\n");
      out.write("                                        </tr> \n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>   \n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <td style=\"width:50%;border: 0px;background-color: #FFF;\" valign=\"top\">\n");
      out.write("                                <table id=\"leavecategories\" class=\"initialization\">   \n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>Leave Categories</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>\n");
      out.write("                                                <input type=\"text\" id=\"lccode\" style=\"display:none;\"/>\n");
      out.write("                                                <input type=\"text\" id=\"lcdescription\" class=\"inputtext\" maxlength=\"100\" style=\"width: 100%;\"/>\n");
      out.write("                                            </th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>\n");
      out.write("                                                <input type=\"button\" id=\"submitleavecategoriesI\" class=\"button\" value=\"Insert\" style=\"width: 49%;\"/>\n");
      out.write("                                                <input type=\"button\" id=\"submitleavecategoriesU\" class=\"button\" value=\"Update\" style=\"width: 49%;display:none;\"/>\n");
      out.write("                                                <input type=\"button\" id=\"reset\" class=\"button reset\" value=\"Reset\" style=\"width: 49%;\"/>\n");
      out.write("                                                <span id=\"serverresponse4\" class=\"error\"></span>\n");
      out.write("                                            </th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>&nbsp;</td>\n");
      out.write("                                        </tr> \n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>   \n");
      out.write("                            </td>\n");
      out.write("                            <td style=\"width:50%;border: 0px;background-color: #FFF;\"  valign=\"top\">\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width:50%;border: 0px;background-color: #FFF;\" valign=\"top\">\n");
      out.write("                                <table id=\"payscales\" class=\"initialization\">   \n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>Pay Scales</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>\n");
      out.write("                                                <input type=\"text\" id=\"payscalecode\" style=\"display:none;\"/>\n");
      out.write("                                                <input type=\"text\" id=\"payscaledescription\" class=\"inputtext\" maxlength=\"100\" style=\"width: 100%;\"/>\n");
      out.write("                                            </th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>\n");
      out.write("                                                <input type=\"button\" id=\"submitpayscalesI\" class=\"button\" value=\"Insert\" style=\"width: 49%;\"/>\n");
      out.write("                                                <input type=\"button\" id=\"submitpayscalesU\" class=\"button\" value=\"Update\" style=\"width: 49%;display:none;\"/>\n");
      out.write("                                                <input type=\"button\" id=\"reset\" class=\"button reset\" value=\"Reset\" style=\"width: 49%;\"/>\n");
      out.write("                                                <span id=\"serverresponse5\" class=\"error\"></span>\n");
      out.write("                                            </th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>&nbsp;</td>\n");
      out.write("                                        </tr> \n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>   \n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <td style=\"width:50%;border: 0px;background-color: #FFF;\" valign=\"top\">\n");
      out.write("                                   <table id=\"designationpayscale\" class=\"initialization\">   \n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th colspan=\"2\">Designation+Pay Scale</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th colspan=\"2\">\n");
      out.write("                                                <select id=\"designation\" name=\"designation\" class=\"select\" style=\"width: 100%\">\n");
      out.write("                                                    <option value=\"\">-</option>\n");
      out.write("                                                 </select>                                                  \n");
      out.write("                                            </th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th colspan=\"2\">\n");
      out.write("                                                <select id=\"payscale\" name=\"payscale\" class=\"select\" style=\"width: 100%\">\n");
      out.write("                                                    <option value=\"\">-</option>\n");
      out.write("                                                 </select>                                                   \n");
      out.write("                                            </th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th colspan=\"2\">                                                \n");
      out.write("                                                <input type=\"text\" id=\"despaycode\" style=\"display:none;\"/>\n");
      out.write("                                                <input type=\"button\" id=\"submitpaysdesI\" class=\"button\" value=\"Insert\" style=\"width: 49%;\"/>\n");
      out.write("                                                <input type=\"button\" id=\"submitpaysdesU\" class=\"button\" value=\"Update\" style=\"width: 49%;display:none;\"/>\n");
      out.write("                                                <input type=\"button\" id=\"reset\" class=\"button reset\" value=\"Reset\" style=\"width: 49%;\"/>\n");
      out.write("                                                <span id=\"serverresponse7\" class=\"error\"></span>\n");
      out.write("                                            </th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th style=\"width: 40%;\">Designation</th>\n");
      out.write("                                            <th>Pay Scale</th>\n");
      out.write("                                        </tr>                                        \n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>&nbsp;</td>\n");
      out.write("                                            <td>&nbsp;</td> \n");
      out.write("                                        </tr> \n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                            </td>\n");
      out.write("                            \n");
      out.write("                            <td style=\"width:50%;border: 0px;background-color: #FFF;\"  valign=\"top\">\n");
      out.write("                            </td>   \n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                    </tfoot>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"footer\" class=\"conts\">\n");
      out.write("            ");
      out.write("<img id=\"banner\" src=\"scripts/application/css/images/issts-product_1.png\"/>\r\n");
      out.write("<span id=\"bannertext\">Copyright@fostai</span>");
      out.write(" \n");
      out.write("        </div>\t\t\t\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
