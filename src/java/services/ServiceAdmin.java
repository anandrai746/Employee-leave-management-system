package services;

import daos.DaoAdmin;
import util.application.*;
import domains.DomainAdmin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ServiceAdmin {
    
    private final UtilService utilService = new UtilService();
    private final DaoAdmin daoAdmin = new DaoAdmin();
    private final DomainAdmin domainAdmin = new DomainAdmin();

    public JSONObject checkLogin(final String useremail,final String userpassword,final String usertype){
        
        return daoAdmin.checkLogin(useremail, userpassword,usertype);
    }    
    public boolean changePassword(final Integer usercode,final String userpassword,final String session_ur){
        return daoAdmin.changePassword(usercode, userpassword,session_ur);
    }    
    public boolean changePhotograph(final Integer usercode,final byte[] userphotograph,final String session_ur){
        return daoAdmin.changePhotograph(usercode, userphotograph,session_ur);
    }    
    public boolean changeProfile(final JSONObject userlogin) {
        return daoAdmin.changeProfile(userlogin);
    }    
    public boolean createUser(final JSONObject userlogin) {
        Integer usercode = utilService.getNextUsercode();
        userlogin.put("usercode", usercode);
        return daoAdmin.createUser(userlogin);
    } 
      
    public int resetPassword(int usercode,String userpassword){
        return daoAdmin.resetPassword(usercode,userpassword);
    }
    
      public boolean updateUserstatus(final Integer usercode,final String userstatus){
        return daoAdmin.updateUserstatus(usercode, userstatus);
    }
       public boolean assignProcesses(final JSONObject userlogin) {
        return daoAdmin.assignProcesses(userlogin);
    }

   
  
    public boolean insertCourses(final JSONObject data) {
        Integer coursecode = utilService.getNextCoursecode();
        data.put("coursecode", coursecode.toString());
        return daoAdmin.insertCourses(data);        
    }
    public boolean updateCourses(final JSONObject data) {
        return daoAdmin.updateCourses(data);        
    } 
     public boolean insertDesignations(final JSONObject data) {
        Integer designationcode = utilService.getNextDesignationcode();
        data.put("designationcode", designationcode.toString());
        return daoAdmin.insertDesignations(data);        
    }
    public boolean updateDesignations(final JSONObject data) {
        return daoAdmin.updateDesignations(data);        
    } 
    public boolean insertEnclosures(final JSONObject data) {
        Integer enclosurecode = utilService.getNextEnclosurecode();
        data.put("enclosurecode", enclosurecode.toString());
        return daoAdmin.insertEnclosures(data);        
    }
    public boolean updateEnclosures(final JSONObject data) {
        return daoAdmin.updateEnclosures(data);        
    } 
     public boolean insertLeavecategories(final JSONObject data) {
       Integer lccode = utilService.getNextLeavecategoriescode();
        data.put("lccode", lccode.toString());
        return daoAdmin.insertLeavecategories(data);        
    }
    public boolean updateLeavecategories(final JSONObject data) {
        return daoAdmin.updateLeavecategories(data);        
    } 
     public boolean insertPayscales(final JSONObject data) {
        Integer payscalecode = utilService.getNextPayscalecode();
        data.put("payscalecode", payscalecode.toString());
        return daoAdmin.insertPayscales(data);        
    }
    public boolean updatePaysacles(final JSONObject data) {
       return daoAdmin.updatePayscales(data);        
    }
    public boolean insertDesPayscales(final JSONObject data) {
        Integer despaycode = utilService.getNextDespayscode();
        data.put("despaycode", despaycode.toString());        
        return daoAdmin.insertDesPayscales(data);        
    }
      public boolean updatetDesPayscales(final JSONObject data) {
       return daoAdmin.updatetDesPayscales(data);        
    }
}
