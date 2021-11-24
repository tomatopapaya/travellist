import java.io.*;
import java.sql.*;
import java.awt.*;
//輸入地區便可查詢當地的景點  並隨機挑選一個今日要去的景點
public class MySQL_GetRow_Statement_OK_travellist
{
    public static void main(String[] args)throws IOException
    {
        
        //建立可輸入的語法
        String go;
        BufferedReader keyin = new BufferedReader(
                                         new InputStreamReader(System.in));
        System.out.println("1台北 2新北 3基隆 4桃園 5新竹 6雲林 7苗栗 8彰化 9台中\n10南投 11嘉義 12台南 13高雄 14屏東 15台東 16花蓮 17宜蘭");
        System.out.println("\n");
        System.out.print("請輸入想去的地點:"); 
        go = keyin.readLine();
        System.out.println("\n");
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //驅動程式參數
       
        String sDriver  = "com.mysql.jdbc.Driver";
        String user     = "root";
        String password = "1234";
        String url      = "jdbc:mysql://localhost/mydb2";
        String sql; 
        
        try {  
            
            Class.forName(sDriver);
        }
        catch(Exception e){
        
            System.out.println("無法載入驅動程式");
            return;
        }
        
        try {  
       
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
        }
        catch(SQLException e){
       
            System.out.println("與資料來源連結錯誤: ");
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
            System.out.println("景點選項:");
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
            System.out.println("這次選到的是:");
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

