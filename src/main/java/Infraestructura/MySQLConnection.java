package Infraestructura;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.Map;

public class MySQLConnection {
    public static final Dotenv dotenv = Dotenv.load();
    public static final String DATABASE = dotenv.get("DB");
    public static final String USER = dotenv.get("USUARIO_DB");
    public  static final String PASSWORD = dotenv.get("PASSWORD_DB");

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
