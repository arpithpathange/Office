import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: arpith
 * Date: 26/1/13
 * Time: 1:02 PM
 * To change this template use File | Settings | File Templates.
 */


public class DBConnection {
    private DBConnection(){};
    private static boolean driverLoad = false;
    private static final String pgDriver="org.postgresql.Driver";
    private static final String pgUrl="jdbc:postgresql:postgres";
    private static final String usr="postgres";
    private static final String psw="password";
    private static  Statement stmt = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(!driverLoad) {
            Class.forName(pgDriver);
            driverLoad=true;
        }
        return DriverManager.getConnection(pgUrl, usr, psw);
    }

    public static void main(String s[]){
        try{
              String query = " select * from persons";
            stmt = DBConnection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getInt("P_id"));
                System.out.println(rs.getString("lastname"));
                System.out.println(rs.getString("firstname"));
                System.out.println(rs.getString("address"));
                System.out.println(rs.getString("city"));
            }
        }catch(Exception e )
        {
            System.out.println("asdasdasd "+e);
        }

    }
}
