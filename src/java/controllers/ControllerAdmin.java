package controllers;

import isstslibs.Convertor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import services.ServiceAdmin;
import util.application.UtilService;

public class ControllerAdmin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        UtilService utilService = new UtilService();
        JSONObject obj = new JSONObject();
        System.out.println("start");
        try {
            String data;
            String returnvalue = "0";
            ServiceAdmin serviceAdmin = new ServiceAdmin();
            JSONParser parser = new JSONParser();
            System.out.println("start");
            JSONObject jSONObject = new JSONObject();

            int option = Integer.valueOf(request.getParameter("option").trim());
            System.out.println("start");
            Integer usercode = (Integer) request.getSession().getAttribute("session_usercode");
            String session_ur = (String) request.getSession().getAttribute("session_userrole");
            System.out.println("start");
            System.out.println("option: " + option);
            switch (option) {
                case 1:
                    String userpassword = request.getParameter("userpassword").trim();
                    returnvalue = (serviceAdmin.changePassword(usercode, userpassword,session_ur)) ? "1" : "0";
                    break;
                case 2:
                    String photograph = request.getParameter("userphotograph").trim();
                    byte[] ph = Convertor.convertToByte(photograph);
                    returnvalue = (serviceAdmin.changePhotograph(usercode, ph,session_ur)) ? "1" : "0";
                    if (returnvalue.equals("1")) {
                        request.getSession().setAttribute("session_userphotograph", Convertor.convertToImageString(ph));
                    }
                    break;
                case 3:
                    String userloginS = request.getParameter("userlogin").trim();
                    JSONObject studentO = (JSONObject) parser.parse(userloginS);
                    studentO.put("usercode", usercode);
                    returnvalue = (serviceAdmin.changeProfile(studentO)) ? "1" : "0";
                    if (returnvalue.equals("1")) {
                        request.getSession().setAttribute("session_userfname", studentO.get("userfname"));
                        request.getSession().setAttribute("session_userlname", studentO.get("userlname"));
                        request.getSession().setAttribute("session_usergender", studentO.get("usergender"));
                        request.getSession().setAttribute("session_userdob", studentO.get("userdob"));
                        request.getSession().setAttribute("session_usermobile", studentO.get("usermobile"));
                        request.getSession().setAttribute("session_username", studentO.get("userfname") + " " + studentO.get("userlname"));

                    }
                    break;
            case 4:data = request.getParameter("userlogin").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       String userrole = (String)request.getSession().getAttribute("session_userrole");
                       if(userrole.equals("A")){
                           obj.put("userrole", "U");
                       }
                       
                       if(utilService.checkUserEmailExist((String)obj.get("useremail"))){
                           returnvalue="2";
                       }else if(utilService.checkUserMobileExist((String)obj.get("usermobile"))){
                           returnvalue="3";
                       }else{
                           returnvalue = (serviceAdmin.createUser(obj))?"1":"0";
                       }
                       break;
               
                case 6: 
                    usercode=Integer.parseInt(request.getParameter("usercode").trim());
                    userpassword = request.getParameter("userpassword").trim();
                    returnvalue = serviceAdmin.resetPassword(usercode,userpassword)+"";
                    break;
                case 7: 
                    usercode=Integer.parseInt(request.getParameter("usercode").trim());
                    String userstatus = request.getParameter("userstatus").trim();
                    returnvalue = serviceAdmin.updateUserstatus(usercode,userstatus)+"";
                    break;
                 case 8:data = request.getParameter("data").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       returnvalue = (serviceAdmin.insertCourses(obj))?"1":"0";
                       break;                    
                case 9:data = request.getParameter("data").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       returnvalue = (serviceAdmin.updateCourses(obj))?"1":"0";
                       break;
                case 10: Integer ucode = Integer.valueOf(request.getParameter("usercode").trim());
                       userstatus = request.getParameter("userstatus").trim();
                       userstatus= (userstatus.equals("Y"))?"N":"Y";
                       returnvalue = (serviceAdmin.updateUserstatus(ucode, userstatus))?"1":"0";
                       break;
                case 11:data = request.getParameter("userlogin").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       returnvalue = (serviceAdmin.assignProcesses(obj))?"1":"0";
                       break; 
                case 12:data = request.getParameter("data").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       returnvalue = (serviceAdmin.insertCourses(obj))?"1":"0";
                       break;                    
                case 13:data = request.getParameter("data").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       returnvalue = (serviceAdmin.updateCourses(obj))?"1":"0";
                       break;
            
                case 14:data = request.getParameter("data").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       returnvalue = (serviceAdmin.insertDesignations(obj))?"1":"0";
                       break;                    
                case 15:data = request.getParameter("data").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       returnvalue = (serviceAdmin.updateDesignations(obj))?"1":"0";
                       break;
                case 16:data = request.getParameter("data").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       returnvalue = (serviceAdmin.insertEnclosures(obj))?"1":"0";
                       break;                    
                case 17:data = request.getParameter("data").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       returnvalue = (serviceAdmin.updateEnclosures(obj))?"1":"0";
                       break;
                case 18:data = request.getParameter("data").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       returnvalue = (serviceAdmin.insertLeavecategories(obj))?"1":"0";
                       break;                    
                case 19:data = request.getParameter("data").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       returnvalue = (serviceAdmin.updateLeavecategories(obj))?"1":"0";
                       break;
                case 20:data = request.getParameter("data").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       returnvalue = (serviceAdmin.insertPayscales(obj))?"1":"0";
                       break;                    
                case 21:data = request.getParameter("data").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       returnvalue = (serviceAdmin.updatePaysacles(obj))?"1":"0";
                       break;
                case 22:data = request.getParameter("data").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       returnvalue = (serviceAdmin.insertDesPayscales(obj))?"1":"0";
                       break;
               case 23:data = request.getParameter("data").trim();                                     
                       obj = (JSONObject)parser.parse(data);   
                       returnvalue = (serviceAdmin.updatetDesPayscales(obj))?"1":"0";
                       break;
       
                default:
            }

            out.print(returnvalue);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nError in ControllerAdmin :" + e);
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
