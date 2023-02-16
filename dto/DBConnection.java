package student_management.dto;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private Connection conn;

    public Connection getConnection(){
        if(this.conn==null){

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_practice", "root", "");
                return this.conn;
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
            return conn;

    }
}
