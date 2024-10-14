package fr.but3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.YearMonth;

@WebServlet("/calendar")
public class CalendarServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String monthParam = request.getParameter("month");
        String yearParam = request.getParameter("year");

        LocalDate currentDate = LocalDate.now();
        int month = monthParam != null ? Integer.parseInt(monthParam) : currentDate.getMonthValue();
        month = Math.max(1, Math.min(12, month));
        int year = yearParam != null ? Integer.parseInt(yearParam) : currentDate.getYear();


        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connexion Effective !");

            String dayToIncrement = request.getParameter("day");
            if (dayToIncrement != null) {
                String query = "UPDATE public.calendar SET value = value + 1 WHERE dat = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, year + "-" + month + "-" + dayToIncrement);
                preparedStatement.executeUpdate();
            }

            String query = "SELECT * FROM public.calendar WHERE dat LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, year + "-" + month + "-%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("dat") + " " + resultSet.getInt("value"));
                request.setAttribute(resultSet.getString("dat"), resultSet.getInt("value"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connexion Impossible");
        }

        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate firstDayOfMonth = yearMonth.atDay(1);
        int daysInMonth = yearMonth.lengthOfMonth();

        request.setAttribute("year", year);
        request.setAttribute("month", month);
        request.setAttribute("firstDayOfMonth", firstDayOfMonth);
        request.setAttribute("daysInMonth", daysInMonth);

        request.getRequestDispatcher("/calendar.jsp").forward(request, response);
    }
}