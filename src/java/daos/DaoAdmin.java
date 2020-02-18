
package daos;

import isstslibs.Convertor;
import isstslibs.DbConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DaoAdmin 
{    
    private String sql = "";    
    private ResultSet rs = null;
    private Connection con = null;
    private PreparedStatement ps = null;   
    
    public JSONObject checkLogin(final String useremail,final String userpassword,final String usertype) 
    {
        JSONObject obj = null;
        try 
        {   
            con = DbConnection.getConnection();
            if (con != null) 
            {
                if(usertype.equals("E")){
                    sql = "SELECT empcode AS usercode,'E' AS userrole,empemail AS useremail,"
                        + "fname AS userfname,lname AS userlname,gender AS usergender,mobile AS usermobile,dob AS userdob,empphoto AS userphotograph  "
                        + "FROM fostai.t_empdetails L WHERE L.empemail=? AND L.emppassword=?";
                }else{
                    sql = "SELECT usercode,userrole,useremail,userfname,userlname,usergender,usermobile,userdob,userphotograph FROM fostai.m_userlogin L WHERE L.userstatus='Y' AND L.useremail=? AND L.userpassword=?";
                }
                ps=con.prepareStatement(sql);
                ps.setString(1, useremail);
                ps.setString(2, userpassword);
                rs=ps.executeQuery();                
                while(rs.next()){
                    obj = new JSONObject();
                    obj.put("usercode", rs.getInt("usercode"));
                    obj.put("userrole", rs.getString("userrole"));
                    obj.put("useremail", rs.getString("useremail"));
                    obj.put("userfname", rs.getString("userfname"));
                    obj.put("userlname", rs.getString("userlname"));
                    obj.put("usergender", rs.getString("usergender"));
                    obj.put("usermobile", rs.getString("usermobile"));
                    obj.put("userdob", rs.getString("userdob"));
                    
                    if(rs.getString("userrole").equals("A")){
                        obj.put("username", rs.getString("userfname"));
                    }else{
                        obj.put("username", rs.getString("userfname")+" "+rs.getString("userlname"));
                    }
                    
                    byte[] userphotograph = rs.getBytes("userphotograph");
                    if(userphotograph!=null){
                        obj.put("userphotograph",Convertor.convertToImageString(userphotograph));
                    }else if(rs.getString("usergender").equals("M")){
                        obj.put("userphotograph", "scripts/application/css/images/male.png");
                    }else{
                        obj.put("userphotograph", "scripts/application/css/images/female.png");
                    }
                }                
            }
        } catch (SQLException e) {
            System.out.print("Error in DaoAdmin.checkLogin(final String useremail,final String userpassword) : " + e);
        } finally {
            try {
                if (rs != null) {rs.close();}
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.print("Error in DaoAdmin.checkLogin(final String useremail,final String userpassword) : " + e);
            }
        }
        return obj;
    }     
    
    public boolean changePassword(final Integer usercode,final String userpassword,final String session_ur) 
    {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {
                if(session_ur.equals("E")){
                    sql = "UPDATE fostai.t_empdetails SET emppassword=? WHERE empcode=?";
                }else{
                    sql = "UPDATE fostai.m_userlogin SET userpassword=? WHERE usercode=?";
                }                
                ps = con.prepareStatement(sql);
                ps.setString(1,userpassword);
                ps.setInt(2,usercode);
                res = ps.executeUpdate() > 0;                
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.print("Error in DaoAdmin.changePassword(final Integer usercode,final String userpassword) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.print("Error in DaoAdmin.changePassword(final Integer usercode,final String userpassword) : " + e);
            }
        }
        return res;
    }     
    
    public boolean changePhotograph(final Integer usercode,final byte[] userphotograph,final String session_ur) 
    {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {
                if(session_ur.equals("E")){
                    sql = "UPDATE fostai.t_empdetails SET empphoto=? WHERE empcode=?";
                }else{
                    sql = "UPDATE fostai.m_userlogin SET userphotograph=? WHERE usercode=?";
                }                                
                
                ps = con.prepareStatement(sql);
                ps.setBytes(1,userphotograph);
                ps.setInt(2,usercode);
                res = ps.executeUpdate() > 0;                
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.print("Error in DaoAdmin.changePhotograph(final Integer usercode,final byte[] userphotograph) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.print("Error in DaoAdmin.changePhotograph(final Integer usercode,final byte[] userphotograph) : " + e);
            }
        }
        return res;
    }     
    
    public boolean changeProfile(final JSONObject userlogin) 
    {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {
                sql = "UPDATE fostai.m_userlogin SET userfname=?,userlname=?,userdob=?,usergender=?,usermobile=? WHERE usercode=?";
                ps = con.prepareStatement(sql);
                ps.setString(1,(String)userlogin.get("userfname"));
                ps.setString(2,(String)userlogin.get("userlname"));
                ps.setDate(3,Date.valueOf((String)userlogin.get("userdob")));
                ps.setString(4,(String)userlogin.get("usergender"));
                ps.setString(5,(String)userlogin.get("usermobile"));
                ps.setInt(6,(Integer)userlogin.get("usercode"));
                res = ps.executeUpdate() > 0;                
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.print("Error in DaoAdmin.changeProfile(final JSONObject userlogin) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.print("Error in DaoAdmin.changeProfile(final JSONObject userlogin) : " + e);
            }
        }
        return res;
    }
    
    public boolean createUser(final JSONObject userlogin) 
    {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {
                sql = "INSERT INTO fostai.m_userlogin(usercode, userfname, userlname, userdob, usergender, usermobile, "
                        + "useremail, userpassword, userrole, userstatus)"
                        + "values (?,?,?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1,(Integer)userlogin.get("usercode"));
                ps.setString(2,(String)userlogin.get("userfname"));
                ps.setString(3,(String)userlogin.get("userlname"));
                ps.setDate(4,Date.valueOf((String)userlogin.get("userdob")));
                ps.setString(5,(String)userlogin.get("usergender"));
                ps.setString(6,(String)userlogin.get("usermobile"));
                ps.setString(7,(String)userlogin.get("useremail"));
                ps.setString(8,(String)userlogin.get("userpassword"));
                ps.setString(9,(String)userlogin.get("userrole"));
                ps.setString(10,(String)userlogin.get("userstatus"));
                               
                res = ps.executeUpdate() > 0;  
                System.out.println("inside dao");
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.print("Error in DaoAdmin.changeProfile(final JSONObject userlogin) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.print("Error in DaoAdmin.changeProfile(final JSONObject userlogin) : " + e);
            }
        }
        System.out.println("res "+res);
        return res;
    }     
    public int resetPassword(int usercode,String userpassword) {
        int success=-1;
        try {
            con = DbConnection.getConnection();
            sql = "UPDATE m_userlogin SET userpassword=? WHERE usercode=? ";
            ps = con.prepareStatement(sql);
            ps.setString(1,userpassword);
            ps.setInt(2,usercode);
            success = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exceptiion in DaoAdmin.resetPassword(int usercode,String userpassword) : " + e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }                
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Exceptiion in DaoAdmin.resetPassword(int usercode,String userpassword) : " + e);
            }
        }
        System.out.println(success);
        return success;
    }
    public int userStatus(int usercode,String userstatus) {
        int success=-1;
        try {
            con = DbConnection.getConnection();
            sql = "UPDATE m_userlogin SET userpassword=? WHERE usercode=? ";
            ps = con.prepareStatement(sql);
            ps.setString(1,userstatus);
            ps.setInt(2,usercode);
            success = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exceptiion in DaoAdmin.resetPassword(int usercode,String userpassword) : " + e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }                
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Exceptiion in DaoAdmin.userstatus(int usercode,String userstatususerstatus) : " + e);
            }
        }
        System.out.println(success);
        return success;
    }
        
    public boolean assignProcesses(final JSONObject userlogin) 
    {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {
                JSONArray processes = (JSONArray) userlogin.get("processes");
                Integer usercode = Integer.valueOf((String)userlogin.get("usercode"));
                
                sql = "DELETE FROM fostai.mp_userprocesses WHERE usercode=? ";
                ps = con.prepareStatement(sql); 
                ps.setInt(1,usercode);
                res = ps.executeUpdate() >= 0;           
                if(processes.size()>0)
                {
                    if(res)
                    {
                        sql = "INSERT INTO fostai.mp_userprocesses(usercode,processcode) VALUES(?,?)";
                        ps = con.prepareStatement(sql);
                        for (Object p : processes) {
                            ps.setInt(1,usercode);
                            ps.setShort(2, Short.valueOf((String) p));                        
                            ps.addBatch();
                        }
                        res = ps.executeBatch().length >= 0;
                    }    
                }              
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoAdmin.assignProcesses(final JSONObject userlogin)  : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.println("Error in DaoAdmin.assignProcesses(final JSONObject userlogin) : " + e);
            }
        }
        return res;
    }
    
    public boolean updateUserstatus(final Integer usercode,final String userstatus) 
    {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {
                sql = "UPDATE fostai.m_userlogin SET userstatus=? WHERE usercode=?";
                ps = con.prepareStatement(sql);
                ps.setString(1,userstatus);
                ps.setInt(2,usercode);
                res = ps.executeUpdate() > 0;                
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoAdmin.updateUserstatus(final Integer usercode,final String userstatus) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.println("Error in DaoAdmin.updateUserstatus(final Integer usercode,final String userstatus) : " + e);
            }
        }
        return res;
    }
    public boolean insertCourses(final JSONObject data) {
       boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {
                sql = "INSERT INTO fostai.m_courses(coursecode,coursename) VALUES(?,?)";
                ps = con.prepareStatement(sql);
                ps.setShort(1,Short.valueOf((String)data.get("coursecode")));
                ps.setString(2,(String)data.get("coursename"));
                res = ps.executeUpdate() > 0;                
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoAdmin.insertCourses(final JSONObject data) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.println("Error in DaoAdmin.insertCourses(final JSONObject data) : " + e);
            }   
        }
        return res;
    }
     public boolean updateCourses(final JSONObject data) 
    {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {
                sql = "UPDATE fostai.m_courses SET coursename=? WHERE coursecode=?";
                ps = con.prepareStatement(sql);
                ps.setString(1,(String)data.get("coursename"));
                ps.setShort(2,Short.valueOf((String)data.get("coursecode")));
                res = ps.executeUpdate() > 0;                
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoAdmin.updateCourses(final JSONObject data) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.println("Error in DaoAdmin.updateCourses(final JSONObject data) : " + e);
            }
        } 
        return res;
    }
    
    public boolean insertDesignations(final JSONObject data) 
    {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {
                sql = "INSERT INTO fostai.m_designations(designationcode,designationname) VALUES(?,?)";
                ps = con.prepareStatement(sql);
                ps.setShort(1,Short.valueOf((String)data.get("designationcode")));
                ps.setString(2,(String)data.get("designationname"));
                res = ps.executeUpdate() > 0;                
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoAdmin.insertDesignations(final JSONObject data) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.println("Error in DaoAdmin.insertDesignations(final JSONObject data) : " + e);
            }
        }
        return res;
    }   
    
    public boolean updateDesignations(final JSONObject data) 
    {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {
                sql = "UPDATE fostai.m_designations SET designationname=? WHERE designationcode=?";
                ps = con.prepareStatement(sql);
                ps.setString(1,(String)data.get("designationname"));
                ps.setShort(2,Short.valueOf((String)data.get("designationcode")));
                res = ps.executeUpdate() > 0;                
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoAdmin.updateDesignations(final JSONObject data) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.println("Error in DaoAdmin.updateDesignations(final JSONObject data) : " + e);
            }
        }
        return res;
    }
    
    public boolean insertEnclosures(final JSONObject data) 
    {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
           if (con != null) 
            {
               sql = "INSERT INTO fostai.m_enclosures(enclosurecode,enclosurename) VALUES(?,?)";
                ps = con.prepareStatement(sql);
                ps.setShort(1,Short.valueOf((String)data.get("enclosurecode")));
                ps.setString(2,(String)data.get("enclosurename"));
                res = ps.executeUpdate() > 0;                
           }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoAdmin.insertEnclosures(final JSONObject data) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
               if (con != null) {con.close();}
           } catch (SQLException e) {
               System.out.println("Error in DaoAdmin.insertEnclosures(final JSONObject data) : " + e);
           }
        }
        return res;
   } 

    
    public boolean updateEnclosures(final JSONObject data) 
    {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {
                sql = "UPDATE fostai.m_enclosures SET enclosurename=? WHERE enclosurecode=?";
               ps = con.prepareStatement(sql);
               ps.setString(1,(String)data.get("enclosurename"));
               ps.setShort(2,Short.valueOf((String)data.get("enclosurecode")));
                res = ps.executeUpdate() > 0;                
            }
       } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoAdmin.updateEnclosures(final JSONObject data) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.println("Error in DaoAdmin.updateEnclosures(final JSONObject data) : " + e);
            }
        }
        return res;
    }
    
     public boolean insertLeavecategories(final JSONObject data) 
    {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {
                sql = "INSERT INTO fostai.m_leavecategories(lccode,lcdescription) VALUES(?,?)";
                ps = con.prepareStatement(sql);
                ps.setShort(1,Short.valueOf((String)data.get("lccode")));
                ps.setString(2,(String)data.get("lcdescription"));
                res = ps.executeUpdate() > 0;                
            }
       } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoAdmin.insertLeavecategories(final JSONObject data) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
           } catch (SQLException e) {
               System.out.println("Error in DaoAdmin.insertLeavecategories(final JSONObject data) : " + e);
            }
        }
        return res;
    }   
    
    public boolean updateLeavecategories(final JSONObject data) 
   {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
           {
               sql = "UPDATE fostai.m_leavecategories SET lcdescription=? WHERE lccode=?";
                ps = con.prepareStatement(sql);
                ps.setString(1,(String)data.get("lcdescription"));
               ps.setShort(2,Short.valueOf((String)data.get("lccode")));
                res = ps.executeUpdate() > 0;                
            }
        } catch (SQLException | NumberFormatException e) {
           System.out.println("Error in DaoAdmin.updateLeavecategories(final JSONObject data) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.println("Error in DaoAdmin.updateLeavecategories(final JSONObject data) : " + e);
            }
        }
        return res;
    }     
     public boolean insertPayscales(final JSONObject data) 
    {
       boolean res = false;
       try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
           {
                sql = "INSERT INTO fostai.m_payscales(payscalecode,payscaledescription) VALUES(?,?)";
                ps = con.prepareStatement(sql);
                ps.setShort(1,Short.valueOf((String)data.get("payscalecode")));
                ps.setString(2,(String)data.get("payscaledescription"));
                res = ps.executeUpdate() > 0;                
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoAdmin.insertPayscales(final JSONObject data) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.println("Error in DaoAdmin.insertPayscales(final JSONObject data) : " + e);
            }
        }
        return res;
    }   
    
    public boolean updatePayscales(final JSONObject data) 
    {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
           {
                sql = "UPDATE fostai.m_payscales SET payscaledescription=? WHERE payscalecode=?";
                ps = con.prepareStatement(sql);
                ps.setString(1,(String)data.get("payscaledescription"));
                ps.setShort(2,Short.valueOf((String)data.get("payscalecode")));
                res = ps.executeUpdate() > 0;                
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoAdmin.updatePayscales(final JSONObject data) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
           } catch (SQLException e) {
                System.out.println("Error in DaoAdmin.updatePayscales(final JSONObject data) : " + e);
           }
        }
        return res;
    }
 public boolean insertDesPayscales(final JSONObject data) 
    {
       boolean res = false;
       try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
           {
                sql = "INSERT INTO fostai.mp_designationpayscale(despaycode,payscalecode,designationcode) VALUES(?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setShort(1,Short.valueOf((String)data.get("despaycode")));
                ps.setShort(2,Short.valueOf((String)data.get("payscalecode")));
                ps.setShort(3,Short.valueOf((String)data.get("designationcode")));
                res = ps.executeUpdate() > 0;                
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoAdmin.insertDesPayscales(final JSONObject data) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.println("Error in DaoAdmin.insertDesPayscales(final JSONObject data) : " + e);
            }
        }
        return res;
    }
    public boolean updatetDesPayscales(final JSONObject data) 
    {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
           {
                sql = "UPDATE fostai.mp_designationpayscale SET designationcode=?,payscalecode=? WHERE despaycode=?";
                ps = con.prepareStatement(sql);
                ps.setShort(1,Short.valueOf((String)data.get("designationcode")));
                ps.setShort(2,Short.valueOf((String)data.get("payscalecode")));
                ps.setInt(3,Integer.valueOf((String)data.get("despaycode")));
                res = ps.executeUpdate() > 0;                
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoAdmin.updatetDesPayscales(final JSONObject data) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (con != null) {con.close();}
           } catch (SQLException e) {
                System.out.println("Error in DaoAdmin.updatetDesPayscales(final JSONObject data) : " + e);
           }
        }
        return res;
    }
}        

