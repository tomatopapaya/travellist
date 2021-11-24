
import java.sql.*;

public class Connect
{
    public static void main(String[] args)
    {
        Connection conn = null;
        Statement stmt = null;
        //�Ѽ�
        String sDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String sCon = "jdbc:odbc:nana";
      
        try   //���JJDBC driver 
        {     
            Class.forName(sDriver);
        }
        catch(Exception e)
        {
            System.out.println("�L�k���J�X�ʵ{��");
            return;
        }
       
        try   //�إ߸�Ƴs���MStatement����
        {
            conn = DriverManager.getConnection(sCon);
            if(conn != null)
            {
                System.out.println("�إ�Connection���󦨥\!");
                stmt = conn.createStatement();
                if(stmt != null)
                    System.out.println("�إ�Statement���󦨥\!");
            }
            else
            {
                System.out.println("Connection���󥼫إߦ��\!");
                return; 
            }          
        }
        catch(SQLException e)
        {
            System.out.println("�P��ƨӷ��s�����~: " + sCon);
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