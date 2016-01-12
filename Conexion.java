import java.sql.*;


public class Conexion{
    
    
    String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/myDataBase";
    private String user = "root";
    private String pwd = "root";
    
    
    public Connection getConnection(){
		
		Connection cn= null;
		
		try {
			Class.forName(driver);
			cn = DriverManager.getConnection(url,user,pwd);
		}
		
		catch(SQLException e){
			System.out.println(e.toString());
			cn= null;
		}
		catch(Exception e) {
			System.out.println(e.toString());
			cn= null;
		}
		return cn;
    }
}
