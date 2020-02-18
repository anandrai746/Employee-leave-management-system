
package util.application;

import isstslibs.Convertor;
import isstslibs.DbConnection;
import isstslibs.GenerateReport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;


public class UtilDao 
{    
    private String sql = "";    
    private ResultSet rs = null;
    private Connection con = null;
    private PreparedStatement ps = null;   
    
    public int getNextValue(final String sql) 
    {
        int slno = 1;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {
                //sql = "SELECT MAX(" + fieldname + ") AS slno FROM " + tablename;
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    slno = rs.getInt("slno")+1;
                }
            }
        } catch (SQLException e) {            
            System.out.println("Error in UtilDao.getNextValue(String sql) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (rs != null) {rs.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.println("Error in UtilDao.getNextValue(String sql) : " + e);
            }
        }
        return slno;
    }    
    
    public boolean checkFieleExist(final String sql) 
    {
        boolean res = false;
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {
                //sql = "SELECT COUNT(*) AS count FROM " + tablename+" WHERE UPPER("+fieldname+")='"+fieldvalue.toUpperCase()+"'";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if(rs.next()){
                    res = (rs.getInt("count") != 0);
                }
            }
        } catch (SQLException e) {            
            System.out.println("Error in UtilDao.checkFieleExist(final String sql) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (rs != null) {rs.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.println("Error in UtilDao.checkFieleExist(final String sql) : " + e);
            }
        }
        return res;
    } 
        
    public JSONArray listData(final String sql) 
    {
        JSONArray jSONArray = new JSONArray();
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {                
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                jSONArray = Convertor.convertToJSON(rs);                
            }
        } catch (Exception e) {            
            System.out.println("Error in UtilDao.listData(sql) : " + e);
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (rs != null) {rs.close();}
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.println("Error in UtilDao.listData(sql) : " + e);
            }
        }
        return jSONArray;
    }
    
    public void generatePDF(HttpServletResponse response,String reportname,HashMap params) 
    {        
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {                            
                GenerateReport.generatePDF(con, params, reportname, response);
            }
        } catch (SQLException e) {            
            System.out.println("Error in UtilDao.generatePDF(HttpServletResponse response,String reportname,HashMap params) : " + e);
        } finally {
            try {
                params=null;
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.println("Error in UtilDao.generatePDF(HttpServletResponse response,String reportname,HashMap params) : " + e);
            }
        }        
    }    
    
    public void generateElcex(HttpServletResponse response,String reportname,String excelpath,HashMap params) 
    {        
        try 
        {
            con = DbConnection.getConnection();
            if (con != null) 
            {                            
                GenerateReport.generateElcex(con, params, reportname,excelpath, response);
            }
        } catch (SQLException e) {            
            System.out.println("Error in UtilDao.generateElcex(HttpServletResponse response,String reportname,String excelpath,HashMap params) : " + e);
        } finally {
            try {
                params=null;
                if (con != null) {con.close();}
            } catch (SQLException e) {
                System.out.println("Error in UtilDao.generateElcex(HttpServletResponse response,String reportname,String excelpath,HashMap params) : " + e);
            }
        }        
    }    
    
    
}
