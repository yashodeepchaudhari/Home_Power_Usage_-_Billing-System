package electricity.system;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    Connection connection;
    Statement statement;
    database(){
        try {
           
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bill_system","root","YashMysql@24");
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

//jdbc:mysql://localhost:3306/?user=root