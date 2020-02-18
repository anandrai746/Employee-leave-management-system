
package util.application;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;


public class UtilController extends HttpServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject jSONObject = new JSONObject();
        UtilService serviceUtil = new UtilService();
        try 
        {
            int option = Integer.valueOf(request.getParameter("option").trim());  
            //System.out.println("option : "+option);
            //System.out.println("utilService.listMCastes() : "+utilService.listMCastes());
            switch (option) 
            {
                   case 1:jSONObject.put("listCourses", serviceUtil.listCourses());
                       jSONObject.put("listMCourses", serviceUtil.listMCourses());
                       jSONObject.put("listDesignations", serviceUtil.listDesignations());
                       jSONObject.put("listEnclosures", serviceUtil.listEnclosures());
                       jSONObject.put("listLeavecategories", serviceUtil.listLeavecategories());
                       jSONObject.put("listPayscales", serviceUtil.listPayscales());
                       jSONObject.put("listDesPay", serviceUtil.listDesPay());
                       jSONObject.put("listMDesignations", serviceUtil.listMDesignations());                      
                       break;            
                case 2:
                       jSONObject.put("listUsers", serviceUtil.listUsers());
                       System.out.println("jSONObject : "+jSONObject);
                       break;                
                case 3:Integer usercode = Integer.valueOf(request.getParameter("usercode").trim());
                       jSONObject.put("listUserprocesses", serviceUtil.listUserprocesses(usercode));
                       break;
                case 4:
                      System.out.println("option 2");
                      jSONObject.put("viewEmployee", serviceUtil.viewEmployee());
                      break;
                case 5:
                     jSONObject.put("listLeave", serviceUtil.listLeave());
                     break;
                case 6:
                     Integer empcode=Integer.valueOf(request.getSession().getAttribute("session_usercode").toString());
                     jSONObject.put("loadLeaves", serviceUtil.loadLeaves(empcode));
                     break;
                case 7:
                     jSONObject.put("leaveProcess", serviceUtil.leaveProcess());
                     break;
                case 8:
                     Integer foryear = Integer.valueOf(request.getParameter("foryear").trim());
                     Integer formonth = Integer.valueOf(request.getParameter("formonth").trim());
                     jSONObject.put("salaryPending", serviceUtil.salaryPending(foryear,formonth));
                     jSONObject.put("salaryProcessed", serviceUtil.salaryProcessed(foryear,formonth));
                     break;
                case 9:
                     empcode=Integer.valueOf(request.getSession().getAttribute("session_usercode").toString());
                     jSONObject.put("vewSalary", serviceUtil.vewSalary(empcode));
                     break;    
                default:                    
            }
            out.print(jSONObject);
        } catch (Exception e) {
            System.out.println("Error in servlet ControllerUtil : " + e);
        } finally {
            try {
                out.close();
                serviceUtil = null;
            } catch (Exception ex) {
                System.out.println("Error in servlet ControllerUtil : " + ex);
            }
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
