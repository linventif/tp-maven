<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calendar</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="container">
    <h2 class="text-center my-4">Calendar for <%= request.getAttribute("month") %>/<%= request.getAttribute("year") %>
    </h2>
    <table class="table table-bordered">
        <thead class="thead-light">
        <tr>
            <th>Mon</th>
            <th>Tue</th>
            <th>Wed</th>
            <th>Thu</th>
            <th>Fri</th>
            <th>Sat</th>
            <th>Sun</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <%
                LocalDate firstDayOfMonth = (LocalDate) request.getAttribute("firstDayOfMonth");
                int daysInMonth = (int) request.getAttribute("daysInMonth");
                int dayOfWeekValue = firstDayOfMonth.getDayOfWeek().getValue();
                int year = (int) request.getAttribute("year");
                int month = (int) request.getAttribute("month");
                for (int i = 1; i < dayOfWeekValue; i++) {
                    out.print("<td></td>");
                }
                for (int day = 1; day <= daysInMonth; day++) {
                    if ((day + dayOfWeekValue - 2) % 7 == 0) {
                        out.print("</tr><tr>");
                    }
                    out.print("<td class='current-month'><form action='calendar' method='get'>" +
                            "<input type='hidden' name='day' value='" + day + "'>" +
                            "<input type='hidden' name='month' value='" + request.getAttribute("month") + "'>" +
                            "<input type='hidden' name='year' value='" + request.getAttribute("year") + "'>" +
                            "<button type='submit' class='btn btn-link'>" + day + " / " + (request.getAttribute(year +
                            "-" + month + "-" + day) == null ? "0" : request.getAttribute(year + "-" + month + "-" + day)) +
                            "</button></form></td>");

                }
            %>
        </tr>
    </table>
    <div>
        <form action="calendar" method="get">
            <input type="hidden" name="month"
                   value="<%= (int) request.getAttribute("month") == 1 ? 12 : (int) request.getAttribute("month") - 1 %>">
            <input type="hidden" name="year"
                   value="<%= (int) request.getAttribute("month") == 1 ? (int) request.getAttribute("year") - 1 : (int) request.getAttribute("year") %>">
            <button type="submit" class="btn btn-primary">Précédent</button>
        </form>
        <form action="calendar" method="get">
            <input type="hidden" name="month"
                   value="<%= (int) request.getAttribute("month") == 12 ? 1 : (int) request.getAttribute("month") + 1 %>">
            <input type="hidden" name="year"
                   value="<%= (int) request.getAttribute("month") == 12 ? (int) request.getAttribute("year") + 1 : (int) request.getAttribute("year") %>">
            <button type="submit" class="btn btn-primary">Suivant</button>
        </form>
    </div>
</div>
</body>
</html>