import java.io.*;
import java.sql.*;
import java.awt.*;
//��J�a�ϫK�i�d�߷�a�����I  ���H���D��@�Ӥ���n�h�����I
public class MySQL_GetRow_Statement_OK_travellist
{
    public static void main(String[] args)throws IOException
    {
        
        //�إߥi��J���y�k
        String go;
        BufferedReader keyin = new BufferedReader(
                                         new InputStreamReader(System.in));
        System.out.println("1�x�_ 2�s�_ 3�� 4��� 5�s�� 6���L 7�]�� 8���� 9�x��\n10�n�� 11�Ÿq 12�x�n 13���� 14�̪F 15�x�F 16�Ὤ 17�y��");
        System.out.println("\n");
        System.out.print("�п�J�Q�h���a�I:"); 
        go = keyin.readLine();
        System.out.println("\n");
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //�X�ʵ{���Ѽ�
       
        String sDriver  = "com.mysql.jdbc.Driver";
        String user     = "root";
        String password = "1234";
        String url      = "jdbc:mysql://localhost/mydb2";
        String sql; 
        
        try {  
            
            Class.forName(sDriver);
        }
        catch(Exception e){
        
            System.out.println("�L�k���J�X�ʵ{��");
            return;
        }
        
        try {  
       
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
        }
        catch(SQLException e){
       
            System.out.println("�P��ƨӷ��s�����~: ");
            System.out.println(e.getMessage());
            if (conn != null)
            {
                try { conn.close(); }
                catch( SQLException e2 ) {}
            }
            return;
        }
        
        
        sql="SELECT * FROM travellist where city="+"'"+go+"'";
        try {
            System.out.println("���I�ﶵ:");
            rs = stmt.executeQuery(sql);
            System.out.println("\n");
            System.out.println("Num     City    Location       Address");
            System.out.println("================================================"+
                              "==========================");                    
            while(rs.next())
            {
                System.out.print(rs.getString("Num"));
                System.out.print("\t");
                System.out.print(rs.getString("City"));
                System.out.print("\t");
                System.out.print(rs.getString("Location"));
                System.out.print("\t");
                System.out.println(rs.getString("Address"));
                             
                
            }
        }
        catch(SQLException e){}
        sql="SELECT * FROM travellist where city="+"'"+go+"'"+"order by rand() limit 1";
        
        try {
        
            rs = stmt.executeQuery(sql);
            System.out.println("\n");
            System.out.println("�o����쪺�O:");
            System.out.println("\n");
            System.out.println("Num     City    Location       Address");
            System.out.println("================================================"+
                              "==========================");                    
            while(rs.next())
            {
                System.out.print(rs.getString("Num"));
                System.out.print("\t");
                System.out.print(rs.getString("City"));
                System.out.print("\t");
                System.out.print(rs.getString("Location"));
                System.out.print("\t");
                System.out.println(rs.getString("Address"));
                             
                
            }
        }
        catch(SQLException e){}
       
        try {
        
            stmt.close(); 
            conn.close(); 
        }
        catch( SQLException e ) {}
    }
}

