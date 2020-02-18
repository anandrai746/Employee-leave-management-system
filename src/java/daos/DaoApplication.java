
package daos;

import isstslibs.DbConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DaoApplication 
{    
    private String sql = "";    
    private ResultSet rs = null;
    private Connection con = null;
    private PreparedStatement ps = null;   
    
     public boolean saveEmployeeDetails(final JSONObject employee) {
        boolean res = false;
        try {
            System.out.println("employee : "+employee);
            con = DbConnection.getConnection();
            con.setAutoCommit(false);
            if (con != null) {
                sql = "INSERT INTO fostai.t_empdetails(empcode,fname,mname,lname,dob,empemail,mobile,emppassword,gender,bloodgroup,fathersname,preaddress,prepin,peraddress,perpin,panno,epicid,adharno,drivinglicenceno,passportno,designationcode) "
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
                ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.valueOf((String) employee.get("empcode")));
                ps.setString(2, (String) employee.get("fname"));
                ps.setString(3, (String) employee.get("mname"));
                ps.setString(4, (String) employee.get("lname"));
                ps.setDate(5, Date.valueOf((String) employee.get("dob")));
                ps.setString(6, (String) employee.get("empemail"));     
                ps.setString(7, (String) employee.get("mobile"));
                ps.setString(8, (String) employee.get("emppassword"));
                ps.setString(9, (String) employee.get("gender"));
                ps.setString(10, (String) employee.get("bloodgroup"));
                ps.setString(11, (String) employee.get("fathersname"));
                ps.setString(12, (String) employee.get("preaddress"));
                ps.setString(13, (String) employee.get("prepin"));
                ps.setString(14, (String) employee.get("peraddress"));
                ps.setString(15, (String) employee.get("perpin"));
                ps.setString(16, (String) employee.get("panno"));
                ps.setString(17, (String) employee.get("epicid"));
                ps.setString(18, (String) employee.get("adharno"));
                ps.setString(19, (String) employee.get("drivinglicenceno"));
                ps.setString(20, (String) employee.get("passportno"));
                ps.setShort(21, Short.valueOf((String) employee.get("designationcode")));
                res = ps.executeUpdate() > 0;
                System.out.println("end of first");
                if (res) {
                    sql = "INSERT INTO fostai.t_empedudetails(empcode,coursecode,institute,passingyear,percentage,division)"
                            + " VALUES (?,?,?,?,?,?) ";
                    ps = con.prepareStatement(sql);
                    JSONArray coursearr = (JSONArray) employee.get("coursecode");
                    JSONArray institutearr = (JSONArray) employee.get("institute");
                    JSONArray passingyeararr = (JSONArray) employee.get("passingyear");
                    JSONArray percentagearr = (JSONArray) employee.get("percentage");
                    JSONArray divisionarr = (JSONArray) employee.get("division");
                    System.out.println("end of array");
                    for (int i = 0; i < coursearr.size(); i++) {
                        ps.setInt(1, Integer.valueOf((String) employee.get("empcode")));
                        ps.setShort(2, Short.valueOf((String) coursearr.get(i)));
                        ps.setString(3, (String) institutearr.get(i));
                        ps.setShort(4, Short.valueOf((String) passingyeararr.get(i)));
                        ps.setDouble(5, Double.parseDouble((String) percentagearr.get(i)));
                        ps.setString(6, (String) divisionarr.get(i));
//                    ps.setBinaryStream(7, null);
//                    ps.setBinaryStream(8, null);
                        ps.addBatch();
                    }
                    System.out.println("Here");
                    int[] ress = ps.executeBatch(); 
                    res = ress.length > 0;
                }
             if(res){
                    con.commit();
                }else{
                    con.rollback();
                }
            }
        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Error in DaoApplication.saveEmployeeDetails(final JSONObject employeedetails) : " + e);
            e.printStackTrace();
        } finally {
            try {
                System.out.println("setautocommit");
                con.setAutoCommit(true);
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error in DaoApplication.saveEmployeeDetails(final JSONObject employeedetails) : " + e);
            }
        }
        return res;
    }

     public boolean leaveDetails(final JSONObject employee) {
        boolean res = false;
        try {
            System.out.println("");
            con = DbConnection.getConnection();
            if (con != null) {
                
                sql = "INSERT INTO fostai.t_leaves(slno,empcode,fromdate,todate,description,lccode) "
                        + "VALUES (?,?,?,?,?,?) ";
                ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.valueOf((String) employee.get("slno")));
                ps.setInt(2, Integer.valueOf((String) employee.get("empcode")));
                ps.setDate(3, Date.valueOf((String) employee.get("fromdate")));
                ps.setDate(4, Date.valueOf((String) employee.get("todate")));
                ps.setString(5, (String) employee.get("description"));
                ps.setShort(6, Short.valueOf((String) employee.get("leavecatagories")));
                 
                res = ps.executeUpdate() > 0;

            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoApplication.saveEmployeeEducation(final JSONObject employeedetails) : " + e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error in DaoApplication.saveEmployeeEducation(final JSONObject employeedetails) : " + e);
            }
        }
        return res;
    }
 
    public boolean apprej(final String slno,final String status) {
        boolean res = false;
        try {
            System.out.println("");
            con = DbConnection.getConnection();
            if (con != null) {
                
                sql = "UPDATE fostai.t_leaves SET appstatus=? WHERE slno=? ";
                ps = con.prepareStatement(sql);                
                ps.setString(1,status);
                ps.setInt(2,Integer.valueOf(slno));                                 
                res = ps.executeUpdate() > 0;
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoApplication.apprej(final String slno,final String status) : " + e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error in DaoApplication.apprej(final String slno,final String status) : " + e);
            }
        }
        return res;
    }
   
    public boolean salaryProcess(final JSONObject salary) {
        boolean res = false;
        try {
            con = DbConnection.getConnection();
            if (con != null) {
                
                sql = "INSERT INTO fostai.t_salary(slno,empcode,basic,ta,da ,hra,foryear,formonth) "
                        + "VALUES (?,?,?,?,?,?,?,?) ";
                ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.valueOf((String) salary.get("slno")));
                ps.setInt(2, Integer.valueOf((String) salary.get("empcode")));
                ps.setDouble(3, Double.valueOf((String) salary.get("basic")));
                ps.setDouble(4, Double.valueOf((String) salary.get("ta")));
                ps.setDouble(5, Double.valueOf((String) salary.get("da")));
                ps.setDouble(6, Double.valueOf((String) salary.get("hra")));
                ps.setShort(7, Short.valueOf((String) salary.get("foryear")));
                ps.setShort(8, Short.valueOf((String) salary.get("formonth")));
                 
                res = ps.executeUpdate() > 0;

            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error in DaoApplication.saveEmployeeEducation(final JSONObject employeedetails) : " + e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error in DaoApplication.saveEmployeeEducation(final JSONObject employeedetails) : " + e);
            }
        }
        return res;
    }
}
