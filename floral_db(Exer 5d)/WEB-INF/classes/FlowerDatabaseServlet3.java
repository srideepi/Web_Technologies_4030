import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FlowerDatabaseServlet3 extends HttpServlet {
   public FlowerDatabaseServlet3() {
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      Connection connection = null;
      Statement statement = null;
      PrintWriter out = response.getWriter();

      try {
         Class.forName("com.mysql.jdbc.Driver");
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/garden", "root", "");
         statement = connection.createStatement();
         PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO flowers VALUES(?, ?, ?)");
         preparedStatement.setString(1, request.getParameter("flowerid"));
         preparedStatement.setString(2, request.getParameter("flowername"));
         preparedStatement.setInt(3, Integer.valueOf(request.getParameter("petalcount")));
         preparedStatement.executeUpdate();
         out.println("<html><body><p>Database Updated</p>");
         String query = "SELECT * FROM flowers";
         preparedStatement = connection.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery();

         while(resultSet.next()) {
            String flowerID = resultSet.getString("FlowerID");
            String flowerName = resultSet.getString("FlowerName");
            int petalCount = resultSet.getInt("PetalCount");
            out.println("<p>Flower ID: " + flowerID + "<br>");
            out.println("Flower Name: " + flowerName + "<br>");
            out.println("Petal Count: " + petalCount + "<br></p>");
         }

         out.println("</body></html>");
         resultSet.close();
         statement.close();
         connection.close();
      } catch (Exception e) {
         System.out.print("Do not connect to DB - Error:" + e.toString());
      }
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      Connection connection = null;
      Statement statement = null;
      PrintWriter out = response.getWriter();

      try {
         Class.forName("com.mysql.jdbc.Driver");
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/garden", "root", "");
         statement = connection.createStatement();
         String query = "SELECT * FROM flowers";
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery();

         out.println("<html><body><h2>Existing Flowers</h2>");

         while(resultSet.next()) {
            String flowerID = resultSet.getString("FlowerID");
            String flowerName = resultSet.getString("FlowerName");
            int petalCount = resultSet.getInt("PetalCount");
            out.println("<p>Flower ID: " + flowerID + "<br>");
            out.println("Flower Name: " + flowerName + "<br>");
            out.println("Petal Count: " + petalCount + "<br></p>");
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
