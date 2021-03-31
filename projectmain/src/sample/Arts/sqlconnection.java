package sample.Arts;
import java.sql.*;
public class sqlconnection {
    public Connection con;
    public Connection  getcon() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aands","root","");
        return con;
    }
}
