package Task_11A;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentDetailsServlet")
public class StudentDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String jdbcURL = "jdbc:postgresql://localhost:5432/Student";
    private static final String jdbcUsername = "postgres";
    private static final String jdbcPassword = "Sidsaanu@1";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String program = request.getParameter("program");

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {
            String insertSQL = "INSERT INTO Registration (name, address, program) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, program);
            preparedStatement.executeUpdate();

            response.getWriter().println("Student record inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery("SELECT * FROM Registration");
            while (rs.next()) {
                out.println("ID: " + rs.getInt("id") + ", ");
                out.println("Name: " + rs.getString("name") + ", ");
                out.println("Address: " + rs.getString("address") + ", ");
                out.println("Program: " + rs.getString("program") + "<br>");
            }
            
            String updateSQL = "UPDATE Registration SET program='UpdatedProgram' WHERE id IN (100, 101)";
            statement.executeUpdate(updateSQL);
            out.println("Records updated for IDs 100 and 101.<br>");
            
            String deleteSQL = "DELETE FROM Registration WHERE id = 101";
            statement.executeUpdate(deleteSQL);
            out.println("Record with ID 101 deleted.<br>");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("</body></html>");
    }
}
