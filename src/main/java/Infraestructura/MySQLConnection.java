package Infraestructura;

import java.sql.*;
import java.util.Map;

public class MySQLConnection {
    public static final Map<String,String> env = System.getenv();
    public static final String DATABASE = env.get("DB");
    public static final String USER = env.get("USUARIO_DB");
    public  static final String PASSWORD = env.get("PASSWORD_DB");

    public static Connection conectar(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost/" + MySQLConnection.DATABASE,
                            MySQLConnection.USER, MySQLConnection.PASSWORD);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}
