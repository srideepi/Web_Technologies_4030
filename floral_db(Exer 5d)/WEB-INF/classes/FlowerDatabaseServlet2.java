import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FlowerDatabaseServlet2 extends HttpServlet {
    
    public FlowerDatabaseServlet2() {
    }

    // This method handles GET requests to retrieve gardener data for a given flower
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String flowerName = request.getParameter("flower");  // Getting flower name from the request

        if (flowerName == null || flowerName.isEmpty()) {
            out.println("<p>Error: Flower name is required</p>");
            return;
        }

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/garden", "root", "");

            // SQL query to fetch gardeners who are associated with the given flower name
            String query = "SELECT * FROM flowers WHERE FlowerName = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, flowerName);  // Set the flower name in the query

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if any gardeners are found
            if (!resultSet.next()) {
                out.println("<p>No gardeners found for the flower: " + flowerName + "</p>");
            } else {
                out.println("<html><body>");
                out.println("<h2>Gardener Details for Flower: " + flowerName + "</h2>");

                // Iterate over the results and display gardener details
                do {
                    String FlowerID = resultSet.getString("FlowerID");
                    String FlowerName = resultSet.getString("FlowerName");
                    String PetalCount = resultSet.getString("PetalCount");
                   

                    out.println("<p>Flower ID: " + FlowerID + "<br>");
                    out.println("Flower Name: " + FlowerName + "<br>");
                    out.println("Petalcount: " + PetalCount + "<br></p>");
                    
                } while (resultSet.next());

                out.println("</body></html>");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            out.println("<p>Error connecting to the database: " + e.getMessage() + "</p>");
            e.printStackTrace();
        }
    }
}
