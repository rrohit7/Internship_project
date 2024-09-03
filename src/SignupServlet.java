import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String username = request.getParameter("newuser");
        String password = request.getParameter("newpass");

        String jdbcURL = "jdbc:mysql://localhost:3306/website";
        String dbUser = "root";
        String dbPassword = "stars";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            String sql = "INSERT INTO user_data VALUES(firstname varchar(20), lastname vachar(20), email varchar(20), dob date, gender varchar(10), phone int, username varchar(20), password varchar(20))";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, email);
            statement.setString(4, dob);
            statement.setString(5, gender);
            statement.setString(6, phone);
            statement.setString(7, username);
            statement.setString(8, password);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A new user has been inserted successfully.");
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("success.html");
    }
}
