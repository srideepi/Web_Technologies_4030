import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FlowerDatabaseServlet extends HttpServlet {
   public FlowerDatabaseServlet() {
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      Connection connection = null;
      Statement statement = null;
      PrintWriter out = response.getWriter();

      try {
         Class.forName("com.mysql.jdbc.Driver");
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/garden", "root", "");
         if (connection != null) {
            out.println("<h1> No issues in Connection</h1>");
         }

         statement = connection.createStatement();
         String query = "SELECT * FROM gardeners";
         ResultSet resultSet = statement.executeQuery(query);

         while(resultSet.next()) {
            String gardenerID = resultSet.getString("GardenerID");
            String name = resultSet.getString("Name");
            String flowerID = resultSet.getString("FlowerID");
            Double experience = resultSet.getDouble("Experience");
            String awarded = resultSet.getString("Awarded");
            out.println("<p> Gardener ID: " + gardenerID + "<br>");
            out.println("Name: " + name + "<br>");
            out.println("Flower ID: " + flowerID + "<br>");
            out.println("Experience: " + experience + "<br>");
            out.println("Awarded: " + awarded + "<br></p>");
         }

         out.println("</body></html>");
         resultSet.close();
         statement.close();
         connection.close();
      } catch (Exception e) {
         System.out.print("Do not connect to DB - Error:" + e.toString());
      }
   }
}
