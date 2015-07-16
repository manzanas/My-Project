import java.sql.*;


public class Conexion{
    
    
    String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/Water_erp";
    private String user = "root";
    private String pwd = "";
    
    
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
