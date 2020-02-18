package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class viewsalary_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Leave</title>\r\n");
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
      out.write(" \t        \r\n");
      out.write("        <script src=\"scripts/application/js/viewsalary.js\" type=\"text/javascript\" ></script> \r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"header\" class=\"conts\">\r\n");
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
      out.write("             \r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"body\" class=\"conts\" style=\"height: 2500px;\">\r\n");
      out.write("            <div id=\"left\">\r\n");
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
      out.write("    \r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"right\">\r\n");
      out.write("                <h3 class=\"pagetitle\">Salary Details</h3>\r\n");
      out.write("                <form id=\"viewsalary\" name=\"viewsalary\" method=\"POST\" action=\"\">\r\n");
      out.write("                   <table id=\"viewsalary\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th colspan=\"10\" style=\"padding: 5px;\">Salay</th>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th style=\"width:10%;padding:5px;\">SLNO.</th>\r\n");
      out.write("                                <th style=\"width:10%;padding:5px;\">For Year</th>\r\n");
      out.write("                                <th style=\"width:10%;padding:5px;\">For Month</th>\r\n");
      out.write("                                <th style=\"width:10%;padding:5px;\">Basic (Rs)</th>\r\n");
      out.write("                                <th style=\"width:10%;padding:5px;\">TA (Rs)</th>\r\n");
      out.write("                                <th style=\"width:10%;padding:5px;\">DA (Rs)</th>\r\n");
      out.write("                                <th style=\"width:10%;padding:5px;\">HRA (Rs)</th>\r\n");
      out.write("                                <th style=\"width:10%;padding:5px;\">Total (Rs)</th>\r\n");
      out.write("                                <th style=\"width:10%;padding:5px;\">Date</th>\r\n");
      out.write("                                <th style=\"width:10%;padding:5px;\">Action</th>\r\n");
      out.write("                            </tr>    \r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                            <tr><td colspan=\"10\"></td></tr>\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>  \r\n");
      out.write("\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\t\t\r\n");
      out.write("        <div id=\"footer\" class=\"conts\">\r\n");
      out.write("            ");
      out.write("<img id=\"banner\" src=\"scripts/application/css/images/issts-product_1.png\"/>\r\n");
      out.write("<span id=\"bannertext\">Copyright@fostai</span>");
      out.write(" \r\n");
      out.write("        </div>\t\t\t\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
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
