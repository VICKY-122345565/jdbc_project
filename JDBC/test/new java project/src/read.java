import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class read {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/movie_simulator";
        String user = "root";
        String pass = "Kanha@123";
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection(url, user, pass);
        //  String readSql = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement("SELECT * FROM movie_watch_list");
            ResultSet rs = ps.executeQuery();

            // System.out.println("\ns.no.| movie | genre | ratings | status");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("S_No") + " | " +
                        rs.getString("Movie") + " | " +
                        rs.getString("Genre")+" " +
                        rs.getInt("Rating")+" | " +
                        rs.getString("Status")
                );
            }
    }catch (Exception e) {
            e.printStackTrace();
        }
    
}
}