package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/headerfiles.jsp");
    _jspx_dependants.add("/header.jsp");
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
      out.write("        <title>Login</title>\n");
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
      out.write("        <script src=\"scripts/application/js/login.js\" type=\"text/javascript\" ></script>\n");
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
      out.write("        <div id=\"body\" class=\"conts\">            \n");
      out.write("            <div id=\"loginContant\">\n");
      out.write("                <h3><center>Welcome to Fostai</center></h3>\n");
      out.write("                <form id=\"loginForm\" name=\"loginForm\" method=\"POST\" action=\"ControllerLogin\">\n");
      out.write("                    <table>\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th colspan=\"2\"><center>Login</center></th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td style=\"width: 30%\">\n");
      out.write("                                    <label>User Type</label><span class=\"mandatory\">*</span>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <select id=\"usertype\" name=\"usertype\" class=\"select\">\n");
      out.write("                                        <option value=\"\">-</option>\n");
      out.write("                                        <option value=\"A\">Admin</option>\n");
      out.write("                                        <option value=\"E\">Employee</option>\n");
      out.write("                                        <option value=\"U\">Office User</option>\n");
      out.write("                                    </select>\n");
      out.write("                                    <span id=\"usertypeMsg\" class=\"error\"></span>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td style=\"width: 30%\">\n");
      out.write("                                    <label>User Id</label><span class=\"mandatory\">*</span>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"text\" id=\"useremail\" name=\"useremail\" maxlength=\"50\" class=\"inputtext\"/>\n");
      out.write("                                    <span id=\"useremailMsg\" class=\"error\"></span>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <label>Password</label><span class=\"mandatory\">*</span>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"password\" id=\"userpassword\" name=\"userpassword\" maxlength=\"512\" class=\"inputtext\"/>\n");
      out.write("                                    <span id=\"userpasswordMsg\" class=\"error\"></span>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>&nbsp;</td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"button\" id=\"login\" value=\"Login\" class=\"button\"/>\n");
      out.write("                                    <input type=\"button\" id=\"reset\" value=\"reset\" class=\"button\"/>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                        <tfoot>\n");
      out.write("                            <tr>\n");
      out.write("                                <td colspan=\"2\">\n");
      out.write("                                    <div id=\"serverresponse\" class=\"error\"></div>&nbsp;\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tfoot>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\t\t\n");
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
