
package util.common;

import isstslibs.DbConnection;
import isstslibs.GenerateReport;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.application.UtilService;

public class ControllerReports extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessionHttp = request.getSession();
        PrintWriter out = null;
        try 
        {                       
            HashMap params = new HashMap(); 
            ArrayList al = new ArrayList();
            UtilService serviceUtil = new UtilService();
            String reportName = "";            
            String servletContext = getServletContext().getRealPath("/");            
            String reportDirectory = servletContext + "reports/";  
            String logoPath = reportDirectory+"logo.png";
            String reportPath = reportDirectory + "report.xls";
            params.put("logoPath", logoPath);                  
            params.put("SUBREPORT_DIR", reportDirectory);      
            Integer option = Integer.valueOf(request.getParameter("option").trim());
            String type = (request.getParameter("type")==null)?"p":request.getParameter("type").trim();
            
            //===================================================//
            
            switch(option)
            {
                case 1: 
                    reportName = reportDirectory + "empdetails.jrxml";
                    Integer empcode= Integer.parseInt(request.getParameter("empcode").trim());
//                    al.add(empcode);
                    params.put("empcode", empcode);
                    
                    break;
                case 2:   
                    reportName = reportDirectory + "salary.jrxml";
                    empcode= Integer.parseInt(request.getParameter("empcode").trim());
                    Short foryear= Short.valueOf(request.getParameter("foryear").trim());
                    Short formonth= Short.valueOf(request.getParameter("formonth").trim());
//                    al.add(empcode);
                    params.put("empcode", empcode);                          
                    params.put("foryear", foryear);                          
                    params.put("formonth", formonth);                          
                    break;
                case 3:   
                    reportName = reportDirectory + "pendingsalary.jrxml";
                    Short foryearp= Short.valueOf(request.getParameter("foryear").trim());
                    Short formonthp= Short.valueOf(request.getParameter("formonth").trim());
//                    al.add(empcode);
                    params.put("foryear", foryearp);                          
                    params.put("formonth", formonthp);                          
                    break;
                    
                default:;
            }
            
                       
            //===================================================//
            if (type.equals("p")) {                
                serviceUtil.generateReport(response, reportName, params);
            }        
            if (type.equals("x")) {          
                serviceUtil.generateElcex(response, reportName,reportPath, params);            
                response.sendRedirect("reports/report.xls");                    
            }
 
        } catch (Exception e) {
            e.getStackTrace();
            out = response.getWriter();
            System.out.println("Error in " + this.getClass() + " at " + new java.util.Date() + " :: " + e);
        } finally {
            if (out != null) {out.close();}
        }
    }


    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
