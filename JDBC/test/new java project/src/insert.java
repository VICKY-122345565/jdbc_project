import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class insert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/movie_simulator";
        String user = "root";
        String pass = "Kanha@123";
        String sql = "INSERT INTO movie_watch_list (S_No, Movie, Genre, Rating, Status) VALUES (?, ?, ?, ?, ?)";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many records you want to enter: ");
        int n = sc.nextInt();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement(sql);
            for (int i = 1; i <= n; i++) {
            System.out.print("Enter Serial Number: ");
            int sno = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Movie Name: ");
            String mname = sc.nextLine();

            System.out.print("Enter Genre: ");
            String gen = sc.nextLine();

            System.out.print("Enter Rating: ");
            float rat = sc.nextFloat();
            sc.nextLine(); 

            System.out.print("Enter Status: ");
            String sts = sc.nextLine();
                ps.setInt(1, sno);
                ps.setString(2, mname);
                ps.setString(3, gen);
                ps.setFloat(4, rat);
                ps.setString(5, sts);
                ps.executeUpdate();
                System.out.println("Movie inserted successfully ");
            }
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
