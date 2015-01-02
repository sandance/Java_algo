import java.sql.*;
import java.io.*;
import java.util.*;



/**
 * Created by nazmul on 12/17/14.
 */
public class DBconnect {

    public static Connection connectToDb() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        // we are connecting to our addressbook  database we created earlier
        String database = "addressbook";
        // we login as root with password
        String userName = "root";
        String passWord = "sandance";

        return DriverManager.getConnection(url + database, userName, passWord);
    }
}
