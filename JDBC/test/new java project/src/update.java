import java.sql.*;
import java.util.Scanner;

public class update {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/movie_simulator";
        String user = "root";
        String pass = "Kanha@123";

        String sql = "UPDATE movie_watch_list SET Status = ? WHERE Movie = ?";

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter movie name: ");
            String movie = sc.next();

            System.out.print("Enter new status: ");
            String status = sc.next();

            ps.setString(1, status);
            ps.setString(2, movie);

            ps.executeUpdate();
            System.out.println("Update done");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}