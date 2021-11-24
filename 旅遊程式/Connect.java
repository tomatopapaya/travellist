
import java.sql.*;

public class Connect
{
    public static void main(String[] args)
    {
        Connection conn = null;
        Statement stmt = null;
        //參數
        String sDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String sCon = "jdbc:odbc:nana";
      
        try   //載入JDBC driver 
        {     
            Class.forName(sDriver);
        }
        catch(Exception e)
        {
            System.out.println("無法載入驅動程式");
            return;
        }
       
        try   //建立資料連結和Statement物件
        {
            conn = DriverManager.getConnection(sCon);
            if(conn != null)
            {
                System.out.println("建立Connection物件成功!");
                stmt = conn.createStatement();
                if(stmt != null)
                    System.out.println("建立Statement物件成功!");
            }
            else
            {
                System.out.println("Connection物件未建立成功!");
                return; 
            }          
        }
        catch(SQLException e)
        {
            System.out.println("與資料來源連結錯誤: " + sCon);
            System.out.println(e.getMessage());
            return;
        }
       
        try 
        { 
            stmt.close(); 
            conn.close(); 
        }
        catch( SQLException e ) {}
    }
}