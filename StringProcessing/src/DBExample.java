
import java.sql.*;
import java.io.*;


/**
 * Created by nazmul on 12/17/14.
 */
public class DBExample {

    public static void main(String[] args) throws SQLException {
            // Get connection, execute query , get the result set
            Connection connection = DBconnect.connectToDb();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(" SELECT * FROM contact");

            System.out.println("ID \t fName \t lName \t email \t phoneNo");

            while(resultSet.next()){
                System.out.println(resultSet.getInt("id") + "\t"
                + resultSet.getString("firstName") + "\t"
                + resultSet.getString("lastName") + "\t"
                + resultSet.getString("email") +"\t"
                + resultSet.getString("phoneNo"));


        }

    }
}
