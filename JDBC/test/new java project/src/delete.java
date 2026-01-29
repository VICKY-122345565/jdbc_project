import java.sql.*;
import java.util.Scanner;

public class delete {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/movie_simulator";
        String user = "root";
        String pass = "Kanha@123";

        String sql = "DELETE FROM movie_watch_list WHERE Status = 'Watched'";

        Scanner sc = new Scanner(System.in);
        System.out.println("Note the watched movie will be deleted permanently\n Are u sure u want to proceed click 'y' to proceed");
        String c=sc.next();
        if (c.equals("y")) {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement(sql);

           

            ps.executeUpdate();
            System.out.println("Deleted");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    }
}