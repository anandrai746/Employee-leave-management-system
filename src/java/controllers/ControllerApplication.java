
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
import services.ServiceApplication;
import util.application.UtilService;


public class ControllerApplication extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String returnvalue="0";
            ServiceApplication serviceApplication = new ServiceApplication();
            UtilService utilService = new UtilService();
            JSONParser parser = new JSONParser();
            JSONObject obj = new JSONObject();            
            int option = Integer.valueOf(request.getParameter("option").trim());
            Integer empcode = Integer.valueOf(request.getSession().getAttribute("session_usercode").toString());            
            System.out.println("option : "+option);
            switch (option)
            {
                
                case 1: String empdetails = request.getParameter("employee").trim();
                    obj = (JSONObject)parser.parse(empdetails);
                    System.out.println("1 cont");
                    returnvalue = (serviceApplication.saveEmployeeDetails(obj))?"1":"0";
                    break;              
                case 2: String leavedetails = request.getParameter("employee").trim();
                    obj = (JSONObject)parser.parse(leavedetails);
                    obj.put("empcode",empcode.toString());                    
                    returnvalue = (serviceApplication.leaveDetails(obj))?"1":"0";
                    break;
                case 3: String slno = request.getParameter("slno").trim();
                    String status = request.getParameter("status").trim();
                    returnvalue = (serviceApplication.apprej(slno,status))?"1":"0";
                    
               case 4: String processsalary = request.getParameter("salary").trim();
                    obj = (JSONObject)parser.parse(processsalary);
                    returnvalue = (serviceApplication.salaryProcess(obj))?"1":"0";
                    break;     
                default:
            }
            out.print(returnvalue);
        }catch(Exception e){
            e.printStackTrace();
            System.out.print("\nError in ControllerApplication :"+e);
        }
        finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
