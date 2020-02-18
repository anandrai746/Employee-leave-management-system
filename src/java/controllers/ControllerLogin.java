
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import services.ServiceAdmin;
import util.application.UtilService;

public class ControllerLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServiceAdmin serviceAdmin = new ServiceAdmin();
        UtilService utilService = new UtilService();
        String menu="";
        try 
        {
            String usertype = request.getParameter("usertype").trim();
            String useremail = request.getParameter("useremail").trim();
            String userpassword = request.getParameter("userpassword").trim();
            JSONObject obj = serviceAdmin.checkLogin(useremail,userpassword,usertype);
            if(obj!=null){
                 request.getSession().setAttribute("session_usercode", obj.get("usercode"));
                 request.getSession().setAttribute("session_userrole", obj.get("userrole"));
                 request.getSession().setAttribute("session_useremail", obj.get("useremail"));
                 request.getSession().setAttribute("session_userfname", obj.get("userfname"));
                 request.getSession().setAttribute("session_userlname", obj.get("userlname"));
                 request.getSession().setAttribute("session_usergender", obj.get("usergender"));
                 request.getSession().setAttribute("session_userdob", obj.get("userdob"));
                 request.getSession().setAttribute("session_usermobile", obj.get("usermobile"));
                 request.getSession().setAttribute("session_username", obj.get("username"));
                 request.getSession().setAttribute("session_userphotograph", obj.get("userphotograph"));
                 if(obj.get("regunitno")!=null){
                     request.getSession().setAttribute("session_regunitno", obj.get("regunitno"));
                 }
                 if(obj.get("userrole").equals("U"))
                 {
                    JSONArray up = utilService.listUserprocessesMenu((Integer)obj.get("usercode"));
                    for(int i=0;i<up.size();i++){                    
                        JSONObject rw = (JSONObject) up.get(i);
                        menu+="<li><a href='"+rw.get("pageurl")+"' >"+rw.get("processname")+"</a></li>";
                    }
                    System.out.println("menu : "+menu);
                    request.getSession().setAttribute("session_menu",menu);
                 }
                response.sendRedirect("home.jsp");
            }else{
                response.sendRedirect("loginfailed.jsp");
            }
             
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("\nError in ControllerLogin :"+e);
        } finally {            
            out.close();
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
