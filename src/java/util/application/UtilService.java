package util.application;

import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;

public class UtilService {

    private final UtilDao daoUtil = new UtilDao();
    private final UtilDomain domainUtil = new UtilDomain();

    public int getNextValue(final String sql){        
        return daoUtil.getNextValue(sql);
    } 
    public boolean checkFieleExist(final String sql) {
        return daoUtil.checkFieleExist(sql);
    }  
    public JSONArray listData(final String sql) {
        return daoUtil.listData(sql);
    }
    
    public void generateReport(HttpServletResponse response,String reportname,HashMap params) {
        daoUtil.generatePDF(response, reportname, params);
    }
    
    public void generateElcex(HttpServletResponse response,String reportname,String excelpath,HashMap params)  {
        daoUtil.generateElcex(response, reportname, excelpath, params);
    }
    public int getNextUsercode(){
        String sql="SELECT MAX (usercode)AS slno FROM fostai.m_userlogin";
        return this.getNextValue(sql);
    }
    public boolean checkUserEmailExist(String useremail){
        String sql = "SELECT COUNT(*) AS count FROM fostai.m_userlogin WHERE useremail='"+useremail+"'";
        return this.checkFieleExist(sql);
    }
    public boolean checkUserMobileExist(String usermobile){
    String sql = "SELECT COUNT (*) AS count FROM fostai.m_userlogin WHERE usermobile='"+usermobile+"'";
    return this.checkFieleExist(sql); 
    }
    
    public JSONArray listMCourses() {
        String sql = "SELECT coursecode AS key,coursename AS value FROM fostai.m_courses";
        return this.listData(sql);
    }
      
    public JSONArray listUsers(){
     String sql="SELECT U.usercode, userfname,userlname, TO_CHAR(userdob,'YYYY-MM-DD') AS userdob, usergender, usermobile, useremail, userstatus,userphotograph, "               
               +"ARRAY_TO_STRING  "
               +"(  "
               +"	ARRAY(  "
               +"		SELECT P.processcode FROM fostai.mp_userprocesses UP  "
               +"		INNER JOIN fostai.m_processes P ON P.processcode=UP.processcode  "
               +"		WHERE UP.usercode=U.usercode ORDER BY U.usercode "
               +"	), ','  "
               +") AS processcodes, "
               +"ARRAY_TO_STRING  "
               +"(  "
               +"	ARRAY(  "
               +"		SELECT P.processname FROM fostai.mp_userprocesses UP  "
               +"		INNER JOIN fostai.m_processes P ON P.processcode=UP.processcode  "
               +"		WHERE UP.usercode=U.usercode ORDER BY U.usercode "
               +"	), ','  "
               +") AS processnames "                    
               +"FROM fostai.m_userlogin U  "
               +"WHERE U.userrole='U' ";                
        return this.listData(sql);
    }
   
     public JSONArray listUserprocesses(Integer usercode) {        
        String sql="SELECT P.processcode,P.processname,X.usercode FROM fostai.m_processes P "               
               +"LEFT OUTER JOIN "
               +"( "
               +"  SELECT P.processcode,UP.usercode FROM fostai.m_processes P "
               +"  INNER JOIN fostai.mp_userprocesses UP ON UP.processcode=P.processcode "
               +"  WHERE UP.usercode= "+usercode+" "
               +") X ON X.processcode=P.processcode "                 
               +"ORDER BY P.processcode ";                             
        return this.listData(sql);
    }
  public boolean updateUserstatus(final Integer usercode,final String userstatus){
        return this.updateUserstatus(usercode, userstatus);
    }

   public JSONArray listCourses() {
       String sql = "SELECT coursecode AS key,coursename AS value FROM fostai.m_courses T ";
       return this.listData(sql);
    }   
    public JSONArray listDesignations() {
        String sql = "SELECT designationcode AS key,designationname AS value FROM fostai.m_designations T ";
        return this.listData(sql);
    }
    
    public JSONArray listEnclosures() {
        String sql = "SELECT enclosurecode AS key,enclosurename AS value FROM fostai.m_enclosures T ";
        return this.listData(sql);
    }
    public JSONArray listLeavecategories() {
        String sql = "SELECT lccode AS key,lcdescription AS value FROM fostai.m_leavecategories T ";
        return this.listData(sql);
    }
    public JSONArray listPayscales() {
        String sql = "SELECT payscalecode AS key,payscaledescription AS value FROM fostai.m_payscales T ";
        return this.listData(sql);
    }
    public JSONArray listLeave() {
        String sql = "SELECT lccode AS key,lcdescription AS value FROM fostai.m_leavecategories T ";
        return this.listData(sql);
    }
    public JSONArray listDesPay() {
        String sql = "SELECT DP.despaycode,DP.designationcode,DP.payscalecode,designationname,payscaledescription FROM fostai.mp_designationpayscale DP "
                   + "INNER JOIN fostai.m_designations D ON D.designationcode=DP.designationcode "
                   + "INNER JOIN fostai.m_payscales P ON P.payscalecode=DP.payscalecode ";
        return this.listData(sql);
    }
    
    public JSONArray listMDesignations() {
        String sql = "SELECT designationcode AS key,designationname AS value FROM fostai.m_designations T ";
        return this.listData(sql);
    }
            
    public int getNextCoursecode(){        
        String sql = "SELECT MAX(coursecode) AS slno FROM fostai.m_courses";
        return this.getNextValue(sql);
    }      
    public int getNextDesignationcode(){        
        String sql = "SELECT MAX(designationcode) AS slno FROM fostai.m_designations";
        return this.getNextValue(sql);
    } 
    public int getNextEnclosurecode(){        
       String sql = "SELECT MAX(enclosurecode) AS slno FROM fostai.m_enclosures";
       return this.getNextValue(sql);
    }  
    public int getNextLeavecategoriescode(){        
       String sql = "SELECT MAX(lccode) AS slno FROM fostai.m_leavecategories";
       return this.getNextValue(sql);
    }  
    public int getNextPayscalecode(){        
        String sql = "SELECT MAX(payscalecode) AS slno FROM fostai.m_payscales";
       return this.getNextValue(sql);
    } 
      public int getNextPayscales(){        
        String sql = "SELECT MAX(payscalecode) AS slno FROM fostai.mp_designationpayscale";
       return this.getNextValue(sql);
    }  
     public int getNextDesignation(){        
        String sql = "SELECT MAX(designationcode) AS slno FROM fostai.mp_designationpayscale";
       return this.getNextValue(sql);
    }  
     public int getNextDespayscode(){        
        String sql = "SELECT MAX(despaycode) AS slno FROM fostai.mp_designationpayscale";
       return this.getNextValue(sql);
    }
      public int getNextEmpcode(){        
        String sql = "SELECT MAX(empcode) AS slno FROM fostai.t_empdetails";
        return this.getNextValue(sql);
    }
      public int getNextLeaveSlno(){        
        String sql = "SELECT MAX(slno) AS slno FROM fostai.t_leaves";
        return this.getNextValue(sql);
    }
      public int getNextSalarySlno(){        
        String sql = "SELECT MAX(slno) AS slno FROM fostai.t_salary";
        return this.getNextValue(sql);
    }
      public JSONArray listUserprocessesMenu(Integer usercode){
        String sql="SELECT processname,pageurl FROM fostai.m_processes P "               
                   +"INNER JOIN fostai.mp_userprocesses MP ON MP.processcode = P.processcode "               
                   +"WHERE MP.usercode= "+usercode+" "               
                   +"ORDER BY P.processcode ";                             
        return this.listData(sql);
      }
       public JSONArray viewEmployee(){
String sql="SELECT E.empcode,fname,lname, TO_CHAR(dob,'YYYY-MM-DD') AS dob, "
             + "fathersname,empemail,mobile,COALESCE(designationname,'') AS designationname FROM fostai.t_empdetails E "
             + "LEFT OUTER JOIN fostai.t_empdesignations DE ON DE.empcode=E.empcode AND DE.ispresent='Y'"
             + "LEFT OUTER JOIN fostai.m_designations D ON D.designationcode=DE.designationcode "
             + "ORDER BY empcode";      
        System.out.println("hgh : "+this.listData(sql));
        return this.listData(sql);
    }
      public JSONArray loadLeaves(Integer empcode){
         String sql= "SELECT T.slno,M.lcdescription,fromdate || '' AS fromdate,todate || '' AS todate,TO_CHAR(entrydate,'yyyy-MM-dd') AS entrydate,  "
                 + "CASE WHEN T.appstatus='P' THEN 'Pending' WHEN T.appstatus='A' THEN 'Approved' WHEN T.appstatus='R' THEN 'Rejected' END As appstatus,"
                 + "description FROM fostai.t_leaves T "
                 + "INNER JOIN fostai.m_leavecategories M ON M.lccode = T.lccode "
                 + "WHERE T.empcode="+empcode+" "
                 + "ORDER BY entrydate DESC  ";
                            
      return this.listData(sql);
      } 
      public JSONArray leaveProcess(){
         String sql= "SELECT T.slno,M.lcdescription,fromdate || '' AS fromdate,todate || '' AS todate,TO_CHAR(entrydate,'yyyy-MM-dd') AS entrydate,  "
                 + "CASE WHEN T.appstatus='P' THEN 'Pending' WHEN T.appstatus='A' THEN 'Approved' WHEN T.appstatus='R' THEN 'Rejected' END As appstatus,"
                 + "description FROM fostai.t_leaves T "
                 + "INNER JOIN fostai.m_leavecategories M ON M.lccode = T.lccode "
                 + "WHERE appstatus='P' "
                 + "ORDER BY entrydate DESC  ";
                            
      return this.listData(sql);
      } 
      public JSONArray salaryPending(Integer foryear, Integer formonth){
            String sql = "SELECT E.empcode,fname || CASE WHEN mname IS NULL OR mname='' THEN '' ELSE ' ' || mname END || ' ' || lname AS fullname,D.designationname,P.payscaledescription "
                    + "FROM fostai.t_empdetails E "
                    + "INNER JOIN fostai.m_designations D ON D.designationcode=E.designationcode "
                    + "INNER JOIN fostai.mp_designationpayscale DP ON DP.designationcode=D.designationcode "
                    + "INNER JOIN fostai.m_payscales P ON  P.payscalecode=DP.payscalecode "                    
                    + "WHERE E.empcode NOT IN (SELECT S.empcode FROM fostai.t_salary S WHERE S.foryear= "+foryear+" AND S.formonth ="+formonth+" ) ";
      return this.listData(sql);
      } 
      public JSONArray salaryProcessed(Integer foryear, Integer formonth){
            String sql = "SELECT E.empcode,fname || CASE WHEN mname IS NULL OR mname='' THEN '' ELSE ' ' || mname END || ' ' || lname AS fullname,D.designationname,P.payscaledescription "
                    + "FROM fostai.t_empdetails E "
                    + "INNER JOIN fostai.m_designations D ON D.designationcode=E.designationcode "
                    + "INNER JOIN fostai.mp_designationpayscale DP ON DP.designationcode=D.designationcode "
                    + "INNER JOIN fostai.m_payscales P ON  P.payscalecode=DP.payscalecode "                    
                    + "WHERE E.empcode IN (SELECT S.empcode FROM fostai.t_salary S WHERE S.foryear= "+foryear+" AND S.formonth ="+formonth+" ) ";
      return this.listData(sql);
      } 
      public JSONArray vewSalary(Integer empcode){
            String sql = "SELECT DISTINCT slno,empcode,basic,ta,da,hra,(basic+ta+da+hra) AS total,foryear,CASE WHEN S.formonth=1 THEN 'January' WHEN S.formonth=2 THEN 'Feburary' WHEN S.formonth=3 THEN 'March' WHEN S.formonth=4 THEN 'April'  WHEN S.formonth=5 THEN 'May' WHEN S.formonth=6 THEN 'June' WHEN S.formonth=7 THEN 'July'  WHEN S.formonth=8 THEN 'August' WHEN S.formonth=9 THEN 'September' WHEN S.formonth=10 THEN 'October'  WHEN S.formonth=11 THEN 'November' WHEN S.formonth=12 THEN 'December' END AS month,S.formonth,TO_CHAR(entrydate,'YYYY-MM-DD') AS entrydate FROM fostai.t_salary S "                    
                    + "WHERE S.empcode="+empcode+" ";
      return this.listData(sql);
      } 
     
      
}
