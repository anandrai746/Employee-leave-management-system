
import isstslibs.*;
import java.sql.Connection;


public class Test {
    
    public static void main(String arg[]) 
    {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            System.out.println("con : " + ((con != null) ? "ok" : "Not conneced"));
            System.out.println("NumberToWords : "+NumberToWords.number2words("123.10"));
            con.close();
            System.out.println("SHA256 : "+SHA256.getHash("admin@123"));
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        }
    }
    
}
