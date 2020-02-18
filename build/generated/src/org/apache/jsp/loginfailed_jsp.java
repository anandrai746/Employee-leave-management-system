package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginfailed_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Login Failed</title>\n");
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
      out.write(" \t        \n");
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
      out.write("        <div id=\"body\" class=\"conts\">\n");
      out.write("            <div class=\"error\" style=\"margin: 0 auto;width: 80%\">                                  \n");
      out.write("                <h2>\n");
      out.write("                    <img src=\"scripts/application/css/images/error.gif\"/>\n");
      out.write("                    <br>\n");
      out.write("                    Unable to Login.\n");
      out.write("                    <br>\n");
      out.write("                    Please check your cadential.\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"button\" class=\"button\" value=\"Go back to the previous page\" onclick=\"history.back();\" style=\"width: 200px;\"/>\n");
      out.write("                </h2>\n");
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
