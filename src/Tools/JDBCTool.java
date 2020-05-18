package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTool {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/stuman?serverTimezone=GMT%2B8";
    static final String USER = "root";
    static final String PWD = "123";
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getDBConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PWD);
    }

    public static void main(String[] args) throws Exception{
        try (Connection c = getDBConnection(); Statement st = c.createStatement()) {
            System.out.println(c);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

